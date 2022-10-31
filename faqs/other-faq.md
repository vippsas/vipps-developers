<!-- START_METADATA
---
title: Other questions
sidebar_position: 90
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# FAQs: Other questions

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

Document version 0.0.1.

<!-- START_TOC -->

## Table of contents

* [Can you send us logs so we can look for errors?](#can-you-send-us-logs-so-we-can-look-for-errors)
* [How do I perform "testing in production"?](#how-do-i-perform-testing-in-production)
* [How can I use Vipps for different types of payments?](#how-can-i-use-vipps-for-different-types-of-payments)
* [How do I set up multiple sale units?](#how-do-i-set-up-multiple-sale-units)
* [How can I change my organization number?](#how-can-i-change-my-organization-number)
* [What about webhooks?](#what-about-webhooks)
* [Can I use Vipps with Klarna Checkout?](#can-i-use-vipps-with-klarna-checkout)
* [What functionality is included in the eCom API, but not the PSP API?](#what-functionality-is-included-in-the-ecom-api-but-not-the-psp-api)
* [What do we have to do with PSD2's SCA requirements?](#what-do-we-have-to-do-with-psd2s-sca-requirements)
* [How can I change partner for my integration with Vipps?](#how-can-i-change-partner-for-my-integration-with-vipps)

<!-- END_TOC -->

## Can you send us logs so we can look for errors?

No. Vipps cannot extract logging info for one merchant or one MSN. There are
terabytes of data, and it's not trivial to provide data for just one merchant
or MSN.

We provide as much information as we can for all API requests that fail, both
by using a sensible HTTP status for the response and by including as much
relevant information as possible in the response body.

It's important to use this information. If you discard it, it's gone.

The API Dashboard on
[portal.vipps.no](https://portal.vipps.no)
provides a high-level overview of errors in the use of the Vipps APIs,
but it does in no way replace a proper handling of errors and error messages.

Having said that, it _is_ possible to investigate specific API calls if you
send us enough information. See the "Contact us" information at the bottom of this page.

## How do I perform "testing in production"?

To do this you need a live Vipps account.
You can order Vipps on
[portal.vipps.no](https://portal.vipps.no).

We recommend testing with 2 NOK, even though 1 NOK is the smallest possible amount.
1 NOK is not reliable, as it gets low priority in some systems.

## How can I use Vipps for different types of payments?

It's possible to use the Vipps eCom API for several different types of payments.

Let's say you run a book store. You can then use Vipps eCom API in several different ways, such as:

1. A webshop that sells physical books:
   Vipps eCom API with "reserve capture", since you cannot capture the payment before the book is shipped.
2. A webshop that sells digital, downloadable books that are immediately available:
   Vipps eCom API with either "reserve capture" or "direct capture", depending on whether the digital product
   needs to be generated or not.
3. A physical store where customers buy physical books in person:
   Vipps eCom API with "direct capture", possibly integrated with the POS.
4. A physical store where customers can buy physical books by scanning a
   QR code in the window, and have the physical book delivered by mail:
   Vipps eCom API with "reserve capture", since you cannot capture the payment before the book is shipped.

The regulatory requirements are different for different types of purchases.
One major difference is if the cardholder is physically present and
"can look the seller in the eye" while making the payment.

Vipps needs to do more thorough "Know Your Customer" (KYC) and compliance checks
for some of the examples above. This must be done per sale unit.
Vipps is also required to have the correct MCC
([Merchant Category Code](https://en.wikipedia.org/wiki/Merchant_category_code))
for each sale unit.

Because of this, merchants must use separate sale units for separate types
of purchases. This also has some benefits:

* Each sale unit has its own name presented to the user in Vipps
* Each sale unit has separate transaction logs
* Each sale unit can have its own settlement account. Sharing a single account across multiple sale units is available on request.

## How do I set up multiple sale units?

This is typically needed for organization numbers with multiple stores,
or offers different ways to pay with Vipps.
See:
[How can I use Vipps for different types of payments?](#how-can-i-use-vipps-for-different-types-of-payments)

The bank account number for a sale unit must belong to the organization number
of the company that has the customer relationship with Vipps.

A legal entity, the "merchant", may have one or more sale units.
It is possible for one merchant to have multiple sale units with a separate
bank account number for each one, as long as the bank accounts belong to the
organization number that the sale unit belongs to.

If the organization has the required financial regulatory approval to "split"
payments between sale units, it is possible to have only one sale unit and
identify the payments of a store using the `orderId` - for instance by prefixing the
`orderId` with the store's id, name or number.

Alternatively each store, if they each have their own organization number,
are set up with their own merchant and sale units.

If all sale units have the same organization number, there are two alternatives:

1: Recommended: Multiple sale units (multiple MSNs): One sale unit per store. Each sale unit will have its
   own MSN (Merchant Serial Number), and the `orderId` may be whatever you want.
   Each sale unit gets its own
   [settlement files](../common-topics/settlements/).
   You will need separate API keys for each sale unit (store).
   If you have a Vipps platform partner, the partner will use the
   [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
   for all the sale units.
   See: [How can I use Vipps for different types of payments?](#how-can-i-use-vipps-for-different-types-of-payments).

2: Use only one sale unit (one MSN) for all stores, and use the `orderId` to identify
   which orders belong to which sale units.
   All sale units are in the same
   [settlement report](../common-topics/settlements/).
   You decide what the `orderId` contains, and it may be up to 50 characters. See:
   [orderId recommendation](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#orderid-recommendations).
   You will use the same API keys for all stores.
   If you have a Vipps platform partner, the partner will use the
   [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
   for all the sale units.

## How can I change my organization number?

A company cannot change its organization number.

Companies (merchants) sometimes merge with other companies, are acquired, etc.
We sometimes get requests from companies that have "changed organization numbers",
but this is not possible in Norway.

The organization number is a unique identifier for a legal entity, and
a new legal entity needs a new organization number. The fact that the company
has the same name, is owned by the same people, etc. is irrelevant.

Vipps is legally required by Finanstilsynet to perform several checks of all
companies that have a customer relationship with Vipps. This is based on each
company's organization number, and the legally binding agreement between the
company and Vipps. This agreement is signed with BankID.

If a company has "changed organization numbers", it is a new legal entity,
and the new company needs a new agreement with Vipps. Establishing a new
customer relationship for the new company is straight-forward on
[portal.vipps.no](https://portal.vipps.no).

## What about webhooks?

Vipps has, so far (and this _may_ change), used `GET` methods for retrieving information.
We have varying success when depending on systems on the merchant side, especially
during peak traffic periods. With webhooks, and also callbacks, Vipps
takes the responsibility of providing information to the merchant, while being
dependent on systems on the merchant side, network stability, etc.

In our experience, `GET` methods is the safest way for merchants to get
information from Vipps. We also provide callbacks, but merchants _must not_
rely on this alone - being able to actively retrieving information with `GET` methods
is a requirement.

See:

* [Vipps eCom API checklist](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-checklist.md)
* [Vipps PSP API checklist](https://github.com/vippsas/vipps-psp-api/blob/master/vipps-psp-api-checklist.md)

## Can I use Vipps with Klarna Checkout?

Yes. Klarna Checkout (KCO) supports Vipps as an External Payment Method if you have
agreement with Klarna for this.

**Please note:** It's technically possible to use
[Vipps Hurtigkasse](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#express-checkout-payments)
on product pages and in the shopping basket for fast and easy checkout, and to
let users choose between Vipps and Klarna _before_ they get to Klarna Checkout.
With
[Vipps Logg inn](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
(the [Vipps Login API](https://github.com/vippsas/vipps-login-api))
it's also possible to let users register and log in without usernames and passwords.
[Vipps Checkout](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/vipps-checkout/)
may also be interesting.

**Important:** Using Vipps as an external payment method in Vipps requires a direct integration
with the Vipps eCom API, as Klarna merely redirects the user to Vipps for payment, as
the example below shows.

All information about price, shipping, etc must be done in Klarna Checkout, before
the user is sent to Vipps to pay the total amount.

```json
"external_payment_methods": [
   {
      "name": "Vipps",
      "redirect_url": "https://example.com/vipps/ecom-api/initiate/acme-shop-123-order123abc",
      "image_url": "https://example.com/images/vipps-logo.png",
      "fee": 0,
      "description": "Husk: Vipps er alltid gebyrfritt når du betaler til bedrifter."
   }
]
```

Note, the description translates to: _Remember: Vipps is always fee-free when you pay to companies_.

| Field          | Description                                              |
| -------------- | -------------------------------------------------------- |
| `name`         | The name of the payment method. Use "Vipps".             |
| `redirect_url` | Merchant hosted url redirecting to [the Vipps payment deeplink URL](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#the-vipps-deeplink-url)|
| `image_url`    | The logo to be shown for this payment method. See: [Vipps design guidelines](https://github.com/vippsas/vipps-design-guidelines).  |
| `fee`          | Should not be applicable because of PSD2 surcharge ban.  |
| `description`  | The `description` field should state that there is no fee when paying with Vipps. The Norwegian text above says: "Vipps is without fees when paying businesses".  |

Follow Klarna's process to get the External Payment Method activated for
your account, described in the
[Klarna documentation](https://developers.klarna.com/documentation/klarna-checkout/in-depth/external-payment-methods/).
Using this method will add Vipps as an payment alternative inside KCO.

See:
[External payment methods & external checkouts](https://docs.klarna.com/klarna-checkout/in-depth-knowledge/external-payment-methods/).

**Please note:** Vipps has limited knowledge of Klarna Checkout, and cannot
help with all the details.

**Important:** When using Vipps as an external payment method in Klarna Checkout
the settlements from Vipps will be separate from the settlements from Klarna.

## What functionality is included in the eCom API, but not the PSP API?

The [Vipps PSP API](https://github.com/vippsas/vipps-psp-api) provides tokens
that a PSP can use to charge a Vipps user's card. To put it simply, it is a
"card token lookup service". The payment is completed by the PSP, who sends an
update to Vipps about the success or failure.

The Vipps eCom API has some functionality that is not available in the PSP API:

1. Retry functionality: If the user attempts to pay with a card that is declined,
   the user can retry with a different card, while still in the same payment process.
   This results in a higher success rater for payments.
   The PSP API does not have this functionality, as it is the PSP, not Vipps,
   that make the charge.
2. [Express checkout (Vipps Hurtigkasse)](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#express-checkout-payments)
   is only available in the Vipps eCom API.
3. [Userinfo](../common-topics/userinfo.md):
   The Vipps eCom API offers the possibility for merchants to ask for the user's
   profile information as part of the payment flow: name, address, email, phone number, birthdate, etc.
4. When using the Vipps eCom API, Vipps handles soft-declines, 3-D Secure, BankID, etc.
   There is nothing a merchant needs to do.
   This give a consistent user experience and a very high completion rate.

## What do we have to do with PSD2's SCA requirements?

Nothing. Vipps will handle everything for you - both bankID and 3-D Secure.

SCA (Strong customer authentication) is a security requirement related to PSD2,
to reduce the risk of fraud and protect customer's data.

Vipps uses delegated SCA, which makes it easier to users to pay with Vipps
than with stand-alone card payments. The result is a higher completion rate.

Delegated SCA is Vipps' primary way of solving the SCA requirements. For
this solution Vipps has developed a SCA compliant solution that consists of a
two-factor authentication featuring either PIN or biometrics in addition to
device possession. In addition Vipps has implemented a Dynamic Linking according
to the requirements.

## How can I change partner for my integration with Vipps?

See:
[How to change partners for a merchant](https://github.com/vippsas/vipps-partner#how-to-change-partners-for-a-merchant).

**Please note:** The MSN (the number) does _not_ change when changing partners.
