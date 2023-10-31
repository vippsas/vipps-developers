---
title: Technical newsletter for developers 2021-06
sidebar_label: 2021-06
sidebar_position: 275
pagination_next: null
pagination_prev: null
---

# Technical newsletter for developers 2021-06

This newsletter was sent in June 2021.

## Recognize your loyal customers

With Vipps you can always know who your customers are, and optionally connect
them to your loyalty program:

* Vipps Log in: The easiest way to register and/or log in. No usernames or passwords!
* Userinfo: Ask the user to share details, such as:
  phone number, name, email address, postal address, birthdate, national identity number and bank accounts.

You can then automatically give your loyal customers benefits such as
discounts, freebies, connect them to your own loyalty program.
More information:

* [Vipps Logg inn: Product information](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
* [Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api)
* [Userinfo for the eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#userinfo)
* [Userinfo for the Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/recurring-api-guide#userinfo)

**Please note:** When a user pays with a debit or credit card using Vipps,
all the benefits apply, just as when the payment card is used outside Vipps.

## API Dashboard for Login API

The API Dashboard now also shows data for the Login API.
See it on
[portal.vipps.no](https://portal.vipps.no)
in the *Utvikler* (*Developer*) section.
Here's an example:

![API dashboard login data](images/2021-06-api-dashboard-login-example.png)

## Reminders

We have mentioned some things before, and take this opportunity to remind you:

### Manage "everything" on portal.vipps.no

All customers can now log in on
[portal.vipps.no](https://portal.vipps.no)
and order new products, which automatically creates a new sales unit:

* [Vipps på Nett](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
  ([eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api),
  for both
  [webshops and apps](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/))
* [Vipps rett i Kassa](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/)
  ([eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api))
* [Vipps Faste betalinger](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
  ([Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api))
* [Vipps Logg inn](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
  ([Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api))

You can create also new sales units in the
[test environment](../test-environment.md)
on
[portal.vipps.no](https://portal.vipps.no):
On the page with the API keys for the test environment there is a button
for creating additional sales units, and you can then select
"direct capture" or "reserve capture", and also `skipLandingPage`.
This is available for all customers, also those that do not yet have any API access.

### Please update your plugins

Several of our plugins have been updated to use the newest versions of
our APIs. Please make sure you have the newest version of the plugins
you use, and keep them up to date. See the
[plugin overview](https://developer.vippsmobilepay.com/docs/plugins).

### How to get help quickly

Please see
[this page](https://developer.vippsmobilepay.com/docs/contact).

### Newsletter archive

All the previous newsletters are in
[newsletters](https://developer.vippsmobilepay.com/docs/newsletters).

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://developer.vippsmobilepay.com/docs/contact).
