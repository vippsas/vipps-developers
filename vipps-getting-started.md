<!-- START_METADATA
---
title: Getting started
sidebar_position: 2
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Getting started

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/vipps-getting-started).

<!-- END_COMMENT -->

Document version: 3.7.1.

<!-- START_TOC -->

## Table of contents

- [API products](#api-products)
- [Apply for Vipps services](#apply-for-vipps-services)
- [Get credentials](#get-credentials)
  - [Permissions and users](#permissions-and-users)
  - [Getting the API keys](#getting-the-api-keys)
- [Test environment](#test-environment)
- [Quick overview of how to make an API call](#quick-overview-of-how-to-make-an-api-call)
  - [Get an access token](#get-an-access-token)
  - [Make an API call](#make-an-api-call)
  - [Checking for errors with the API Dashboard](#checking-for-errors-with-the-api-dashboard)
- [Next step: Quick start guides](#next-step-quick-start-guides)
- [Questions?](#questions)

<!-- END_TOC -->

## API products

The `Vipps-API` product gives you access to the majority of Vipps APIs for example:

- [Checkout API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/checkout-api/) - Provide a complete Checkout solution for both Vipps and card payments with auto-fill and shipping integrations.
- [eCom API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/) - Offer Vipps as a method of payment. Offer a quick checkout option where Vipps is the method of payment and the shipping options are specified directly from the Vipps app. This is also known as Vipps Online (_Vipps På Nett_) and Vipps Express Checkout (_Vipps Hurtigkasse_).
- [ePayment API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/epayment-api/) - In combination with Checkout API, apply payments, -This is the new version of eCom API.
- [Login API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/login-api/) - Allow the customer to log in by using their Vipps account.
- [Order Management API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/order-management-api/) - Add data to orders.
- [Partner API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/partner-api/) - Get info about merchants/sale units.
- [PSP API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/psp-api/) - Initiate PSP payments. Update merchants.
- [QR API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/qr-api/) - Use QR codes to allow customers to connect to Vipps and purchase from your store.
- [Recurring API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api/) - A business or organization can allow their customers to set up recurring payments (e.g., for subscriptions, membership, regular donations, etc.) through Vipps. This is also known as _Vipps Faste Betalinger_.
- [Report API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/report-api) - Fetch information about payment events that have been processed by Vipps.
- [Access Token API](#get-an-access-token)- Required to obtain a JWT.

**Please note:** API keys are _not_ available for
[Vippsnummer](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/),
as there is no external API.

For an overview of all products, in Norwegian, see [vipps.no](https://vipps.no/produkter-og-tjenester/bedrift/).

## Apply for Vipps services

Apply for vipps services on [portal.vipps.no](https://portal.vipps.no).

You need to have a Norwegian organization number, applications must be signed with Norwegian BankID,
you must apply for a _Merchant Agreement_ and order a Vipps service.
See
[Common topics: Requirements for applying for a Vipps service](./common-topics/requirements.md).

As soon as the _Merchant Agreement_ has been approved and a product order is sent,
access to the
[Vipps test environment (MT)](./developer-resources/test-environment.md)
will be provided by email to the user associated with the product order.

If you have questions about your application, please check the status on
[portal.vipps.no](https://portal.vipps.no) or
[contact customer service](https://www.vipps.no/kontakt-oss/bedrift/).

**Please note:** If you plan to use Vipps through a PSP, you will have to
order the appropriate Vipps solution from the PSP,
and have _them_ help you with developer access to their systems.

## Get credentials

When your application has been processed, Vipps will send an email
informing you that the API keys can be retrieved by
logging in with BankID on the [Vipps portal (portal.vipps.no)](https://portal.vipps.no).

For details, see:

- [Developer resources: Vipps portal](./developer-resources/portal.md).

### Permissions and users

For problems logging in to the Vipps Portal, see:

- [Developer resources: Vipps Portal: Permissions and users](./developer-resources/portal.md#permissions-and-users).

### Getting the API keys

See
[Common topics: API keys](./common-topics/api-keys.md)
for details including:

- [How to find API keys](./common-topics/api-keys.md#getting-the-api-keys)
- [Production versus test keys](./common-topics/api-keys.md#production-and-test-keys)
- [How to use the keys with the API](./common-topics/api-keys.md#how-to-use-the-api-keys)

## Test environment

The Merchant Test Environment (MT) is available for all Vipps merchants
with API access.

See
[Developer resources: The Vipps Test Environment (MT)](./developer-resources/test-environment.md)
for details including:

- [Test server](./developer-resources/test-environment.md#test-server)
- [Test merchants](./developer-resources/test-environment.md#test-merchants)
- [Test users](./developer-resources/test-environment.md#test-users)
- [Vipps test apps](./developer-resources/test-environment.md#vipps-test-apps)

## Quick overview of how to make an API call

We recommend using the
[standard Vipps HTTP headers](common-topics/http-headers.md)
for all requests.

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
[partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).

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
[FAQ: Common errors](faqs/common-errors-faq.md).

### Make an API call

After obtaining the access token (JWT), it is then used for the "real" calls
to the Vipps API, with the `Bearer` keyword (it is case-sensitive).

A typical example of an API endpoint:
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
in the Vipps eCom API:
[Initiate payment flow: API calls](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#initiate-payment-flow-api-calls).

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

* [FAQ: Common errors](./faqs/common-errors-faq.md)
* [HTTP response codes](./common-topics/http-response-codes.md)

### Checking for errors with the API Dashboard

All merchants have access to the
[API Dashboard](./developer-resources/api-dashboard.md).
We strongly recommend to use that for detecting errors in the API use,
in addition to normal monitoring.


## Next step: Quick start guides

If you are ready to try out some API request, head over to the
[Quick start guides](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/developer-resources/quick-start-guides) page and read about creating your own test set up!

See:

* [Quick start guides: What you need for getting started with the API](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/developer-resources/quick-start-guides)

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).

Sign up for our [Technical newsletter for developers](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters).
