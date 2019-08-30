# Vipps Settlements

# Frequency

Vipps merchants can select daily, weekly or monthly settlement frequency by logging in with BankID on portal.vipps.no.

Vipps pays merchants every Monday or every 1. of the month, depending on the merchant preference.
It then takes 1-3 bank days before the money reaches the merchant settlement account.

# Settlement flow

The settlement flow is as follows:

1. Day 1: A customer makes a purchase and the transaction is completed. If the purchased product is shipped later, the "day 1" is the day the product is shipped and the customer's account is charged.
2. Day 2: Settlement files are distributed, and are available in the Vipps portal: https://portal.vipps.no.
3. Day 3 (the next _bank day_) at 16:00: Payments are made from Vipps.
4. Day 5 (the third _bank day_): The settlement is booked with reference by the bank.

A day starts and ends at midnight, Oslo time: Start `00:00:00`, end `23:59:59` (subseconds not specified). 
Please make sure your servers' clocks are correct, e.g. by using [NTP](https://en.wikipedia.org/wiki/Network_Time_Protocol).

A Vipps merchant normally receives daily settlements. This can be changed to weekly, monthly settlements. See [the FAQ](https://www.vipps.no/sporsmal#bedriftspm) for more details.

# Settlement reports

Settlement reports are provided in these formats:

| Format | Example            | Specification      |
| ------ | ------------------ | ------------------ |
| XML    | [Example-Gross.xml](xml/Example-Gross.xml), [Example-Net.xml](xml/Example-Net.xml) | [SettlementReport-3.0.xsd](xml/SettlementReport-3.0.xsd) |
| CSV    | [settlement-report.csv](csv/settlement-report.csv) | - |
| PDF    | [PDF](pdf/Vipps-oppgjørsrapport-16655-2018-09-23.pdf) | - |
| XLSX   | [XLSX](xlsx/Vipps-oppgjørsrapport-16655-2018-09-23.xlsx) | - |

Settlements reports are available both with and without personal details of the customer. 

This is due to [GDPR](https://ec.europa.eu/info/law/law-topic/data-protection_en), and whether
the data processor is Vipps or the merchant. See [GDPR](#gdpr) below.

# GDPR

The settlement reports available by SFTP (see below) do not contain detailed information about the
transactions. Reports containing personal information requires a data processor agreement.
Due to this, reports with personal information can only be downloaded by logging in with 
BankID on [portal.vipps.no](https://portal.vipps.no) and accepting the terms there.

The Norwegian text from [portal.vipps.no](https://portal.vipps.no):

_Velger du å laste ned rapporter med personinformasjon blir bedriften din selvstendig behandlingsansvarlig for personinformasjonen som lastes ned. Dette betyr at bedriften din er selv ansvarlig for å sikre etterlevelse av peronvernreglene. For mer informasjon, vennligst se Vipps [vilkår](https://www.vipps.no/vilkar/) for bruk._

# portal.vipps.no

Customers can log in to [portal.vipps.no](https://portal.vipps.no), choose "Rapporter" and download reports
in the formats mentioned above. Reports with personal details of the customers are also available.

# SFTP report service

The SFTP report service is used for downloading settlement reports.
SFTP-users are created, associated with a public key, and given access to the
reports of one or more merchants.
The reports are generated dynamically upon request.

These reports do not contain personal details of the customers.

Details: See the [sftp-report-service](sftp-report-service/) folder.

## XML

Details: See the [xml](xml/) folder.

## CSV

Details: See the [csv](csv/) folder.

## PDF

Details: See the [pdf](pdf/) folder.

## OCR

OCR files are no longer provided by Vipps. 
Documentation for the legacy solution: [Vipps Faktura](ocr/vipps-invoice-api-vipps-faktura.pdf).

Details: See the [ocr](ocr/) folder.

