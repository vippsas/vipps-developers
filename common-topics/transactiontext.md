---
title: TransactionText
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---


# TransactionText recommendations

This is applicable to:

* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
* [QR API](https://developer.vippsmobilepay.com/docs/APIs/qr-api)

All Vipps payments are initiated with a text that appears in Vipps, using the
`transactionText` parameter. There are separate texts for the different actions:
Initiate, capture, cancel, refund.

The text should be as user-friendly and informative as possible.

The `transactionText` can be up to 100 characters.

We recommend the following, using the example "Vipps web shop":

| Operation | Recommended `transactionText` | Not recommended |
|:----------|:------------------------------|-----------------|
| Initiate, one item (the `transactionText` is shown in the push message and on the payment screen) | `One pair of Vipps socks`, `Orderid acme-shop-123-order123abc in Vipps webshop` | `Payment`, `Vipps webshop`, `Shop number 12345`, `Vipps` |
| Initiate, multiple items or a shopping basket | `One pair of Vipps socks, one XL hoodie, ...` (truncated to ~100 characters) or `Payment for order acme-shop-123-order123abc in Vipps webshop` | (same as above) |
| Initiate, reservation of maximum amount (for EV charging, parking, etc.) | `Midlertidig reservasjon av maksbeløp. Du bli kun belastet for faktisk bruk.` English: `Temporary reservation of maximum amount. You will only be charged for the actual use.` | Not making it clear that it is a temporary reservation of the maximum amount (otherwise: same as above) |
| Capture (the `transactionText` is shown on the receipt) | `Order acme-shop-123-order123abc. Thank you for shopping at Vipps webshop!` | (same as above) |
| Refund | `Refund for order acme-shop-123-order123abc` | `Refund`, `Orderid acme-shop-123-order123abc` |
