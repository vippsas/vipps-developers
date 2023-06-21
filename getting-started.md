---
title: Getting started
sidebar_label: Getting started
sidebar_position: 2
description: Getting started with Vipps
pagination_next: null
pagination_prev: null
---

# Getting started

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/vipps-developers/getting-started/).
<!-- END_COMMENT -->

When the *Merchant Agreement* is approved and your product order is sent,
the person who applied will receive an email with credentials for accessing the
[test environment](test-environment.md):

* Sales unit name
* Merchant serial number
* Credentials for logging into the Vipps test app

For information about applying for services, see the
[Applying for services FAQ](./faqs/services.md).

## Start testing in the test environment

1. Get your test keys.

    Log-in to [portal.vipps.no](https://portal.vipps.no) and get your test API keys, as described in
    [API keys](./common-topics/api-keys.md).

1. Get the test app.

    Download and install the Vipps Merchant Test (MT) app as described in the
    [Vipps test apps](./test-environment.md#vipps-test-apps) section.

1. Send Vipps API requests to the test server.

    The test server address is found [here](./test-environment.md#test-server)

    To experiment with sending requests (e.g., create payment, cancel payment, refund payment),
    [Postman](https://learning.postman.com/docs/getting-started/introduction/) is a good alternative.
    We have several API-specific
    [quick start guides using Postman](quick-start-guides.md) to help you get started.

## Use the production environment

When your product order is approved, you will get an email stating that you can
get access to the API in the production environment.

Log in to
[portal.vipps.no](https://portal.vipps.no)
to get your production
[API keys](./common-topics/api-keys.md).

Now, you can start making API requests to the production server
(e.g., create a payment request that goes to a real user's Vipps app).

## Implement best practices

It is very important that you check the return response of each API call.
You will get information about potential problems that could cause the customers problems or might cause you to lose money.

We strongly recommend using the
[API Dashboard](./developer-resources/api-dashboard.md)
for detecting errors in the API use, in addition to normal monitoring.
