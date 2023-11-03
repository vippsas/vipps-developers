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

Vipps and MobilePay payment methods can be added to your online store or Point of Sale.

To test the products beforehand, see
[Do you want to test our products](https://vippsmobilepay.com/merchant-test-account-sign-up).

## Apply for services

To apply for services in Norway, Denmark, or Finland, see the links below:

* [Register as a Vipps merchant in Norway](./knowledge-base/applying-for-services.md#using-vipps-in-norway)
* [mobilepay.dk: Register as a MobilePay merchant in Denmark](https://mobilepay.dk/hjaelp/mobilepay-til-erhverv/mobilepay-portalen/mobilepay-portalen/jeg-er-ny-kunde-hvordan-bestiller-jeg-mobilepay#scroll)
* [mobilepay.fi: Register as a MobilePay merchant in Finland](https://mobilepay.fi/yrityksille/turvallisuus/yrityksen-rekisteroityminen)

## Select your product

There are APIs for handling payments (*ePayment API*),
creating checkout sessions (*Checkout API*), establishing recurring agreements (*Recurring API*),
and logging the user in to your website with their Vipps or MobilePay credentials (*Login API*).
You can get a description of the API products in the [*API platform*](https://developer.vippsmobilepay.com/docs/APIs/)
section.

Order your products on [portal.vipps.no](https://portal.vipps.no).

## Get familiar with docs

Have a look at the API guide for your new product.
For example, if you ordered *Vipps på Nett*, see the
[ePayment API guide](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/) with
example user flows from purchase to payment transfer.

You will also find general information that applies to several APIs in the
[*Knowledge base*](./knowledge-base/README.md).
For example, to learn how to find your API keys, see *Knowledge base* > *API basics* > 
[*API keys*](./knowledge-base/api-keys.md).

## Get your credentials

When your *Merchant Agreement* is approved and your product order is sent, you
will receive an email with credentials for accessing the
[test environment](test-environment.md):

* Sales unit name
* Merchant serial number
* Credentials for logging into the test app

You can also find your keys on [portal.vipps.no](https://portal.vipps.no).
For a description of how to find your keys, see [API keys](./knowledge-base/api-keys.md).

## Start testing in the test environment

You will need the following:

1. A *test user*.
   All merchants automatically get a [test user](test-environment.md#test-users).

1. Test keys.

    Log-in to the [merchant portal](https://portal.vipps.no) and get your test API keys, as described in
    [API keys](./knowledge-base/api-keys.md).

1. The test app.

    Download and install the Merchant Test (MT) app as described in the
    [test apps](./test-environment.md#test-apps) section.

1. The test server, `apitest.vipps.no`.
    See [test servers](./test-environment.md#test-server) for more information.

1. A tool allowing you to test the API.

    * [curl](https://curl.se/) is a command line tool where you can enter API requests and get responses.

    * [Postman](https://www.postman.com/) has a Graphical User Interface which allows you to build your API requests and save them for later.

      **Please note:** Postman now only supports a cloud version. Many companies don't have permission to save keys in the cloud, as they are very secret and allow for transferring money.

      If you wish to use Postman, we have created collections for the APIs (e.g., [ePayment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/quick-start/)). These can be used to quickly run through the requests after updating a few global variables in the [Vipps MobilePay Global Postman environment](/tools/global-postman-environment.json).

When your product order is approved, you will get an email stating that you can
get access to the API in the production environment.

Log in to
[portal.vipps.no](https://portal.vipps.no)
to get your production
[API keys](./knowledge-base/api-keys.md).

## Best practices

It is very important that you check the return response of each API call.
You will get information about potential problems that could cause the customers problems or might cause you to lose money.

We strongly recommend using the
[API Dashboard](./developer-resources/api-dashboard.md)
for detecting errors in the API use, in addition to normal monitoring.
