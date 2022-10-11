<!-- START_METADATA
---
sidebar_position: 68
title: 2022-11
---
END_METADATA -->

# Technical newsletter for developers 2022-11

💥 DRAFT! 💥

This newsletter was sent in November 2022.

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
* We hava new
  [Solutions](https://vippsas.github.io/vipps-developer-docs/)
  section to highlight combinations of Vipps APIs, such as
  [Loyalty in physical stores](https://vippsas.github.io/vipps-developer-docs/).
* All APIs now have a
  [Quick start](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/vipps-quick-start-guides)
  with Postman collection. We also have a global Postman environment to make it
  easier to test all APIs.  

## Check your phone number format

Far too many Vipps payments fail because of badly formatted phone numbers.
We try to silently correct them, but please see the API specification:
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)

## Reminders

### Please check your API calls for errors

We are working on eliminating incorrect API use. Please:
- Monitor the responses you get when making API calls
- Log all errors
- Fix errors as quickly as possible
- Use the API Dashboard
- Contact us if there is anything we can help with

### Use the API Dashboard to find problems with your integration

The
[API Dashboard](https://github.com/vippsas/vipps-developers/blob/master/vipps-resources.md#api-dashboard)
is available to all merchants for both the production and test environments,
and is an easy way to see if you are using the Vipps APIs correctly.
Think of it as a "health check", that you can use to see if there are any
problems you need to investigate.

Here's an example for the Vipps eCom API's `/refund` endpoint:

![API Dashboard example](images/2021-02-api-dashboard-example.png)

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
