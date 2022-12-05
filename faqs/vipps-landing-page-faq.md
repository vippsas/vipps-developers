<!-- START_METADATA
---
title: Vipps landing page
sidebar_position: 90
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# FAQs: Vipps landing page

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

Document version 0.0.1.

<!-- START_TOC -->

## Table of contents

* [Is it possible to skip the landing page?](#is-it-possible-to-skip-the-landing-page)
* [How can I check if I have skipLandingPage activated?](#how-can-i-check-if-i-have-skiplandingpage-activated)
* [Can I show the landing page in an iframe?](#can-i-show-the-landing-page-in-an-iframe)

<!-- END_TOC -->

## Is it possible to skip the landing page?

Only in special cases, where displaying it is not possible.

This feature has to be specially enabled by Vipps for eligible sale units:
The sale units must be whitelisted by Vipps.
Skipping the landing page is typically used at physical points of sale
where there is no display available.

The Vipps landing page is more than just a web page, it is an entire
application and it plays an important role in the Vipps payment process.
See
[The Vipps landing page](../common-topics/vipps-landing-page.md)
for more information

If you need to skip the landing page in a Point of Sale (POS) solution, see:
[What is the process to go live in production?](pos-integrations-faq.md#what-is-the-process-to-go-live-in-production).

If you need to skip the landing page for a different reason:
Contact your Key Account Manager. If you do not have a KAM:
Please log in on
[portal.vipps.no](https://portal.vipps.no),
open the "Utvikler" (Developer) tab,
find the right sale unit and
click the email link under the "i" information bubble.
Include a detailed description of why it is not possible to display the landing page.

See:
[Skip landing page](../common-topics/vipps-landing-page.md#skip-landing-page).

## How can I check if I have skipLandingPage activated?

Vipps can no longer manually check this for merchant or partners.

All merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and check if a sale unit has `skipLandingPage` enabled
for all their sale units under the "Utvikler" menu item.

You can also find information on how to activate `skipLandingPage` there.

If you are a partner and want to check a merchant, see the
[Partner API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/partner-api/).

If you are a partner and do not yet use the Partner API, you can ask the
merchant to create a user for you on
[portal.vipps.no](https://portal.vipps.no)
so you can check on behalf of the merchant as
[described in detail with screenshots](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/add-portal-user).

If you are not able to log in on
[portal.vipps.no](https://portal.vipps.no)
you can make a small payment (2 kr)
with `skipLandingPage`.
If you do not get an error, it's active.
If you get an error, it's not active.

See:
[Skip landing page](../common-topics/vipps-landing-page.md#skip-landing-page).

## Can I show the landing page in an iframe?

No. Never show the Vipps landing page inside an iframe. That will make it
impossible for the user to reliably be redirected back to the merchant's website,
and result in a lower success rate. In general: Any "optimization" of the payment
flow may break the Vipps payment flow - if not today, then later.

See:
[Skip landing page](../common-topics/vipps-landing-page.md#skip-landing-page).
