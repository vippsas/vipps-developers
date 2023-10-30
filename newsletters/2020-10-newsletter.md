---
title: Technical newsletter for developers 2020-10
sidebar_label: 2020-10
sidebar_position: 277
pagination_next: null
pagination_prev: null
---


# Technical newsletter for developers 2020-10

This newsletter was sent in October 2020.

## Userinfo

Vipps now offers the possibility for merchants to ask for user profile details as part of the payment flow in the
[eCom API v2](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#userinfo)
and
[Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api#userinfo).

This is done by adding a `scope` parameter to the initiate calls:

* address
* birthDate
* email
* name
* phoneNumber
* nin (fødselsnummer)
* accountNumbers

The userinfo endpoint is shared with
[Vipps Login](https://developer.vippsmobilepay.com/docs/APIs/login-api)
and the merchant needs to have
activated Vipps Login on their account to use this feature. Information on how
to do this can be found
[here](https://developer.vippsmobilepay.com/docs/APIs/login-api/login-api-faq#how-can-i-activate-and-set-up-vipps-login).
Using the Vipps Login service itself is optional.

### Customer registration

Vipps Login can also be used if you need to register your customers because of
the Covid-19 pandemic. See our information in Norwegian:
[https://vipps.no/om-oss/nyheter/vipps-innsjekk-for-serveringssteder/](https://vipps.no/om-oss/nyheter/vipps-innsjekk-for-serveringssteder/).

## New plugins

There are now 12 Vipps plugins for various ecommerce platforms:
WooCommerce, WordPress, Magento, Episerver, Drupal, Shopify, Craft and more.

All [plugins](https://developer.vippsmobilepay.com/docs/plugins) are open source. See the complete list.

## PSP v3

Vipps MobilePay is launching the
[PSP API v3](https://developer.vippsmobilepay.com/docs/APIs/psp-api)
to coincide with our migration of our users' cards from PAN to EMVco network
tokens. This technological migration is Vipps' strategy for achieving delegated
SCA once PSD2 comes into effect for card payments on January 1, 2021.

The PSP API v3 is functionally identical to PSP API v2 apart from the
additional payment source format. There are also minor changes to naming of
properties to bring the API in line with Vipps' API standards.

Encrypted cards will still be sent for our users cards that have not yet been
migrated. Please see our [migration guide](https://developer.vippsmobilepay.com/docs/APIs/psp-api/v2-deprecation).

## Rate limiting

Vipps has implemented rate limiting on our external APIs in order to offer a
more robust and secure service. Most of these limits are only created to
counteract unexpected and erratic behavior, and it's nothing you should notice
under normal operation. More information about this is available in the
documentation for
[Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api#rate-limiting)
and
[eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#rate-limiting)

## Deprecations

### Deprecation of `/status`

The `/details` endpoint in the eCom API v2 offers more than the old
and long deprecated `/status` endpoint. We still see some customers using
the old endpoint and strongly recommend updating to the
[current one](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#get-payment-details).

### Deprecation of Vipps for Magento 1

The
[Vipps Payment Module for Magento 1](https://github.com/vippsas/vipps-magento-v1/blob/master/README.md)
is deprecated because of the high security risk in continued use of Magento 1.

## Reminders

We have mentioned some things before, and take this opportunity to remind you:

### API lifecycle

Our API lifecycle policy is
[available on GitHub](../knowledge-base/api-lifecycle.md).

### Status pages for test and production environments

* Test: <https://vipps-test.statuspage.io>

* Production: <https://vipps.statuspage.io>

### How to get help quickly

Please see
[this page](https://developer.vippsmobilepay.com/docs/contact).

### Newsletter archive

Please see: [newsletters](https://developer.vippsmobilepay.com/docs/newsletters)

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://developer.vippsmobilepay.com/docs/contact).
