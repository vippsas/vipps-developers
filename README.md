# Vipps Developers

This repository contains various resources for Vipps developers.
We recommend starting with [Getting started](vipps-getting-started.md).

## Table of contents

- [Vipps demo store](#vipps-demo-store)
- [API documentation](#api-documentation)
- [Technical newsletter](#technical-newsletter)
- [Partners](#partners)
- [Plugins](#plugins)
- [Status pages](#status-pages)
- [The Vipps test environment (MT)](#the-vipps-test-environment-mt)
- [Postman](#postman)
- [API Dashboard](#api-dashboard)
- [Vipps API servers](#vipps-api-servers)
- [Vipps request servers](#vipps-request-servers)
- [Vipps API Lifecycle](#vipps-api-lifecycle)
- [Settlements](#settlements)
- [Vipps design guidelines](#vipps-design-guidelines)
- [Questions?](#questions)

Document version: 2.6.4.

## Vipps demo store

You can test Vipps with a _production_ version of the Vipps app
(the normal one in Apple Store and Google Play) here:
[demo.vipps.no](https://demo.vipps.no).

Maybe you want to start by scanning this QR code and go directly to
Vipps Hurtigkasse (express checkout) and buy a nice VHS cassette?

<img src="images/demostore-qr-vipps-hurtigkasse.png" alt="QR code to Vipps Hurtigkasse" title="QR code to Vipps Hurtigkasse" width="285" />

## API documentation

First of all: See [Getting started](vipps-getting-started.md).

The most commonly used APIs:

- [Vipps Checkout API](https://github.com/vippsas/vipps-checkout-api)
- [Vipps eCom API](https://github.com/vippsas/vipps-ecom-api)
- [Vipps Login API](https://github.com/vippsas/vipps-login-api)
- [Vipps Recurring API](https://github.com/vippsas/vipps-recurring-api)
- [Vipps QR API](https://github.com/vippsas/vipps-qr-api)
- [Vipps Order Management API](https://github.com/vippsas/vipps-order-management-api)
- [Vipps PSP API](https://github.com/vippsas/vipps-psp-api)

All Vipps APIs are available (and searchable) here: <https://github.com/vippsas>

The API documentation is frequently improved and increasingly extensive.
Please use the search functionality in your browser and on GitHub to find
what you are looking for.

## Technical newsletter

We have a low volume newsletter with important information to developers about
Vipps' APIs and products. Subscribe (and access the archive) here:
[Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).

## Partners

See our [Partner section](https://github.com/vippsas/vipps-partner#vipps-partners).

## Plugins

Vipps provides several open source plugins for various web solutions.
See our [Plugins section](https://github.com/vippsas/vipps-plugins).

## Status pages

We have several status pages, and we strongly recommend to subscribe to them
(you can also subscribe to updates for specific incidents):

- Test environment: <https://vipps-test.statuspage.io>
- Production environment: <https://vipps.statuspage.io>
- BankID production: <https://www.bankid.no/status/>
- BankID preprod: <https://bankidpreprod.statuspage.io>

You can use the Atom and RSS feeds on the status pages for integration with other systems.

## The Vipps test environment (MT)

See
[The Vipps test environment (MT)](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md)
for more information about general test functionality,
the iOS and Android test apps, etc.

MT is short for Merchant Test.

## Postman

See our
[Postman guide](https://github.com/vippsas/vipps-developers/blob/master/postman-guide.md)
or the
[Postman documentation](https://www.getpostman.com/docs/)
for more information about using Postman.

## API Dashboard

All merchants have access to an API Dashboard on
[portal.vipps.no](https://portal.vipps.no) under the "Utvikler" tab.

The API Dashboard shows information about your API usage, an overview of errors, etc.
Here's an example for one endpoint:

![API Dashboard](newsletters/images/2021-02-api-dashboard-example.png)

The API Dashboard is available for both the production and test environments,
and is an easy way to see if you are using the Vipps APIs correctly.
It only gives a high-level overview, so must check the actual API
responses for more details about the errors.
Think of it as a "health check" that you can use to see if there are any
problems you need to investigate.
We strongly recommend that you also monitor your Vipps integration yourself.

**Important:** Partners can ask their merchants to give them access to the
sale unit(s) the partner is making payments for, so the partner can use the
API Dashboard.

**Please note:** The API dashboard is not real-time, and events might take up to
10 minutes before they appear.

Keep in mind that the "Utvikler" tab is only available to users with admin or
developer roles.

## Vipps API servers

The test and production environments are separate and require different API credentials:

| Production (Prod) | Test (MT)        |
|-------------------|------------------|
| api.vipps.no      | apitest.vipps.no |

The servers are world accessible. Vipps only relies on the API keys, and
no requests to our servers are blocked on our side by IP addresses or similar.

The servers are the same for all APIs.

**Please note:** Vipps may change the IP addresses for the API servers. To ensure
that you are whitelisting the correct IP addresses please use these hostnames
and DNS, and automatically update your firewall rules if there are DNS changes.
We can not provide the IP addresses in any other way than DNS.

## Vipps request servers

Requests made by Vipps are made from the servers specified below.
Vipps normally only uses one server at a time, and change servers approximately
every three months.

| Production (Prod)   | Disaster recovery (DR) | Test (MT)              |
|---------------------|------------------------|------------------------|
| callback-1.vipps.no | callback-dr-1.vipps.no | callback-mt-1.vipps.no |
| callback-2.vipps.no | callback-dr-2.vipps.no | callback-mt-2.vipps.no |
| callback-3.vipps.no | callback-dr-3.vipps.no |                        |
| callback-4.vipps.no | callback-dr-4.vipps.no |                        |

The disaster recovery environment is as important as the production environment.

The servers are the same for all APIs.

**Please note:** Vipps may change the IP addresses for the request servers. To ensure
that you are whitelisting the correct IP addresses please use these hostnames
and DNS, and automatically update your firewall rules if there are DNS changes.
We can not provide the IP addresses in any other way than DNS.

For API products where Vipps makes requests to your servers, please make sure
that these request servers are allowed through firewalls, etc.

## Vipps API Lifecycle

See:
[Vipps API Lifecycle](https://github.com/vippsas/vipps-developers/blob/master/vipps-api-lifecycle.md).

## Settlements

See:
[Settlements](https://github.com/vippsas/vipps-developers/tree/master/settlements).

## Vipps design guidelines

Guidelines, logos, buttons, etc is here:
[vipps-design-guidelines](https://github.com/vippsas/vipps-design-guidelines).

And here:
[brand.vipps.no](https://brand.vipps.no).

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
