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

To get an access token:

1. Get your API keys, as described in
   [Common topics: API keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/common-topics/api-keys)

   **Please note:** Partners should use
   [Partner info: Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).

2. Get your access token by calling
   [`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/access-token#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost).

    Include your API keys in the header fields, `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key`.

See the [Access Token API Guide](https://vippsas.github.io/vipps-developer-docs/docs/APIs/access-token-api) for details about the parameters and responses.

Problems? See:
[FAQ: Common errors](../faqs/common-errors-faq.md)
