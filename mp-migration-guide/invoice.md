---
title: "Invoice to ePayment"
sidebar_label: Invoice to ePayment
sidebar_position: 36
pagination_next: null
pagination_prev: null
---

import MT from './_mt.md'

# Invoice to ePayment

Read more about the transition to one platform on the [MobilePay site](https://developer.mobilepay.dk/docs/invoice/transition-to-one-platform).
Below, you can find comparison between the existing MobilePay Invoice API and the new [ePayment API](/docs/APIs/epayment-api) replacing MobilePay Invoice.

Visit our [Recommended flows](https://developer.vippsmobilepay.com/docs/solutions/) section to see the recommended flow for [invoice](/docs/solutions/invoice-through-epayments/).

Please note that ePayment encompasses various use case scenarios. Therefore, if you are seeking use cases that target existing MobilePay merchants and can be utilized for migration purposes, some examples include:

* [MobilePay InvoiceDirect](https://developer.mobilepay.dk/docs/invoice/api-endpoint-reference#invoicedirect)  1-1 to ePayment with userFlow = `PUSH_MESSAGE`
* [MobilePay InvoiceLinks](https://developer.mobilepay.dk/docs/invoice/api-endpoint-reference#invoicelink) 1-1 to ePayment with userFlow = `WEB_REDIRECT`
* "QR" The use of PDF => [Order Management API](https://developer.vippsmobilepay.com/docs/APIs/order-management-api/)

## Input formats

| MobilePay invoice                    | Vipps MobilePay ePayment                                                                      |
|--------------------------------------|-------------------------------------------------------------------------------------------------|
| `InvoiceIssuer​`                      | `Merchant-Serial-Number` (see [HTTP headers](https://developer.vippsmobilepay.com/docs/common-topics/http-headers/))                                                   ​ |
| `ConsumerAlias {Alias, AliasType}`  ​ | `Customer {Alias} (Example: 4512345678)`                                                        |
| `TotalAmount​`                        | `amount {currency, value (øre)}​`                                                                 |
| `InvoiceNumber` / `PaymentReference​` | [`reference`](https://developer.vippsmobilepay.com/docs/common-topics/orderid) / `paymentDescription`                                                             ​ |
| `DueDate​`                            | `expiresAt` (Must be between 10 minutes and 28 days. Example: `2023-02-26T17:32:28`)​                                    |
| (`InvoiceLink`) `RedirectUrl`       ​ | `returnUrl` (The URL the user is redirected to after the payment session).​                      |
| `Comment​`                            | N/A |
| `ConsumerAddressLines []`            | N/A |
| `DeliveryAddressLines []`            | N/A |
| `ConsumerName​`                       | N/A |
| `TotalVATAmount​`                     | N/A |
| `IssueDate`                          | N/A |
| `OrderDate`                          | N/A |
| `OrderDate`                          | N/A |
| `DeliveryDate​`                       | N/A |
| `MerchantContactName`                | N/A |
| `MerchantOrderNumber`                | N/A |
| `BuyerOrderNumber​`                   | N/A |
| `InvoiceUrl`+ `InvoiceArticles []`​   | See: [Order Management API](https://developer.vippsmobilepay.com/docs/APIs/order-management-api) |
| N/A                                  ​ | [`paymentDescription​`](https://developer.vippsmobilepay.com/docs/common-topics/transactiontext/)                                                                             |
| N/A                                    | `profile` ([`scope`](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api/#scope))​                                                                               |
| N/A                                  ​ | `paymentMethod` (`WALLET` or `CARD`. `CARD` → WEB_REDIRECT)​                                    |
| N/A                                    | `userFlow` (`PUSH_MESSAGE`, `NATIVE_REDIRECT`, `WEB_REDIRECT`, `QR`)                           ​ |
| N/A                                    | `qrFormat {format, size}` (only applicable when `userFlow` is set to `QR`)                         ​ |
| N/A                                    | `customerInteraction` (`CUSTOMER_PRESENT`, `CUSTOMER_NOT_PRESENT`)​                              |
| N/A                                    | `industryData` (In special cases only: Additional compliance data related to the transaction)​                          |

## Test environment

<MT />
