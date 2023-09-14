---
title: "Point of Sale to ePayment"
sidebar_label: Point of Sale to ePayment
sidebar_position: 37
pagination_next: null
pagination_prev: null
---

import MT from './_mt.md'

# Migrating Point of Sale to new common platform
Read more about the [transition to one platform](https://developer.mobilepay.dk/docs/pos/transition-to-one-platform).

Below you can find comparison between the existing MobilePay PoS API and the new [ePayment API](/docs/APIs/epayment-api) replacing MobilePay PoS.

## Different solutions for different setups
Depending on the merchant setup there can be multiple ways to implement the payment flow. This section tries to sketch an overview of what is possible, and what might be the best approach depending on the merchant setup today.

No matter what, it is required to implement the new ePayments API for doing payments. The main differences between the different approaches is the differences in how to pair the customer that wants to pay, with the given checkout that wants to issue the payment.

The next sections will contain the recommended approaches based on what capabilities the merchant has available at their checkouts.

<b>Note: The developer documentation in Vipps MobilePay describes using webhooks instead of polling for payment statuses in the ePayments API. Polling however, is still possible and a valid way to follow the payment status just as it is today in MobilePay PoS. However it will not be possible to detect user checkins using polling.</b>

### Checkout has QR scanning capabilities
This is our recommended flow. If the merchant has the possibility to scan a QR code at their checkouts, they can use the 'Merchant Scan' approach. Before the payment is initiated the merchant scans a QR on the customer phone which will contain the customer info needed to initiate the payment. The payment is then initiated with the ``userFlow`` parameter set to "PUSH_MESSAGE" together with the ``personalQr`` parameter set to the full content of the QR scanned. This solution removes the need for merchant QR codes as MobilePay PoS solutions uses today. More information on this payment flow can be found [here](https://developer.vippsmobilepay.com/docs/solutions/in-store/). 

### Checkout has customer facing screens
In this scenario there is one solution simpler than all others. Here the merchant does not need the customer info before they initiate the payment. They simple initiate the payment where the ``userFlow`` parameter is set to "QR". Then the response will contain a link to a dynamic QR code, which the checkout then downloads and shows on their customer facing screen. The user scans the QR and completes the payment flow. This flow is described in more detail [here](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/features/qr-payments/) where it also is shown how to specify the image format and size of the QR being created.

### Checkout neither has QR scanners nor customer facing screens
In these scenarios the PoS merchants will have to use static QR codes as stickers as they do today. These QRs can work in two different ways. 

The first option is where the QR code contains a link to a merchant website where the merchant will then ask for the customer info needed. This QR is referred to as a MerchantRedirect QR and you can read more about it by pressing [here](https://developer.vippsmobilepay.com/docs/solutions/vending-machines/qr-to-merchant-site-payment-only/).

The second option is called MerchantCallback QRs and it resembles the way of using QRs in MobilePay PoS solutions today. When the QR is scanned by a customer, Vipps MobilePay will send a callback to an endpoint that is hosted by the merchant. The callback will contain a ``customerToken`` that is used to initiate the payment towards the customer. This is identical to the notification service solution offered for vending machines and similar unmanned checkouts in MobilePay PoS today.
Polling for user checkins will not be an option as in MobilePay PoS today, and hence it is required to support callbacks.
You can find the documentation for this solution [here](https://developer.vippsmobilepay.com/docs/solutions/static-qr-at-pos/)

<b>Note: It will be possible to migrate all the existing QRs to the new solution such that the merchants do not have to replace the QRs they already have. </b>

#### Migration guide to Merchant Callback QRs
To make the transition from MobilePay PoS to the new ePayments API with MerchantCallback QRs the merchant has to do the following:
* Host an API with an endpoint that Vipps MobilePay can send callbacks to.
* Migrate existing QRs. There exists an endpoint specifically for migrating MobilePay QRs. This endpoint will take the beaconId and posName of the current QR, and register it as a MerchantCallback QR. This will make the old QRs work after the switch to the common platform. The endpoint can be found [here](https://developer.vippsmobilepay.com/api/qr/#tag/Merchant-callback-QR/operation/PutMerchantCallbackMobilePayQr)
* Subscribe to the ``user.checkin.v1`` event for all merchant-serial-numbers (stores). This will trigger Vipps MobilePay to send these events whenever a customer has scanned one of your QRs. The callback contains the ``merchant-serial-number`` as well as the ``merchantQrId`` (equal to the beaconId in MobilePay PoS). This information will distill down to what checkout the customer has checked in to. See documentation on how to implement webhooks [here](https://developer.vippsmobilepay.com/docs/APIs/webhooks-api/)
* Implement the integration to the new ePayments API that must be used to initiate and handle the payment flow. The next sections of this page will help sketch out the differences from the current MobilePay PoS API and the ePayments API.

## PoS and ePayment endpoints

| Operation                 | MobilePay PoS                            | ePayment                                    |
|---------------------------|------------------------------------------|---------------------------------------------|
| PoS management            | `POST/GET/DELETE /v10/pointofsales`      | N/A                                         |
| Initiate Payment          | `POST:/v10/payments`                     | [`POST:/epayments/v1/payments`](https://developer.vippsmobilepay.com/api/epayment#tag/CreatePayment/operation/createPayment)                         |
| Initiate Prepared payment | `POST:/v10/payments/prepare`             | N/A (For loyalty, see [Loyalty at POS](https://developer.vippsmobilepay.com/docs/solutions/loyalty-in-pos))     |
| Query Payment             | `GET:/v10/payments/{paymentid}`          | [`GET:/epayments/v1/payments/{reference}`](https://developer.vippsmobilepay.com/api/epayment#tag/QueryPayments/operation/getPayment)              |
| Query Active Payments     | `GET /v10/payments`                      | N/A                                         |
| Query payment log         | N/A                                      | [`GET:/epayments/v1/payments/{reference}/events`](https://developer.vippsmobilepay.com/api/epayment#tag/QueryPayments/operation/getPaymentEventLog)       |
| Capture Payment           | `POST:/v10/payments/{paymentid}/capture` | [`POST:/epayments/v1/payments/{reference}/capture`](https://developer.vippsmobilepay.com/api/epayment#tag/AdjustPayments/operation/capturePayment)     |
| Cancel Payment            | `POST:/v10/payments/{paymentid}/cancel`  | [`POST:/epayments/v1/payments/{reference}/cancel`](https://developer.vippsmobilepay.com/api/epayment#tag/AdjustPayments/operation/cancelPayment)      |
| Refund Payment            | `POST:/v10/refunds`                       | [`POST:/epayments/v1/payments/{reference}/refund`](https://developer.vippsmobilepay.com/api/epayment#tag/AdjustPayments/operation/refundPayment)      |
| Lookup a refund           | `GET:/v10/refunds/{refundid}`            | [`GET:/epayments/v1/payments/{reference}`](https://developer.vippsmobilepay.com/api/epayment#tag/QueryPayments/operation/getPayment)              |

## Authentication and headers

See:

* [Access token API](https://developer.vippsmobilepay.com/docs/APIs/access-token-api/)

| MobilePay PoS                           | ePayment                                        |
|-----------------------------------------|-------------------------------------------------|
| `Authorization` (`POST:/connect/token`) | `Authorization` ([`POST:/accesstoken/get`](https://developer.vippsmobilepay.com/api/access-token#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost))       |
| `X-MobilePay-Client-System-Version`     | `Vipps-System-Version` (see [HTTP headers](https://developer.vippsmobilepay.com/docs/common-topics/http-headers/))                          |
| N/A                                     | `Vipps-System-Name` (see [HTTP headers](https://developer.vippsmobilepay.com/docs/common-topics/http-headers/))                             |
| N/A                                     | `Vipps-System-Plugin-Name` (see [HTTP headers](https://developer.vippsmobilepay.com/docs/common-topics/http-headers/))       |
| N/A                                     | `Vipps-System-Plugin-Version` (see [HTTP headers](https://developer.vippsmobilepay.com/docs/common-topics/http-headers/))    |
| `X-MobilePay-Merchant-VAT-Number`       | N/A                                             |
| `X-MobilePay-Idempotency-Key`           | `Idempotency-Key` (see [Idempotency](https://developer.vippsmobilepay.com/docs/common-topics/http-headers/#idempotency))                               |
| N/A                                     | `Ocp-Apim-Subscription-Key`                     |
| N/A                                     | `Merchant-Serial-Number`                        |

## Initiate Payment

See:

* [Create](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/create/)

| MobilePay PoS                                                  | ePayment                                       |
|----------------------------------------------------------------|------------------------------------------------|
| `amount`                                                       | `amount` (`currency`, `value`)                 |
| `currencyCode`                                                 | *Applied in `amount`*                          |
| `orderId`                                                      | [`paymentDescription​`](https://developer.vippsmobilepay.com/docs/common-topics/transactiontext/)                            |
| `plannedCaptureDelay`                                          | N/A                                            |
| `posId`                                                        | N/A                                            |
| `restrictions` (`debitCardDisallowed`, `creditCardDisallowed`) | N/A                                            |
| `merchantPaymentLabel`                                         | N/A                                            |
| N/A                                                            | `customer` (`phoneNumber`)                     |
| N/A                                                            | `customerInteraction` (`"CUSTOMER_PRESENT"`)   |
| N/A                                                            | `paymentMethod` (`type` `"WALLET"`)            |
| N/A                                                            | [`reference`](https://developer.vippsmobilepay.com/docs/common-topics/orderid)                                    |
| N/A                                                            | `userFlow` (`"PUSH_MESSAGE"` `"QR"`)           |
| N/A                                                            | `qrFormat` (`format`, `size`)                  |
|                                                                |                                                |
| **Response**                                                   |                                                |
| `paymentId`                                                    | [`reference`](https://developer.vippsmobilepay.com/docs/common-topics/orderid) (set in paymentInitiation)         |

## Query Payment

See:

* [Get payment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/get_info/)
* [Get payment event log](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/get_event_log/)

| MobilePay PoS   | ePayment                                                                                |
|-----------------|-----------------------------------------------------------------------------------------|
| `paymentId`     | [`reference`](https://developer.vippsmobilepay.com/docs/common-topics/orderid)                                                                             |
|                 |                                                                                         |
| **Response**    |                                                                                         |
| `orderId`       | [`reference`](https://developer.vippsmobilepay.com/docs/common-topics/orderid)                                                                             |
| `amount`        | `amount` (`currency`, `value`)                                                          |
| `currencyCode`  | *Applied in `amount`*                                                                   |
| `status`        | `state`                                                                                  |
| N/A             | `aggregate` (`authorizedAmount`, `cancelledAmount`, `capturedAmount`, `refundedAmount`) |
| N/A             | `paymentMethod` (`type`)                                                                |
| `loyaltyIds`    | `profile` (`sub`) (see [What is the `sub`?](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api/userinfo-api-faq/#what-is-the-sub))                                                                      |
| N/A             | `pspReference`                                                                          |

*N/A: `posId`, `restrictions` (`debitCardDisallowed`, `creditCardDisallowed`), `merchantPaymentLabel`, `plannedCaptureDelay`, `customerToken`, `customerReceiptToken`, `paymentExpiresAt`, `partialCapturePossible`, `pollDelayInMs`*

## Capture, Cancel and Refund Payment

See:

* [Capture](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/capture/)
* [Cancel](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/cancel/)
* [Refund](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/refund/)

| MobilePay PoS                           | ePayment                                                                                |
|-----------------------------------------|-----------------------------------------------------------------------------------------|
| `paymentId`                             | [`reference`](https://developer.vippsmobilepay.com/docs/common-topics/orderid)                                                                             |
| `amount`                                | `modificationAmount` (`currency`, `value`) *not applicable for cancel*                  |
|                                         |                                                                                         |
| **Response**                            |                                                                                         |
| N/A                                     | `amount` (`currency`, `value`)                                                          |
| N/A                                     | `state`                                                                                 |
| N/A                                     | `aggregate` (`authorizedAmount`, `cancelledAmount`, `capturedAmount`, `refundedAmount`) |
| `refundId` *only applicable for refund* | `pspReference`                                                                          |
| N/A                                     | [`reference`](https://developer.vippsmobilepay.com/docs/common-topics/orderid)                                                                             |

## Test environment

<MT />
