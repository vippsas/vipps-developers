# Vipps Test Data

Document version 1.0.0.

The [Vipps Test environment (MT)](https://github.com/vippsas/vipps-developers#the-vipps-test-environment-mt) contains synthetic data useful for testing.

## Users

All Vipps customers get a dedicated test user with a unique phone number to use in 
[the test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md).
Please use this test user for all development and testing.

The common test user below may be used in situations where the dedicated test user, 
for some reason, can not be used.

| customerId | NIN (fødselsnummer) | MSISDN (phone number) | First name   | Last name |
| ---------- | ------------------- | --------------------- | ------------ | --------- |
| 10003301	 | 01032300371         | 4797777776            | Willhelm Fos | Kluvstad  |

## Merchants

All Vipps customers get a dedicated test merchant to use in 
[the test environment](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md).
Please use this test merchant for all development and testing.

The common merchants below may be used in situations where the dedicated test merchant, 
for some reason, can not be used.

| Name               | Org. number | Account number |
| ------------------ |------------ | -------------- |
| Vipps Teknologi AS | 918130047   | 15038366383    |
| Merchant test account | -        | 18000000000 |

# Creating more test data

## Credit card numbers

Nets offers a series of credit cards with pre-defined characteristics: https://shop.nets.eu/web/partners/test-cards
Response codes: https://shop.nets.eu/web/partners/response-codes

BIN Codes: Credit Card & Debit Card Number Tools: https://www.bincodes.com/bin-creditcard-generator/

## Faker

The Faker Python library may also be useful: https://github.com/joke2k/faker

## DNB Open Banking

DNB Open banking has some useful tools for generating synthetic "Norwegian" data: https://github.com/DNBbank/dnbtestdata

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
