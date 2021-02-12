# The Vipps Test Environment (MT)

Document version: 2.0.3.

The Merchant Test Environment (MT) is available for all Vipps customers.

The environment is suitable for testing _most_ of the Vipps functionality, but some
functionality in the production environment is not available in MT.
In general, MT does not contain functionality that requires integration with
third parties, such as Payment Service Providers, EVRY, Nets, banks, etc.

Functionality not available in MT (a non-exhaustive list):
* Push alerts may be unstable. To see payment requests: Open Vipps and manually go to the "Betalinger" (in English: "Send") page.
* Payment of invoices, both for Vipps Regninger and Vipps Faktura
* Limited support for testing card statuses that require connections to Nets, etc
* Limited support for looking up customer information in [KAR](https://www.bits.no/en/bank/konto-og-adresseringsregister-kar/), etc

To test functionality that is not available in MT, you will have to use the
production environment in a controlled manner. One example may be to test
Vipps Regninger with real invoices, but with small amounts. We recommend 2 NOK.

Other differences in MT:
* There is no equivalent to [portal.vipps.no](https://portal.vipps.no) for the test environment.
  Payments must be checked with the API, as there is no web interface.
* We allow 10,000 incorrect PIN attempts before locking the Vipps user's account

## Test users

The welcome email contains information about your test profile.
You can use this test user to in the [Vipps test apps](#vipps-test-apps).

If you have not yet received the welcome email, see the
[standard reply](https://github.com/vippsas/vipps-developers/blob/master/housekeeping/response-apinokler.txt)
(in Norwegian) for requests about this.

There is no way to get a test user in the production environment.
The production environment only contains real users and data.

### Phone number

The test mobile number is registered with everything required to complete a payment.
You may use the test user on multiple devices.
The test mobile number works on all phones and on all networks.

**Important:** Do _not_ use the test phone number in the production environment,
as the test number may be a real phone number for a real Vipps user.

### Payment card

The test mobile number is registered with a payment card.

If you need additional payment cards, you can add it in the Vipps app.
See [Credit card numbers](https://github.com/vippsas/vipps-developers/tree/master/testdata#credit-card-numbers)
for more details.

### Bank accounts

The test mobile number is registered with a bank account.

If you need additional bank accounts, you can add it in the Vipps app.

Fake bank account numbers can be generated with
[Faker](https://github.com/joke2k/faker):
`faker -l no_NO bban`

**Important:** Bank accounts in the test environment must start with the a
valid Norwegian "bankplass" series. Recommended series:
* DNB = 1201, 1207, 1208, 1542
* Sparebank = 2601, 4605, 4609, 4658, 4730
* Nordea = 8841, 9406, 6509, 6446
* Sbanken = 9710, 9712, 9729, 9810
* Handelsbanken = 9499, 9049, 9688
* Danske Bank = 8606, 9760, 9747, 9065

Please note that the chance that a random number works for payments
in the test environment is practically zero.

### Test data

See: [Vipps Test Data](https://github.com/vippsas/vipps-developers/blob/master/testdata/README.md).

## Test amounts

Vipps supports using special amounts that are always rejected when approving the payment in the Vipps test app.

| Amount | Error                     |
|--------|---------------------------|
| 1.51   | Not sufficient funds      |
| 1.86   | Expired Card              |
| 1.87   | Invalid card              |
| 1.82   | Refused by issuer         |
| 1.83   | Suspected fraud           |
| 1.84   | Withdrawal limit exceeded |
| 1.97   | 3D Secure denied          |

**Please note:** The "force approve" endpoint is not validated for this functionality and will result in different behaviour.

## Vipps test apps

The test apps for iOS and Android are identical to the production apps, but connects to the
Vipps [the Vipps test environment (MT)](#the-vipps-test-environment-mt) instead of the production environment.

Only test accounts, with random "fake" phone numbers, are available in the test environments.
Normal Vipps users are not available, so you can not use your own phone number with the test apps.  

**Important:** Do _not_ use the test phone number in the production environment,
as the test number may be a real phone number for a real Vipps user.

**Please note:** It may sometimes be necessary to use specific app versions in MT.
This happens when the production apps and the production environment are not _quite_
in sync with the test environment. When this happens, we update the
[Stastuspage for the test environment](https://vipps-test.statuspage.io)
with details.

### Limitations of the test apps

* Push alerts may be unstable. To see payment requests: Open Vipps and manually go to the "Betalinger" (in English: "Send") page.

### iOS

![Vipps test app icon](images/vipps-testapp-app-store-icon.jpg)

The iOS test app is available in Apple TestFlight.
You do *not* need an invitation or an activation code.

1. Open the [TestFlight](https://testflight.apple.com/join/hTAYrwea) link on your iOS phone (it will not work on macOS)
2. Install the "Vipps MT" app
3. Open the "Vipps MT" app
4. Enter the test phone number, that was sent in the welcome email to the email address used in the registration. Your normal Vipps user is not available in the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable FaceID (or TouchID) and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the iOS test app connected to the Vipps test environment.

### Android

The Android test app is available in App Center.
You do *not* need an invitation or an activation code.

1. Open the [App Center](https://install.appcenter.ms/orgs/vipps/apps/vipps-android/distribution_groups/mt%20testers) link on your Android phone (it will nok work on a PC/Mac). If you get a push message prompting to whitelist the source, you should be able to do this via the "Settings" button.
2. Install the "Vipps Android" app
3. Open the "Vipps Android" app
4. Enter the test phone number, that was sent in the welcome email to the email address used in the registration. Your normal Vipps user is not available in the test environment.
5. On the "Verify your number" screen: Use PIN  `1236`.
6. On the "Enter your code" screen: Use PIN `1236`.
7. Enable touch id and confirm with PIN  `1236`.
8. Accept push notifications.

You are now ready to use the Android test app connected to the Vipps test environment.
