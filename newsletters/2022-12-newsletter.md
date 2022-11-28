<!-- START_METADATA
---
sidebar_position: 67
title: 2022-11
---
END_METADATA -->

# Technical newsletter for developers 2022-11

💥 DRAFT! 💥

This newsletter was sent in December 2022.

<!-- START_TOC -->

* [Recurring API v3](#recurring-api-v3)
* [Solutions](#solutions)
* [Updated emails to new merchants (and partners)](#updated-emails-to-new-merchants-and-partners)
* [Reminders](#reminders)
  * [Please check your API calls for errors](#please-check-your-api-calls-for-errors)
* [Questions or comments?](#questions-or-comments)

<!-- END_TOC -->

## Recurring API v3

The new version of Vipps Recurring API v3 is live! (https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api/)
This API includes new and improved functionality for campaignes (for example "10 weeks for 10 kr" or "1 kr until Christmas"), the possibility to reserve and capture/partally capture a charge (specially important for physical subscriptions) and several technical improvements. Go here for Migration guide ( https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api/v2-to-v3-migration-guide) and here for our Quick start guide including Postman collection ( https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api/vipps-recurring-api-quick-start)

The transfer to v3 will require some technical changes, but will have the same flows and logic as v2. We have made it as easy as possible to do the migration. v2 will still be working, but will not support the new functionality. **The v2 API will be phased out from June 1st 2023**.

## Solutions

The new
[Solutions](https://vippsas.github.io/vipps-developer-docs/docs/vipps-solutions)
section of our developer documentation describes best practice for
combining Vipps APIs for specific use cases, like:
* Loyalty at the point of sale (POS)
* Electric vehicle charging
* Parking

## Updated emails to new merchants (and partners)

We have updated and improved all emails sent as part of becoming a Vipps
merchant (the onboarding process). They all use the Vipps design, and
contain:
* The merchant's organization number
* The merchant's name
* The sale unit's MSN
* The sale unit's name

## Reminders

### Please check your API calls for errors

We are working on eliminating incorrect API use. Please:

* Monitor the responses you get when making API calls
* Log all errors
* Fix errors as quickly as possible
* Use the
  [API Dashboard](../developer-resources/api-dashboard.md)
  to find problems with your integration.

![API Dashboard example](images/2021-02-api-dashboard-example.png)

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).
