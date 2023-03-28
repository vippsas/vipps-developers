<!-- START_METADATA
---
title: Direct integration and PSP integration
sidebar_label: Direct integration and PSP integration
description: Direct integration and PSP integration
title: Vipps landing page
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Direct integration and PSP integration

There are two ways to use Vipps MobilePay:
* Direct integration: The merchant or partner uses the
  [APIs](https://developer.vippsmobilepay.com/docs/APIs)
  directly
  (e.g.,
  [ePayment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api),
  [eCom](https://developer.vippsmobilepay.com/docs/APIs/ecom-api),
  [Checkout](https://developer.vippsmobilepay.com/docs/APIs/checkout-api),
  [Recurring](https://developer.vippsmobilepay.com/docs/APIs/recurring-api),
  [Login](https://developer.vippsmobilepay.com/docs/APIs/login-api)
  [Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api)
  [Order Management](https://developer.vippsmobilepay.com/docs/APIs/order-management-api),
  [QR](https://developer.vippsmobilepay.com/docs/APIs/qr-api)),
  etc.
  All the functionality of the APIs can be used, and also combined as described
  in
  [Solutions](https://developer.vippsmobilepay.com/docs/vipps-solutions).
* PSP integration: The merchant or partner uses the PSP's API, which is
  based on our
  [PSP API](https://developer.vippsmobilepay.com/docs/APIs/psp-api).
  The merchant or partner does not have a direct communication with
  Vipps MobilePay, and uses none of our services directly.
  Without a direct integration it is not possible to use all functionality
  provided by our APIs.

## How the PSP API works

The
[PSP API](https://developer.vippsmobilepay.com/docs/APIs/psp-api)
provides _tokens_ that a PSP can use to charge a Vipps user's card.

To put it simply, it is a "card token lookup service". The payment is completed
by the PSP, who sends an update to us about the success or failure.

## Benefits of direct integration

The
[ePayment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
and
[eCom](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
APIs have some functionality that is not available in the PSP API:

1. Direct integration allows you to have more control over the payment process
   and to customize it to your specific needs. This can lead to a better user
  experience for your customers and can help to increase conversions.
2. Higher success rate.
   With a direct integration, you have full control over the user flow,
   and use the Vipps MobilePay APIs directly without any additional steps or
   middleware.
   See:
   [High success rate for direct integrations](../faqs/common-problems-faq#high-success-rate-for-direct-integrations).
3. Retry functionality: If the user attempts to pay with a card that is declined,
   the user can retry with a different card, while still in the same payment process.
   This results in a higher success rater for payments.
   The PSP API does not have this functionality, as it is the PSP, not Vipps,
   that make the charge.
4. [Express checkout (Vipps Hurtigkasse)](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#express-checkout-payments)
   is only available in the Vipps eCom API.
5. [Userinfo](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#userinfo):
   The Vipps eCom API offers the possibility for merchants to ask for the user's
   profile information as part of the payment flow: name, address, email, phone number, birthdate, etc.
6. When using the
   [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
   and
   [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api),
   Vipps handles soft-declines, 3-D Secure, BankID, etc.
   We have taken care of the regulatory required "secure customer authentication" (SCA),
   as we have regulatory approved _delegated SCA_ from the card issuers.
   This means that Vipps MobilePay takes care of the SCA requirements when the
   user logs into the app, and the need for additional SCA is eliminated.
   The user gets a simpler and faster user experience
   and a extremely high completion rate.
   See:
   [When do users get a "soft decline" and need to complete a 3-D Secure verification?](https://developer.vippsmobilepay.com/docs/vipps-developers/faqs/users-and-payments-faq#when-do-users-get-a-soft-decline-and-need-to-complete-a-3-d-secure-verification)

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
