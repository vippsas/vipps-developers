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

## API products

The `Vipps-API` product gives you access to the majority of Vipps APIs, for example:

- [Access token API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/access-token-api)- Required to obtain a JWT.
- [Check-in API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/check-in-api) - Communicate with users through their Vipps app from the Point of Sale (POS).
- [Checkout API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/checkout-api) - Provide a complete Checkout solution for both Vipps and card payments with auto-fill and shipping integrations.
- [eCom API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api) - Offer Vipps as a method of payment. Offer a quick checkout option where Vipps is the method of payment and the shipping options are specified directly from the Vipps app. This is also known as Vipps Online (_Vipps På Nett_) and Vipps Express Checkout (_Vipps Hurtigkasse_).
- [ePayment API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/epayment-api) - In combination with Checkout API, apply payments, -This is the new version of eCom API.
- [Login API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/login-api) - Allow the customer to log in by using their Vipps account.
- [Order management API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/order-management-api) - Add data to orders.
- [Partner API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/partner-api) - Get info about merchants/sale units.
- [PSP API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/psp-api) - Initiate PSP payments. Update merchants.
- [QR API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/qr-api) - Use QR codes to allow customers to connect to Vipps and purchase from your store.
- [Recurring API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api) - A business or organization can allow their customers to set up recurring payments (e.g., for subscriptions, membership, regular donations, etc.) through Vipps. This is also known as _Vipps Faste Betalinger_.
- [Report API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/report-api) - Fetch information about payment events that have been processed by Vipps.

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
[Vipps test environment (MT)](test-environment.md)
will be provided by email to the user associated with the product order.

If you have questions about your application, please check the status on
[portal.vipps.no](https://portal.vipps.no) or
[contact customer service](https://www.vipps.no/kontakt-oss/bedrift/).

**Please note:** If you plan to use Vipps through a PSP, you will have to
order the appropriate Vipps solution from the PSP,
and have _them_ help you with developer access to their systems.

## Get your credentials

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

## Get set up in the test environment

The Merchant Test Environment (MT) is available for all Vipps merchants
with API access.

See
[Developer resources: The Vipps Test Environment (MT)](test-environment.md)
for details including:

- [Test server](test-environment.md#test-server)
- [Test merchants](test-environment.md#test-merchants)
- [Test users](test-environment.md#test-users)
- [Vipps test apps](test-environment.md#vipps-test-apps)

## Quick overview of how to make an API call

1. Get an access token

    All Vipps API calls are authenticated and authorized with an access token
    (JWT bearer token) and an API subscription key.

    The access token is obtained by calling
    [`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/access-token#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)
    and passing the `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key`.

    ```http
    curl https://apitest.vipps.no/accessToken/get \
    -H "client_id: REPLACE-WITH-YOUR-CLIENT-ID" \
    -H "client_secret: REPLACE-WITH-YOUR-CLIENT-SECRET" \
    -H "Ocp-Apim-Subscription-Key: REPLACE-WITH-YOUR-SUBSCRIPTION-KEY" \
    -X POST
    ```

    This is described in detail in the [Access token API guide](https://vippsas.github.io/vipps-developer-docs/docs/APIs/access-token-api).

   Your integration should include all the [standard Vipps HTTP headers](common-topics/http-headers.md), so that we can help you find debugging information in the logs.

    ```http
    -H "Merchant-Serial-Number: YOUR-MERCHANT-ACCOUNT-NUMBER" \
    -H "Vipps-System-Name: Acme Enterprises Ecommerce DeLuxe" \
    -H "Vipps-System-Version: 3.1.2" \
    -H "Vipps-System-Plugin-Name: Point Of Sale Excellence" \
    -H "Vipps-System-Plugin-Version 4.5.6" \
    ```

2. Make an API request

    Use the access token (JWT) from the previous step (including the case-sensitive `Bearer` keyword) to provide authentication in other API requests.

    For example,
    [`POST:/ecomm/v2/payments`](https://vippsas.githubgithub.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST):

    ```http
    curl https://apitest.vipps.no/ecomm/v2/payments \
    -H "Authorization: Bearer <TOKEN>" \
    -H "Ocp-Apim-Subscription-Key: YOUR-SUBSCRIPTION-KEY" \
    -H "Content-Type: application/json" \
    -H "Merchant-Serial-Number: YOUR-MERCHANT-ACCOUNT-NUMBER" \
    -H "Vipps-System-Name: Acme Enterprises Ecommerce DeLuxe" \
    -H "Vipps-System-Version: 3.1.2" \
    -H "Vipps-System-Plugin-Name: Point Of Sale Excellence" \
    -H "Vipps-System-Plugin-Version 4.5.6" \
    -X POST \
    -d '{
        "merchantInfo": {
          "callbackPrefix":"https://example.com/vipps/callbacks-for-payment-update-from-vipps",
          "fallBack": "https://example.com/vipps/fallback-result-page-for-both-success-and-failure/acme-shop-123-order123abc",
          "merchantSerialNumber": "YOUR-MERCHANT-ACCOUNT-NUMBER"
        },
        "customerInfo": {
          "mobileNumber": "YOUR-PHONE-NUMBER"
        },
        "transaction": {
          "amount": 49900,
          "orderId": "2810171674485753715",
          "transactionText": "Transaction text to be displayed in Vipps.",
          "skipLandingPage": false
    }'
    ```

See the [eCom Quick start guide](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api-quick-start)
to try this out in the Postman environment. It provides a step-by-step guide with examples that you can experiment with.

Problems? See:

* [FAQ: Common errors](./faqs/common-errors-faq.md)
* [HTTP response codes](./common-topics/http-response-codes.md)

### Check for errors with the API Dashboard

All merchants have access to the
[API Dashboard](./developer-resources/api-dashboard.md).
We strongly recommend to use that for detecting errors in the API use,
in addition to normal monitoring.

## Next step: Quick start guides

If you are ready to try out some API request, head over to the
[Quick start guides](quick-start-guides.md) page and read about creating your own test set up!
