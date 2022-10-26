<!-- START_METADATA
---
title: User info
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# User information

Vipps offers the possibility for merchants to ask for the user's profile information as part of the payment flow.
This is done through Vipps Userinfo which follows
the [OIDC Standard](https://openid.net/specs/openid-connect-core-1_0.html#UserInfo).

To enable the possibility to fetch profile information for a user, the merchant can add a `scope`
parameter to the initiate call:
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST).

If the end user has not already consented to sharing information from Vipps to the
merchant, they will be asked for any remaining consents before completing the payment flow.
Once the payment flow is completed, the merchant can get the profile
information from our Userinfo endpoint.

A user's consent to share information with a merchant applies across our services. Thus, if the merchant implements Vipps Login as part of the payment flow,
in addition to profile information, they can also use Vipps to log the user in without the need for additional consents.

Example of the userInfo flow:

![User info flow](images/userinfo-flow.png)

## Scope

Scope is the type of information you want access to. This can include any of the following values, separated by a space.

| Scope            | Description | User consent required |
|:-----------------|:------------|:----------------------|
| `address`        | A list containing the user's addresses. The list always contains the home address from the National Population Register and can also include work address and other addresses added by the user in Vipps. | yes |
| `birthDate`      | Birth date. Verified with BankID. | yes |
| `email`          | Email address. The flag `email_verified : true` (or `false`) in the response indicates whether the email address is verified. | yes |
| `name`           | First, middle and given name. Verified with the National Population Register. | yes |
| `phoneNumber`    | Phone number. Verified when creating the Vipps account. | yes |
| `nin`            | Norwegian national identity number. Verified with BankID. **NB:** Merchants need to apply for access to NIN. See: [Who can get access to NIN and how?](/docs/APIs/login-api/vipps-login-api-faq.md#who-can-get-access-to-nin-and-how)    | yes |
| `accountNumbers` | User bank account numbers. **NB:** Merchants need to apply for access to accountNumbers. See: [Who can get access to account numbers and how?](/docs/APIs/login-api/vipps-login-api-faq.md#who-can-get-access-to-accountnumbers-and-how) | yes |

See the API specification for the formats and other details for each scope.

**Please note:** If the e-mail address that is delivered has the flag `email_verified : false`,
this address should not be used to link the user to an existing account without
further authentication. Such authentication could be to prompt the user to
log in to the original account or to confirm the account linking by providing a
confirmation link sent to the email address.

## Userinfo call-by-call guide

Scenario: You want to complete a payment and get the name and phone number of
a customer. Details about each step are described in the sections below.

1. Retrieve the access token:
   [`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost).
2. Add scope to the transaction object and include the scope you wish to get
   access to (valid scope) before calling
   [`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/initiatePaymentV3UsingPOST)
   Include the scopes you need access to (e.g., "name address email phoneNumber birthDate"), separated by spaces.
3. The user consents to the information sharing and perform the payment in Vipps.
4. Retrieve the `sub` by calling
   [`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET)
5. Using the sub from step 4, call
   [`GET:/vipps-userinfo-api/userinfo/{sub}`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-Userinfo-API/operation/getUserinfo)
   to retrieve the user's information.
   Do not include the ``Ocp-Apim-Subscription-Key`` header. See more information under [Userinfo call](#userinfo-call).


**Please note:** The `sub` is added asynchronously, so if the `/details` request
is made within (milli)seconds of the payment approval in the app, it may not be
available. If that happens, simply make another `/details` request.
See
[Polling guidelines](#polling-guidelines)
for more recommendations.

**Important note:** The API call to
[`GET:/vipps-userinfo-api/userinfo/{sub}`](https://vippsas.github.io/vipps-recurring-api/#/Userinfo%20Endpoint/getUserinfo)
must *not* include the subscription key (the `Ocp-Apim-Subscription-Key` header) used for the eCom API.
This is because userinfo is part of Vipps Login and is therefore *not* under the same subscription,
and will result in a `HTTP Unauthorized 401` error.

## Get userinfo

Once the user completes the session, a unique identifier `sub` can be retrieved from the
[`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/getPaymentDetailsUsingGET) endpoint.

Example `sub` format:

```json
"sub": "c06c4afe-d9e1-4c5d-939a-177d752a0944",
```

This `sub` is a link between the merchant and the user and can be used to retrieve
the user's details from Vipps userinfo:
[`GET:/vipps-userinfo-api/userinfo/{sub}`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-Userinfo-API/operation/getUserinfo)

The `sub` is based on the user's national identity number ("fødselsnummer"
in Norway), and does not change (except in very special cases).

**Please note:** It is recommended to get the user's information directly after
completing the transaction. There is a *time limit of 168 hours*
(one week) to retrieve the consented profile data from the `/userinfo` endpoint. This is to
better support merchants that depend on manual steps/checks in their process of
fetching the profile data. The merchant will get the information that is in the
user profile at the time when they actually fetch the information. This means
that the information might have changed from the time the user completed the
transaction and the fetching of the profile data.

## Userinfo call

This endpoint returns the payload with the information that the user has consented to share.

Call [`GET:/vipps-userinfo-api/userinfo/{sub}`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-Userinfo-API/operation/getUserinfo)
with the `sub` that was retrieved earlier. See below on how to construct the call.

### Request

#### Headers

| Header        | Description             |
|:--------------|:------------------------|
| Authorization | "Bearer {Access Token}" |

The access token is received on a successful request to the token endpoint described in [Authentication](#authentication).

**Important note:** `OCP-APIM-Subscription-Key` used for the eCom API must *not* be included. This is because userinfo is part of
Vipps Login and is therefore *not* under the same subscription, and will result in a `HTTP Unauthorized 401` error.

**Example response from a successful call:**

```json
{
  "sub": "c06c4afe-d9e1-4c5d-939a-177d752a0944",
  "birthdate": "1815-12-10",
  "email": "user@example.com",
  "email_verified": true,
  "nin": "10121550047",
  "name": "Ada Lovelace",
  "given_name": "Ada",
  "family_name": "Lovelace",
  "sid": "7d78a726-af92-499e-b857-de263ef9a969",
  "phone_number": "4712345678",
  "address": {
    "street_address": "Suburbia 23",
    "postal_code": "2101",
    "region": "OSLO",
    "country": "NO",
    "formatted": "Suburbia 23\\n2101 OSLO\\nNO",
    "address_type": "home"
  },
  "other_addresses": [
    {
      "street_address": "Fancy Office Street 2",
      "postal_code": "0218",
      "region": "OSLO",
      "country": "NO",
      "formatted": "Fancy Office Street 2\\n0218 OSLO\\nNO",
      "address_type": "work"
    },
    {
      "street_address": "Summer House Lane 14",
      "postal_code": "1452",
      "region": "OSLO",
      "country": "NO",
      "formatted": "Summer House Lane 14\\n1452 OSLO\\nNO",
      "address_type": "other"
    }
  ],
  "accounts": [
    {
      "account_name": "My savings",
      "account_number": "12064590675",
      "bank_name": "My bank"
    }
  ]
}
```

Userinfo sequence:

![Userinfo sequence](images/userinfo-direct.png)

## Consent

A user's consent to share information with a merchant applies across all Vipps
services. Thus, if the merchant implements Vipps Login as part of the payment flow,
in addition to profile information, they can also use Vipps to
log the user in without the need for additional consent.

The user is presented with a consent card that must be accepted before
approving the payment in Vipps. The following screenshots show examples
of consent cards for Android(left) and iOS(right):

![Consent card](images/share-user-info.png)

**Please note:** This operation has an "all or nothing" approach, so a user must
complete a valid payment and consent to *all* values in order to complete the
session. If a user chooses to reject the terms, the payment will not be
processed. Unless the whole flow is completed, this will be handled as a
failed payment by the eCom API.