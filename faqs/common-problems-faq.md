<!-- START_METADATA
---
title: "FAQ: Common problems"
sidebar_label: Common problems
sidebar_position: 20
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# FAQ: Common problems

See also
[Common problems](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api-faq#common-problems)
in the eCom API FAQs.

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

## Table of contents

* [Why do payments fail?](#why-do-payments-fail)
* [Why does capture fail?](#why-does-capture-fail)
* [Why do I get a CORS error?](#why-do-i-get-a-cors-error)
* [How can I open the fallback URL in a specific (embedded) browser?](#how-can-i-open-the-fallback-url-in-a-specific-embedded-browser)
* [How can I measure Vipps sales with Google Analytics, Facebook pixel, etc?](#how-can-i-measure-vipps-sales-with-google-analytics-facebook-pixel-etc)
* [Why are the customer names not shown on the transaction overview?](#why-are-the-customer-names-not-shown-on-the-transaction-overview)

<!-- END_COMMENT -->

## Why do payments fail?

The most common reasons are:

1. The debit/credit card has expired.
   Vipps notifies users in good time before a card expires, but users must
   update the card(s) themselves.
   Vipps verifies cards for _every_ payment (resulting in an extremely low fraud rate).
   **Please note:** Vennebetaling (P2P) uses bank accounts directly, not the card.
   It's therefore possible for a user to pay another person (using the bank account),
   but not be able to pay a merchant (since the card is expired).
2. The debit/credit is no longer valid.
   This can happen when a user has received a new card, but the previous card's
   expiry date has not yet been reached.
   See 1. above.
3. Insufficient funds on the debit/credit card.
   There is not enough money in the debit card's bank account,
   or not enough credit left on the credit card.
4. The debit/credit card has been rejected by the issuer.
   There are many possible reasons for this, and Vipps may not be allowed to
   give the details to the merchant.
   See 1. above.
5. Payment limit reached.
   There are some amount limits to prevent misuse and fraud.
   The user sometimes (not often) needs to authenticate with BankID in Vipps.
   Some users _still_ do not use the BankID app or "BankID på mobil" and need their
   BankID "kodebrikkke" (_code card_), which they may not have available.
6. The payment has timed out.
   This happens if the user does not confirm in Vipps within 10 minutes
   (5 minutes to log into Vipps, then 5 minutes to confirm the payment),
   typically if the user has deactivated push notifications and does not open
   Vipps manually.
7. Attempt to capture an amount that exceeds the reserved amount.
   It's not possible to capture a higher amount than the user has confirmed in Vipps.
   Some merchants experience this because of rounding errors on their side.
   See: [Why does capture fail?](#why-does-capture-fail)
8. Attempt to capture an amount that has not been reserved.
   If the user does not confirm the payment in Vipps, it's impossible for the
   merchant to capture it.
   The payment must have status "reserved" for capture to be possible.
   See: [Why does capture fail?](#why-does-capture-fail)

We strongly recommend to check the full history of every Vipps payment with
the API: You can see if a payment has been actively rejected, if the user has
not done anything, etc.
See: [Get payment details](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#get-payment-details).

We are continuously improving the error messages in the Vipps app. Some of the
above errors may only have a general error message when attempting to pay.

**Please note:** Vipps is not allowed to give detailed information about all errors to the
merchant, as some information should only be provided to the Vipps user.
Vipps also generally wants to be on the user's side and not "leak" more details
than we have to. The general rule is that if the problem must be corrected by
the user in Vipps, all necessary information will be provided to the user in Vipps.

**Tip:** Everyone can test their Vipps credit and debit cards in our demo store:
[demo.vipps.no](https://demo.vipps.no).

See:
[All errors](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#error-codes).

## Why does capture fail?

The most common reasons are:

1. Attempt at capturing a higher amount than the one that has been reserved:
   The user has approved a payment in Vipps, but you attempt to charge more.
2. Attempt at capturing a payment that is not reserved:
   The user has not approved the payment in Vipps.

All failed capture attempts get an error response from our API.
The response contains the details of why the capture failed.

If the reserved amount is too low for shipping costs to be included, the capture will fail.
The reserved amount must at least as high as the amount that is captured.

Example: If the value of the shopping cart is 1000 NOK, and the reserved amount is 1200 NOK,
the shipping cost can be maximum 200 NOK to be within the reserved amount of 1200 NOK.
If the shipping cost is 300 kr, a capture of 1000 + 3000 kr = 1300 NOK will fail.

It is not possible to capture more than the reserved amount, as that would
make this sequence possible:

1. The merchant initiates a payment of 1000 NOK
2. The user confirms the 1000 NOK payment in Vipps
3. The merchant captures 50 000 NOK from the user

Similarly: It is not possible to capture an amount that is not reserved, as
that would make it possible to charge a user's card without requiring the user
to confirm the payment in Vipps first.

See:

* [Cancelling a pending order](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#cancelling-a-pending-order)
* [For how long is a payment reserved?](reserve-and-capture-faq.md#for-how-long-is-a-payment-reserved)

## Why do I get a CORS error?

If you get a CORS (Cross-Origin Resource Sharing) error, it is from your side,
not an error from Vipps. You are most likely attempting to call the Vipps API
from a website, and your web server's configuration prevents it.

CORS is a protocol that enables scripts running on a browser client to interact
with resources from a different origin. Sometimes servers are configured to
prevent this, and that results in a CORS error.

Vipps only receives the API requests over HTTPS, and has no way of detecting
how the request was made on the caller side - it all looks the same.
We cannot fix the CORS error for you.

You can read more about CORS here:
[CORS Tutorial: A Guide to Cross-Origin Resource Sharing](https://auth0.com/blog/cors-tutorial-a-guide-to-cross-origin-resource-sharing/).

## How can I open the fallback URL in a specific (embedded) browser?

The phone's operating system always opens URLs in the default browser.

This means that the `fallback` URL (the "result page") will be opened in
the default browser. Vipps has no way to open the `fallback` URL in the
embedded browser in Facebook, Instagram, etc. Similarly there is no way
for Vipps to open the `fallback` URL in the same tab that the user came from
before the app-switch.

This means that the merchant must be able to detect or recognize the user
when the `fallback` URL is opened, without relying on session, cookies, etc.

See:
[Recommendations regarding handling redirects](../common-topics/redirects.md).

## How can I measure Vipps sales with Google Analytics, Facebook pixel, etc?

Vipps does not have any functionality for measuring sales with with Google
Analytics, Facebook pixel, etc. Merchants may of course use any service on
their own website, and use a fallback URL (the "result page") to track any
activity. This must be done by the merchant itself.

See:
[Initiate payment flow: Phone and browser](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#initiate-payment-flow-phone-and-browser).

## Why are the customer names not shown on the transaction overview?

Vipps is anonymous be default: Users can pay with Vipps without sharing their
personal data with the merchant. Merchants can use the built-in functionality to
get the user's consent to share personal data -  such as phone number, name,
e-mail address and address.
See
[Userinfo](https://vippsas.github.io/vipps-developer-docs/docs/APIs/userinfo-api)
and
[Express checkout](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#express-checkout-payments).

The transaction overview on
[portal.vipps.no](https://portal.vipps.no)
and the settlement reports available by e.mail and SFTP show the customer names for
[Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
payments. 

For other payments, such as
[Vipps på nett](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
and
[Vipps Faste betalinger (Recurring payments)](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
the `orderId` is shown instead of the customer name.

You can click the little "i" in the header on the transaction overview and see the same info as above.

The `orderId` is specified by the merchant. See the
[orderId recommendations](../common-topics/orderid.md).

Use
[Userinfo](https://vippsas.github.io/vipps-developer-docs/docs/APIs/userinfo-api)
to get the customer's consent to share name, email address, etc.

**Please note:** Vippsnummer is not legal for payments where the customer is
not physically present. It does also not comply with the Treasury Act, (_Kassaloven_).
