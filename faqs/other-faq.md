---
title: "FAQ: Other questions"
sidebar_label: Other questions
sidebar_position: 400
pagination_next: null
pagination_prev: null
---

# FAQ: Other questions

## Where do I find the `client_id` and `client_secret`?

See:

* [How to find the API keys](../common-topics/api-keys.md#getting-the-api-keys)

## Can you send us logs, so we can look for errors?

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

Having said that, it *is* possible to investigate specific API calls in special
cases if you send us enough information. Please do your own investigations before
contacting us about this.

## How do I perform "testing in production"?

To do this you need a live Vipps account.
You can order Vipps on
[portal.vipps.no](https://portal.vipps.no).

We recommend testing with 2 NOK, even though 1 NOK is the smallest possible amount.
1 NOK is not reliable, as it gets low priority in some systems.

## How can I use Vipps for different types of payments?

It's possible to use the Vipps eCom API for several types of payments.

Let's say you run a book store. You can then use Vipps eCom API in several ways, such as:

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
for some of the examples above. This must be done per sales unit.
Vipps is also required to have the correct MCC
([Merchant Category Code](https://en.wikipedia.org/wiki/Merchant_category_code))
for each sales unit.

Because of this, merchants must use separate sales units for separate types
of purchases. This also has some benefits:

* Each sales unit has its own name presented to the user in Vipps
* Each sales unit has separate transaction logs
* Each sales unit can have its own settlement account. Sharing a single account across multiple sales units is available on request.

## How do I set up multiple sales units?

This is typically needed for organization numbers with multiple stores,
or offers different ways to pay with Vipps.
See:
[How can I use Vipps for different types of payments?](#how-can-i-use-vipps-for-different-types-of-payments)

The bank account number for a sales unit must belong to the organization number
of the company that has the customer relationship with Vipps.

A legal entity, the "merchant", may have one or more sales units.
It is possible for one merchant to have multiple sales units with a separate
bank account number for each one, as long as the bank accounts belong to the
organization number that the sales unit belongs to.

If the organization has the required financial regulatory approval to "split"
payments between sales units, it is possible to have only one sales unit and
identify the payments of a store using the `orderId` - for instance by prefixing the
`orderId` with the store's ID, name or number.

Alternatively each store, if they each have their own organization number,
are set up with their own merchant and sales units.

If all sales units have the same organization number, there are two alternatives:

1: Recommended: Multiple sales units (multiple MSNs): One sales unit per store. Each sales unit will have its
   own MSN (Merchant Serial Number), and the `orderId` may be whatever you want.
   Each sales unit gets its own
   [settlement files](../settlements/README.md).
   You will need separate API keys for each sales unit (store).
   If you have a Vipps platform partner, the partner will use the
   [Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
   for all the sales units.
   See: [How can I use Vipps for different types of payments?](#how-can-i-use-vipps-for-different-types-of-payments).

2: Use only one sales unit (one MSN) for all stores, and use the `orderId` to identify
   which orders belong to which sales units.
   All sales units are in the same
   [settlement report](../settlements/README.md).
   You decide what the `reference` (called `orderId` in the older eCom API) contains,
   and it may be up to 50 characters. See:
   [Recommendations for `reference` and `orderId`](../common-topics/orderid.md).
   You will use the same API keys for all stores.
   If you have a Vipps platform partner, the partner will use the
   [Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
   for all the sales units.

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

See:
[Webhooks API](https://developer.vippsmobilepay.com/docs/APIs/webhooks-api/)

## Can I use Vipps with Klarna Checkout?

Yes. Klarna Checkout (KCO) supports Vipps as an External Payment Method if you have
agreement with Klarna for this.

**Please note:** It's technically possible to use
[Vipps Hurtigkasse](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#express-checkout-payments)
on product pages and in the shopping basket for fast and easy checkout, and to
let users choose between Vipps and Klarna *before* they get to Klarna Checkout.
With
[Vipps Login](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
(the [Vipps Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api))
it's also possible to let users register and log in without usernames and passwords.
[Vipps Checkout](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/vipps-checkout/)
may also be interesting.

**Important:** Using Vipps as an external payment method in Vipps requires a direct integration
with the Vipps eCom API, as Klarna merely redirects the user to Vipps for payment, as
the example below shows.

All information about price, shipping, etc. must be done in Klarna Checkout, before
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

Note, the description translates to: *Remember: Vipps is always fee-free when you pay to companies*.

| Field          | Description                                              |
| -------------- | -------------------------------------------------------- |
| `name`         | The name of the payment method. Use "Vipps".             |
| `redirect_url` | Merchant hosted URL redirecting to [the Vipps payment deeplink URL](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#the-vipps-deeplink-url)|
| `image_url`    | The logo to be shown for this payment method. See: [Vipps design guidelines](https://developer.vippsmobilepay.com/docs/vipps-design-guidelines).  |
| `fee`          | Should not be applicable because of PSD2 surcharge ban.  |
| `description`  | The `description` field should state that there is no fee when paying with Vipps. The Norwegian text above says: "Vipps is without fees when paying businesses".  |

Follow Klarna's process to get the External Payment Method activated for
your account, described in the
[Klarna documentation](https://docs.klarna.com/klarna-checkout/in-depth-knowledge/external-payment-methods/).
Using this method will add Vipps as a payment alternative inside KCO.

See:
[External payment methods & external checkouts](https://docs.klarna.com/klarna-checkout/in-depth-knowledge/external-payment-methods/).

**Please note:** Vipps has limited knowledge of Klarna Checkout, and cannot
help with all the details.

**Important:** When using Vipps as an external payment method in Klarna Checkout
the settlements from Vipps will be separate from the settlements from Klarna.

## What functionality is included in the Vipps MobilePay API, but not the PSP API?

See [Common topics: Benefits of direct integration](../common-topics/direct-vs-psp.md#benefits-of-direct-integration).

## What do we have to do with PSD2's SCA requirements?

Nothing. Vipps will handle everything for you - both bankID and 3-D Secure.

SCA (Strong customer authentication) is a security requirement related to PSD2,
to reduce the risk of fraud and protect customer's data.

Vipps uses delegated SCA, which makes it easier to users to pay with Vipps
than with stand-alone card payments. The result is a higher completion rate.

Delegated SCA is Vipps' primary way of solving the SCA requirements. For
this solution Vipps has developed an SCA compliant solution that consists of a
two-factor authentication featuring either PIN or biometrics in addition to
device possession. In addition, Vipps has implemented a Dynamic Linking according
to the requirements.

## How can I change partner for my integration with Vipps?

See:
[How to change partners for a merchant](https://developer.vippsmobilepay.com/docs/partner/how-to-change-partners/).

**Please note:** The MSN (the number) does *not* change when changing partners.
