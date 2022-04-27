# Technical newsletter for developers 2022-04

This newsletter was sent in April 2022.

## Table of Contents

* [Release of remainder after doing a partial capture](#release-of-remainder-after-doing-a-partial-capture)
* [The Vipps QR API now works in the test environment](#the-vipps-qr-api-now-works-in-the-test-environment)
* [Logo handling changes in PSP Signup API](#logo-handling-changes-in-psp-signup-api)
* [Recurring charge changes](#recurring-charge-changes)
* [Reminders](#reminders)
  * [Please check your eCom API calls](#please-check-your-ecom-api-calls)
  * [Use the API Dashboard to find problems with your integration](#use-the-api-dashboard-to-find-problems-with-your-integration)

# Release of remainder after doing a partial capture

The Vipps eCom API now supports both partial capture (as before) and
release of the remainder of the reserved amount.

If you wish to cancel an order which you have partially captured: Send a
[`PUT:/ecomm/v2/payments/{orderId}/cancel`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/cancelPaymentRequestUsingPUT)
request with `shouldReleaseRemainingFunds: true` in the body.
The payment must be `RESERVED` for this to take effect.
See:
[Cancelling a partially captured order](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#cancelling-a-partially-captured-order).

# The Vipps QR API now works in the test environment

[The Vipps QR API](https://github.com/vippsas/vipps-qr-api) now works in both in
the production and
[test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md).

# Logo handling changes in PSP Signup API

The response of the
[`GET:/v1/merchants/{merchantSerialNumber}`](https://vippsas.github.io/vipps-psp-api/signup/#/Merchant/getMerchant)
endpoint in the in the
[Vipps PSP API](https://github.com/vippsas/vipps-psp-api)
contains a `logo` field, with the merchant's logo encoded in base64 format.

We are changing this to a URL, with a new field `logoUrl` in the response,
pointing to a separate and highly available service where we will host the logo
images.

The `logo` field in this API response is from now on **deprecated**, and will be removed on 30. May.

Please switch to the new `logoUrl` field as soon as possible.

This change only applies to the `GET` method, and does not affect the `POST` and `PATCH` methods.

# Recurring charge changes

 From **August 1st, 2022** some new rules for charge creation will be enforced:

 - The `amount` of a charge is flexible but can not be higher than the
   `agreement price`.
 - For an agreement with a `campaign`, the `amount` of a charge is flexible but
   can not be higher than the campaign price. After the campaign expires the
  `amount` of a charge can not be higher than the `agreement price`.

 If the agreement was created with an initial charge and the initial charge
 amount is the same amount as the campaign price, then no new charges can be
 created until the next interval for the campaign.

 See:
 [Create charge]([https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#create-charge).

# Reminders

## Please check your eCom API calls

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
