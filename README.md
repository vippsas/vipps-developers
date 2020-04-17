# Vipps Developers

Version: 2.0.3.

This repository contains various resources for Vipps developers, including:

* [Getting started](vipps-getting-started.md) with Vipps development
* [How to contribute](contribute.md) to Vipps projects on GitHub
* [How to contact us](contact.md) in the Vipps Integration team
* [Requirements](requirements.md) for foreign companies in order to use Vipps
* [Settlements](https://github.com/vippsas/vipps-developers/tree/master/settlements) for information about settlements

## Table of contents

- [API documentation](#api-documentation)
- [Plugins](#plugins)
- [Status page](#status-page)
  * [Status page for the test environment](#status-page-for-the-test-environment)
  * [Status page for the production environment](#status-page-for-the-production-environment)
- [Postman](#postman)
  * [Our Postman collections and environments](#our-postman-collections-and-environments)
- [Example code](#example-code)
- [The Vipps test environment (MT)](#the-vipps-test-environment--mt-)
    + [Test users](#test-users)
    + [Test amounts](#test-amounts)
- [Vipps test apps](#vipps-test-apps)
  * [Test app versions](#test-app-versions)
  * [Limitations of the test apps](#limitations-of-the-test-apps)
  * [iOS](#ios)
  * [Android](#android)
- [Vipps design guidelines](#vipps-design-guidelines)
- [Vipps API servers](#vipps-api-servers)
- [Vipps request servers](#vipps-request-servers)
  * [Production environment](#production-environment)
  * [Disaster recovery (DR) environment](#disaster-recovery--dr--environment)
  * [Test environment](#test-environment)
- [Additional developer resources](#additional-developer-resources)

# API documentation

See: [Getting started](vipps-getting-started.md).

# Plugins

| Platform/solution   | eCommerce         | Recurring      |  Login |
| ------------------- | ------------ | -------------- | ------ |
| Vipps product info  | [Vipps på nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)  | [Faste betalinger](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)  | [Vipps Logg Inn](https://www.vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)  |
| WooCommerce  | [vipps-woocommerce](https://github.com/vippsas/vipps-woocommerce)  | [vipps-recurring-woocommerce](https://github.com/vippsas/vipps-recurring-woocommerce)  | - |
| WordPress  | -  | - |  [vipps-login-wordpress](https://github.com/vippsas/vipps-login-wordpress)  |
| Magento 2  |  [vipps-magento](https://github.com/vippsas/vipps-magento) | - | [vipps-login-magento](https://github.com/vippsas/vipps-login-magento)  |
| Magento 1  |  [vipps-magento-v1](https://github.com/vippsas/vipps-magento-v1) | -  | To be decided. |
| Episerver  |  [vipps-episerver](https://github.com/vippsas/vipps-episerver) | - | Coming soon. |
| Drupal   | [vipps-drupal](https://github.com/vippsas/vipps-drupal)  | Coming soon. | Coming soon. |
| Shopify  | [vipps-shopify](https://github.com/vippsas/vipps-shopify)  | - | - |
| Craft Commerce  | To be decided. | -  | Coming soon. |
| Wix  | To be decided.  | -  | -  |
| BigCommerce  | To be decided.  | -  | -  |

# Status page

## Status page for the test environment

https://vipps-test.statuspage.io

## Status page for the production environment

https://vipps.statuspage.io

# Postman

[Postman](https://www.getpostman.com/) is a common tool for working with REST APIs.
We offer [Postman Collections](https://www.getpostman.com/collection) for some APIs.
Postman can import Swagger files directly, so collections are not a requirement.

With Postman you can make calls to all the API endpoints and see the full
request and response for each call, including headers.

When contacting us about API issues, we are usually able to help faster if you send us
the complete request and response.

See our [Postman guide](https://github.com/vippsas/vipps-developers/blob/master/postman-guide.md) or the
 [Postman documentation](https://www.getpostman.com/docs/) for more information about using Postman.

## Our Postman collections and environments

| Product           | Github Link |
|:------------------|:------------
| eCommerce V2      | [https://github.com/vippsas/vipps-ecom-api/tree/master/tools](https://github.com/vippsas/vipps-ecom-api/tree/master/tools)            |
| Invoice           | [https://github.com/vippsas/vipps-invoice-api/tree/master/tools](https://github.com/vippsas/vipps-invoice-api/tree/master/tools)      |
| Recurring         | [https://github.com/vippsas/vipps-recurring-api/tree/master/tools](https://github.com/vippsas/vipps-recurring-api/tree/master/tools)  |

# Example code

We have made some example code available, in hope that it may be useful:
https://github.com/vippsas/vipps-developers/tree/master/code-examples

# The Vipps test environment (MT)

The Merchant Test Environment (MT) is available for all Vipps customers.

The environment is suitable for testing _most_ of the Vipps functionality, but some
functionality in the production environment is not available in MT.
In general, MT does not contain functionality that requires integration with
third parties, such as Payment Service Providers, EVRY, Nets, banks, etc.

Functionality not available in MT (a non-exhaustive list):
* Push alerts may be unstable
* Payment of invoices, both for Vipps Regninger and Vipps Faktura
* Limited support for testing card statuses that require connections to Nets, etc
* Limited support for looking up customer information in [KAR](https://www.bits.no/en/bank/konto-og-adresseringsregister-kar/), etc

To test functionality that is not available in MT, you will have to use the
production environment in a controlled manner. One example may be to test
Vipps Regninger with real invoices, but with small amounts. We recommend 2 NOK.

Other differences in MT:
* We allow 10,000 incorrect PIN attempts before locking the Vipps user's account

### Test users

The welcome email contains information about your test profile. The test mobile number is registered with everything required to complete a payment.

You can use this test user to in the [Vipps test apps](#vipps-test-apps).

**Important:** Do _not_ use the test phone number in production,
as the test number may be a real phone number for a real Vipps user.

If you need additional payment cards, you can add it in the Vipps app.
See [Credit card numbers](https://github.com/vippsas/vipps-developers/tree/master/testdata#credit-card-numbers)
for more details.

If you have not yet received the welcome email, see the
[standard reply](https://github.com/vippsas/vipps-developers/blob/master/housekeeping/response-apinokler.txt)
(in Norwegian) for requests for this.

There is no way to get a test user in the production environment.
The production environment only contains real users and data.

See also: [Vipps Test Data](https://github.com/vippsas/vipps-developers/blob/master/testdata/README.md).

### Test amounts

Vipps supports using special amounts that are always "rejected in the app", etc -
without anyone needing to use the app. This is useful for testing,
test automation, etc.

| Amount | Error                      |
| ------ | -------------------------- |
| 1.51   | Not sufficient funds       |
| 1.86   | Expired Card               |
| 1.87   | Invalid card               |
| 1.82   | Refused by issuer          |
| 1.83   | Suspected fraud            |
| 1.84   | Withdrawal limit exceeded  |
| 1.97   | 3D Secure denied           |


# Vipps test apps

The test apps for iOS and Android are identical to the production apps, but connects to the
Vipps [the Vipps test environment (MT)](#the-vipps-test-environment-mt) instead of the production environment.

Only test accounts, with random phone numbers, are available in the test environments.
Normal Vipps users are not available, so you can not use your own phone number with the test apps.

## Limitations of the test apps

* Push alerts do not work
* For iOS: There may be conflicts with the production apps, and we recommend to only have one of the apps installed

## iOS

![Vipps test app icon](images/vipps-testapp-app-store-icon.jpg)

The iOS test app is available in Apple TestFlight.
You do *not* need an activation code.

1. Open the [TestFlight](https://testflight.apple.com/join/hTAYrwea) link
2. Install the "Vipps MT" app
3. Open the "Vipps MT" app
4. Enter the test phone number, that was sent in the welcome email to the email address used in the registration. Your normal Vipps user is not available in the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable FaceID (or TouchID) and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the iOS test app connected to the Vipps test environment.

**Please note:** App-switching on iOS uses the same URL pattern for both the
production Vipps app (in App Store) and the MT test app (in TestFlight).
This means that iOS may open either of the apps for a `vipps://` URL, as iOS
can not know which of the apps to open. Because of this, we recommend to
only have one of the apps installed on the same device.

**Important:** Do _not_ use the test phone number in production,
as the test number may be a real phone number for a real Vipps user.

## Android

The Android test app is available in App Center.
You do *not* need an activation code.

1. Open the [App Center](https://install.appcenter.ms/orgs/vipps/apps/vipps-android/distribution_groups/mt%20testers) link. If you get a push message prompting to whitelist the source, you should be able to do this via the "Settings" button.
2. Install the "Vipps Android" app
3. Open the "Vipps Android" app
4. Enter the test phone number, that was sent in the welcome email to the email address used in the registration. Your normal Vipps user is not available in the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable touch id and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the Android test app connected to the Vipps test environment.

**Please note:** Older versions of the test app using a mobile browser for the landing page will not work in the test environment. This is because it will always redirect to the production Vipps app, not the MT test app. If the production Vipps app is not installed, the redirect will open Google Play to download the production Vipps app.

**Important:** Do _not_ use the test phone number in production,
as the test number may be a real phone number for a real Vipps user.

# Vipps design guidelines

Guidelines, logos, buttons, etc: https://github.com/vippsas/vipps-design-guidelines

# Vipps API servers

Test (MT): apitest.vipps.no<br/>
Production: api.vipps.no

**Note:** Vipps may change the IP addresses for the API servers. To ensure
that you are whitelisting the correct IP addresses please use these hostnames
and DNS, and automatically update your firewall rules if there are DNS changes.

# Vipps request servers

Requests made by Vipps are made from the servers specified below.
Vipps normally only uses one server at a time, and change servers approximately every three months.

## Production environment
```
callback-1.vipps.no
callback-2.vipps.no
callback-3.vipps.no
callback-4.vipps.no
```


## Disaster recovery (DR) environment

```
callback-dr-1.vipps.no
callback-dr-2.vipps.no
callback-dr-3.vipps.no
callback-dr-4.vipps.no
```

The disaster recovery environment is as important as the production environment.

## Test environment

```
callback-mt-1.vipps.no
callback-mt-2.vipps.no
callback-mt-3.vipps.no
callback-mt-4.vipps.no
```

For API products where Vipps makes requests to your servers, please make sure that these request servers are allowed through firewalls, etc.

**Note:** Vipps may change the IP addresses for the request servers. To ensure that you are whitelisting the correct IP addresses please use these hostnames and DNS, and automatically update your firewall rules if there are DNS changes.

# Additional developer resources

* Developer overview: https://vipps.no/developer
* High-level overview of the API documentation: https://vipps.no/developer/documentation/
* Products, personal: http://vipps.no/privat
* Products, business: http://vipps.no/bedrift

**The Vipps Integration team**
[Get in touch here](contact.md)
