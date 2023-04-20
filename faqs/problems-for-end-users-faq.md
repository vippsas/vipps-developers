---
title: "FAQ: Problems for end users"
sidebar_label: Problems for end users
sidebar_position: 140
pagination_next: null
pagination_prev: null
---


# FAQ: Problems for end users



## Why don't I receive the payment notification?

Push notifications must be active for Vipps to send payment notifications.

Push notifications are "best effort", and Vipps cannot guarantee that all
push notifications arrive. It depends on services, networks, etc. that Vipps
cannot control.

If Vipps is already open and active when the push notification is received,
the user must press the "Send" button and move to the payments screen to see
the payment notification. Vipps is not able to poll or discover the
payment notification automatically.

## Why am I not sent back to where I came from when I have paid?

If the payment started in a custom browser (like Chrome on iOS, or an embedded
browser on Instagram, instead of the default Safari browser), the `fallback` URL
(the result page) will still be opened in the default browser.

See:

* [How can I open the fallback URL in a specific (embedded) browser?](common-problems-faq.md#how-can-i-open-the-fallback-url-in-a-specific-embedded-browser).
* [Recommendations regarding handling redirects](../common-topics/redirects.md).
