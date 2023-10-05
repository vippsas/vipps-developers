---
title: "FAQ: Common errors"
sidebar_label: Common errors
sidebar_position: 110
pagination_next: null
pagination_prev: null
---

# FAQ: Common errors

See also error descriptions in the specific API guide sections (e.g., [ePayment API FAQ](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/faq/#what-do-all-the-errors-mean), [eCom API FAQ](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-faq#common-errors)).

## Why do I get `HTTP 400 Bad Request`?

It is because you are making an incorrect API request. The response body contains
information about what you are doing wrong.

Some common errors:

* Invalid API keys.
* Invalid amount.
* callbackUrl is invalid.
* Captured amount exceeds the reserved amount. You can not capture a higher amount than the user has accepted.
* Cannot refund more than captured amount.
* User unknown. The phone number is either incorrectly formatted, is not a Vipps or MobilePay user, or the user is under 15 years old and
  cannot pay businesses. Vipps MobilePay cannot give more details. This error also occurs
  if using a non-Norwegian phone number.

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
7. If you are a partner, and you are using partner keys: Double check everything
   described here:
   [Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys).
   A common mistake is to mix `Merchant-Serial-Number` (used in the HTTP header)
   and `merchantSerialNumber` (used in the request body).

You can log in to
[portal.vipps.no](https://portal.vipps.no)
to double-check your API keys, sales units and API products.
See:
[Getting the API keys](../common-topics/api-keys.md#getting-the-api-keys).

You should also ensure you have access to the correct API.
See:
[API products](https://developer.vippsmobilepay.com/docs/APIs).

If you are absolutely, completely 100 % sure that you have done everything
correctly, and it *still* doesn't work, you can regenerate the API keys on
[portal.vipps.no](https://portal.vipps.no).
This should never be necessary, and we do not know of any situations where
this fixes any known problem, so it's our very last suggestion.
The old API keys will of course stop working when they have been regenerated.

**Important:** Vipps MobilePay cannot help with the debugging of your code,
we can only help with the API requests and response. Please do not send us your
source code asking us to fix it for you.

## Why do I get `HTTP 403 Forbidden`?

Merchants that only have access to the
[Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api)
and attempt to use the ePayment API (or eCom API) will get this error, with
`Merchant Not Allowed for Ecommerce Payment` in the response body.

This is because the compliance checks required for making payments are not
done for merchants that only need the Login API.
If you need access to the ePayment API (or eCom API), you can apply for this on
[portal.vipps.no](https://portal.vipps.no).

Partners can get this error if they use
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys),
but:

* Do not send the `Merchant-Serial-Number` header.
* Send a `Merchant-Serial-Number` header for a sales unit (MSN) that is not connected
  to them as a partner. The partner keys can only be used for sales units that are
  connected to them as a partner.

See: [HTTP headers](https://developer.vippsmobilepay.com/docs/common-topics/http-headers/).

## Why do I get "Merchant Not Allowed for Ecommerce Payment"?

This error occurs if you attempt to use a payment related API with a sales unit (MSN)
that is only approved for the Login API.

Your sales unit will need to go through a different set of regulatory and legally required checks
to get access to the payment APIs.
Place an order for *Vipps på Nett* through the
[merchant portal](https://portal.vipps.no).

Note that all sales units that have been approved for the eCom API can also use
the Login API, but not the other way around.

## Why do I get an error about having the app installed and being 15 years old?

This can happen when:

* You attempt to use a real user in the test environment.
* You have a new test user and have not logged into the test app before
  trying to make payments, etc.

See:
[Test Environment (MT)](../test-environment.md).
