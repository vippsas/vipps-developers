<!-- START_METADATA
---
title: Quick start guides
sidebar_position: 15
---
END_METADATA -->

# Quick start guides

<!-- START_TOC -->

## Table of Contents

* [Quick start guides](#quick-start-guides)
* [Test accounts](#test-account)
* [Getting started with Postman](#getting-started-with-postman)
  * [Download Postman](#download-postman)
  * [Import collections and environments](#import-collections-and-environments)
  * [Update the environment values](#update-the-environment-values)
  * [Tabs](#tabs)
* [Questions?](#questions)

<!-- END_TOC -->

Document version: 4.1.2.

## API quick start guides

We have quick start guides for these APIs: [eCom API](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-quick-start.md), [Recurring API](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api-quick-start.md), [Login API](https://github.com/vippsas/vipps-login-api/blob/master/vipps-login-api-quick-start.md), [Partner API](https://github.com/vippsas/vipps-partner-api/blob/main/vipps-partner-api-quick-start.md), [PSP API](https://github.com/vippsas/vipps-psp-api/blob/master/vipps-psp-api-quick-start.md), [QR API](https://github.com/vippsas/vipps-qr-api/blob/main/vipps-qr-api-quick-start.md).

By following the steps detailed in each quick start guide, you can make calls to all the
endpoints, and see the full `request` and `response` for each call.

All of these are based on Postman, which we have some information about below.

## Test account

In order to run the postman examples, you will need a test merchant account.
If you haven't already set this up, see [Test Merchants](vipps-test-environment#test-merchants).

## Getting started with Postman

[Postman](https://www.getpostman.com/) is a common tool for working with REST APIs.
We offer a postman collection to make development easier.

With Postman, you can make calls to all the API endpoints and see the full
request and response for each call, including headers.

When contacting us about API issues, we are usually able to help faster if you send us
the complete request and response.

### Download Postman

You don't need to sign-up for Postman. Just download the Postman app from <https://www.postman.com/downloads/>.
Don't use the web version because we should never save our keys on the web.

### Import collections and environments

Once you have installed Postman, you can import an environment from one our our APIs and then customize it for your own use.

1. To import the collection or environment, save the file to your desktop. Then, click the *Import* button in the Postman interface:
   ![Postman import](images/postman-import.png)
2. Select the file(s) and click *Open*.

### Update the environment values

The Postman environments comes pre-filled with some values, but there are still
some required values which have to be manually entered. These are described in the quick start guide for each API.

### Tabs

Some methods require a `body` with information that is sent with the request.
Vipps provides pre-populated test data, but this can be modified.

You might want to make the same request from your own application. You can
generate snippets of code in various languages that will help you do this.
Click the Code link to open the "Generate code snippets" modal.

![Vipps Developer Postman: Tabs](images/postman-tabs.png)

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
