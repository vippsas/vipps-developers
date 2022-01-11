# Getting Started

This guide is for the following APIs:
* [Vipps eCom API](https://github.com/vippsas/vipps-ecom-api)
* [Vipps Recurring API](https://github.com/vippsas/vipps-recurring-api)
* [Vipps Login API](https://github.com/vippsas/vipps-login-api)
* [Vipps QR API](https://github.com/vippsas/vipps-qr-api )
* [Vipps Order Management API](https://github.com/vippsas/vipps-order-management-api)

Please note that API keys are _not_ available for
[Vippsnummer](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/).

If you are using Vipps through an e-commerce platform, integration partner or PSP, please see the respective resources:
* [E-commerce platform](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-1)
* [Partner](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-3)
* [PSP](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-2)

Document version: 3.2.26.

# Table of contents

- [Requirements](#requirements)
  * [Foreign companies](#foreign-companies)
  * [Vipps users](#vipps-users)
- [Get credentials](#get-credentials)
  * [Getting the API keys](#getting-the-api-keys)
  * [Permissions and users](#permissions-and-users)
  * [Test and production environments](#test-and-production-environments)
  * [List of sale units](#list-of-sale-units)
  * [API keys for a sale unit](#api-keys-for-a-sale-unit)
  * [API key details](#api-key-details)
  * [API keys for different use](#api-keys-for-different-use)
- [API products](#api-products)
  * [Vipps-API](#vipps-api)
  * [Legacy API products](#legacy-api-products)
- [Quick overview of how to make an API call](#quick-overview-of-how-to-make-an-api-call)
  * [Get an access token](#get-an-access-token)
    + [Request](#request)
    + [Response](#response)
  * [Make an API call](#make-an-api-call)
  * [HTTP response codes](#http-response-codes)
- [Questions?](#questions-)

# Requirements

Merchants need a Norwegian organization number and Norwegian BankID to apply for Vipps services.

Before they can order any services, they first need to apply for a Merchant Agreement. This is a legal agreement between the merchant and Vipps. When the Merchant Agreement has been sent, the merchant can apply for the services they want.

Everything can be done through [portal.vipps.no](https://portal.vipps.no). For an overview of all products, see [vipps.no](https://vipps.no/produkter-og-tjenester/bedrift/).

As soon as the Merchant Agreement has been approved, and a product order is sent, access to test is created, and details are sent on email to the user who ordered the product.

## Foreign companies

Foreign companies must have the following in order to use Vipps as a payment
provider and to receive payments from Vipps users:

* A Norwegian organization number
* A Norwegian bank account
* An appointed contact person with a Norwegian phone number and Norwegian
  identity number ("fødselsnummer" or "D-nummer", 11 digits).

If the foreign company is registered in
[Brønnøysundregistrene](https://breeg.no)
it has a contact person with a fødselsnummer or D-nummer.

If the foreign company has not yet been formally established, Vipps can
manually send the agreement for digital signing with Danish NemID,
Swedish BankID, etc. Please contact your partner manager (if you are a partner) or
[customer service](https://vipps.no/kontakt-oss/)
if this is required.

If the above is impossible, the company can use Vipps through a
[Payment Service Provider (PSP)](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-2).

## Vipps users

Vipps payments can only be made by customers with a Norwegian phone number and
with a Norwegian national identity number or D-number.
This is required by the Norwegian government.

Vipps users must authenticate with Norwegian BankID when creating the Vipps account.

A D-number is given to foreign persons who do not have a Norwegian national identity number,
but have a need for identification for the Norwegian authorities.
Read more on how to
[apply for a D-number](https://www.skatteetaten.no/en/person/foreign/norwegian-identification-number/).

# Get credentials

When the application has been processed you will receive an email, and the
API keys can be retrieved by logging in with BankID on
[portal.vipps.no](https://portal.vipps.no).

If you have questions about your application, please check the status on
[portal.vipps.no](https://portal.vipps.no).

If you have questions about your customer relationship, please
[contact customer service](https://www.vipps.no/kontakt-oss/bedrift/).

**Please note:** If you plan to use Vipps through a PSP, you will have to
order the appropriate Vipps solution from the PSP,
and have _them_ help you with developer access to their systems.

## Getting the API keys

API keys can be retrieved, by logging in with BankID on
[portal.vipps.no](https://portal.vipps.no),
under the `Utvikler` menu item.
Since this gives access to API keys for both the test and production environment,
we require BankID.

**Please note:**

* Vipps can not provide API keys in any other way, such as by
  email, as the API keys give access to transferring money.
* Vipps will never ask for your API keys, and you must keep them secret.
* If your developers do not have Norwegian BankID, you will need to retrieve the API keys
  for them, and send them to the developers in a secure way.
* Do _not_ send API keys unencrypted by email.
* If you accidentally share your API keys, you must generate new ones on
  [portal.vipps.no](https://portal.vipps.no).

## Permissions and users

If you do not have BankID,
or you have BankID but not access to the right merchant,
you will need the merchant's administrator to log in on
[portal.vipps.no](https://portal.vipps.no)
and provide the API keys to you in a secure way.

The merchant's administrator can also create additional users on
[portal.vipps.no](https://portal.vipps.no).
If you don't know who the administrator is, you can check
[Brønnøysundregistrene](https://www.brreg.no)
and see who has the right to sign for the company.

If you can login to [portal.vipps.no](https://portal.vipps.no) but cannot see
the "Utvikler" (developer) selection in the menu you need to have the
merchant's administrator grant you developer access for the sales unit you
need access to.

For integration partners: You will need the merchant's administrator to either
log in on
[portal.vipps.no](https://portal.vipps.no)
and grant you developer access for the sales unit you need access to,
or provide the API keys to you in a secure way. See also:
[Vippps Partners](https://github.com/vippsas/vipps-partner).

## Test and production environments

* API keys for the
  [test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md):
  Normally available on
  [portal.vipps.no](https://portal.vipps.no)
  a few minutes after we receive the application.

* API keys for the production environment are normally available on
  [portal.vipps.no](https://portal.vipps.no)
  after a few days, depending on the workload and whether we need additional information.

## List of sale units

Select the `production keys` or `test keys`, then select `Show keys` for
the relevant sale unit to display the API keys.

Click the `i` to get additional information about that column, including
information about how to
[change between "direct capture" and "reserve capture"](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#how-do-i-turn-direct-capture-on-or-off)
and
[how to activate `skipLandingPage`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#is-it-possible-to-skip-the-landing-page).

![portal.vipps.no: The API products for a sales unit](images/portalvippsno-salesunit-products.png)

## API keys for a sale unit

This screen shows the API keys for the selected sale unit.
Some of the API keys are hidden because the logged-in user does not have the
required permissions.

![portal.vipps.no: The API keys for a sales unit](images/portalvippsno-salesunit-keys.png)

## API key details

| Name                     | Format | Example                              |  Description                     |
| ------------------------ | ------ | ------------------------------------ | -------------------------------- |
| `client_id`              | GUID   | fb492b5e-7907-4d83-bc20-c7fb60ca35de | Client ID for the merchant (the "username")     |
| `client_secret`          | Base64 | Y8Kteew6GE3ZmeycEt6egg==             | Client Secret for the merchant (the "password") |
| `Vipps-Subscription-Key` | Base64 | 0f14ebcab0eb4b29ae0cb90d91b4a84a     | Subscription key for the API product |

There are both a primary and secondary `Vipps-Subscription-Key`.
The primary and secondary keys are interchangeable; you can use either one,
they both work in the same way. Having two active keys enables you to
regenerate one subscription key, while still using the other key, without downtime.
If you don't understand what the second key is for, you can just ignore it.

**Please note:** `Vipps-Subscription-Key` was previously called `Ocp-Apim-Subscription-Key`.
The legacy name `Ocp-Apim-Subscription-Key` _must still be used in requests and code_,
but we are working to make `Vipps-Subscription-Key` work everywhere.

## API keys for different use

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

| API                  | Description                           | Documentation                                    |
| -------------------- | ------------------------------------- | ------------------------------------------------ |
| Access Token API     | Required to obtain a JWT              | See: [Get an access token](#get-an-access-token) |
| eCom API             | eCommerce, including express checkout | https://github.com/vippsas/vipps-ecom-api        |
| Recurring API        | Recurring API                         | https://github.com/vippsas/vipps-recurring-api   |
| Log In API           | Identification                        | https://github.com/vippsas/vipps-login-api       |
| QR API               | QR codes                              | https://github.com/vippsas/vipps-qr-api          |
| Order Management API | Add data to orders                    | https://github.com/vippsas/vipps-order-management-api |

Vipps-API also includes some _legacy_ APIs:

| API              | Description                                                      | Documentation                                    |
| ---------------- | ---------------------------------------------------------------- | ------------------------------------------------ |
| eCom API v1      | eCommerce, legacy version, phased out on September 1 2020.       | https://github.com/vippsas/vipps-ecom-api-v1     |
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

Request to
[`POST:/accesstoken/get`](https://vippsas.github.io/vipps-ecom-api/#/Authorization_Service/fetchAuthorizationTokenUsingPost)
(including the Vipps HTTP headers):

```
client_id: fb492b5e-7907-4d83-ba20-c7fb60ca35de
client_secret: Y8Kteew6GE2ZmeycEt6egg==
Ocp-Apim-Subscription-Key: 0f14ebcab0ec4b29ae0cb90d91b4a84a
Merchant-Serial-Number: 123456
Vipps-System-Name: Acme Enterprises Ecommerce DeLuxe
Vipps-System-Version: 3.1.2
Vipps-System-Plugin-Name: Point Of Sale Excellence
Vipps-System-Plugin-Version 4.5.6
```

| Header                        | Description                                  | Example value       |
| ----------------------------- | -------------------------------------------- | ------------------- |
| `Merchant-Serial-Number`      | The MSN for the sale unit                    | `123456`            |
| `Vipps-System-Name`           | The name of the ecommerce solution           | `woocommerce`       |
| `Vipps-System-Version`        | The version number of the ecommerce solution | `5.4`               |
| `Vipps-System-Plugin-Name`    | The name of the ecommerce plugin             | `vipps-woocommerce` |
| `Vipps-System-Plugin-Version` | The version number of the ecommerce plugin   | `1.4.1`             |

The `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key` are unique per
`merchantSerialNumber` (MSN, i.e. the number of the sale unit).

Please note: Partners should use
[partner keys](https://github.com/vippsas/vipps-partner/blob/main/README.md#partner-keys).

Partners must always send the `Merchant-Serial-Number` header, and we recommend
that _everyone_ sends it, also when using the merchant's own API keys.
The `Merchant-Serial-Number` header can be used with all API keys, and can
speed up any trouble-shooting of API problems quite a bit.

**Please note:** You can have multiple access tokens being used at the same time.

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

A typical example of an API endpoint:
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-ecom-api/#/Vipps_eCom_API/initiatePaymentV3UsingPOST)
in the Vipps eCom API:
[Initiate payment flow: API calls](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#initiate-payment-flow-api-calls).

Here is an example with `Authorization` and `Ocp-Apim-Subscription-Key` (but
without the `client_id` and `client_secret`, since they are only used for the
[`POST:/accesstoken/get`](https://vippsas.github.io/vipps-ecom-api/#/Authorization_Service/fetchAuthorizationTokenUsingPost)
call), including the Vipps HTTP headers:

```
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1Ni <snip>
Ocp-Apim-Subscription-Key: 0f14ebcab0ec4b29ae0cb90d91b4a84a
Merchant-Serial-Number: 123456
Vipps-System-Name: Acme Enterprises Ecommerce DeLuxe
Vipps-System-Version: 3.1.2
Vipps-System-Plugin-Name: Point Of Sale Excellence
Vipps-System-Plugin-Version 4.5.6
```

For more details: See the OpenAPI specifications and Postman collections
for the APIs.

Problems? See:
[Common errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#common-errors).

## HTTP response codes

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

# Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
