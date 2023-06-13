<!-- START_METADATA
---
title: "FAQ: Common errors"
sidebar_label: Common errors
sidebar_position: 110
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# FAQ: Common errors

See also
[Common errors](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-faq#common-errors)
in the eCom API FAQs.

## Why do I get `HTTP 400 Bad Request`?

It is because you are making an incorrect API request. The response body contains
information about what you are doing wrong.

Some common errors:

* Invalid API keys.
* Invalid amount.
* callbackUrl is invalid.
* Captured amount exceeds the reserved amount. You can not capture a higher amount than the user has accepted.
* Cannot refund more than captured amount.
* User unknown. The phone number is either incorrectly formatted (see the API
  specification), is not a Vipps user, or the user is under 15 years old and
  cannot pay businesses. Vipps cannot give more details. This error also occurs
  if using a non-Norwegian phone number. Look for related questions in this FAQ.

## Why do I get `HTTP 401 Unauthorized`?

This means you are using the wrong API keys or Authorization header.

The reason for the error is often in the response body, such as:

* Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription.
* Access denied due to missing subscription key. Make sure to include subscription key when making requests to an API.
* Subscription not found.

If the error message is "Something went wrong, please try again later", it normally
indicates that the provided `Authorization` header (the access token) is invalid.
Check that the access token is in the correct format and that it has not expired.

Please follow these steps to make sure everything is correct:

1. Make sure that you are using a valid access token. See
   [Get an access token](https://developer.vippsmobilepay.com/docs/APIs/access-token-api#get-an-access-token)
   for details, how long it is valid, etc.
   Remember to use `Authorization: Bearer <access token goes here>`.
   If you do not include `Bearer`, you may get a `HTTP 401 Unauthorized` error.
2. Check that you are using the correct API credentials for the MSN (Merchant Serial Number)
   you are using
   (See
   [Common topics: How to use the API keys](../common-topics/api-keys.md#how-to-use-the-api-keys) for more details):
   * `client_id`
   * `client_secret`
   * `Ocp-Apim-Subscription-Key` (the subscription key)
3. Check that you are using the same subscription key for both the access token and the payment requests.
   If you have a valid access token, but for a different MSN, you will get an error.
   If you are caching the access token: Check that too.
   See:
   [Why do I get `errorCode 35 "Requested Order not found"`?](#why-do-i-get-errorcode-35-requested-order-not-found)
4. Check the API specification for the correct spelling of all the header parameters.
   They are case-sensitive: `Authorization: Bearer <access token goes here>`
   is not the same as `Authorization: bearer <access token goes here>`.
5. Make sure you are using the right environment and check that you are using
   the correct API keys for the right sales unit in that environment. The
   [test environment](../test-environment.md)
   is completely separate from the production environment, and both the MSN and
   the API keys are different.
6. Check both the HTTP response header and the response body from our API for errors.
   For most errors the body contains an explanation of what went wrong.
   See:
   [Errors](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#errors).
7. If you are a partner, and you are using partner keys: Double check everything
   described here:
   [Partner keys](https://developer.vippsmobilepay.com/docs/vipps-partner/partner-keys).
   A common mistake is to mix `Merchant-Serial-Number` (used in the HTTP header)
   and `merchantSerialNumber` (used in the request body).

You can log in to
[portal.vipps.no](https://portal.vipps.no)
to double-check your API keys, sales units and API products.
See:
[Getting the API keys](../common-topics/api-keys.md#getting-the-api-keys).

You can use
[Postman](../quick-start-guides.md)
to manually do API calls, Use the "inspect" functionality to see the complete
requests and responses, and to check that the API keys are correct.

You should also ensure you have access to the correct API.
See:
[API products](https://developer.vippsmobilepay.com/docs/APIs).

If you are absolutely, completely 100 % sure that you have done everything
correctly, and it _still_ doesn't work, you can regenerate the API keys on
[portal.vipps.no](https://portal.vipps.no).
This should never be necessary, and we do not know of any situations where
this fixes any known problem, so it's our very last suggestion.
The old API keys will of course stop working when they have been regenerated.

**Important:** Vipps cannot help with the debugging of your code,
we can only help with the API requests and response. Please do not send us your
source code asking us to fix it for you.

## Why do I get `HTTP 403 Forbidden`?

Merchants that only have access to the
[Vipps Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api)
and attempt to use the Vipps eCom API will get this error, with
`Merchant Not Allowed for Ecommerce Payment` in the body.

This is because the compliance checks required for Vipps eCom API are not
done for merchants that only need the Vipps Login API.
If you need access to the Vipps eCom API, you can apply for this on
[portal.vipps.no](https://portal.vipps.no).

Partners can get this error if they use
[Partner keys](https://developer.vippsmobilepay.com/docs/vipps-partner/partner-keys),
but do not send the
`Merchant-Serial-Number` header.

## Why do I get `HTTP 429 Too Many Requests`?

We rate-limit some API endpoints to prevent incorrect usage.
The rate-limiting has nothing to do with Vipps' total capacity, but is
designed to stop obviously incorrect use.

See:

* [eCom API Rate limiting](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#rate-limiting)
* [Recurring API Rate limiting](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api#rate-limiting)

## Why do I get `HTTP 404 Not Found`?

It depends. You must check the body of the response.

It could be that you are attempting to call a non-existent API endpoint, and
it could be that you are using the API keys for one MSN for an `orderId`
that belongs to a different MSN.

See: [Why do I get `errorCode 35 "Requested Order not found"`?](#why-do-i-get-errorcode-35-requested-order-not-found).

## Why do I get `HTTP 500 Internal Server Error`?

Something _might_ be wrong on our side and we are working to fix it!

But: It's usually a problem with your request, and that our validation does not catch it.
In other words: We should have returned `HTTP 400 Bad Request`.

Some tips:

* Please make sure the JSON payload in your API request validates.
  That is the most common source of this type of error.
* We strongly recommend using
  [Postman](../quick-start-guides.md)
  to manually do API calls, to see the correct request.
  Use Postman's
  [Inspect](https://blog.postman.com/debugging-postman-requests/)
  functionality to see the complete request.
* You will get a 500 error if the MSN is sent as an integer:
  `merchantSerialNumber":654321` instead of a string: `merchantSerialNumber":"654321"`.
* The same will happen if the `amount` is not an integer.
* Please check the capitalization of the parameters.
  We will return `HTTP 500 Error` if the incorrect `fallback` is used instead of
  the correct `fallBack`.

Check both the HTTP response header and the response body from our API for errors.
For most errors the body contains an explanation of what went wrong.

**Please note:** If you get a `HTTP 500 Internal Server Error` in the test environment,
it may be a glitch in the SQL server. We are running a "weaker" instance than in
production, and on very rare occasions this can cause SQL errors that result in
a `HTTP 500 Server Error`. Retry the call, and see if it helps.

See:

* [Errors](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#errors).
* [Status page](../developer-resources/status-pages.md).

## Why do I get `errorCode 35 "Requested Order not found"`?

This is either because you are specifying an incorrect `orderId`, or because
the payment with this `orderId` was initiated using the API keys for
one sales unit (MSN), and you are attempting to get the details with
the API keys for a different sales unit (MSN).

The `orderId`s is not globally unique, they are only unique per MSN.

See:

* [Why do I get `HTTP 404 Not Found`?](#why-do-i-get-http-404-not-found)
* [Error codes](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#error-codes).

## Why do I get `errorCode 37 "Merchant not available or deactivated or blocked"`?

Or: `Merchant not available or active`.

Please check that the merchant's organization number is still active in
[Brønnøysundregistrene](https://www.brreg.no). Vipps automatically deactivates
merchants (companies) when they are deleted from Brønnøysundregistrene.
This can also happen if a merchant changes organization type, for instance
from _ENK_ to _AS_.

Merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and deactivate their sales units. This is sometimes done "by accident", without being
aware of the consequences. If a sales unit has been incorrectly deactivated,
the merchant can reactivate it again.

**Please note:** We require BankID for deactivation and reactivation,
and cannot help with this based on email requests.

Deactivation can also happen if the test merchant is not being used for a
_very long_ time. Please
[contact customer service](https://vipps.no/kontakt-oss/),
and we will reactivate the merchant.

Partners that use
[partner keys](https://developer.vippsmobilepay.com/docs/vipps-partner/partner-keys)
can also get this error if the partner itself is deactivated, even though
the sales unit (that it is acting on behalf of) is active.

**Please note:** We no longer automatically deactivate test merchants.
Merchants can also create new sales units in the test environment on
[portal.vipps.no](https://portal.vipps.no).

See: [Error codes](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#error-codes).

## Why do I get "Merchant Not Allowed for Ecommerce Payment"?

This error occurs if you attempt to use the Vipps eCom API with a sales unit (MSN)
that is only approved for the Vipps Login API.

Vipps does not do the same checks for sales units that do not make payments,
so to use the eCom API you need to order "Vipps på nett" on
[portal.vipps.no](https://portal.vipps.no)
to go through the regulatory and legally required checks and get
access to the Vipps eCom API.

All sales units that have been approved for the Vipps eCom API can also use
the Vipps Login API, but not the other way around.

See:
[Why do I get `HTTP 403 Forbidden`?](#why-do-i-get-http-403-forbidden)

## Why do I get error 81 and `User not registered with Vipps`?

The most common reasons are:

* The phone number is incorrectly formatted.
  Vipps attempts to correct incorrectly formatted phone numbers
  instead of responding with `HTTP 400 Bad Request`.
  In cases where the phone number still fails, the error will be `errorCode: 81`.
  See the API specification:
  [`POST:/ecomm/v2/payments`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST).
* The user is under 15 years old and cannot pay businesses.
* The phone number is not for a Vipps user.

Vipps cannot give more details, as we cannot "leak" information about a user's
age, whether a user has been blocked, whether a user has reached its spending
limit, etc.

## Why do I get an error about having Vipps installed and being 15 years old?

This can happen when:

* You attempt to use a real Vipps user in the test environment.
* You have a brand new test user and have not logged into the test app before
  trying to make payments, etc.

See:
[The Vipps Test Environment (MT)](../test-environment.md).

## Why do I get `Invalid MSN: 654321. Check your API keys on portal.vipps.no and see the eCom FAQ for tips.`?

This can happen when:

* A partner tries to use
  [Partner keys](https://developer.vippsmobilepay.com/docs/vipps-partner/partner-keys)
  for a sales unit that is not registered with them as partner.
* API keys for the test environment is used in the production environment, or opposite.
* [Partner keys](https://developer.vippsmobilepay.com/docs/vipps-partner/partner-keys)
  are used, but the `Merchant-Serial-Number` HTTP header is not used correctly.

## Why do I get `Invalid MSN: 654321. This MSN is not valid for the provided supermerchant ID.`?

This can happen when the partner making the API request is using:

* API keys for the test environment in the production environment, or opposite
* An MSN for the test environment in the production environment, or opposite
* [Partner keys](https://developer.vippsmobilepay.com/docs/vipps-partner/partner-keys)
  without including the required `Merchant-Serial-Number` header

If the error message is `Invalid MSN: This MSN is not valid for the provided supermerchant ID.`,
with no MSN specified, it means that the `Merchant-Serial-Number` is missing in the request header.

## Why do I get `Invalid MSN: 654321. This MSN is not valid for the provided PSP id.`?

The full error message text is:

"Invalid MSN: 654321. This MSN is not valid for the provided PSP ID. Check that you are
using the correct credentials for the right environment."

In addition to what the error message says, this error can occur if a PSP attempts to initiate
payments for an MSN that was created by a different PSP.
PSP's can only initiate payments for MSNs that are connected to them.

The solution is to create a new MSN with the
[PSP Signup API](https://developer.vippsmobilepay.com/docs/APIs/psp-api/vipps-psp-signup-api/).
