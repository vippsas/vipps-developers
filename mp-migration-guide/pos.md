---
title: "Point of Sale to ePayment"
sidebar_label: Point of Sale to ePayment
sidebar_position: 37
pagination_next: null
pagination_prev: null
---

import MT from './_mt.md'

# Point of Sale to ePayment

Read more about the [transition to one platform](https://developer.mobilepay.dk/docs/pos/transition-to-one-platform).
Below you can find comparison between the existing MobilePay PoS API and the new [ePayment API](/docs/APIs/epayment-api) replacing MobilePay PoS.

Visit our [Recommended flows](https://developer.vippsmobilepay.com/docs/solutions/) to see the recommended flow for in-store payment [merchant scan](/docs/solutions/in-store/).

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
| `X-MobilePay-Client-System-Version`     | `Vipps-System-Version` (see [HTTP headers](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/http-headers/))                          |
| N/A                                     | `Vipps-System-Name` (see [HTTP headers](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/http-headers/))                             |
| N/A                                     | `Vipps-System-Plugin-Name` (see [HTTP headers](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/http-headers/))       |
| N/A                                     | `Vipps-System-Plugin-Version` (see [HTTP headers](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/http-headers/))    |
| `X-MobilePay-Merchant-VAT-Number`       | N/A                                             |
| `X-MobilePay-Idempotency-Key`           | `Idempotency-Key` (see [Idempotency](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/http-headers/#idempotency))                               |
| N/A                                     | `Ocp-Apim-Subscription-Key`                     |
| N/A                                     | `Merchant-Serial-Number`                        |

## Initiate Payment

See:

* [Create](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/create/)

| MobilePay PoS                                                  | ePayment                                       |
|----------------------------------------------------------------|------------------------------------------------|
| `amount`                                                       | `amount` (`currency`, `value`)                 |
| `currencyCode`                                                 | *Applied in `amount`*                          |
| `orderId`                                                      | [`paymentDescription​`](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/transactiontext/)                            |
| `plannedCaptureDelay`                                          | N/A                                            |
| `posId`                                                        | N/A                                            |
| `restrictions` (`debitCardDisallowed`, `creditCardDisallowed`) | N/A                                            |
| `merchantPaymentLabel`                                         | N/A                                            |
| N/A                                                            | `customer` (`phoneNumber`)                     |
| N/A                                                            | `customerInteraction` (`"CUSTOMER_PRESENT"`)   |
| N/A                                                            | `paymentMethod` (`type` `"WALLET"`)            |
| N/A                                                            | [`reference`](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/orderid)                                    |
| N/A                                                            | `userFlow` (`"PUSH_MESSAGE"` `"QR"`)           |
| N/A                                                            | `qrFormat` (`format`, `size`)                  |
|                                                                |                                                |
| **Response**                                                   |                                                |
| `paymentId`                                                    | [`reference`](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/orderid) (set in paymentInitiation)         |

## Query Payment

See:

* [Get payment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/get_info/)
* [Get payment event log](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/get_event_log/)

| MobilePay PoS   | ePayment                                                                                |
|-----------------|-----------------------------------------------------------------------------------------|
| `paymentId`     | [`reference`](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/orderid)                                                                             |
|                 |                                                                                         |
| **Response**    |                                                                                         |
| `orderId`       | [`reference`](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/orderid)                                                                             |
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
| `paymentId`                             | [`reference`](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/orderid)                                                                             |
| `amount`                                | `modificationAmount` (`currency`, `value`) *not applicable for cancel*                  |
|                                         |                                                                                         |
| **Response**                            |                                                                                         |
| N/A                                     | `amount` (`currency`, `value`)                                                          |
| N/A                                     | `state`                                                                                 |
| N/A                                     | `aggregate` (`authorizedAmount`, `cancelledAmount`, `capturedAmount`, `refundedAmount`) |
| `refundId` *only applicable for refund* | `pspReference`                                                                          |
| N/A                                     | [`reference`](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/orderid)                                                                             |

## Test environment

<MT />
