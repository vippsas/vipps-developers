---
description: Recommendations for the values of the payment description and transaction text fields in API calls.
sidebar_label: paymentDescription
pagination_next: null
pagination_prev: null
---

# Recommendations for payment description and transaction text

Here you will find recommendations for the values of the payment description and transaction text fields in API calls.

This is applicable to:

* [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/)
* [QR API](https://developer.vippsmobilepay.com/docs/APIs/qr-api)
* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)

All payments are initiated with a text that appears in the Vipps or MobilePay app, using the
`paymentDescription` (or `transactionText` for the older eCom API) parameter.
There are separate texts for the different actions: Initiate, capture, cancel, refund.

The text should be as user-friendly and informative as possible and is limited to 100 characters.

| Operation | Example payment description |
|:----------|:------------------------------|
| Initiate, one item (the `paymentDescription` is shown in the push message and on the payment screen) | *One pair of socks*, *Orderid acme-shop-123-order123abc in webshop* |
| Initiate, multiple items or a shopping basket | *One pair of socks, one XL hoodie* (truncated to ~100 characters) or *Payment for order acme-shop-123-order123abc in webshop* |
| Initiate, reservation of maximum amount (for EV charging, parking, etc.) | *Temporary reservation of maximum amount. You will only be charged for the actual use.* |
| Capture | *Order acme-shop-123-order123abc. Thank you for shopping at our webshop!* |
| Refund | *Refund for order acme-shop-123-order123abc* |

See also:
[Recommendations for `reference` and `orderId`](orderid.md).
