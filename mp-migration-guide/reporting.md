---
title: "Reporting to Report"
sidebar_label: "Reporting to Report"
sidebar_position: 40
pagination_next: null
pagination_prev: null
---

import MT from './_mt.md'

# Reporting API to Report API

## API Documentation

Both the [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api/) and the [Reporting API](https://developer.mobilepay.dk/docs/reporting) allow for the retrieval of data related to payments, reconciliation, and more. The data offered by these APIs is quite similar. The transition from the Reporting API to the Report API is straightforward, involving no advanced logic; it's primarily about retrieving data in a read-only manner. 

## Transition to facades

1. When we transition merchants to facades, settlement data from that date will no longer be accessible in the old [Reporting API](https://developer.mobilepay.dk/docs/reporting). It will be exclusively available in the new [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api/).

2. Merchants are required to retrieve their historical data using the [Reporting API](https://developer.mobilepay.dk/docs/reporting) and obtain new data using the [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api/).

3. Merchants will need to combine data from both APIs on their end. This task is not overly complex as both APIs provide read-only JSON with similar data fields.

4. In the future, merchants will be able to access all settlement data, both old and new, through the [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api/) once the migration is complete.

5. At some point, the [Reporting API](https://developer.mobilepay.dk/docs/reporting) will be deprecated and discontinued since all data will be accessible through the Report API. We may discontinue it before data migration, as there will be no new data available, and we encourage merchants to retrieve their data while it's still accessible.

Both the [Vipps MobilePay Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api/) and the [MobilePay Reporting API](https://developer.mobilepay.dk/docs/reporting) allow for the retrieval of data related to payments, reconciliation, and more. The data offered by these APIs is quite similar. The transition from the Reporting API to the Report API is straightforward, involving no advanced logic. It's primarily about retrieving data in a read-only manner.

### Notable Differences

It's important to note that the MobilePay Reporting API offered some functionalities, such as retrieving payment points, which are readily available for you in the [Management API](https://developer.vippsmobilepay.com/docs/APIs/management-api/management-api-guide/#get-the-sales-units-for-a-merchant-by-orgno).
Please note that Report and Management API are only available in production.

### Upcoming Changes

Please be aware that a v2 version or the Report API is still in development, which will introduce additional endpoints. You will have one endpoint for fetching transactions and another for fetching fees.

### Input formats

| **MobilePay Reporting API** | **Vipps MobilePay Report API** |
| --------------------------- | ------------------------------ |
| `paymentId`                 | `transactionId`                |
| `type`: `"Payment"`         | `transactionType`              |
| `amount`                    | `ledgerAmount`                 |
|                             |                                |
| `currencyCode`              | `currency`                     |
| `message`                   | Upcoming feature               |
| `merchantReference`         | `orderId`                      |
| `merchantPaymentLabel`      | N/A                            |
| `transferReference`         | N/A                            |
| `transferDate`              | `ledgerDate`                   |
| `timestamp`                 | `timestamp`                    |
| `userPhoneNumber`           | N/A                            |
| `userName`                  | N/A                            |
| `loyaltyId`                 | N/A                            |
| `myShopNumber`              | `recipientHandle`              |
| `brandName`                 | N/A                            |
| `brandId`                   | N/A                            |
| `locationId`                | N/A                            |
| `posName`                   | N/A                            |
| `beaconId`                  | N/A                            |
| `agreementExternalId`       | N/A                            |
| `agreementId`               | N/A                            |
| `refundId`                  | N/A                            |
| N/A                         | `ledgerId`                     |
| N/A                         | `fee`                          |

### Webhook

Webhook events through the [MobilePay Webhook API](https://developer.mobilepay.dk/api/wehooks) will no longer be sent for transfer.
