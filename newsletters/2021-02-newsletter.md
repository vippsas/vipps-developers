---
title: Technical newsletter for developers 2021-02
sidebar_label: 2021-02
sidebar_position: 276
pagination_next: null
pagination_prev: null
---


# Technical newsletter for developers 2021-02

This newsletter was sent in February 2021.

## Please update your plugins

Several of our plugins have been updated to use the newest versions of
our APIs. Please make sure you have the newest version of the plugins
you use, and keep them up to date. See the
[plugin overview](https://developer.vippsmobilepay.com/docs/plugins).

## API Dashboard 🚦

The API Dashboard is now available on
[portal.vipps.no](https://portal.vipps.no)
in the *Utvikler* (*Developer*) section.
It lets you see if there are problems with your use of APIs.
Here's an example:

![API Dashboard example](images/2021-02-api-dashboard-example.png)

This is just the start. Please let us know what you think and suggest improvements.

## The deprecated eCom API `/status` endpoint will be removed

The
[`/status`](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#get-payment-status)
endpoint has been deprecated for a long time, and we will remove it on March 1.

The
[`/details`](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#get-payment-details)
endpoint has been available for a long time, and gives more data and details: The full payment history of the orderId.

## Login API version 2

To have a unified way of providing user information across Vipps services
we are standardizing the data formats, both within Vipps and with the OIDC standard.
To do this we have to introduce a new version of our Login API.
**The previous version (Version 1) of the Login API will have end of life on February 28th 2021**.

Our plugins are updated to support the latest version.
Make sure that you use the latest version of the plugin.
See
[Plugins](https://developer.vippsmobilepay.com/docs/plugins)
for details.

## Vipps Login improvements 🎉

The merchant can now choose whether the user should be automatically returned
to the browser after completing the authentication Vipps.
We have also added a specific flow for integrations with native apps.

## Use Userinfo

Vipps Hurtigkasse is for shipping products to the customer.
Some use it for other purposes, but if no products are shipped,
you should not ask the customer for address and shipping method.

You should avoid asking the customer in a pub for the shipping method for the drinks, etc.

Instead: Use *Userinfo* to ask for the user's details, such as:
phone number, name, email address, postal address, birthdate, national identity number and bank accounts.
The user must of course consent to sharing the information.

See
[Userinfo for eCom](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#userinfo)
and
[Userinfo for Recurring](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/recurring-api-guide#userinfo).

## Recurring: Info about failures

You can now see *why* a charge fails, not just that it fails: Insufficient funds, invalid card, etc.
See:
[Charge failure reasons](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/recurring-api-guide#charge-failure-reasons).

## Reminders

We have mentioned some things before, and take this opportunity to remind you:

### Vipps HTTP Headers ℹ️

We recommend using the following *optional* HTTP headers for all requests to the
[eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
and the
[Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api).

| Header                        | Description                                  | Example value        |
| ----------------------------- | -------------------------------------------- | -------------------- |
| `Merchant-Serial-Number`      | The merchant serial number                   | `123456`             |
| `Vipps-System-Name`           | The name of the ecommerce solution           | `WooCommerce`        |
| `Vipps-System-Version`        | The version number of the ecommerce solution | `5.4`                |
| `Vipps-System-Plugin-Name`    | The name of the ecommerce plugin             | `woocommerce-payment`  |
| `Vipps-System-Plugin-Version` | The version number of the ecommerce plugin   | `1.4.1`              |

These headers provide useful metadata about the merchant's system,
which help Vipps improve our services, and also help in investigating problems.

### Suggest improvements, get a pair of Vipps socks 🧦

![Vipps socks orange](images/2020-11-sock-orange.jpg)

We appreciate all suggestions for improvement to our development platform,
including complaints! To encourage this, we will send two (2) Vipps socks to
everyone that creates a (somewhat meaningful) issue or PR for our API
documentation before February 28, 2021:

1. Create an issue or PR in the appropriate GitHub repo.
2. Wait for our comment (it may not be immediate).
3. If we think it's "OK", we will ask you to email us with your address.

While we are keen to fix even the tiniest typos, we hope to get as many
"real" improvements as possible and not drown in microscopic issues, so:
Be smart. Thanks!

If we get more improvements than the number of socks we have,
we will do a scientifically randomized drawing.

### Do you want a Slack channel? 📢

We can set up a dedicated, temporary Slack channel to help fast-track your
Vipps development. Email [developer@vippsmobilepay.com](mailto:developer@vippsmobilepay.com) with a list of
email addresses to invite, with the same people on CC. We'll fix the rest.

This does require that you have already ordered a Vipps solution, and
that you already have API access.

This does, unfortunately, not apply to customers using one of our
[plugins](https://developer.vippsmobilepay.com/docs/plugins), or
customers using Vipps through a partner.

### Do you want a technical workshop? 🛠

We can set up a dedicated video workshop to help fast-track your
Vipps integration. Email [developer@vippsmobilepay.com](mailto:developer@vippsmobilepay.com) with a list of
email addresses to invite, with the same people on CC. We fix the rest.

This does require that you have already ordered a Vipps solution, and
that you already have API access.

This does, unfortunately, not apply to customers using one of our
[plugins](https://developer.vippsmobilepay.com/docs/plugins), or
customers using Vipps through a partner.

### API lifecycle

Our API lifecycle policy is
[available on GitHub](../knowledge-base/api-lifecycle.md).

### Status pages for test and production environments

* Test: <https://vipps-test.statuspage.io>
* Production: <https://vipps.statuspage.io>

### How to get help quickly

Please see
[this page](https://developer.vippsmobilepay.com/docs/contact).

### Newsletter archive

Please see: [newsletters](https://developer.vippsmobilepay.com/docs/newsletters)

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://developer.vippsmobilepay.com/docs/contact).
