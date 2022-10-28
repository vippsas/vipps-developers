<!-- START_METADATA
---
title: Frequently asked questions
sidebar_position: 60
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Frequently asked questions

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->


Document version 0.0.1.

<!-- START_TOC -->

## Table of contents

* [Requirements](#requirements)
  * [What are the requirements for Vipps merchants?](#what-are-the-requirements-for-vipps-merchants)
  * [Can I use my "Vippsnummer" in my webshop?](#can-i-use-my-vippsnummer-in-my-webshop)
* [Common problems](#common-problems)
  * [Why do payments fail?](#why-do-payments-fail)
  * [Why does Vipps Hurtigkasse (express checkout) fail?](#why-does-vipps-hurtigkasse-express-checkout-fail)
  * [Why does capture fail?](#why-does-capture-fail)
  * [Why do I get a CORS error?](#why-do-i-get-a-cors-error)
  * [How can I open the fallback URL in a specific (embedded) browser?](#how-can-i-open-the-fallback-url-in-a-specific-embedded-browser)
  * [How can I measure Vipps sales with Google Analytics, Facebook pixel, etc?](#how-can-i-measure-vipps-sales-with-google-analytics-facebook-pixel-etc)
  * [Why are the customer names not shown on the transaction overview?](#why-are-the-customer-names-not-shown-on-the-transaction-overview)
* [Reservations and captures](#reservations-and-captures)
  * [For how long is a payment reserved?](#for-how-long-is-a-payment-reserved)
  * [When should I charge the customer?](#when-should-i-charge-the-customer)
  * [What is the difference between "Reserve Capture" and "Direct Capture"?](#what-is-the-difference-between-reserve-capture-and-direct-capture)
  * [When should I use "Direct Capture"?](#when-should-i-use-direct-capture)
  * [How can I check if I have "reserve capture" or "direct capture"?](#how-can-i-check-if-i-have-reserve-capture-or-direct-capture)
  * [How do I turn direct capture on or off?](#how-do-i-turn-direct-capture-on-or-off)
  * [Can I prevent people from paying with credit cards?](#can-i-prevent-people-from-paying-with-credit-cards)
  * [Can I initiate a Vipps payment with a QR code?](#can-i-initiate-a-vipps-payment-with-a-qr-code)
  * [Can I send a Vipps payment link in an SMS, QR or email?](#can-i-send-a-vipps-payment-link-in-an-sms-qr-or-email)
  * [Can I sell products on social media?](#can-i-sell-products-on-social-media)
  * [Can I whitelist my URL for a Vipps QR?](#can-i-whitelist-my-url-for-a-vipps-qr)
  * [Can I use a different currency than NOK?](#can-i-use-a-different-currency-than-nok)
* [Refunds](#refunds)
  * [How can I refund a payment?](#how-can-i-refund-a-payment)
  * [How can I refund only a part of a payment?](#how-can-i-refund-only-a-part-of-a-payment)
  * [How long does it take from a refund is made until the money is in the customer's account?](#how-long-does-it-take-from-a-refund-is-made-until-the-money-is-in-the-customers-account)
* [Users and payments](#users-and-payments)
  * [Is there an API for checking if a number belongs to a Vipps user?](#is-there-an-api-for-checking-if-a-number-belongs-to-a-vipps-user)
  * [Is there an API for retrieving information about a Vipps user?](#is-there-an-api-for-retrieving-information-about-a-vipps-user)
  * [Where can I find information about payment and settlements?](#where-can-i-find-information-about-payment-and-settlements)
  * [Can I split payments to charge a fee?](#can-i-split-payments-to-charge-a-fee)
  * [Can I create a marketplace with multiple merchants?](#can-i-create-a-marketplace-with-multiple-merchants)
  * [Can I create a service to match buyers and sellers?](#can-i-create-a-service-to-match-buyers-and-sellers)
  * [Can I use Vipps for crowdfunding?](#can-i-use-vipps-for-crowdfunding)
  * [Is it possible for a merchant to pay a Vipps user?](#is-it-possible-for-a-merchant-to-pay-a-vipps-user)
  * [I have initiated an order but I can't find it!](#i-have-initiated-an-order-but-i-cant-find-it)
  * [How long is an initiated order valid, if the user does not confirm in the Vipps app?](#how-long-is-an-initiated-order-valid-if-the-user-does-not-confirm-in-the-vipps-app)
  * [How long does it take until the money is in my account?](#how-long-does-it-take-until-the-money-is-in-my-account)
  * [Why has one of my customers been charged twice for the same payment?](#why-has-one-of-my-customers-been-charged-twice-for-the-same-payment)
  * [In which sequence are callbacks and fallbacks done?](#in-which-sequence-are-callbacks-and-fallbacks-done)
  * [Where can I find reports on transactions?](#where-can-i-find-reports-on-transactions)
  * [When do users get a "soft decline" and need to complete a 3-D Secure verification?](#when-do-users-get-a-soft-decline-and-need-to-complete-a-3-d-secure-verification)
* [The Vipps landing page](#the-vipps-landing-page)
  * [Is it possible to skip the landing page?](#is-it-possible-to-skip-the-landing-page)
  * [How can I check if I have skipLandingPage activated?](#how-can-i-check-if-i-have-skiplandingpage-activated)
  * [Can I show the landing page in an iframe?](#can-i-show-the-landing-page-in-an-iframe)
* [Problems for end users](#problems-for-end-users)
  * [Why don't I receive the payment notification?](#why-dont-i-receive-the-payment-notification)
  * [Why am I not sent back to where I came from when I have paid?](#why-am-i-not-sent-back-to-where-i-came-from-when-i-have-paid)
* [Common errors](#common-errors)
  * [Why do I not get callbacks from Vipps?](#why-do-i-not-get-callbacks-from-vipps)
  * [Why do I get `HTTP 401 Unauthorized`?](#why-do-i-get-http-401-unauthorized)
  * [Why do I get `HTTP 403 Forbidden`?](#why-do-i-get-http-403-forbidden)
  * [Why do I get `HTTP 429 Too Many Requests`?](#why-do-i-get-http-429-too-many-requests)
  * [Why do I get `HTTP 404 Not Found`?](#why-do-i-get-http-404-not-found)
  * [Why do I get `HTTP 500 Internal Server Error`?](#why-do-i-get-http-500-internal-server-error)
  * [Why do I get `errorCode 35 "Requested Order not found"`?](#why-do-i-get-errorcode-35-requested-order-not-found)
  * [Why do I get `errorCode 37 "Merchant not available or deactivated or blocked"`?](#why-do-i-get-errorcode-37-merchant-not-available-or-deactivated-or-blocked)
  * [Why do I get "Merchant Not Allowed for Ecommerce Payment"?](#why-do-i-get-merchant-not-allowed-for-ecommerce-payment)
  * [Why do I not get the `sub` from `/details`?](#why-do-i-not-get-the-sub-from-details)
  * [Why do I get `unauthorized_client`?](#why-do-i-get-unauthorized_client)
  * [Why do I get `Payment failed`?](#why-do-i-get-payment-failed)
  * [Why do I get error 81 and `User not registered with Vipps`?](#why-do-i-get-error-81-and-user-not-registered-with-vipps)
  * [Why do I get an error about having Vipps installed and being 15 years old?](#why-do-i-get-an-error-about-having-vipps-installed-and-being-15-years-old)
  * [Why do I get `Invalid MSN: 654321`?](#why-do-i-get-invalid-msn-654321)
* [Other questions](#other-questions)
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
* [Frequently Asked Questions for POS integrations](#frequently-asked-questions-for-pos-integrations)
  * [How do I use the one-time payment QR?](#how-do-i-use-the-one-time-payment-qr)
  * [How can we be whitelisted for `skipLandingPage`?](#how-can-we-be-whitelisted-for-skiplandingpage)
  * [Handling refunds on behalf of other stores](#handling-refunds-on-behalf-of-other-stores)
  * [Distance selling from a POS solution](#distance-selling-from-a-pos-solution)
  * [What is the process to go live in production?](#what-is-the-process-to-go-live-in-production)
  * [Which API keys should I use?](#which-api-keys-should-i-use)
  * [Do we need to support callbacks?](#do-we-need-to-support-callbacks)
  * [How can I check if a person has Vipps?](#how-can-i-check-if-a-person-has-vipps)
  * [How can I save the customer's phone number?](#how-can-i-save-the-customers-phone-number)
  * [How can we mass sign up merchants?](#how-can-we-mass-sign-up-merchants)
* [Questions?](#questions)

<!-- END_TOC -->

## Requirements

### What are the requirements for Vipps merchants?

Vipps merchants (corporate customers) must have a Norwegian organization number
and applications must be signed with Norwegian BankID. Vipps must follow the
regulatory requirements for KYC (Know Your Customer), AML (Anti Money Laundering)
and other risk assessment procedures.

See:
[Getting Started: Requirements](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#requirements)

### Can I use my "Vippsnummer" in my webshop?

No.
[Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
can't be used for
[Vipps på Nett](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/),
[Vipps Logg Inn](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
or
[Vipps Faste Betalinger (Recurring payments)](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/).
You need
[Vipps på Nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/).

The reason for this is that the Norwegian Tax Administration considers
"Vippsnummer" to be cash transactions,
while eCommerce is defined as remote sales (in Norwegian, *fjernhandel*). The regulations
associated with both are different enough to require this policy.

## Common problems

### Why do payments fail?

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
   BankID "kodebrikkke", which they may not have available.
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
See: [Get payment details](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#get-payment-details).

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
[All errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#error-codes).

### Why does Vipps Hurtigkasse (express checkout) fail?

When using Vipps Hurtigkasse (express checkout), Vipps makes a callback to the
merchant's server to retrieve the merchant's shipping methods for the user's
address. Vipps sends the user's address (with the user's consent) to the
merchant, and the merchant responds with the shipping methods and cost.

If the merchant's server is slow, or has a slow internet connection,
the delay may cause Vipps Hurtigkasse to fail due to a timeout.

The solution to this is a faster server and internet connection, or to provide
the shipping methods as part of the payment initiation. See:
[Express checkout API endpoints required on the merchant side](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#express-checkout-api-endpoints-required-on-the-merchant-side).

**Please note:** If you are not shipping any products you should use
[Userinfo](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo)
instead of Vipps Hurtigkasse, so you avoid asking the customer in a pub
for the shipping method for the drinks, etc.

### Why does capture fail?

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

* [Cancelling a pending order](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#cancelling-a-pending-order)
* [For how long is a payment reserved?](#for-how-long-is-a-payment-reserved)

### Why do I get a CORS error?

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

### How can I open the fallback URL in a specific (embedded) browser?

The phone's operating system always opens URLs in the default browser.

This means that the `fallback` URL (the "result page") will be opened in
the default browser. Vipps has no way to open the `fallback` URL in the
embedded browser in Facebook, Instagram, etc. Similarly there is no way
for Vipps to open the `fallback` URL in the same tab that the user came from
before the app-switch.

This means that the merchant must be able to detect or recognize the user
when the `fallback` URL is opened, without relying on session, cookies, etc.

See:
[Recommendations regarding handling redirects](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#recommendations-regarding-handling-redirects).

### How can I measure Vipps sales with Google Analytics, Facebook pixel, etc?

Vipps does not have any functionality for measuring sales with with Google
Analytics, Facebook pixel, etc. Merchants may of course use any service on
their own website, and use a fallback URL (the "result page") to track any
activity. This must be done by the merchant itself.

See:
[Initiate payment flow: Phone and browser](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#initiate-payment-flow-phone-and-browser).

### Why are the customer names not shown on the transaction overview?

The transaction overview on
[portal.vipps.no](https://portal.vipps.no)
shows the customer names for
[Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
payments. For other payments, such as
[Vipps på nett](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
and
[Vipps Faste betalinger (Recurring payments)](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
the `orderId` is shown instead of the customer name.

You can click the little "i" in the header on the transaction overview and see the same info as above.

The `orderId` is specified by the merchant. See the
[orderId recommendations](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#orderid-recommendations).

Use
[Userinfo](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo)
to get customer's consent to share name, email address, etc.

**Please note:** Vippsnummer is not legal for payments where the customer is
not physically present. It does also not comply with "Kassaloven".

## Reservations and captures

### For how long is a payment reserved?

That depends. Vipps does not control the behaviour of the customer's card or account.

The details may change, but the information below is the best Vipps can offer.

* VISA reservations are valid for 7 days (but only 5 for Visa Electron).
  The banks will release the reservation after 4-7 days, but if the capture is
  done within the 7 days, VISA guarantees that the capture will succeed.
  Vipps' PSP is Adyen, and they have some documentation for
  [VISA reservations](https://docs.adyen.com/online-payments/adjust-authorisation#visa).

* MasterCard reservations are valid for 30 days.
  The banks may release the reservation before this, but if the capture is
  done within the 30 days, MasterCard guarantees that the capture will succeed.
  Vipps' PSP is Adyen, and they have some documentation for
 [Mastercard reservations](https://docs.adyen.com/online-payments/adjust-authorisation#mastercard).

Vipps cannot and does not automatically change the status of a reservation.

If a capture attempt is made more than 7 days (VISA) or 30 days (MasterCard)
after the payment has been initiated _and_ the reservation has been released
by the bank in the meantime, Vipps will make a new payment request to the bank.
If the account has sufficient funds, the payment will be successful.

If the user's account has insufficient funds at this time, the payment will
either succeed and put the customer's card/account in the negative (as
an overdraft), or fail because the customer's card/account cannot be put into
the negative - for example youth accounts.
Vipps cannot know in advance what will happen.

It is also possible that the card expires, is blocked, etc somewhere between
the time of reservation and the time of capture.
Vipps cannot know in advance what will happen.

In many cases the bank will have a register of expired reservations and they
will force the capture through if the account allows this.
This will put the account in the negative.

Customers may, understandably, be dissatisfied if the capture puts their account
in the negative, so please avoid this.

Capture can be made up to 180 days after reservation.
Attempting to capture an older payment will result in a
`HTTP 400 Bad Request`.

The
[`POST:/ecomm/v2/payments/{orderId}/capture`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/capturePaymentUsingPOST)
and
[`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)
API calls will always return the correct status.

See:
[How can I refund only a part of a payment?](#how-can-i-refund-only-a-part-of-a-payment).


### When should I charge the customer?

You should charge the customer when the product or service is delivered.
That is usually when the product is shipped.

According to Norwegian regulations you must _not_ capture a payment until the
product or service is provided to the customer. See:
[Forbrukerkjøpsloven §38](https://lovdata.no/lov/1988-05-13-27/§49)
(in Norwegian):


>Følger ikke betalingstiden av avtalen, skal forbrukeren betale når selgeren krever det.
>Hvis ikke noe annet er avtalt, har forbrukeren ikke plikt til å betale kjøpesummen uten at tingen blir overlevert eller stilt til hans eller hennes rådighet i samsvar med avtalen og loven.
>Forbrukeren er ikke bundet av en forhåndsavtale om plikt til å betale på et bestemt tidspunkt uavhengig av om selgeren oppfyller til rett tid.

This roughly translates to:

>If the payment time does not follow the agreement, the consumer must pay when the seller demands it.
>If nothing else has been agreed, the consumer has no obligation to pay the purchase price without the item being handed over or placed at his or her disposal in accordance with the agreement and the law.
>The consumer is not bound by a prior agreement on the obligation to pay at a specific time regardless of whether the seller fulfils on time.

For more information, please see the Consumer Authority's
[Guidelines for the standard sales conditions for consumer purchases of goods over the internet](https://www.forbrukertilsynet.no/english/guidelines/guidelines-the-standard-sales-conditions-consumer-purchases-of-goods-the-internet).

Vipps cannot offer legal advice for this.

See more details below:

* [What is the difference between "Reserve Capture" and "Direct Capture"?](#what-is-the-difference-between-reserve-capture-and-direct-capture)
* [When should I use "Direct Capture"?](#when-should-i-use-direct-capture)

### What is the difference between "Reserve Capture" and "Direct Capture"?

When you initiate a payment it will be _reserved_ until you _capture_ it.
Reserved means the customer has approved the payment. The funds are still
in the customer's account, but not available to spend on other things.
Capture means the funds are moved from customer's account to merchant's account.
Vipps supports both _reserve-capture_ and _direct capture_:

* _Reserve capture_ is the default. When you initiate a payment it will be
  reserved until you capture it. The capture can be done a few seconds later,
  or several days later.
* When _direct capture_ is activated, all payment reservations will instantly be
  captured. This is intended for situations where the product or service is
  immediately provided to the customer, and there is no chance that the service
  is not available or sold out, e.g. digital services.
  Direct capture requires additional compliance checks of the merchant.

**Important:** It's completely fine to use "reserve capture" almost exactly like
"direct capture": Just do the capture immediately after the reservation.
The user experience is exactly the same.

Some things to consider:

* If a payment has been _reserved_ (as with "reserve capture"), the merchant can
  make a `/cancel` call to immediately release the reservation and make available
  in the customer's account.
* If a payment has been _captured_ (as with "direct capture"), the merchant has to
  make a `/refund` call, and it then takes several days before the amount is
  available in the customer's account.
* With "reserve capture" it is possible to reserve a higher amount and only
  capture a part of it (useful for electric car charging stations, etc).
  It is also possible to capture the full amount
  with multiple captures ("partial capture").

See:

* [When should I charge the customer?](#when-should-i-charge-the-customer)
* [When should I use "Direct Capture"?](#when-should-i-use-direct-capture)
* [How long does it take from a refund is made until the money is in the customer's account?](#how-long-does-it-take-from-a-refund-is-made-until-the-money-is-in-the-customers-account)

### When should I use "Direct Capture"?

You can probably use "reserve capture", and just do the capture right after the
reserve. This has some benefits, see the first link below.

See:

* [What is the difference between "Reserve Capture" and "Direct Capture"?](#what-is-the-difference-between-reserve-capture-and-direct-capture)
* [Regular eCommerce payments](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#regular-ecommerce-payments) for more details.

### How can I check if I have "reserve capture" or "direct capture"?

Vipps can no longer manually check this for merchant or partners.

All merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and check the capture type for all their sale units under the "Utvikler" menu item.

You can also find information on how to change capture type there.
We require BankID login for this, as "direct capture" requires additional
compliance checks.

If you are a partner and want to check a merchant, see the
[Partner API](https://github.com/vippsas/vipps-partner-api).

If you are a partner and do not yet use the Partner API, you can ask the
merchant to create a user for you on
[portal.vipps.no](https://portal.vipps.no)
so you can check on behalf of the merchant as
[described in detail with screenshots](https://github.com/vippsas/vipps-partner/blob/main/add-portal-user.md).

If you are not able to log in on
[portal.vipps.no](https://portal.vipps.no)
you can make a small payment (2 kr), check the payment with
[`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET),
and cancel (if it was `RESERVE` and reserve capture) or refund (if it was `SALE` and direct capture).

### How do I turn direct capture on or off?

You can't turn _direct capture_ on or off as a merchant.
A sale unit can only have one capture type, and it must be configured by Vipps.

**Please note:** Vipps only offers "direct capture" for merchants that use
Vipps through a partner, and for merchants that have a Key Account Manager.
"Direct capture"" must be requested by the partner from the partner manager,
or by KAM merchants from the Key Account Manager.

See:

* [When should I use "Direct Capture"?](#when-should-i-use-direct-capture)
* [What is the difference between "Reserve Capture" and "Direct Capture"?](#what-is-the-difference-between-reserve-capture-and-direct-capture)

### Can I prevent people from paying with credit cards?

Yes, but only if you are not legally allowed to accept credit card payments.

Sale units can be configured to only accept payments from debit cards, so
customers cannot pay with credit cards. This is not configurable by the
merchant. Please contact your KAM or
[Vipps Customer Center](https://vipps.no/kontakt-oss/bedrift/vipps/)
if you need this.

### Can I initiate a Vipps payment with a QR code?

It is not possible to use a _static_ QR code to initiate payments with the eCom API.

With the eCom API all payments are initiated by calling
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST),
with a unique `orderId` for each payment.

This is not possible with a static QR code on a sticker, etc, but
_is_ possible if a dynamic (unique per payment) QR can be displayed on a screen
for the Vipps user to scan.

The only ways to initiate Vipps payments from a QR code are:

* Use a dynamic QR code for Vipps eCom. The QR code must identical to the
  Vipps deeplink URL provided in normal eCom payments, which will open
  Vipps. See:
  [Initiate payment flow: API calls](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#initiate-payment-flow-api-calls).
  When the Vipps user scans the QR containing the deeplink URL (with either the camera app or with Vipps),
  Vipps will be opened, and the payment request will be displayed.
  The user then has a few minutes to complete the payment. See:
  [Timeouts](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#timeouts).
* [Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/),
  the solution for flea markets, etc – which does not have any external API.
  This solution uses a static QR code for the sale unit, available on
  [portal.vipps.no](https://portal.vipps.no).
  Vippsnummer cannot be used for online sales, etc, as it does not meet the
  legal requirements.
* [Vipps i terminal](https://www.vipps.no/produkter-og-tjenester/privat/vipps-i-terminal/vipps-i-terminal/):
  Merchant-presented, dynamic QR shown on the display of a payment terminal.

See: [The Vipps QR API](https://github.com/vippsas/vipps-qr-api).

### Can I send a Vipps payment link in an SMS, QR or email?

No.

The Vipps "deeplink" opens the payment page in Vipps where the user
accepts a payment. This is an integrated part of the Vipps payment process,
and the link should never be sent in an SMS or email.

According to Norwegian regulations the customer needs to actively accept the
terms and conditions for the purchase.
This is not possible if you just send a deeplink.

For more information, please see the Consumer Authority's
[Guidelines for the standard sales conditions for consumer purchases of goods over the internet](https://www.forbrukertilsynet.no/english/guidelines/guidelines-the-standard-sales-conditions-consumer-purchases-of-goods-the-internet).

There are different regulatory requirements for payments that are initiated
by a user and by a merchant.

The Vipps deeplink is only valid for 5 minutes, so users that do not act quickly will
not be able to pay. There is no way to "retry" a deeplink after the timeout.
See:
[For how long is a payment reserved?](#for-how-long-is-a-payment-reserved)

Instead of sending a Vipps deeplink: Send a link to your website, and let
the user start the Vipps payment there. It can be a very simple page with a link
or a button. You then have the opportunity to give the user additional
information, and also a proper confirmation page after the payment has been completed.

You can also send the customer a link to a pre-filled shopping cart, so the customer
can add more items, and pay with Vipps Hurtigkasse.

In some cases, such as for donations and gifts, it may be acceptable to automatically
trigger the Vipps payment when the user enters your website. This requires that the
payment process is user initiated, and that there are no relevant terms and conditions
or that the user has accepted any terms and conditions at an earlier stage.

In general we advice caution and point out that it is the responsibility of the
merchant to assure that users accept terms and conditions for products and services.

You can also use
[Vipps Logg Inn](https://github.com/vippsas/vipps-login-api)
for easy registration and login.

See:
[The Vipps deeplink URL](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#the-vipps-deeplink-url).

### Can I sell products on social media?

Yes, but you also need a website.
Vipps is required to check your website and that it meets the
requirements set by Norwegian law and regulation.

See:

* [Can I initiate a Vipps payment with a QR code?](#can-i-initiate-a-vipps-payment-with-a-qr-code)
* [Can I send a Vipps payment link in an SMS, QR or email?](#can-i-send-a-vipps-payment-link-in-an-sms-qr-or-email)

### Can I whitelist my URL for a Vipps QR?

There is no need for whitelisting QR codes any longer. It was previously a temporary solution a merchant to whitelist a URL to support users scanning
a Vipps-branded QR to be sent directly to the merchant's URL.

The previous whitelisting functionality has been replaced by [the Vipps QR API](https://github.com/vippsas/vipps-qr-api).

The API supports static [merchant redirect URLs](https://github.com/vippsas/vipps-qr-api#merchant-redirect-qr) with possibility to update the target URL for stickers, billboards, TV-commercials, magazine ads, etc.

The API also support a [one-time payment QR code](https://github.com/vippsas/vipps-qr-api#one-time-payment-qr) for customer facing screens in POS situations.

### Can I use a different currency than NOK?

Nope. All Vipps payments must be in NOK. Vipps does not do currency conversion.

You will have to make any currency conversion _before_ initiating the Vipps
payment, as the amount specified in the payment initiation is always in NOK,
and in øre (1 NOK = 100 øre).

See: [Regular eCom Payments](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#regular-ecommerce-payments).

## Refunds

### How can I refund a payment?

This depends on your eCommerce solution. The Vipps API supports refunds with
[`POST:/ecomm/v2/payments/{orderId}/refund`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/refundPaymentUsingPOST).
For details on how to offer refunds, please refer to the documentation for your eCommerce solution.

All integrations with the Vipps eCom API _must_  support refunds. See the
[Vipps eCommerce API Checklist](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-checklist.md).

It is also possible to do refunds on
[portal.vipps.no](https://portal.vipps.no).

Refunds can be made up to 365 days after payment or reservation.
Very old payments have a higher risk of being problematic, because people
change banks, leave the country, die, etc,
and this then requires time-consuming manual work.
Vipps therefore limits refunds to 365 days.

### How can I refund only a part of a payment?

Example: A customer has placed an order of of two items for a total of 1000 NOK.
The merchant has initiated a payment of 1000 NOK, but the customer has changed
her mind and only bought one of the items, with a price of 750 NOK. The merchant
has therefore made a
[partial capture](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#partial-capture)
of 750 NOK, and need to refund the remaining 250 NOK.

* The short version: This is done automatically by the bank after a few days.
See:
[For how long is a payment reserved?](#for-how-long-is-a-payment-reserved).

* The long version: It _is_ possible to cancel the remaining reservation after a
partial capture through Vipps: Send a
[`PUT:/ecomm/v2/payments/{orderId}/cancel`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/cancelPaymentRequestUsingPUT)
request with `shouldReleaseRemainingFunds: true` in the body.
The payment must be `RESERVED` for this to take effect.
See:
[Cancelling a partially captured order](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#cancelling-a-partially-captured-order).

The partial capture (the 750 of the 1000 NOK in the example above)
is normally confirmed in the bank after 3-10 days, but it sometimes takes even
longer. When this is done, the bank will make the remaining (250 NOK) available
in the customer's account again. This process depends entirely on the customer's
bank, and Vipps cannot speed it up.

Banks keep reservations for the same number of days regardless of whether there
has been one or more captures. Banks do not extend the reservation if a partial
capture has been made.

If a partial capture has been made, the bank cancels the reservation for the
remaining amount. If no capture has been made, the entire reserved amount is
cancelled. Banks "count the days" from when the reservation was made, so the
merchant must make the capture, or all captures, before the reservation expires.

See: [Settlements](https://github.com/vippsas/vipps-developers/tree/master/common-topics/settlements/).

### How long does it take from a refund is made until the money is in the customer's account?

Normally 2-3 _bank days_, depending on the bank(s).
It can take much longer, up to 10 days, and depends on the bank(s).

Vipps does not have more information than what is available through our API:
[`GET:/ecomm/v2/payments/{orderId}/details`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#get-payment-details).

See: [Settlements](https://github.com/vippsas/vipps-developers/tree/master/common-topics/settlements/).

## Users and payments

### Is there an API for checking if a number belongs to a Vipps user?

No. Vipps does not offer a lookup service for this, as we do not want to
leak information about users. If a payment is initiated for a user that can
not pay businesses, the response will be an error.

Vipps does not distinguish between the following when initiating a payment with
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
and the API call contains a phone number that can not be used to complete the payment:
* Not a Vipps user
* A Vipps user, but too young to pay businesses
* A previous Vipps user that has deleted his/her account
* A Vipps user that has his/her account temporarily or permanently blocked.

### Is there an API for retrieving information about a Vipps user?

Yes. Vipps offers the possibility for merchants to as part of the payment flow in the
[Vipps eCom API: Userinfo](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo)
and
[Vipps Recurring API: Userinfo](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#userinfo).

This is done by adding a `scope` parameter to the initiate calls:
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST) (eCom)
and
[`POST:/recurring/v2/agreements`](https://vippsas.github.io/vipps-recurring-api/#/Agreement%20Controller/draftAgreement) (Recurring):

- address
- birthDate
- email
- name
- phoneNumber
- nin (national identity number, "fødselsnummer")
- accountNumbers

**Please note:** Vipps users have not consented to Vipps providing any
information to third parties, and Vipps does not allow it.
The Vipps user must always give consent to sharing data with a merchant.
There is no other API to look up a user's address, retrieve a user's purchases, etc.

### Where can I find information about payment and settlements?

[portal.vipps.no](https://portal.vipps.no)
provides information about your transactions, sale units and settlement reports.
You can also subscribe to daily or monthly transaction reports by email.

See:

* [Report API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/report-api).
* [Settlements](https://github.com/vippsas/vipps-developers/tree/master/common-topics/settlements/)

### Can I split payments to charge a fee?

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
[What are the requirements for Vipps merchants?](#what-are-the-requirements-for-vipps-merchants)

### Can I create a marketplace with multiple merchants?

We sometimes get questions whether Vipps can support a marketplace or a
shopping center, with multiple merchants. The answer is: That depends.
It may not be as straight-forward as expected, and some typical questions
are covered elsewhere in this FAQ:

* All payments with Vipps must be to a merchant that is a customer of Vipps. See
  [What are the requirements for Vipps merchants?](#what-are-the-requirements-for-vipps-merchants)
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

### Can I create a service to match buyers and sellers?

Companies that receive payments through Vipps must be Vipps customers,
and this is defined in the regulatory approval for Vipps from Finanstilsynet.

If the service receives payment from a buyer and then pays the seller,
so that the service "holds" the money even for a short time, the service
will need the regulatory approval as
[e-pengeforetak (i.e., *e-money institution*)](https://www.finanstilsynet.no/konsesjon/e-pengeforetak/).

If the service sells access, in the form of a subscription or per-use, the
service is _most likely_ a regular Vipps eCom customer, and can use
the
[Vipps eCom API](https://github.com/vippsas/vipps-ecom-api)
or one of our
[plugins](https://github.com/vippsas/vipps-plugins).

Vipps cannot offer legal advice for this.

### Can I use Vipps for crowdfunding?

That depends, but probably: No.

Vipps cannot keep money for merchants.
All Vipps payments must be made to a company that is a customer of Vipps.

See:

* [What are the requirements for Vipps merchants?](#what-are-the-requirements-for-vipps-merchants)
* [Can I create a marketplace with multiple merchants?](#can-i-create-a-marketplace-with-multiple-merchants)
* [Can I create a service to match buyers and sellers?](#can-i-create-a-service-to-match-buyers-and-sellers)

### Is it possible for a merchant to pay a Vipps user?

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
* Payouts to cards is different than accounts, and will depend on the PSPs,
  which brings another set of challenges.
* Some merchant accounts requires "four eyes" before making payments from them,
  and Vipps does not have this functionality in the API.
* The SCA (Secure Customer Authentication) required by PSD2 further complicates
  payouts, both with an API and on [portal.vipps.no](https://portal.vipps.no).

Vipps does have functionality for getting the user's bank accounts enrolled in
Vipps, with the user's consent. Payments may then be made to the bank account.
See:
[Is there an API for retrieving information about a Vipps user?](#is-there-an-api-for-retrieving-information-about-a-vipps-user)

### I have initiated an order but I can't find it!

If you have multiple sale units: Make sure you use the correct API keys, and that
you are not attempting to use one sale unit's API keys to retrieve an order made
by a different sale unit.

Have you, or the eCommerce solution you are using, successfully implemented
[`GET:/ecomm/v2/payments/{orderId}/details`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#get-payment-details)?
This is a requirement, see the
[API checklist](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-checklist.md).

In case the Vipps
[callback](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#callbacks)
fails, you will not automatically receive notification of order status.
The solution is to check with
[`GET:/ecomm/v2/payments/{orderId}/details`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#get-payment-details).

You can use
[Postman](https://github.com/vippsas/vipps-developers/blob/master/developer-resources/quick-start-guides.md)
to manually do API calls, Use the "inspect" functionality to see the complete requests and responses.

See:
[API endpoints](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#api-endpoints).

### How long is an initiated order valid, if the user does not confirm in the Vipps app?

Vipps orders have a max timeout of 10 minutes: 5 minutes to log in and 5 minutes to confirm the payment.

It's important that the merchant waits (at least) this long, otherwise the Vipps
user may confirm in the Vipps app, and right after get an error from the merchant
that the order has been cancelled.

See: [Timeouts](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#timeouts).

### How long does it take until the money is in my account?

See: [Settlements](https://github.com/vippsas/vipps-developers/tree/master/common-topics/settlements/).

### Why has one of my customers been charged twice for the same payment?

Once in a while a customer claims they have "paid double", "paid twice" or similar.

This does not happen, except in _*extremely*_ rare cases where multiple services,
both at Vipps, banks, PSPs, etc fail simultaneously. In reality: This never happens.

The most common reason for misunderstanding is that customers do not understand
the difference between a _reservation_ and a _payment_ and/or that some banks
do not present this to their customers in a way that the customer understands.
Some banks will display the reservation of a payment even _after_ the payment has
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

This is of course also supported in the API, and it is a requirement to use
this functionality when integrating with Vipps:
[`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)

The user can also check the payment in Vipps:

1. Start Vipps and log in.
2. Press "Payments" on the main screen.
3. Scroll down and press "History"
4. Check the payment and the "Transactions".
5. Verify that the orderId and transaction id matches the ones in step 6 above.

See:
[For how long is a payment reserved?](#for-how-long-is-a-payment-reserved)

### In which sequence are callbacks and fallbacks done?

Vipps cannot guarantee a particular sequence, as this depends on user
actions, network connectivity/speed, etc. Because of this, it is not
possible to base an integration on a specific sequence of events.

See:
[Initiate payment flow: Phone and browser](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#initiate-payment-flow-phone-and-browser)

### Where can I find reports on transactions?

[portal.vipps.no](https://portal.vipps.no) provides information about
your transactions, sale units and settlement reports.
You can also subscribe to daily or monthly transaction reports by email.

See: [Settlements](https://github.com/vippsas/vipps-developers/tree/master/common-topics/settlements/).

### When do users get a "soft decline" and need to complete a 3-D Secure verification?

Vipps handles everything related to "soft declines" and 3-D Secure.
Vipps also handles BankID verification, when that is required.
There is nothing a merchant needs to to.

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

## The Vipps landing page

### Is it possible to skip the landing page?

Only in special cases, where displaying it is not possible.

This feature has to be specially enabled by Vipps for eligible sale units:
The sale units must be whitelisted by Vipps.
Skipping the landing page is typically used at physical points of sale
where there is no display available.

The Vipps landing page is more than just a web page, it is an entire
application and it plays an important role in the Vipps payment process.
See the landing page information in the API Guide:
[The Vipps landing page](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#the-vipps-landing-page).

If you need to skip the landing page in a Point of Sale (POS) solution, see:
[What is the process to go live in production?](#what-is-the-process-to-go-live-in-production).

If you need to skip the landing page for a different reason:
Contact your Key Account Manager. If you do not have a KAM:
Please log in on
[portal.vipps.no](https://portal.vipps.no),
open the "Utvikler" (Developer) tab,
find the right sale unit and
click the email link under the "i" information bubble.
Include a detailed description of why it is not possible to display the landing page.

See:
[Skip landing page](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#skip-landing-page)
in the API guide.

### How can I check if I have skipLandingPage activated?

Vipps can no longer manually check this for merchant or partners.

All merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and check if a sale unit has `skipLandingPage` enabled
for all their sale units under the "Utvikler" menu item.

You can also find information on how to activate `skipLandingPage` there.

If you are a partner and want to check a merchant, see the
[Partner API](https://github.com/vippsas/vipps-partner-api).

If you are a partner and do not yet use the Partner API, you can ask the
merchant to create a user for you on
[portal.vipps.no](https://portal.vipps.no)
so you can check on behalf of the merchant as
[described in detail with screenshots](https://github.com/vippsas/vipps-partner/blob/main/add-portal-user.md).

If you are not able to log in on
[portal.vipps.no](https://portal.vipps.no)
you can make a small payment (2 kr)
with `skipLandingPage`.
If you do not get an error, it's active.
If you get an error, it's not active.

See:
[Skip landing page](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#skip-landing-page)
in the API guide.

### Can I show the landing page in an iframe?

No. Never show the Vipps landing page inside an iframe. That will make it
impossible for the user to reliably be redirected back to the merchant's website,
and result in a lower success rate. In general: Any "optimization" of the payment
flow may break the Vipps payment flow - if not today, then later.

See:
[Skip landing page](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#skip-landing-page)
in the API guide.

## Problems for end users

### Why don't I receive the payment notification?

Push notifications must be active for Vipps to send payment notifications.

Push notifications are "best effort", and Vipps cannot guarantee that all
push notifications arrive. It depends on services, networks, etc that Vipps
cannot control.

If Vipps is already open and active when the push notification is received,
the user must press the "Send" button and move to the payments screen to see
the payment notification. Vipps is not able to poll or discover the
payment notification automatically.

### Why am I not sent back to where I came from when I have paid?

If the payment started in a custom browser (like Chrome on iOS, or an embedded
browser in Instagram, instead of the default Safari browser), the `fallback` URL
(the result page) will still be opened in the default browser.

See:

* [How can I open the fallback URL in a specific (embedded) browser?](#how-can-i-open-the-fallback-url-in-a-specific-embedded-browser).
* [Recommendations regarding handling redirects](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#recommendations-regarding-handling-redirects).

## Common errors

### Why do I not get callbacks from Vipps?

Please make sure the URLs you provide to Vipps are reachable from outside your
own environment.

Have a look at the
[Callback](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#callback-endpoints)
section in the API guide, and see
[How to test your own callbacks](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#how-to-test-your-own-callbacks).

If you do not receive a callback, it could be because your firewall is blocking
our requests. See:
[Vipps request servers](https://github.com/vippsas/vipps-developers/blob/master/developer-resources/servers.md#vipps-request-servers).

Please check your own logs for any signs of problems. If your
`orderId` is `acme-shop-123-order123abc`: Search your logs for `acme-shop-123-order123abc`.

Check the API Dashboard on
[portal.vipps.no](https://portal.vipps.no)
for problems with the callbacks. The API Dashboard is under "Utvikler".

### Why do I get `HTTP 401 Unauthorized`?

If you get a `HTTP 401 Unauthorized` response, the reason for the error is in the
response body, such as:

```text
Access denied due to invalid subscription key.
Make sure to provide a valid key for an active subscription.
```

or

```text
Access denied due to missing subscription key.
Make sure to include subscription key when making requests to an API.
```

or

```json
{
  "errorCode":"Unauthorized",
  "errorMessage":"Subscription not found",
  "contextId":"ff0b3ca8-eae5-4e95-9859-6600b2428315"
}
```

You need to check that you are providing the correct API keys.
Please follow these steps to make sure everything is correct:

1. Check that you are using the correct API credentials for the MSN (Merchant Serial Number)
   you are using
   (See
   [Getting started: Quick overview of how to make an API call](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#quick-overview-of-how-to-make-an-api-call) for more details):
   * `client_id`
   * `client_secret`
   * `Ocp-Apim-Subscription-Key` (the subscription key)
2. Check that you are using the same subscription key for both the access token and the payment requests.
   If you have a valid access token, but for a different MSN, you will get an error.
   See:
   [Why do I get `errorCode 35 "Requested Order not found"`?](#why-do-i-get-errorcode-35-requested-order-not-found)
3. Check the swagger specification for the correct spelling of all the header parameters.
   They are case sensitive: `Authorization: Bearer <snip>` is not the same as `Authorization: bearer <snip>`.
4. Make sure you are using the right environment and check that you are using
   the correct API keys for the right sale unit in that environment. The
   [test environment](https://github.com/vippsas/vipps-developers/blob/master/developer-resources/test-environment.md)
   is completely separate from the production environment, and both the MSN and
   the API keys are different.
5. Check both the HTTP response header and the response body from our API for errors.
   For most errors the body contains an explanation of what went wrong.
   See:
   [Errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#errors).
6. If you are a partner and you are using partner keys: Double check everything
   described here:
   [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).
7. Make sure that you are using a valid access token. See
   [Getting started: Get an access token](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#get-an-access-token)
   for details, how long it is valid, etc.

You can log in to
[portal.vipps.no](https://portal.vipps.no)
to double check your API keys, sale units and API products.
See:
[Getting the API keys](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#getting-the-api-keys).

You can use
[Postman](https://github.com/vippsas/vipps-developers/blob/master/developer-resources/quick-start-guides.md)
to manually do API calls, Use the "inspect" functionality to see the complete requests and responses.

You also need to make sure you have access to the right API.
See:
[API products](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#api-products).

See:
[Quick overview of how to make an API call](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#quick-overview-of-how-to-make-an-api-call).

If you are absolutely, completely 100 % sure that you have done everything
correctly, and it _still_ doesn't work, you can regenerate the API keys on
[portal.vipps.no](https://portal.vipps.no).
This should never be necessary, and we cannot think of any situations where
this fixes any known problem, so it's our very last suggestion.
The old API keys will of course stop working when they have been regenerated.

**Important:** Vipps cannot help with the debugging of your code,
we can only help with the API requests and response. Please do not send us your
source code asking us to fix it for you.

### Why do I get `HTTP 403 Forbidden`?

Merchants that only have access to the
[Vipps Login API](https://github.com/vippsas/vipps-login-api)
and attempt to use the Vipps eCom API will get this error, with
`Merchant Not Allowed for Ecommerce Payment` in the body.

This is because the compliance checks required for Vipps eCom API are not
done for merchants that only need the Vipps Login API.
If you need access to the Vipps eCom API, you can apply for it on
[portal.vipps.no](https://portal.vipps.no).

Partners can get this error if they use
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys),
but do not send the
`Merchant-Serial-Number` header.

### Why do I get `HTTP 429 Too Many Requests`?

We rate-limit some API endpoints to prevent incorrect usage.
The rate-limiting has nothing to do with Vipps' total capacity, but is
designed to stop obviously incorrect use.
See:
[Rate limiting](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#rate-limiting)
for details.

### Why do I get `HTTP 404 Not Found`?

It depends. You must check the body of the response.

It could be that you are attempting to call a non-existant API endpoint, and
it could be that you are using the API keys for one MSN for an `orderId`
that belongs to a different MSN.

See: [Why do I get `errorCode 35 "Requested Order not found"`?](#why-do-i-get-errorcode-35-requested-order-not-found).

### Why do I get `HTTP 500 Internal Server Error`?

Something _might_ be wrong on our side and we are working to fix it!

But: It's usually a problem with your request, and that our validation does not catch it.
In other words: We should have returned `HTTP 400 Bad Request`.

Some tips:

* Please make sure the JSON payload in your API request validates.
  That is the most common source of this type of error.
* We strongly recommend using
  [Postman](https://github.com/vippsas/vipps-developers/blob/master/developer-resources/quick-start-guides.md)
  to manually do API calls, to see the correct request.
  Use Postman's
  [Inspect](https://blog.postman.com/debugging-postman-requests/)
  functionality to see the complete request.
* You will get a 500 error if the MSN is sent as an integer:
  `merchantSerialNumber":654321` instead of a string: `merchantSerialNumber":"654321"`.
* The same will happen if the `amount` is not an integer.
* Please check the capitalization of the parameters.
  We will return `HTTP 500 Error` if the incorrect `fallback` is used instead of
  the correct `fallBack`.

Check both the HTTP response header and the response body from our API for errors.
For most errors the body contains an explanation of what went wrong.

**Please note:** If you get a `HTTP 500 Internal Server Error` in the test environment,
it may be a glitch in the SQL server. We are running a "weaker" instance than in
production, and on very rare occasions this can cause SQL errors that result in
a `HTTP 500 Server Error`. Retry the call, and see if it helps.

See:

* [Errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#errors).
* [Status page](https://github.com/vippsas/vipps-developers/blob/master/developer-resources/status-pages.md).

### Why do I get `errorCode 35 "Requested Order not found"`?

This is either because you are specifying an incorrect `orderId`, or because
the payment with this `orderId` was initiated using the API keys for
one sale unit (MSN), and you are attempting to get the details with
the API keys for a different sale unit (MSN).

The `orderId`s is not globally unique, they are only unique per MSN.

See:

* [Why do I get `HTTP 404 Not Found`?](#why-do-i-get-http-404-not-found)
* [Error codes](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#error-codes).

### Why do I get `errorCode 37 "Merchant not available or deactivated or blocked"`?

Or: `Merchant not available or active`.

Please check that the merchant's organization number is still active in
[Brønnøysundregistrene](https://www.brreg.no). Vipps automatically deactivates
merchants (companies) when they are deleted from Brønnøysundregistrene.

Merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and deactivate their sale units. This is sometimes done "by accident", without being
aware of the consequences. If a sale unit has been incorrectly deactivated,
the merchant can reactivate it again.

**Please note:** We require BankID for deactivation and reactivation,
and cannot help with this based on email requests.

Deactivation can also happen if the test merchant is not being used for a _very long_ time.
Please
[contact customer service](https://vipps.no/kontakt-oss/bedrift/vipps/),
and we will reactivate the merchant.

We no longer automatically deactivate test merchants.
Merchants can also create new sale units in the test environment on
[portal.vipps.no](https://portal.vipps.no).

See: [Error codes](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#error-codes).

### Why do I get "Merchant Not Allowed for Ecommerce Payment"?

This error occurs if you attempt to use the Vipps eCom API with a sale unit (MSN)
that is only approved for the Vipps Login API.

Vipps does not do the same checks for sale units that do not make payments,
so to use the eCom API you need to order "Vipps på nett" on
[portal.vipps.no](https://portal.vipps.no)
to go through the regulatory and legally required checks and get
access to the Vipps eCom API.

All sale units that have been approved for the Vipps eCom API can also use
the Vipps Login API, but not the other way around.

See:
[Why do I get `HTTP 403 Forbidden`?](#why-do-i-get-http-403-forbidden)

### Why do I not get the `sub` from `/details`?

If you use the correct `scope` in the payment initiation, but don't get the
`sub` in the response for `/details`: Check that you are following the
[orderId recommendations](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#orderid-recommendations).
Very short orderIds don't work well with our database index, and may cause
an internal timeout, and we "have to" send the response without the `sub`.
We cannot enforce longer orderIds due to backwards compatibility.

### Why do I get `unauthorized_client`?

If you get errors like below from Microsoft Azure, you are not using the right API keys:

```json
{
  "error": "unauthorized_client",
  "error_description":
    "AADSTS70001: Application with identifier 'e9b6c99d-2442-4a5d-84a2-\
     c53a807fe0c4' was not found in the directory testapivipps.no\
     Trace ID: 3bc2b2a0-d9bb-4c2e-8367- 5633866f1300\r\nCorrelation ID:\
     bb2f4093-70af-446a-a26d-ed8becca1a1a\r\nTimestamp: 2017-05-19 09:21:28Z",
  "error_codes": [ 70001 ],
  "timestamp": "2017-05-19 09:21:28Z",
  "trace_id": "3bc2b2a0-d9bb-4c2e-8367-5633866f1300",
  "correlation_id": "bb2f4093-70af-446a-a26d-ed8becca1a1a"
}
```

```json
{
  "error":"unauthorized_client",
  "error_description":
    "AADSTS700016: Application with identifier \'my_client_id\'
     was not found in the directory \'tenant_directory\'.
     This can happen if the application has not been installed
     by the administrator of the tenant or consented to by any
     user in the tenant. You may have sent your authentication
     request to the wrong tenant.",
  "error_codes":[700016],
  "timestamp":"2021-03-23 06:46:31Z",
  "trace_id":"<snip>",
  "correlation_id":"<snip>",
  "error_uri":"https://login.windows.net/error?code=700016"
}
```

To fix this, please check that you are using the right API keys, similar to:
[Why do I get `HTTP 401 Unauthorized`?](#why-do-i-get-http-401-unauthorized).

### Why do I get `Payment failed`?

This error is shown in Vipps if you use Vipps Hurtigkasse (express checkout) and respond
incorrectly to the request for
[`[shippingDetailsPrefix]/v2/payments/{orderId}/shippingDetails`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Merchant-Endpoints/operation/fetchShippingCostUsingPOST).

Please verify that your response is correct.

Also consider using
[static shipping methods](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#shipping-and-static-shipping-details),
as it gives a faster payment process and a better user experience.

### Why do I get error 81 and `User not registered with Vipps`?

The most common reasons are:
* The phone number is incorrectly formatted.
  Vipps attempts to correct incorrectly formatted phone numbers
  instead of responding with `HTTP 400 Bad Request`.
  In cases where the phone number still fails, the error will be `errorCode: 81`.
  See the API specification:
  [`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST).
* The user is under 15 years old and cannot pay businesses.
* The phone number is not for a Vipps user.

Vipps cannot give more details.

### Why do I get an error about having Vipps installed and being 15 years old?

You are probably attempting to use a real Vipps user in the test environment.
See:
[The Vipps Test Environment (MT)](https://github.com/vippsas/vipps-developers/blob/master/developer-resources/test-environment.md).

### Why do I get `Invalid MSN: 654321`?

If you get the error
`"Invalid MSN: 654321. Check your API keys on portal.vipps.no and see the eCom FAQ for tips."`
it is because you are using API keys that are not valid for the specified MSN.

This can happen when:

- A partner tries to use
  [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
  for a sale unit that is not registered with them as partner.
- API keys for the test environment is used in the production environment, or opposite.
- [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
  are used, but the `Merchant-Serial-Number` HTTP header is not used correctly.

## Other questions

### Can you send us logs so we can look for errors?

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

### How do I perform "testing in production"?

To do this you need a live Vipps account.
You can order Vipps on
[portal.vipps.no](https://portal.vipps.no).

We recommend testing with 2 NOK, even though 1 NOK is the smallest possible amount.
1 NOK is not reliable, as it gets low priority in some systems.

### How can I use Vipps for different types of payments?

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

- Each sale unit has its own name presented to the user in Vipps
- Each sale unit has separate transaction logs
- Each sale unit can have its own settlement account. Sharing a single account across multiple sale units is available on request.

### How do I set up multiple sale units?

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
   [settlement files](https://github.com/vippsas/vipps-developers/tree/master/common-topics/settlements/).
   You will need separate API keys for each sale unit (store).
   If you have a Vipps platform partner, the partner will use the
   [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
   for all the sale units.
   See: [How can I use Vipps for different types of payments?](#how-can-i-use-vipps-for-different-types-of-payments).

2: Use only one sale unit (one MSN) for all stores, and use the `orderId` to identify
   which orders belong to which sale units.
   All sale units are in the same
   [settlement report](https://github.com/vippsas/vipps-developers/tree/master/common-topics/settlements/).
   You decide what the `orderId` contains, and it may be up to 50 characters. See:
   [orderId recommendation](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#orderid-recommendations).
   You will use the same API keys for all stores.
   If you have a Vipps platform partner, the partner will use the
   [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
   for all the sale units.

### How can I change my organization number?

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

### What about webhooks?

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

### Can I use Vipps with Klarna Checkout?

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

### What functionality is included in the eCom API, but not the PSP API?

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
3. [Userinfo](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo):
   The Vipps eCom API offers the possibility for merchants to ask for the user's
   profile information as part of the payment flow: name, address, email, phone number, birthdate, etc.
4. When using the Vipps eCom API, Vipps handles soft-declines, 3-D Secure, BankID, etc.
   There is nothing a merchant needs to do.
   This give a consistent user experience and a very high completion rate.

### What do we have to do with PSD2's SCA requirements?

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

### How can I change partner for my integration with Vipps?

See:
[How to change partners for a merchant](https://github.com/vippsas/vipps-partner#how-to-change-partners-for-a-merchant).

**Please note:** The MSN (the number) does _not_ change when changing partners.

## Frequently Asked Questions for POS integrations

POS: Point Of Sale. Think "cash register".

We will improve this section as we learn more. Please suggest improvements
in [Questions](#questions) below.

### How do I use the one-time payment QR?

This feature is for presenting a QR code for opening a payment request from a
customer-facing screen, so there is no need to manually input the mobile number.

Basic flow:

1. Initiate a Vipps eCom payment (`skipLandingPage` must be set to false)
2. Receive the payment URL as response
3. Post the payment URL to the
   [Vipps QR API](https://github.com/vippsas/vipps-qr-api)
4. Receive a URL to a QR code in PNG (Portable Network Graphics) format
5. Present the QR code on the customer-facing screen
6. The user scans the QR code with Vipps or camera app
7. The user pays (or cancels the payment) in Vipps
8. The fallback URL is triggered and will be presented on customers mobile phone

**Please note:**
The customer-facing screen will not show the fallback page. We recommend
presenting the result of the payment in some other way on the screen, and
also that an error messages if something went wrong.

If it is not possible for the POS solution to handle a fallback URL you may use one of the following options:

1. Set fallbackURL to be the merchants website
2. Set fallbackURL to be this Vipps hosted static page: [www.vipps.no/thankyoupage/](https://www.vipps.no/thankyoupage/)

See also:

- [QR API](https://github.com/vippsas/vipps-qr-api/)
- [Error codes](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#error-codes)
- [Do we need to support callbacks?](#do-we-need-to-support-callbacks)

### How can we be whitelisted for `skipLandingPage`?

See: [Is it possible to skip the landing page?](#is-it-possible-to-skip-the-landing-page)

### Handling refunds on behalf of other stores

It may be relevant for enterprise setup, omnichannel, multiple physical stores within the same chain to refund orders on behalf of other stores.

**Prerequisites:**
Stores or a centralized system (e.g. from a headquarter) must have access to all store credentials, or use
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).
Stores must be able to search for `orderId` from other stores or request it from the centralized system.

**User story:** A user buys a product from Store A.
The user then visits Store B to return some goods. Store B wants to be able to refund on behalf of Store A.

**Problem:** Refunds can only be performed by the sale unit where the payment originated from: Store A.

**Recommended solutions:**

**A:** If
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
are used for all stores
Stores must be able to search for `orderId` for payments made in other stores. The cashier can then search and select `orderId` from Store A and click `refund`.  
**Technical:** Use
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
to authenticate, add `Merchant-Serial-Number` from Store A to the request header and original `orderId` to the [refund](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/refundPaymentUsingPOST) request.

NB: With
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
, do not let the cashier input `Merchant-Serial-Number` themselves. These must be locked and connected to the store selection to reduce risk of adding the wrong store.

**B:** If
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
are not used
In this case a centralized system needs to store credentials from all sale units within the enterprise.
Store B must be able to request a `refund` from the sentral system based on the original `orderId` and location for the order origin (Store A).  
**Technical:** Use Store A credentials to authenticate, add original `orderId` to the [refund](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/refundPaymentUsingPOST) request.

**C:** Use same sale unit for all locations
It is possible to use one sale unit (one MSN) for all stores, and use a prefix in the `orderId` to identify which orders belong to which sale units.
This will result in having one settlement for all. You decide what the `orderId` contains, and it may be up to 50 characters. See: [orderId recommendation](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#orderid-recommendations). You will use the same API keys for all stores.

### Distance selling from a POS solution

Due to compliance requirements in a payment situation where customer is not present we recommend implementing the [Order Management API](https://github.com/vippsas/vipps-order-management-api#vipps-order-management-api-v1). This allows the merchants to send rich receipt information to existing Vipps transactions. This information is visible for the customer in the app in their order history.

As an alternative an online sale log must be available for Vipps.

### What is the process to go live in production?

1. The partner establishes a customer relationship with Vipps.
   [Apply here](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/).
2. The partner integrates the POS with Vipps and completes
   [the integration checklist](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-checklist.md).
   The partner now has a working POS integration.
   This process normally takes 1-4 days.
3. The partner's merchant establishes a customer relationship with Vipps.
   [Apply here](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/).
   This process normally takes 1-4 days.
4. If the merchant already has a customer relationship with Vipps, a new sales
   unit must be created, with `skipLandingPage` activated.
   The
   [Vipps customer center](https://vipps.no/hjelp/vipps/)
   can help with this.
   See: [FAQ](#is-it-possible-to-skip-the-landing-page).
5. The POS vendor normally uses
   [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).
   If not: The merchant
   [retrieves the API keys](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#getting-the-api-keys)
   and provides them in a secure way to the partner.
   See: [Which API keys should I use?](#which-api-keys-should-i-use)
6. The partner configures the merchant's POS for Vipps.
7. The merchant can now accept Vipps payments in the POS.

### Which API keys should I use?

You should probably use
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
,and not separate API keys for each of
your merchants. But it depends.

See: [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).

### Do we need to support callbacks?

Please try to implement the API required, even if you do not use the data
provided in the callback. The API Dashboard will show errors if not.

If it is not possible for your POS to support callbacks (no fixed hostname/IP, etc),
you must actively check the payment status with
[``GET:/ecomm/v2/payments/{orderId}/details``](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#get-payment-details).

This is also required if you do support callbacks.

### How can I check if a person has Vipps?

There is no separate API for this, but an attempt to
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
with a phone number that is not registered with Vipps will fail with error 81,
`User not registered with Vipps`.
See: [Error codes](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#error-codes).

Users that install Vipps accept the terms and conditions, including being
"looked up" by the merchant if the payment is initiated with the phone number
is specified.  It is of course possible to pay with Vipps without sharing the
phone number with the merchant.
See
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
for the details of initiating payments with and without phone number.
See also
[privacy and terms](https://vipps.no/vilkar/)
on vipps.no.

There are users with unlisted numbers, users with secret number, etc.
These users can still pay with Vipps, since their phone number is
not shared with anyone without their explicit consent.

### How can I save the customer's phone number?

Vipps does not send the customer's phone number to the merchant. When a customer
enters the phone number on the Vipps landing page, that is only used by Vipps
to send a push alert in Vipps. The number is not passed on to the merchant.

If the POS integration is implemented so that the customer's phone number
is entered in the POS, the merchant can of course save it -
complying with GDPR, etc.

See:

* [Is there an API for retrieving information about a Vipps user?](#is-there-an-api-for-retrieving-information-about-a-vipps-user).
* [The Vipps QR API](https://github.com/vippsas/vipps-qr-api)

### How can we mass sign up merchants?

See: [Vipps Partners: How to sign up new merchants](https://github.com/vippsas/vipps-partner#how-to-sign-up-new-merchants).

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-ecom-api/issues),
a [pull request](https://github.com/vippsas/vipps-ecom-api/pulls),
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).

Sign up for our [Technical newsletter for developers](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters).
