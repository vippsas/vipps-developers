<!-- START_METADATA
---
title: API keys
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# API keys

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

All Vipps APIs use the same API keys.

The API keys are retrieved as described here:
[Get credentials](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/vipps-getting-started#get-credentials).

Partners use
[Parter keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).

## API key details

| Name                     | Format | Example                              | Description                                     |
|--------------------------|--------|--------------------------------------|-------------------------------------------------|
| `client_id`              | GUID   | fb492b5e-7907-4d83-bc20-c7fb60ca35de | Client ID for the merchant (the "username")     |
| `client_secret`          | Base64 | Y8Kteew6GE3ZmeycEt6egg==             | Client Secret for the merchant (the "password") |
| `Vipps-Subscription-Key` (or `Ocp-Apim-Subscription-Key`) | Base64 | 0f14ebcab0eb4b29ae0cb90d91b4a84a | Subscription key for the API product |

There are both a primary and secondary `Vipps-Subscription-Key`.
The primary and secondary keys are interchangeable: You can use either one,
they both work in the same way. Having two active keys enables you to
regenerate one subscription key, while still using the other key, without downtime.
If you don't understand what the second key is for, you can just ignore it.

**Please note:** `Vipps-Subscription-Key` was previously called `Ocp-Apim-Subscription-Key`.
The legacy name `Ocp-Apim-Subscription-Key` _must still be used in requests and code_,
but we are working to make `Vipps-Subscription-Key` work everywhere.

## API keys for different use

The same API keys are used for many types of integration:
Direct integration, native apps for iOS and Android, point of sale integrations,
[all the Vipps plugins](https://github.com/vippsas/vipps-plugins)
and any other solution based on the Vipps APIs.
