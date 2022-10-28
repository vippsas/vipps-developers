<!-- START_METADATA
---
title: orderId
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# orderId recommendations

An `orderId` must be unique for the sale unit Merchant Serial Number (MSN) (i.e., the id of
the sale unit). The `orderId` does not need to be globally unique, so several
MSNs may use the same `orderId`, as long as it is unique for each sale unit.

The `orderId` is case-sensitive.
We *strongly* recommend to use a format like `acme-shop-123-order123abc`,
instead of just `123456`.

**Please note:** Very short orderIds (just a few digits() can cause internal
processing in Vipps' systems to be slower than when using recommended
`orderId`s, and this *can* cause problems, such as timeouts.

If you ever have a problem that requires us to search in our logs, we need an
`orderId` that is "unique enough" to actually find. An `orderId` that
is just a number may not be possible to find, and then we are not able to help.

It is possible to use
[UUID](https://en.wikipedia.org/wiki/Universally_unique_identifier),
on the format `123e4567-e89b-12d3-a456-426614174000`, but remember
that `orderId` is shown to the user in Vipps.
We recommend something more user friendly, like `acme-shop-123-order123abc`.

The maximum length of an `orderId` is 50 alphanumeric characters:
`a-z`, `A-Z`, `0-9` and `-` (hyphen).
Leading zeros should be avoided, as some applications (like Excel)
tend to remove them, and this may cause misunderstandings.

If you have multiple sale units, prefixing the `orderId` with the MSN
for each sale unit is recommended: If the MSN is `654321`, the
`orderId` could be `654321-acme-shop-123-order123abc`.

If you need to make multiple attempts at paying the "same" order, you can
add a suffix to the orderId to make it unique on the Vipps side.
For example, if your internal orderId is
`acme-shop-123-order123abc`, you can add `-1` to get a unique *Vipps* orderId
`acme-shop-123-order123abc-1` for the first attempt,
`acme-shop-123-order123abc-2` for the second, etc.

This is useful when a customer does the following:

1. Adds a product to the cart
2. Goes to the payment page and selects Vipps
3. Gets the payment request in Vipps *but cancels* (or does nothing)
4. Adds another product to the same cart (or order)
5. Repeats steps 2 and 3.
