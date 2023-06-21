---
title: Cancellations
pagination_next: null
pagination_prev: null
---

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/vipps-developers/).
<!-- END_COMMENT -->

# Cancellations

The `Cancel` request allows the merchant to cancel a reserved or initiated transaction.

Please note that it is not possible to cancel a request that is over 180 days old.
Attempting to cancel an older payment will result in a `HTTP 400 Bad Request`.

The payment flow can be aborted under certain circumstances:

* When the user cancels (rejects) the initiated payment in Vipps.
* When the merchant cancels.
* Timeouts: If the user does not confirm, etc.

After cancellation, the order gets a new status.
See the individual API guides for more API specifics:

* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
* [ePayment API](https://developer.vippsmobilepay.com/docs/APIs/epayment-api)
* [Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api)

## Cancel a pending order

If you wish to cancel a transaction before the customer can confirm the payment
in Vipps, you can send a cancel request while the transaction is in the `INITIATE` stage.

This may be useful in face-to-face situations where a customer's phone runs out
of battery, or if the customer suddenly changes their mind and wants to buy
more and the amount for the payment increases.
This should not be considered a consistent or guaranteed operation,
as the `cancel` request depends on actions taken by the user in the app.

If the `cancel`
request is successful, the payment state in the response will be: `CANCELLED`.  

**Please note:** If the user is already in a 3-D Secure session, the payment
cannot be cancelled as described above.

## Cancel a partially captured order

If you wish to cancel an order that you have partially captured, send a
`cancel` request with `shouldReleaseRemainingFunds: true` in the body.
The payment must be `RESERVED` for this to take effect.

If `shouldReleaseRemainingFunds` is not set, it will default to `false`.

When `shouldReleaseRemainingFunds` is set to `false`,
any request to cancel after a partial or full capture has been performed will be rejected.

This is a useful and recommended feature, as it releases any reserved balance
as soon as the card issuer and/or bank permits.

See also the FAQ:
[How long does it take from a refund is made until the money is in the customer's account?](../faqs/refunds-faq.md#how-long-does-it-take-from-a-refund-is-made-until-the-money-is-in-the-customers-account)

**Please note:** Once this operation has been performed, there will be zero
funds remaining to capture. Do not call this endpoint until you are sure you
have captured all you need.
