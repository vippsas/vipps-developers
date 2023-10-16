---
title: "FAQ: Applying for services"
sidebar_label: Applying for services
sidebar_position: 105
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

If a foreign business is registered in
[Brønnøysundregistrene](https://www.brreg.no/),
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
[Direct integration and PSP integration](../common-topics/direct-vs-psp.md).

We are required to perform a background check on all merchants who want to use our
services, so it might take a few days before you hear back from us.
You can check the status of your application on
[portal.vipps.no](https://portal.vipps.no)
or
by contacting [customer service](https://www.vipps.no/kontakt-oss/).

When the *Merchant Agreement* is approved and your product order is sent,
you (or the user associated with the order) will receive an email
with the name and serial number of your test sales unit, along with the
[test user](https://developer.vippsmobilepay.com/docs/test-environment/#test-users)
for logging into the
[Merchant Test (MT) app](https://developer.vippsmobilepay.com/docs/test-environment/#vipps-test-apps).
Now, you can start testing with the APIs.

When your product order is approved, you will get an email stating that you can
get access to the production environment using your production
[API keys](../common-topics/api-keys.md)
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
