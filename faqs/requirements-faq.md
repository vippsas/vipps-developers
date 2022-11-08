<!-- START_METADATA
---
title: Requirements
sidebar_position: 10
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# FAQs: Requirements

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

Document version 0.0.2.

<!-- START_TOC -->

## Table of contents

* [What are the requirements for Vipps merchants?](#what-are-the-requirements-for-vipps-merchants)
* [Can I use my "Vippsnummer" in my webshop?](#can-i-use-my-vippsnummer-in-my-webshop)

<!-- END_TOC -->

## What are the requirements for Vipps merchants?

Vipps merchants (corporate customers) must have a Norwegian organization number
and applications must be signed with Norwegian BankID. Vipps must follow the
regulatory requirements for KYC (Know Your Customer), AML (Anti Money Laundering)
and other risk assessment procedures.

See:
[Getting Started: Requirements](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md#requirements).

It is also possible to use Vipps through a PSP.
Vipps then relies on the PSP for KYC (Know Your Customer), AML (Anti Money Laundering)
and other risk assessment procedures. Contact your PSP for details.

## Can I use my "Vippsnummer" in my webshop?

No.
[Vippsnummer](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/ta-betalt-med-vipps/)
can't be used for
[Vipps på Nett](https://vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/),
[Vipps Logg Inn](https://vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
or
[Vipps Faste Betalinger (Recurring payments)](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/).
You need
[Vipps på Nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/).

The reason for this is that the Norwegian Tax Administration considers
"Vippsnummer" to be cash transactions,
while eCommerce is defined as remote sales (in Norwegian, *fjernhandel*). The regulations
associated with both are different enough to require this policy.
