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
