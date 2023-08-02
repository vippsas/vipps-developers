---
title: Refunds
sidebar_label: Refunds
pagination_next: null
pagination_prev: null
---

# Refunds

The merchant can initiate a refund of the captured amount.

It is not possible to refund a larger amount than the captured amount.

A refund can be a partial or full.

Partial refunds are done by specifying an `amount` that is lower than the
captured amount. It is possible to make several partial refunds after each
other.

Refunds can be made up to 365 days after reservation.
Attempting to refund an older payment will result in a
`HTTP 400 Bad Request`.

If the customer's card has expired sometime after the purchase, so the merchant
is not able to automatically refund, the merchant must contact the customer to
find a different way to make the refund.

Refunded funds will be deducted from the merchant's settlement account after
two business days. See
[Settlement Information](../settlements/README.md) for more details.

This is applicable to:

* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
* [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
* [Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api)

See
[Refund](https://developer.vippsmobilepay.com/docs/faqs/refunds-faq/)
for common questions.
