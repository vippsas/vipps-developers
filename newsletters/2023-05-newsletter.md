<!-- START_METADATA
---
title: Technical newsletter for developers 2023-05
sidebar_label: 2023-05
sidebar_position: 265
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Technical newsletter for developers 2023-05

This newsletter was sent in May 2023.

## SDKs for Vipps Checkout and the ePayment API

There are now SDKs availablew for .NET and Node.

- SDKs: https://developer.vippsmobilepay.com/docs/SDKs/
- Vipps Checkout: Product information (Norwegian): https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/checkout/
- Vipps Checkout API: https://developer.vippsmobilepay.com/docs/APIs/checkout-api

## Migration guide for integrations using the MobilePay APIs

We have collected information for how to migrate from the Mobilepay APIs to the new
common Vipps MobilePay APIs, which will be the common "one platform" for all markets:

- https://developer.vippsmobilepay.com/docs/vipps-developers/mp-migration-guide

## Reminders

### Please check your API calls for errors

We are working on eliminating incorrect API use to ensure the best possible user
experience for all Vipps users and merchants. 

API typically result in your customers thinking that "Vipps doesn't work",
and may mean that you lose money. Please make sure you use our APIs in the best way:

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

All previous newsletters are in the
[newsletter archive](https://developer.vippsmobilepay.com/docs/vipps-developers/newsletters).
