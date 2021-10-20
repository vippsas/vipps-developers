# Vipps Settlements

Document version 2.2.0.

- [Settlement flow](#settlement-flow)
- [Frequency](#frequency)
- [Net and gross settlements](#net-and-gross-settlements)
- [Settlement report formats](#settlement-report-formats)
  * [Additional info for recurring payments](#additional-info-for-recurring-payments)
  * [GDPR](#gdpr)
- [How to get settlement files](#how-to-get-settlement-files)
  * [portal.vipps.no](#portalvippsno)
  * [Email](#email)
  * [SFTP](#sftp)
  * [API](#api)
- [Availability](#availability)
    + [Daily reports](#daily-reports)
    + [Weekly reports](#weekly-reports)
    + [Monthly reports](#monthly-reports)
- [Questions?](#questions-)

# Settlement flow

Settlements are done as quickly as possible, and depends on banks. The settlement flow is as follows:

1. Day 1: A customer makes a purchase and the transaction is completed.
   If the purchased product is shipped later, the "day 1" is the day the
   product is shipped and the customer's account is charged.
2. Day 2: Settlement files are distributed, and are available on
   [portal.vipps.no](https://portal.vipps.no).
3. Day 3 (the next _bank day_) at 16:00: Payments are made from Vipps.
4. Day 5 (the third _bank day_): The settlement is booked with reference by the bank.

A day starts and ends at midnight, Oslo time: Start `00:00:00`, end `23:59:59` (subseconds not specified).
Please make sure your servers' clocks are correct, e.g. by using [NTP](https://en.wikipedia.org/wiki/Network_Time_Protocol).

# Frequency

Vipps merchants can select daily, weekly or monthly settlement frequency by logging in with BankID on
[portal.vipps.no](https://portal.vipps.no).

Vipps pays merchants every Monday or every 1. of the month, depending on the merchant preference.
It then takes 1-3 bank days before the money reaches the merchant settlement account.

See [the FAQ](https://www.vipps.no/sporsmal#bedriftspm) for more details.

# Net and gross settlements

Merchants with a "net settlement" contract receive the users' payments
excluding the Vipps fees. On other words: The Vipps fees are deducted
from the settlement amount.

Merchants with a "gross settlement" contract receive the _full amount_
of the users' payments
_including_ the Vipps fees, and are then invoiced for the Vipps fees.

For gross settlements: If the merchant's organization number is registered as an EHF recipient,
Vipps sends invoices as EHF. If not, the invoices are sent by email.
To change invoice recipient, please
[contact customer service](https://vipps.no/kontakt-oss/bedrift/vipps/).

See [Availability](#availability) below for information about settlement files
when the balance is negative.

# Settlement report formats

Settlement reports are provided in these formats:

| Format | Example            | Specification      |
| ------ | ------------------ | ------------------ |
| XML    | [Example-Gross.xml](xml/Example-Gross.xml), [Example-Net.xml](xml/Example-Net.xml) | [SettlementReport-3.0.xsd](xml/SettlementReport-3.0.xsd) |
| CSV    | [settlement-report.csv](csv/settlement-report.csv) | - |
| PDF    | [PDF](pdf/Vipps-oppgjørsrapport-16655-2018-09-23.pdf) | - |
| XLSX   | [XLSX](xlsx/vipps-settlement-example.xlsx) | - |

More details:
* XML: See the [xml](xml/) folder.
* CSV: See the [csv](csv/) folder.
* PDF: See the [pdf](pdf/) folder.
* OCR: Not available. See the [ocr](ocr/) folder.

Payments made with
[Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
do not have an `orderId`.
If you need an `orderId` to identify a payment, you need to use
[Vipps på nett](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/).
See also the Vipps eCom API.

## Additional info for recurring payments

For recurring payments the `ordreID` is an optional field.
If `ordreID` is not specified by the merchant when making a charge,
the settlement report shows the automatically generated `chargeID` in the `orderID` field.
If `ordreID` is in use, that is also used in the settlement report.

## GDPR

Settlements reports are available both with and without personal details of the customer.
This is due to [GDPR](https://ec.europa.eu/info/law/law-topic/data-protection_en), and whether
the data processor is Vipps or the merchant.

Reports containing personal information requires a data processor agreement.
Due to this, reports with personal information can only be downloaded by logging in with
BankID on [portal.vipps.no](https://portal.vipps.no) and accepting the terms there.

The Norwegian text from [portal.vipps.no](https://portal.vipps.no):

_Velger du å laste ned rapporter med personinformasjon blir bedriften din selvstendig behandlingsansvarlig for personinformasjonen som lastes ned. Dette betyr at bedriften din er selv ansvarlig for å sikre etterlevelse av peronvernreglene. For mer informasjon, vennligst se Vipps [vilkår](https://www.vipps.no/vilkar/) for bruk._

The settlement reports available by [SFTP](#sftp) do not contain detailed information about the
transactions, as the API can not obtain the data processor agreement.

# How to get settlement files

## portal.vipps.no

Customers can log in to [portal.vipps.no](https://portal.vipps.no), choose "Rapporter" and download reports
in the formats mentioned above. 

Reports with personal details of the customers are also available, see
[GDPR](#gdpr).

## Email

Merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and specify email addresses that Vipps will send settlement reports to.

Reports with personal details of the customers can not be sent by email, , see
[GDPR](#gdpr).

## SFTP

The SFTP report service is used for downloading settlement reports.
SFTP-users are created, associated with a public key, and given access to the
reports of one or more merchants.
The reports are generated dynamically upon request.

See [Availability](#availability) for information about when the files
and directories are available.

Reports with personal details of the customers can not be sent with SFTP, see
[GDPR](#gdpr).

Details: See the [sftp-report-service](sftp-report-service/) folder.

## API

There is no API for retrieving settlement data.

# Availability

Settlement reports are available by 12:00 noon. The reports are generated around
01-03 at night, but may be delayed due to technical changes, maintenance in
various systems, etc.

**Please note:** There will be no settlement reports for dates without completed
payments. In these cases, neither the settlement files nor the directories that
should have contained settlement files will exist.

**Important:** If a merchant has refunded more money than the sum of payments,
so that the balance is negative, Vipps will not create settlement reports.
Vipps covers the negative balance for a (short) while, but if it persists,
Vipps will send an invoice to the merchant to settle the balance.

There are no settlement reports for the 
[test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md).


### Daily reports

The settlement reports are available by 12:00 noon.

### Weekly reports

The settlement report is generated on Mondays, by 12:00 noon.

### Monthly reports

The settlement report is generated on the 1st of the month, by 12:00 noon.

# Questions?

We're always happy to help with code or other questions you might have!

For customer-specific questions about settlements, please contact operations@vipps.no.

For general questions: Please create an [issue](https://github.com/vippsas/vipps-ecom-api/issues),
a [pull request](https://github.com/vippsas/vipps-ecom-api/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
