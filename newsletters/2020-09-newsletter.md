# Technical newsletter for developers 2020-09

💥Draft!💥

This newsletter was sent in September 2020.

# Userinfo

# PSP v3

Vipps is launching the [PSP API v3](https://github.com/vippsas/vipps-psp-api) to coincide with our migration of our users cards from PAN to EMVco Network Tokens. This technological migration is Vipps' strategy for achieving delegated SCA once PSD2 comes into force for card payments on January 1 2021.

The PSP API v3 is functionaly identical to PSP API v2 apart from the additional payment source format. There are also minor changes to namings of properties to bring the API in-line with Vipps' API standards.

Encrypted cards will still be sent for our users cards that have not yet been migrated.
Please refer to our migration guide here: [v2-deprecation.md](v2-deprecation.md).

# Rate limiting

Vipps has implemented Rate Limiting on our external apis in order to create a more robust and secure application. Most of these limits are only created to counteract wrongful behaviour and it's nothing you should notice under normal operation. More information about this is available in the doc for [recurring](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#rate-limiting) and [ecom](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#rate-limiting)

# Reminders

We have mentioned some things before, and take this opportunity to remind you:

## API lifecycle

Our API lifecycle policy is
[available on GitHub](https://github.com/vippsas/vipps-developers/blob/master/vipps-api-lifecycle.md).

## Status pages for test and production environments

* Test: https://vipps-test.statuspage.io
* Production: https://vipps.statuspage.io

## How to get help quickly

Please see
[this page](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

## Newsletter archive

Please see: https://github.com/vippsas/vipps-developers/tree/master/newsletters

# Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
