# Vipps Developers

This repository contains various resources for Vipps developers, including:

* [Getting started](vipps-developer-portal-getting-started.md) with the Vipps Developer Portal
* [How to contribute](contribute.md) to Vipps projects on GitHub
* [How to contact us](contact.md) in the Vipps Integration team

# Vipps repositories on GitHub

To clone [all the Vipps repositories](https://github.com/vippsas), this works for macOS:

1. Install [Homebrew](https://brew.sh), the missing package manager for macOS  
        ```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
        ```
2. Install [jq](https://stedolan.github.io/jq/), a lightweight and flexible command-line JSON processor  
        ```
brew install jq
       ```
3. Run this command  
        ```
curl -s https://api.github.com/orgs/vippsas/repos | jq .[].clone_url | xargs -n 1 git clone
        ```

## Pull all GitHub repos in the current directory

Creating an alias like `gitall` for this command may be useful:

```
find . -type d -depth 1 -exec git --git-dir={}/.git --work-tree=$PWD/{} pull origin master \;
```
# Postman

[Postman](https://www.getpostman.com/) is a common tool for working with REST APIs.
We offer [Postman Collections](https://www.getpostman.com/collection) for some APIs.

With Postman you can make calls to all the API endpoints and see the full
`request` and `response` for each call, including headers.

Postman can import Swagger files directly, so collections is not a requirement.

See the [Postman documentation](https://www.getpostman.com/docs/) for more information about using Postman.

# The Vipps test environment (MT)

The Merchant Test Environment (MT) is available for all Vipps customers.
The environment is suitable for testing _most_ of the Vipps functionality, but some
functionality in the production environment is not available in MT.
In general, MT does not contain functionality that requires integration with
third parties, such as Payment Service Providers, EVRY, Nets, banks, etc.

Functionality not available in MT (a non-exhaustive list):
* Payment of invoices, both for Vipps Regninger and Vipps Faktura
* Push alerts may be unstable
* Limited support for testing card statuses that require connections to Nets, etc
* Limited support for looking up customer information in KAR, etc

To test functionality that is not available in MT, you will have to use the
production environment in a controlled manner. One example may be to test
Vipps Regninger with real invoices, but with small amounts.

### Test users

The welcome email contains information about your test user, which has the following dummy data:

* Name
* Phone number
* PIN
* Bank account number
* Credit card number

You can use this test user to in the test app.

#### Creating additional test users

We aim to offer support for creating your own test user(s) in MT, in steps
similar to this (we do not yet have an ETA on this):

0. Download the test app (see below).
1. Create a valid, dummy NIN (National Identity number, "fødselsnummer"): http://prag.matisk.com/ssn
2. Register in the MT app with your own phone number and your own name
3. You will automatically get an account number and a credit card number
4. One Time Password (OTP) for activation: Use 1234 (or any number)

# Vipps test app

## iOS

![Vipps test app icon](images/vipps-testapp-app-store-icon.jpg)

The iOS test app is available in Apple TestFlight: https://testflight.apple.com/join/hTAYrwea (you do not need an activation code).

The app is identical to the production app, but connects to the
Vipps test environment [The Vipps test environment (MT)](#the-vipps-test-environment-mt) instead of the production environment.

## Android

We aim to offer a test app for Android, and will update this page when it is available.
There is no date for when this will be available. If you need an Android test app,
please [contact us](contact.md).

# Additional developer resources

* Developer overview: https://vipps.no/developer
* High-level overview of the APIs: http://vippsas.github.io
* Products, personal: http://vipps.no/privat
* Products, business: http://vipps.no/bedrift

The Vipps Integration team  
Get in touch: [How to contact us](contact.md)
