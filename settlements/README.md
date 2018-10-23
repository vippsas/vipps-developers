# Vipps Settlements

Settlement reports are provided in these formats:

| Format | Example            | Specification      |
| ------ | ------------------ | ------------------ |
| OCR    | [OCRV20170114.sample.txt](ocr/OCRV20170114.sample.txt) | [ocr-spec.xlsx](ocr/ocr-spec.xlsx) |
| CSV    | [settlement-report.csv](csv/settlement-report.csv) | - |
| XML    | [Example-Gross.xml](xml/Example-Gross.xml), [Example-Net.xml](xml/Example-Net.xml) | [SettlementReport-3.0.xsd](xml/SettlementReport-3.0.xsd) |
| PDF    | [PDF](pdf/Vipps-oppgjørsrapport-16655-2018-09-23.pdf) | - |
| XLSX   | [XLSX](xlsx/Vipps-oppgjørsrapport-16655-2018-09-23.xlsx) | - |

# SFTP report service

The SFTP report service is used for downloading settlement reports.
SFTP-users are created, associated with a public key, and given access to the
reports of one or more merchants.
The reports are generated dynamically upon request.

Details: See the [sftp-report-service](sftp-report-service/) folder.

# OCR

OCR files are distributed in different ways, and will soon move to an
[SFTP](https://en.wikipedia.org/wiki/SSH_File_Transfer_Protocol)-based distribution.

Documentation for the legacy solution: [Vipps Faktura](ocr/vipps-invoice-api-vipps-faktura.pdf).

Details: See the [ocr](ocr/) folder.

# CSV

CSV files are sent by email.

Details: See the [csv](csv/) folder.

# XML

XML files are sent by email.

Details: See the [xml](xml/) folder.

# PDF

PDF files are sent by email.

Details: See the [pdf](pdf/) folder.
