---
title: Getting started
sidebar_label: Getting started
sidebar_position: 10
description: Getting started with Vipps MobilePay
pagination_next: null
pagination_prev: null
---

# Getting started

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/getting-started/).
<!-- END_COMMENT -->

When your *Merchant Agreement* is approved and your product order is sent, you
will receive an email with credentials for accessing the
[test environment](test-environment.md):

* Sales unit name
* Merchant serial number
* Credentials for logging into the test app

For information about applying for services, see the
[Applying for services FAQ](./faqs/services.md).

## Start testing in the test environment

You will need the following:

1. A *test user*.
   All merchants automatically get a [test user](test-environment.md#test-users).

1. Test keys.

    Log-in to [portal.vipps.no](https://portal.vipps.no) and get your test API keys, as described in
    [API keys](./common-topics/api-keys.md).

1. The test app.

    Download and install the Merchant Test (MT) app as described in the
    [test apps](./test-environment.md#vipps-test-apps) section.

1. The test server, `apitest.vipps.no`.
    See [test servers](./test-environment.md#test-server) for more information.

1. A tool allowing you to test the API.

    * [curl](https://curl.se/) is a command line tool where you can enter API requests and get responses.

    * [Postman](https://www.postman.com/) has a Graphical User Interface which allows you to build your API requests and save them for later.

      **Please note:** Postman now only supports a cloud version. Many companies don't have permission to save keys in the cloud, as they are very secret and allow for transferring money.

      If you wish to use Postman, we have created collections for the APIs (e.g., [ePayment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/quick-start/)). These can be used to quickly run through the requests after updating a few global variables in the [Vipps MobilePay Global Postman environment](/tools/vipps-api-global-postman-environment.json).


## The production environment

When your product order is approved, you will get an email stating that you can
get access to the API in the production environment.

Log in to
[portal.vipps.no](https://portal.vipps.no)
to get your production
[API keys](./common-topics/api-keys.md).

Now, you can start making API requests to the production server
(e.g., create a payment request that goes to a real user's Vipps or MobilePay app).

## Best practices

It is very important that you check the return response of each API call.
You will get information about potential problems that could cause the customers problems or might cause you to lose money.

We strongly recommend using the
[API Dashboard](./developer-resources/api-dashboard.md)
for detecting errors in the API use, in addition to normal monitoring.
