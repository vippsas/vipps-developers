---
title: Quick start guides
sidebar_label: Quick start guides
sidebar_position: 30
description: A guide for using Postman to test the Vipps MobilePay APIs.
pagination_next: null
pagination_prev: null
---

# Quick start guides

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/vipps-developers/quick-start-guides/).
<!-- END_COMMENT -->

## What you need for testing the API with Postman

1. A *test user*.
   All merchants automatically get a test user. See [test users](test-environment.md#test-users).
2. A *test sales unit*.
   You can create as described in [How to create a test sales unit](./developer-resources/portal.md#how-to-create-a-test-sales-unit).
3. A Vipps test app, *Vipps MT*, for your phone.
   See [Vipps test app](test-environment.md#vipps-test-apps).
4. The Postman application on your computer.
   Download [Postman](https://www.postman.com/downloads/) and install it.
   Don't use the web version, because you should never save your API keys on the web.

## Getting started with Postman

[Postman](https://learning.postman.com/docs/getting-started/introduction/)
is a common tool for working with REST APIs.
It allows you to make calls to the API endpoints and see the full
request and response for each call, including headers.

### Import collections and environments

Our Postman collections contain example API calls that you can run in the test environment.

1. In Postman, click *Import* in the upper-left corner.
1. In the dialog that opens, with *File* selected, click *Upload Files*.
1. Select the two files you have just downloaded and click *Import*.

Use the
[Global Postman environment](/tools/vipps-api-global-postman-environment.json)
with all the APIs.

### Update the environment values

The Postman environments come pre-filled with some values, but there are still
some required values that have to be manually entered. These are described in the quick start guide for each API.

You must normally update the variables to use your API keys: `client_id`,
`client_secret`, `Ocp-Apim-Subscription-Key`, and `merchantSerialNumber`.

### Run API calls

After you have imported and updated the collections and environments, you can begin to run the calls.

There is a sequence to running these, so check in the applicable API quick start guide to see what to run first.

Some methods require a `body` with information that is sent with the request.
Vipps provides pre-populated test data, but this can be modified.

You might want to make the same request from your own application. You can
generate snippets of code in various languages that will help you do this.
Click the Code link to open the "Generate code snippets" modal.

![Developer Postman: Tabs](images/postman-tabs_sm.png)

## Try it out

Choose one of the API quick start guides listed below.
This will lead you through a sequence of steps where you can experiment with every endpoint in the API.

* [Checkout API](https://developer.vippsmobilepay.com/docs/APIs/checkout-api/vipps-checkout-api-quick-start)
* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-quick-start)
* [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/quick-start/)
* [Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api/vipps-login-api-quick-start)
* [Order Management API](https://developer.vippsmobilepay.com/docs/APIs/order-management-api/vipps-order-management-api-quick-start)
* [Partner API](https://developer.vippsmobilepay.com/docs/APIs/partner-api/vipps-partner-api-quick-start)
* [PSP API](https://developer.vippsmobilepay.com/docs/APIs/psp-api/vipps-psp-api-quick-start)
* [QR API](https://developer.vippsmobilepay.com/docs/APIs/qr-api/vipps-qr-api-quick-start)
* [Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api-quick-start)
* [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api/vipps-report-api-quick-start)
