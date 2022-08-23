<!-- START_METADATA
---
sidebar_position: 77
title: 2019-11
---
END_METADATA -->

# Technical newsletter for developers 2019-11

This newsletter was sent November 19 2019.

# Vipps eCom v1 API to be phased out June 1 2020

The Vipps eCom API v1 was superseded by the eCom v2 API around two years ago.
The eCom v2 API has all the functionality of eCom v1, and there is no reason
for not upgrading to eCom v2.

Se [more details about eCom v1](https://github.com/vippsas/vipps-ecom-api/blob/master/v1-deprecation.md),
and
[more details about the various Vipps APIs](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#api-products).

# Vipps InApp API to be phased out December 31 2019

This was communicated July, but we mention it again, just in case.

# API products: Vipps API

Vipps has previously had separate API keys for each API product, and a set of API keys were 
directly linked to one sale unit. This meant that customers needed to keep track of 
multiple API keys, and that access to a new API required a new sale unit.

This is no longer the case: The Vipps-API API product give access to all current APIs, 
and the API keys for the Vipps eCom v1 and v2 APIs have been “upgraded” to include the 
same APIs as Vipps API.

See more details [here](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#api-products).

# API lifecycle

We are working on this, and the current version/draft is
[available on GitHub](https://github.com/vippsas/vipps-developers/blob/master/vipps-api-lifecycle.md).

# vipps.no/developer

New developer pages, in addition to
[GitHub](https://github.com/vippsas),
are available at https://vipps.no/developer

# Status page for test and production

We will soon launch status pages:

* Test: https://vipps-test.statuspage.io (possibly https://test.status.vipps.no)
* Test: https://vipps.statuspage.io (possibly https://status.vipps.no)

# Further plans

We are working on more developer resources, including a data API and
a developer dashboard. We can not provide any dates yet, but we
welcome input in the form of issues on https://github.com/vippsas/vipps-developers.

# Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
