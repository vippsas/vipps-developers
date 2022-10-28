<!-- START_METADATA
---
title: Keys and headers
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# HTTP keys and headers

Please use the following Vipps HTTP headers for all requests to the
Vipps APIs. These headers provide useful metadata about the merchant's system,
which help Vipps improve our services, and also helps in investigating problems.

These headers are **required for plugins and partners** and sent by the recent versions of
[the official Vipps plugins](https://github.com/vippsas/vipps-plugins)
and we recommend all customers with direct integration with the API to also do so.

Partners must always send the `Merchant-Serial-Number` header, and we recommend
that _everyone_ sends it, also when using the merchant's own API keys.
The `Merchant-Serial-Number` header can be used with all API keys, and can
speed up any trouble-shooting of API problems quite a bit.

**Important:** Please use self-explanatory, human readable and reasonably short
values that uniquely identify the system (and plugin).

## Example headers

For example, if the merchant's name is "Acme AS" and they offers three different systems:
point of sale (POS) integration, webshop, and vending machines,
the headers could be:

| Header| Description| Example value for POS | Example for webshop | Example for vending machine | Example for WooCommerce plugin |
|-------------------------------|----------------------------------------------|-----------|----------------|--------|---------------|
| `Vipps-System-Plugin-Name`    | The name of the ecommerce plugin             | `acme-pos`| `acme-webshop` | `acme-vending` | `vipps-woocommerce` |
| `Vipps-System-Name`           | The name of the ecommerce solution           | `acme`    | `acme`         | `acme` | `woocommerce` |
| `Vipps-System-Version`        | The version number of the ecommerce solution | `1.7`     | `2.6`          | `2.6` | `5.4` |
| `Vipps-System-Plugin-Version` | The version number of the ecommerce plugin   | `3.2`     | `4.3`          | `4.3` | `1.4.1` |
| `Merchant-Serial-Number`      | The MSN for the sale unit                    | `123456`  | `123456`       | `123456` | `123456` |

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
