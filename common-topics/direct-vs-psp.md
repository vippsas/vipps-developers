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

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/vipps-developers/).
<!-- END_COMMENT -->

There are two ways to use Vipps MobilePay:

* Direct integration: The merchant or partner uses the
  [APIs](https://developer.vippsmobilepay.com/docs/APIs)
  directly
  (e.g.,
  [ePayment](https://developer.vippsmobilepay.com/docs/APIs/epayment-api),
  [eCom](https://developer.vippsmobilepay.com/docs/APIs/ecom-api),
  [Checkout](https://developer.vippsmobilepay.com/docs/APIs/checkout-api),
  [Recurring](https://developer.vippsmobilepay.com/docs/APIs/recurring-api),
  [Login](https://developer.vippsmobilepay.com/docs/APIs/login-api),
  [Userinfo](https://developer.vippsmobilepay.com/docs/APIs/userinfo-api),
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
provides *tokens* for the users' payment cards.
The PSPs uses the token charge a Vipps user's card.

To put it simply, The PSP API is a "card token lookup service". The PSP uses the
token to process the payment, and then send us an update to us about the success
or failure.

## Benefits of direct integration

The
[ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
(and
[eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api))
provides important functionality that is not available in the PSP API:

1. Direct integration gives you more control over the integration - and the user experience -
   and lets you customize it to your specific needs. This leads to a better user
   experience for your customers and also increased conversion.
2. [Extremely high completion rate](../faqs/common-problems-faq.md#high-success-rate-for-direct-integrations).
   With a direct integration, you use the Vipps MobilePay APIs directly without
   any additional steps or middleware.
3. Retry functionality: If the user attempts to pay with a card that is declined,
   the user can retry with a different card, while still in the same payment process.
   This results in a higher success rater for payments.
   The PSP API does not have this functionality, as it is the PSP, not Vipps,
   that (attempts or) makes the charge.
4. With direct integration there need for the user to confirm with 3D Secure, BankID, etc.,
   as this additional security provided when logging into the Vipps MobilePay app.
   We have taken care of the regulatory required "strong customer authentication"
   ([SCA, required by the Payment Services Directive 2, PSD2](https://en.wikipedia.org/wiki/Strong_customer_authentication)),
   as we have regulatory approved *delegated SCA* from the card issuers.
   Details:
   [When do users get a "soft decline" and need to complete a 3-D Secure verification?](https://developer.vippsmobilepay.com/docs/vipps-developers/faqs/users-and-payments-faq#when-do-users-get-a-soft-decline-and-need-to-complete-a-3-d-secure-verification)
5. [Express checkout](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#express-checkout-payments),
   where the user selects shipping address and shipping method in the Vipps MobilePay app,
   is only available with direct integration.
6. [Userinfo](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#userinfo),
   which lets merchants ask for the user's profile information
   (name, address, email, phone number, birthdate, etc.)
   as part of the payment flow, is only available with direct integration.
7. With direct integrations the merchant is guaranteed to get the money,
   as Vipps Mobilepay takes the risk in case of fraud.

## Extremely high success rate of direct integrations

We have extremely high success rate (low drop-off) for direct integration:
Almost every user that selects to pay with Vipps completes the payment. The
success rate is significantly higher than when using a payment card directly.

When comparing success rates: Remember to compare data for when the
user *selects* payment method, do not compare Vipps to numbers for when the
user has selected card payment and already has manually entered the card number, etc.:

* Drop-off data for Vipps: Measure the success rate after the user has selected Vipps.
* Drop-off rate for cards: Measure the success rate after the user has selected card,
  but from *before* the user has to enter the card details.

Users that select Vipps will simply have to use biometric log-in to the app and
confirm the payment. Very, very simple.

See:
[Why do payments fail?](../faqs/common-problems-faq.md#why-do-payments-fail)
