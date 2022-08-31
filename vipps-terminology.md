<!-- START_METADATA
---
title: Terminology
sidebar_position: 95
---
END_METADATA -->

# Vipps terminology

Document version: 1.0.0.

## Common terms

* API keys - Codes that give a merchant access to the API (e.g., `client_id`, `client_secret`, `Vipps-Subscription-Key`).
These are found in the [VippsPortal](https://portal.vipps.no/) in the *Utvikler* section, under *Show keys*.

* BankID - Software that certifies the identity of a person.

* D-number - A Norwegian identification number given to foreign persons who do not have a Norwegian national identity number, but have a need for identification for the Norwegian authorities.

* Deeplink - The Vipps "deeplink" opens the payment page in Vipps where the user
accepts a payment. This is an integrated part of the Vipps payment process,
and the link should never be sent in an SMS or email.

* Direct capture - **Direct capture** causes all payment reservations to be instantly captured.
This is intended for situations where the product or service is immediately
provided to the customer, e.g. digital services.

* Idempotency-Key - An idempotency header ensures that, if the merchant retries a request with the same idempotency key, the retried request will not make additional changes.

* Merchant - A juridical unit, typically called a business or company, identified with organization number (`orgno`).

* Merchant Serial Number (MSN) - The unique id of a sale unit. 
    MSN is short for "Merchant Serial Number", but identifies a sale unit, not a merchant. A payment is uniquely identified by the combination of `merchantSerialNumber` and `orderId` (e.g., `acme-shop-123-order123abc`). Partners must always send the `Merchant-Serial-Number` header, and we recommend that everyone sends it, also when using the merchant's own API keys. The `Merchant-Serial-Number` header can be used with all API keys and can speed up any troubleshooting of API problems quite a bit.

* `orderId` - Every Vipps payment needs a unique `orderId`. A payment is uniquely identified by the combination of `merchantSerialNumber` and `orderId` (e.g., `acme-shop-123-order123abc`).

* `orgno` - The organization number for a merchant.

* Partner - A Vipps partner is a company that represents several merchants by providing a platform, helping set up custom integrations, or developing Vipps' official plugins.

* Partner keys - Unique identifiers that allow partners to use their own API credentials to make API calls on behalf of their merchants.

* Payment Service Provider (PSP) - A third-party company that performs online payments on behalf of Vipps. Vipps does not handle the settlements for PSP integrations. These are handled by the PSP.

* Reserve capture - Reserve capture is the normal flow. When the end user approves an initiated payment, it will be reserved until you capture it. When the order is reserved, the amount is marked as reserved by the bank, but not transferred.

* Sale unit - A merchant can have one or more sale units. It may be different   brands, different physical locations, different services, etc.

## Commonly used Norwegian words

* *Abonnement* - subscription

* *Betale, betalt, betalinger* - Pay, paid, payments

* [*Brønnøysundregistrene*](https://breeg.no/) - The official Norwegian register of companies

* [*Finanstilsynet*](https://www.finanstilsynet.no) - A Norwegian agency that supervises companies

* *Fødselsnummer* - Norwegian identity number

* *Månedsabonnement* - Monthly subscription

* *Straksbetaling* - Instant payments

* *Transaksjoner* - Transactions

* *Utvikler* - Software developer
