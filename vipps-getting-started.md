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

    See the [ePayment Getting started guide](https://vippsas.github.io/vipps-developer-docs/docs/APIs/epayment-api/getting-started)
to try this out in the Postman environment. It provides a step-by-step guide with examples that you can experiment with.


## Check the API Dashboard

All merchants have access to the
[API Dashboard](./developer-resources/api-dashboard.md).
We strongly recommend to use that for detecting errors in the API use,
in addition to normal monitoring.

## Experiment with the quick start guides

If you are ready to try out some API request, head over to the
[Quick start guides](quick-start-guides.md) page and read about creating your own test set up!
