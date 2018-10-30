# Vipps Developers

This repository contains various resources for Vipps developers, including:

* [Getting started](vipps-developer-portal-getting-started.md) with the Vipps Developer Portal
* [How to contribute](contribute.md) to Vipps projects on GitHub
* [How to contact us](contact.md) in the Vipps Integration team

# Vipps repositories on GitHub

To clone all the Vipps repos, this works for macOS:

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

# Vipps test app

## iOS

![Vipps test app icon](images/vipps-testapp-app-store-icon.jpg)

The iOS test app is available in Apple TestFlight: https://testflight.apple.com/join/hTAYrwea

The app is identical to the production app, but connects to the Vipps test environment (MT: Merchant Test) instead of the production environment.

### Test users

To get your own test users created in the MT environment, please [contact us](contact.md). We will need the following:

* Phone number, 8 digits (Norwegian numbers only)
* NIN (National Identity Number, fødselsnummer), 11 digits
* First name and last name
* Account number

## Android

We are working on a test app for Android, and will update this page when it is available.

# Additional developer resources

* Developer overview: https://vipps.no/developer
* High-level overview of the APIs: http://vippsas.github.io
* Products, personal: http://vipps.no/privat
* Products, business: http://vipps.no/bedrift

The Vipps Integration team  
Get in touch: [How to contact us](contact.md)
