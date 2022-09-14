<!-- START_METADATA
---
sidebar_position: 76
title: 2021-04
---
END_METADATA -->

# Technical newsletter for developers 2021-04

This newsletter was sent in April 2021.

# "Click and collect" recommendations

For "click and collect" we recommend to use
[`staticShippingDetails`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#shipping-and-static-shipping-details)
(to avoid the extra HTTP roundtrip where Vipps asks the merchant
for the shipping options and prices) and also to set the default
shipping method to "Click and collect".

This will significantly speed up the payment process for customers.

This is done in the
[`POST:​/ecomm​/v2​/payments`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/initiatePaymentV3UsingPOST)
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

# Recurring payments and campaigns

Tip: Use
[Campaigns](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#campaigns)
if the subscription is cheaper in the beginning, such as "One month for 10 kr" and then the normal price.

If you use
`initialcharge`, users will be confused by how it appears in Vipps, as it
looks like the full price period starts immediately. Initial charge should be used for situations where
the customer pays for a phone and a phone subscription, and the first payment includes the phone.

See more details and screenshots here:
[When to use campaigns or initial charge](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#when-to-use-campaigns-or-initial-charge).

# Easier to use Userinfo

The authentication is now much easier, with no need for additional keys, both for
the eCom and Recurring APIs. See the call by call guides:

* [eCom API](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo-call-by-call-guide)
* [Recurring API](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#userinfo-call-by-call-guide)

# New date limits for capture and cancel

Payments can be captured up to 365 days after reservation,
and can be cancelled up to 180 days after reservation.
Attempts at capturing and cancelling older payments will result in
a `HTTP 400 Bad Request` with more details in the request body.

# Partner keys

If you are a Vipps partner and manage transactions on behalf of other
Vipps merchants you can use your own credentials to authenticate, and then send
the `Merchant-Serial-Number` header to identify which of your merchants you are
acting on behalf of.

The same set of partner keys can be used for both the
[Vipps eCom API](https://github.com/vippsas/vipps-ecom-api)
and the
[Vipps Recurring API](https://github.com/vippsas/vipps-recurring-api),
including the
[Userinfo](#use-userinfo)
endpoints for both.

See:
[Partner keys for eCom](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#partner-keys)
and
[Partner keys for Recurring](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#partner-keys)

# PSP Signup API

Payment Service Providers can use their existing API keys with the PSP Signup API to:

* List all or one merchant(s) under them
* Create a new merchant under them
* Update an existing merchant

See:
[PSP Signup API](https://github.com/vippsas/vipps-psp-api/blob/master/vipps-psp-signup-api.md).

# Order new products and create new sale units on portal.vipps.no

All customers can now log in on
[portal.vipps.no](https://portal.vipps.no)
and order new products, which automatically creates a new sale unit:

* [Vipps på Nett](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
  ([eCom API](https://github.com/vippsas/vipps-ecom-api),
  for both
  [webshops and apps](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/))
* [Vipps rett i Kassa](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/)
  ([eCom API](https://github.com/vippsas/vipps-ecom-api))
* [Vipps Faste betalinger](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
  ([Recurring API](https://github.com/vippsas/vipps-recurring-api))
* [Vipps Logg inn](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
  ([Login API](https://github.com/vippsas/vipps-login-api))

# Create new sale units in the test environment

You can create new sale units in the
[test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md)
on
[portal.vipps.no](https://portal.vipps.no):

On the page with the API keys for the test environment there is a button
for creating additional sale units, and you can then select
"direct capture" or "reserve capture", and also `skipLandingPage`.

This is available for all customers, also those that do not yet have any API access.

# Reminders

We have mentioned some things before, and take this opportunity to remind you:

## Please update your plugins

Several of our plugins have been updated to use the newest versions of
our APIs. Please make sure you have the newest version of the plugins
you use, and keep them up to date. See the
[the plugin overview](https://github.com/vippsas/vipps-plugins).

## Use Userinfo

Vipps Hurtigkasse is for shipping products to the customer.
Some use it for other purposes, but if no products are shipped,
you should not ask the customer for address and shipping method.

You should avoid asking the customer in a pub for the shipping method for the drinks, etc.

Instead: Use _Userinfo_ to ask for the user's details, such as:
phone number, name, email address, postal address, birth date, national identity number and bank accounts.
The user must of course consent to sharing the information.

See
[Userinfo for eCom](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo)
and
[Userinfo for Recurring](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#userinfo).

## API Dashboard 🚦

The API Dashboard is now available on
[portal.vipps.no](https://portal.vipps.no)
under the "Utvikler" ("Developer") tab.
It lets you see if there are problems with your use of Vipps APIs.
Here's an example:

![API Dashboard example](images/2021-02-api-dashboard-example.png)

This is just the start. Please let us know what you think and suggest improvements.

## Vipps HTTP Headers ℹ️

We recommend using the following _optional_ HTTP headers for all requests to the
[Vipps eCom API](https://github.com/vippsas/vipps-ecom-api/)
and the
[Vipps Recurring API](https://github.com/vippsas/vipps-recurring-api/).

| Header                        | Description                                  | Example value        |
| ----------------------------- | -------------------------------------------- | -------------------- |
| `Merchant-Serial-Number`      | The merchant serial number                   | `123456`             |
| `Vipps-System-Name`           | The name of the ecommerce solution           | `woocommerce`        |
| `Vipps-System-Version`        | The version number of the ecommerce solution | `5.4`                |
| `Vipps-System-Plugin-Name`    | The name of the ecommerce plugin             | `vipps-woocommerce`  |
| `Vipps-System-Plugin-Version` | The version number of the ecommerce plugin   | `1.4.1`              |

These headers provide useful metadata about the merchant's system,
which help Vipps improve our services, and also help in investigating problems.

## How to get help quickly

Please see
[this page](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

## Newsletter archive

Please see: [newsletters](https://github.com/vippsas/vipps-developers/tree/master/newsletters)

# Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
