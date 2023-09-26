---
title: "FAQ: Common problems"
sidebar_label: Common problems
sidebar_position: 120
pagination_next: null
pagination_prev: null
---

# FAQ: Common problems

See also
[Common problems](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-faq#common-problems)
in the eCom API FAQs.

## Why do payments fail?

### High success rate for direct integrations

**Please note:** We have extremely high success rate (low drop-off) for direct integration.
Almost every user that selects to pay with Vipps completes the payment. The
success rate is much higher than when using a payment card directly.

When comparing drop-off rates: Remember to compare drop-off data for when the
user *selects* payment method, do not compare Vipps to numbers for when the
user has selected card payment and already has manually entered the card number, etc.:

* Drop-off data for Vipps: Measure the success rate after the user has selected Vipps MobilePay.
* Drop-off rate for cards: Measure the success rate after the user has selected card,
  but from *before* the user has to enter the card details.

The success rate for PSP integrations is not quite as high.
See:
[Direct integration and PSP integration](https://developer.vippsmobilepay.com/docs/common-topics/direct-vs-psp)
and
[Benefits of direct integration](https://developer.vippsmobilepay.com/docs/common-topics/direct-vs-psp#benefits-of-direct-integration).

### Common reasons why payments are not completed

The most common reasons why payments are not completed are:

1. The debit/credit card has expired.
   We notify users in the app in good time before a card expires, but users must
   update the card(s) themselves.
   We verify cards for *every* payment (resulting in an extremely low fraud rate).
   **Please note:** *Vennebetaling* (Person-to-person) uses bank accounts directly, not the card.
   It's therefore possible for a user to pay another person (using the bank account),
   but not be able to pay a merchant (since the card is expired).
2. The debit/credit is no longer valid.
   This can happen when a user has received a new card, but the previous card's
   expiry date has not yet been reached.
   See point 1 above.
3. For freestanding card payments with the
   [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/): If the card issuer does
   not correctly handle the "3D Secure step up", meaning the required secure
   customer identification, the payment will fail. See
   [Card payments](https://developer.vippsmobilepay.com/docs/faqs/users-and-payments-faq/#card-payments).
   Payments also fail if the user is attempting to pay with a card
   from a country that is not allowed.
4. Insufficient funds on the debit/credit card.
   There is not enough money in the debit card's bank account,
   or not enough credit left on the credit card.
   With a direct integration, the user can retry the same payment with a
   different card, and because of this "second chance" the success rate is high.
   See
   [Direct integration and PSP integration](https://developer.vippsmobilepay.com/docs/common-topics/direct-vs-psp/).
5. The debit/credit card has been rejected by the issuer.
   There are many possible reasons for this, and we may not be allowed to
   give the details to the merchant.
   See 1 above.
6. Payment limit reached, BankID required.
   There are some amount limits to prevent misuse and fraud, and when a limit is reached
   the user sometimes (not often) needs to authenticate with BankID, even in Vipps MobilePay.
   Some users *still* need their physical BankID *kodebrikkke* (*code card*), which they may not have available.
7. The payment has timed out.
   This happens if the user does not confirm in the app within 10 minutes
   (5 minutes to log in, then 5 minutes to confirm the payment),
   typically if the user has deactivated push notifications and does not open
   Vipps manually.
   See:
   [Timeouts](https://developer.vippsmobilepay.com/docs/common-topics/timeouts).
8. Attempt to capture an amount that exceeds the reserved amount.
   It's not possible to capture a higher amount than the user has confirmed in Vipps MobilePay.
   Some merchants experience this because of rounding errors on their side.
   See: [Why does capture fail?](#why-does-capture-fail)
9. Attempt to capture an amount that has not been reserved.
   If the user does not confirm the payment in the app, it's impossible for the
   merchant to capture it.
   The payment must have status "reserved" for capture to be possible.
   See: [Why does capture fail?](#why-does-capture-fail)
10. The user has reached the limit for payments within a time period.
   See: [Payment limits, in Norwegian](https://vipps.no/hjelp/vipps/sende-og-motta-penger/har-vipps-belopsgrenser/).

### Investigating problems

We strongly recommend checking the full history of every payment with
the API. You can see if a payment has been actively rejected, if the user has
not done anything, etc.
See: [Get payment details](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#get-payment-details).

We are continuously improving the error messages in the app. Some of the
above errors may only have a general error message when attempting to pay.

**Please note:** We are not allowed to give detailed information about all errors to the
merchant, as some information should only be provided to the user.
We will not "leak" more user details
than we have to. The general rule is that if the problem must be corrected by
the user in the Vipps or MobilePay app, all necessary information will be provided to the user there.

**Tip:** Everyone can test their Vipps or MobilePay app with credit and debit cards in our demo store:
[demo.vipps.no](https://demo.vipps.no).

See:
[All errors](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#error-codes).

## Why does capture fail?

The most common reasons are:

1. Attempt at capturing a higher amount than the one that has been reserved:
   The user has approved a payment in the app, but you attempt to charge more.
2. Attempt at capturing a payment that is not reserved:
   The user has not approved the payment.

All failed capture attempts get an error response from our API.
The response contains the details of why the capture failed.

If the reserved amount is too low for shipping costs to be included, the capture will fail.
The reserved amount must at least as high as the amount that is captured.

Example: If the value of the shopping cart is 1000 NOK, and the reserved amount is 1200 NOK,
the shipping cost can be maximum 200 NOK to be within the reserved amount of 1200 NOK.
If the shipping cost is 300 NOK, a capture of 1000 + 3000 NOK = 1300 NOK will fail.

It is not possible to capture more than the reserved amount, as that would
make this sequence possible:

1. The merchant initiates a payment of 1000 NOK
2. The user confirms the 1000 NOK payment in the app
3. The merchant captures 50 000 NOK from the user

Similarly: It is not possible to capture an amount that is not reserved, as
that would make it possible to charge a user's card without requiring the user
to confirm the payment first.

See:

* [Cancelling a pending order](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#cancelling-a-pending-order)
* [For how long is a payment reserved?](reserve-and-capture-faq.md#for-how-long-is-a-payment-reserved)

## Why do I get a CORS error?

If you get a CORS (Cross-Origin Resource Sharing) error, it is from your side,
not an error from Vipps MobilePay. You are most likely attempting to call an API
from a website, and your web server's configuration prevents it.

CORS is a protocol that enables scripts running on a browser client to interact
with resources from a different origin. Sometimes servers are configured to
prevent this, and that results in a CORS error.

We only receive the API requests over HTTPS, and we have no way of detecting
how the request was made on the caller side - it all looks the same.
We cannot fix the CORS error for you.

You can read more about CORS here:
[CORS Tutorial: A Guide to Cross-Origin Resource Sharing](https://auth0.com/blog/cors-tutorial-a-guide-to-cross-origin-resource-sharing/).

## How can I open the fallback URL in a specific (embedded) browser?

The phone's operating system always opens URLs in the default browser.

This means that the `fallback` URL (the "result page") will be opened in
the default browser. We have no way to open the `fallback` URL in the
embedded browser on Facebook, Instagram, etc. Similarly, there is no way
for us to open the `fallback` URL in the same tab that the user came from
before the app-switch.

This means that the merchant must be able to detect or recognize the user
when the `fallback` URL is opened, without relying on session, cookies, etc.

See:
[Recommendations regarding handling redirects](../common-topics/redirects.md).

## How can I measure Vipps sales with Google Analytics, Facebook pixel, etc.?

We don't have any functionality for measuring sales with Google
Analytics, Facebook pixel, etc. Merchants may of course use any service on
their own website, and use a fallback URL (the "result page") to track any
activity. This must be done by the merchant itself.

See:
[Initiate payment flow: Phone and browser](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#initiate-payment-flow-phone-and-browser).

## Why are the customer names not shown on the transaction overview?

Vipps MobilePay is anonymous, by default. Users can pay through Vipps MobilePay without sharing their
personal data with the merchant. Merchants can use the built-in functionality to
get the user's consent to share personal data - such as phone number, name,
e-mail address and address.
See
[Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api)
and
[Express checkout](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#express-checkout-payments).

The transaction overview on
[portal.vipps.no](https://portal.vipps.no)
and the settlement reports available by e.mail and SFTP show the customer names for
[Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
payments.

For other payments, such as
[*Vipps på nett*](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
and
[*Faste betalinger* (Recurring payments)](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
the `orderId` is shown instead of the customer name.

You can click the little "i" in the header on the transaction overview and see the same info as above.

The `reference` (called `orderId` in the older eCom API) is specified by the merchant. See the
[recommendations for `reference` and `orderId`](../common-topics/orderid.md).

Use
[Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api)
to get the customer's consent to share name, email address, etc.

**Please note:** *Vippsnummer* is not legal for payments where the customer is
not physically present. It does also not comply with the Treasury Act, (*Kassaloven*).
