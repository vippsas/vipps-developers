---
title: Technical newsletter for developers 2023-10
sidebar_label: 2023-10
sidebar_position: 265
pagination_next: null
pagination_prev: null
---

# Technical newsletter for developers 2023-10

This newsletter was sent in October 2023.

## Report API

The [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api)
version 2 is now available.

The API gives you, or your accounting partner, the ability to
fetch information about payment events that have been processed.
It is a REST API providing data in JSON format.

**Please note:**
* Accounting partners must use their
  [accounting keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys/#types-of-partner-keys).
  Merchants are not allowed to share API keys with partners that have not been approved by
  Vipps MobilePay, as we are strictly regulated and must know who can make payments using our APIs.
* Accounting companies can use the
  [form on vipps.no](https://www.vipps.no/developer/become-a-partner/)
  to become an accounting partner.
* Merchants select their accounting partner on portal.vipps.no as described here:
  [Give access to an accounting partner](https://developer.vippsmobilepay.com/docs/APIs/report-api/api-guide/overview/#give-access-to-an-accounting-partner).

## Deprecation of the SFTP service

The
[SFTP service](https://developer.vippsmobilepay.com/docs/settlements/sftp-report-service/)
is now deprecated, and will be shut down on February 1 2024,
with a four month warning according to the
[API Lifecycle](https://developer.vippsmobilepay.com/docs/common-topics/api-lifecycle/).

The
[Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api/)
is the replacement. See:
[What are the benefits of the Report API over the SFTP service?](https://developer.vippsmobilepay.com/docs/APIs/report-api/vipps-report-api-faq/#what-are-the-benefits-of-the-report-api-over-the-sftp-service)


## Reminders

### Please check your API calls for errors

We still see too much incorrect use of our APIs, and some errors cause payments to
fail, as well as bad user experiences. The API checklists explicitly says:

>Make sure to log and handle all errors. All integrations should display errors in a way that the users (customers and merchant employees/administrators) can see and understand them.

We are working on eliminating incorrect API use to ensure the best possible user
experience for all users and merchants. Please:

* Monitor the responses you get when making API calls
* Log all errors
* Fix errors as quickly as possible
* Use the
  [API Dashboard](https://developer.vippsmobilepay.com/docs/developer-resources/api-dashboard/)
  to find problems with your integration.

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please
[contact us](https://developer.vippsmobilepay.com/docs/contact).
