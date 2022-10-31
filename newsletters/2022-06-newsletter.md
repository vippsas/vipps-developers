<!-- START_METADATA
---
sidebar_position: 70
title: 2022-06
---
END_METADATA -->

# Technical newsletter for developers 2022-06

This newsletter was sent in June 2022.

<!-- START_TOC -->

## Table of Contents

* [Vipps Order Management API](#vipps-order-management-api)
* [Vipps Partner API](#vipps-partner-api)
* [All OpenAPI (Swagger) specifications and Postman collections/environments updated](#all-openapi-swagger-specifications-and-postman-collectionsenvironments-updated)
* [Remember: Vipps is always without fees when paying to businesses](#remember-vipps-is-always-without-fees-when-paying-to-businesses)
  * [Klarna Checkout recommendations](#klarna-checkout-recommendations)
* [Vipps eCom API: HTTPS required for all URLs](#vipps-ecom-api-https-required-for-all-urls)
* [Reminders](#reminders)
  * [Please check your eCom API calls for errors](#please-check-your-ecom-api-calls-for-errors)
  * [Use the API Dashboard to find problems with your integration](#use-the-api-dashboard-to-find-problems-with-your-integration)
  * [How to get help quickly](#how-to-get-help-quickly)
  * [Newsletter archive](#newsletter-archive)
* [Questions or comments?](#questions-or-comments)

<!-- END_TOC -->

## Vipps Order Management API

[The Vipps Order Management API](https://github.com/vippsas/vipps-order-management-api)
allows merchants to send rich receipt information to existing Vipps transactions,
including links to tracking information, tickets, etc.

## Vipps Partner API

[The Vipps Partner API](https://github.com/vippsas/vipps-partner-api)
is now available for all partners using partner keys.
We are very interested in feedback!

## All OpenAPI (Swagger) specifications and Postman collections/environments updated

We have done a major overhaul of all our API specifications, so all the
OpenAPI/Swagger specifications and all the Postman collections and environments
have been improved. See each API's GitHub repo for details.

## Remember: Vipps is always without fees when paying to businesses

Just a friendly reminder: Users never have to pay a fee when they pay a business
with Vipps. Please try to make this as clear as possible in your solution.

### Klarna Checkout recommendations

Please make sure to include the text saying
"Remember: Vipps is always without fees when paying businesses"
or similar:

```json
"external_payment_methods":[
   {
      "name": "Vipps",
      "redirect_url": "https://example.com/vipps/ecom-api/initiate/acme-shop-123-order123abc",
      "image_url": "https://example.com/images/vipps-logo.png",
      "fee": 0,
      "description": "Husk: Vipps er alltid gebyrfritt når du betaler til bedrifter."
   }
]
```

More details:
[Can I use Vipps with Klarna Checkout?](../faqs/other-faq.md#can-i-use-vipps-with-klarna-checkout)

## Vipps eCom API: HTTPS required for all URLs

From October 1, 2022, URL links in the body of
[`POST:/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
will no longer support HTTP, only HTTPS.

This includes the following fields:

* callbackPrefix
* consentRemovalPrefix
* fallBack
* shippingDetailsPrefix

 This has been documented for a _long_ time already, but not strictly enforced.
 See:
 [URL validation](../common-topics/url-validation.md).

## Reminders

### Please check your eCom API calls for errors

We are working on eliminating incorrect API use. Although we always respond to
incorrect API calls with a sensible HTTP status (usually `HTTP 400 Bad Request`)
and an informative error message in the response body, we see that some merchant
and partners keep making incorrect API calls.

Please:

* Monitor the responses you get when making API calls
* Log all errors
* Fix errors as quickly as possible
* Use the API Dashboard
* Contact us if there is anything we can help with

One example: Far too many calls to
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
use an incorrectly formatted phone number.
The effect is that the user's phone number is not correctly pre-filled on
the Vipps landing page.
Please make sure you send the `mobileNumber` in `91234567` format, not
`+47 91 23 45 67` or something else.
We have previously tried to respond with `HTTP 400 Bad Request` (as we should)
for incorrectly formatted phone numbers, but that broke _a lot_  of integrations,
so we decided to accept the incorrect API calls even though they give a poor
user experience.

See:

* [Use the API Dashboard to find problems with your integration](#use-the-api-dashboard-to-find-problems-with-your-integration)
* [Common errors](../faqs/common-errors-faq.md)

### Use the API Dashboard to find problems with your integration

The API Dashboard is available to all merchants for both the production and test environments,
and is an easy way to see if you are using the Vipps APIs correctly.
Think of it as a "health check", that you can use to see if there are any
problems you need to investigate.

See it on
[portal.vipps.no](https://portal.vipps.no)
under the "Utvikler" ("Developer") tab.
Here's an example for the Vipps eCom API's `/refund` endpoint:

![API Dashboard example](images/2021-02-api-dashboard-example.png)

See:
[API Dashboard](../developer-resources/api-dashboard.md).

### How to get help quickly

Please see
[this page](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).

### Newsletter archive

Please see: [newsletters](README.md)

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).
