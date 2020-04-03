# First og all
This guide only applies to the following APIs: Ecommerce, Recurring and Login. 

If you are using an e-commerce platform, integration partner or PSP, please see the respective resources:

* [Ecommerce platform](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-1)
* [Partner](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-3)
* [PSP](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-2)

## Table of contents
  - [First of all](#first-of-all)
    - [API documentation](#api-documentation)
  - [Getting a test account (and a production account)](#getting-a-test-account-and-a-production-account)
  - [Getting the API keys](#getting-the-api-keys)
    - [The API products for a salesunit](#the-api-products-for-a-salesunit)
    - [API keys for a salesunit](#api-keys-for-a-salesunit)
    - [API key details](#api-key-details)
  - [API products](#api-products)
    - [Vipps-API](#vipps-api)
    - [Legacy API products](#legacy-api-products)
  - [Quick overview of how to make an API call](#quick-overview-of-how-to-make-an-api-call)
    - [Get an access token](#get-an-access-token)
      - [Request](#request)
      - [Response](#response)
      - [HTTP response codes](#http-response-codes)
    - [Make an eCom v2 API call](#make-an-ecom-v2-api-call)
- [Questions?](#questions)

## Get credentials
The fastest way to get a Vipps developer account for the test and production
environments, is to apply for a product at [vipps.no](https://vipps.no/produkter-og-tjenester/bedrift/).

*Note: You will need a Norwegian organization number to apply for Vipps services*

Test credentials are normally available 24 hours after we receive the order. When the application has been processed You will receive an email, and the
API keys can be retrieved by logging in to https://portal.vipps.no with BankID.

Please note: If you plan to use Vipps through a Partner or a PSP, you will have to
order the appropriate Vipps solution, and then contact the Partner or PSP
to have _them_ help you with developer access.

## Getting the API keys

API keys are available in the Vipps Portal, under the `Utvikler` menu item in the top menu:
https://portal.vipps.no

The registered admin can log in with BankID and fetch the API keys.

All Vipps customers must have a Norwegian organization number, and the customer
agreements are signed with BankID. Since portal.vipps.no give access to API keys
for both the test and production environment, we require BankID for loging in.
The customer's administrator can create additional users on portal.vipps.no

If you do not have BankID, you will need the admin to log in and provide the
API keys to you.

**Please note:** Vipps can not provide API keys in any other way, such as by
email, as the API keys give access to transferring money.
Vipps will never ask for your API keys, and you should keep them secret.

### List of sale units
Click `Show keys` on the relevant sale unit to display credentials.
 
![portal.vipps.no: The API products for a sales unit](images/portalvippsno-salesunit-products.png)

### API keys for a salesunit
![portal.vipps.no: The API keys for a sales unit](images/portalvippsno-salesunit-keys.png)

### API key details

| Keys                     | Value                                            |
| ------------------------ | ------------------------------------------------ |
| `Vipps-Subscription-Key` | This is used in the header for all API requests. |
| `client_id`              | The "username"                                   |
| `client_secret`          | The "password". Keep this secret.                |

*Note:* Vipps-Subscription-Key was previously called Ocp-Apim-Subscription-Key. The legacy name Ocp-Apim-Subscription-Key must still be used in request headers.

## Your first Vipps API request

We reccomend getting familiar with the Vipps APIs using Postman. We have a guide, complete with resources for all Vipps APIs available [here](postman-guide.md)

