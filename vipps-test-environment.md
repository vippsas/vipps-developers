# The Vipps Test Environment (MT)

The Merchant Test Environment (MT) is available for all Vipps customers.

## Table of contents

- [About the test environment](#about-the-test-environment)
  * [Limitations of the test environment](#limitations-of-the-test-environment)
- [Test merchants](#test-merchants)
- [Test users](#test-users)
  * [Phone number](#phone-number)
  * [Payment card](#payment-card)
  * [Email address](#email-address)
- [Test amounts](#test-amounts)
- [Vipps test apps](#vipps-test-apps)
  * [Limitations of the test apps](#limitations-of-the-test-apps)
  * [iOS](#ios)
  * [Android](#android)

Document version: 3.1.14.

## About the test environment

All Vipps customers with access to
[Vipps På Nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/),
[Vipps Faste Betalinger](https://www.vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
and
[Vipps Logg Inn](https://www.vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
have access to the test environment. See
[Getting started](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md)
for more information.

**Important:** There is no SLA or uptime guarantee for the test environment.
Vipps will not make any fixes, etc. outside of typical Norwegian office hours.
See
[Statuspage](https://vipps-test.statuspage.io)
for automatically updated status information.

The test environment is suitable for testing _most_ of the Vipps functionality, but some
functionality in the production environment is not available in MT.
In general, MT does not contain functionality that requires integration with
third parties.

### Limitations of the test environment

Functionality not available in MT (a non-exhaustive list):

* Push alerts may be unavailable or unstable. To see payment requests: Open Vipps and manually
  go to the "Betalinger" (in English: "Payments") at the bottom of the main screen.
  The background for this: The app id for the test and production apps are the same, and we
  are not able to distinguish between the apps when sending push messages.
* Payment of invoices, both for Vipps Regninger and Vipps Faktura
* Limited support for testing card statuses that require connections our PSP
* Limited support for looking up customer information in
  [KAR](https://www.bits.no/en/bank/konto-og-adresseringsregister-kar/), etc

To test functionality that is not available in MT, you will have to use the
production environment in a controlled manner. One example may be to test
Vipps Regninger with real invoices, but with small amounts. We recommend 2 NOK.

Other differences between Prod and MT:

* There is no equivalent to [portal.vipps.no](https://portal.vipps.no) for the test environment.
  Payments must be checked with the API, as there is no web interface.
* We allow 10,000 incorrect PIN attempts before locking the Vipps user's account
* There are no settlement reports or SFTP service.

## Test merchants

Sale units in the test environment has access to these APIs:
* [Vipps Access Token API](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#get-an-access-token)
* [Vipps eCom API](https://github.com/vippsas/vipps-ecom-api)
* [Vipps Recurring API](https://github.com/vippsas/vipps-recurring-api)
* [Vipps Login API](https://github.com/vippsas/vipps-login-api)
* [Vipps QR API](https://github.com/vippsas/vipps-qr-api )
* [Vipps Order Management API](https://github.com/vippsas/vipps-order-management-api)

See
[API Products](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#api-products)
for more details.

All Vipps customers can create sale units in the test environment on
[portal.vipps.no](https://portal.vipps.no)
under the "Utvikler" tab: Choose "test keys" and then press
"Add test sale unit".

You can configure the sale unit with "direct capture" or "reserve capture",
"skipLandingPage", etc.

It is not possible to _change_ an existing sale unit in the test environment,
but you can create as many as you need.

**Please note:** Sale units in the _production_ environment must follow strict rules
(regulatory and other), so you may not be able to get the same sale unit configuration
(like "direct capture") there, even though you have it in the test environment.

## Test users

The welcome email that is automatically sent to all new customers contains
information about your test user for the test environment.
Please search your mail, including the spam/junk folder if you do not fint it.

You can use this test user in the [Vipps test apps](#vipps-test-apps).

You may use the same test user on multiple devices.

Test users can are not connected to any merchant, they can be used with any
merchant and sale unit in the test environment.

If you need more than one test user, please
[contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

There is no way to get a test user in the production environment.
The production environment only contains real users and data.

### Phone number

The test user has everything required to complete a payment.
The test user's mobile number works on all phones and on all networks.

**Important:** Do _not_ use the test phone number in the production environment,
as the test number may be a real phone number for a real Vipps user.

### Payment card

The test mobile number is registered with a payment card.

If you need additional payment cards, you can add it in the Vipps app.
See [Credit card numbers](https://github.com/vippsas/vipps-developers/tree/master/testdata#credit-card-numbers)
for more details.

### Email address

You can add a real email address on a test user from the `Profile` -> `Personal information` -> `Email` section in the app.

**Plesae note:** In MT verification of emails can only be triggered in a
Vipps Login flow (if the merchant requests email), or from clicking “send email”
from the email address section under profile-page (after updating the email
address you will need to close and reopen the app for this option to be
available). Just updating the email and storing it will _not_ trigger an email
to be sent for verification. The indication on the profile page that the email
is not verified can be ignored.

### Other data

The test user's name, birth date, etc. are randomly generated when the test user
is created and can not be changed.

## Test amounts

Vipps supports using special amounts that are always rejected when approving the payment in the Vipps test app.  

These test amounts currently **only** works with "reserve capture".

| Amount | Error                     |
|--------|---------------------------|
| 1.51   | Not sufficient funds      |
| 1.86   | Expired Card              |
| 1.87   | Invalid card              |
| 1.82   | Refused by issuer         |
| 1.83   | Suspected fraud           |
| 1.84   | Withdrawal limit exceeded |
| 1.97   | 3D Secure denied          |

**Please note:** The
[force approve](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#testing)
endpoint does not support this functionality.

## Vipps test apps

The test apps for iOS and Android are identical to the production apps, but connect to
[the Vipps test environment (MT)](#the-vipps-test-environment-mt)
instead of the production environment.

The test apps can be installed on the same device as the production apps without conflicts.
The test apps use the `vippsMT://` URL scheme, and the production apps use `vipps://`.

Only test users, with random "fake" phone numbers, are available in the test environments.
Normal Vipps users are not available, so you can not use your own phone number with the test apps.  

**Important:** Do _not_ use the test phone number in the production environment,
as the test number may be a real phone number for a real Vipps user.

**Please note:** It may sometimes be necessary to use specific app versions in MT.
This happens when the production apps and the production environment are not _quite_
in sync with the test environment. When this happens, we update the
[Statuspage for the test environment](https://vipps-test.statuspage.io)
with details.

**Please note:** If you use an emulator, and not the native apps installed on
a phone, you may experience problems - such as having to log in "from scratch"
every time you start Vipps in the emulator.

### Limitations of the test apps

* Push alerts may be unstable. To see payment requests: Open Vipps and manually
  go to "Betalinger" (in English: "Payments") at the bottom of the main screen.

### iOS

The iOS test app is available in Apple TestFlight.
You do *not* need an invitation or an activation code.

1. Open the
   [TestFlight](https://testflight.apple.com/join/hTAYrwea)
   link on your iOS phone (it will not work on macOS)
2. Install the "Vipps MT" app
3. Open the "Vipps MT" app
4. Enter the test phone number, that was sent in the welcome email to the email
   address used in the registration. Your normal Vipps user is not available in
   the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable FaceID (or TouchID) and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the iOS test app connected to the Vipps test environment.

### Android

The Android test app is available in App Center.
You do *not* need an invitation or an activation code.

1. Open the
   [App Center](https://install.appcenter.ms/orgs/vipps/apps/vipps-android/distribution_groups/mt%20testers)
   link on your Android phone (it will nok work on a PC/Mac). If you get a push
   message prompting to whitelist the source, you should be able to do this via
   the "Settings" button.
2. Install the "Vipps Android" app
3. Open the "Vipps Android" app
4. Enter the test phone number, that was sent in the welcome email to the email
   address used in the registration. Your normal Vipps user is not available in
   the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable touch id and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the Android test app connected to the Vipps test environment.

# Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
