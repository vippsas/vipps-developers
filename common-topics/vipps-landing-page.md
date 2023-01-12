<!-- START_METADATA
---
title: Vipps landing page
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# The Vipps landing page

This is applicable to:

* [eCom API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/)
* [Partner API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/partner-api/)
* [PSP API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/psp-api/)
* [Recurring API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api/)

When a user is directed to the `url`,
they will either be taken to Vipps or to the Vipps landing page:

* In a mobile browser, the Vipps app will automatically be opened with app-switch.
  The result is the same for the `vipps://` and the `https://` URLs.
  This is done by the phone's operating system; It recognized that the `https://`
  URL for the landing page is a Vipps URL, and knows that it should be open the
  Vipps app instead of the opening it in a web browser.
* In a desktop browser, the landing page will prompt the user for the phone number
  (the number may also be pre-filled, see below).
  The user enters or confirms the phone number.
  If is also possible to enter another Vipps user's number, to have that
  person complete the payment.
  Vipps sends a push notification to the specified phone number,
  the user gets a push notification, opens Vipps and confirms the payment.

![The Vipps landing page](images/vipps-flow-landing-page.png)

The Vipps landing page is mandatory and provides a consistent and recognizable user experience
that helps guide the user through the payment flow.
Our data shows that the landing page gives a higher success rate and lower drop-off,
because the users get a familiar user experience and know the payment flow.
In this way, Vipps takes responsibility for helping the user from the browser to the app,
and to complete the payment in a familiar way.

The user's phone number can be set in the payment initiation call. It is
remembered by the user's browser, eliminating the need for re-typing it on
subsequent purchases.

In some cases one Vipps user will start the payment process, but the actual payment
will be made by another Vipps user. The Vipps landing page makes this possible, since
the phone number can be changed.
A typical example is one user that is below
15 years old, and can therefore not pay businesses, will let another Vipps
user complete the payment.

**Important:** Never show the Vipps landing page inside an iframe.
That will make it impossible for the user to reliably be redirected back to the
merchant's website, and result in a lower success rate.
In general: Any "optimization" of the payment flow may break the Vipps payment
flow - if not today, then later.

<!-- START_COMMENT -->

## Table of contents

- [Generating a QR code to the Vipps landing page](#generating-a-qr-code-to-the-vipps-landing-page)
- [Skip landing page](#skip-landing-page)

<!-- END_COMMENT -->

## Generating a QR code to the Vipps landing page

If you have user-facing display, you may want to generate a QR code based on the
landing page URL, instead of asking the user for their phone number. Scanning
the QR code will take the user directly to the payment in the Vipps app.

![Demo QR code](images/demo-qr.svg)

This is done in cooperation with the Vipps QR API. See
[One-time payment QR](https://vippsas.github.io/vipps-developer-docs/docs/APIs/qr-api/vipps-qr-api#one-time-payment-qr-codes)
in the Vipps QR API guide for more details about this and other QR services.

See the
[Quick start](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api-quick-start)
for step-by-step examples of generating QR codes and short links for one-time payments initiated from the eCom API.

## Skip landing page

*This functionality is only available for special cases.*

Skipping the landing page is reserved for physical points of sale and vending
machines where no display is available.

This feature must be specially enabled by Vipps for an eligible sale unit and
the sale unit must be whitelisted by Vipps.

If you need to skip the landing page: Contact your
Key Account Manager. If you do not have a KAM: Please log in on
[portal.vipps.no](https://portal.vipps.no),
find the right sale unit and click the email link under the "i" information
bubble. Include a detailed description of why it is not possible to display
the landing page.

**Please note:** When using `skipLandingPage`, the user is not sent to a URL
after completion of the payment. The "result page" is just the confirmation in
Vipps. The `fallback` URL sent in the API request can therefore be the
merchant's main URL, like `https://example.com`, etc.

If the `skipLandingPage` property is set to `true`:
* It will cause a push notification to be sent immediately to the given
  phone number, without loading the landing page.
* The user is not sent to a URL after completion of the payment.
  The "result page" is just the confirmation in
  Vipps.
* If the sale unit is not whitelisted, the request will fail and an error
  message will be returned.

**Important:** When using `"skipLandingPage": true`:

* The user is not able to provide a different phone number for completing the payment.
* It is crucial to use the correct format for the user's phone number.
  If not, the payment will fail.
* The user is not sent to a `fallback` URL after completion of the payment.
  The "result page" is just the confirmation in Vipps.
  The `fallback` URL sent in the API request can simply be the website URL.

If you want to check if a sale unit is allowed to use `skipLandingPage`, see
the sale unit overview under the "Utvikler" (developer) menu. Or you can check
by using the API:

1. Specify `"skipLandingPage": true`.
2. Check the response code and message.
   The API will return an error if attempting to use `skipLandingPage` without being whitelisted.

See FAQ:

* [Is it possible to skip the landing page](../faqs/vipps-landing-page-faq.md#is-it-possible-to-skip-the-landing-page)
* [How can I check if I have skipLandingPage activated?](../faqs/vipps-landing-page-faq.md#how-can-i-check-if-i-have-skiplandingpage-activated)
