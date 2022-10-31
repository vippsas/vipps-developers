<!-- START_METADATA
---
sidebar_position: 68
title: 2022-11
---
END_METADATA -->

# Technical newsletter for developers 2022-11

This newsletter was sent in November 2022.

<!-- START_TOC -->

* [Get ready for "black week"](#get-ready-for-black-week)
* [eCom API: Don't rely 100 % on callbacks](#ecom-api-dont-rely-100--on-callbacks)
* [Report API](#report-api)
* [Documentation improvements](#documentation-improvements)
* [Check your phone number format](#check-your-phone-number-format)
* [Reminders](#reminders)
  * [Please check your API calls for errors](#please-check-your-api-calls-for-errors)
* [Questions or comments?](#questions-or-comments)

<!-- END_TOC -->

## Get ready for "black week"

Let your customers pay with
[Vipps Hurtigkasse](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#express-checkout-payments)
with the new and improved user experience by specifying
[`useExplicitCheckoutFlow": true`](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#how-to-specify-the-old-or-new-express-checkout-flow)
to reduce drop-off, left shopping carts, etc.

Make sure your use of Vipps is as good as it can be, without errors.
See: [Please check your API calls for errors](#please-check-your-api-calls-for-errors).

Monitor the Vipps Status Page:
[vipps.statuspage.io]( https://vipps.statuspage.io/).

The eCom FAQ entry
[Why do payments fail?](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api-faq#why-do-payments-fail)
may also be useful.

## eCom API: Don't rely 100 % on callbacks

Callback offer a faster user experience than polling, but you
cannot rely on callbacks alone. You must also poll
[`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)
as described in the
[Polling guidelines](../common-topics/polling-guidelines.md).

See:
[Callbacks](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#callbacks)

## Report API

The
[Report API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/report-api)
gives you or a third-party acting on your behalf the ability to
fetch information about payment events that have been processed by Vipps.

## Documentation improvements

We are working hard to improve the
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/):

* The documentation is
  [searchable](https://vippsas.github.io/vipps-developer-docs/search/)
* We have a new
  [Solutions](https://vippsas.github.io/vipps-developer-docs/docs/vipps-solutions/)
  section to highlight combinations of Vipps APIs, such as
  [Loyalty in physical stores](https://vippsas.github.io/vipps-developer-docs/docs/vipps-solutions/loyalty-in-pos/)
  and
  [Electric vehicle charging](https://vippsas.github.io/vipps-developer-docs/docs/vipps-solutions/ev-charging/).
* All APIs now have a
  [Quick start](../developer-resources/quick-start-guides.md)
  with Postman collection. We also have a global Postman environment to make it
  easier to test all APIs.

Please
[tell us what you think](https://forms.office.com/r/8iZVibsM4m)
in this short, 3-minute survey - thanks!

## Check your phone number format

Far too many Vipps payments fail because of badly formatted phone numbers.
We try to silently correct them, but can not fix all errors.

This is especially important when using
[Skip landing page](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#skip-landing-page),
as it's impossible to send a push message to a user if the specified phone number is incorrect.

Please see the API specification:
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)

![API specification for phone number](images/2022-11-phone-number.png)

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
