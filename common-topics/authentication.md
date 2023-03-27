<!-- START_METADATA
---
title: Authentication
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Authentication

All Vipps API requests must include an `Authorization` header with
a JSON Web Token (JWT), which we call the _access token_.

To get an access token, first you need to have API keys. Get your API keys, as described in
[API keys](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/api-keys).
Partners should use
[Partner keys](https://developer.vippsmobilepay.com/docs/vipps-partner/partner-keys).

Get your access token by calling
[`POST:/accesstoken/get`](https://developer.vippsmobilepay.com/api/access-token#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)
and including the `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key` headers.

For example:

```http
curl https://apitest.vipps.no/accessToken/get \
-H "client_id: REPLACE-WITH-YOUR-CLIENT-ID" \
-H "client_secret: REPLACE-WITH-YOUR-CLIENT-SECRET" \
-H "Ocp-Apim-Subscription-Key: REPLACE-WITH-YOUR-SUBSCRIPTION-KEY" \
-H "Merchant-Serial-Number: YOUR-MERCHANT-ACCOUNT-NUMBER" \
-H "Vipps-System-Name: Acme Enterprises Ecommerce DeLuxe" \
-H "Vipps-System-Version: 3.1.2" \
-H "Vipps-System-Plugin-Name: Point Of Sale Excellence" \
-H "Vipps-System-Plugin-Version 4.5.6" \
-X POST
```

Many of these headers are optional during testing, but you should include them in your integration, so that error information can be found in the logs.
Read more about the [standard Vipps HTTP headers](http-headers.md).

See the [Access Token API Guide](https://developer.vippsmobilepay.com/docs/APIs/access-token-api) for more details about the parameters and responses.
