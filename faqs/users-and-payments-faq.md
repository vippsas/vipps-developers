---
title: "FAQ: Users and payments"
sidebar_label: Users and payments
sidebar_position: 180
pagination_next: null
pagination_prev: null
---

# FAQ: Users and payments

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

## Where can I find information about payment and settlements?

On the [merchant portal](https://portal.vipps.no)
provides information about your transactions, sales units and settlement reports.
You can also subscribe to daily or monthly transaction reports by email.

See:

* [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api).
* [Settlements](../settlements/README.md)

## Can I split payments to charge a fee?

No. We don't support splitting payments to charge a fee.

If you want to charge a fee (like 3 %) of your payments, you can:

1. Receive the full payment, take your 3 %, and then pay the remaining
   97 % to your customer (merchant). In order to receive payments in this way,
   you may need the regulatory approval as
   [*e-pengeforetak* (*e-money institution*)](https://www.finanstilsynet.no/konsesjon/e-pengeforetak/)
   from the Finanstilsynet.
2. Have your customer (merchant) receive the full payment directly, then send an
   invoice for your 3 % fee.

Companies that receive payments through Vipps MobilePay needs to be our customers.
See:
[What are the requirements for merchants?](requirements-faq.md#what-are-the-requirements-for-vipps-merchants)

## Can I create a marketplace with multiple merchants?

We sometimes get questions whether we can support a marketplace or a
shopping center, with multiple merchants. The answer is: That depends.
It may not be as straight-forward as expected, and some typical questions
are covered elsewhere in this FAQ:

* All payments with Vipps MobilePay must be to a merchant that is a customer of Vipps MobilePay. See
  [What are the requirements for Vipps MobilePay merchants?](requirements-faq.md#what-are-the-requirements-for-vipps-merchants)
* Revenue share between the marketplace and the merchants: See:
  [Can I split payments to charge a fee?](#can-i-split-payments-to-charge-a-fee)
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

## Can I create a service to match buyers and sellers?

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

## Can I use Vipps MobilePay for crowdfunding?

That depends, but probably: No.

Vipps MobilePay cannot keep money for merchants.
All Vipps MobilePay payments must be made to a business that is a customer of Vipps MobilePay.

See:

* [What are the requirements for merchants?](requirements-faq.md#what-are-the-requirements-for-merchants)
* [Can I create a marketplace with multiple merchants?](#can-i-create-a-marketplace-with-multiple-merchants)
* [Can I create a service to match buyers and sellers?](#can-i-create-a-service-to-match-buyers-and-sellers)

## Is it possible for a merchant to pay a Vipps or MobilePay user?

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

## I have initiated an order, but I can't find it

For the eCom API, see
[I have initiated an order, but I can't find it](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-faq#i-have-initiated-an-order-but-i-cant-find-it).

## How long is an initiated order valid, if the user does not confirm in the app?

Orders through the ePayment API can have longer timeouts. See
[ePayment API: Long-living payments](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/features/long-living-payments/).

Orders through the eCom API have a max timeout of 10 minutes: 5 minutes to log in and 5 minutes to confirm the payment.

It's important that the merchant waits (at least) this long, otherwise the user may confirm in the app,
and right after get an error from the merchant that the order has been cancelled.

See: [Timeouts](../common-topics/timeouts.md).

## How long does it take until the money is in my account?

See: [Settlements](../settlements/README.md).

## Why has one of my customers been charged twice for the same payment?

Once in a while a customer claims they have "paid double", "paid twice" or similar.

This does not happen, except in *extremely* rare cases where multiple services,
both at Vipps, banks, PSPs, etc. fail simultaneously. In reality: This never happens.

The most common reason for misunderstanding is that customers do not understand
the difference between a *reservation* and a *payment* and/or that some banks
do not present this to their customers in a way that the customer understands.

Some banks will display the reservation of a payment even *after* the payment has
been captured. This may lead some customers into thinking that both the
reservation and the capture are payments, and that they have paid twice.

Most banks manage to do this properly, but apparently not all.

Please check the payment:

1. Find the `orderId` for the payment.
2. Log in on [portal.vipps.no](https://portal.vipps.no).
3. Click "Transaksjoner" (*Transactions*) and then *Søk på ID* (*Search for ID*)
4. Search for the `orderId` from step 1.
5. Click the order.
6. See the "History" details.

This is of course also supported in the [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api), and it is a requirement to use
this functionality when integrating with Vipps MobilePay:
[`GET:/ecomm/v2/payments/{orderId}/details`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)

The user can also check the payment in the Vipps or MobilePay app:

1. Start the app and log in.
2. Press *Payments* on the main screen.
3. Scroll down and press *History*
4. Check the payment and the *Transactions*.
5. Verify that the orderId and transaction ID matches the ones in step 6 above.

See:
[For how long is a payment reserved?](../common-topics/reserve-and-capture.md#for-how-long-is-a-payment-reserved)

## In which sequence are callbacks and fallbacks done?

We can't guarantee a particular sequence, as this depends on user
actions, network connectivity/speed, etc. Because of this, it is not
possible to base an integration on a specific sequence of events.

See:
[Initiate payment flow: Phone and browser](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#initiate-payment-flow-phone-and-browser)

## Where can I find reports on transactions?

The [merchant portal](https://portal.vipps.no) provides information about
your transactions, sales units and settlement reports.
You can also subscribe to daily or monthly transaction reports by email.

See: [Settlements](../settlements/README.md).

## When do users get a "soft decline" and need to complete a 3-D Secure verification?

We handle everything related to "soft declines" and 3-D Secure.
We also handle BankID verification, when that is required.
There is nothing a merchant needs to.

We use delegated SCA (Secure Customer Authentication) from the banks, which
significantly simplifies the user experience, as there is normally no need for
BankID verification. The biometric login in the Vipps or MobilePay app is enough.

We use tokenized cards, which eliminates the need for "soft decline".
As long as the token is valid, the user never has to verify the card again.

In order to prevent misuse and fraud, we require users to do a 3-D Secure
verification if the user has paid more than 15 000 NOK during the last five days.

In short: Users paying with Vipps MobilePay have a much faster and simpler user experience
than when using a card directly.

We also have an extremely low fraud rate, as it is impossible to pay
with a card that has been invalidated in any way by the issuer. All users
must log in to the app with their BankID verified identity to use their card.

See:

* [Benefits of direct integration](../common-topics/direct-vs-psp.md#benefits-of-direct-integration)
* [Extremely high success rate of direct integrations](../common-topics/direct-vs-psp.md#extremely-high-success-rate-of-direct-integrations)

## Card payments

The
[ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/)
and the
[Checkout API](https://developer.vippsmobilepay.com/docs/APIs/checkout-api/)
support freestanding card payments:
Users can enter their card details and pay with the card without using the app.
This means that payments are possible also for users in countries where
Vipps MobilePay is not yet available.

Both Visa and Mastercard are supported.
This includes any cards that are co-branded with VISA and Mastercard.

Visa Electron is supported if card is enabled for online purchases.

**Important:** To reduce risk, we do a 3D Secure step-up for *all* cards
used for freestanding payments. We do not have the delegated SCA
used in the app, when users are making freestanding payments.
Therefore, this additional security is required.
If the issuer does not handle 3D Secure correctly, the payment will fail.

Cards issued in the following countries are accepted:

* EEA/EØS (European Economic Area)
* UK
* Canada
* USA
* Australia
* New Zealand
* South Korea
* Japan
* Israel

**Please note**: Just to avoid confusion: Payments with the app are also done using
the users' cards that they have been added there. The user gets all the benefits of the card,
and since the app has delegated SCA, the user gets a faster and simpler user experience.
See also:
[Direct integration and PSP integration](../common-topics/direct-vs-psp.md).
