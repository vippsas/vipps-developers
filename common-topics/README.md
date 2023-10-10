---
sidebar_label: Overview
sidebar_position: 40
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---

# Knowledge base

In this section, you'll find a lot of general information relating to the APIs.

## API basics

* [API keys](api-keys.md) - Where to find your credentials.
* [Authentication](authentication.md) - How to get authentication for API requests.
* [HTTP headers](http-headers.md) - Headers to use in all your API requests.
* [Error formats](errors.md) - The standard response body format for our error messages.
* [HTTP response codes](http-response-codes.md) - HTTP statuses returned in API responses.

## General information

* [Direct integration and PSP integration](direct-vs-psp.md) - The differences between integrating the Vipps MobilePay APIs directly or implementing the PSP API.
* [API lifecycle](api-lifecycle.md) - General advice about API versioning and deprecation.

## User experience

* [Landing page](landing-page.md) - The landing page which opens in a browser and prompts the user to enter their phone number.
* [Payment screen](payment-screen.md) - The payment request screen and receipt details in the Vipps MobilePay app.

## Payment concepts

* [Reserve and capture](reserve-and-capture.md) - The difference between reserving and capturing a payment.
* [Cancellations](cancel.md) - Ways to cancel a payment.
* [Refunds](refund.md) - Notes about payment refunds.
* [Polling guidelines](polling-guidelines.md) - Guidelines for using polling.
* [Timeouts](timeouts.md) - Standard timeouts for payment requests.

## Detailed technical recommendations

* [Recommendations for payment description and transaction text](transactiontext.md)
* [Recommendations for reference and orderId](orderid.md)
* [Redirects](redirects.md) - Redirecting users to your website.
* [URL validation](url-validation.md) - Details surrounding URL validation in the eCom and PSP APIs.
* [isApp](isApp.md) - The `isApp` payment flow in the eCom and Recurring API.
