---
title: "FAQ: Refunds"
sidebar_label: Refunds
sidebar_position: 150
pagination_next: null
pagination_prev: null
---

# FAQ: Refunds

## Can I refund a payment?

This depends on your eCommerce solution. The eCom API supports refunds with
[`POST:/ecomm/v2/payments/{orderId}/refund`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/refundPaymentUsingPOST).
For details on how to offer refunds, please refer to the documentation for your eCommerce solution.

### How can I refund only a part of a payment?

This varies by API. See the following for details:

* [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/operations/refund/#partial-refund)
* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-faq/#refunds)



## How long does it take from a refund is made until the money is in the customer's account?

Normally 2-3 *bank days*, depending on the bank(s).
It can take much longer, up to 10 days, and depends on the bank(s).

We don't have more information than what is available through our API.

See: [Settlements](../settlements/README.md).
