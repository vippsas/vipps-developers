<!-- START_METADATA
---
title: Technical newsletter for developers 2019-11
sidebar_label: 2019-11
sidebar_position: 78
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Technical newsletter for developers 2019-11

This newsletter was sent November 19, 2019.

## Vipps eCom v1 API to be phased out June 1, 2020

The Vipps eCom API v1 was superseded by the eCom v2 API around two years ago.
The eCom v2 API has all the functionality of eCom v1, and there is no reason
for not upgrading to eCom v2.

## Vipps InApp API to be phased out December 31, 2019

This was communicated July, but we mention it again, just in case.

## API products: Vipps API

Vipps has previously had separate API keys for each API product, and a set of API keys were
directly linked to one sales unit. This meant that customers needed to keep track of
multiple API keys, and that access to a new API required a new sales unit.

This is no longer the case: The *Vipps-API* product give access to all current APIs,
and the API keys for the Vipps eCom v1 and v2 APIs have been “upgraded” to include the
same APIs as Vipps API.

See more details [in Getting Started](../getting-started.md).

## API lifecycle

We are working on this, and the current version/draft is
[available on GitHub](../common-topics/api-lifecycle2.md).

## vipps.no/developer

New developer pages, in addition to [GitHub](https://github.com/vippsas),
are available at <https://vipps.no/developer>.

## Status page for test and production

We will soon launch status pages:

- Test environment: <https://vipps-test.statuspage.io>
- Production environment: <https://vipps.statuspage.io>

## Further plans

We are working on more developer resources, including a data API and
a developer dashboard. We cannot provide any dates yet, but we
welcome input in the form of issues on <https://github.com/vippsas/vipps-developers>.

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://developer.vippsmobilepay.com/docs/vipps-developers/contact).
