<!-- START_METADATA
---
sidebar_label: Terminology
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Terminology

Document version: 1.0.0.

## Common terms

* API keys - Codes that give a merchant access to the API (e.g.,
  `client_id`, `client_secret`, `Vipps-Subscription-Key`).
  Also called API credentials. Think of them as "username and password".
  The API keys are found in on [portal.vipps.no](https://portal.vipps.no/)
  in the *Utvikler* section, under *Show keys*.

* BankID - Software that certifies the identity of a person.

* [Brønnøysundregistrene](https://www.brreg.no/) - The official Norwegian
  register of companies.

* `client_id` - The client ID (e.g., the "username") for the merchant. This
  is one of the API keys that is retrieved by logging in on
  [portal.vipps.no](https://portal.vipps.no).

* `client_secret` - The client secret (e.g., "password") for the merchant.
  This is one of the API keys that is retrieved by logging in on
  [portal.vipps.no](https://portal.vipps.no).

* D-number - A Norwegian identification number given to foreign persons who
  do not have a Norwegian national identity number (NIN), but have a need for
  identification for the Norwegian authorities.

* Deeplink - The Vipps "deeplink" opens the payment page in Vipps where the user
  accepts a payment. This is an integrated part of the Vipps payment process,
  and the link should never be sent in an SMS or email.

* Direct capture - **Direct capture** causes all payment reservations to be instantly captured.
  This is intended for situations where the product or service is immediately
  provided to the customer, e.g. digital services.

* [Finanstilsynet](https://www.finanstilsynet.no) - A Norwegian agency that
  supervises Norwegian financial companies.

* Fødselsnummer: See: National identity number.  

* Idempotency-Key - An idempotency header ensures that, if the merchant retries
  a request with the same idempotency key, the retried request will not make
  additional changes. See the API specification for the requirements for the
  idempotency key.

* Merchant - A juridical unit, typically called a business or company,
  identified with organization number (`orgno`).

* Merchant Serial Number (MSN) - The unique id of a sale unit.
  MSN is short for "Merchant Serial Number", but identifies a sale unit, not
  a merchant. A payment is uniquely identified by the combination of
  `merchantSerialNumber` and `orderId` (e.g., `acme-shop-123-order123abc`).
  Partners must always send the `Merchant-Serial-Number` header, and we
  recommend that everyone sends it, also when using the merchant's own API keys.
  The `Merchant-Serial-Number` header can be used with all API keys and can
  speed up any troubleshooting of API problems quite a bit.

* National identity number: An 11 digit number that uniquely identifies
  each Norwegian citizen.

* `Ocp-Apim-Subscription-Key` - See `Vipps-Subscription-Key`.

* `orderId` - The API parameter that supplies a unique identifier for the
  payment. This is the same as `reference`. Newer APIs will use `reference`
  instead of `orderId`. See the API specification for the requirements for
  this id.

* `orgno` - The organization number for a merchant. Nine digits.
  Can be used to retrieve information at
  [Brønnøysundregistrene](https://www.brreg.no).

* Partner - A Vipps partner is a company that represents several merchants by
  providing a platform, helping set up custom integrations, or developing
  Vipps' official plugins.
  See:
  [Vipps partners](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/).

* Partner keys - Unique identifiers that allow partners to use their own API
  credentials to make API calls on behalf of their merchants.
  See:
  [Partner keys](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/partner-keys).

* Payment Service Provider (PSP) - A third-party company that performs online
  payments on behalf of Vipps. Vipps does not handle the settlements for PSP
  integrations. These are handled by the PSP.

* `reference` - The API parameter that supplies a unique identifier for the
  payment. This is the same as `orderId`. Newer APIs will use `reference`
  instead of `orderId`.

* Reserve capture - Reserve capture is the normal flow. When the end user
  approves an initiated payment, it will be reserved until you capture it.
  When the order is reserved, the amount is marked as reserved by the bank,
  but not transferred.

* Sale unit - A merchant can have one or more sale units. It may be different
  brands, different physical locations, different services, etc.

* `Vipps-Subscription-Key` - The header which supplies the subscription key
  for the Vipps API. This is one of the API keys that is retrieved by logging
  in on [portal.vipps.no](https://portal.vipps.no). Note that
  `Vipps-Subscription-Key` was previously called `Ocp-Apim-Subscription-Key`,
  but some APIs still use the previous name.

## Commonly used Norwegian words

* *Abonnement* - subscription

* *Betale, betalt, betalinger* - Pay, paid, payments

* *Fødselsnummer* - Norwegian identity number, 11 digits. The last five digits are called "personnummer".

* *Månedsabonnement* - Monthly subscription

* *Straksbetaling* - Instant payments

* *Transaksjoner* - Transactions

* *Utvikler* - Software developer
