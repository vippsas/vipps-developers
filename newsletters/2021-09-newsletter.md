<!-- START_METADATA
---
title: Technical newsletter for developers 2021-09
sidebar_label: 2021-09
sidebar_position: 75
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Technical newsletter for developers 2021-09

This newsletter was sent in September 2021.

<!-- START_COMMENT -->

## Table of Contents

- [The Vipps QR API](#the-vipps-qr-api)
- [The Vipps Order Management API](#the-vipps-order-management-api)
- [The Vipps Merchant Management API](#the-vipps-merchant-management-api)
- [Vipps Login support for authentication/registration outside of browser/app (CIBA)](#vipps-login-support-for-authenticationregistration-outside-of-browserapp-ciba)
- [The Vipps Recurring API now supports variable amounts](#the-vipps-recurring-api-now-supports-variable-amounts)
- [API Dashboard for the test environment](#api-dashboard-for-the-test-environment)
- [Removed HTTP 402 errors](#removed-http-402-errors)

<!-- END_COMMENT -->

## The Vipps QR API

An early version of the
[Vipps QR API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/qr-api)
is available.

The Vipps QR API lets merchants generate Vipps QR codes that can be used to pay
over the counter, without requiring the Vipps user to provide their telephone
number to the merchant.

The QR code, when scanned and opened, will redirect the user to the Vipps
landing page, which on the phone will automatically trigger a switch to the
Vipps app where they can pay the merchant.

## The Vipps Order Management API

An early version of the
[Vipps Order Management API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/order-management-api)
is available.

The Order Management API allows merchants to send rich receipt information to
existing Vipps transaction. This information is shown to the customer in the
app in their order history. This functionality is available for both recurring
and direct payments, but not for pass-through payments.

## The Vipps Merchant Management API

An early version of the
[Vipps Merchant Management API](https://github.com/vippsas/vipps-merchant-management-api)
is available on GitHub:

The Vipps Merchant Management API will let partners, banks and large corporations
manage their merchants and sales units. See the GitHub repository for
background and priorities.

## Vipps Login support for authentication/registration outside of browser/app (CIBA)

The Vipps Login service has been extended with Client Initiated Backchannel Authentication
(CIBA) flows to support use cases where authentication/registration does not start in a browser or an app.

This could typically be physical contexts like point of sales (POS) solutions, on the
phone in call center solutions, or devices/terminals like TV boxes. We currently support initiating logins based on the users phone number. We are also working on supporting the same flows with the user scanning the merchant's QR-code as a starting point.

More information can be found in the
[Vipps Login API Guide](https://vippsas.github.io/vipps-developer-docs/docs/APIs/login-api).

## The Vipps Recurring API now supports variable amounts

Recurring agreements with variable amount lets merchants charge users a different amount each for interval, based on the user's specified max amount.

More information can be found in the
[Vipps Recurring API Guide](https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api/vipps-recurring-api#recurring-agreements-with-variable-amount).

## API Dashboard for the test environment

The API Dashboard is now available for both the production and test environments.
See it on
[portal.vipps.no](https://portal.vipps.no)
under the "Utvikler" ("Developer") tab.
Here's an example:

![API dashboard login data](images/2021-06-api-dashboard-login-example.png)

## Removed HTTP 402 errors

The Vipps eCom API previously sent `HTTP 402 Payment Required` for some errors.
That HTTP status is "reserved for future use", and our use was a bit .. creative.

We now send `HTTP 400 Bad Request` instead, with more details in the message body.

Since this is _still_ an error that can and must be fixed by the merchant,
we have concluded that the change does not require a new version of the API.

## Newsletter archive

All the previous newsletters are in the
[newsletter archive](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters).

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).
