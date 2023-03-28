<!-- START_METADATA
---
title: Vipps landing page
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Direct integration and PSP integration

There are two ways to use Vipps Mobilepay:
* Direct integration: The merchant or partner uses the
  [APIs](https://developer.vippsmobilepay.com/docs/APIs)
  directly:
  [ePayment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api),
  [eCom](https://developer.vippsmobilepay.com/docs/APIs/ecom-api),
  [Checkout](https://developer.vippsmobilepay.com/docs/APIs/checkout-api),
  [Recurring](https://developer.vippsmobilepay.com/docs/APIs/recurring-api),
  [Login](https://developer.vippsmobilepay.com/docs/APIs/login-api)
  [Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api)
  [Order Management](https://developer.vippsmobilepay.com/docs/APIs/order-management-api),
  [QR](https://developer.vippsmobilepay.com/docs/APIs/qr-api),
  etc.
  All the functionality of the APIs can be used, and also combined as dewscribed
  in
  [Solutions](https://developer.vippsmobilepay.com/docs/vipps-solutions).
* PSP integration: The merchants or partner uses the PSPs APIs, which is
  based on our
  [PSP API](https://developer.vippsmobilepay.com/docs/APIs/psp-api).
  The merchants or partner does not have a direct communication with
  Vipps MobilePay, and uses none of our services directly.
  It is not possible to use all functionality provided with direct integration.

## How the PSP API works

The
[PSP API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/psp-api)
provides _tokens_ that a PSP can use to charge a Vipps user's card.

To put it simply, it is a "card token lookup service". The payment is completed
by the PSP, who sends an update to us about the success or failure.

## Benefits of direct integration

The
[ePayment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
and
[eCom](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
APIs have some functionality that is not available in the PSP API:

1. Higher success rate.
   With a direct integration, you have full control over the user flow,
   and use the Vipps MobilePay APIs directly without any additional steps or
   middleware.
   See:
   [High success rate for direct integrations](../faqs/common-problems-faq#high-success-rate-for-direct-integrations).
1. Retry functionality: If the user attempts to pay with a card that is declined,
   the user can retry with a different card, while still in the same payment process.
   This results in a higher success rater for payments.
   The PSP API does not have this functionality, as it is the PSP, not Vipps,
   that make the charge.
2. [Express checkout (Vipps Hurtigkasse)](vipps-ecom-api.md#express-checkout-payments)
   is only available in the Vipps eCom API.
3. [Userinfo](vipps-ecom-api.md#userinfo):
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
success rate is much higher than when using a payment card directly.

When comparing drop-off rates: Remember to compare drop-off data for when the
user _selects_ payment method, do not compare Vipps to numbers for when the
user has selected card payment and already has manually entered the card number, etc:
* Drop-off data for Vipps: Measure the success rate after the user has selected Vipps.
* Drop-off rate for cards: Measure the success rate after the user has selected card,
  but from _before_ the user has to enter the card details.

See:
[Why do payments fail?](../faqs/common-problems-faq#why-do-payments-fail)
