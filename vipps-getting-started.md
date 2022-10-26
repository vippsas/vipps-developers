<!-- START_METADATA
---
title: Getting started
sidebar_position: 2
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Getting Started

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

The Vipps APIs provide access to the following types of transactions.

In-person and remote transactions:

- _Vipps Checkout (Vipps Checkout)_ - A complete Checkout solution for both Vipps and card payments with auto-fill and shipping integrations.

In-person transactions:

- _Vennebetaling (Person to Person payments)_ - A person can transfer money to another person. They must both have configured their Vipps app with their respective bank account numbers. There is no API.

- _Vippsnummer (Vipps number)_ - An organization or company can receive an identification number from Vipps. Customers can then register their payments to this number. This gives people the possibility of paying or donating money without cash. There is no API.

- _Vipps i kassa (Vipps In Store)_ - A company can integrate its Point of Sale (POS) system with Vipps so that in-store customers can pay by using Vipps, and the sale will be automatically registered in their system.

Remote transactions:

- _Vipps Logg Inn (Vipps Login)_ - A website or app can allow the customer to log in by using their Vipps account.

- _Vipps på nett (Vipps Online)_ - An online store or app can offer Vipps as a method of payment.

- _Vipps Hurtigkasse (Vipps Express Checkout)_ - An online store can offer a quick checkout option where Vipps is the method of payment and the shipping options are specified directly from the Vipps app.

- _Faste betalinger (Recurring payments)_ - A business or organization can allow their customers to set up recurring payments (e.g., for subscriptions, membership, regular donations, etc.) through Vipps.

Document version: 3.5.0.

<!-- START_TOC -->

## Table of contents

