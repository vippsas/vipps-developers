<!-- START_METADATA
---
title: Test environment
sidebar_position: 4
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# The Vipps Test Environment (MT)

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

The Merchant Test Environment (MT) is available for all Vipps merchants
with API access.

<!-- START_TOC -->

## Table of contents

- [About the test environment](#about-the-test-environment)
  - [Limitations of the test environment](#limitations-of-the-test-environment)
- [Test server](#test-server)
- [Test merchants](#test-merchants)
- [Test users](#test-users)
  - [Phone number](#phone-number)
  - [Payment card](#payment-card)
  - [Email address](#email-address)
  - [Other data](#other-data)
- [Test amounts](#test-amounts)
- [Vipps test apps](#vipps-test-apps)
  - [Install Vipps MT on iOS](#install-vipps-mt-on-ios)
  - [Install Vipps MT on Android](#install-vipps-mt-on-android)
  - [Other versions](#other-versions)
  - [Limitations of the test apps](#limitations-of-the-test-apps)
- [Questions?](#questions)

<!-- END_TOC -->

Document version: 3.3.1.


Quick link:

* [Vipps test apps](#vipps-test-apps)

## About the test environment

All Vipps customers with access to
[Vipps På Nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/),
[Vipps Faste Betalinger](https://www.vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/)
and
[Vipps Logg Inn](https://www.vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
have access to the test environment.

**Important:** There is no SLA or uptime guarantee for the test environment.
Vipps will not make any fixes, etc. outside of typical Norwegian office hours.
See the
[Status page](https://vipps-test.statuspage.io)
for automatically updated status information.

The test environment is suitable for testing _most_ of the Vipps functionality, but some
functionality in the production environment is not available in MT.
In general, MT does not contain functionality that requires integration with
third parties.

The test and production environments are completely separate and use different
[API keys](common-topics/api-keys.md).

**Please note:** For production, Vipps only offers
[Direct capture](common-topics/reserve-and-capture.md#direct-capture)
for merchants that use Vipps through a partner.
In the test environment, you can do this by creating a sale unit where direct capture is allowed.

### Limitations of the test environment

Functionality not available in MT (a non-exhaustive list):

- Unscheduled maintenance _may_ occur.
  We will do our best to inform with
  [Status page](./developer-resources/status-pages.md),
  but it may no always be possible.
  In practice this is extremely rare.
- Push alerts may be unavailable or unstable. To see payment requests: Open Vipps and manually
  go to the "Betalinger" (i.e., *Payments*) at the bottom of the main screen.
  The background for this: The app id for the test and production apps are the same, and we
  are not able to distinguish between the apps when sending push messages.
- Payment of invoices, both for _Vipps Regninger_ and _Vipps Faktura_
- Limited support for testing card statuses that require connections our PSP
- Limited support for looking up customer information in
  [KAR](https://www.bits.no/en/bank/konto-og-adresseringsregister-kar/), etc
- Some quirks around email verification, see [Email address](#email-address).  

To test functionality that is not available in MT, you will have to use the
production environment in a controlled manner. One example may be to test
_Vipps Regninger_ with real invoices, but with small amounts. We recommend 2 NOK.

Other differences between Production and MT:

- There is no equivalent to [portal.vipps.no](https://portal.vipps.no) for the test environment.
  Payments must be checked with the API, as there is no web interface.
- We allow 10,000 incorrect PIN attempts before locking the Vipps user's account
- There are no settlement reports and no SFTP service.

## Test server

The test and production environments are separate and require different API credentials:

| Production (Prod) | Test (MT)        |
|-------------------|------------------|
| api.vipps.no      | apitest.vipps.no |

The servers are world-accessible. Vipps only relies on the API keys, and
no requests to our servers are blocked on our side by IP addresses or similar.

See [Vipps servers](./developer-resources/servers.md) for more information.

## Test merchants

The test environment and production environments are completely separate.
You will, therefore, need to use a different set of API keys for the test environment.

All Vipps customers can create sales units ("merchants") in the test environment.

See:

- [Developer resources: Vipps portal: How to create a test sales unit](./developer-resources/portal.md#how-to-create-a-test-sales-unit).

**Please note:** Sale units in the _production_ environment must follow strict rules
(regulatory and other), so you may not be able to get the same sale unit configuration
(like "direct capture") there, even though you have it in the test environment.

## Test users

A welcome email is automatically sent to **all** new customers. This email
contains information about your test user.
The subject should contain "Kom i gang med Vipps".
Please search your mail, including the spam/junk folder, if you do not find it.

**Please note:**

* The provided test user can be used in the [Vipps test apps](#vipps-test-apps).
* You must log in with the test user in the test app, before you can complete
  payments for that user.
* You may use the same test user on multiple devices.
* Test users are not connected to any merchant, they can be used with any
  merchant and sale unit in the test environment.

If you need more than one test user, please contact your
Key Account Manager (if you have one),
your partner contact (if you have one),
or contact
[customer service](https://vipps.no/kontakt-oss/).

There is no way to get a test user in the production environment.
The production environment only contains real users and data.

### Phone number

The test user has everything required to complete a payment.
The test user's mobile number works on all phones and on all networks.

**Important:** Do _not_ use the test phone number in the production environment,
as the test number may be a real phone number for a real Vipps user.

### Payment card

The test user is registered with one payment card.

If you need additional payment cards, you can add it in the Vipps app.

### Email address

You can add a real email address on a test user from the *Profile* -> *Personal information* -> *Email* section in the app.

**Please note:** In MT verification of emails can only be triggered in a
Vipps Login flow (if the merchant requests email), or from clicking “send email”
from the email address section under profile-page (after updating the email
address you will need to close and reopen the app for this option to be
available). Just updating the email and storing it will _not_ trigger an email
to be sent for verification. The indication on the profile page that the email
is not verified can be ignored.

### Other data

The test user's name, birth date, etc. are randomly generated when the test user
is created and cannot be changed.

## Test amounts

Vipps supports using special amounts in the Vipps test app.
Use these amounts to always get the same result.

| Amount | Error                     |
|--------|---------------------------|
| 1.51   | Not sufficient funds      |
| 1.82   | Refused by issuer         |
| 1.83   | Suspected fraud           |
| 1.84   | Withdrawal limit exceeded |
| 1.86   | Expired Card              |
| 1.87   | Invalid card              |
| 1.97   | 3D Secure denied          |
| 2.01   | Unknown result for 1 hour |
| 2.02   | SCA required              |

**Please note:** The
[force approve](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api#testing)
endpoint does not support this functionality.

## Vipps test apps

The test apps for iOS and Android are identical to the production apps, but connect to
the Vipps test environment (MT) instead of the production environment.

The test apps can be installed on the same device as the production apps without conflicts.
The test apps use the `vippsMT://` URL scheme, and the production apps use `vipps://`.
See installation instructions below.

Only test users, with random "fake" phone numbers, are available in the test environment.
Normal Vipps users are not available, so you cannot use your own phone number with the test apps.  

**Important:** Do _not_ use the test phone number in the production environment,
as the test number may be a real phone number for a real Vipps user.

### Install Vipps MT on iOS

The iOS test app is available for everyone in Apple TestFlight.
You do _not_ need an invitation or an activation code.

1. Open the
   [TestFlight](https://testflight.apple.com/join/hTAYrwea)
   link on your iOS phone (it will not work on macOS, and you cannot search for Vipps in TestFlight)
2. Install the "Vipps MT" app
3. Open the "Vipps MT" app
4. Enter the test phone number, that was sent in the welcome email to the email
   address used in the registration  (please double check before asking for
   a new test phone number).
   Your normal Vipps user is not available in the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable FaceID (or TouchID) and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the iOS test app connected to the Vipps test environment.

### Install Vipps MT on Android

The Android test app is available for everyone in App Center.
You do _not_ need an invitation or an activation code.

1. Open the
   [App Center](https://install.appcenter.ms/orgs/vipps/apps/vipps-android/distribution_groups/mt%20testers)
   link on your Android phone (it will not work on a PC/Mac). If you get a push
   message prompting to whitelist the source, you should be able to do this via
   the "Settings" button.
2. Install the "Vipps Android" app
3. Open the "Vipps Android" app
4. Enter the test phone number, that was sent in the welcome email to the email
   address used in the registration  (please double check before asking for
   a new test phone number).
   Your normal Vipps user is not available in the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable touch id and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the Android test app connected to the Vipps test environment.

### Other versions

It may sometimes be necessary to use specific app versions in MT.
This happens when the production apps and the production environment are not _quite_
in sync with the test environment. When this happens, we update the
[Status page for the test environment](https://vipps-test.statuspage.io)
with details.

If you use an emulator, and not the native apps installed on
a phone, you may experience problems - including having to log in "from scratch"
every time you start Vipps in the emulator.

### Limitations of the test apps

- Push alerts may be unstable. To see payment requests: Open Vipps and manually
  go to "Betalinger" (i.e., _Payments_) at the bottom of the main screen.
  You may also need to pull down to refresh.

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).

Sign up for our [Technical newsletter for developers](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters).
