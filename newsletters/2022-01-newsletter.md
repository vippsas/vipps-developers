# Technical newsletter for developers 2022-01

💥 DRAFT! 💥

This newsletter was sent in January 2022.

* [Recurring API: Processing](#recurring-api-processing)
* [Deprecation of the Vipps Signup API](#deprecation-of-the-vipps-signup-api)
* [Reminders](#reminders)
  * [Omikron tips](#omikron-tips)
  * [Vipps Hurtigkasse: Use the explicit flow](#vipps-hurtigkasse-use-the-explicit-flow)
  * [Use the API Dashboard to find problems with your integration](#use-the-api-dashboard-to-find-problems-with-your-integration)
  * [Use Userinfo to register visitors](#use-userinfo-to-register-visitors)
  * ["Click and collect" recommendations](#click-and-collect-recommendations)
* [Newsletter archive](#newsletter-archive)
* [Questions or comments?](#questions-or-comments)

# Recurring API: Processing

We would like to emphasize: Merchants ask Vipps to make charges, and Vipps handles _everything_.

Vipps does not "leak" the customers's information about insufficient funds,
blocked cards, etc. Users are informed about all such problems in Vipps, which
is the only place they can be corrected. The merchant's customer service should
always ask the user to check in Vipps if a charge has failed.

The status of a charge will be `PROCESSING` while we are taking care of business,
from the `due` date until the `retryDays` have passed. After that the status
will be `CHARGED` or `FAILED`.

See:
[Charge states](https://github.com/vippsas/vipps-recurring-api/blob/processing/vipps-recurring-api.md#charge-states).

# Deprecation of the Vipps Signup API

The old API that some partners still use to sign up new merchants will
be phased out. See
[Deprecation of the Vipps Signup API](https://github.com/vippsas/vipps-signup-api/blob/master/vipps-signup-api-deprecation.md)
and
[Vipps Partners](https://github.com/vippsas/vipps-partner).

# Reminders

## Omikron tips

These Vipps solutions are extra relevant (again):

- Use
  [Vipps Logg inn](https://vipps.no/produkter-og-tjenester/privat/logg-inn-med-vipps/logg-inn-med-vipps/)
  and the
  [Vipps Login API](https://github.com/vippsas/vipps-login-api)
  to register visitors - it's free.
- [Use Userinfo to register visitors](#use-userinfo-to-register-visitors)
  as an easy-to-use step in a normal Vipps payment.
- ["Click and collect" recommendations](#-click-and-collect--recommendations)
  to speed up the user experience for your customers.

## Vipps Hurtigkasse: Use the explicit flow

When users are prompted to select shipping address and shipping address, the
explicit flow is _strongly_ recommended. The user then has to actively
select shipping address and shipping method.

The "old" flow does not prompt the user in the same way, and some users
do not notice that they select an incorrect/old/outdated address.

Using the explicit flow is simple: Just specify
`"useExplicitCheckoutFlow": true`
in
[`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/initiatePaymentV3UsingPOST).

See
[Old and new express checkout flow](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#old-and-new-express-checkout-flow)
for more details.

## Use the API Dashboard to find problems with your integration

The API Dashboard is available for both the production and test environments,
and is an easy way to see if you are using the Vipps APIs correctly.
Think of it as a "health check", that you can use to see if there are any
problems you need to investigate.

See it on
[portal.vipps.no](https://portal.vipps.no)
under the "Utvikler" ("Developer") tab.
Here's an example for the Vipps eCom API's `/refund` endpoint:

![API Dashboard example](images/2021-02-api-dashboard-example.png)

## Use Userinfo to register visitors

For guest registration/tracking: Use _Userinfo_ to ask for the user's details, such as:
phone number, name, email address, postal address, birth date, national identity number and bank accounts.
The user must of course consent to sharing the information.

See
[Userinfo for eCom](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo)
and
[Userinfo for Recurring](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#userinfo).

## "Click and collect" recommendations

For "click and collect" we recommend to use
[`staticShippingDetails`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#shipping-and-static-shipping-details)
(to avoid the extra HTTP roundtrip where Vipps asks the merchant
for the shipping options and prices) and also to set the default
shipping method to "Click and collect".

This will significantly speed up the payment process for customers.

This is done in the
[`POST:​/ecomm​/v2​/payments`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/initiatePaymentV3UsingPOST)
call by including:

```
"staticShippingDetails": [
  {
    "isDefault": "Y",
    "priority": 0,
    "shippingCost": 0,
    "shippingMethod": "Click and collect",
    "shippingMethodId": "click-and-collect"
  }
]
```

# Newsletter archive

All the previous newsletters are in the
[newsletter archive](https://github.com/vippsas/vipps-developers/tree/master/newsletters).

# Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
