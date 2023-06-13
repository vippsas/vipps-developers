<!-- START_METADATA
---
title: Technical newsletter for developers 2021-12
sidebar_label: 2021-12
sidebar_position: 274
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Technical newsletter for developers 2021-12

This newsletter was sent in December 2021.

## Omikron tips

These Vipps solutions are extra relevant (again):

* Use
  [Vipps Logg inn](https://vipps.no/produkter-og-tjenester/privat/logg-inn-med-vipps/logg-inn-med-vipps/)
  and the
  [Vipps Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api)
  to register visitors - it's free.
* [Use Userinfo to register visitors](#use-userinfo-to-register-visitors)
  as an easy-to-use step in a normal Vipps payment.
* ["Click and collect" recommendations](#click-and-collect-recommendations)
  to speed up the user experience for your customers.

## Vipps Hurtigkasse: Use the explicit flow

When users are prompted to select shipping address and shipping address, the
explicit flow is *strongly* recommended. The user then has to actively
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
[Vipps Partner pages](https://developer.vippsmobilepay.com/docs/vipps-partner)
for (continuously) updated information.

## Reminders

### Use Userinfo to register visitors

For guest registration/tracking: Use *Userinfo* to ask for the user's details, such as:
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

### The Vipps QR API

Make window shopping great again!

An [early version of the Vipps QR API](https://developer.vippsmobilepay.com/docs/APIs/qr-api) is available.

The Vipps QR API lets merchants generate Vipps QR codes that can be used to pay
over the counter, without requiring the Vipps user to provide their telephone
number to the merchant. Or you can create your own QR with a
[short URL](https://developer.vippsmobilepay.com/docs/APIs/qr-api/vipps-qr-api#qr-formats)
that we provide.

The QR code, when scanned and opened, will redirect the user to the Vipps
landing page, which on the phone will automatically trigger a switch to the
Vipps app where they can pay the merchant.

### The Order Management API

An early version of the
[Order Management API](https://developer.vippsmobilepay.com/docs/APIs/order-management-api) is available.

The Order Management API allows merchants to send rich receipt information to
existing Vipps transaction. This information is shown to the customer in the
app in their order history. This functionality is available for both recurring
and direct payments, but not for pass-through payments.

### The Vipps Recurring API now supports variable amounts

Recurring agreements with variable amount lets merchants charge users a different
amount each for interval, based on the user's specified max amount.

More information can be found in the
[Recurring guide](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api#recurring-agreements-with-variable-amount).

### Vipps Login support for authentication/registration outside of browser/app (CIBA)

The Vipps Login service has been extended with Client Initiated Backchannel Authentication
(CIBA) flows to support use cases where authentication/registration does not start in a browser or an app.

This could typically be physical contexts like point of sales (POS) solutions, on the
phone in call center solutions, or devices/terminals like TV boxes. We currently support initiating logins based on the users phone number. We are also working on supporting the same flows with the user scanning the merchant's QR-code as a starting point.

More information can be found in [our documentation](https://developer.vippsmobilepay.com/docs/APIs/login-api).

## Newsletter archive

All the previous newsletters are in the
[newsletter archive](https://developer.vippsmobilepay.com/docs/vipps-developers/newsletters).

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://developer.vippsmobilepay.com/docs/vipps-developers/contact).
