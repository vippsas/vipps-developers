---
title: "Reporting to Report"
sidebar_label: "Reporting to Report"
sidebar_position: 39
pagination_next: null
pagination_prev: null
---

import MT from './_mt.md'

# Reporting API to Report API

## API Documentation

Both the [Vipps MobilePay Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api/) and the [MobilePay Reporting API](https://developer.mobilepay.dk/docs/reporting) allow for the retrieval of data related to payments, reconciliation, and more. The data offered by these APIs is quite similar. The transition from the Reporting API to the Report API is straightforward, involving no advanced logic; it's primarily about retrieving data in a read-only manner. 

### Notable Differences

It's important to note that the MobilePay Reporting API offered some functionalities, such as retrieving payment points, which are readily available for you in the [Management API](https://developer.vippsmobilepay.com/docs/APIs/management-api/management-api-guide/#get-the-sales-units-for-a-merchant-by-orgno)  

### Upcoming Changes

Please be aware that a v2 version is in development, which will introduce additional endpoints. You will have one endpoint for fetching transactions and another for fetching fees.

### Input formats



| **MobilePay Reporting API**             | **Vipps MobilePay Report API**                                                                      |
| ---------------------------------- | ----------------------------------------------------------------------------------------------- |
| `paymentId`:               | `transactionId`: "2000001"                                                                    |
| `type`: "`Payment"`                  | `transactionType`: "refund"                                                                   |
| `amount`: 276.45                   | `ledgerAmount`: 49900                                                                         |
|                                   |                                                                                                 |
| `currencyCode`: "DKK"             | `currency`: "NOK"                                                                             |
| `message`                 | N/A                                                                                          |
| `merchantReference: `"external_id"` | `orderId`: "acme-shop-123-order123abc"                                                       |
| `merchantPaymentLabel`:     | N/A                                                                                          |
| `transferReference`:       | N/A                                                                                          |
| `transferDate`:            | `ledgerDate`: "2020-10-05"                                                                    |
| `timestamp`: "2019-08-24T14:15:22Z" | `timestamp`: "2020-10-05T10:21:54.141089+0200"                                              |
| `userPhoneNumber`         | N/A                                                                                          |
| `userName`                | N/A                                                                                          |
| `loyaltyId`               | N/A                                                                                          |
| `myShopNumber`            | `recipientHandle`: "nor:12345"                                                                                          |
| `brandName`               | N/A                                                                                          |
| `brandId`                 | N/A                                                                                          |
| `locationId`              | N/A                                                                                          |
| `posName`                 | N/A                                                                                          |
| `beaconId`               | N/A                                                                                          |
| `agreementExternalId`     | N/A                                                                                          |
| `agreementId`             | N/A                                                                                          |
| `refundId`               | N/A                                                                                          |
|               | ledgerId: "1",
                                                                                          |
