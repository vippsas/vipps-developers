---
title: Refunds
sidebar_label: Refunds
pagination_next: null
pagination_prev: null
---

# Refunds

The merchant can initiate a full or partial refund of the captured amount up to 365 days after payment or reservation.
It usually takes 2-3 *bank days* until the money is in the customer's account, depending on the bank(s).
It can take much longer, up to 10 days, and depends on the bank(s).

It is not possible to refund a larger amount than the captured amount.

A refund can be a partial or full.

Partial refunds are done by specifying an amount that is lower than the
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

Here are related sections in the API guides:

* [ePayment API: Refund](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/refund/)
* [Recurring API: Refund a charge](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api/#refund-a-charge)
* [eCom API: Refund](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api/#refund)

It is also possible to do refunds on
[portal.vipps.no](https://portal.vipps.no).

See the
[Refund FAQ](https://developer.vippsmobilepay.com/docs/faqs/refunds-faq/)
for common questions.
