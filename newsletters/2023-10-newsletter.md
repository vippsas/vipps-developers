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

## Management API

The
[Management API](https://developer.vippsmobilepay.com/docs/APIs/management-api/)
is available for all merchants and _most_ partners:
* Pre-fill product orders to simplify and speed up onboarding of merchants
* Retrieve information about merchants and their sales units

See
[What are the benefits of the Management API over the Partner API?](https://developer.vippsmobilepay.com/docs/APIs/management-api/management-api-faq/#what-are-the-benefits-of-the-management-api-over-the-partner-api)

Partners: See
[Types of partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys/#types-of-partner-keys).

## ePayments API

The [Long living payments](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/features/long-living-payments/) feature in ePayments API is now supported in the latest version of the app on both iOS and Android.

When a payment is created with order lines, users can now see the them before making the payment in the latest version of the app on both iOS and Android.

See [recommended flows](https://developer.vippsmobilepay.com/docs/solutions/invoice-through-epayments/) for how enduser will see the above scenarios in their app. 

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

## Deprecation of the Partner API

The
[Management API](https://developer.vippsmobilepay.com/docs/APIs/management-api/)
has replaced the
[Partner API](https://developer.vippsmobilepay.com/docs/APIs/partner-api/.)

For those few that still use the Partner API, please update as soon as possible.
The Partner API will be unavailable _at the latest_ on February 1 2024.

## Deprecation of the Checkout API V2

The
[Checkout API version 2](https://developer.vippsmobilepay.com/docs/APIs/checkout-api/)
will be shut down Jan 1st 2024, so please make sure you're using version 3.

Checkout V3 improves upon V2 through alignment of polling and callback responses, improvement of field names, and expanding models related to logistics options to permit more advanced features. 

[Our migration guide](https://developer.vippsmobilepay.com/docs/APIs/checkout-api/vipps-checkout-api-migration-v3/) will take you through all the details, if you haven't already switched.

## MobilePay migration guides

There are several migration guides for how to move from the
MobilePay APIs to the new APIs:
[Migration giudes](https://developer.vippsmobilepay.com/docs/mp-migration-guide).

## Reminders

### Deprecation of the Recurring API V2
As announced in [December 2022 newsletter](https://developer.vippsmobilepay.com/docs/newsletters/2022-12-newsletter/#recurring-api-v3),
the [Recurring API version 2](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/) will be shut down November 1st 2023, so please make sure you're using version 3.

[Our migration guide](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/v2-to-v3-migration-guide/) will take you through all the details, if you haven't already switched.

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
