---
title: orderId
pagination_next: null
pagination_prev: null
---


# Recommendations for orderId/reference

The `orderId` (also called `reference`) must be unique for the sales unit Merchant Serial Number (MSN) (i.e., the ID of
the sales unit). The `orderId` does not need to be globally unique, so several
MSNs may use the same `orderId`, as long as it is unique for each sales unit.

The `orderId` is case-sensitive.
We *strongly* recommend using a format like `acme-shop-123-order123abc`,
instead of just `123456`.

**Please note:** Having very short orderIds, with just a few digits, can cause internal
processing in the Vipps systems to be slower, and this *can* cause problems, such as timeouts.
Use the recommended format to avoid problems.

This is applicable to:

* [Checkout API](https://developer.vippsmobilepay.com/docs/APIs/checkout-api)
* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
* [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
* [Order Management API](https://developer.vippsmobilepay.com/docs/APIs/order-management-api)
* [PSP API](https://developer.vippsmobilepay.com/docs/APIs/psp-api)
* [QR API](https://developer.vippsmobilepay.com/docs/APIs/qr-api)
* [Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api)

## Use user-friendly orderIds

If you ever have a problem that requires us to search in our logs, we need an
`orderId` that is "unique enough" to actually find. An `orderId` that
contains only digits may not be possible to find, and then we are not able to help.

It is possible to use
[UUID](https://en.wikipedia.org/wiki/Universally_unique_identifier),
of the format `123e4567-e89b-12d3-a456-426614174000`, but remember
that `orderId` is shown to the user in Vipps.
We recommend a more user-friendly format, like `acme-shop-123-order123abc`.

The maximum length of an `orderId` is 50 alphanumeric characters:
`a-z`, `A-Z`, `0-9` and `-` (hyphen).
Leading zeros should be avoided, as some applications (e.g., Excel)
tend to remove them, and this may cause misunderstandings.

See also:
[TransactionText recommendations](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/transactiontext/).

## Multiple sales units

If you have multiple sales units, prefixing the `orderId` with the MSN
for each sales unit is recommended. For example, if the MSN is `654321`, the
`orderId` could be `654321-acme-shop-123-order123abc`.

## Multiple attempts

If you need to make multiple attempts at paying the "same" order, you can
add a suffix to the orderId to make it unique on the Vipps side.

For example, if your internal orderId is
`acme-shop-123-order123abc`, you can add `-1` to get a unique *Vipps* orderId
`acme-shop-123-order123abc-1` for the first attempt,
`acme-shop-123-order123abc-2` for the second, etc.

This is useful when a customer does the following:

1. Adds a product to the cart.
2. Goes to the payment page and selects Vipps.
3. Gets the payment request in Vipps *but cancels* (or does nothing).
4. Adds another product to the same cart (or order).
5. Repeat steps 2 and 3.

If you use a suffix, you will still be able to search for the main part of
the orderId on
[portal.vipps.no](https://portal.vipps.no),
like `acme-shop-123-order123abc`, without the suffix, and still get find
the orderId `acme-shop-123-order123abc-1`.
