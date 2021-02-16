# Technical newsletter for developers 2021-02

💥 DRAFT! 💥

This newsletter was sent in February 2021.

# The deprecated eCom API `/status` endpoint will be removed

The
[`/status`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#get-payment-status)
endpoint has been deprecated for a long time, and we will remove it on March 1.

The
[`/details`](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#get-payment-details)
endpoint has been available for a long time, and gives more data and details: The full payment history of the orderId.

# Vipps Login API version 2

To have a unified way of providing user information across Vipps services
we are standardising the data formats, both within Vipps and with the OIDC standard.
To do this we have to introduce a new version of our Vipps login API.
**The previous version (Version 1) of the Vipps login API will have end of life on February 28th 2021**.
See
[the API migration guide](https://github.com/vippsas/vipps-login-api/blob/master/vipps-login-migrate-api-1.0-to-2.0.md)
for details on moving from version 1 to 2.

# Vipps Login improvements 🎉

The merchant can now choose whether the user should be automatically returned
to the browser after completing the authentication Vipps.
We have also added a specific flow for integrations with native apps.
More information, and screenshots of the new flows, can be found in the
[documentation](https://github.com/vippsas/vipps-login-api/blob/master/vipps-login-api.md#mobile-flow---app-switch-based-flow).

# API Dashboard 🚦

![API Dashboaard](images/2021-02-api-dashboard-initiate-payment.png)

The API Dashboard is now available on
[portal.vipps.no](https://portal.vipps.no)
under the "Utvikler" ("Developer") tab.

This is just the start. Please let us know what you think and suggest improvements.

# Use Userinfo

Vipps Hurtigkasse is for shipping products to the customer.
Some use it for other purposes, but if no products are shipped,
you should not ask the customer for address and shipping method.

You should avoid asking the customer in a pub for the shipping method for the drinks, etc.

Instead: Use _Userinfo_ to ask for the user's details. See
[Userinfo for eCom](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#userinfo)
and
[Userinfo for Recurring](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#userinfo).

# Recurring: Info about failures

You can now se _why_ a charge fails, not just that it fails:
https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api.md#charge-failure-reasons

# Reminders

We have mentioned some things before, and take this opportunity to remind you:

## Optional HTTP Headers ℹ️

We recommend using the following _optional_ HTTP headers for all requests to the
[Vipps eCom API](https://github.com/vippsas/vipps-ecom-api/)
and the
[Vipps Recurring API](https://github.com/vippsas/vipps-recurring-api/).

| Header                        | Description                                  | Example value        |
| ----------------------------- | -------------------------------------------- | -------------------- |
| `Merchant-Serial-Number`      | The merchant serial number                   | `123456`             |
| `Vipps-System-Name`           | The name of the ecommerce solution           | `woocommerce`        |
| `Vipps-System-Version`        | The version number of the ecommerce solution | `5.4`                |
| `Vipps-System-Plugin-Name`    | The name of the ecommerce plugin             | `vipps-woocommerce`  |
| `Vipps-System-Plugin-Version` | The version number of the ecommerce plugin   | `1.4.1`              |

These headers provide useful metadata about the merchant's system,
which help Vipps improve our services, and also help in investigating problems.   

## Suggest improvements, get a pair of Vipps socks 🧦

![Vipps socks orange](images/2020-11-sock-orange.jpg)

We appreciate all suggestions for improvement to our development platform,
including complaints! To encourage this, we will send two (2) Vipps socks to
everyone that creates a (somewhat meaningful) issue or PR for our API
documentation before February 28 2021:

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
email addresses to invite, with the same people on CC. We'll fix the rest.

This does, unfortunately, not apply to customers using one of our
[plugins](https://github.com/vippsas/vipps-developers#plugins), or
customers using Vipps through a partner.

## Do you want a technical workshop? 🛠

We can set up a dedicated video workshop to help fast-track your
Vipps integration. Send an email to integration@vipps.no with a list of
email addresses to invite, with the same people on CC. We fix the rest.

This does, unfortunately, not apply to customers using one of our
[plugins](https://github.com/vippsas/vipps-developers#plugins), or
customers using Vipps through a partner.

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
