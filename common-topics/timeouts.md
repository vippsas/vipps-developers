---
sidebar_label: Timeouts
pagination_next: null
pagination_prev: null
---

# Timeouts

For most APIs, the user has 10 minutes to accept the payment.
The ePayment API allows you to extend the expiration time through
[Long-living payments](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/features/long-living-payments).

## Using a phone

Both the landing page and the deeplink URL, which causes the app-switch to the Vipps or MobilePay app, are valid for 5 minutes.

If the user doesn't act on the app-switch (such as not attempting to log in)
 within 5 minutes, the payment will time out.

After the app-switch, the user has an additional 5 minutes to complete the
payment in Vipps MobilePay.

This means that the user has a total of 10 minutes to complete the payment.

## Using a PC

If the user is using a PC, they must confirm or enter their phone number on
the landing page within 5 minutes; otherwise, the payment times out.

After the user has clicked "OK" on the landing page, the user
has an additional 5 minutes to complete the payment in Vipps MobilePay.

This means that the user has a total of 10 minutes to complete the payment.
