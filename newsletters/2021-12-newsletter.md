<!-- START_METADATA
---
sidebar_position: 74
title: 2021-12
---
END_METADATA -->

# Technical newsletter for developers 2021-12

This newsletter was sent in December 2021.

<!-- START_TOC -->

- [Omikron tips](#omikron-tips)
- [Vipps Hurtigkasse: Use the explicit flow](#vipps-hurtigkasse-use-the-explicit-flow)
- [Use the API Dashboard to find problems with your integration](#use-the-api-dashboard-to-find-problems-with-your-integration)
- [Important information for partners](#important-information-for-partners)
- [Reminders](#reminders)
  * [Use Userinfo to register visitors](#use-userinfo-to-register-visitors)
  * ["Click and collect" recommendations](#-click-and-collect--recommendations)
  * [The Vipps QR API](#the-vipps-qr-api)
  * [The Vipps Order Management API](#the-vipps-order-management-api)
  * [The Vipps Recurring API now supports variable amounts](#the-vipps-recurring-api-now-supports-variable-amounts)
  * [Vipps Login support for authentication/registration outside of browser/app (CIBA)](#vipps-login-support-for-authenticationregistration-outside-of-browserapp-ciba)
- [Newsletter archive](#newsletter-archive)
- [Questions or comments?](#questions-or-comments-)

<!-- END_TOC -->

## Omikron tips

These Vipps solutions are extra relevant (again):

- Use
  [Vipps Logg inn](https://vipps.no/produkter-og-tjenester/privat/logg-inn-med-vipps/logg-inn-med-vipps/)
  and the
  [Vipps Login API](https://github.com/vippsas/vipps-login-api)
  to register visitors - it's free.
- [Use Userinfo to register visitors](#use-userinfo-to-register-visitors)
  as an easy-to-use step in a normal Vipps payment.
- ["Click and collect" recommendations](#-click-and-collect--recommendations)
  to speed up the user experience for your customers.

## Vipps Hurtigkasse: Use the explicit flow

When users are prompted to select shipping address and shipping address, the
explicit flow is _strongly_ recommended. The user then has to actively
select shipping address and shipping method.

The "old" flow does not prompt the user in the same way, and some users
do not notice that they select an incorrect/old/outdated address.

Using the explicit flow is simple: Just specify
`"useExplicitCheckoutFlow": true`
in
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST).

See
[Old and new express checkout flow](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#old-and-new-express-checkout-flow)
for more details.

## Use the API Dashboard to find problems with your integration

The API Dashboard is available for both the production and test environments,
and is an easy way to see if you are using the Vipps APIs correctly.
Think of it as a "health check", that you can use to see if there are any
problems you need to investigate.

See it on
[portal.vipps.no](https://portal.vipps.no)
under the "Utvikler" ("Developer") tab.
Here's an example for the Vipps eCom API's `/refund` endpoint:

![API Dashboard example](images/2021-02-api-dashboard-example.png)

## Important information for partners

There is quite a bit happening for Vipps partners.
Please see
[github.com/vippsas/vipps-partner](https://github.com/vippsas/vipps-partner)
for (continuously) updated information.

## Reminders

### Use Userinfo to register visitors

For guest registration/tracking: Use _Userinfo_ to ask for the user's details, such as:
phone number, name, email address, postal address, birth date, national identity number and bank accounts.
The user must of course consent to sharing the information.

See
[Userinfo for eCom](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo)
and
[Userinfo for Recurring](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#userinfo).

### "Click and collect" recommendations

For "click and collect" we recommend to use
[`staticShippingDetails`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#shipping-and-static-shipping-details)
(to avoid the extra HTTP roundtrip where Vipps asks the merchant
for the shipping options and prices) and also to set the default
shipping method to "Click and collect".

This will significantly speed up the payment process for customers.

This is done in the
[`POST:​/ecomm​/v2​/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
call by including:

```
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

### The Vipps QR API

Make window shopping great again!

An early version of the Vipps QR API is available on GitHub:
https://github.com/vippsas/vipps-qr-api

The Vipps QR API lets merchants generate Vipps QR codes that can be used to pay
over the counter, without requiring the Vipps user to provide their telephone
number to the merchant. Or you can create your own QR with a [short URL](https://github.com/vippsas/vipps-qr-api/blob/main/vipps-qr-api.md#qr-formats) we provide.

The QR code, when scanned and opened, will redirect the user to the Vipps
landing page, which on the phone will automatically trigger a switch to the
Vipps app where they can pay the merchant.

### The Vipps Order Management API

An early version of the Vipps Order Management API is available on GitHub:
https://github.com/vippsas/vipps-order-management-api/

The Order Management API allows merchants to send rich receipt information to
existing Vipps transaction. This information is shown to the customer in the
app in their order history. This functionality is available for both recurring
and direct payments, but not for passthrough payments.

### The Vipps Recurring API now supports variable amounts

Recurring agreements with variable amount lets merchants charge users a different
amount each for interval, based on the user's specified max amount.

More information can be found in
[our documentation](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#recurring-agreements-with-variable-amount).

### Vipps Login support for authentication/registration outside of browser/app (CIBA)

The Vipps Login service has been extended with Client Initiated Backchannel Authentication
(CIBA) flows to support use cases where authentication/registration does not start in a browser or an app.

This could typically be physical contexts like point of sales (POS) solutions, on the
phone in call center solutions, or devices/terminals like TV boxes. We currently support initiating logins based on the users phone number. We are also working on supporting the same flows with the user scanning the merchant's QR-code as a starting point.

More information can be found in [our documentation](https://github.com/vippsas/vipps-login-api/blob/master/vipps-login-api.md#client-initiated-backchannel-authentication-flows-ciba---special-cases-where-login-does-not-start-in-browser-or-app).

## Newsletter archive

All the previous newsletters are in the
[newsletter archive](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters/).

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
