<!-- START_METADATA
---
title: Refunds
sidebar_position: 50
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# FAQs: Refunds

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

## Table of contents

* [Can I refund a payment?](#can-i-refund-a-payment)
* [How can I refund only a part of a payment?](#how-can-i-refund-only-a-part-of-a-payment)
* [How long does it take from a refund is made until the money is in the customer's account?](#how-long-does-it-take-from-a-refund-is-made-until-the-money-is-in-the-customers-account)

<!-- END_COMMENT -->

## Can I refund a payment?

This depends on your eCommerce solution. The Vipps eCom API supports refunds with
[`POST:/ecomm/v2/payments/{orderId}/refund`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/refundPaymentUsingPOST).
For details on how to offer refunds, please refer to the documentation for your eCommerce solution.

All integrations with the Vipps eCom API _must_ support refunds.

It is also possible to do refunds on
[portal.vipps.no](https://portal.vipps.no).

Refunds can be made up to 365 days after payment or reservation.
Very old payments have a higher risk of being problematic, because people
change banks, leave the country, die, etc,
and this then requires time-consuming manual work.
Vipps therefore limits refunds to 365 days.

### How can I refund only a part of a payment?

Example: A customer has placed an order of of two items for a total of 1000 NOK.
The merchant has initiated a payment of 1000 NOK, but the customer has changed
her mind and only bought one of the items, with a price of 750 NOK. The merchant
has therefore made a
[partial capture](../common-topics/reserve-and-capture#partial-capture)
of 750 NOK, and need to refund the remaining 250 NOK.

* The short version: This is done automatically by the bank after a few days.
See:
[For how long is a payment reserved?](reserve-and-capture-faq.md#for-how-long-is-a-payment-reserved).

* The long version: It _is_ possible to cancel the remaining reservation after a
partial capture through the Vipps eCom API: Send a
[`PUT:/ecomm/v2/payments/{orderId}/cancel`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/cancelPaymentRequestUsingPUT)
request with `shouldReleaseRemainingFunds: true` in the body.
The payment must be `RESERVED` for this to take effect.
See:
[Vipps eCom API: Cancelling a partially captured order](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#cancelling-a-partially-captured-order).

The partial capture (the 750 of the 1000 NOK in the example above)
is normally confirmed in the bank after 3-10 days, but it sometimes takes even
longer. When this is done, the bank will make the remaining (250 NOK) available
in the customer's account again. This process depends entirely on the customer's
bank, and Vipps cannot speed it up.

Banks keep reservations for the same number of days regardless of whether there
has been one or more captures. Banks do not extend the reservation if a partial
capture has been made.

If a partial capture has been made, the bank cancels the reservation for the
remaining amount. If no capture has been made, the entire reserved amount is
cancelled. Banks "count the days" from when the reservation was made, so the
merchant must make the capture, or all captures, before the reservation expires.

See: [Settlements](../settlements/README.md).

### How long does it take from a refund is made until the money is in the customer's account?

Normally 2-3 _bank days_, depending on the bank(s).
It can take much longer, up to 10 days, and depends on the bank(s).

Vipps does not have more information than what is available through our API.

See: [Settlements](../settlements/README.md).
