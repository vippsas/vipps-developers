---
title: "FAQ: Point of Sale integration"
sidebar_label: POS integrations
sidebar_position: 130
pagination_next: null
pagination_prev: null
---

# FAQ: Point of Sale integration

Point Of Sale (POS) is similar to a "cash register".

## Handling refunds on behalf of other stores

It may be relevant for enterprise setup, omnichannel, multiple physical stores within the same chain to refund orders on behalf of other stores.

**Prerequisites:**
Stores or a centralized system (e.g. from a headquarters) must have access to all store credentials, or use
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys).
Stores must be able to search for `orderId` from other stores or request it from the centralized system.

**User story:** A user buys a product from Store A.
The user then visits Store B to return some goods. Store B wants to be able to refund on behalf of Store A.

**Problem:** Refunds can only be performed by the sales unit where the payment originated from: Store A.

**Recommended solutions:**

**A:**
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
are used for all stores:

Stores must be able to search for `orderId` for payments made in other stores. The cashier can then search and select `orderId` from Store A and click `refund`.  
**Technical:** Use
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
to authenticate, add `Merchant-Serial-Number` from Store A to the request header and original `orderId` to the
[refund](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/refundPaymentUsingPOST) request.

NB: With
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys),
do not let the cashier input `Merchant-Serial-Number` themselves. These must be locked and connected to the store selection to reduce risk of adding the wrong store.

**B:**
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
are not used:

In this case, a centralized system needs to store credentials from all sales units within the enterprise.
Store B must be able to request a `refund` from the central system based on the original `orderId` and location for the order origin (Store A).
**Technical:** Use Store A credentials to authenticate, add original `orderId` to the
[refund](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/refundPaymentUsingPOST)
request.

**C:** Same sales unit is used for all locations:

It is possible to use one sales unit (one MSN) for all stores and use a prefix in the `reference` (called `orderId` in the older eCom API)
to identify which orders belong to which sales units.
This will result in having one settlement for all. You decide what the `reference` contains, and it may be up to 50 characters.
See: [Recommendations for `reference` and `orderId`](../common-topics/orderid.md).
You will use the same API keys for all stores.

## Distance selling from a POS solution

Due to compliance requirements in a payment situation where customer is not present, we recommend implementing the
[Order management API](https://developer.vippsmobilepay.com/docs/APIs/order-management-api/vipps-order-management-api).
This allows the merchants to send rich receipt information to existing transactions.
This information is visible for the customer in the app in their order history.

As an alternative, an online sale log must be available.

## What is the process to go live in production?

1. The partner establishes a customer relationship with Vipps MobilePay.
   [Apply here](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/).
2. The partner integrates the POS with Vipps MobilePay and completes
   [the integration checklist](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-checklist).
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
   See: [landing page FAQ](landing-page-faq.md#is-it-possible-to-skip-the-landing-page).
5. The POS vendor normally uses
   [Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys).
   If not: The merchant
   [retrieves the API keys](../common-topics/api-keys.md#getting-the-api-keys)
   and provides them securely to the partner.
   See: [Which API keys should I use for POS integrations?](#which-api-keys-should-i-use-for-pos-integrations)
6. The partner configures the merchant's POS for Vipps MobilePay.
7. The merchant can now accept Vipps MobilePay payments in the POS.

## Which API keys should I use for POS integrations?

For POS integrations, you should probably use
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys),
and not separate API keys for each of your merchants. But it depends.

See: [Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys).

## How can I save the customer's phone number?

We don't send the customer's phone number to the merchant. When a customer
enters the phone number on the landing page, that is only used
to send a push alert in Vipps MobilePay. The number is not passed on to the merchant.

If the POS integration is implemented so that the customer's phone number
is entered in the POS, the merchant can of course save it -
complying with GDPR, etc.

See:

* [Is there an API for retrieving information about a user?](users-and-payments-faq.md#is-there-an-api-for-retrieving-information-about-a-user).
* [The QR API](https://developer.vippsmobilepay.com/docs/APIs/qr-api)

## How can we mass sign up merchants?

See: [Partners: How to sign up new merchants](https://developer.vippsmobilepay.com/docs/partner#how-to-sign-up-new-merchants).
