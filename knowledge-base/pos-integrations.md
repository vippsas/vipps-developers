---
title: "Point of Sale integrations"
sidebar_label: POS integrations
pagination_next: null
pagination_prev: null
---

# Point of Sale integrations

Point Of Sale (POS) is similar to a "cash register".

## Using the one-time payment QR

The one-time payment QR is for presenting a QR code for opening a payment request from a
customer-facing screen, so there is no need to manually input the mobile number.

Basic flow:

1. Initiate a eCom payment (`skipLandingPage` must be set to `false`)
2. Receive the payment URL as response
3. Post the payment URL to the
   [QR API](https://developer.vippsmobilepay.com/docs/APIs/qr-api)
4. Receive a URL to a QR code in PNG (Portable Network Graphics) format
5. Present the QR code on the customer-facing screen
6. The user scans the QR code with the Vipps or MobilePay app, or the camera app
7. The user pays (or cancels the payment) in the app
8. The fallback URL is triggered and will be presented on customers mobile phone

**Please note:**
The customer-facing screen will not show the fallback page. We recommend
presenting the result of the payment in some other way on the screen, and
also that an error messages if something went wrong.

If it is not possible for the POS solution to handle a fallback URL, you may use one of the following options:

1. Set `fallbackURL` to be the merchant's website
2. Set `fallbackURL` to be this static page: [www.vipps.no/thankyoupage/](https://www.vipps.no/thankyoupage/)

See also:

* [QR API: One-time payment QR codes](http://localhost:3000/vipps-developer-docs/docs/APIs/qr-api/vipps-qr-api#one-time-payment-qr-codes)
* [Error codes](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#error-codes)
* [Do we need to support callbacks?](#do-we-need-to-support-callbacks)


## Handling refunds on behalf of other stores

It may be relevant for enterprise setup, omnichannel, multiple physical stores within the same chain to refund orders on behalf of other stores.

**Prerequisites:**
Your stores or your centralized system must have access to all store credentials or use
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys).
Stores must be able to search for the order reference ID from other stores or request it from the centralized system.

**User story:** A user buys a product from "Store A".
The user then visits Store B to return some goods. "Store B" wants to be able to refund on behalf of "Store A".

**Problem:** Refunds can only be performed by the sales unit where the payment originated from: "Store A".

**Recommended solutions:**

**A:**
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
are used for all stores:

Stores must be able to search for `orderId` for payments made in other stores. The cashier can then search and select `orderId` from "Store A" and click `refund`.  
**Technical:** Use
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
to authenticate, add `Merchant-Serial-Number` from "Store A" to the request header and original `orderId` to the refund request.

NB: With
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys),
do not let the cashier input `Merchant-Serial-Number` themselves. These must be locked and connected to the store selection to reduce risk of adding the wrong store.

**B:**
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
are not used:

In this case, a centralized system needs to store credentials from all sales units within the enterprise.
"Store B" must be able to request a `refund` from the central system based on the original `orderId` and location for the order origin ("Store A").
**Technical:** Use "Store A" credentials to authenticate, add original `orderId` to the refund request.

**C:** Same sales unit is used for all locations:

It is possible to use one sales unit (one MSN) for all stores and use a prefix in the `reference` (also called `orderId`)
to identify which orders belong to which sales units.
This will result in having one settlement for all. You decide what the `reference` contains, and it may be up to 50 characters.
See: [Recommendations for `reference` and `orderId`](orderid.md).
You will use the same API keys for all stores.

## Distance selling from a POS solution

Due to compliance requirements in a payment situation where customer is not present, we recommend implementing the
[Order management API](https://developer.vippsmobilepay.com/docs/APIs/order-management-api/order-management-api-guide).
This allows the merchants to send rich receipt information to existing transactions.
This information is visible for the customer in the app in their order history.

As an alternative, an online sale log must be available.

## The process to go live in production

1. The partner establishes a customer relationship with Vipps MobilePay
   ([Apply here](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/)).
2. The partner integrates the POS with Vipps MobilePay and completes the
   integration checklist for the APIs they are using.
   The partner now has a working POS integration.
   This process normally takes 1-4 days.
3. The partner's merchant establishes a customer relationship with Vipps MobilePay.
   [Apply here](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/).
   This process normally takes 1-4 days.
4. If the merchant already has a customer relationship with Vipps MobilePay, a new sales
   unit must be created, with `skipLandingPage` activated.
   The
   [customer center](https://vipps.no/hjelp/vipps/)
   can help with this.
   See: [landing page](landing-page.md#skip-landing-page).
5. The POS vendor normally uses
   [Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys).
   If not: The merchant
   [retrieves the API keys](api-keys.md#getting-the-api-keys)
   and provides them securely to the partner.
   See: [Which API keys should I use for POS integrations?](#which-api-keys-should-i-use-for-pos-integrations)
6. The partner configures the merchant's POS for Vipps MobilePay.
7. The merchant can now accept Vipps MobilePay payments in the POS.


## POS FAQ

### How can we be whitelisted for `skipLandingPage`?

See: [skip the landing page](landing-page.md#skip-landing-page)

### Which API keys should I use for POS integrations?

For POS integrations, you should probably use
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys),
and not separate API keys for each of your merchants. But it depends.

See: [Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys).

### Do we need to support callbacks?

Please try to implement the API required, even if you do not use the data
provided in the callback. The API Dashboard will show errors if not.

If it's not possible for your POS to support callbacks (no fixed hostname/IP, etc.),
you must actively check the payment status.

This is also required if you do support callbacks.

### How can I check if a person has a Vipps or MobilePay account?

There is no separate API for this, but an attempt to initiate a payment
with a phone number that is not registered with Vipps will fail with error 81,
`User not registered with Vipps`.
See: [Error codes](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#error-codes).

Users that install the app accept the terms and conditions, including being
"looked up" by the merchant if the payment is initiated with the phone number
is specified. It is possible to pay with Vipps without sharing the
phone number with the merchant.

See also
[vipps.no: privacy and terms](https://vipps.no/vilkar/).

There are users with unlisted numbers, users with secret number, etc.
These users can still pay with Vipps, since their phone number is
not shared with anyone without their explicit consent.

### How can I save the customer's phone number?

We don't send the customer's phone number to the merchant. When a customer
enters the phone number on the landing page, that is only used
to send a push alert in Vipps MobilePay. The number is not passed on to the merchant.

If the POS integration is implemented so that the customer's phone number
is entered in the POS, the merchant can of course save it -
complying with GDPR, etc.

There is an API for retrieving information about a user, as part of a payment or login.

We offer the possibility for merchants to ask the user for information
as part of the payment flow with
[Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api/userinfo-api-guide/).

### How can we mass sign up merchants?

Partners can sign up users.
See: [Partners: How to sign up new merchants](https://developer.vippsmobilepay.com/docs/partner#how-to-sign-up-new-merchants).
