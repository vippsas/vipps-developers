<!-- START_METADATA
---
title: Common errors
sidebar_position: 80
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# FAQs: Common errors

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

See also
[Common errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#common-errors)
in the eCom API FAQs.

Document version 0.2.0.

<!-- START_TOC -->

## Table of contents

* [Why do I get `HTTP 401 Unauthorized`?](#why-do-i-get-http-401-unauthorized)
* [Why do I get `HTTP 403 Forbidden`?](#why-do-i-get-http-403-forbidden)
* [Why do I get `HTTP 429 Too Many Requests`?](#why-do-i-get-http-429-too-many-requests)
* [Why do I get `HTTP 404 Not Found`?](#why-do-i-get-http-404-not-found)
* [Why do I get `HTTP 500 Internal Server Error`?](#why-do-i-get-http-500-internal-server-error)
* [Why do I get `errorCode 35 "Requested Order not found"`?](#why-do-i-get-errorcode-35-requested-order-not-found)
* [Why do I get `errorCode 37 "Merchant not available or deactivated or blocked"`?](#why-do-i-get-errorcode-37-merchant-not-available-or-deactivated-or-blocked)
* [Why do I get "Merchant Not Allowed for Ecommerce Payment"?](#why-do-i-get-merchant-not-allowed-for-ecommerce-payment)
* [Why do I not get the `sub` from `/details`?](#why-do-i-not-get-the-sub-from-details)
* [Why do I get `unauthorized_client`?](#why-do-i-get-unauthorized_client)
* [Why do I get error 81 and `User not registered with Vipps`?](#why-do-i-get-error-81-and-user-not-registered-with-vipps)
* [Why do I get an error about having Vipps installed and being 15 years old?](#why-do-i-get-an-error-about-having-vipps-installed-and-being-15-years-old)
* [Why do I get `Why do I get Invalid MSN: 654321. Check your API keys on portal.vipps.no and see the eCom FAQ for tips.`?](#why-do-i-get-invalid-msn-654321-check-your-api-keys-on-portalvippsno-and-see-the-ecom-faq-for-tips)
* [Why do I get `Why do I get Invalid MSN: 654321. This MSN is not valid for the provided supermerchant id.`?](#why-do-i-get-invalid-msn-654321-this-msn-is-not-valid-for-the-provided-supermerchant-id)

<!-- END_TOC -->

## Why do I get `HTTP 401 Unauthorized`?

If you get a `HTTP 401 Unauthorized` response, the reason for the error is in the
response body, such as:

```text
Access denied due to invalid subscription key.
Make sure to provide a valid key for an active subscription.
```

or

```text
Access denied due to missing subscription key.
Make sure to include subscription key when making requests to an API.
```

or

```json
{
  "errorCode":"Unauthorized",
  "errorMessage":"Subscription not found",
  "contextId":"ff0b3ca8-eae5-4e95-9859-6600b2428315"
}
```

You need to check that you are providing the correct API keys.
Please follow these steps to make sure everything is correct:

1. Check that you are using the correct API credentials for the MSN (Merchant Serial Number)
   you are using
   (See
   [Getting started: Quick overview of how to make an API call](../vipps-getting-started.md#quick-overview-of-how-to-make-an-api-call) for more details):
   * `client_id`
   * `client_secret`
   * `Ocp-Apim-Subscription-Key` (the subscription key)
2. Check that you are using the same subscription key for both the access token and the payment requests.
   If you have a valid access token, but for a different MSN, you will get an error.
   See:
   [Why do I get `errorCode 35 "Requested Order not found"`?](#why-do-i-get-errorcode-35-requested-order-not-found)
3. Check the swagger specification for the correct spelling of all the header parameters.
   They are case sensitive: `Authorization: Bearer <snip>` is not the same as `Authorization: bearer <snip>`.
4. Make sure you are using the right environment and check that you are using
   the correct API keys for the right sale unit in that environment. The
   [test environment](../developer-resources/test-environment.md)
   is completely separate from the production environment, and both the MSN and
   the API keys are different.
5. Check both the HTTP response header and the response body from our API for errors.
   For most errors the body contains an explanation of what went wrong.
   See:
   [Errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#errors).
6. If you are a partner and you are using partner keys: Double check everything
   described here:
   [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).
7. Make sure that you are using a valid access token. See
   [Getting started: Get an access token](../vipps-getting-started.md#get-an-access-token)
   for details, how long it is valid, etc.

You can log in to
[portal.vipps.no](https://portal.vipps.no)
to double check your API keys, sale units and API products.
See:
[Getting the API keys](../vipps-getting-started.md#getting-the-api-keys).

You can use
[Postman](../developer-resources/quick-start-guides.md)
to manually do API calls, Use the "inspect" functionality to see the complete requests and responses.

You also need to make sure you have access to the right API.
See:
[API products](../vipps-getting-started.md#api-products).

See:
[Quick overview of how to make an API call](../vipps-getting-started.md#quick-overview-of-how-to-make-an-api-call).

If you are absolutely, completely 100 % sure that you have done everything
correctly, and it _still_ doesn't work, you can regenerate the API keys on
[portal.vipps.no](https://portal.vipps.no).
This should never be necessary, and we cannot think of any situations where
this fixes any known problem, so it's our very last suggestion.
The old API keys will of course stop working when they have been regenerated.

**Important:** Vipps cannot help with the debugging of your code,
we can only help with the API requests and response. Please do not send us your
source code asking us to fix it for you.

## Why do I get `HTTP 403 Forbidden`?

Merchants that only have access to the
[Vipps Login API](https://github.com/vippsas/vipps-login-api)
and attempt to use the Vipps eCom API will get this error, with
`Merchant Not Allowed for Ecommerce Payment` in the body.

This is because the compliance checks required for Vipps eCom API are not
done for merchants that only need the Vipps Login API.
If you need access to the Vipps eCom API, you can apply for it on
[portal.vipps.no](https://portal.vipps.no).

Partners can get this error if they use
[Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys),
but do not send the
`Merchant-Serial-Number` header.

## Why do I get `HTTP 429 Too Many Requests`?

We rate-limit some API endpoints to prevent incorrect usage.
The rate-limiting has nothing to do with Vipps' total capacity, but is
designed to stop obviously incorrect use.
See:
[Rate limiting](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#rate-limiting)
for details.

## Why do I get `HTTP 404 Not Found`?

It depends. You must check the body of the response.

It could be that you are attempting to call a non-existant API endpoint, and
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
  [Postman](https://github.com/vippsas/vipps-developers/blob/master/developer-resources/quick-start-guides.md)
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

* [Errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#errors).
* [Status page](../developer-resources/status-pages.md).

## Why do I get `errorCode 35 "Requested Order not found"`?

This is either because you are specifying an incorrect `orderId`, or because
the payment with this `orderId` was initiated using the API keys for
one sale unit (MSN), and you are attempting to get the details with
the API keys for a different sale unit (MSN).

The `orderId`s is not globally unique, they are only unique per MSN.

See:

* [Why do I get `HTTP 404 Not Found`?](#why-do-i-get-http-404-not-found)
* [Error codes](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#error-codes).

## Why do I get `errorCode 37 "Merchant not available or deactivated or blocked"`?

Or: `Merchant not available or active`.

Please check that the merchant's organization number is still active in
[Brønnøysundregistrene](https://www.brreg.no). Vipps automatically deactivates
merchants (companies) when they are deleted from Brønnøysundregistrene.

Merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and deactivate their sale units. This is sometimes done "by accident", without being
aware of the consequences. If a sale unit has been incorrectly deactivated,
the merchant can reactivate it again.

**Please note:** We require BankID for deactivation and reactivation,
and cannot help with this based on email requests.

Deactivation can also happen if the test merchant is not being used for a _very long_ time.
Please
[contact customer service](https://vipps.no/kontakt-oss/bedrift/vipps/),
and we will reactivate the merchant.

We no longer automatically deactivate test merchants.
Merchants can also create new sale units in the test environment on
[portal.vipps.no](https://portal.vipps.no).

See: [Error codes](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#error-codes).

## Why do I get "Merchant Not Allowed for Ecommerce Payment"?

This error occurs if you attempt to use the Vipps eCom API with a sale unit (MSN)
that is only approved for the Vipps Login API.

Vipps does not do the same checks for sale units that do not make payments,
so to use the eCom API you need to order "Vipps på nett" on
[portal.vipps.no](https://portal.vipps.no)
to go through the regulatory and legally required checks and get
access to the Vipps eCom API.

All sale units that have been approved for the Vipps eCom API can also use
the Vipps Login API, but not the other way around.

See:
[Why do I get `HTTP 403 Forbidden`?](#why-do-i-get-http-403-forbidden)

## Why do I not get the `sub` from `/details`?

If you use the correct `scope` in the payment initiation, but don't get the
`sub` in the response for `/details`: Check that you are following the
[orderId recommendations](../common-topics/orderid.md).
Very short orderIds don't work well with our database index, and may cause
an internal timeout, and we "have to" send the response without the `sub`.
We cannot enforce longer orderIds due to backwards compatibility.

## Why do I get `unauthorized_client`?

If you get errors like below from Microsoft Azure, you are not using the right API keys:

```json
{
  "error": "unauthorized_client",
  "error_description":
    "AADSTS70001: Application with identifier 'e9b6c99d-2442-4a5d-84a2-\
     c53a807fe0c4' was not found in the directory testapivipps.no\
     Trace ID: 3bc2b2a0-d9bb-4c2e-8367- 5633866f1300\r\nCorrelation ID:\
     bb2f4093-70af-446a-a26d-ed8becca1a1a\r\nTimestamp: 2017-05-19 09:21:28Z",
  "error_codes": [ 70001 ],
  "timestamp": "2017-05-19 09:21:28Z",
  "trace_id": "3bc2b2a0-d9bb-4c2e-8367-5633866f1300",
  "correlation_id": "bb2f4093-70af-446a-a26d-ed8becca1a1a"
}
```

```json
{
  "error":"unauthorized_client",
  "error_description":
    "AADSTS700016: Application with identifier \'my_client_id\'
     was not found in the directory \'tenant_directory\'.
     This can happen if the application has not been installed
     by the administrator of the tenant or consented to by any
     user in the tenant. You may have sent your authentication
     request to the wrong tenant.",
  "error_codes":[700016],
  "timestamp":"2021-03-23 06:46:31Z",
  "trace_id":"<snip>",
  "correlation_id":"<snip>",
  "error_uri":"https://login.windows.net/error?code=700016"
}
```

To fix this, please check that you are using the right API keys, similar to:
[Why do I get `HTTP 401 Unauthorized`?](#why-do-i-get-http-401-unauthorized).


## Why do I get error 81 and `User not registered with Vipps`?

The most common reasons are:

* The phone number is incorrectly formatted.
  Vipps attempts to correct incorrectly formatted phone numbers
  instead of responding with `HTTP 400 Bad Request`.
  In cases where the phone number still fails, the error will be `errorCode: 81`.
  See the API specification:
  [`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST).
* The user is under 15 years old and cannot pay businesses.
* The phone number is not for a Vipps user.

Vipps cannot give more details.

## Why do I get an error about having Vipps installed and being 15 years old?

You are probably attempting to use a real Vipps user in the test environment.
See:
[The Vipps Test Environment (MT)](https://github.com/vippsas/vipps-developers/blob/master/developer-resources/test-environment.md).

## Why do I get `Invalid MSN: 654321. Check your API keys on portal.vipps.no and see the eCom FAQ for tips.`?

This can happen when:

* A partner tries to use
  [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
  for a sale unit that is not registered with them as partner.
* API keys for the test environment is used in the production environment, or opposite.
* [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys)
  are used, but the `Merchant-Serial-Number` HTTP header is not used correctly.

## Why do I get `Invalid MSN: 654321. This MSN is not valid for the provided supermerchant id.`?

This error can be caused by the partner making the API request:

* Uses API keys for the test environment in the production environment, or opposite.
* Uses a MSN for the test environment in the production environment, or opposite.
* Uses
  [partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys),
  but does not send the required `Merchant-Serial-Number` header.

Note that there _is no MSN_ in the error message in the example above.
That means it's missing from the request.
