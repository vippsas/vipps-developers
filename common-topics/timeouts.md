---
sidebar_label: Timeouts
pagination_next: null
pagination_prev: null
---

# Timeouts

For most APIs, the user has 10 minutes to accept the payment.
The
[ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/features/long-living-payments)
allows you to extend the expiration time.

## Using a phone

Both the deeplink URL, which causes the app-switch to Vipps, and the landing
page displayed in browsers, are valid for 5 minutes.

If the user does not act on the app-switch (such as not attempting to log in to
Vipps) within 5 minutes, the payment will time out.

After the app-switch to Vipps, the user has another 5 minutes to complete the
payment in Vipps.

This means that the user has a total of 10 minutes to complete the payment.

## Using a PC

If the user is using a PC, they must confirm or enter their phone number on
the landing page within 5 minutes; otherwise, the payment times out.

After the user has clicked "OK" on the landing page, the user
has an additional 5 minutes to complete the payment in Vipps.

This means that the user has a total of 10 minutes to complete the payment.