- [API products](#api-products)
- [Requirements](#requirements)
  - [Non-Norwegian companies](#non-norwegian-companies)
  - [Vipps users](#vipps-users)
- [Get credentials](#get-credentials)
  - [Getting the API keys](#getting-the-api-keys)
  - [Permissions and users](#permissions-and-users)
  - [Test and production environments](#test-and-production-environments)
  - [List of sale units](#list-of-sale-units)
  - [API keys for a sale unit](#api-keys-for-a-sale-unit)
  - [API key details](#api-key-details)
  - [API keys for different use](#api-keys-for-different-use)
- [Quick overview of how to make an API call](#quick-overview-of-how-to-make-an-api-call)
  - [Vipps HTTP headers](#vipps-http-headers)
  - [Idempotency header](#idempotency-header)
  - [Get an access token](#get-an-access-token)
  - [Make an API call](#make-an-api-call)
  - [HTTP response codes](#http-response-codes)
  - [Checking for errors with the API Dashboard](#checking-for-errors-with-the-api-dashboard)
- [Questions?](#questions)

<!-- END_TOC -->

## API products

The `Vipps-API` product gives you access to all of the following APIs:

- [Access Token API](#get-an-access-token)- Required to obtain a JWT
- [Checkout API](https://github.com/vippsas/vipps-checkout-api) - Checkout API
- [eCom API](https://github.com/vippsas/vipps-ecom-api) - eCommerce, including express checkout
- [ePayment API](https://github.com/vippsas/vipps-epayment-api) - New version of eCom API
- [Login API](https://github.com/vippsas/vipps-login-api) - Identification
- [Order Management API](https://github.com/vippsas/vipps-order-management-api) - Add data to orders
- [Partner API](https://github.com/vippsas/vipps-partner-api) - Get info about merchants/sale units
- [PSP API](https://github.com/vippsas/vipps-psp-api) - Initiate PSP payments. Update merchants
- [QR API](https://github.com/vippsas/vipps-qr-api) - QR codes
- [Recurring API](https://github.com/vippsas/vipps-recurring-api) - Recurring API

**Please note:** API keys are _not_ available for
[Vippsnummer](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/),
as there is no external API.

For an overview of all products, in Norwegian, see [vipps.no](https://vipps.no/produkter-og-tjenester/bedrift/).

### Note to existing users

Vipps has previously had separate API keys for each API product, and a set of
API keys were directly linked to one sale unit. This meant that customers
needed to keep track of multiple API keys, and that access to a new API
required a new sale unit. The API keys for Vipps eCom v1 and v2 APIs have been “upgraded” to include the same APIs as
Vipps API.  The `Vipps-API` product also includes some _legacy_ APIs, such as _eCom API v1_ _Signup and Login_.

If you are still using a legacy API, you should upgrade as soon as possible.
See:
[Vipps API Lifecycle](vipps-api-lifecycle.md) for more information.

## Requirements

To apply for Vipps services, you need to have a Norwegian organization number, Norwegian BankID.

In addition, before you can order any Vipps services, you must apply for
a _Merchant Agreement_. This is a legal agreement between you and Vipps.
Once the _Merchant Agreement_ has been submitted, you can order Vipps
products.

You will do everything on [portal.vipps.no](https://portal.vipps.no).

As soon as the _Merchant Agreement_ has been approved, and a product order is sent,
access to the
[Vipps test environment (MT)](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md)
will be provided. Details are sent on email to the user who made the product order.

### Non-Norwegian companies

Non-Norwegian companies must have the following in order to use Vipps as a payment
provider and to receive payments from Vipps users:

- A Norwegian organization number
- A Norwegian bank account
- An appointed contact person with a Norwegian phone number and Norwegian
  identity number (i.e., "fødselsnummer" or "D-nummer", 11 digits).

If the foreign company is registered in

[Brønnøysundregistrene](https://www.brreg.no/)
it has a contact person with a Norwegian identity number.

If the foreign company has not yet been formally established, Vipps can
manually send the agreement for digital signing with Danish NemID,
Swedish BankID, etc. Please contact your partner manager (if you are a partner) or
[customer service](https://vipps.no/kontakt-oss/)
if this is required.

If the above is impossible, the company can use Vipps through a
[Payment Service Provider (PSP)](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-2).

### Vipps users

Vipps payments can only be made by customers with a Norwegian phone number and
with a Norwegian national identity number or D-number.
This is required by the Norwegian government.

Vipps users must authenticate with Norwegian BankID when creating the Vipps account.

A D-number is given to foreign persons who do not have a Norwegian national identity number,
but have a need for identification for the Norwegian authorities.
Read more on how to
[apply for a D-number](https://www.skatteetaten.no/en/person/foreign/norwegian-identification-number/).

## Get credentials

When your application has been processed, Vipps will send an email
informing you that the API keys can be retrieved by logging in with BankID on
[portal.vipps.no](https://portal.vipps.no).

If you have questions about your application, please check the status on
[portal.vipps.no](https://portal.vipps.no).

If you have questions about your customer relationship, please
[contact customer service](https://www.vipps.no/kontakt-oss/bedrift/).

**Please note:** If you plan to use Vipps through a PSP, you will have to
order the appropriate Vipps solution from the PSP,
and have _them_ help you with developer access to their systems.

### Getting the API keys

To get your API keys:

1. Log in to [portal.vipps.no](https://portal.vipps.no) using BankID.

2. Select _Vipps På Nett_ > _Utvikler_.

   - Not available for _Vippsnummer_ ,as it has no API.

3. In the page that opens, you will find your merchant sale unit listed under _Production_ and/or _Test_. Click the _Show keys_ button to see your keys.

**Please note:**

- Vipps cannot provide API keys in any other way, such as by
  email, as the API keys give access to transferring money.
- Vipps will never ask for your API keys, and you must keep them secret.
- If your developers do not have Norwegian BankID, you will need to retrieve
  the API keys for them, and send them to the developers in a secure way.
- Do _not_ send API keys unencrypted by email.
- If you accidentally share your API keys, you must generate new ones on
  [portal.vipps.no](https://portal.vipps.no).

### Permissions and users

If you do not have BankID,
or you have BankID but not access to the correct merchant,
you will need the merchant's administrator to log in on
[portal.vipps.no](https://portal.vipps.no)
and provide the API keys to you in a secure way.

The merchant's administrator can also create additional users on
[portal.vipps.no](https://portal.vipps.no).
If you don't know who the administrator is, you can check
[Brønnøysundregistrene](https://www.brreg.no)
and see who has the right to sign for the company.

If you can log in to [portal.vipps.no](https://portal.vipps.no), but cannot see
the "Utvikler" (developer) selection in the menu, you need to have the
merchant's administrator grant you developer access for the sales unit you
need access to.

For integration partners: You will need the merchant's administrator to either
log in on
[portal.vipps.no](https://portal.vipps.no)
and grant you developer access for the sales unit you need access to,
or provide the API keys to you in a secure way.
The user permissions are described (in Norwegian)
[here](https://vipps.no/hjelp/vipps/kundeforholdet-mitt/hvilke-tilganger-kan-vi-opprette-i-vippsportalen/).
See also:
[Vipps Partners](https://github.com/vippsas/vipps-partner).

### Test and production environments

The test and production environments are completely separate and use different API keys.

- API keys for the
  [test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md):
  Normally available on
  [portal.vipps.no](https://portal.vipps.no)
  a few minutes after we receive the application.

- API keys for the production environment are normally available on
  [portal.vipps.no](https://portal.vipps.no)
  after a few days, depending on the workload and whether we need additional information.

### List of sale units

Select the `production keys` or `test keys`, then select `Show keys` for
the relevant sale unit to display the API keys.

Click the `i` to get additional information about that column, including
information about how to
[change between "direct capture" and "reserve capture"](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#how-do-i-turn-direct-capture-on-or-off)
and
[how to activate `skipLandingPage`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#is-it-possible-to-skip-the-landing-page).

![portal.vipps.no: The API products for a sales unit](images/portalvippsno-salesunit-products.png)

### API keys for a sale unit

This screen shows the API keys for the selected sale unit.
Some API keys are hidden because the logged-in user does not have the
required permissions.

![portal.vipps.no: The API keys for a sales unit](images/portalvippsno-salesunit-keys.png)

### API key details

| Name                     | Format | Example                              | Description                                     |
|--------------------------|--------|--------------------------------------|-------------------------------------------------|
| `client_id`              | GUID   | fb492b5e-7907-4d83-bc20-c7fb60ca35de | Client ID for the merchant (the "username")     |
| `client_secret`          | Base64 | Y8Kteew6GE3ZmeycEt6egg==             | Client Secret for the merchant (the "password") |
| `Vipps-Subscription-Key` (or `Ocp-Apim-Subscription-Key`) | Base64 | 0f14ebcab0eb4b29ae0cb90d91b4a84a     | Subscription key for the API product            |

There are both a primary and secondary `Vipps-Subscription-Key`.
The primary and secondary keys are interchangeable: You can use either one,
they both work in the same way. Having two active keys enables you to
regenerate one subscription key, while still using the other key, without downtime.
If you don't understand what the second key is for, you can just ignore it.

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

## Quick overview of how to make an API call

### Vipps HTTP headers

Please use the following Vipps HTTP headers for all requests to the
Vipps APIs. These headers provide useful metadata about the merchant's system,
which help Vipps improve our services, and also helps in investigating problems.

These headers are **required for plugins and partners** and sent by the recent versions of
[the official Vipps plugins](https://github.com/vippsas/vipps-plugins)
and we recommend all customers with direct integration with the API to also do so.

Partners must always send the `Merchant-Serial-Number` header, and we recommend
that _everyone_ sends it, also when using the merchant's own API keys.
The `Merchant-Serial-Number` header can be used with all API keys, and can
speed up any trouble-shooting of API problems quite a bit.

**Important:** Please use self-explanatory, human readable and reasonably short
values that uniquely identify the system (and plugin).

#### Example headers

For example, if the merchant's name is "Acme AS" and they offers three different systems:
point of sale (POS) integration, webshop, and vending machines,
the headers could be:

| Header| Description| Example value for POS | Example for webshop | Example for vending machine | Example for WooCommerce plugin |
|-------------------------------|----------------------------------------------|-----------|----------------|--------|---------------|
| `Vipps-System-Plugin-Name`    | The name of the ecommerce plugin             | `acme-pos`| `acme-webshop` | `acme-vending` | `vipps-woocommerce` |
| `Vipps-System-Name`           | The name of the ecommerce solution           | `acme`    | `acme`         | `acme` | `woocommerce` |
| `Vipps-System-Version`        | The version number of the ecommerce solution | `1.7`     | `2.6`          | `2.6` | `5.4` |
| `Vipps-System-Plugin-Version` | The version number of the ecommerce plugin   | `3.2`     | `4.3`          | `4.3` | `1.4.1` |
| `Merchant-Serial-Number`      | The MSN for the sale unit                    | `123456`  | `123456`       | `123456` | `123456` |

#### Idempotency header

Many API requests to Vipps APIs can be retried without any side effects
by providing `Idempotency-key`(in older APIs, this may be called, `Request-Id`) in the header of the
request. For example, in case the request fails because of network error, it can
safely be retried with the same `Idempotency-key` key. The `Idempotency-key` key must be
generated by the merchant.

You can use any unique id for your idempotency header.

For example:

```json
Request-Id: slvnwdcweofjwefweklfwelf
```

**Important:** If the response is a client-error (4xx), you will continue to get the same error as long as you use the same idempotency-key, as the requested operation is not retried.

**Important:** If you reuse an idempotency-key on a different request, you will get a 409 CONFLICT.

### Get an access token

All Vipps API calls are authenticated and authorized with an access token
(JWT bearer token) and an API subscription key:

| Header Name                 | Header Value                | Description      |
|:----------------------------|:----------------------------|:-----------------|
| `Authorization`             | `Bearer <JWT access token>` | Type: Authorization token. See [Get an access token](#get-an-access-token). |
| `Ocp-Apim-Subscription-Key` | Base 64 encoded string      | The subscription key for this API. This is available on [portal.vipps.no](https://portal.vipps.no). |

All Vipps API requests must include an `Authorization` header with
a JSON Web Token (JWT), which we call the _access token_.

The access token is obtained by calling
[`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)
and passing the `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key`.
(We _are_ aware that this is a `POST`, without a body, to an endpoint with
`get` in the URL, and hope to fix it in a later version of the API. Sorry for the inconvenience.)

#### Request

Request to
[`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)
(including the Vipps HTTP headers):

```json
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
|-------------------------------|----------------------------------------------|---------------------|
| `Merchant-Serial-Number`      | The MSN for the sale unit                    | `123456`            |
| `Vipps-System-Name`           | The name of the ecommerce solution           | `woocommerce`       |
| `Vipps-System-Version`        | The version number of the ecommerce solution | `5.4`               |
| `Vipps-System-Plugin-Name`    | The name of the ecommerce plugin             | `vipps-woocommerce` |
| `Vipps-System-Plugin-Version` | The version number of the ecommerce plugin   | `1.4.1`             |

The `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key` are unique per
`merchantSerialNumber` (MSN, i.e. the number of the sale unit).

Please note: Partners should use
[partner keys](https://github.com/vippsas/vipps-partner/blob/main/README.md#partner-keys).

**Please note:** You can have multiple access tokens being used at the same time.

**Please note:** We are in process of changing the name of the header
`Ocp-Apim-Subscription-Key` to `Vipps-Subscription-Key`. We will at some point
phase out the old name completely, but it is not trivial and will take some time.
You may encounter both in the developer documentation, and the actual header
name to send is `Ocp-Apim-Subscription-Key`.

#### Response

The response from
[`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)
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

| Name             | Description                                                                      |
|------------------|----------------------------------------------------------------------------------|
| `Bearer`         | It’s a `Bearer` token. The word `Bearer` must be added before the token          |
| `expires_in`     | Token expiry duration in seconds.                                                |
| `ext_expires_in` | Extra expiry time. Not used.                                                     |
| `expires_on`     | Token expiry time in epoch time format.                                          |
| `not_before`     | Token creation time in epoch time format.                                        |
| `resource`       | For the product for which token has been issued.                                 |
| `access_token`   | The actual access token that needs to be used in `Authorization` request header. |

**Please note:** The access token is valid for 1 hour in the test environment
and 24 hours in the production environment. To be sure that you are using
correct time please use `expires_in` or `expires_on`.
The access token is a JWT (JSON Web Token), and uses UTC time.

Problems? See:
[Common errors](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#common-errors).

### Make an API call

After obtaining the access token (JWT), it is then used for the "real" calls
to the Vipps API, with the `Bearer` keyword (it is case-sensitive).

A typical example of an API endpoint:
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
in the Vipps eCom API:
[Initiate payment flow: API calls](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#initiate-payment-flow-api-calls).

Here is an example with `Authorization` and `Ocp-Apim-Subscription-Key` (but
without the `client_id` and `client_secret`, since they are only used for the
[`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)
call), including the Vipps HTTP headers:

```json
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

### HTTP response codes

This API returns the following HTTP statuses in the responses:

| HTTP status        | Description                                             |
|--------------------|---------------------------------------------------------|
| `200 OK`           | Request successful.                                     |
| `400 Bad Request`  | Invalid request, see the `error` for details.           |
| `401 Unauthorized` | Invalid authorization.                                  |
| `403 Forbidden`    | Authentication ok, but credentials lacks authorization. |
| `500 Server Error` | An internal Vipps problem.                              |

You can use the
[API Dashboard](https://github.com/vippsas/vipps-developers/blob/master/vipps-resources.md#api-dashboard)
to check the responses to your API calls.

### Checking for errors with the API Dashboard

All merchants have access to the
[API Dashboard](https://github.com/vippsas/vipps-developers/blob/master/vipps-resources.md#api-dashboard).
We strongly recommend to use that for detecting errors in the API use,
in addition to normal monitoring.

![API Dashboard](newsletters/images/2021-02-api-dashboard-example.png)

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
