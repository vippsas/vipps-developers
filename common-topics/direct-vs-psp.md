<!-- START_METADATA
---
title: Direct integration and PSP integration
sidebar_label: Direct integration and PSP integration
description: Direct integration and PSP integration
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Direct integration and PSP integration

There are two ways to use Vipps Mobilepay:

* Direct integration: The merchant or partner uses the
  [APIs](https://developer.vippsmobilepay.com/docs/APIs)
  directly
  (e.g., [ePayment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api),
  [eCom](https://developer.vippsmobilepay.com/docs/APIs/ecom-api),
  [Checkout](https://developer.vippsmobilepay.com/docs/APIs/checkout-api),
  [Recurring](https://developer.vippsmobilepay.com/docs/APIs/recurring-api),
  [Login](https://developer.vippsmobilepay.com/docs/APIs/login-api)
  [Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api)
  [Order Management](https://developer.vippsmobilepay.com/docs/APIs/order-management-api),
  [QR](https://developer.vippsmobilepay.com/docs/APIs/qr-api)).
  All the functionality of the APIs can be used, and also combined as described in
  [Solutions](https://developer.vippsmobilepay.com/docs/vipps-solutions).
* PSP integration: The merchant or partner uses the PSPs APIs, which are
  based on our
  [PSP API](https://developer.vippsmobilepay.com/docs/APIs/psp-api).
  The merchant or partner does not have a direct communication with
  Vipps MobilePay, and uses none of our services directly.
  It is not possible to use all functionality provided with direct integration.

## How the PSP API works

The
[PSP API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/psp-api)
provides _tokens_ for payment cards, and the PSP use the token to charge a
Vipps user's payment card.

To put it simply, it is a "card token lookup service": 
The PSP initiates a payment with the PSP API, receives a card token,
use the token to process the payment, and then sends an update to us about
the success or failure of the payment.

## Benefits of direct integration

The
[ePayment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
and
[eCom](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
APIs have some functionality that is not available in the PSP API:

1. Retry functionality: If the user attempts to pay with a card that is declined,
   the user can retry with a different card, while still in the same payment process.
   This results in a higher success rater for payments.
   The PSP API does not have this functionality, as it is the PSP, not Vipps,
   that make the charge.
2. [Express checkout (Vipps Hurtigkasse)](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#express-checkout-payments)
   is only available in the Vipps eCom API.
3. [Userinfo](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#userinfo):
   The Vipps eCom API offers the possibility for merchants to ask for the user's
   profile information as part of the payment flow: name, address, email, phone number, birthdate, etc.
4. When using the Vipps eCom API, Vipps handles soft-declines, 3-D Secure, BankID, etc.
   We have taken care of the regulatory required "secure customer authentication" (SCA),
   so the user gets a simpler and faster user experience.
   This give a consistent user experience and a very high completion rate.
   There is nothing a merchant needs to do.

## Extremely high success rate of direct integrations

We have extremely low drop-off rates for direct integration:
Almost every user that selects to pay with Vipps completes the payment. The
success rate is significantly higher than when using a payment card directly.

When comparing drop-off rates, it is important to compare drop-off data for when the
user _selects_ payment method. Do not compare Vipps to when the
user has selected card payment, but not yet manually entered the card number:

* Drop-off data for Vipps: Measure the success rate after the user has selected Vipps.
* Drop-off rate for cards: Measure the success rate after the user has selected card,
  but _before_ the user must enter the card details.

See:
[Why do payments fail?](../faqs/common-problems-faq#why-do-payments-fail)
