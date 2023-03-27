<!-- START_METADATA
---
title: CSV
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Vipps settlements: CSV

<!-- START_COMMENT -->

ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/).

<!-- END_COMMENT -->

The following is an example of a CSV settlement file:

* [CSV settlement file](./settlement-report.csv)

The CSV settlement file contains the following info:

| Column title  | Description | Comment  |
| ------------- | ------------- | ------------- |
| Salgsdato  | Date of sale  |    |
| Salgssted  | Sales unit name   |   |
| Vippsnummer  | Merchant serial number   |   |
| Produkt  | Vipps product name  | E.G. "Vipps Netthandel"  |
| Transaksjons-ID  | Transaction ID  | Differs for Reserved, Captured and Refunded transaction  |
| Ordre-ID  | Ordre ID   |   |
| Brutto  | Total amount  |   |
| Gebyr  | Fees   |   |
| Netto  | Total amount minus fees   |   |
| Transaksjonstype  | Transaction type  | E.G. Salg (Sale), Refundering (Refund)  |
| Oppgjørs-ID  | Settlement ID    |
| Oppgjørsdato  | Settlement date   |
| Oppgjørssum  | Settlement total amount   |
| Oppgjørskonto  | Settlement bank account number   |   |
| Fornavn  | First name  | Only applicable for Vipps number   |
| Etternavn  | Last name  | Only applicable for Vipps number   |
| Melding  | Message/Transaction text  |   |

<!-- START_COMMENT -->

See the [Settlements](..) overview.

<!-- END_COMMENT -->
