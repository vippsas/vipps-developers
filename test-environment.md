---
title: The Vipps and MobilePay test environment
sidebar_label: Test environment
sidebar_position: 20
pagination_next: null
pagination_prev: null
---

# Test environment

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/vipps-developers/test-environment/).
<!-- END_COMMENT -->

The Merchant Test (MT) environment is available for all merchants who have
access to the Vipps MobilePay APIs.

## About the test environment

All customers with access to the APIs have access to the test environment.

**Important:** There is no SLA or uptime guarantee for the test environment.
We will not make any fixes, etc. outside typical Norwegian office hours.
See the
[Status page](./developer-resources/status-pages.md)
for automatically updated status information.

The test environment is suitable for testing *most* of the API functionality, but some
functionality in the production environment is not available in MT.
In general, MT does not contain functionality that requires integration with
third parties.

The test and production environments are completely separate and use different
[API keys](common-topics/api-keys.md).

### Limitations of the test environment

Functionality that is not available in the test environment, a non-exhaustive list:

1. Unscheduled maintenance *may* occur.
   We will do our best to inform with
   [Status page](./developer-resources/status-pages.md),
1. For now, the test app has the orange Vipps color scheme, and not the blue MobilePay color scheme.
   This will be fixed, but there is no estimated time of arrival (ETA).
1. Only Norwegian phone numbers are supported (this will be fixed, but there is no ETA).
1. All test merchants appear as Norwegian merchants in the app (this will be fixed, but there is no ETA).
1. Currency: Limited support, please test with NOK (this will be fixed, but there is no ETA).
1. Push alerts may be unavailable or unstable. To see payment requests:
   Click the "Payments" button at the bottom, and then "pull to refresh" on the Payments screen.
