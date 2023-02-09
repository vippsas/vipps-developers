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

The first step towards integrating your business with Vipps is to [apply for Vipps services](#apply-for-vipps-services).

The second step is to order the product that you want to use. Here are the most common API products:

- [eCom API (_Vipps På Nett_)](/docs/APIs/ecom-api) - Allow your customer to pay with Vipps on your internet site or app.
- [Recurring API (_Vipps Faste Betalinger_)](/docs/APIs/recurring-api) - Allow your customers to set up recurring payments (e.g., for subscriptions, membership, regular donations, etc.) through Vipps.
- [Login API (_Vipps Logg Inn_)](/docs/APIs/login-api) - Allow your customer to log in to your site by using their Vipps account.

See [Vipps APIs](/docs/APIs) for a complete list of API products.

For a Norwegian overview of the products, see [vipps.no: Produkter og tjenester](https://vipps.no/produkter-og-tjenester/bedrift/).


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

When the _Merchant Agreement_ is approved and a product order is sent,
you (or the user associated with the product order) will receive an email
with the name and serial number for your test sale unit along with credentials for logging into the
Vipps test app.

Then, you will have everything you need to start testing with the Vipps APIs.

When your product order is approved, you will get an email stating that you can
get your production [API keys](./common-topics/api-keys.md) on [portal.vipps.no](https://portal.vipps.no).

## Get set up in the test environment

Start by getting your test sale unit's [API keys](./developer-resources/portal.md#how-to-find-the-api-keys).
You will need these for providing your authentication when running the Vipps API commands.
See [API keys](./common-topics/api-keys.md) for more information.

Download a [Vipps test app](./test-environment.md#vipps-test-apps).
When you run API commands against the [test server](./test-environment.md#test-server),
you will be able to interact by using your Vipps test app.

You will also need a place to run the API commands (e.g., create payment, cancel payment, refund payment). We recommend [Postman](https://learning.postman.com/docs/getting-started/introduction/) and we have several [Quick start guides](quick-start-guides.md) to help you get started.

Learn all about the test environment on the [Vipps test environment (MT)](test-environment.md) page.


## Best practices

It is very important that you check the return response of each API call.
You will get information about potential problems that could cause the customers problems or might cause you to lose money.

We strongly recommend to use the [API Dashboard](./developer-resources/api-dashboard.md) for detecting errors in the API use,
in addition to normal monitoring.

