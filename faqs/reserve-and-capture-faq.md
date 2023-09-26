---
title: "FAQ: Reservations and capture"
sidebar_label: Reservations and capture
sidebar_position: 170
pagination_next: null
pagination_prev: null
---

# FAQ: Reservations and capture

## For how long is a payment reserved?

That depends. We don't control the behavior of the customer's card or account.

The details may change, but the information below is the best we can offer.

* VISA reservations are valid for 7 days (but only 5 for Visa Electron).
  The banks will release the reservation after 4-7 days, but if the capture is
  done within the 7 days, VISA guarantees that the capture will succeed.
  Our PSP is Adyen, and they have some documentation for
  [VISA reservations](https://docs.adyen.com/online-payments/adjust-authorisation#visa).

* MasterCard reservations are valid for 30 days.
  The banks may release the reservation before this, but if the capture is
  done within the 30 days, MasterCard guarantees that the capture will succeed.
  Our PSP is Adyen, and they have some documentation for
 [Mastercard reservations](https://docs.adyen.com/online-payments/adjust-authorisation#mastercard).

We can't and don't automatically change the status of a reservation.

If a capture attempt is made more than 7 days (VISA) or 30 days (MasterCard)
after the payment has been initiated, and* the reservation has been released
by the bank in the meantime, we will make a new payment request to the bank.
If the account has sufficient funds, the payment will be successful.

If the user's account has insufficient funds at this time, the payment will
either succeed and put the customer's card/account in the negative (as
an overdraft), or fail because the customer's card/account cannot be put into
the negative - for example youth accounts.
We can't know in advance what will happen.

It is also possible that the card expires, is blocked, etc. somewhere between
the time of reservation and the time of capture.
We can't know in advance what will happen.

In many cases the bank will have a register of expired reservations, and they
will force the capture through if the account allows this.
This will put the account in the negative.

Customers may, understandably, be dissatisfied if the capture puts their account
in the negative, so please avoid this.

Capture can be made up to 180 days after reservation.
Attempting to capture an older payment will result in a
`HTTP 400 Bad Request`.

The
[`POST:/ecomm/v2/payments/{orderId}/capture`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/capturePaymentUsingPOST)
and
[`GET:/ecomm/v2/payments/{orderId}/details`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)
API calls will always return the correct status.

See:
[How can I refund only a part of a payment?](refunds-faq.md#how-can-i-refund-only-a-part-of-a-payment).

## When should I charge the customer?

You should charge the customer when the product or service is delivered.
That is usually when the product is shipped.

According to Norwegian regulations you must *not* capture a payment until the
product or service is provided to the customer. See:
[Forbrukerkjøpsloven §38](https://lovdata.no/lov/1988-05-13-27/§49)
(in Norwegian):

>Følger ikke betalingstiden av avtalen, skal forbrukeren betale når selgeren krever det.
>Hvis ikke noe annet er avtalt, har forbrukeren ikke plikt til å betale kjøpesummen uten at tingen blir overlevert eller stilt til hans eller hennes rådighet i samsvar med avtalen og loven.
>Forbrukeren er ikke bundet av en forhåndsavtale om plikt til å betale på et bestemt tidspunkt uavhengig av om selgeren oppfyller til rett tid.

This roughly translates to:

>If the payment time does not follow the agreement, the consumer must pay when the seller demands it.
>If nothing else has been agreed, the consumer has no obligation to pay the purchase price without the item being handed over or placed at his or her disposal in accordance with the agreement and the law.
>The consumer is not bound by a prior agreement on the obligation to pay at a specific time regardless of whether the seller fulfills on time.

For more information, please see the Consumer Authority's
[Guidelines for the standard sales conditions for consumer purchases of goods over the internet](https://www.forbrukertilsynet.no/english/guidelines/guidelines-the-standard-sales-conditions-consumer-purchases-of-goods-the-internet).

We can't offer legal advice for this.

See more details below:

* [What is the difference between "Reserve Capture" and "Direct Capture"?](#what-is-the-difference-between-reserve-capture-and-direct-capture)
* [When should I use "Direct Capture"?](#when-should-i-use-direct-capture)

## What is the difference between "Reserve Capture" and "Direct Capture"?

When you initiate a payment it will be *reserved* until you *capture* it.
Reserved means the customer has approved the payment. The funds are still
in the customer's account, but not available to spend on other things.
Capture means the funds are moved from customer's account to merchant's account.
We support both *reserve-capture* and *direct capture*:

* *Reserve capture* is the default. When you initiate a payment it will be
  reserved until you capture it. The capture can be done a few seconds later,
  or several days later.
* When *direct capture* is activated, all payment reservations will instantly be
  captured. This is intended for situations where the product or service is
  immediately provided to the customer, and there is no chance that the service
  is not available or sold out, e.g. digital services.
  Direct capture requires additional compliance checks of the merchant.

**Important:** It's completely fine to use "reserve capture" almost exactly like
"direct capture": Just do the capture immediately after the reservation.
The user experience is exactly the same.

Some things to consider:

* If a payment has been *reserved* (as with "reserve capture"), the merchant can
  make a `/cancel` call to immediately release the reservation and make available
  in the customer's account.
* If a payment has been *captured* (as with "direct capture"), the merchant has to
  make a `/refund` call, and it then takes several days before the amount is
  available in the customer's account.
* With "reserve capture" it is possible to reserve a higher amount and only
  capture a part of it (useful for electric car charging stations, etc.).
  It is also possible to capture the full amount
  with multiple captures ("partial capture").

See:

* [When should I charge the customer?](#when-should-i-charge-the-customer)
* [When should I use "Direct Capture"?](#when-should-i-use-direct-capture)
* [How long does it take from a refund is made until the money is in the customer's account?](refunds-faq.md#how-long-does-it-take-from-a-refund-is-made-until-the-money-is-in-the-customers-account)

## When should I use "Direct Capture"?

You can probably use "reserve capture", and just do the capture right after the
reserve. This has some benefits, see the first link below.

See:

* [What is the difference between "Reserve Capture" and "Direct Capture"?](#what-is-the-difference-between-reserve-capture-and-direct-capture)
* [Regular eCommerce payments](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#regular-ecommerce-payments) for more details.

## How can I check if I have "reserve capture" or "direct capture"?

We can no longer manually check this for merchant or partners.

All merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and check the capture type for all their sales units under the "Utvikler" menu item.

You can also find information on how to change capture type there.
We require BankID login for this, as "direct capture" requires additional
compliance checks.

If you are a partner and want to check a merchant, see the
[Management API](https://developer.vippsmobilepay.com/docs/APIs/management-api/).

If you are a partner and do not yet use the Management API, you can ask the
merchant to create a user for you on
[portal.vipps.no](https://portal.vipps.no), so you can check on behalf of the merchant as
[described in detail with screenshots](https://developer.vippsmobilepay.com/docs/partner/add-portal-user).

If you are not able to log in on
[portal.vipps.no](https://portal.vipps.no)
you can make a small payment (2 NOK), check the payment with
[`GET:/ecomm/v2/payments/{orderId}/details`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET),
and cancel (if it was `RESERVE` and reserve capture) or refund (if it was `SALE` and direct capture).

## How do I turn direct capture on or off?

You can't turn *direct capture* on or off as a merchant.
A sales unit can only have one capture type, and we must be configured that.

**Please note:** We only offer "direct capture" to merchants that use
Vipps MobilePay through a partner, and for merchants that have a Key Account Manager.
"Direct capture" must be requested by the partner from the partner manager,
or by KAM merchants from the Key Account Manager.

See:

* [When should I use "Direct Capture"?](#when-should-i-use-direct-capture)
* [What is the difference between "Reserve Capture" and "Direct Capture"?](#what-is-the-difference-between-reserve-capture-and-direct-capture)

## Can I prevent people from paying with credit cards?

Yes, but only if you are not legally allowed to accept credit card payments.

Sales units can be configured to only accept payments from debit cards, so
customers cannot pay with credit cards. This is not configurable by the
merchant. Please [contact us](https://developer.vippsmobilepay.com/docs/contact/) if you need this.

## Can I initiate a payment with a QR code?

Yes, you can do this with the new ePayment API.
See the QR flow under [ePayment API: Create payment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/create/).

## Can I send a payment link in an SMS, QR or email?

No.

The "deeplink" opens the payment page in the Vipps or MobilePay app where the user
accepts a payment. This is an integrated part of the payment process,
and the link should never be sent in an SMS or email.

According to Norwegian regulations the customer needs to actively accept the
terms and conditions for the purchase.
This is not possible if you just send a deeplink.

For more information, please see the Consumer Authority's
[Guidelines for the standard sales conditions for consumer purchases of goods over the internet](https://www.forbrukertilsynet.no/english/guidelines/guidelines-the-standard-sales-conditions-consumer-purchases-of-goods-the-internet).

There are different regulatory requirements for payments that are initiated
by a user and by a merchant.

The deeplink is only valid for 5 minutes, so users that do not act quickly will
not be able to pay. There is no way to "retry" a deeplink after the timeout.
See:
[For how long is a payment reserved?](#for-how-long-is-a-payment-reserved)

Instead of sending a deeplink: Send a link to your website, and let
the user start the Vipps or MobilePay payment there. It can be a very simple page with a link
or a button. You then have the opportunity to give the user additional
information, and also a proper confirmation page after the payment has been completed.

You can also send the customer a link to a pre-filled shopping cart, so the customer
can add more items, and pay with Vipps Hurtigkasse.

In some cases, such as for donations and gifts, it may be acceptable to automatically
trigger the payment when the user enters your website. This requires that the
payment process is user initiated, and that there are no relevant terms and conditions
or that the user has accepted any terms and conditions at an earlier stage.

In general, we advise caution and point out that it is the responsibility of the
merchant to assure that users accept terms and conditions for products and services.

You can also use
[Login](https://developer.vippsmobilepay.com/docs/APIs/login-api)
for easy registration and login.

See:
[eCom deeplink URL](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#the-vipps-deeplink-url).

## Can I sell products on social media?

Yes, but you also need a website.
Vipps MobilePay is required to check your website and that it meets the
requirements set by Norwegian law and regulation.

See:

* [Can I initiate a payment with a QR code?](#can-i-initiate-a-payment-with-a-qr-code)
* [Can I send a payment link in an SMS, QR or email?](#can-i-send-a-payment-link-in-an-sms-qr-or-email)

## Can I whitelist my URL for a QR?

There is no need for whitelisting QR codes any longer. It was previously a temporary solution a merchant to whitelist a URL to support users scanning
a Vipps branded QR to be sent directly to the merchant's URL.

The previous whitelisting functionality has been replaced by the
[QR API](https://developer.vippsmobilepay.com/docs/APIs/qr-api).

The API supports static
[merchant redirect](https://developer.vippsmobilepay.com/docs/APIs/qr-api/vipps-qr-api#merchant-redirect-qr-codes)
with possibility to update the target URL for stickers, billboards, TV-commercials, magazine ads, etc.

The API also support a
[one-time payment QR code](https://developer.vippsmobilepay.com/docs/APIs/qr-api/vipps-qr-api#one-time-payment-qr-codes)
for customer facing screens in POS situations.