1. Email verification has some quirks, see [Email address](#email-address).
1. Partner functionality, like the relationship between an MSN and a partner,
   and the use of
   [partner keys](https://developer.vippsmobilepay.com/docs/vipps-partner/partner-keys),
   does not work as in the production environment. In general, partner
   functionality is not available. See
   [Partners](https://developer.vippsmobilepay.com/docs/vipps-partner).
1. There is no equivalent to [portal.vipps.no](https://portal.vipps.no) for the
   test environment. Payments must be checked with the API.
1. There are no settlements in the test environment, and therefore
   no settlement reports, not SFTP service and no Report API.
   The only way to test the complete settlement flow is in the production environment.
1. The user's email address can not be verified in the normal way.
   See: [Email address](#email-address).
1. [Freestanding card payments](https://developer.vippsmobilepay.com/docs/APIs/epayment-api/features/free-standing-card-payments/)
   are not available.
1. Payment of invoices is unavailable.
1. We allow 10,000 incorrect PIN attempts before locking the Vipps user's account.

To test functionality that is not available in MT, you will have to use the
production environment in a controlled manner, using a real user and a real merchant.

## Access to the test environment

### Merchants

All merchants with API access have access to the Vipps test environment.

A test sales unit is automatically created when the merchant submits an order
for a Vipps product (that has an API), and the details can be found on the
"Utvikler" (developer) section on
[portal.vipps.no](https://portal.vipps.no).

See:

* [Common topics: Getting the API keys](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/api-keys#getting-the-api-keys)
* [How to create a test sales unit](https://developer.vippsmobilepay.com/docs/vipps-developers/developer-resources/portal#how-to-create-a-test-sales-unit)

### Partners

Partners can get access to the test environment by ordering
"Vipps Logg inn" (the
[Vipps Login API](https://developer.vippsmobilepay.com/docs/APIs/login-api)).

See:
[How to get access to portal.vipps.no](https://developer.vippsmobilepay.com/docs/vipps-partner#how-to-get-access-to-portalvippsno).

## Test server

The test and production environments are separate and require different API credentials:

| Production (Prod) | Test (MT)        |
|-------------------|------------------|
| api.vipps.no      | apitest.vipps.no |

The servers are accessible around the world. Vipps only relies on the API keys, and
no requests to our servers are blocked on our side by IP addresses or similar.

See [Vipps servers](./developer-resources/servers.md) for more information.

## Test merchants

The test environment and production environments are completely separate.
You will, therefore, need to use a different set of API keys for the test environment.

Test merchants have access to all the common APIs on the
[Vipps MobilePay API platform](https://developer.vippsmobilepay.com/docs/APIs).

All Vipps customers can create as many sales units ("merchants") as they need
in the test environment. Sale units in the test environment can not be changed.

See:
[Developer resources: Vipps portal: How to create a test sales unit](./developer-resources/portal.md#how-to-create-a-test-sales-unit).

**Please note:** Sales units in the *production* environment must follow strict
rules (regulatory and other), so you may not be able to get the same sales unit
configuration there, even though you have it in the test environment.

## Test users

A welcome email is automatically sent to **all** new customers. This email
contains information about your test user.
Please search your mail, including the spam/junk folder, if you do not find it.

**Please note:**

* The provided test user must only be used in the [Vipps test apps](#vipps-test-apps).
* You must *log in* (not register) as the test user in the test app, before you
  can complete payments or logins as that user.
* You may use the same test user on multiple devices.
* Test users are not connected to any merchant, they can be used with any
  merchant and sales unit in the test environment.
* We can not create test users with specific attributes (phone number, name, numbers, age, etc.).

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

**Important:** Do *not* use the test phone number in the production environment,
as the test number may be a real phone number for a real Vipps user.

You will get your test phone number in the welcome email. If you did not receive this,
contact your partner contact (if you have one) or
[customer service](https://vipps.no/kontakt-oss/).

### Payment card

The test user is registered with a payment card, and it is not possible to add
new cards in the test app.

### Email address

You can add a real email address on a test user from the
*Profile* -> *Personal information* -> *Email*
section in the app.

**Please note:** In the test environment verification of emails can only be triggered in a
[Vipps Login](https://developer.vippsmobilepay.com/docs/APIs/login-api)
flow (if the merchant requests the `email` scope), or from clicking “send email”
from the email address section under profile page. After updating the email
address you will need to close and reopen the app for this option to be
available. 

Just updating the email and saving it will *not* trigger an email
to be sent for verification. The indication on the profile page that the email
is not verified can be ignored.

### Other data

The test user's name, birthdate, etc. are randomly generated when the test user
is created and cannot be changed.

## Test amounts

Vipps supports using special amounts in the Vipps test app.
Use these amounts to always get the same result.

| Amount | Error                     |
|--------|---------------------------|
| 1.51   | Insufficient funds        |
| 1.82   | Refused by issuer         |
| 1.83   | Suspected fraud           |
| 1.84   | Withdrawal limit exceeded |
| 1.86   | Expired Card              |
| 1.87   | Invalid card              |
| 1.97   | 3D Secure denied          |
| 2.01   | Unknown result for 1 hour |
| 2.02   | SCA required              |

**Please note:** The
[force approve](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#testing)
endpoint does not support this functionality.

## Vipps test apps

The test apps for iOS and Android are identical to the production apps, but connect to
the Vipps test environment (MT) instead of the production environment.

The test apps can be installed on the same device as the production apps without conflicts.
The test apps use the `vippsMT://` URL scheme, and the production apps use `vipps://`.

Only test users, with random "fake" phone numbers, are available in the test environment.
Normal (real) users are not available, so you cannot use your own phone number with the test apps.  

**Important:** Do *not* use the test phone number in the production environment,
as the test number may be a real phone number for a real Vipps user.

### Install Vipps MT on iOS

The iOS test app is available for everyone in Apple TestFlight.
You do *not* need an invitation or an activation code.

**Please note:** You only need to *log in* with your test user, not register.

1. Open the
   [TestFlight](https://testflight.apple.com/join/hTAYrwea)
   link on your iOS phone (it will not work on macOS, and you cannot search for Vipps in TestFlight)
2. Install the "Vipps MT" app
3. Open the "Vipps MT" app
4. Enter the test phone number, that was sent in the welcome email to the email
   address used in the registration  (please double-check before asking for
   a new test phone number).
   Your normal Vipps user is not available in the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable Face ID (or Touch ID) and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the iOS test app connected to the Vipps test environment.

### Install Vipps MT on Android

The Android test app is available for everyone in App Center.
You do *not* need an invitation or an activation code.

**Please note:** You only need to *log in* with your test user, not register.

1. Open the
   [App Center](https://install.appcenter.ms/orgs/vipps/apps/vipps-android/distribution_groups/mt-testers)
   link on your Android phone (it will not work on a PC/Mac). If you get a push
   message prompting to whitelist the source, you should be able to do this via
   the "Settings" button.
2. Install the "Vipps Android" app
3. Open the "Vipps Android" app
4. Enter the test phone number, that was sent in the welcome email to the email
   address used in the registration  (please double-check before asking for
   a new test phone number).
   Your normal Vipps user is not available in the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable touch ID and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the Android test app connected to the Vipps test environment.

### Other versions of the test app

It may sometimes be necessary to use specific app versions in MT.
This happens when the production apps and the production environment are not *quite_
in sync with the test environment. When this happens, we update the
[Status page](./developer-resources/status-pages.md)
for the test environment with details.

### Using an emulator

If you use an app emulator, and not the native apps installed on
a real phone, you may experience problems - including having to log in "from scratch"
every time you start Vipps in the emulator.
