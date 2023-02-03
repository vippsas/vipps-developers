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

## Get your API keys

When your application has been processed, Vipps will send an email
informing you that the API keys can be retrieved. This means that you are ready to start
testing!

Read the
[API keys](./common-topics/api-keys.md) page to make sure you understand what the API keys are
and how to find them.


## Get set up in the test environment

You will use the Merchant Test (MT) environment to create test sale units.

Review the
[The Vipps Test Environment (MT)](test-environment.md)
page for details including:

- [Test server](test-environment.md#test-server)
- [Test merchants](test-environment.md#test-merchants)
- [Test users](test-environment.md#test-users)
- [Vipps test apps](test-environment.md#vipps-test-apps)

## Make an API call

To make an API call, you first need an access token.

1. Get an access token

    All Vipps API calls are authenticated and authorized with an access token
    (JWT bearer token) and an API subscription key.

    The access token is obtained by calling
    [`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/access-token#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)
    and passing the `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key`.

    See the [Access Token API Guide](https://vippsas.github.io/vipps-developer-docs/docs/APIs/access-token-api) for more details about the parameters and responses.

2. Send a request

    Use the access token from the previous step (including the case-sensitive `Bearer` keyword) to provide authentication in other API requests.

    For example,
    [`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST):

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
