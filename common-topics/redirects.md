<!-- START_METADATA
---
sidebar_label: Redirects
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Recommendations regarding handling redirects

Since Vipps is a mobile entity the amount of control Vipps have over the redirect back to the merchant after the purchase is completed is limited. A merchant must not assume that Vipps will redirect to the exact same session and for example rely entirely on cookies in order to handle the redirect event. For example the redirect could happen to another browser.

Examples of some, but not all, factors out of Vipps control.

- Configurations set by the OS itself, for example the default browser.
- User configurations of browsers.
- Users closing app immediately upon purchase.

Therefore, Vipps recommends having a stateless approach in the site that is supposed to be the end session. An example would a polling based result handling from a value in the redirect url.

Example for demonstration purposes that should be handled.

- User starts is in web session in a Chrome Browser.
- A Vipps purchase is started, a redirect URL is defined by the Merchant.
- The user completes the purchase.
- The Vipps app redirects the user.
- The OS defaults to a Safari Browser for the redirect.
- The merchant handles the redirect without the customer noticing any discrepancies from the browser switch.
