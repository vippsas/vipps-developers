<!-- START_METADATA
---
title: Exception handling
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Exceptions handling


## Connection timeout

Defining a socket timeout period is the common measure to protect server
resources and is expected. However, the time needed to fulfil a service requests
depends on several systems, which impose longer timeout period than usually
required.

We recommend setting no less than 1 second socket connection timeout
and 5 seconds socket read timeout while communicating with Vipps.

A good practice is, if/when the socket read timeout occurs, to call
[`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)
and check status of last transaction in transaction history prior
to executing the service call again.

## Callback aborted or interrupted

If the communication is broken during payment process for some reason,
either because of network problems, that the user abruptly closes the app or
something else, and Vipps is not able to execute callback, the callback will
not be retried.

In other words, if the merchant doesn't receive any confirmation on payment
request call within callback time frame, merchant must call
[`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)
to get the response of payment request.

## PSP connection issues

In cases of communication problems with Vipps' PSP, the response from Vipps
will be an error.
See [eComAPI Errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#errors) or
[PSP API Errors](https://github.com/vippsas/vipps-psp-api/blob/master/vipps-psp-api.md#errors).

The merchant should then call
[`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)
to check if the transaction request is processed before making a new call,
using the same [idempotency key](http-headers.md#idempotency).

## Clean-up strategies

Vipps recommends merchants implement a robust clean up strategy for all orders
where the goods or services are not issued to the user.

An example case would be:

Bank X is having issues and transactions for their customers are slow (15+ seconds)
for a significant period of time. As a result of this the user decides to close
the Vipps app while the transaction is being processed, they do not then see the
final result in the Vipps app. This transaction will eventually result in a
successful reservation. The user then returns to the Merchants app, but as the
entry was not via an expected app-switch from the Vipps app, state is not correctly
resumed. The user attempts a second payment, which this time goes through in a
timely manner, and upon app-switch back the user is issued their goods/services.

The user has now two reservations and only received goods/services once. It is
the merchant's responsibility here to ensure the first order, for which no
goods/services were issued, should be cancelled to remove the reservation from
the customers account.

Vipps recommends polling
[`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)
until either a `REJECT`, `USER_CANCEL`, `RESERVE` or `SALE` status is received,
and then performing the appropriate action based on the status of product issuing.
The user should also be notified that the merchant has issued any product to
ensure they do not naturally retry the purchase. This includes using SMS/email
strategy if it is unclear that the user in on the merchants website/app to see confirmation.

## Recommendations for handling very high traffic

At peak traffic, like Black Friday, it is especially important to have a
robust integration.

We strongly recommend using "reserve capture", and not "direct capture",
so it is possible to cancel a payment without making a refund.

* Make sure you poll
  [`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET),
  and do not rely on the callback from Vipps, and also don't rely on the user
  reaching the callback URL.
* Consider if you should cancel or complete the payment if the payment takes
  much longer than normal, so much that the user may give up.
  * If you sell a ticket: It may be good to always issue the ticket if the user
    has approved the payment, even if the processing of the payment takes much
    longer than normal and the user "gives up".
  * If you sell food at a restaurant: If the payment takes so long that the
    user gives up and tries to order again: It may be smart to cancel the
    previous order, even though the user did approve the payment.

It is also important that the merchant's and/or partner's systems are able to
to handle the peak traffic.
