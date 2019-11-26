# Vipps: Getting Started

This guide covers what you need to get started with Vipps development,
after you have received the welcome email.

Version: 2.1.2.

- [First of all](#first-of-all)
  * [API documentation](#api-documentation)
- [Getting a test account (and a production account)](#getting-a-test-account-and-a-production-account))
- [Getting the API keys](#getting-the-api-keys)
  * [API key details](#api-key-details)
- [API products](#api-products)
  * [Vipps-API](#vipps-api)
  * [Legacy API products](#legacy-api-products)
- [Quick overview of how to make an API call](#quick-overview-of-how-to-make-an-api-call)
  * [Get an access token](#get-an-access-token)
    + [Request](#request)
    + [Response](#response)
    + [HTTP response codes](#http-response-codes)
  * [Make an eCom v2 API call](#make-an-ecom-v2-api-call)
- [Questions?](#questions-)

# First of all

Make sure you have a customer relationship with Vipps, and that you have
an active subscription for the relevant Vipps solution(s):
https://www.vipps.no/produkter-og-tjenester/bedrift/

After ordering a Vipps solution, you will get a welcome email.
This normally takes 1-3 days.

We do not (yet) offer access to the test environment unless you are
a Vipps customer.

For general questions about products, please use the contact form:
https://www.vipps.no/bedrift/kontakt-oss

## API documentation

All Vipps APIs are documented on GitHub: https://github.com/vippsas/

Please see the general developer information: https://github.com/vippsas/vipps-developers

# Getting a test account (and a production account)

The fastest way to get a Vipps developer account for the test and production
environments, is to
[order Vipps on vipps.no](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/).
Choose the "direct integration".
You will need a Norwegian organization number, and to sign the order with BankID.

Test accounts are normally available 24 hours after we receive the order,
depending on the order volume. You will receive an email, and the
API keys can be retrieved by logging in to https://portal.vipps.no with BankID.

Please note: If you plan to use Vipps through a Partner or a PSP, you will have to
order the appropriate Vipps solution, and then contact the Partner or PSP
to have _them_ help you with developer access.

# Getting the API keys

API keys are available in the Vipps Portal, under the `Utvikler` menu item in the top menu:
https://portal.vipps.no

The registered admin user can log in with bankID and fetch the API keys.

All Vipps customers must have a Norwegian organization number, and the customer
agreements are signed with BankID. Since portal.vipps.no give access to APIn keys
for both the test and production environment, we require BankID for loging in.
The customer's administrator can create additional users on portal.vipps.no

If you do not have BankID, you will need the admin to log in and provide the
API keys to you.

**Please note:** Vipps can not provide API keys in any other way, such as by
email, as the API keys give access to transferring money.
Vipps will never ask for your API keys, and you should keep them secret.

## The API products for a salesunit

![portal.vipps.no: The API products for a sales unit](images/portalvippsno-salesunit-products.png)

## API keys for a salesunit

![portal.vipps.no: The API keys for a sales unit](images/portalvippsno-salesunit-keys.png)

## API key details

| Keys              |  Value                                       |
|------------------ |----------------------------------------------|
| `Vipps-Subscription-Key` | This is used in the header for all API requests. |
| `client_id`       | The "username"  |
| `client_secret`   | The "password". Keep this secret.|

**Please note:** `Vipps-Subscription-Key` was previously called `Ocp-Apim-Subscription-Key`.
The legacy name `Ocp-Apim-Subscription-Key` _must still be used in requests and code_,
but we are working to make `Vipps-Subscription-Key` work ASAP.

# API products

An _API product_ is a "package" consisting of one or more APIs.

Vipps has previously had separate API keys for each API product, and a set of API keys were directly linked to one sale unit. This meant that customers needed to keep track of multiple API keys, and that access to a new API required a new sale unit.

This is no longer the case: New customers now get the `Vipps-API` API product.

The Vipps-API API product give access to all current APIs, and the API keys for the Vipps eCom v1 and v2 APIs have been “upgraded” to include the same APIs as Vipps API.


## Vipps-API

This API product includes the following APIs:

| API              | Description                         | Documentation |
| ---------------- | ----------------------------------- | ------------- |
| Access Token   | Required to obtain a JWT | See: [Get an access token](#get-an-access-token) |
| eCom v2        | eCommerce, including express checkout | https://github.com/vippsas/vipps-ecom-api  |
| Recurring      | Recurring API            | https://github.com/vippsas/vipps-recurring-api  |
| Vipps Log In   | Identification           | https://github.com/vippsas/vipps-login-api  |

Vipps-API also includes some legacy APIs:

| API              | Description                         | Documentation |
| ---------------- | ----------------------------------- | ------------- |
| eCom v1          | eCommerce, legacy version, to be phased out. |  https://github.com/vippsas/vipps-ecom-api-v1 |
| Signup and Login | Legacy API (superseded by Vipps Log In), end of life Dec 31 2019 |  https://github.com/vippsas/vipps-signuplogin-api |

If you are still using a legacy API, you should upgrade as soon as possible.
The best way to keep up to date of changes is to
[star the API repository on GitHub](https://help.github.com/en/articles/about-stars).

## Legacy API products

Old API products have the `ZZZ` prefix to make them easy to distinguish,
and to always sort them at the bottom of lists.
One example is `ZZZ eCommerce-Classic-Services-API`.

The legacy API products prefixed with `ZZZ` have been updated to also include the
current, corresponding APIs in Vipps-API.
This means that a salesunit that could previously only use eCom v1,
can now also use eCom v2, with the same API keys as before.

The legacy API products still work, and there is no need to "upgrade" to Vipps-API,
unless there are technical problems.

The current APIs offer substantial improvements over the legacy APIs, and
we strongly recommend upgrading to the current version as soon as possible.

# Quick overview of how to make an API call

## Get an access token

The Access Token API provides the JWT bearer token used in the `Authorization`
header, required in all Vipps API calls.

The API keys needed the access token are the same as for the API products:
* client_id: <client_id>
* client_secret: <client_secret>
* Ocp-Apim-Subscription-Key: <Vipps-Subscription-Key>

### Request

```
POST https://apitest.vipps.no/accessToken/get
client_id: <client_id>
client_secret: <client_secret>
Ocp-Apim-Subscription-Key: <Vipps-Subscription-Key>
```

Header details:

| Name                     | Value                  | Description                      |
| ------------------------ | ---------------------- | -------------------------------- |
| `client_id`              | A GUID value           | Client ID for the merchant       |
| `client_secret`          | Base 64 encoded string | Client Secret for the merchant   |
| `Vipps-Subscription-Key` | Base 64 encoded string | Subscription key for the product |

### Response

```
HTTP 200 OK
{
  "token_type": "Bearer",
  "expires_in": "86398",
  "ext_expires_in": "0",
  "expires_on": "1495271273",
  "not_before": "1495184574",
  "resource": "00000002-0000-0000-c000-000000000000",
  "access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1Ni <snip>"
}
```

JWT properties:

| Name             | Description                                 |
| ---------------- | ------------------------------------------- |
| `token_type`     | It’s a `Bearer` token. The word `Bearer` should be added before the token |
| `expires_in`     | Token expiry duration in seconds. |
| `ext_expires_in` | Extra expiry time. Not used. |
| `expires_on`     | Token expiry time in epoch time format. |
| `not_before`     | Token creation time in epoch time format. |
| `resource`       | For the product for which token has been issued. |
| `access_token`   | The actual access token that needs to be used in `Authorization` request header. |

**Please note:** The JWT (access token) is valid for 1 hour in MT (test) and 24 hours in Production.
To be sure that you are using correct time please use `expires_in` or `expires_on`.

#### HTTP response codes

This API returns the following HTTP statuses in the responses:

| HTTP status         | Description                                 |
| ------------------- | ------------------------------------------- |
| `200 OK`            | Request successful.                          |
| `400 Bad Request`   | Invalid request, see the `error` for details.  |
| `401 Unauthorized`  | Invalid authorization.                         |
| `403 Forbidden`     | Authentication ok, but credentials lacks authorization.  |
| `500 Server Error`  | An internal Vipps problem.  |

## Make an eCom v2 API call

See the eCom v2 API documentation for
[Initiate payment](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#initiate-payment).

# Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-ecom-api/issues),
a [pull request](https://github.com/vippsas/vipps-ecom-api/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
