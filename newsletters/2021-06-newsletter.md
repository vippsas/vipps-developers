<!-- START_METADATA---
sidebar_position: 75
title: 2021-06
---
END_METADATA -->

# Technical newsletter for developers 2021-06

This newsletter was sent in June 2021.

## Recognize your loyal customers

With Vipps you can always know who your customers are, and optionally connect
them to your loyalty program:
* Vipps Logg inn: The easiest way to register and/or log in. No usernames or passwords!
* Userinfo: Ask the user to share details, such as:
  phone number, name, email address, postal address, birth date, national identity number and bank accounts.

You can then automatically give your loyal customers benefits such as
discounts, freebies, connect them to your own loyalty programme, etc.
More information:
* [Vipps Logg inn: Product information](https://www.vipps.no/produkter-og-tjenester/bedrift/innlogging-og-identifisering/logg-inn-med-vipps/)
* [Vipps Login API](https://github.com/vippsas/vipps-login-api)
* [Userinfo for the Vipps eCom API](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo)
* [Userinfo for the Vipps Recurring API](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#userinfo)

**Please note:** When a user pays with a debit or credit card using Vipps,
all the benefits apply, just as when the payment card is used outside of Vipps.

## API Dashboard for Vipps Login API

The API Dashboard now also shows data for the Login API.
See it on
[portal.vipps.no](https://portal.vipps.no)
under the "Utvikler" ("Developer") tab.
Here's an example:

![API dashboard login data](images/2021-06-api-dashboard-login-example.png)

## Reminders

We have mentioned some things before, and take this opportunity to remind you:

### Manage "everything" on portal.vipps.no

All customers can now log in on
[portal.vipps.no](https://portal.vipps.no)
and order new products, which automatically creates a new sale unit:

- [Vipps på Nett](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
  ([eCom API](https://github.com/vippsas/vipps-ecom-api),
  for both
  [webshops and apps](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/))
- [Vipps rett i Kassa](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/)
  ([eCom API](https://github.com/vippsas/vipps-ecom-api))
- [Vipps Faste betalinger](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
  ([Recurring API](https://github.com/vippsas/vipps-recurring-api))
- [Vipps Logg inn](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
  ([Login API](https://github.com/vippsas/vipps-login-api))

You can create also new sale units in the
[test environment](../developer-resources/test-environment.md)
on
[portal.vipps.no](https://portal.vipps.no):
On the page with the API keys for the test environment there is a button
for creating additional sale units, and you can then select
"direct capture" or "reserve capture", and also `skipLandingPage`.
This is available for all customers, also those that do not yet have any API access.

### Please update your plugins

Several of our plugins have been updated to use the newest versions of
our APIs. Please make sure you have the newest version of the plugins
you use, and keep them up to date. See the
[the plugin overview](https://github.com/vippsas/vipps-plugins).

### How to get help quickly

Please see
[this page](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).

### Newsletter archive

All the previous newsletters are in
[newsletters](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters/).

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).
