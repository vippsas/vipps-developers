---
title: User data
pagination_next: null
pagination_prev: null
---

# User data

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
[recommendations for `reference` and `orderId`](../common-topics/orderid.md).

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

## Is there an API for checking if a number belongs to a user?

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

## Is there an API for retrieving information about a user?

Yes, but only as part of a payment or login.

We offer the possibility for merchants to ask the user for information
as part of the payment flow with
[Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api/userinfo-api-guide/).

**Please note:** Vipps or MobilePay users have not consented to providing any
information to third parties, and we do not allow it.
The user must always give consent to sharing data with a merchant.
There is no other API to look up a user's address, retrieve a user's purchases, etc.

## Why are the customer names not shown on the transaction overview?

Using Vipps MobilePay is anonymous for the users, by default.
