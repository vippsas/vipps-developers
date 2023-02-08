<!-- START_METADATA
---
title: API keys
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# API keys

When you start using the Vipps API, you will need to provide API keys.
These are like passcodes that confirm your identity and that your API request is valid.

Your API keys are specific for your sale unit and you will use them to interact with all the
[Vipps API products](https://vippsas.github.io/vipps-developer-docs/docs/APIs).

The same API keys are used for many types of integration:
Direct integration, native apps for iOS and Android, point of sale integrations,
[all the Vipps plugins](https://vippsas.github.io/vipps-developer-docs/docs/vipps-plugins)
and any other solution based on the Vipps APIs.

**Please note:** There are no API keys for
[Vippsnummer](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/),
as there is no external API.

**Please note**: This page describes the keys that are provided to you, as a merchant.
Partners use special keys that will work for all their merchants. These are known as
[*Partner keys*](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).

## Production and Test Keys

The test environment and production environments are completely separate.
You will, therefore, need to use a different set of API keys for the test environment versus the production environment.

- API keys for the test environment:
  Normally available a few minutes after the sales unit is created.
  See [Developer resources: How to create a test sales unit](../developer-resources/portal.md#how-to-create-a-test-sales-unit) for details.
- API keys for the production environment:
  Normally available after a few days after application, depending on the
  workload and whether we need additional information.

### Getting the API keys

To get your API keys:

1. Log in to [portal.vipps.no](https://portal.vipps.no) using BankID.
   See [Developer resources: Permissions and users](../developer-resources/portal.md#permissions-and-users), if necessary.
2. Select _Vipps På Nett_ > _Utvikler_.
3. In the page that opens, you will find your merchant sale unit listed under _Production_ and/or _Test_.
   Click the _Show keys_ button to see your keys.

See [Developer resources: Vipps Portal](../developer-resources/portal.md#how-to-find-the-api-keys) for more details.

**Please note:**

- Vipps cannot provide API keys in any other way, such as by
  email or over the phone, as the API keys give access to transferring money.
- Vipps will never ask for your API keys, and you must keep them secret.
- If your developers do not have Norwegian BankID, you will need to retrieve
  the API keys for them, and send them to the developers in a secure way.
- Do _not_ send API keys unencrypted by email.
- If you accidentally share your API keys, you must generate new ones on
  [portal.vipps.no](https://portal.vipps.no).

## How to use the API keys

The Vipps API Keys are:

| API Key Name             | Description                                                         | Format | Example                              |
|--------------------------|---------------------------------------------------------------------|--------|--------------------------------------|
| `client_id`              | Client id for the sale unit (the "username")                        | GUID   | fb492b5e-7907-4d83-bc20-c7fb60ca35de |
| `client_secret`          | Client secret for the merchant (the "password")                     | Base64 | Y8Kteew6GE3ZmeycEt6egg==             |
| `Vipps-Subscription-Key` (primary)   | Subscription key for the API product                    | Base64 | 0f14ebcab0eb4b29ae0cb90d91b4a84a     |
| `Vipps-Subscription-Key` (secondary) | Subscription key for the API product                    | Base64 | 0f14ebcab0eb4b29ae0cb90d91b4a84a     |

The `client_id` and `client_secret` are used with the
[Access token API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/access-token-api)
to get an access token to use for all subsequent API requests.

There are both a primary and secondary `Vipps-Subscription-Key`.
The primary and secondary keys are interchangeable: You can use either one,
they both work in the same way.
Having two active keys enables you to
regenerate one subscription key, while still using the other key, without downtime.
If you want, you can just ignore the second key.

**Please note:** `Vipps-Subscription-Key` was previously called `Ocp-Apim-Subscription-Key`.
The legacy name `Ocp-Apim-Subscription-Key` _must still be used in some requests and code_,
but we are working to make `Vipps-Subscription-Key` work everywhere.

## Historical note

Vipps has previously had separate API keys for each API product, and a set of
API keys were directly linked to one sale unit. This meant that customers
needed to keep track of multiple API keys, and that access to a new API
required a new sale unit. The API keys for Vipps eCom v1 and v2 APIs have been “upgraded” to include the same APIs as
Vipps API.  The `Vipps-API` product also includes some _legacy_ APIs, such as _eCom API v1_ _Signup and Login_.

If you are still using a legacy API, you should upgrade as soon as possible.
See:
[Vipps API Lifecycle](api-lifecycle.md) for more information.
