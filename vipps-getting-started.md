<!-- START_METADATA
---
title: Getting started
sidebar_position: 2
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Getting started

Hello and welcome to Vipps!

Get started integrating your business with Vipps by [applying for Vipps services](#apply-for-vipps-services).
After that, you can [start testing](#start-testing) and [implementing best practices](#implement-best-practices).

## Apply for Vipps services

You can apply for Vipps services on [portal.vipps.no](https://portal.vipps.no).
See
[Requirements for applying for a Vipps service](./common-topics/requirements.md).

**Please note:** If you plan to use Vipps through a PSP, you must
order the Vipps solution from the PSP.
They will also help you with developer access to their systems.

Vipps is required to perform a background check on all merchants who want to use Vipps services, so it might take a few days before you hear back from us.
You can check the status of your application on [portal.vipps.no](https://portal.vipps.no) or
by contacting [customer service](https://www.vipps.no/kontakt-oss/bedrift/).

You can start getting familiar with the products and preparing for placing an order.
Here are the most common API products:

- [eCom API (_Vipps På Nett_)](/docs/APIs/ecom-api) - Allow your customer to pay with Vipps on your website or app.
- [Recurring API (_Vipps Faste Betalinger_)](/docs/APIs/recurring-api) - Allow your customers to set up recurring payments (e.g., for subscriptions, membership dues, parking fees, etc.) through Vipps.
- [Login API (_Vipps Logg Inn_)](/docs/APIs/login-api) - Allow your customer to log in to your site by using their Vipps account.

See [Vipps APIs](/docs/APIs) for a complete list of API products.

For a Norwegian overview of the products, see [vipps.no: Produkter og tjenester](https://vipps.no/produkter-og-tjenester/bedrift/).

When the _Merchant Agreement_ is approved and your product order is sent,
you (or the user associated with the order) will receive an email
with the name and serial number of your test sales unit, along with credentials for logging into the
Vipps Merchant Test (MT) app. Now, you can start testing with the Vipps APIs.

When your product order is approved, you will get an email stating that you can
get your production [API keys](./common-topics/api-keys.md) on [portal.vipps.no](https://portal.vipps.no).
These will allow you to start running API commands against the production server (e.g., create a payment request that goes to a real user's Vipps app).

## Start testing

Start by [getting your API keys](./developer-resources/portal.md#how-to-find-the-api-keys).
You will need these for providing authentication when sending Vipps API requests.
For more information about the keys, see the [API keys](./common-topics/api-keys.md) page.

You can download and install the Vipps test app as described in the [Vipps test apps](./test-environment.md#vipps-test-apps) section.
Once this is done, you will be able to send Vipps API requests to the [test server address (apitest.vipps.no)](./test-environment.md#test-server)
and respond by using the Vipps Merchant Test (MT) app. Learn more about the Vipps Merchant Test (MT) app on the [Vipps Merchant Test (MT)](test-environment.md) page.

To experiment with sending requests (e.g., create payment, cancel payment, refund payment), [Postman](https://learning.postman.com/docs/getting-started/introduction/) is a good alternative. We have several API-specific [quick start guides using Postman](quick-start-guides.md) to help you get started.

## Implement best practices

It is very important that you check the return response of each API call.
You will get information about potential problems that could cause the customers problems or might cause you to lose money.

We strongly recommend to use the [API Dashboard](./developer-resources/api-dashboard.md) for detecting errors in the API use,
in addition to normal monitoring.
