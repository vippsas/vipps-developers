<!-- START_METADATA
---
title: Technical newsletter for developers 2023-02
sidebar_label: 2023-03
sidebar_position: 66
pagination_next: null
pagination_prev: null
draft: true
---
END_METADATA -->

# Technical newsletter for developers 2023-03

💥 DRAFT! 💥

This newsletter was sent in March 2023.

<!-- START_COMMENT -->

## Table of Contents

* [Is this is the first time you receive this newsletter?](#is-this-is-the-first-time-you-receive-this-newsletter)
* [ePayment API](#epayment-api)
* [Webhooks API](#webhooks-api)
* [eCom API and Express Checkout](#ecom-api-and-express-checkout)
* [Improved shipping options in Vipps Checkout](#improved-shipping-options-in-vipps-checkout)
* [More Solutions and best practices](#more-solutions-and-best-practices)
* [Report API](#report-api)
* [Reminders](#reminders)
  * [Please check your API calls for errors](#please-check-your-api-calls-for-errors)
* [Questions or comments?](#questions-or-comments)

<!-- END_COMMENT -->

## Is this is the first time you receive this newsletter?

All Vipps customers that have API access now receive this technical newsletter,
with important information about the
[Vipps APIs](https://vippsas.github.io/vipps-developer-docs/docs/APIs)
you have access to.
The newsletter is sent 5-10 times a year. See the
[Newsletter archive](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters).

## ePayment API

The ePayment API is the successor of the eCom API. The main benefits are:
* Designed based on years of experience with the eCom API
* Supports different flows, like direct push and pay by QR code, out-of-the-box without the "hacks" required in the eCom API
* Supports long-lived payments (payment requests from merchants) that are valid up to 28 days
* Supports free-standing card payments: Pay with VISA and MasterCard without the Vipps app
* Uses the Webhooks API to send information back to the merchant/partner

We strongly recommend that all new integrations use the
[ePayment API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/epayment-api), not the
[eCom API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api).
The ePayment API is redesigned from scratch, based on everything we have learned through the
eCom API over several years.

The
[ePayment API specification](https://vippsas.github.io/vipps-developer-docs/api/epayment)
has been ready for some time, and now
we have also updated the
[API guide, FAQ, etc](https://vippsas.github.io/vipps-developer-docs/docs/APIs/epayment-api).

**Please note:** The eCom API will still be available for a long time, but new development will
be for the ePayment API.

## Webhooks API

This API lets merchant receive information from Vipps about payment updates, etc.

See: [Webhooks API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/webhooks-api).

## eCom API and Express Checkout

The new express checkout flow (`"useExplicitCheckoutFlow": true`) is now the only possible
flow.
This ensures that the user gets the item delivered to the right place in the right way.

See the FAQ:
[Express checkout: Old and new flow](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api-faq#express-checkout-old-and-new-flow).

## Improved shipping options in Vipps Checkout

It is essential that you provide your customers their preferred shipping method.
[Vipps Checkout](https://vippsas.github.io/vipps-developer-docs/docs/APIs/checkout-api)
now supports all major shipping providers in the Norwegian market, including:

* Bring/Posten
* Postnord
* Porterbuddy
* Helthjem
* Instabox

See
[How it works for shipping](https://vippsas.github.io/vipps-developer-docs/docs/APIs/checkout-api/vipps-checkout-how-it-works-shipping)
for more details, and try for yourself in our
[demo store](https://demo.vipps.no/vipps-checkout-1/full).

## More Solutions and best practices

You can now see how Vipps APIs can be used and combined to give the best
user experience for vending machines, taxis, QR codes, and more.

See: [Solutions](https://vippsas.github.io/vipps-developer-docs/docs/vipps-solutions).

## Report API

The Vipps Report API is now available. It is a REST API providing data about
payments in JSON format. See the
[API documentation](https://vippsas.github.io/vipps-developer-docs/docs/APIs/report-api).

## Reminders

### Please check your API calls for errors

We are working on eliminating incorrect API use. Please:

* Monitor the responses you get when making API calls
* Log all errors
* Fix errors as quickly as possible
* Use the
  [API Dashboard](../developer-resources/api-dashboard.md)
  to find problems with your integration.

![API Dashboard example](images/2021-02-api-dashboard-example.png)

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).
