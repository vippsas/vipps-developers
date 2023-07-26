---
title: Landing page
sidebar_label: Landing page
pagination_next: null
pagination_prev: null
---

# Landing page

The landing page is mandatory for payments initiated on a different device than the user's phone.
It provides a consistent and recognizable user experience
that helps guide the user through the payment flow.

Our data shows that the landing page gives a higher success rate and lower drop-off,
because the users get a familiar user experience and know the payment flow.
In this way, Vipps takes responsibility for helping the user from the browser to the app,
and to complete the payment in a familiar way.

## MobilePay landing page

A MobilePay landing page will be provided in the future, but we don't know the details yet.
We'll get back to this soon.

## Vipps landing page

### User flow

When a payment is initiated, the user is directed to a `url` which will either open.
the Vipps app or the landing page:

* In a mobile browser, the Vipps app will automatically be opened with app-switch.
  The result is the same for the `vipps://` and the `https://` URLs.
  This is done by the phone's operating system. It recognizes that the `https://`
  URL for the landing page is a Vipps URL, and knows that it should open the
  Vipps app instead of the opening it in a web browser.
* In a desktop browser, the landing page will prompt the user for the phone number
  (the number may also be pre-filled, as described in
  [the user's phone number](#the-users-phone-number) section).
  The user enters or confirms the phone number.
  It is also possible to enter another Vipps user's number, to have that
  person complete the payment.

![The landing page](images/vipps-flow-landing-page.png)

### The user's phone number

The user's phone number can be set in the payment initiation call. It is
remembered by the user's browser, eliminating the need for re-typing it on
subsequent purchases.

In some cases, one user will start the payment process, but the actual payment
will be made by another user. The landing page makes this possible, since
the phone number can be changed.
A typical example is one user that is below
15 years old, and therefore cannot pay to businesses, will let another Vipps
user complete the payment.

See:
[Is it possible to prevent the user from editing the phone number?​](https://developer.vippsmobilepay.com/docs/vipps-developers/faqs/landing-page-faq#is-it-possible-to-prevent-the-user-from-editing-the-phone-number).

### Never display the landing page in an iframe

**Important:** Never show the landing page inside an iframe. See:
[Can I show the landing page in an iframe?​](https://developer.vippsmobilepay.com/docs/vipps-developers/faqs/landing-page-faq#can-i-show-the-landing-page-in-an-iframe).

This is applicable to:

* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
* [Partner API](https://developer.vippsmobilepay.com/docs/APIs/partner-api)
* [PSP API](https://developer.vippsmobilepay.com/docs/APIs/psp-api)
* [Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api)

### Generating a QR code to the landing page

If you have user-facing display, you may want to generate a QR code based on the
landing page URL, instead of asking the user for their phone number. Scanning
the QR code will take the user directly to the payment in the Vipps app.

![Demo QR code](images/demo-qr.png)

This is done in cooperation with the QR API. See
[One-time payment QR](https://developer.vippsmobilepay.com/docs/APIs/qr-api/vipps-qr-api#one-time-payment-qr-codes)
for more details about this and other QR services.

See the
[Quick start](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/quick-start/)
for step-by-step examples of generating QR codes and short links for one-time payments initiated from the ePayment API.

### Skip landing page

**Please note:** This functionality is only available for special cases.
Skipping the landing page is only allowed when it is not possible to show it.

Skipping the landing page is reserved for when the payment is initiated on a
device that the user does not own or control:

* Not on the user's phone
* Not on the user's computer
* On a device that has no user-facing display where the landing page can be
  shown, such as physical points of sale (POS) solutions, vending machines, etc.

This `skipLandingpage` functionality must be specially enabled by Vipps MobilePay for each
sales unit that needs it.
If you need to skip the landing page, contact your
Key Account Manager. If you do not have a KAM, please log in on
[portal.vipps.no](https://portal.vipps.no),
find the right sales unit and click the email link under the "i" information
bubble. Include a detailed description of why it is not possible to display
the landing page.

**Please note:** When using `skipLandingPage`, the user is not sent to a URL
after completion of the payment. The "result page" is just the confirmation in
the Vipps app. The required parameter `returnUrl` (called `fallback` for the eCom API)
is not used, so you can provide any URL as that value.

**Important:** When using `"skipLandingPage": true` in the API request that
initiates the payment:

* Vipps will send a push notification immediately to the Vipps app
  for the user with the specified phone number, without showing the landing page.
* It is crucial to use the correct format for the user's phone number.
  If not, the payment will fail.
* The user is not able to provide a different phone number for completing the
  payment. This means that a "Vipps for those under 15" (that cannot pay
  businesses) cannot have someone else pay for them.
* The user is not sent to a return URL (the result page) after completion
  of the payment.
  Instead of the "result page", the user will just get a confirmation in
  the Vipps app.
* If the sales unit is not whitelisted, the request will fail and an error
  message will be returned.

See:
[Is it possible to skip the landing page?](../faqs/landing-page-faq.md#is-it-possible-to-skip-the-landing-page.)

### Sequence diagram

This sequence diagram shows the difference between the normal flow and
the flow with `"skipLandingPage": true`:

```mermaid
sequenceDiagram
    participant M as Merchant
    participant API as Vipps MobilePay API
    participant LP as Landing page
    participant App as Vipps app
    actor U as User
    M-->>API: Initiate payment<br/>with or without skipLandingPage
    alt Normal flow
        API-->>LP: Show the landing page
        U-->>LP: Confirm/enter/change phone number
        LP-->>API: Phone number
    end
    API-->>App: Push message: "Payment request"
    U-->>App: Confirms payment
    App-->>API: Payment confirmed
    API-->>M: Payment confirmed
    alt Normal flow
        API-->>U: Show the merchant's result page
    else skipLandingpage: true
        App-->>U: Payment confirmation in app only
    end
```

See:

* [Is it possible to skip the landing page](../faqs/landing-page-faq.md#is-it-possible-to-skip-the-landing-page)
* [How can I check if I have skipLandingPage activated?](../faqs/landing-page-faq.md#how-can-i-check-if-i-have-skiplandingpage-activated)
