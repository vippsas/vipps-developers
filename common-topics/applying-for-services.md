---
title: "Applying for services"
pagination_next: null
pagination_prev: null
---

# Applying for services

As a merchant, you can apply for a *Merchant Agreement*. This is a legal agreement between you and Vipps MobilePay.
Once the *Merchant Agreement* has been submitted, you can order products.

## Requirements

*This is in the process of changing as part of the [Vipps MobilePay joint platform launch](https://www.vippsmobilepay.com/#about).*

Merchants must have the following in order to use Vipps MobilePay as a payment
provider and to receive payments from Vipps and MobilePay users:

* A Norwegian organization number
* A Norwegian bank account
* An appointed contact person with a Norwegian phone number and Norwegian
  identity number (i.e., "fødselsnummer" or "D-nummer", 11 digits).

If a foreign business is registered in the
[Brønnøysund Register](https://www.brreg.no/),
it has a contact person with a Norwegian identity number.

If a foreign business has not yet been formally established, Vipps MobilePay can
manually send the agreement for digital signing with Danish NemID,
Swedish BankID, etc. When this is required, please contact
[customer service](https://vipps.no/kontakt-oss/)
or, for partners, please contact your partner manager.

If the above is impossible, the business can use Vipps MobilePay through a
[Payment Service Provider (PSP)](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-2).

## How to apply

For a merchant planning to do direct integration toward the Vipps MobilePay APIs,
apply for a *Merchant Agreement* on
[portal.vipps.no](https://portal.vipps.no).

**Please note:** If you plan to use Vipps MobilePay through a PSP, please see
[Direct integration and PSP integration](direct-vs-psp.md).

We are required to perform a background check on all merchants who want to use our
services, so it might take a few days before you hear back from us.
You can check the status of your application on
[portal.vipps.no](https://portal.vipps.no).

When the *Merchant Agreement* is approved and your product order is sent,
you (or the user associated with the order) will receive an email
with the name and serial number of your test sales unit, along with the
[test user](../test-environment/#test-users)
for logging into the
[Merchant Test (MT) app](../test-environment/#vipps-test-apps).
Now, you can start testing with the APIs.

When your product order is approved, you will get an email stating that you can
get access to the production environment using your production
[API keys](api-keys.md)
on
[portal.vipps.no](https://portal.vipps.no).
These API keys will allow you to start making API requests to the production server
(e.g., create a payment request that goes to a real user's app).


## Vipps users

Vipps payments can only be made by customers with a Norwegian phone number and
with a Norwegian national identity number or D-number.
This is required by the Norwegian government.

Vipps users must authenticate with Norwegian BankID when creating the Vipps account.

A D-number is given to foreign persons who do not have a Norwegian national identity number,
but have a need for identification for the Norwegian authorities.
Read more on how to
[apply for a D-number](https://www.skatteetaten.no/en/person/foreign/norwegian-identification-number/).

## Services FAQ

### What are the requirements for merchants?

Vipps MobilePay merchants (corporate customers) must have a:

* A Norwegian organization number
* A Norwegian bank account

The merchant's application must be signed with Norwegian BankID.

We must follow the regulatory requirements for KYC (Know Your Customer),
AML (Anti Money Laundering) and other risk assessment procedures.

See:
[Requirements](#requirements).

It is also possible to use Vipps MobilePay through a Payment Service Provider (PSP).
We then rely on the PSP for KYC (Know Your Customer), AML (Anti Money Laundering)
and other risk assessment procedures.
To use a PSP, contact the PSP.

### Can I use my "Vippsnummer" in my webshop?

No.
[Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
can't be used for
[*Vipps på Nett*](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/),
[*Logg inn*](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
or
[*Faste Betalinger* (Recurring payments)](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
because the Norwegian Tax Administration considers *Vippsnummer* to be cash transactions,
while eCommerce is defined as remote sales (in Norwegian, *fjernhandel*). The regulations
associated with both are different enough to require this policy.

You need
[*Vipps på Nett*](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/).
