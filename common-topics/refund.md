<!-- START_METADATA
---
title: Refunds
sidebar_label: Refunds
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Refunds

The merchant can initiate a refund of the captured amount.
The refund can be a partial or full.

Partial refunds are done by specifying an `amount` which is lower than the
captured amount. The refunded amount cannot be larger than the captured amount.

Refunds can be made up to 365 days after reservation.
Attempting to refund an older payment will result in a
`HTTP 400 Bad Request`.

This is applicable to:

* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
* [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
* [Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api)

See [FAQ: Refunds](../faqs/reserve-and-capture-faq.md) for common questions.
