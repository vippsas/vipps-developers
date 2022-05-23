# Technical newsletter for developers 2022-05

💥 DRAFT 💥

This newsletter was sent in May 2022.

## Table of Contents

* [Vipps Order Management API](#vipps-order-management-api)
* [Vipps Partner API](#vipps-partner-api)
* [Klarna Checkout recommendations](#klarna-checkout-recommendations)
* [Reminders](#reminders)
  * [Please check your eCom API calls for errors](#please-check-your-ecom-api-calls-for-errors)
  * [Use the API Dashboard to find problems with your integration](#use-the-api-dashboard-to-find-problems-with-your-integration)
  * [How to get help quickly](#how-to-get-help-quickly)
  * [Newsletter archive](#newsletter-archive)
* [Questions or comments?](#questions-or-comments)

# Vipps Order Management API

[The Vipps Order Management API](https://github.com/vippsas/vipps-order-management-api)
allows merchants to send rich receipt information to existing Vipps transactions,
including links to tracking information, tickets, etc.

# Vipps Partner API

[The Vipps Partner API](https://github.com/vippsas/vipps-partner-api)
is now available for all partners using partner keys.
We are very interested in feedback!

# Klarna Checkout recommendations

Please make sure to include the text saying
"Vipps is without fees when paying businesses"
or similar:

```
"external_payment_methods":[
   {
      "name": "Vipps",
      "redirect_url": "https://example.com/vipps/ecom-api/initiate/acme-shop-123-order123abc",
      "image_url": "https://example.com/images/vipps-logo.png",
      "fee": 0,
      "description": "Husk: Vipps er gebyrfritt når du betaler til bedrifter."
   }
]
```

More details:
[Can I use Vipps with Klarna Checkout?](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#can-i-use-vipps-with-klarna-checkout)

# Reminders

## Please check your eCom API calls for errors

We are working on eliminating incorrect API use. Although we always respond to
incorrect API calls with a sensible HTTP status (usually `HTTP 400 Bad Request`)
and an informative error message in the response body, we see that some merchant
and partners keep making incorrect API calls.

Please:
- Monitor the responses you get when making API calls
- Log all errors
- Fix errors as quickly as possible
- Use the API Dashboard
- Contact us if there is anything we can help with

One example: Far too many calls to
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-ecom-api/#/Vipps_eCom_API/initiatePaymentV3UsingPOST)
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
* "Common errors" in the
  [eCom API FAQ](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md)

## Use the API Dashboard to find problems with your integration

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
[API Dashboard](https://github.com/vippsas/vipps-developers#api-dashboard).

## How to get help quickly

Please see
[this page](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

## Newsletter archive

Please see: https://github.com/vippsas/vipps-developers/tree/master/newsletters

# Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
