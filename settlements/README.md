---
description: Learn how settlements are processed by Vipps MobilePay.
sidebar_label: Overview
sidebar_position: 1
pagination_next: null
pagination_prev: null
---

# Settlements

## Settlement flow

Settlements are done as quickly as possible and are dependent on banks.

The settlement flow is as follows:

1. Day 1: A customer makes a purchase and the transaction is completed.
   The merchant ships the product to the customer, if applicable.
   Then, the merchant captures the money and the customer's account is charged.

   Note: *Day 1* is normally the day that the product is shipped and the customer's account is charged.
2. Day 2: Settlement files are available (see [How to get settlement files](#how-to-get-settlement-files)).
3. Day 3: Payments are made from the Vipps MobilePay bank account to the merchant's bank
   account. Money is *normally* available in the account before noon.

The settlement process will always adhere to our
[terms and conditions](https://vipps.no/vilkar/vilkar-bedrift/),
section 5, "OPPGJØR OG FORHOLD TIL VIPPS INNLØSER" (i.e., *SETTLEMENT AND RELATIONSHIP WITH VIPPS REDEEMER*).

Days are bank days, Monday - Friday, excluding banking holidays. In other words,
a capture made on Monday will be on the merchant's account on Wednesday, while a
capture made on Friday will be on the merchant's account on Tuesday.

A day starts and ends at midnight, Oslo time: Start `00:00:00`, end `23:59:59` (subseconds not specified).
Please make sure your servers' clocks are correct, e.g. by using [NTP](https://en.wikipedia.org/wiki/Network_Time_Protocol).

Settlement files are generated every day including bank days and weekends (one file every day).
Payout for Friday, Saturday, and Sunday arrives on Tuesday (three separate transactions).
There is one settlement file per payout.

**Please note:** There is only one payment per settlement period: Even if there
have been thousands of payments in one week, there will still only be one
payment (e.g., lump sum) from us to the merchant.
The settlement reports have all the details for each of the thousands of payments.
Additionally, there is one payment per sales unit and this includes a corresponding settlement file.

### Reconciliation

A simple illustration showing where each ID is set, and how it all fits together.

![Settlement flow illustrated](img/settlement-process.png)

## Frequency

Vipps MobilePay merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and select daily, weekly, or monthly settlement frequency.

Vipps MobilePay pays merchants every Monday for weekly settlements,
and on the first day of the month for monthly settlements.

## Net and gross settlements

There are two types of settlements:

* Net settlement: Merchants will receive the users' payments excluding the Vipps MobilePay fees.
  In other words: The Vipps MobilePay fees are deducted from the settlement amount.
* Gross settlement: Merchants receive the full amount of the users' payments
  *including* the Vipps MobilePay fees. The merchant is then invoiced for the fees.

Net settlement is the default and is, in practice, the only settlement method offered.
Gross settlements are only offered in very rare cases.
With gross settlements, Vipps MobilePay essentially provides a loan to the merchant, and
this involves both additional cost and risk and also requires additional checks.

For gross settlements, if the merchant's organization number is registered as an EHF recipient,
Vipps MobilePay sends invoices as EHF. If not, the invoices are sent by email.
To change the invoice recipient, please
[contact customer service](https://vipps.no/kontakt-oss/).

See [Availability](#availability) for information about settlement files
when the balance is negative.

## File formats

Settlement reports are provided in:

* [XML](#xml)
* [CSV](#csv)
* [PDF](#pdf)
* [XLSX](#xlsx)


### XML

Here are schemas and example files for XML settlement reports.

Both [the current settlement report schema v3.0](/downloads/settlements/xml/SettlementReport-3.0.xsd) and the [old v2.0 version](/downloads/settlements/xml/SettlementReport-2.0.xsd) are available.

Example files are available for:

* [Gross settlements](/downloads/settlements/xml/Example-Gross.xml)
* [Net settlements](/downloads/settlements/xml/Example-Gross.xml)

<details>
<summary>Changes to the settlement report XML schema from v2.0 to v3.0</summary>
<div>

**NB!** New settlements will contain a mix of captures and refunds.
To make the numbers unambiguous we have introduced new fields
for capture and refund, but kept gross and net fields as before.

* Schema changes from v2.0 to v3.0:
  * Old schema URL for v2.0 was [SettlementReport-2.0.xsd](/downloads/settlements/xml/SettlementReport-2.0.xsd)
  * New schema URL is [SettlementReport-3.0.xsd](/downloads/settlements/xml/SettlementReport-3.0.xsd)
  * New schema validates all amount fields with new types `money`, `positiveMoney`, and `negativeMoney`
  * Other changes organized by parent element below

* Changes to PaymentsInfo:
  * `ReportDateFrom` and `ReportDateTo` fields:
    * Drop time part, keep only date (in YYYY-MM-DD format)
    * Change schema type from `xs:string` to `xs:date`
  * Remove control sums (`TotalSettledGrossAmount`, `TotalSettledNetAmount`, `TotalSettledFeeAmount`, and `TotalSettledRefundAmount`)
  * Move `NumOfSettlements` after `SettlementInfo` blocks to facilitate future streaming optimizations for large files

* Changes to TransactionInfo:
  * Rename `TransactionDate` to `TransactionTime` and:
    * Change type from `xs:string` to `xs:dateTime`
    * Fix time zone bug from previous report system where time UTC formatting was applied to Oslo time.
    * Now always Oslo time zone, consistent with dates
  * Change type of `TransactionID` from `xs:string` to `xs:long`
  * Add field `TransactionCaptureAmount` (always positive)
  * Add field `TransactionRefundAmount` (always negative)
  * Note that `TransactionGrossAmount = TransactionCaptureAmount + TransactionRefundAmount`

* Changes to `SettlementInfo`:
  * Rename `SettlementBatchDate` to `SettlementDate` and:
    * Drop time part and change type from `xs:string` to `xs:date`
    * For new settlements, this date is within the inclusive range `[ReportDateFrom, ReportDateTo]` and is equal to or later than the date of the last transaction within the settlement
    * Note that the bank transfer will typically occur at a later date
  * Change type of `SettlementID` from `xs:string` to `xs:long`
  * Move `NumOfTransactions` and all amounts to below `TransactionInfo` fields, to facilitate future streaming optimizations for large files
  * Add field `SettlementType` (`Net` or `Gross`)
  * Add field `SettledAmount`, which is the amount paid out or invoiced (net or gross depending on settlement type)
  * Add field `CaptureSettlementAmount`, sum of `TransactionCaptureAmount` fields
  * Add field `RefundSettlementAmount`, sum of `TransactionRefundAmount` fields
  * Note that `GrossSettlementAmount` is still the sum of `TransactionGrossAmount` fields
  * Note that `GrossSettlementAmount = CaptureSettlementAmount + RefundSettlementAmount`

* Changes to `FeeInfo`:
  * `FeeInfo` will only be included for old reports with gross settlement type
  * Change type of `FeeDate` from `xs:string` to `xs:date`
  * Change type of `FeeAccount` from `xs:long` to `xs:string`

* Changes to `SettlementDetailsInfo`:
  * Change type of `MainAddressCity` from `xs:NCName` to `xs:string`

* Changes to `VippsInfo`:
  * Change type of `WebSite` from `xs:NCName` to `xs:anyURI`
  * Change type of `Country` from `xs:NCName` to `xs:string`


</div>
</details>

### CSV

The following is an example of a CSV settlement file:

* [CSV settlement file](/downloads/settlements/csv/settlement-report.csv)

<details>
<summary>CSV settlement file contents</summary>
<div>

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


</div>
</details>

### PDF

The following is an example of a PDF settlement file:

* [PDF settlement file](/downloads/settlements/pdf/Vipps-oppgj%C3%B8rsrapport-16655-2018-09-23.pdf)

### XLSX

The following is an example of a CSV settlement file:

* [XLSX settlement file](/downloads/settlements/xlsx/vipps-settlement-example.xlsx)

### Identifying payments

If you need to use `orderId` to identify a payment, please use
[Vipps på nett](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/) and the
[ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/).

Payments made with
[*Vippsnummer*](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
do not have an `orderId`.

### Additional info for recurring payments

For recurring payments, the `orderID` is an optional field.
If `orderID` is not specified by the merchant when making a charge,
the settlement report shows the automatically generated `chargeID` in the `orderID` field.
If `orderID` is in use, this is also used in the settlement report.

See the
[Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/recurring-api-guide#create-a-charge)
for more details.

### GDPR

We need the customer's consent before sharing personal information.

Settlement reports generally don't contain personal information; however, payments made with *Vippsnummer* may have personal information and must be treated with care.

See the FAQ:
[Why are the customer names not shown on the transaction overview?](../knowledge-base/merchant-questions.md#why-are-the-customer-names-not-shown-on-the-transaction-overview).

## How to get settlement files

### Report API

Use the [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api)
to get your settlement files programmatically. With this API, you can get daily or continuous-feed reports for your accounts. See the
[Report API guide](https://developer.vippsmobilepay.com/docs/APIs/report-api/api-guide/) for details.

### Merchant portal

You can download reports from the
[merchant portal](https://portal.vipps.no) in the *Rapporter* (i.e., *Reports*) section.
Reports are available in the formats mentioned under [File formats](#file-formats).

Reports with personal details of the customers are also available.
Please consider [GDPR](#gdpr).

### Email

Through the [merchant portal](https://portal.vipps.no), you can specify the email addresses to receive settlement reports.

**Please note:** We are not allowed to send reports with personal customer details.
See [GDPR](#gdpr) for more information.

### SFTP

**Important:** The SFTP service is deprecated and will be unavailable from March 1, 2024.
This was announced in the
[Technical Newsletter for Developers 2023-10](https://developer.vippsmobilepay.com/docs/newsletters/2023-10-newsletter/#deprecation-of-the-sftp-service).

Please use the
[Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api/) to get your settlement information.

## Availability

Settlements are created every day, as long as the balance is positive.

If the balance for a day is zero (e.g. due to lack of
transaction) or negative (e.g. due to refunds), a settlement will not be created
until the balance becomes positive. This means that in some cases, a settlement report may
include transactions spanning several days back in time.

Settlement reports are available by 12:00 noon. The reports are generated around
01:00-03:00 at night, but may be delayed due to technical changes, maintenance in
various systems, or other unforeseen events.

**Please note:** There will be no settlement reports for dates without completed
payments. In these cases, neither the settlement files nor the directories that
should have contained settlement files will exist.

**Important:** If a merchant has refunded more money than the sum of payments,
so that the balance is negative, we will not create settlement reports.
We cover the negative balance for a short while, but if it persists,
we will send an invoice to the merchant to settle the balance.

There are no settlement reports for the
[test environment](../test-environment.md).

### Daily reports

The settlement reports are available by 12:00 noon.

### Weekly reports

The settlement report is generated on Mondays, by 12:00 noon.

### Monthly reports

The settlement report is generated on the 1st of the month, by 12:00 noon.
