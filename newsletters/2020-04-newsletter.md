# Technical newsletter for developers 2020-04

This newsletter was sent in April 2020.

# Much faster payments on phones

Vipps eCom payments using app-switch are now done in the same biometric operation.
There is no longer a need to first log in and then confirm the payment.

This reduces the time it takes to pay with Vipps.

And: Since the "login" is connected to the payment, we have better logging and
more data, so _if_ something goes wrong, we can fix it faster.

# POS integration

Point Of Sale (POS) integrations are now possible with the eCom API.

See
[the product page](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/)
and the
[Frequently Asked Questions for POS integrations](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#frequently-asked-questions-for-pos-integrations).

# eCom: skipLandingPage

If there is no way to show the Vipps landing page, it can be skipped.

This may be useful for POS integration, vending machines, etc.
See
[Skip landing page](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#skip-landing-page)
for details.

# eCom: Cancel pending payments

The `/cancel` endpoint may now also be called _before_ the payment has been
reserved, meaning before the user has accepted/rejected in Vipps. This may be
useful in face-to-face situations where a customer's phone runs out of battery.

See
[Cancelling a pending order](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#Cancelling-a-pending-order).

# User details

The user details provided by
[Vipps Hurtigkasse](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
and
[Vipps Login](https://www.vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
will (very soon) use the same data formats.

"Star" the eCom repo on GitHub to get updates on this (and other things):
https://github.com/vippsas/vipps-ecom-api


# eCom: `/approve` endpoint for integration tests

A new
[`/approve`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#testing)
endpoint makes it possible to approve payments through the API,
without using the app.

# New developer pages on vipps.no

We now offer nicely formatted and Vipps-branded developer pages at
https://vipps.no/developer.

The pages are automatically generated from the GitHub repos, so the
content is the same, and you can choose what to use.

We are just getting started, and
[feedback](https://github.com/vippsas/vipps-developers/blob/master/contact.md)
is very welcome. We know there are some (minor?) issues, please bear with us.

# API documentation in HTML format with Slate

We now offer generated HTML documentation in three formats for most APIs.
Examples for the eCom API:

* Swagger UI: https://vippsas.github.io/vipps-ecom-api/
* ReDoc: https://vippsas.github.io/vipps-ecom-api/redoc.html
* Slate: https://vippsas.github.io/vipps-ecom-api/slate/

[Feedback](https://github.com/vippsas/vipps-developers/blob/master/contact.md)
is very welcome.

# How it works

We have made some more in-depth product information pages with screenshots:

* eCom (Vipps på Nett): https://vipps.no/developers-documentation/ecom/how-it-works/
* Recurring: https://vipps.no/developers-documentation/recurring/how-it-works/

# Plugin overview

We now have plugins for WordPress/WooCommerce, Magento, Episerver, Shopify, Drupal:
https://github.com/vippsas/vipps-developers#plugins

We have some more candidates too.

# Reminders

We have mentioned some things before, and take this opportunity to remind you:

## API lifecycle

Our API lifecycle policy is
[available on GitHub](https://github.com/vippsas/vipps-developers/blob/master/vipps-api-lifecycle.md).

## Status pages for test and production environments

* Test: https://vipps-test.statuspage.io
* Production: https://vipps.statuspage.io

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
