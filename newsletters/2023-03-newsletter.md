---
title: Technical newsletter for developers 2023-03
sidebar_label: 2023-03
sidebar_position: 266
pagination_next: null
pagination_prev: null
---

# Technical newsletter for developers 2023-03

This newsletter was sent in March 2023.

## New to the technical newsletter?

You’re receiving this newsletter because you have admin privileges on
[portal.vipps.no](https://portal.vipps.no)
for a merchant with access to
[Vipps APIs](https://developer.vippsmobilepay.com/docs/APIs).

We strongly advise all technical resources to subscribe to the newsletter. If you
don’t subscribe, you will not receive this newsletter again.

👉 **[Subscribe to the newsletter here](https://cloud.melding.vipps.no/utv)** 👈

In this newsletter, we share information about changes and updates to APIs,
new functionality, and other important information to ensure that your Vipps solutions run
smoothly.

The newsletter is sent at irregular intervals, when there is important
information to share. In 2022, we sent six newsletters.

Like all our
[developer documentation](https://developer.vippsmobilepay.com/),
the newsletter is in English. This makes
it easier to forward to all developers and technical resources.

See:
[Newsletter information and archive](https://developer.vippsmobilepay.com/docs/vipps-developers/newsletters).

## ePayment API

The new [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
is designed from scratch, based on everything we have
learned through the [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
over several years. The main benefits are:

* Support for different flows, like paying by QR code, out-of-the-box without the "hacks" required in the eCom API
* Support for long-lived payments (payment requests from merchants) that are valid up to 28 days
* Support for freestanding card payments where you can pay with VISA and MasterCard without the Vipps app
* Webhooks to always reliably send information back to the merchant or partner

We strongly recommend that all new integrations use the
[ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api), not the
eCom API.

The
[ePayment API specification](https://developer.vippsmobilepay.com/api/epayment)
has been ready for some time, and now we have also updated the
[API guide, FAQ, etc](https://developer.vippsmobilepay.com/docs/APIs/epayment-api).

**Please note:** The eCom API will still be available for a long time, but new
development will be for the ePayment API.

## Webhooks API

The [Webhooks API](https://developer.vippsmobilepay.com/docs/APIs/webhooks-api)
allows merchants to receive information from Vipps about when a payment has
been authorized, cancelled, expired, etc.

Merchants register one API endpoint and specify which events they want to receive.
If an event is not delivered successfully, it will be retried multiple times.

See: [Webhooks API](https://developer.vippsmobilepay.com/docs/APIs/webhooks-api).

## Recurring API: Look up agreements by charge

The new endpoint
[`GET:/charges/{chargeId}`](https://developer.vippsmobilepay.com/api/recurring)
makes it possible to retrieve a charge specified by `chargeId`,
without knowing the `agreementId`. The resulting charge now contains the `agreementId`.
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

In the [Solutions](https://developer.vippsmobilepay.com/docs/vipps-solutions) section of the documentation,
you can now see how Vipps APIs can be combined to give the best user experience for several use cases, such as:

* Electric vehicle charging
* Loyalty at Point of Sale (POS)
* Static QR codes at POS
* Parking and "pay as you go"
* Taxi companies
* Vending machines

See: [Solutions](https://developer.vippsmobilepay.com/docs/vipps-solutions).

## Report API

The [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api)
gives you, or a third-party acting on your behalf, the ability to
fetch information about payment events that have been processed by Vipps.
It is a REST API providing data in JSON format.

See the
[API documentation](https://developer.vippsmobilepay.com/docs/APIs/report-api).

## Change of IP addresses

We will soon change the IP addresses for the publicly available servers.
Make sure you follow the documentation for DNS, etc.:
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
