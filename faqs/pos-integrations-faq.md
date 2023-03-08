<!-- START_METADATA
---
title: FAQ: Point of Sale integration
sidebar_label: POS integrations
sidebar_position: 30
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# FAQ: Point of Sale integration

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

## Table of contents

* [How do I use the one-time payment QR?](#how-do-i-use-the-one-time-payment-qr)
* [How can we be whitelisted for `skipLandingPage`?](#how-can-we-be-whitelisted-for-skiplandingpage)
* [Handling refunds on behalf of other stores](#handling-refunds-on-behalf-of-other-stores)
* [Distance selling from a POS solution](#distance-selling-from-a-pos-solution)
* [What is the process to go live in production?](#what-is-the-process-to-go-live-in-production)
* [Which API keys should I use?](#which-api-keys-should-i-use)
* [Do we need to support callbacks?](#do-we-need-to-support-callbacks)
* [How can I check if a person has Vipps?](#how-can-i-check-if-a-person-has-vipps)
* [How can I save the customer's phone number?](#how-can-i-save-the-customers-phone-number)
* [How can we mass sign up merchants?](#how-can-we-mass-sign-up-merchants)

<!-- END_COMMENT -->

Point Of Sale (POS) is similar to a "cash register".

We will improve this section as we learn more. Please suggest improvements
in [Questions](#questions) below.

## How do I use the one-time payment QR?

This feature is for presenting a QR code for opening a payment request from a
customer-facing screen, so there is no need to manually input the mobile number.

Basic flow:

1. Initiate a Vipps eCom payment (`skipLandingPage` must be set to false)
2. Receive the payment URL as response
3. Post the payment URL to the
   [Vipps QR API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/qr-api)
4. Receive a URL to a QR code in PNG (Portable Network Graphics) format
5. Present the QR code on the customer-facing screen
6. The user scans the QR code with Vipps or camera app
7. The user pays (or cancels the payment) in Vipps
8. The fallback URL is triggered and will be presented on customers mobile phone

**Please note:**
The customer-facing screen will not show the fallback page. We recommend
presenting the result of the payment in some other way on the screen, and
also that an error messages if something went wrong.

If it is not possible for the POS solution to handle a fallback URL you may use one of the following options:

1. Set fallbackURL to be the merchants website
2. Set fallbackURL to be this Vipps hosted static page: [www.vipps.no/thankyoupage/](https://www.vipps.no/thankyoupage/)

See also:

* [QR API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/qr-api)
* [Error codes](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#error-codes)
* [Do we need to support callbacks?](#do-we-need-to-support-callbacks)

## How can we be whitelisted for `skipLandingPage`?

See: [Is it possible to skip the landing page?](vipps-landing-page-faq.md#is-it-possible-to-skip-the-landing-page)

## Handling refunds on behalf of other stores

It may be relevant for enterprise setup, omnichannel, multiple physical stores within the same chain to refund orders on behalf of other stores.

**Prerequisites:**
Stores or a centralized system (e.g. from a headquarter) must have access to all store credentials, or use
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).
Stores must be able to search for `orderId` from other stores or request it from the centralized system.

**User story:** A user buys a product from Store A.
The user then visits Store B to return some goods. Store B wants to be able to refund on behalf of Store A.

**Problem:** Refunds can only be performed by the sales unit where the payment originated from: Store A.

**Recommended solutions:**

**A:**
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
are used for all stores:

Stores must be able to search for `orderId` for payments made in other stores. The cashier can then search and select `orderId` from Store A and click `refund`.  
**Technical:** Use
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
to authenticate, add `Merchant-Serial-Number` from Store A to the request header and original `orderId` to the
[refund](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/refundPaymentUsingPOST) request.

NB: With
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys),
do not let the cashier input `Merchant-Serial-Number` themselves. These must be locked and connected to the store selection to reduce risk of adding the wrong store.

**B:**
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
are not used:

In this case, a centralized system needs to store credentials from all sales units within the enterprise.
Store B must be able to request a `refund` from the central system based on the original `orderId` and location for the order origin (Store A).
**Technical:** Use Store A credentials to authenticate, add original `orderId` to the
[refund](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/refundPaymentUsingPOST)
request.

**C:** Same sales unit is used for all locations:

It is possible to use one sales unit (one MSN) for all stores and use a prefix in the `orderId` to identify which orders belong to which sales units.
This will result in having one settlement for all. You decide what the `orderId` contains, and it may be up to 50 characters.
See: [orderId recommendation](../common-topics/orderid.md).
You will use the same API keys for all stores.

## Distance selling from a POS solution

Due to compliance requirements in a payment situation where customer is not present, we recommend implementing the
[Order management API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/order-management-api/vipps-order-management-api).
This allows the merchants to send rich receipt information to existing Vipps transactions.
This information is visible for the customer in the app in their order history.

As an alternative an online sale log must be available for Vipps.

## What is the process to go live in production?

1. The partner establishes a customer relationship with Vipps.
   [Apply here](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/).
2. The partner integrates the POS with Vipps and completes
   [the integration checklist](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api-checklist).
   The partner now has a working POS integration.
   This process normally takes 1-4 days.
3. The partner's merchant establishes a customer relationship with Vipps.
   [Apply here](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/).
   This process normally takes 1-4 days.
4. If the merchant already has a customer relationship with Vipps, a new sales
   unit must be created, with `skipLandingPage` activated.
   The
   [Vipps customer center](https://vipps.no/hjelp/vipps/)
   can help with this.
   See: [Vipps landing page FAQ](vipps-landing-page-faq.md#is-it-possible-to-skip-the-landing-page).
5. The POS vendor normally uses
   [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).
   If not: The merchant
   [retrieves the API keys](../common-topics/api-keys.md#getting-the-api-keys)
   and provides them in a secure way to the partner.
   See: [Which API keys should I use?](#which-api-keys-should-i-use)
6. The partner configures the merchant's POS for Vipps.
7. The merchant can now accept Vipps payments in the POS.

## Which API keys should I use?

You should probably use
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
,and not separate API keys for each of
your merchants. But it depends.

See: [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).

## Do we need to support callbacks?

Please try to implement the API required, even if you do not use the data
provided in the callback. The API Dashboard will show errors if not.

If it is not possible for your POS to support callbacks (no fixed hostname/IP, etc),
you must actively check the payment status with
[``GET:/ecomm/v2/payments/{orderId}/details``](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#get-payment-details).

This is also required if you do support callbacks.

## How can I check if a person has Vipps?

There is no separate API for this, but an attempt to
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
with a phone number that is not registered with Vipps will fail with error 81,
`User not registered with Vipps`.
See: [Error codes](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#error-codes).

Users that install Vipps accept the terms and conditions, including being
"looked up" by the merchant if the payment is initiated with the phone number
is specified.  It is of course possible to pay with Vipps without sharing the
phone number with the merchant.
See
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
for the details of initiating payments with and without phone number.
See also
[privacy and terms](https://vipps.no/vilkar/)
on vipps.no.

There are users with unlisted numbers, users with secret number, etc.
These users can still pay with Vipps, since their phone number is
not shared with anyone without their explicit consent.

## How can I save the customer's phone number?

Vipps does not send the customer's phone number to the merchant. When a customer
enters the phone number on the Vipps landing page, that is only used by Vipps
to send a push alert in Vipps. The number is not passed on to the merchant.

If the POS integration is implemented so that the customer's phone number
is entered in the POS, the merchant can of course save it -
complying with GDPR, etc.

See:

* [Is there an API for retrieving information about a Vipps user?](users-and-payments-faq.md#is-there-an-api-for-retrieving-information-about-a-vipps-user).
* [The Vipps QR API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/qr-api)

## How can we mass sign up merchants?

See: [Vipps Partners: How to sign up new merchants](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner#how-to-sign-up-new-merchants).
