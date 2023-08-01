---
title: Authentication
pagination_next: null
pagination_prev: null
---

# Authentication

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/vipps-developers/).
<!-- END_COMMENT -->

All Vipps API requests must include the `Authorization` header with
a JSON Web Token (JWT), which we call the *access token*.

To get an access token, first you need to have API keys. Get your API keys, as described in
[API keys](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/api-keys).
Partners should use
[Partner keys](https://developer.vippsmobilepay.com/docs/partner/partner-keys).

Get your access token by calling
[`POST:/accesstoken/get`](https://developer.vippsmobilepay.com/api/access-token#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)
and including the `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key` headers.

For example:

```http
curl https://apitest.vipps.no/accessToken/get \
-H "client_id: REPLACE-WITH-YOUR-CLIENT-ID" \
-H "client_secret: REPLACE-WITH-YOUR-CLIENT-SECRET" \
-H "Ocp-Apim-Subscription-Key: REPLACE-WITH-YOUR-SUBSCRIPTION-KEY" \
-H "Merchant-Serial-Number: REPLACE-WITH-YOUR-MERCHANT-ACCOUNT-NUMBER" \
-H "Vipps-System-Name: Acme Commerce" \
-H "Vipps-System-Version: 1.7" \
-H "Vipps-System-Plugin-Name: acme-webshop" \
-H "Vipps-System-Plugin-Version 4.3" \
-X POST
```

Read more about the [standard Vipps HTTP headers](http-headers.md).

Many of these headers are optional during testing, but you should include them in your integration, so that error information can be found in the logs.

See the [Access Token API Guide](https://developer.vippsmobilepay.com/docs/APIs/access-token-api) for more details about the parameters and responses.
