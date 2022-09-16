<!-- START_METADATA
---
draft: true

---
END_METADATA -->

# Vipps Test Data

Document version 2.0.0.

The [Vipps Test environment (MT)](https://github.com/vippsas/vipps-developers#the-vipps-test-environment-mt) contains synthetic data useful for testing.

## Users

All Vipps customers get a dedicated test user with a unique phone number to use in
[the test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md).
Please use this test user for all development and testing.

## Merchants

All Vipps customers get a dedicated test merchant to use in
[the test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md).
Please use this test merchant for all development and testing.

The common merchants below may be used in situations where the dedicated test merchant,
for some reason, cannot be used.

| Name               | Org. number | Account number |
| ------------------ |------------ | -------------- |
| Vipps Teknologi AS | 918130047   | 15038366383    |
| Merchant test account | -        | 18000000000 |

# Creating more test data

## Credit card numbers

Please use the card details that was provided in the test user account.

## Bank accounts

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

## Faker

The Faker Python library may also be useful: <https://github.com/joke2k/faker>

## DNB Open Banking

DNB Open banking has some useful tools for generating synthetic "Norwegian" data: <https://github.com/DNBbank/dnbtestdata>

The file [fake-people-100k.json](fake-people-100k.json)
contains 100,000 synthetic users in JSON format (took ~30 minutes to create), like this:

```json
{
  "ssn": "07073319586",
  "firstName": "Berit",
  "lastName": "Birkeland",
  "dateOfBirth": "1933-07-07",
  "gender": "Female",
  "nationality": "Norwegian",
  "address": {
    "street": "Sivertsentjernet 55H",
    "postalCode": "2997",
    "city": "Sørensen",
    "country": "NO"
  },
  "phoneNumber": "08 67 82 12",
  "email": "birkeland1933@example.com",
  "idType": "passport"
}
```
