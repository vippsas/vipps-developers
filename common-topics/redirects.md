<!-- START_METADATA
---
sidebar_label: Redirects
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Recommendations regarding handling redirects

Since Vipps is a native app, and not a website used in a web browser, the level
of control Vipps has over the redirect back to the merchant after a completed
purchase is limited. The merchant *must not* assume that Vipps will redirect to
the exact same session or for example rely entirely on cookies in order to
handle the redirect event. The redirect may send the user to a different web browser.

Examples of some, but not all, factors outside of Vipps control:

* Configurations set by the OS itself, for example the default browser.
* User configurations of browsers.
* Users closing Vipps immediately upon purchase.

Because of this, Vipps recommends a stateless approach on the website that
is supposed to be the end of the session. An example would a polling-based result
handling from a value in the redirect URL.

An example with iOS of how redirects should be handled:

1. The user starts is in web session in the Chrome or Firefox web browser on a phone (not the default Safari browser).
2. A Vipps purchase is started, with a redirect URL specified by the merchant.
3. The user completes the purchase in Vipps.
4. Vipps (the app) redirects the user by asking the phone's operating system to open the URL specified in step 2.
5. The OS opens the URL in the default browser: Safari (not Chrome or Firefox).
6. The merchant handles the redirect without the customer noticing any
   discrepancies from the browser switch.

**Please note:** If the user has installed an ad blocker, that may cause problems
opening URL with custom URL schemes.

Apple has some information about
[changing the default browser on iOS](https://support.apple.com/en-us/HT211336).

This is applicable to:

* [Checkout API](https://developer.vippsmobilepay.com/docs/APIs/checkout-api)
* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
* [Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api)
