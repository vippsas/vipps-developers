# Vipps: Getting Started

This guide covers what you need to get started with Vipps development, after
you have received the welcome email.

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
    + [Make an eCom v2 API call](#make-an-ecom-v2-api-call)
- [Questions?](#questions-)

Version: 2.0.0.

# Getting the API keys

API keys are available in the Vipps Portal: https://portal.vipps.no

Make sure you have an active subscription to the relevant Vipps product(s): https://www.vipps.no/bedrift
For general questions about products, please use the contact form: https://www.vipps.no/bedrift/kontakt-oss

The registered admin user can log in with BankID and fetch the API keys.
Please note that Vipps can not provide API keys in any other way.
The admin user may create additional users on the Vipps Portal.

## API key details

| Keys              |  Value                                       |
|-------------------|----------------------------------------------|
| `Vipps-Subscription-Key` | This is used in the header for all API requests. |
| `client_id`  | The "username" |
| `client_secret` | The "password". Keep this secret.|

Please note: `Vipps-Subscription-Key` was previously called `Ocp-Apim-Subscription-Key`.
The legacy name still works, but please change to the current version as soon
as possible.

# API products

An _API product_ is a "package" consisting of one or more APIs.

Vipps has previously had separate API keys for each API product, and
that a set of API keys were directly linked to one salesunit.
This meant that customers needed to keep track of multiple API keys,
and that access to a new API required a new salesunit.
This is no longer the case.

New customers now get the `Vipps-API` API product.

## Vipps-API

This API product includes the following APIs:

| API            | Description                         | Documentation |
| -------------- | ----------------------------------- | ------------- |
| Access Token   | Required to obtain an access token  | Included in each API |
| eCom v2        | eCommerce, current version.         | https://github.com/vippsas/vipps-ecom-api  |
| Recurring      | Recurring API.                      | https://github.com/vippsas/vipps-recurring-api  |

Vipps-API also includes some legacy APIs:

| API            | Description                         | Documentation |
| -------------- | ----------------------------------- | ------------- |
| eCom v1        | eCommerce, legacy version, to be phased out. |  https://github.com/vippsas/vipps-ecom-api-v1 |
| Signup and Login  | Legacy API, superseeded by Vipps Log In  |  https://github.com/vippsas/vipps-signuplogin-api |

If you are still using a legacy API, you should upgrade as soon as possible.
The best way to keep up to date of changes is to
[star the API repository on GitHub](https://help.github.com/en/articles/about-stars).

## Legacy API products

Old API products have been given the `ZZZ-` prefix to make them easy to distinguish,
and to always sort them at the bottom of lists.

The API products prefixed with `ZZZ-` have been updated to also include the
APIs in Vipps-API. This means that a salesunit that could previously only use
eCom v1, can now also use eCom v2, with the same API keys as before.

The legacy API products still work, and there is no need to "upgrade" to Vipps-API,
unless there are technical problems.

# Quick overview of how to make an API call

## Get an access token

The Access Token API provides the JWT bearer token used in the `Authorization`
header, required in all Vipps API calls.

### Request

```
POST https://apitest.vipps.no/accessToken/get
client_id: <client_id>
client_secret: <client_secret>
Vipps-Subscription-Key: <Vipps-Subscription-Key>
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

**Please note:** The access token is valid for 1 hour in MT and 24 hours in Production. To be sure that you are using correct time please use `expires_in` or `expires_on`.

### HTTP response codes

This API returns the following HTTP statuses in the responses:

| HTTP status         | Description                                 |
| ------------------- | ------------------------------------------- |
| `200 OK`            | Request successful.                          |
| `400 Bad Request`   | Invalid request, see the `error` for details.  |
| `401 Unauthorized`  | Invalid authorization.                         |
| `403 Forbidden`     | Authentication ok, but credentials lacks authorization.  |
| `500 Server Error`  | An internal Vipps problem.  

### Make an eCom v2 API call

See the eCom v2 API documentation for
[Initiate payment](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#initiate-payment).

# Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-ecom-api/issues),
a [pull request](https://github.com/vippsas/vipps-ecom-api/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
