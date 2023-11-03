---
pagination_next: null
pagination_prev: null
---

# Merchant questions

## Sales units


### How do I set up multiple sales units?

This is typically needed for organization numbers with multiple stores,
or offers different ways to pay with Vipps MobilePay.
See:
[How can I use Vipps MobilePay for different types of payments?](payments.md#how-can-i-use-vipps-mobilepay-for-different-types-of-payments)

The bank account number for a sales unit must belong to the organization number
of the merchant that has the customer relationship with Vipps MobilePay.

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
   If you have a Vipps MobilePay platform partner, the partner will use the
   [Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
   for all the sales units.
   See: [How can I use Vipps MobilePay for different types of payments?](payments.md#how-can-i-use-vipps-mobilepay-for-different-types-of-payments).

2: Use only one sales unit (one MSN) for all stores, and use the `orderId` to identify
   which orders belong to which sales units.
   All sales units are in the same
   [settlement report](../settlements/README.md).
   You decide what the `reference` (called `orderId` in the older eCom API) contains,
   and it may be up to 50 characters. See:
   [Recommendations for `reference` and `orderId`](orderid.md).
   You will use the same API keys for all stores.
   If you have a Vipps MobilePay platform partner, the partner will use the
   [Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys)
   for all the sales units.

### How can I change my organization number?

A merchant cannot change its organization number.

Businesses (i.e., merchants) sometimes merge with other businesses, are acquired, etc.
We sometimes get requests from companies that have "changed organization numbers",
but this is not possible in Norway.

The organization number is a unique identifier for a legal entity, and
a new legal entity needs a new organization number. The fact that the business
has the same name, is owned by the same people, etc. is irrelevant.

Vipps MobilePay is legally required by the financial authorities to perform several checks of all
businesses that have a customer relationship with Vipps MobilePay. This is based on each
business' organization number, and the legally binding agreement between the
businesses and Vipps MobilePay. This agreement is signed with BankID.

If a business has "changed organization numbers", it is a new legal entity.
The new business needs a new agreement with Vipps MobilePay. Establishing a new
customer relationship for the new business is done on the
[merchant portal](https://portal.vipps.no).


### Can I use Vipps with Klarna Checkout?

Yes. Klarna Checkout (KCO) supports Vipps as an External Payment Method if you have
agreement with Klarna for this.

**Please note:** It's technically possible to use
[Hurtigkasse](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#express-checkout-payments)
on product pages and in the shopping basket for fast and easy checkout, and to
let users choose between Vipps and Klarna *before* they get to Klarna Checkout.
With
[Login](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
(the [Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api))
it's also possible to let users register and log in without usernames and passwords.
[Checkout](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/vipps-checkout/)
may also be interesting.

**Important:** Using Vipps as an external payment method requires a direct integration
with the eCom API, as Klarna merely redirects the user to Vipps for payment, as
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

Note, the description translates to: *Remember: Vipps MobilePay is always fee-free when you pay to companies*.

| Field          | Description                                              |
| -------------- | -------------------------------------------------------- |
| `name`         | The name of the payment method. Use "Vipps".             |
| `redirect_url` | Merchant hosted URL redirecting to [the Vipps payment deeplink URL](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#the-vipps-deeplink-url)|
| `image_url`    | The logo to be shown for this payment method. See: [Design guidelines](https://developer.vippsmobilepay.com/docs/design-guidelines).  |
| `fee`          | Should not be applicable because of PSD2 surcharge ban.  |
| `description`  | The `description` field should state that there is no fee when paying with Vipps. The Norwegian text above says: "Vipps is without fees when paying businesses".  |

Follow Klarna's process to get the External Payment Method activated for
your account, described in the
[Klarna documentation](https://docs.klarna.com/klarna-checkout/in-depth-knowledge/external-payment-methods/).
Using this method will add Vipps as a payment alternative inside KCO.

See:
[External payment methods & external checkouts](https://docs.klarna.com/klarna-checkout/in-depth-knowledge/external-payment-methods/).

**Please note:** We have limited knowledge of Klarna Checkout, and cannot
help with all the details.

**Important:** When using Vipps as an external payment method in Klarna Checkout,
the settlements from us will be separate from the settlements from Klarna.

### What functionality is included in the Vipps MobilePay API, but not the PSP API?

See [Benefits of direct integration](direct-vs-psp.md#benefits-of-direct-integration).

### What do we have to do with PSD2's SCA requirements?

Nothing. We will handle everything for you - both BankID and 3-D Secure.

SCA (Strong customer authentication) is a security requirement related to PSD2,
to reduce the risk of fraud and protect customer's data.

We use delegated SCA, which makes it easier to users to pay with Vipps MobilePay
than with stand-alone card payments. The result is a higher completion rate.

Delegated SCA is our primary way of solving the SCA requirements. For
this solution, we have developed an SCA compliant solution that consists of a
two-factor authentication featuring either PIN or biometrics in addition to
device possession. In addition, we have implemented a Dynamic Linking according
to the requirements.

### How can I change partner for my Vipps MobilePay integration?

See:
[How to change partners for a merchant](https://developer.vippsmobilepay.com/docs/partner/how-to-change-partners/).

**Please note:** The MSN (the number) does *not* change when changing partners.


### How can I measure Vipps sales with Google Analytics, Facebook pixel, etc.?

We don't have any functionality for measuring sales with Google
Analytics, Facebook pixel, etc. Merchants may of course use any service on
their own website, and use a fallback URL (the "result page") to track any
activity. This must be done by the merchant itself.

See:
[Initiate payment flow: Phone and browser](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#initiate-payment-flow-phone-and-browser).


### Can I create a marketplace with multiple merchants?

We sometimes get questions whether we can support a marketplace or a
shopping center, with multiple merchants. The answer is: That depends.
It may not be as straight-forward as expected, and some typical questions
are covered elsewhere in this FAQ:

* All payments with Vipps MobilePay must be to a merchant that is a customer of Vipps MobilePay. See
  [What are the requirements for Vipps MobilePay merchants?](applying-for-services.md#what-are-the-requirements-for-merchants)
* Revenue share between the marketplace and the merchants: See:
  [Can I split payments to charge a fee?](payments.md#can-i-split-payments-to-charge-a-fee)
* Refunds can only be made from the merchant that received the payment. See:
  [Is it possible for a merchant to pay a Vipps or MobilePay user?](#is-it-possible-for-a-merchant-to-pay-a-vipps-or-mobilepay-user)

So, there are two alternatives:

1. The shopping center is the only Vipps merchant, and all payments from Vipps MobilePay
   users is to this merchant. We aren't involved in the cooperation between
   the shopping center and it's merchants, and it is completely up to them
   to operate according to Norwegian laws and regulation.
2. Each merchant in the shopping center is a Vipps MobilePay merchant, and each payment
   from a Vipps or MobilePay user is made directly to the merchant. This means that a
   common shopping cart for all merchants cannot be paid in one operation,
   since: All payments with Vipps MobilePay must be to a merchant that is a customer of Vipps MobilePay.

### Is it possible for a merchant to pay a Vipps or MobilePay user?

No. We have no functionality to allow a merchant to pay a user,
except for refunding (part of) a payment.

Vipps MobilePay only has APIs for paying from a person to a merchant.

It is not possible to pay from one merchant to another merchant,
or to pay from a merchant to a person.

There are several reasons for this, including:

* The Norwegian *Straksbetaling* (instant payments) system is not designed
  for this, and not all banks support it.
* There are other account-to-account payment methods, but all have their
  idiosyncrasies, and none are a perfect fit.
* Payouts to cards is different from accounts, and will depend on the PSPs,
  which brings another set of challenges.
* Some merchant accounts require "four eyes" before making payments from them,
  and we don't have this functionality in the API.
* The SCA (Secure Customer Authentication) required by PSD2 further complicates
  payouts, both with an API and on [portal.vipps.no](https://portal.vipps.no).

We have functionality for getting the user's bank accounts enrolled in
Vipps MobilePay, with the user's consent. Payments may then be made to the bank account.
See:
[Is there an API for retrieving information about a user?](#is-there-an-api-for-retrieving-information-about-a-user)


### Can I create a service to match buyers and sellers?

Companies that receive payments through Vipps MobilePay must be Vipps MobilePay customers,
and this is defined in the regulatory approval from Finanstilsynet.

If the service receives payment from a buyer and then pays the seller,
so that the service "holds" the money even for a short time, the service
will need the regulatory approval as
[e-pengeforetak (i.e., *e-money institution*)](https://www.finanstilsynet.no/konsesjon/e-pengeforetak/).

If the service sells access, in the form of a subscription or per-use, the
service is *most likely* a regular eCom customer, and can use
the
[eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
or one of our
[plugins](https://developer.vippsmobilepay.com/docs/plugins).

We can't offer legal advice for this.

### Can I use Vipps MobilePay for crowdfunding?

That depends, but probably: No.

Vipps MobilePay cannot keep money for merchants.
All Vipps MobilePay payments must be made to a business that is a customer of Vipps MobilePay.

See:

* [What are the requirements for merchants?](applying-for-services.md#what-are-the-requirements-for-merchants)
* [Can I create a marketplace with multiple merchants?](#can-i-create-a-marketplace-with-multiple-merchants)
* [Can I create a service to match buyers and sellers?](#can-i-create-a-service-to-match-buyers-and-sellers)

## Users

### Is there an API for checking if a number belongs to a user?

No, we don't offer a lookup service for this, as we don't want to
leak information about users. If a payment is initiated for a user that can
not pay businesses, the response will be an error.

If you initiate a payment request with a phone number that can't be used to complete the payment,
we don't distinguish between the following:

* Not a Vipps MobilePay user
* A Vipps MobilePay user, but too young to pay businesses
* A previous Vipps MobilePay user that has deleted his/her account
* A Vipps MobilePay user that has his/her account temporarily or permanently blocked.

We aren't allowed to provide more details about the reason for the failure.

### Is there an API for retrieving information about a user?

Yes, but only as part of a payment or login.

We offer the possibility for merchants to ask the user for information
as part of the payment flow with
[Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api/userinfo-api-guide/).

**Please note:** Vipps or MobilePay users have not consented to providing any
information to third parties, and we do not allow it.
The user must always give consent to sharing data with a merchant.
There is no other API to look up a user's address, retrieve a user's purchases, etc.

### Why are the customer names not shown on the transaction overview?

Using Vipps MobilePay is anonymous for the users, by default. Users can pay through Vipps MobilePay without sharing their
personal data with the merchant. Merchants can use the built-in functionality to
get the user's consent to share personal data - such as phone number, name,
e-mail address and address.
See
[Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api)
and
[Express checkout](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#express-checkout-payments).

The transaction overview on
[portal.vipps.no](https://portal.vipps.no)
shows the customer names for
[Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
payments.

For other payments, such as
[*Vipps på nett*](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
and
[*Faste betalinger* (Recurring payments)](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
the `reference` (ePayment API), or `orderId` (the eCom API), is shown instead of the customer name.

The `reference` (or `orderId` in the older eCom API) is specified by the merchant. See the
[recommendations for `reference` and `orderId`](../knowledge-base/orderid.md).

Use
[Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api)
to get the customer's consent to share name, email address, etc.
The user can then consent to sharing as part of the payment flow.

**Please note:** *Vippsnummer* is not legal for payments where the customer is
not physically present. It does also not comply with the Treasury Act, (*Kassaloven*).

**Please note:** Vipps or MobilePay users have not consented to providing any
information to third parties, and we do not allow it.
The user must always give consent to sharing data with a merchant.
There is no other API to look up a user's address, retrieve a user's purchases, etc.

### Can I use my "Vippsnummer" in my webshop?

No.
[Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
can't be used for
[*Vipps på Nett*](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/),
[*Logg inn*](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
or
[*Faste Betalinger* (Recurring payments)](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
because the Norwegian Tax Administration considers *Vippsnummer* to be cash transactions,
while eCommerce is defined as remote sales (in Norwegian, *fjernhandel*). The regulations
associated with both are different enough to require this policy.

You need
[*Vipps på Nett*](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/).
