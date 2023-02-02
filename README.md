<!-- START_METADATA
---
title: Introduction
sidebar_position: 1
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Vipps Developer Information

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers).

<!-- END_COMMENT -->

## API products

The `Vipps-API` product gives you access to the majority of Vipps APIs, for example:

- [Access token API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/access-token-api)- Required to obtain a JWT.
- [Check-in API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/check-in-api) - Communicate with users through their Vipps app from the Point of Sale (POS).
- [Checkout API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/checkout-api) - Provide a complete Checkout solution for both Vipps and card payments with auto-fill and shipping integrations.
- [eCom API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api) - Offer Vipps as a method of payment. Offer a quick checkout option where Vipps is the method of payment and the shipping options are specified directly from the Vipps app. This is also known as Vipps Online (_Vipps På Nett_) and Vipps Express Checkout (_Vipps Hurtigkasse_).
- [ePayment API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/epayment-api) - In combination with Checkout API, apply payments, -This is the new version of eCom API.
- [Login API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/login-api) - Allow the customer to log in by using their Vipps account.
- [Order management API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/order-management-api) - Add data to orders.
- [Partner API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/partner-api) - Get info about merchants/sale units.
- [PSP API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/psp-api) - Initiate PSP payments. Update merchants.
- [QR API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/qr-api) - Use QR codes to allow customers to connect to Vipps and purchase from your store.
- [Recurring API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api) - A business or organization can allow their customers to set up recurring payments (e.g., for subscriptions, membership, regular donations, etc.) through Vipps. This is also known as _Vipps Faste Betalinger_.
- [Report API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/report-api) - Fetch information about payment events that have been processed by Vipps.

**Please note:** API keys are _not_ available for
[Vippsnummer](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/),
as there is no external API.

For an overview of all products, in Norwegian, see [vipps.no](https://vipps.no/produkter-og-tjenester/bedrift/).
Start your journey in the [Getting Started](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/vipps-getting-started) page.
This is where you learn about the API keys, test environments, and how to make calls.

## Getting started

Quick links:

* [Getting started guide](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/vipps-getting-started) - General information about developing with Vipps.
* [Vipps test environment](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/test-environment) - Install the test app.

Dive deeper with:

* [Developer resources](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/developer-resources) - API dashboard, demo store, design guidelines, Vipps portal, status pages, etc.
* [Common API topics](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/common-topics) - API keys, API lifecycle, authentication, HTTP headers, polling guidelines, reserve and capture, userinfo, Vipps landing page, etc.
* [Frequently asked questions](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/faqs) - Requirements, common problems, refunds, users and payments, Vipps landing page, problems for end users, etc.

Vipps provides several open source plugins for various web solutions.
See our [Plugins section](https://vippsas.github.io/vipps-developer-docs/docs/vipps-plugins).
For information about partners, see our [Partner section](https://github.com/vippsas/vipps-partner#vipps-partners).
