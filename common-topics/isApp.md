---
title: isApp
pagination_next: null
pagination_prev: null
---

# Using the isApp feature

## isApp flow

The information below is valid for the
[eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api/#payments-initiated-in-an-app)
and
[Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api/#accept-an-agreement).

It is possible to perform manual handling of the interaction between the user's Vipps app and the Vipps backend, although this is not recommended.

The flow is as follows:

1. The merchant initiates the payment in the [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api/#payments-initiated-in-an-app)
or
[Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api/#accept-an-agreement) with `isApp: true`.
2. In response, Vipps returns a *deeplink* URL in the `vipps://` format.
3. The merchant uses the *deeplink* URL to invoke Vipps. (*Note:* Always use this URL *exactly* as it is sent from Vipps.)
4. The Vipps app opens automatically, without the user having to click *OK* or *Accept*.
5. The user accepts (or rejects) the payment request in the app.
6. The backend makes a call to the merchant's `callbackPrefix` with information about the payment.
7. When the payment process is completed, the merchant is redirected to the `fallBack` URL.

**Please note:** The user must always be sent *directly* to the deeplink.
Rewriting the deeplink URL in any way may break the payment process.

The deeplink URL is only valid for five minutes.
Attempts at using it after that will result in a timeout and an error.

See:

* [Timeouts](timeouts.md)
* [Can I send a payment link in an SMS, QR or email?](../faqs/reserve-and-capture-faq.md#can-i-send-a-payment-link-in-an-sms-qr-or-email)

## Important information when using isApp

**Important:** Using `isApp` comes with some extra responsibility:

* The merchant's native app must ensure that the user's phone can open the
  `vipps://` deeplink, because the [landing page](landing-page.md)
  will not be shown to the user, and it will therefore not be possible to
  enter a phone number and pay with Vipps MobilePay on another device.
* If your customers use a native app: Remember that some iOS users
  may install the app on an iPad where they don't have Vipps MobilePay installed. If you
  initiate payments with `isApp: true`, the app will try to open `vipps://` on
  the iPad, but since Vipps MobilePay is not installed "nothing will happen", and the user will
  not be able to pay. When you don't send `isApp`, the built-in logic will
  fix things for you, and display the
  [landing page](landing-page.md)
  instead.
* Vipps MobilePay requires a minimum version of the phone's operating system. At the time
  of writing this is iOS 12 (from 2018) or Android 6 (from 2015). If the user
  has an older version of the operating system, Vipps MobilePay cannot be used.
  The merchant must keep track of this by checking the Apple App Store and
  Google Play.
* If `isApp: true` is used in an embedded web browser, such as
  Instagram or Facebook, the `vipps://` URL will not work, since the
  embedded browser does not know what to do with it.
  The user will get an error from the embedded browser, or "nothing will happen".

## Technical details

If the payment is initiated in a native app, it is possible to explicitly force
a `vipps://` URL by sending the optional `isApp` parameter in the initiate call:

* `isApp: false` (or not sent at all): The URL is `https://`, which handles
  everything automatically for you.
  The phone's operating system will know, through "universal linking", that
  the `https://api.vipps.no` URL should open the app, and not the default
  web browser.
  **Please note:** In some cases, this requires the user to approve that
  the app is opened, but this is usually only the first time.
* `isApp: true`: The URL is for a deeplink, for forced app-switch to Vipps, with `vipps://`.
  **Please note:** In our test environment (MT), the scheme is `vippsMT://`

If the user doesn't have the app installed:

* `isApp:false` (or not sent at all): The
   [landing page](landing-page.md)
   will be shown, and the user can enter a phone number and pay on a device
   with the Vipps or MobilePay app installed.
* `isApp: true`: The user will get an error message saying that the link can
  not be opened. Or, depending on the native app, nothing will happen.

### Example responses

Example: Response body for `isApp:false` (or not sent at all):

```json
{
  "orderId": "acme-shop-123-order123abc",
  "url": "https://api.vipps.no/dwo-api-application/v1/deeplink/vippsgateway?v=2&token=eyJraWQiOiJqd3RrZXkiLC <truncated>"
}
```

Example: Response body for `isApp:true`, with a forced app-switch to Vipps:

```json
{
  "orderId": "acme-shop-123-order123abc",
  "url": "vipps://?token=eyJraWQiOiJqd3RrZXkiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiO <truncated>"
}
```

