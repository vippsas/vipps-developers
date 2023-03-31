<!-- START_METADATA
---
title: Technical newsletter for developers 2022-01
sidebar_label: 2022-01
sidebar_position: 73
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Technical newsletter for developers 2022-01

This newsletter was sent in January 2022.

<!-- START_COMMENT -->

## Table of Contents

* [Please check your eCom API calls](#please-check-your-ecom-api-calls)
* [Recurring API: The "PROCESSING" status](#recurring-api-the-processing-status)
* [Vipps Login directly from phone number and QR code](#vipps-login-directly-from-phone-number-and-qr-code)
* [Deprecation of the Vipps Signup API](#deprecation-of-the-vipps-signup-api)
* [Reminders](#reminders)
  * [Use the API Dashboard to find problems with your integration](#use-the-api-dashboard-to-find-problems-with-your-integration)
  * [Use Status page to get information about incidents](#use-status-page-to-get-information-about-incidents)
  * [Omikron tips](#omikron-tips)
  * [Vipps Hurtigkasse: Use the explicit flow](#vipps-hurtigkasse-use-the-explicit-flow)
  * [Use Userinfo to register visitors when they pay](#use-userinfo-to-register-visitors-when-they-pay)
  * ["Click and collect" recommendations](#click-and-collect-recommendations)
* [Newsletter archive](#newsletter-archive)
* [Questions or comments?](#questions-or-comments)

<!-- END_COMMENT -->

## Please check your eCom API calls

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
[`POST:/ecomm/v2/payments`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
use an incorrectly formatted phone number.
The effect is that the user's phone number is not correctly pre-filled on
the [Vipps landing page](../common-topics/vipps-landing-page.md).

Please make sure you send the `mobileNumber` in `91234567` format, not
`+47 91 23 45 67` or something else.
We have previously tried to respond with `HTTP 400 Bad Request` (as we should)
for incorrectly formatted phone numbers, but that broke _a lot_  of integrations,
so we decided to accept the incorrect API calls even though they give a poor
user experience.

See:

* [Use the API Dashboard to find problems with your integration](#use-the-api-dashboard-to-find-problems-with-your-integration)
* [FAQ: Common errors](../faqs/common-errors-faq.md)

## Recurring API: The "PROCESSING" status

We would like to emphasize: With the Vipps Recurring API merchants ask Vipps
to make the charges, and Vipps handles _everything_ for the merchant.

Vipps does not "leak" the customers' information about insufficient funds,
blocked cards, etc. Users are informed about all such problems in Vipps, which
is the only place they can be corrected. The merchant's customer service should
always ask the user to check in Vipps if a charge has failed.

We have, for a while, attempted to give the merchant up-to-date information
about the status of the charge, with `failureReason` and `failureDescription`,
but this causes more confusion than clarity: Even if one charge attempt fails,
the charge itself has not failed until all the attempts are completed.
We will therefore continue to use `PROCESSING`, as we have done, but until
_all_ charge attempts have been made.

The status of a charge will be `PROCESSING` while Vipps is taking care of business,
from the `due` date until the charge has succeeded, or until the
`retryDays` have passed without a successful charge.
The final status will be `CHARGED` or `FAILED`.
See the
[Recurring API documentation](https://developer.vippsmobilepay.com/docs/APIs/recurring-api)
for more details.

We are also working on providing an event log for each `chargeId`, so merchants
can get _some_ information, especially if a charge ends as `FAILED`.
You can "star" the
[Vipps Recurring API repo](https://developer.vippsmobilepay.com/docs/APIs/recurring-api)
and subscribe to this newsletter to get updates.

## Vipps Login directly from phone number and QR code

The Vipps Login API now supports merchant-initiated logins using the
user's phone number, and by users scanning a QR code.

* Vipps Login directly from phone number is a "Client Initiated Backchannel
  Authentication" (CIBA) flow where authentication/registration does not start in a
  browser or an app, but is initiated by the merchant, using the user's phone number.
  The user simply confirms in Vipps.
  This is typically in physical contexts like point of sales (POS), on the phone
  in call center solutions, or using devices/terminals like TV boxes. The user can
  either get a confirmation in Vipps, or be taken to the merchant's confirmation page in a browser.
* Vipps Login directly from QR code allows the user to scan a QR code with the
  phone's camera or with Vipps and register or log in directly. The user can either get a confirmation in Vipps,
  or be taken to the merchant's confirmation page in a browser.
  This can be used in marketing, from posters, screens etc.

See:

* [Vipps Login from phone number API: How It Works](https://developer.vippsmobilepay.com/docs/APIs/login-api/how-it-works/vipps-login-from-phone-number-api-howitworks)
* Vipps Login from QR-code API: How It Works (no longer available)
* [Vipps Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api)

## Deprecation of the Vipps Signup API

The old API that a few partners still use to sign up new merchants will
be phased out. See
[Deprecation of the Vipps Signup API](https://github.com/vippsas/vipps-signup-api/blob/master/vipps-signup-api-deprecation.md)
and
[Vipps Partners](https://developer.vippsmobilepay.com/docs/vipps-partner).

## Reminders

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

### Use Status page to get information about incidents

Vipps uses Status page to inform about problems, planned maintenance, etc.
You can subscribe to get all updates, and also subscribe to specific incidents.

One example:
[Apache Log4j vulnerability – No impact to Vipps](https://vipps.statuspage.io/incidents/yfbhp4lm9g4j).

See:
[Status page for the production environment](https://vipps.statuspage.io)
and
[the other status pages](../developer-resources/status-pages.md).

### Omikron tips

These Vipps solutions are extra relevant (again):

* Use
  [Vipps Logg inn](https://vipps.no/produkter-og-tjenester/privat/logg-inn-med-vipps/logg-inn-med-vipps/)
  and the
  [Vipps Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api)
  to register visitors - it's free.
* [Use Userinfo to register visitors when they pay](#use-userinfo-to-register-visitors-when-they-pay)
  as an easy-to-use step in a normal Vipps payment.
* ["Click and collect" recommendations](#click-and-collect-recommendations)
  to speed up the user experience for your customers.

### Vipps Hurtigkasse: Use the explicit flow

When users are prompted to select shipping address and shipping address, the
explicit flow is _strongly_ recommended. The user then has to actively
select shipping address and shipping method.

The "old" flow does not prompt the user in the same way, and some users
do not notice that they select an incorrect/old/outdated address.

Using the explicit flow is simple: Just specify
`"useExplicitCheckoutFlow": true`
in
[`POST:/ecomm/v2/payments`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST).

See
[Old and new express checkout flow](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#old-and-new-express-checkout-flow)
for more details.

### Use Userinfo to register visitors when they pay

For guest registration/tracking: Use _Userinfo_ to ask for the user's details, such as:
phone number, name, email address, postal address, birthdate, national identity number and bank accounts.
The user must of course consent to sharing the information.

See
[Userinfo for eCom](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#userinfo)
and
[Userinfo for Recurring](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api#userinfo).

### "Click and collect" recommendations

For "click and collect" we recommend to use
[`staticShippingDetails`](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#shipping-and-static-shipping-details)
(to avoid the extra HTTP roundtrip where Vipps asks the merchant
for the shipping options and prices) and also to set the default
shipping method to "Click and collect".

This will significantly speed up the payment process for customers.

This is done in the
[`POST:​/ecomm​/v2​/payments`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
call by including:

```json
"staticShippingDetails": [
  {
    "isDefault": "Y",
    "priority": 0,
    "shippingCost": 0,
    "shippingMethod": "Click and collect",
    "shippingMethodId": "click-and-collect"
  }
]
```

## Newsletter archive

All the previous newsletters are in the
[newsletter archive](https://developer.vippsmobilepay.com/docs/vipps-developers/newsletters).

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://developer.vippsmobilepay.com/docs/vipps-developers/contact).
