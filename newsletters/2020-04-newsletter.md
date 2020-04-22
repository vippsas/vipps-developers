# Technical newsletter for developers 2019-11

**Draft:** This newsletter for April 2020.

# Much faster payments

Vipps eCom payments are confirmed without first logging in to the app:
The login and payment confirmation is done with the same biometric operation.

This dramatically reduces the time it takes to pay with Vipps.

Even though we are talking seconds, it adds up: A quick estimate indicates
that Vipps users save a total of _one year_ each month because of faster payments.

Another benefit is that better logging and more data, so
_if_ something goes wrong, we can find out more, and fix the problem.

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
in the documentation for details.

# eCom: Cancel before reservation

The `/cancel` endpoint may now be called before the payment has been reserved.
This may be useful in face-to-face situations where a customer's phone runs out of battery.

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

The content is the same as on GitHub.

We are just getting started, and
[feedback](https://github.com/vippsas/vipps-developers/blob/master/contact.md)
is very welcome. We know there are some (minor?) issues, please bear with us.

# How it works

We have made some more in-depth product information with screenshots:

* eCom (Vipps på Nett): https://vipps.no/developers-page/ecom/how-it-works/
* Recurring: https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api-howitworks.md

# Plugin overview

We have plugins for WordPress/WooCommerce, Magento, Episerver, Shopify, Drupal:
https://github.com/vippsas/vipps-developers#plugins

We have some more candidates too.

# Reminders

We have mentioned this before, and take the chance to remind you:

## API lifecycle

Just a reminder: Our API lifecycle policy is available here:
[available on GitHub](https://github.com/vippsas/vipps-developers/blob/master/vipps-api-lifecycle.md).

## Status pages for test and production environments

* Test: https://vipps-test.statuspage.io
* Production: https://vipps.statuspage.io

## How to get help quickly

Please see
[this page](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

# Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
