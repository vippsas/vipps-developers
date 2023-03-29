<!-- START_METADATA
---
title: Technical newsletter for developers 2023-03
sidebar_label: 2023-03
sidebar_position: 66
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Technical newsletter for developers 2023-03

This newsletter was sent in March 2023.

<!-- START_COMMENT -->

## Table of Contents

* [New to the technical newsletter?](#new-to-the-technical-newsletter)
* [ePayment API](#epayment-api)
* [Webhooks API](#webhooks-api)
* [Recurring API: Look up agreements by charge](#recurring-api-look-up-agreements-by-charge)
* [eCom API and Express Checkout](#ecom-api-and-express-checkout)
* [Improved shipping options in Vipps Checkout](#improved-shipping-options-in-vipps-checkout)
* [More Solutions and best practices](#more-solutions-and-best-practices)
* [Report API](#report-api)
* [Change of IP addresses](#change-of-ip-addresses)
* [Reminders](#reminders)
  * [Please check your API calls for errors](#please-check-your-api-calls-for-errors)
* [Questions or comments?](#questions-or-comments)

<!-- END_COMMENT -->

## New to the technical newsletter?

You’re receiving this newsletter because you have admin privileges on
[portal.vipps.no](https://portal.vipps.no)
for a merchant with access to
[Vipps APIs](https://developer.vippsmobilepay.com/docs/APIs).

We strongly advise all technical resources to subscribe to the newsletter. If you
don’t subscribe, you will not receive this newsletter again.

**[Subscribe to the newsletter here](https://cloud.melding.vipps.no/utv).**

In this newsletter we share information about changes and updates to APIs,
new functionality, and other important info to ensure your Vipps solutions run
smoothly.

The newsletter is sent at irregular intervals, when there is important
information to share. In 2022 we sent six newsletters.

Like all our
[developer documentation](https://developer.vippsmobilepay.com/),
the newsletter is in English. This makes
it easier to forward to all developers and technical resources.

See:
[Newsletter information and archive](https://developer.vippsmobilepay.com/docs/vipps-developers/newsletters).

## ePayment API

The new ePayment API is designed from scratch, based on everything we have
learned through the eCom API over several years. The main benefits are:

* Supports different flows, like pay by QR code, out-of-the-box without the "hacks" required in the eCom API
* Supports long-lived payments (payment requests from merchants) that are valid up to 28 days
* Supports free-standing card payments: Pay with VISA and MasterCard without the Vipps app
* Uses the Webhooks API to always reliably send information back to the merchant/partner

We strongly recommend that all new integrations use the
[ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api), not the
[eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api).

The
[ePayment API specification](https://developer.vippsmobilepay.com/api/epayment)
has been ready for some time, and now we have also updated the
[API guide, FAQ, etc](https://developer.vippsmobilepay.com/docs/APIs/epayment-api).

**Please note:** The eCom API will still be available for a long time, but new
development will be for the ePayment API.

## Webhooks API

This API lets merchant receive information from Vipps about when a payment has
been authorized, cancelled, expired, etc.

Merchants register one API endpoint, and specify which events it wants to receive.
If an event is not delivered successfully, it will be retried multiple times.

See: [Webhooks API](https://developer.vippsmobilepay.com/docs/APIs/webhooks-api).

## Recurring API: Look up agreements by charge

The new endpoint
[`GET:/charges/{chargeId}`](https://developer.vippsmobilepay.com/api/recurring)
makes it possible to retrieve an agreement specified by `chargeId`,
without knowing the `agreementId`.
Its purpose is to simplify investigations when the merchant lost track of which
charge belongs to which agreement.

See:
[Retrieve a charge](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api#retrieve-a-charge).

## eCom API and Express Checkout

The improved express checkout flow (`"useExplicitCheckoutFlow": true`) is now
the only possible flow. This ensures that the user gets the item delivered to
the right place in the right way.

The `useExplicitCheckoutFlow` parameter no longer has any effect.

See the FAQ:
[Express checkout](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-faq#express-checkout).

## Improved shipping options in Vipps Checkout

It is essential that you provide your customers their preferred shipping method.
[Vipps Checkout](https://developer.vippsmobilepay.com/docs/APIs/checkout-api)
now supports all major shipping providers in the Norwegian market, including:

* Bring/Posten
* Postnord
* Porterbuddy
* Helthjem
* Instabox

See
[How it works for shipping](https://developer.vippsmobilepay.com/docs/APIs/checkout-api/vipps-checkout-how-it-works-shipping)
for more details, and try for yourself in our
[demo store](https://demo.vipps.no/vipps-checkout-1/full).

## More Solutions and best practices

You can now see how Vipps APIs can be combined to give the best user experience for:
* Electric vehicle charging
* Loyalty at Point of Sale (POS)
* Static QR codes at POS
* Parking and "pay as you go"
* Taxi companies
* Vending machines
* .. and more.

See: [Solutions](https://developer.vippsmobilepay.com/docs/vipps-solutions).

## Report API

The Report API gives you, or a third-party acting on your behalf, the ability to
fetch information about payment events that have been processed by Vipps.
It is a REST API providing data in JSON format.

See the
[API documentation](https://developer.vippsmobilepay.com/docs/APIs/report-api).

## Change of IP addresses

We will soon change the IP-addresses for the publicly available servers.
Make sure you follow the documentation for DNS, etc:
[Vipps servers](https://developer.vippsmobilepay.com/docs/vipps-developers/developer-resources/servers).

## Reminders

### Please check your API calls for errors

We are working on eliminating incorrect API use to ensure the best possible user
experience for all Vipps users and merchants. Please:

* Monitor the responses you get when making API calls
* Log all errors
* Fix errors as quickly as possible
* Use the
  [API Dashboard](../developer-resources/api-dashboard.md)
  to find problems with your integration.

![API Dashboard example](images/2021-02-api-dashboard-example.png)

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://developer.vippsmobilepay.com/docs/github)
for the relevant API,
or [contact us](https://developer.vippsmobilepay.com/docs/vipps-developers/contact).
