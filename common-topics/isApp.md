<!-- START_METADATA
---
title: isApp
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# isApp

If the payment is initiated in a native app, it is possible to explicitly force
a `vipps://` URL by sending the optional `isApp` parameter in the initiate call:

* `"isApp": false` (or not sent at all): The URL is `https://`, which handles
  everything automatically for you.
  The phone's operating system will know, through "universal linking", that
  the `https://api.vipps.no` URL should open the Vipps app, and not the default
  web browser.
  **Please note:** In some cases, this requires the user to approve that
  Vipps is opened, but this is usually only the first time.
* `"isApp": true`: The URL is for a deeplink, for forced app-switch to Vipps, with `vipps://`.
  **Please note:** In our test environment (MT), the scheme is `vippsMT://`

If the user does not have Vipps installed:

* `"isApp":false` (or not sent at all): The
   [Vipps landing page](vipps-landing-page.md)
   will be shown, and the user can enter a phone number and pay on a device
   with Vipps installed.
* `"isApp": true`: The user will get an error message saying that the link can
  not be opened. Or, depending on the native app, nothing will happen.

**Important:** If your customers use a native app: Remember that some iOS users
may install the app on an iPad where they don't have Vipps installed. If you
initiate payments with `"isApp": true` the app will try to open `vipps://` on
the iPad, but since Vipps installed "nothing will happen", and the user will
not be able to pay. If you simply don't sent `isApp`, the built-in logic will
fix things for you, and display
[the Vipps landing page](vipps-landing-page.md)
instead.

Example: Response body for `"isApp":false` (or not sent at all):

```json
{
  "orderId": "acme-shop-123-order123abc",
  "url": "https://api.vipps.no/dwo-api-application/v1/deeplink/vippsgateway?v=2&token=eyJraWQiOiJqd3RrZXkiLC <truncated>"
}
```

Example: Response body for `"isApp":true`, with a forced app-switch to Vipps:

```json
{
  "orderId": "acme-shop-123-order123abc",
  "url": "vipps://?token=eyJraWQiOiJqd3RrZXkiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiO <truncated>"
}
```

The effect of the above is the same in all normal cases.

**Important:** Using `isApp` comes with some extra responsibility:

* The merchant's native app must be sure that the user's phone can open the
  `vipps://` deeplink, as the
  [Vipps landing page](vipps-landing-page.md)
  will not be shown to the user, and it will therefore not be possible to
  enter a phone number and pay with Vipps on another device.
* Vipps requires a minimum version of the phone's operating system. At the time
  of writing this is iOS 12 (from 2018) or Android 6 (from 2015). If the user
  has an older version of the operating system, Vipps cannot be used.
  The merchant must keep track of this by checking the Apple App Store and
  Google Play.
* If `"isApp":true` is used in an embedded web browser, such as
  Instagram or Facebook, the `vipps://` URL will not work, since the
  embedded browser does not know what to do with it.
  The user will get an error from the embedded browser.

If you do want to use `isApp` the flow is as follows:

1. Merchant initiates the payment with `isApp: true` parameter:
   [`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST).
2. Vipps returns a `deeplink` URL on the `vipps://` format as response to initiate payment.
3. The merchant uses the `vipps://` URL to invoke Vipps (never change the URL, use it *exactly* as sent from Vipps)
4. Vipps is automatically opened, without the user having to click "OK" or accept.
5. The user accepts (or rejects) the payment request in Vipps.
6. The Vipps backend makes a call to the merchant's `callbackPrefix` with information about the payment.
7. When the payment process is completed, Vipps redirects to the merchant using the `fallBack` URL.

**Please note:** The user should be sent *directly* to the deeplink.
Rewriting the deeplink URL in any way may break the payment process.
If not today, it may break if Vipps changes some details later.

The deeplink URL is only valid for five minutes.
Attempts at using it after that will result in a timeout and an error.

See:

* [Timeouts](timeouts.md)
* [Can I send a Vipps payment link in an SMS, QR or email?](../faqs/reserve-and-capture-faq.md#can-i-send-a-vipps-payment-link-in-an-sms-qr-or-email)
