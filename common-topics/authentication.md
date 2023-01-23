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



## Get an access token

All Vipps API calls are authenticated and authorized with an access token
(JWT bearer token) and an API subscription key.

To get an access token:

1. Get your API keys, as described in
   [Common topics: API keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/common-topics/api-keys)

   **Please note:** Partners should use
   [Partner info: Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).

2. Get your access token by calling
   [`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost).

    Include your API keys in the header fields, `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key`.

    For example:

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

    The `client_id`, `client_secret` and `Ocp-Apim-Subscription-Key` are unique per
    `merchantSerialNumber`.
    See [HTTP Headers](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/common-topics/http-headers)
    for a description of the standard Vipps header fields.


    **Please note:** You can have multiple access tokens being used at the same time.

    **Please note:** We are in process of changing the name of the header
    `Ocp-Apim-Subscription-Key` to `Vipps-Subscription-Key`. We will at some point
    phase out the old name completely, but it is not trivial and will take some time.
    You may encounter both in the developer documentation, and the actual header
    name to send is `Ocp-Apim-Subscription-Key`.

    **Please note:** Unfortunately, there is legacy code that results in this being is a `POST`, without a body, to an endpoint with
    `get` in the URL. Sorry for the inconvenience.



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
[FAQ: Common errors](../faqs/common-errors-faq.md)
