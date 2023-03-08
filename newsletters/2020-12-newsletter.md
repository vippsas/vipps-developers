<!-- START_METADATA
---
title: Technical newsletter for developers 2020-12
sidebar_label: 2020-12
sidebar_position: 76
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Technical newsletter for developers 2020-12

This newsletter was sent in December 2020.

<!-- START_COMMENT -->

## Table of Contents

- [The Vipps eCom API v1 is disabled](#the-vipps-ecom-api-v1-is-disabled)
- [Vipps Login improvements](#vipps-login-improvements-)
- [Vipps HTTP Headers](#vipps-http-headers-ℹ%EF%B8%8F)
- [API Dashboard](#api-dashboard-)
- [Suggest improvements, get a pair of Vipps socks](#suggest-improvements-get-a-pair-of-vipps-socks-)
- [Do you want a Slack channel?](#do-you-want-a-slack-channel-)
- [Do you want a technical workshop?](#do-you-want-a-technical-workshop-)
- [Reminders](#reminders)

<!-- END_COMMENT -->

## The Vipps eCom API v1 is disabled

After several extensions to the original June 1 deadline, the Vipps eCom API v1
was shut down on December 4. The Vipps eCom API v2 has been available for
about three years, and offers more functionality than the old version.


## Vipps Login improvements 🎉

Vipps Login now lets merchants to control the login experience on phones: The
merchant can choose whether the user should be automatically taken back to the
browser after completing an authentication in the Vipps app.
We have also added a specific flow for integrations with apps.

To have a unified way of providing user information across Vipps services
we are standardizing the data formats, both within Vipps and with the OIDC standard.
To do this we have been required to introduce a new version of our Vipps login API.
**The previous version (Version 1) of the Vipps login API will have end of life on February 28th 2021**.


## Vipps HTTP Headers ℹ️

We recommend using the following _optional_ HTTP headers for all requests to the
[Vipps eCom API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api)
and the
[Vipps Recurring API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api).

| Header                        | Description                                  | Example value        |
| ----------------------------- | -------------------------------------------- | -------------------- |
| `Merchant-Serial-Number`      | The merchant serial number                   | `123456`             |
| `Vipps-System-Name`           | The name of the ecommerce solution           | `woocommerce`        |
| `Vipps-System-Version`        | The version number of the ecommerce solution | `5.4`                |
| `Vipps-System-Plugin-Name`    | The name of the ecommerce plugin             | `vipps-woocommerce`  |
| `Vipps-System-Plugin-Version` | The version number of the ecommerce plugin   | `1.4.1`              |

These headers provide useful metadata about the merchant's system,
which help Vipps improve our services, and also help in investigating problems.   

## API Dashboard 🚦

We are working on an API Dashboard that will be available under "Utvikler" on
[portal.vipps.no](https://portal.vipps.no).
The API Dashboard will make it easier for integrators to find errors and
possible improvements in the use of the Vipps APIs.

The MVP will show the statuses for the most recent API calls, making it possible
to see trends and areas to investigate.

Once the initial version is available, we are very interested in
suggestions for improvement. You can even start suggesting features now:
Please create one issue per suggestion/wish in the
[vipps-developers](https://github.com/vippsas/vipps-developers/issues)
repo on GitHUb.

## Suggest improvements, get a pair of Vipps socks 🧦

![Vipps socks orange](images/2020-11-sock-orange.jpg)

We appreciate all suggestions for improvement to our development platform,
including complaints! To encourage this, we will send two (2) Vipps socks to
everyone that creates a (somewhat meaningful) issue or PR for our API
documentation before January 31 2021.

What do do:

1. Create an issue or PR in the appropriate GitHub repo.
2. Wait for our comment (it may not be immediate).
3. If we think it's "OK", we will ask you to send an email to us with your address.

While we are keen to fix even the tiniest typos, we hope to get as many
"real" improvements as possible and not drown in microscopic issues, so:
Be smart. Thanks!

If we get more improvements than the number of socks we have,
we will do a scientifically randomized drawing.

## Do you want a Slack channel? 📢

We can set up a dedicated, temporary Slack channel to help fast-track your
Vipps development. Send an email to integration@vipps.no with a list of
email addresses to invite, with the same people on CC. We fix the rest.

This does, unfortunately, not apply to customers using one of our
[plugins](https://vippsas.github.io/vipps-developer-docs/docs/vipps-plugins), or
customers using Vipps through a partner.

## Do you want a technical workshop? 🛠

We can set up a dedicated video workshop to help fast-track your
Vipps development. Send an email to integration@vipps.no with a list of
email addresses to invite, with the same people on CC. We fix the rest.

This does, unfortunately, not apply to customers using one of our
[plugins](https://vippsas.github.io/vipps-developer-docs/docs/vipps-plugins), or
customers using Vipps through a partner.

## Reminders

We have mentioned some things before, and take this opportunity to remind you:

### API lifecycle

Our API lifecycle policy is
[available on GitHub](../common-topics/api-lifecycle.md).

### Status pages for test and production environments

* Test: https://vipps-test.statuspage.io
* Production: https://vipps.statuspage.io

### How to get help quickly

Please see
[this page](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).

### Newsletter archive

Please see: [newsletters](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters)

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).
