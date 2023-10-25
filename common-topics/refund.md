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

## Refunds FAQs

### Can I refund a payment?

For details on how to offer refunds, please refer to the documentation for your eCommerce solution.

Here are related sections in the API guides:

* [ePayment API: Refund](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/refund/)
* [Recurring API: Refund a charge](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api/#refund-a-charge)
* [eCom API: Refund](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api/#refund)

All integrations with the eCom API *must* support refunds.

It is also possible to do refunds on
[portal.vipps.no](https://portal.vipps.no).

Refunds can be made up to 365 days after payment or reservation.
Very old payments have a higher risk of being problematic, because people
change banks, leave the country, die, etc.,
and this then requires time-consuming manual work.
We therefore limit refunds to 365 days.

### How can I refund only a part of a payment?

Example: A customer has placed an order of two items for a total of 1000 NOK.
The merchant has initiated a payment of 1000 NOK, but the customer has changed
her mind and only bought one of the items, with a price of 750 NOK. The merchant
has therefore made a
[partial capture](./reserve-and-capture.md#partial-capture)
of 750 NOK, and need to refund the remaining 250 NOK.

* The short version: This is done automatically by the bank after a few days.
See:
[For how long is a payment reserved?](../common-topics/reserve-and-capture.md#for-how-long-is-a-payment-reserved).

* The long version: It *is* possible to cancel the remaining reservation after a
partial capture through the eCom API: Send a
[`PUT:/ecomm/v2/payments/{orderId}/cancel`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/cancelPaymentRequestUsingPUT)
request with `shouldReleaseRemainingFunds: true` in the body.
The payment must be `RESERVED` for this to take effect.
See:
[eCom API: Cancelling a partially captured order](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#cancelling-a-partially-captured-order).

The partial capture (the 750 of the 1000 NOK in the example above)
is normally confirmed in the bank after 3-10 days, but it sometimes takes even
longer. When this is done, the bank will make the remaining (250 NOK) available
in the customer's account again. This process depends entirely on the customer's
bank, and we can't speed it up.

Banks keep reservations for the same number of days regardless of whether there
has been one or more captures. Banks do not extend the reservation if a partial
capture has been made.

If a partial capture has been made, the bank cancels the reservation for the
remaining amount. If no capture has been made, the entire reserved amount is
cancelled. Banks "count the days" from when the reservation was made, so the
merchant must make the capture, or all captures, before the reservation expires.

See: [Settlements](../settlements/README.md).

### How long does it take from a refund is made until the money is in the customer's account?

Normally 2-3 *bank days*, depending on the bank(s).
It can take much longer, up to 10 days, and depends on the bank(s).

We don't have more information than what is available through our API.

See: [Settlements](../settlements/README.md).
