<!-- START_METADATA
---
title: "FAQ: Users and payments"
sidebar_label: Users and payments
sidebar_position: 180
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# FAQ: Users and payments

## Is there an API for checking if a number belongs to a Vipps user?

No. Vipps does not offer a lookup service for this, as we do not want to
leak information about users. If a payment is initiated for a user that can
not pay businesses, the response will be an error.

Vipps does not distinguish between the following when initiating a payment with
[`POST:/ecomm/v2/payments`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
and the API call contains a phone number that can not be used to complete the payment:

* Not a Vipps user
* A Vipps user, but too young to pay businesses
* A previous Vipps user that has deleted his/her account
* A Vipps user that has his/her account temporarily or permanently blocked.

Vipps cannot give more details about the reason.

## Is there an API for retrieving information about a Vipps user?

Yes, but only as part of a payment or login.

Vipps offers the possibility for merchants to ask the user for information
as part of the payment flow with
[Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api).

This is done by adding a `scope` parameter to the initiate calls:
[`POST:/ecomm/v2/payments`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST) (eCom)
and
[`POST:/recurring/v2/agreements`](https://developer.vippsmobilepay.com/api/recurring#tag/Agreement-v2-endpoints/operation/DraftAgreement) (Recurring):

* `address`
* `birthDate`
* `email`
* `name`
* `phoneNumber`
* `nin` (national identity number, "fødselsnummer" in Norway)
* `accountNumbers`

**Please note:** Vipps users have not consented to Vipps providing any
information to third parties, and Vipps does not allow it.
The Vipps user must always give consent to sharing data with a merchant.
There is no other API to look up a user's address, retrieve a user's purchases, etc.

## Where can I find information about payment and settlements?

[portal.vipps.no](https://portal.vipps.no)
provides information about your transactions, sales units and settlement reports.
You can also subscribe to daily or monthly transaction reports by email.

See:

* [Report API](https://developer.vippsmobilepay.com/docs/APIs/report-api).
* [Settlements](../settlements/README.md)

## Can I split payments to charge a fee?

No. Vipps does not support splitting payments to charge a fee.

If you want to charge a fee (like 3 %) of your payments, you can:

1. Receive the full payment, take your 3 %, and then pay the remaining
   97 % to your customer (merchant). In order to receive payments in this way,
   you may need the regulatory approval as
   [e-pengeforetak (i.e., *e-money institution*)](https://www.finanstilsynet.no/konsesjon/e-pengeforetak/)
   from the Finanstilsynet.
2. Have your customer (merchant) receive the full payment directly, then send an
   invoice for your 3 % fee.

Companies that receive payments through Vipps needs to be Vipps customers.
See:
[What are the requirements for Vipps merchants?](requirements-faq.md#what-are-the-requirements-for-vipps-merchants)

## Can I create a marketplace with multiple merchants?

We sometimes get questions whether Vipps can support a marketplace or a
shopping center, with multiple merchants. The answer is: That depends.
It may not be as straight-forward as expected, and some typical questions
are covered elsewhere in this FAQ:

* All payments with Vipps must be to a merchant that is a customer of Vipps. See
  [What are the requirements for Vipps merchants?](requirements-faq.md#what-are-the-requirements-for-vipps-merchants)
* Revenue share between the marketplace and the merchants: See:
  [Can I split payments to charge a fee?](#can-i-split-payments-to-charge-a-fee)
* Refunds can only be made from the merchant that received the payment. See:
  [Is it possible for a merchant to pay a Vipps user?](#is-it-possible-for-a-merchant-to-pay-a-vipps-user)

So, there are two alternatives:

1. The shopping center is the only Vipps merchant, and all payments from Vipps
   users is to this merchant. Vipps is not involved in the cooperation between
   the shopping center and it's merchants, and it is completely up to them
   to operate according to Norwegian laws and regulation.
2. Each merchant in the shopping center is a Vipps merchant, and each payment
   from a Vipps user is made directly to the merchant. This means that a
   common shopping cart for all merchants cannot be paid in one operation,
   since: All payments with Vipps must be to a merchant that is a customer of Vipps.

## Can I create a service to match buyers and sellers?

Companies that receive payments through Vipps must be Vipps customers,
and this is defined in the regulatory approval for Vipps from Finanstilsynet.

If the service receives payment from a buyer and then pays the seller,
so that the service "holds" the money even for a short time, the service
will need the regulatory approval as
[e-pengeforetak (i.e., *e-money institution*)](https://www.finanstilsynet.no/konsesjon/e-pengeforetak/).

If the service sells access, in the form of a subscription or per-use, the
service is *most likely* a regular Vipps eCom customer, and can use
the
[Vipps eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
or one of our
[plugins](https://developer.vippsmobilepay.com/docs/vipps-plugins).

Vipps cannot offer legal advice for this.

## Can I use Vipps for crowdfunding?

That depends, but probably: No.

Vipps cannot keep money for merchants.
All Vipps payments must be made to a company that is a customer of Vipps.

See:

* [What are the requirements for Vipps merchants?](requirements-faq.md#what-are-the-requirements-for-vipps-merchants)
* [Can I create a marketplace with multiple merchants?](#can-i-create-a-marketplace-with-multiple-merchants)
* [Can I create a service to match buyers and sellers?](#can-i-create-a-service-to-match-buyers-and-sellers)

## Is it possible for a merchant to pay a Vipps user?

No. Vipps has no functionality for a merchant to paying to a Vipps user,
except for refunding (part of) a payment.

Vipps only has APIs for paying from a person to a merchant.

It is not possible to pay from one merchant to another merchant,
or to pay from a merchant to a person.

There are several reasons for this, including:

* The Norwegian "Straksbetaling" (instant payments) system is not designed
  for this, and not all banks support it.
* There are other account-to-account payment methods, but all have their
  idiosyncrasies, and none are a perfect fit.
* Payouts to cards is different from accounts, and will depend on the PSPs,
  which brings another set of challenges.
* Some merchant accounts require "four eyes" before making payments from them,
  and Vipps does not have this functionality in the API.
* The SCA (Secure Customer Authentication) required by PSD2 further complicates
  payouts, both with an API and on [portal.vipps.no](https://portal.vipps.no).

Vipps does have functionality for getting the user's bank accounts enrolled in
Vipps, with the user's consent. Payments may then be made to the bank account.
See:
[Is there an API for retrieving information about a Vipps user?](#is-there-an-api-for-retrieving-information-about-a-vipps-user)

## I have initiated an order, but I can't find it

For the eCom API, see
[I have initiated an order, but I can't find it](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-faq#i-have-initiated-an-order-but-i-cant-find-it).

## How long is an initiated order valid, if the user does not confirm in the Vipps app?

Vipps orders have a max timeout of 10 minutes: 5 minutes to log in and 5 minutes to confirm the payment.

It's important that the merchant waits (at least) this long, otherwise the Vipps
user may confirm in the Vipps app, and right after get an error from the merchant
that the order has been cancelled.

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

Please check the Vipps payment:

1. Find the Vipps `orderId` for the payment.
2. Log in on [portal.vipps.no](https://portal.vipps.no).
3. Click "Transaksjoner" (*Transactions*) and then "Søk på ID" (*Search for ID*)
4. Search for the `orderId` from step 1.
5. Click the order.
6. See the "History" details.

This is of course also supported in the [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api), and it is a requirement to use
this functionality when integrating with Vipps:
[`GET:/ecomm/v2/payments/{orderId}/details`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)

The user can also check the payment in Vipps:

1. Start Vipps and log in.
2. Press "Payments" on the main screen.
3. Scroll down and press "History"
4. Check the payment and the "Transactions".
5. Verify that the orderId and transaction ID matches the ones in step 6 above.

See:
[For how long is a payment reserved?](reserve-and-capture-faq.md#for-how-long-is-a-payment-reserved)

## In which sequence are callbacks and fallbacks done?

Vipps cannot guarantee a particular sequence, as this depends on user
actions, network connectivity/speed, etc. Because of this, it is not
possible to base an integration on a specific sequence of events.

See:
[Initiate payment flow: Phone and browser](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#initiate-payment-flow-phone-and-browser)

## Where can I find reports on transactions?

[portal.vipps.no](https://portal.vipps.no) provides information about
your transactions, sales units and settlement reports.
You can also subscribe to daily or monthly transaction reports by email.

See: [Settlements](../settlements/README.md).

## When do users get a "soft decline" and need to complete a 3-D Secure verification?

Vipps handles everything related to "soft declines" and 3-D Secure.
Vipps also handles BankID verification, when that is required.
There is nothing a merchant needs to.

Vipps uses delegated SCA (Secure Customer Authentication) from the banks, and
significantly simplifies the user experience, as there is normally no need for
BankID verification.

The biometric login in Vipps is enough.

Vipps uses tokenized cards, which eliminates the need for "soft decline".
As long as the token is valid, the user never has to verify the card again.

In order to prevent misuse and fraud Vipps require users to do a 3-D Secure
verification if the user has paid more than 15 000 NOK during the last five days.

In short: Users paying with Vipps has a much faster and simpler user experience
than when using a card directly.

Vipps also has an extremely low fraud rate, as it is impossible to pay
with a card that has been invalidated in any way by the issuer, and all users
has to log into Vipps with their BankID verified identity to use their card.

## Card payments

The
[ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/)
and the
[Checkout API](https://developer.vippsmobilepay.com/docs/APIs/checkout-api/)
support freestanding card payments:
Users can enter their card details and pay with the card without using the app.
This means that payments are possible also for users in countries where
Vipps and MobilePay are not yet available.

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

**Please note**: Just to avoid confusion: Payments with the app are also done using
the users' cards that they have been added there. The user gets all the benefits of the card,
and since the app has delegated SCA, the user gets a faster and simpler user experience.
See also:
[Direct integration and PSP integration](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/direct-vs-psp/).
