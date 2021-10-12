# Getting Started

This guide only applies to the following APIs:
* [Vipps eCom API](https://github.com/vippsas/vipps-ecom-api)
* [Vipps Login API](https://github.com/vippsas/vipps-login-api)
* [Vipps Recurring API](https://github.com/vippsas/vipps-recurring-api)

If you are using Vipps through an e-commerce platform, integration partner or PSP, please see the respective resources:

* [Ecommerce platform](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-1)
* [Partner](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-3)
* [PSP](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-2)

Document version: 3.2.6.

## Table of contents

- [Requirements](#requirements)
  - [Foreign companies](#foreign-companies)
  - [Vipps users](#vipps-users)
- [Get credentials](#get-credentials)
- [Getting the API keys](#getting-the-api-keys)
  - [List of sale units](#list-of-sale-units)
  - [API keys for a salesunit](#api-keys-for-a-salesunit)
  - [API key details](#api-key-details)
  - [API keys for different use](#api-keys-for-different-use)
- [API products](#api-products)
  - [Vipps-API](#vipps-api)
  - [Legacy API products](#legacy-api-products)
- [Quick overview of how to make an API call](#quick-overview-of-how-to-make-an-api-call)
  - [Get an access token](#get-an-access-token)
    - [Request](#request)
    - [Response](#response)
  - [Make an API call](#make-an-api-call)
  - [HTTP response codes](#http-response-codes)
- [Questions?](#questions)

## Requirements

Merchants need a Norwegian organization number and BankID to apply for Vipps services.

The fastest way to get a Vipps developer account for the test and production
environments, is to apply for a product at
[vipps.no](https://vipps.no/produkter-og-tjenester/bedrift/).

### Foreign companies

Foreign companies must have the following in order to use Vipps as a payment
provider and to receive payments from Vipps users:
* A Norwegian organization number
* A Norwegian bank account
* An appointed contact person with a Norwegian phone and identity number

### Vipps users

Vipps payments can only be made by customers with a Norwegian phone number and
with a Norwegian national identity number or D-number.
This is required by the government.

A D-number is given to foreign persons who do not have a national identity number,
but have a need for identification for the Norwegian authorities.
Read more on how to
[apply for a D-number](https://www.skatteetaten.no/en/person/foreign/norwegian-identification-number/).

## Get credentials

When the application has been processed you will receive an email, and the
API keys can be retrieved by logging in with BankID on
[portal.vipps.no](https://portal.vipps.no).

If you have questions about your customer relationship, or an application, please
[contact customer service](https://www.vipps.no/kontakt-oss/bedrift/).

**Please note:** If you plan to use Vipps through a Partner or a PSP, you will have to
order the appropriate Vipps solution, and then contact the Partner or PSP
to have _them_ help you with developer access.

## Getting the API keys

API keys can be retrieved, by logging in with BankID on
[portal.vipps.no](https://portal.vipps.no),
under the `Utvikler` menu item.
Since this gives access to API keys for both the test and production environment,
we require BankID.

**Please note:** Vipps can not provide API keys in any other way, such as by
email, as the API keys give access to transferring money.
Vipps will never ask for your API keys, and you must keep them secret.
If your developers do not have Norwegian BankID, you will need to retrieve the API keys
for them, and send them to the developers in a secure way.
Do _not_ send API keys unencrypted by email.
If you accidentally share your API keys, you must generate new ones on
[portal.vipps.no](https://portal.vipps.no).

If you do not have BankID, you will need the administrator to log in
[portal.vipps.no](https://portal.vipps.no)
and provide the API keys to you in a secure way.
The merchant's administrator can create additional users on
[portal.vipps.no](https://portal.vipps.no).
If you don't know who the administrator is, you can check
[Brønnøysundregistrene](https://www.brreg.no)
and see who has the right to sign for the company.

* API keys for the
  [test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md):
  Normally available on
  [portal.vipps.no](https://portal.vipps.no)
  24 hours after we receive the application.

* API keys for the production environment are normally available on
  [portal.vipps.no](https://portal.vipps.no)
  after a few days, depending on the workload and whether we need additional information.

Please note that API keys are _not_ available for
[Vippsnummer](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/).
You may need to order
[Vipps På Nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/),
[Vipps Faste Betalinger](https://www.vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
or
[Vipps Logg Inn](https://www.vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/).
See
[Vipps products](https://vipps.no/produkter-og-tjenester/bedrift/)
for an overview of all Vipps products, and
also the
[Vipps plugins](https://github.com/vippsas/vipps-plugins).

### List of sale units

Select the `production keys` or `test keys`,
then select `Show keys` for the relevant sale unit to display the credentials.

![portal.vipps.no: The API products for a sales unit](images/portalvippsno-salesunit-products.png)

### API keys for a salesunit

![portal.vipps.no: The API keys for a sales unit](images/portalvippsno-salesunit-keys.png)

### API key details

| Name                     | Format | Example                              |  Description                     |
| ------------------------ | ------ | ------------------------------------ | -------------------------------- |
| `client_id`              | GUID   | fb492b5e-7907-4d83-bc20-c7fb60ca35de | Client ID for the merchant (the "username")     |
| `client_secret`          | Base64 | Y8Kteew6GE3ZmeycEt6egg==             | Client Secret for the merchant (the "password") |
| `Vipps-Subscription-Key` | Base64 | 0f14ebcab0eb4b29ae0cb90d91b4a84a     | Subscription key for the API product |

There are both a primary and secondary `Vipps-Subscription-Key`.
The primary and secondary keys are interchangeable; you can use either one,
they both work in the same way. Having two active keys enables you to
regenerate one subscription key, while still using the other key, without downtime.

**Please note:** `Vipps-Subscription-Key` was previously called `Ocp-Apim-Subscription-Key`.
The legacy name `Ocp-Apim-Subscription-Key` _must still be used in requests and code_,
but we are working to make `Vipps-Subscription-Key` work everywhere.

### API keys for different use

The same API keys are used for many types of integration:
Direct integration,
native apps for iOS and Android,
point of sale integrations,
[all the Vipps plugins](https://github.com/vippsas/vipps-plugins)
and any other solution based on the Vipps eCom API.

# API products

An _API product_ is a "package" consisting of one or more APIs.

Vipps has previously had separate API keys for each API product, and a set of
API keys were directly linked to one sale unit. This meant that customers
needed to keep track of multiple API keys, and that access to a new API
required a new sale unit.
This is no longer the case: New customers now get the `Vipps-API` API product.

The Vipps-API API product give access to all current APIs, and the API keys for
the Vipps eCom v1 and v2 APIs have been “upgraded” to include the same APIs as
Vipps API.

## Vipps-API

This API product includes the following APIs:

| API          | Description                           | Documentation                                    |
| ------------ | ------------------------------------- | ------------------------------------------------ |
| Access Token | Required to obtain a JWT              | See: [Get an access token](#get-an-access-token) |
| eCom v2      | eCommerce, including express checkout | https://github.com/vippsas/vipps-ecom-api        |
| Recurring    | Recurring API                         | https://github.com/vippsas/vipps-recurring-api   |
| Vipps Log In | Identification                        | https://github.com/vippsas/vipps-login-api       |

Vipps-API also includes some _legacy_ APIs:

| API              | Description                                                      | Documentation                                    |
| ---------------- | ---------------------------------------------------------------- | ------------------------------------------------ |
| eCom v1          | eCommerce, legacy version, phased out on September 1 2020.       | https://github.com/vippsas/vipps-ecom-api-v1     |
| Signup and Login | Legacy API (superseded by Vipps Log In), end of life Dec 31 2019 | https://github.com/vippsas/vipps-signuplogin-api |

See more details about the
[phase-out of eCom API v1](https://github.com/vippsas/vipps-ecom-api/blob/master/v1-deprecation.md)
on September 1 2020.

If you are still using a legacy API, you should upgrade as soon as possible.
The best way to keep up to date of changes is to
[star the API repository on GitHub](https://help.github.com/en/articles/about-stars).

See:
[Vipps API Lifecycle](vipps-api-lifecycle.md).

## Legacy API products

Old API products have the `ZZZ` prefix to make them easy to distinguish,
and to always sort them at the bottom of lists.
One example is `ZZZ eCommerce-Classic-Services-API`.

The legacy API products prefixed with `ZZZ` have been updated to also include the
current, corresponding APIs in Vipps-API.
This means that a sale unit that could previously only use eCom v1,
can now also use eCom v2, with the same API keys as before.

The legacy `ZZZ` API products still work, and there is no need to "upgrade" to Vipps-API,
unless there are technical problems.

The current APIs offer substantial improvements over the legacy APIs, and
we strongly recommend upgrading to the current version as soon as possible.

# Quick overview of how to make an API call

## Get an access token

All Vipps API requests must include an `Authorization` header with
a JSON Web Token (JWT), which we call the _access token_.
The access token is obtained by calling
[`POST:/accesstoken/get`](https://vippsas.github.io/vipps-ecom-api/#/Authorization_Service/fetchAuthorizationTokenUsingPost)
and passing the `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key`.
(We _are_ aware that this is a `POST`, without a body, to an endpoint with
`get` in the URL, and hope to fix it in a later version of the API. Sorry.)

### Request

Request (including the recommended `Vipps-*` HTTP headers):

```http
POST https://apitest.vipps.no/accesstoken/get
client_id: fb492b5e-7907-4d83-ba20-c7fb60ca35de
client_secret: Y8Kteew6GE2ZmeycEt6egg==
Ocp-Apim-Subscription-Key: 0f14ebcab0ec4b29ae0cb90d91b4a84a
Vipps-System-Name: Acme Enterprises Ecommerce DeLuxe
Vipps-System-Version: 3.1.2
Vipps-System-Plugin-Name: Point Of Sale Excellence
Vipps-System-Plugin-Version 4.5.6
```

The `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key` are unique per
`merchantSerialNumber` (MSN, i.e. the number of the sale unit) and can be found on
[portal.vipps.no](https://portal.vipps.no).

| Header Name                 | Header Value           | Description                      |
| --------------------------- | ---------------------- | -------------------------------- |
| `client_id`                 | A GUID value           | Client ID for the sale unit      |
| `client_secret`             | Base 64 encoded string | Client Secret for the sale unit  |
| `Ocp-Apim-Subscription-Key` | Base 64 encoded string | Subscription key for the product |

**Note** You can have multiple access tokens being used at the same time.

**Please note:** We are in process of changing the name of the header
`Ocp-Apim-Subscription-Key` to `Vipps-Subscription-Key`. We will at some point
phase out the old name completely, but it is not trivial and will take some time.
You may encounter both in the developer documentation, and the actual header
name to send is `Ocp-Apim-Subscription-Key`.

### Response

The response from
[`POST:/accesstoken/get`](https://vippsas.github.io/vipps-ecom-api/#/Authorization_Service/fetchAuthorizationTokenUsingPost)
is like this:

```json
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

The `access_token` is the most important part.
An explanation of the contents of the access token (the JWT properties):

| Name                        | Description                                 |
| --------------------------- | ------------------------------------------- |
| `Bearer`                    | It’s a `Bearer` token. The word `Bearer` must be added before the token |
| `expires_in`                | Token expiry duration in seconds. |
| `ext_expires_in`            | Extra expiry time. Not used. |
| `expires_on`                | Token expiry time in epoch time format. |
| `not_before`                | Token creation time in epoch time format. |
| `resource`                  | For the product for which token has been issued. |
| `access_token`              | The actual access token that needs to be used in `Authorization` request header. |

**Please note:** The access token is valid for 1 hour in the test environment
and 24 hours in the production environment. To be sure that you are using
correct time please use `expires_in` or `expires_on`.

Problems? See:
[Common errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#common-errors).

## Make an API call

After obtaining the access token (JWT), it is then used for the "real" calls
to the Vipps API, with the `Bearer` keyword (it is case sensitive).
Here is an example of HTTP headers, with the recommended `Vipps-*` HTTP headers:

```http
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1Ni <snip>
Ocp-Apim-Subscription-Key: 0f14ebcab0ec4b29ae0cb90d91b4a84a
Vipps-System-Name: Acme Enterprises Ecommerce DeLuxe
Vipps-System-Version: 3.1.2
Vipps-System-Plugin-Name: Point Of Sale Excellence
Vipps-System-Plugin-Version: 4.5.6
```

A typical example of an API endpoint:
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-ecom-api/#/Vipps_eCom_API/initiatePaymentV3UsingPOST)
in the Vipps eCom API:
[Initiate payment flow: API calls](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#initiate-payment-flow-api-calls).

For more details: See the OpenAPI specifications and Postman collections
for the APIs.

Problems? See:
[Common errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#common-errors).

### HTTP response codes

This API returns the following HTTP statuses in the responses:

| HTTP status        | Description                                             |
| ------------------ | ------------------------------------------------------- |
| `200 OK`           | Request successful.                                     |
| `400 Bad Request`  | Invalid request, see the `error` for details.           |
| `401 Unauthorized` | Invalid authorization.                                  |
| `403 Forbidden`    | Authentication ok, but credentials lacks authorization. |
| `500 Server Error` | An internal Vipps problem.                              |

You can use the
[API Dashboard](https://github.com/vippsas/vipps-developers#api-dashboard)
to check the responses to your API calls.

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
