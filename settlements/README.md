# Vipps Settlements

The settlement flow is as follows:

1. Day 1: A customer makes a purchase and the transaction is completed. If the purchased product is shipped later, the "day 1" is the day the product is shipped and the customer's account is charged.
2. Day 2: Settlement files are distributed, and are available in the Vipps portal: https://portal.vipps.no.
3. Day 3 (the next _bank day_) at 16:00: Payments are made from Vipps.
4. Day 5 (the third _bank day_): The settlement is booked with reference by the bank.

A Vipps merchant normally receives daily settlements. This can be changed to weekly, monthly settlements. See https://www.vipps.no/sporsmal#bedriftspm for more details.

# Settlement reports

Settlement reports are provided in these formats:

| Format | Example            | Specification      |
| ------ | ------------------ | ------------------ |
| OCR    | [OCRV20170114.sample.txt](ocr/OCRV20170114.sample.txt) | [ocr-spec.xlsx](ocr/ocr-spec.xlsx) |
| CSV    | [settlement-report.csv](csv/settlement-report.csv) | - |
| XML    | [Example-Gross.xml](xml/Example-Gross.xml), [Example-Net.xml](xml/Example-Net.xml) | [SettlementReport-3.0.xsd](xml/SettlementReport-3.0.xsd) |
| PDF    | [PDF](pdf/Vipps-oppgjørsrapport-16655-2018-09-23.pdf) | - |
| XLSX   | [XLSX](xlsx/Vipps-oppgjørsrapport-16655-2018-09-23.xlsx) | - |

Please note: Vipps does not provide settlement reports for Vipps Regninger, as payments are made directly from the user to the merchant. All payments are included in the OCR files provided by the merchant's bank.

## SFTP report service

The SFTP report service is used for downloading settlement reports.
SFTP-users are created, associated with a public key, and given access to the
reports of one or more merchants.
The reports are generated dynamically upon request.

Details: See the [sftp-report-service](sftp-report-service/) folder.

## OCR

OCR files are distributed in different ways, and will soon move to an
[SFTP](https://en.wikipedia.org/wiki/SSH_File_Transfer_Protocol)-based distribution.

Documentation for the legacy solution: [Vipps Faktura](ocr/vipps-invoice-api-vipps-faktura.pdf).

Details: See the [ocr](ocr/) folder.

## CSV

CSV files are sent by email.

Details: See the [csv](csv/) folder.

## XML

XML files are sent by email.

Details: See the [xml](xml/) folder.

## PDF

PDF files are sent by email.

Details: See the [pdf](pdf/) folder.
