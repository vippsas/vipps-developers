---
title: "FAQ: Problems for end users"
sidebar_label: Problems for end users
sidebar_position: 140
pagination_next: null
pagination_prev: null
---

# FAQ: Problems for end users

## Why don't I receive the payment notification?

Push notifications must be active.

Push notifications are "best effort", and we can't guarantee that all
push notifications arrive. It depends on services, networks, and other things outside our control.

If the Vipps or MobilePay app is already open and active when the push notification is received,
the user must press the *Send* button and move to the payments screen to see
the payment notification. The app isn't able to poll or discover the
payment notification automatically.

## Why am I not sent back to where I came from when I have paid?

If the payment started in a custom browser (like Chrome on iOS, or an embedded
browser on Instagram, instead of the default Safari browser), the `fallback` URL
(the result page) will still be opened in the default browser.

See:

* [How can I open the fallback URL in a specific (embedded) browser?](common-problems-faq.md#how-can-i-open-the-fallback-url-in-a-specific-embedded-browser).
* [Recommendations regarding handling redirects](../common-topics/redirects.md).
