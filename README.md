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
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

The Vipps APIs provide access to the following types of transactions.

In-person and remote transactions:

- _Vipps Checkout (Vipps Checkout)_ - A complete Checkout solution for both Vipps and card payments with auto-fill and shipping integrations.

In-person transactions:

- _Vennebetaling (Person to Person payments)_ - A person can transfer money to another person. They must both have configured their Vipps app with their respective bank account numbers. There is no API.

- _Vippsnummer (Vipps number)_ - An organization or company can receive an identification number from Vipps. Customers can then register their payments to this number. This gives people the possibility of paying or donating money without cash. There is no API.

- _Vipps i kassa (Vipps In Store)_ - A company can integrate its Point of Sale (POS) system with Vipps so that in-store customers can pay by using Vipps, and the sale will be automatically registered in their system.

Remote transactions:

- _Vipps Logg Inn (Vipps Login)_ - A website or app can allow the customer to log in by using their Vipps account.

- _Vipps på nett (Vipps Online)_ - An online store or app can offer Vipps as a method of payment.

- _Vipps Hurtigkasse (Vipps Express Checkout)_ - An online store can offer a quick checkout option where Vipps is the method of payment and the shipping options are specified directly from the Vipps app.

- _Faste betalinger (Recurring payments)_ - A business or organization can allow their customers to set up recurring payments (e.g., for subscriptions, membership, regular donations, etc.) through Vipps.

Vipps provides several open source plugins for various web solutions.
See our [Plugins section](https://vippsas.github.io/vipps-developer-docs/docs/vipps-plugins/).

To learn about integrating with Vipps, proceed to [Getting started](vipps-getting-started.md).

## API products

The `Vipps-API` product gives you access to the majority of Vipps APIs, for example:

- [Access Token API](vipps-getting-started.md#get-an-access-token)- Required to obtain a JWT
- [Checkout API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/checkout-api/) - Checkout API
- [eCom API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/) - eCommerce, including express checkout
- [ePayment API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/epayment-api/) - New version of eCom API
- [Login API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/login-api/) - Identification
- [Order Management API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/order-management-api/) - Add data to orders
- [Partner API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/partner-api/) - Get info about merchants/sale units
- [PSP API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/psp-api/) - Initiate PSP payments. Update merchants
- [QR API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/qr-api/) - QR codes
- [Recurring API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api/) - Recurring API

**Please note:** API keys are _not_ available for
[Vippsnummer](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/),
as there is no external API.

For an overview of all products, in Norwegian, see [vipps.no](https://vipps.no/produkter-og-tjenester/bedrift/).

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](contact.md).

Sign up for our [Technical newsletter for developers](newsletters/README.md).
