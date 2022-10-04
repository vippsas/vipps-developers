<!-- START_METADATA
---
title: Developer resources
sidebar_position: 25
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Developer resources

This repository contains various resources for Vipps developers.
We recommend starting with [Getting started](vipps-getting-started.md).

<!-- START_COMMENT -->

💥 Preview the new documentation pages here: <https://vippsas.github.io/vipps-developer-docs/>.
See the disclaimer: <https://vippsas.github.io/vipps-developer-docs/docs/examples/>.

<!-- END_COMMENT -->

<!-- START_TOC -->

## Table of contents

* [Vipps demo store](#vipps-demo-store)
* [API documentation](#api-documentation)
* [Technical newsletter](#technical-newsletter)
* [Partners](#partners)
* [Plugins](#plugins)
* [Status pages](#status-pages)
* [The Vipps test environment (MT)](#the-vipps-test-environment-mt)
* [Quick start guides](#quick-start-guides)
* [API Dashboard](#api-dashboard)
* [Vipps servers](#vipps-servers)
  * [Vipps API servers](#vipps-api-servers)
  * [Vipps request servers](#vipps-request-servers)
* [Vipps API Lifecycle](#vipps-api-lifecycle)
* [Settlements](#settlements)
* [Vipps design guidelines](#vipps-design-guidelines)
* [Questions?](#questions)

<!-- END_TOC -->

Document version: 1.0.0.

## Vipps demo store

You can test Vipps with a _production_ version of the Vipps app
(the normal one in Apple Store and Google Play) here:
[demo.vipps.no](https://demo.vipps.no).

Maybe you want to start by scanning this QR code and go directly to
Vipps Hurtigkasse (express checkout) and buy a nice VHS cassette?

![QR code to Vipps Hurtigkasse](images/demostore-qr-vipps-hurtigkasse_sm.png)


<!-- START_COMMENT -->
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

All the Vipps APIs, and all the documentation on this website,
is available (and searchable) on GitHub: <https://github.com/vippsas>.
If you have suggestions for improvement: Please submit an issue or PR.

## Technical newsletter

We have a low volume newsletter with important information to developers about
Vipps' APIs and products. Subscribe (and access the archive) here:
[Technical newsletter for developers](newsletters/README.md).

## Partners

See our [Partner section](https://github.com/vippsas/vipps-partner#vipps-partners).

## Plugins

Vipps provides several open source plugins for various web solutions.
See our [Plugins section](https://github.com/vippsas/vipps-plugins).
<!-- END_COMMENT -->


## Status pages

We have several status pages, and we strongly recommend to subscribe to them
(you can also subscribe to updates for specific incidents):

- Test environment: <https://vipps-test.statuspage.io>
- Production environment: <https://vipps.statuspage.io>

You can use the Atom and RSS feeds on the status pages for integration with other systems.


<!-- START_COMMENT -->
## The Vipps test environment (MT)

See
[The Vipps test environment (MT)](vipps-test-environment.md)
for more information about general test functionality,
the iOS and Android test apps, etc.

## Quick start guides

See our
[Quick start guides](vipps-quick-start-guides.md)
for an introduction of how to use our APIs.
<!-- END_COMMENT -->


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
API Dashboard. There is a guide here:
[How to add a user on portal.vipps.no](https://github.com/vippsas/vipps-partner/blob/main/add-portal-user.md)

**Please note:** The API dashboard is not real-time, and events might take up to
10 minutes before they appear.

Keep in mind that the "Utvikler" tab is only available to users with admin or
developer roles.

## Vipps servers

Vipps has different servers for making API calls to Vipps, and for Vipps
to make API calls to merchants (like callbacks).

**Please note:** Vipps may change the IP addresses for the request servers. To ensure
that you are whitelisting the correct IP addresses please use these hostnames
and DNS, and automatically update your firewall rules if there are DNS changes.
We cannot provide the IP addresses in any other way than DNS.

The servers are the same for all APIs.

The Vipps servers all use UTC time.

### Vipps API servers

The test and production environments are separate and require different API credentials:

| Production (Prod) | Test (MT)        |
|-------------------|------------------|
| api.vipps.no      | apitest.vipps.no |

The servers are world accessible. Vipps only relies on the API keys, and
no requests to our servers are blocked on our side by IP addresses or similar.

### Vipps request servers

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

For API products where Vipps makes requests to your servers, please make sure
that these request servers are allowed through firewalls, etc.

<!-- START_COMMENT -->
## Vipps API Lifecycle

See:
[Vipps API Lifecycle](vipps-api-lifecycle.md).

## Settlements

See:
[Settlements](settlements/README.md).
<!-- END_COMMENT -->


## Vipps design guidelines

The best source is:
[brand.vipps.no](https://brand.vipps.no)

There are also some guidelines, logos, buttons, etc. here:
[vipps-design-guidelines](https://github.com/vippsas/vipps-design-guidelines).

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](contact.md).

Sign up for our [Technical newsletter for developers](newsletters/README.md).
