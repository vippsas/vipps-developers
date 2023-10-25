---
sidebar_label: Redirects
pagination_next: null
pagination_prev: null
---

# Redirecting the user to a website or app

You can redirect the user to a website or app once they have used the Vipps or MobilePay app to log in to your site, complete a payment, accept an agreement, or similar.

Most of the APIs provide the redirect functionality in different flows. For example:

* [Checkout API](https://developer.vippsmobilepay.com/docs/APIs/checkout-api/vipps-checkout-api/)
* [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/create/)
* [Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api/api-guide/overview/#login-in-browser)
* [Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api/#agreements)

## Recommendations regarding handling these redirects

We have limited control over the redirect back to the merchant's website after a completed
purchase or log-in. Your integration *must not* assume that the app will redirect to
the exact same session. For example, don't rely entirely on cookies in order to
handle the redirect event. The redirect may send the user to a different web browser.

Examples of some, but not all, factors outside our control:

* Configurations set by the operating system, for example the default browser.
* User configurations of browsers.
* Users closing the app immediately upon purchase.

Because of this, we recommend a stateless approach on the website that
should be the end of the session. For example, implement polling-based result
handling from a value in the redirect URL.

## Examples

An example of how redirects should be handled:

1. The user starts a web session in the non-default browser (e.g., Firefox).
2. A Vipps or MobilePay purchase is started where the merchant specifies a redirect URL.
3. The user completes the purchase in the Vipps or MobilePay app.
4. The app requests the operating system to open the URL specified in step 2.
5. The OS opens the URL in the default browser, not necessarily the browser where the session started (e.g., Firefox).
6. The merchant handles the redirect without the customer noticing any
   discrepancies from the browser switch.

**Please note:** If the user has installed an ad blocker, that may cause problems
opening URL with custom URL schemas.

See also:
[changing the default browser on iOS](https://support.apple.com/en-us/HT211336)

## Redirection FAQs

### How can I open the fallback URL in a specific (embedded) browser?

The phone's operating system always opens URLs in the default browser.

This means that the `fallback` URL (the "result page") will be opened in
the default browser. We have no way to open the `fallback` URL in the
embedded browser on Facebook, Instagram, etc. Similarly, there is no way
for us to open the `fallback` URL in the same tab that the user came from
before the app-switch.

This means that the merchant must be able to detect or recognize the user
when the `fallback` URL is opened, without relying on session, cookies, etc.

### Why a user might not be sent back to where they came from when they have paid?

If the payment started in a custom browser (like Chrome on iOS, or an embedded
browser on Instagram, instead of the default Safari browser), the `fallback` URL
(the result page) will still be opened in the default browser.

