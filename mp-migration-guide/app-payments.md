---
title: "App Payments to ePayment"
sidebar_label: App Payments to ePayment
sidebar_position: 39
pagination_next: null
pagination_prev: null
---

import MT from './\_mt.md'

# App Payments to ePayment

Read more about the transition to one platform on the [MobilePay site](https://developer.mobilepay.dk/docs/invoice/transition-to-one-platform).
Below, you can find comparison between the existing MobilePay App Payments API and the new [ePayment API](/docs/APIs/epayment-api) replacing MobilePay Invoice.

Please note that ePayment encompasses various use case scenarios. Therefore, if you are seeking use cases that target existing MobilePay merchants and can be utilized for migration purposes, some examples include:

## App Payments and ePayment endpoints

| Operation                | MobilePay App Payments                   | ePayment                                                                                                        |
| ------------------------ | ---------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| Initiate Payment         | `POST:/v1/payments`                      | [`POST:/epayments/v1/payments`](/api/epayment#tag/CreatePayment/operation/createPayment)                        |
| Fetch Single Payment     | `GET:/v1/payments/{paymentid}`           | [`GET:/epayments/v1/payments/{reference}`](/api/epayment#tag/QueryPayments/operation/getPayment)                |
| Fetch a list of payments | `GET /v1/payments`                       | N/A                                                                                                             |
| Query payment log        | N/A                                      | [`GET:/epayments/v1/payments/{reference}/events`](/api/epayment#tag/QueryPayments/operation/getPaymentEventLog) |
| Capture Payment          | `POST:/v1/payments/{paymentid}/capture`  | [`POST:/epayments/v1/payments/{reference}/capture`](/api/epayment#tag/AdjustPayments/operation/capturePayment)  |
| Cancel Payment           | `POST:/v1/payments/{paymentid}/cancel`   | [`POST:/epayments/v1/payments/{reference}/cancel`](/api/epayment#tag/AdjustPayments/operation/cancelPayment)    |
| Issue new refund         | `POST:/v1/refunds`                       | [`POST:/epayments/v1/payments/{reference}/refund`](/api/epayment#tag/AdjustPayments/operation/refundPayment)    |
| fetch a list of refunds  | `GET:/v1/refunds`                        | N/A                                                                                                             |
| fetch single refund      | `GET:/v1/refunds/{refundid}`             | [`GET:/epayments/v1/payments/{reference}`](/api/epayment#tag/QueryPayments/operation/getPayment)                |

## Authentication and headers

See:

- [Access token API](/docs/APIs/access-token-api/)

| MobilePay App Payments        | ePayment                                                                                                                            |
| ----------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| `apiKey or openId`            | `Authorization` ([`POST:/accesstoken/get`](/api/access-token#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)) |
| N/A                           | `Vipps-System-Version` (see [HTTP headers](/docs/common-topics/http-headers/))                                                      |
| N/A                           | `Vipps-System-Name` (see [HTTP headers](/docs/common-topics/http-headers/))                                                         |
| N/A                           | `Vipps-System-Plugin-Name` (see [HTTP headers](/docs/common-topics/http-headers/))                                                  |
| N/A                           | `Vipps-System-Plugin-Version` (see [HTTP headers](/docs/common-topics/http-headers/))                                               |
| `X-MobilePay-Idempotency-Key` | `Idempotency-Key` (see [Idempotency](/docs/common-topics/http-headers/#idempotency))                                                |
| N/A                           | `Ocp-Apim-Subscription-Key`                                                                                                         |
| N/A                           | `Merchant-Serial-Number`                                                                                                            |

## Initiate Payment

See:

- [Create](/docs/APIs/epayment-api/operations/create/)

| MobilePay App Payments                                    | ePayment                                                              |
| --------------------------------------------------------- | --------------------------------------------------------------------- |
| `amount`                                                  | `amount` (`currency`, `value`)                                        |
| `idempotencyKey`                                          | `Idempotency-Key`                                                     |
| `reference`                                               | [`paymentDescription`](/docs/common-topics/transactiontext/)          |
| `paymentPointId`                                          | `Merchant-Serial-Number`                                              |
| `redirectUri`                                             | `returnUrl`                                                           |
| `description`                                             | `paymentDescription`                                                  |
| `customerPhoneNumber` (Used for dual device flows on web) | `customer`  (`phoneNumber`)                                           |
| N/A                                                       | `customerInteraction` (`"CUSTOMER_NOT_PRESENT"`)                      |
| N/A                                                       | `paymentMethod` (`type` `"WALLET"`)                                   |
| N/A                                                       | [`reference`](/docs/common-topics/orderid)                            |
| N/A                                                       | `userFlow` (`"NATIVE_REDIRECT"` `"WEB_REDIRECT"`)                     |
|                                                           |                                                                       |
| **Response**                                              |                                                                       |
| `paymentId`                                               | [`reference`](/docs/common-topics/orderid) (set in paymentInitiation) |

## Query Payment

See:

- [Get payment](/docs/APIs/epayment-api/operations/get_info/)
- [Get payment event log](/docs/APIs/epayment-api/operations/get_event_log/)

| MobilePay App Payments | ePayment                                                                                                |
| ---------------------- | ------------------------------------------------------------------------------------------------------- |
| `paymentId`            | [`reference`](/docs/common-topics/orderid)                                                              |
|                        |                                                                                                         |
| **Response**           |                                                                                                         |
| `paymentId`            | [`reference`](/docs/common-topics/orderid)                                                              |
| `amount`               | `amount` (`currency`, `value`)                                                                          |
| `description`          | N/A                                                                                                     |
| `state`                | `state`                                                                                                 |
| N/A                    | `aggregate` (`authorizedAmount`, `cancelledAmount`, `capturedAmount`, `refundedAmount`)                 |
| N/A                    | `paymentMethod` (`type`)                                                                                |
| N/A                    | `profile` (`sub`) (see [What is the `sub`?](/docs/APIs/userinfo-api/userinfo-api-faq/#what-is-the-sub)) |
| N/A                    | `pspReference`                                                                                          |

## Capture, Cancel and Refund Payment

See:

- [Capture](/docs/APIs/epayment-api/operations/capture/)
- [Cancel](/docs/APIs/epayment-api/operations/cancel/)
- [Refund](/docs/APIs/epayment-api/operations/refund/)

| MobilePay App payments                  | ePayment                                                                                |
| --------------------------------------- | --------------------------------------------------------------------------------------- |
| `paymentId`                             | [`reference`](/docs/common-topics/orderid)                                              |
| `amount`                                | `modificationAmount` (`currency`, `value`) _not applicable for cancel_                  |
|                                         |                                                                                         |
| **Response**                            |                                                                                         |
| N/A                                     | `amount` (`currency`, `value`)                                                          |
| N/A                                     | `state`                                                                                 |
| N/A                                     | `aggregate` (`authorizedAmount`, `cancelledAmount`, `capturedAmount`, `refundedAmount`) |
| `refundId` _only applicable for refund_ | N/A                                                                                     |
| N/A                                     | `pspReference`                                                                          |

| N/A | [`reference`](/docs/common-topics/orderid) |

## Test environment

<MT />
