---
sidebar_label: Terminology
sidebar_position: 190
pagination_next: null
pagination_prev: null
---


# Terminology

## Common terms

* API keys - Codes that provide a merchant with access to the API (e.g.,
  `client_id`, `client_secret`, `Vipps-Subscription-Key`).
  Also called API credentials. Think of them as "username and password".
  The API keys are found in on [portal.vipps.no](https://portal.vipps.no/)
  in the *Utvikler* section, under *Show keys*.

* `client_id` - The client ID (e.g., the "username") for the merchant. This
  is one of the API keys that is retrieved by logging in on
  [portal.vipps.no](https://portal.vipps.no).

* `client_secret` - The client secret (e.g., "password") for the merchant.
  This is one of the API keys that is retrieved by logging in on
  [portal.vipps.no](https://portal.vipps.no).

* Deeplink - The "deeplink" opens the payment page in the app, where the user
  accepts a payment. This is an integrated part of the payment process,
  and the link should never be sent in an SMS or email.

* Direct capture - **Direct capture** causes all payment reservations to be instantly captured.
  This is intended for situations where the product or service is immediately
  provided to the customer, e.g. digital services.

* Idempotency-Key - An idempotency header ensures that, if the merchant retries
  a request with the same idempotency key, the retried request will not make
  additional changes. See the API specification for the requirements for the
  idempotency key.

* Merchant - A juridical unit, typically called a business or company,
  identified with organization number (`orgno`).

* Merchant Serial Number (MSN) - The MSN identifies a sales unit, not a merchant.
  Partners must always send the `Merchant-Serial-Number` header, and we
  recommend that everyone sends it, also when using the merchant's own API keys.
  The `Merchant-Serial-Number` header can be used with all API keys and can
  speed up any troubleshooting of API problems.

* `Ocp-Apim-Subscription-Key` - The header which supplies the subscription key,
  `Vipps-Subscription-Key`, for the API.

* `orderId` - The API parameter that supplies a unique identifier for the
  payment. This is the same as `reference`. Newer APIs will use `reference`
  instead of `orderId`. See the API specification for the requirements for
  this ID.

* Partner - A partner is a company that represents several merchants by
  providing a platform, helping set up custom integrations, or developing
  our official plugins.
  See:
  [Vipps partners](https://developer.vippsmobilepay.com/docs/vipps-partner).

* Partner keys - Unique identifiers that allow partners to use their own API
  credentials to make API calls on behalf of their merchants.
  See:
  [Partner keys](https://developer.vippsmobilepay.com/docs/vipps-partner/partner-keys).

* Payment Service Provider (PSP) - A third party company that performs online
  payments on behalf of Vipps MobilePay. Settlements for PSP integrations are handled by the PSP.

* `reference` - The API parameter that supplies a unique identifier for the
  payment. This is the same as `orderId`. Newer APIs will use the name `reference`
  instead of `orderId`.

* Reserve capture - Reserve capture is the normal flow. When the end user
  approves an initiated payment, it will be marked as *reserved* by the bank,
  but not transferred. It will stay *reserved* until the point at which it is *captured*.

* Sales unit - A merchant can have one or more sales units. It may be different
  brands, different physical locations, different services, etc.

* `Vipps-Subscription-Key` - This subscription key is retrieved by logging
  in on [portal.vipps.no](https://portal.vipps.no).
  The header which supplies the subscription key to the API is
  `Ocp-Apim-Subscription-Key`.

## Norwegian terms

* BankID - Software that certifies the identity of a person (Norwegian only).

* [Brønnøysundregistrene](https://www.brreg.no/) - The official Norwegian
  register of companies.

* D-number - A Norwegian identification number given to foreign persons who
  do not have a Norwegian national identity number (NIN), but have a need for
  identification for the Norwegian authorities.

* [Finanstilsynet](https://www.finanstilsynet.no) - A Norwegian agency that
  supervises Norwegian financial companies.

* National identity number: An 11-digit number that uniquely identifies
  each Norwegian citizen. This is also called "Fødselsnummer".

* `orgno` - The organization number for a merchant. Nine digits.
This can be used to retrieve information at
  [Brønnøysundregistrene](https://www.brreg.no).
  
## Danish terms

* [MitID](https://www.mitid.dk/en-gb/) - Software that certifies the identity of a person.

* [Det Centrale Virksomhedsregister](https://datacvr.virk.dk/) - The official Danish
  register of companies.

* `orgno` - The organization number for a merchant. Also called CVR or VAT-number. 8 digits.
  This can be used to retrieve information at
  [Det Centrale Virksomhedsregister](https://datacvr.virk.dk/).
  
* [Finanstilsynet](https://www.finanstilsynet.dk/) - The Danish Financial Supervisory Authority that
  supervises Danish financial companies.
  
* CPR nummer - Social Security Number (SSN). A 10-digit number that uniquely identifies
  each Danish citizen. This is also called.
  
* Administrative CPR-number - A Danish identification number given to foreign persons who
  do not have a Danish social security number (SSN), but have a need for
  identification for the Danish authorities.
  
## Finnish terms

* Finnish Trust Network (FTN) - Software that certifies the identity of a person.

* [Yritys- ja yhteisötietojärjestelmä (YJT)](https://ytj.fi/en/index.html) - The official Finnish
  register of companies. 

* `orgno` - The business ID for a merchant. Also called Y-tunnus (Yritys- ja yhteisötunnus) or VAT-number. 8 digits.
  This can be used to retrieve information at
  [YTJ](https://www.ytj.fi/en/index/businessid.html). 
  
* [Finanssivalvonta](https://www.finanssivalvonta.fi/en/) - Financial Supervisory Authority.
   
* Henkilötunnus - Personal Identity Code. A 10-digit number that uniquely identifies
  each Finnish citizen.
 

