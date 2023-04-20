---
title: XML
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---


# Vipps XML reports



This repository contains schemas and example files for Vipps XML settlement reports.

Both [the current settlement report schema v3.0](SettlementReport-3.0.xsd) and the [old v2.0 version](SettlementReport-2.0.xsd) are available.

Example files are available for:

* [Gross settlements](Example-Gross.xml)
* [Net settlements](Example-Gross.xml)

## Changes to the Vipps settlement report XML schema from v2.0 to v3.0

**NB!** New settlements will contain a mix of captures and refunds.
To make the numbers unambiguous we have introduced new fields
for capture and refund, but kept gross and net fields as before.

- Schema changes from v2.0 to v3.0:
    - Old schema URL for v2.0 was [SettlementReport-2.0.xsd](./SettlementReport-2.0.xsd)
    - New schema URL is [SettlementReport-3.0.xsd](./SettlementReport-3.0.xsd)
    - New schema validates all amount fields with new types "money", "positiveMoney", and "negativeMoney"
    - Other changed organized by parent element below

- Changes to PaymentsInfo:
    - ReportDateFrom and ReportDateTo fields:
        - Drop time part, keep only date (in YYYY-MM-DD format)
        - Change schema type from xs:string to xs:date
    - Remove control sums (TotalSettledGrossAmount, TotalSettledNetAmount, TotalSettledFeeAmount, and TotalSettledRefundAmount)
    - Move NumOfSettlements after SettlementInfo blocks to facilitate future streaming optimizations for large files

- Changes to TransactionInfo:
    - Rename TransactionDate to TransactionTime and:
        - Change type from xs:string to xs:dateTime
        - Fix time zone bug from previous report system where time UTC formatting was applied to Oslo time.
        - Now always Oslo time zone, consistent with dates
    - Change type of TransactionID from xs:string to xs:long
    - Add field TransactionCaptureAmount (always positive)
    - Add field TransactionRefundAmount (always negative)
    - Note that TransactionGrossAmount = TransactionCaptureAmount + TransactionRefundAmount

- Changes to SettlementInfo:
    - Rename SettlementBatchDate to SettlementDate and:
        - Drop time part and change type from xs:string to xs:date
        - For new settlements, this date is within the inclusive range [ReportDateFrom, ReportDateTo] and is equal to or later than the date of the last transaction within the settlement
        - Note that the bank transfer will typically occur at a later date
    - Change type of SettlementID from xs:string to xs:long
    - Move NumOfTransactions and all amounts to below TransactionInfo fields, to facilitate future streaming optimizations for large files
    - Add field SettlementType ("Net" or "Gross")
    - Add field SettledAmount, which is the amount paid out or invoiced (net or gross depending on settlement type)
    - Add field CaptureSettlementAmount, sum of TransactionCaptureAmount fields
    - Add field RefundSettlementAmount, sum of TransactionRefundAmount fields
    - Note that GrossSettlementAmount is still the sum of TransactionGrossAmount fields
    - Note that GrossSettlementAmount = CaptureSettlementAmount + RefundSettlementAmount

- Changes to FeeInfo:
    - FeeInfo will only be included for old reports with gross settlement type
    - Change type of FeeDate from xs:string to xs:date
    - Change type of FeeAccount from xs:long to xs:string

- Changes to SettlementDetailsInfo:
    - Change type of MainAddressCity from xs:NCName to xs:string

- Changes to VippsInfo:
    - Change type of WebSite from xs:NCName to xs:anyURI
    - Change type of Country from xs:NCName to xs:string
