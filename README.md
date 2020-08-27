# Vipps Developers

Document version: 2.1.1.

This repository contains various resources for Vipps developers, including:

* [Getting started](vipps-getting-started.md) with Vipps development
* [How to contact us](contact.md) in the Vipps Integration team
* [Requirements](requirements.md) for foreign companies in order to use Vipps
* [Settlements](https://github.com/vippsas/vipps-developers/tree/master/settlements)
  for information about settlements
* [How to contribute](contribute.md) to Vipps projects on GitHub

## Table of contents

- [Vipps Developers](#vipps-developers)
  - [Table of contents](#table-of-contents)
  - [API documentation](#api-documentation)
  - [Plugins](#plugins)
  - [Status page](#status-page)
  - [The Vipps test environment (MT)](#the-vipps-test-environment-mt)
  - [Postman](#postman)
  - [Vipps design guidelines](#vipps-design-guidelines)
  - [Vipps API servers](#vipps-api-servers)
  - [Vipps request servers](#vipps-request-servers)
  - [Additional developer resources](#additional-developer-resources)
  - [Questions?](#questions)

## API documentation

See: [Getting started](vipps-getting-started.md).

## Plugins

Platform/solution | eCommerce | Recurring  | Login
----------------- | --------- | ---------- | -----
Vipps product info | [Vipps på nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/) | [Faste betalinger](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/) | [Vipps Logg Inn](https://www.vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/)
WooCommerce | [vipps-woocommerce](https://github.com/vippsas/vipps-woocommerce) <br/>For support, use [wordpress.org](https://wordpress.org/support/plugin/woo-vipps/)| [vipps-recurring-woocommerce](https://github.com/vippsas/vipps-recurring-woocommerce)<br/>For support, use [wordpress.org](https://wordpress.org/support/plugin/vipps-recurring-payments-gateway-for-woocommerce/) | - |
WordPress | - | - | [vipps-login-wordpress](https://github.com/vippsas/vipps-login-wordpress) <br/>For support, use [wordpress.org](https://wordpress.org/support/plugin/login-with-vipps/)
Magento 2 | [vipps-magento](https://github.com/vippsas/vipps-magento)<br/>For support, use vipps@vaimo.no<br/> or [submit an issue on GitHub](https://github.com/vippsas/vipps-magento) | - | [vipps-login-magento](https://github.com/vippsas/vipps-login-magento)<br/>For support, use vipps@vaimo.no <br/>or [submit an issue on GitHub](https://github.com/vippsas/vipps-login-magento)
Magento 1 | [vipps-magento-v1](https://github.com/vippsas/vipps-magento-v1)<br/> For support, use vipps@vaimo.no<br/> or [submit an issue on GitHub](https://github.com/vippsas/vipps-magento-v1) | - | To be decided.
Episerver | [vipps-episerver](https://github.com/vippsas/vipps-episerver) | - | Coming soon.
Drupal | [vipps-drupal](https://github.com/vippsas/vipps-drupal) | Coming soon. | Coming soon.
Shopify | [vipps-shopify](https://github.com/vippsas/vipps-shopify)<br/>For support, [submit an issue on GitHub](https://github.com/vippsas/vipps-shopify) | - | - |
Craft Commerce | To be decided. | - | [vipps-craft-login](https://github.com/vippsas/vipps-craft-login)
Wix | To be decided. | - | -
BigCommerce | To be decided. | - | -

## Status page

* Test environment: https://vipps-test.statuspage.io
* Production environment: https://vipps.statuspage.io

## The Vipps test environment (MT)

See
[The Vipps test environment (MT)](https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md)
for more information about general test functionality,
the iOS and Android test apps, etc

## Postman

See our
[Postman guide](https://github.com/vippsas/vipps-developers/blob/master/postman-guide.md)
or the
[Postman documentation](https://www.getpostman.com/docs/)
for more information about using Postman.

## Vipps design guidelines

Guidelines, logos, buttons, etc is here:
[vipps-design-guidelines](https://github.com/vippsas/vipps-design-guidelines).

## Vipps API servers

* Test (MT): apitest.vipps.no
* Production: api.vipps.no

**Please note:** Vipps may change the IP addresses for the API servers. To ensure
that you are whitelisting the correct IP addresses please use these hostnames
and DNS, and automatically update your firewall rules if there are DNS changes.

## Vipps request servers

Requests made by Vipps are made from the servers specified below.
Vipps normally only uses one server at a time, and change servers approximately
every three months.

| Production (Prod)   | Disaster recovery (DR) | Test (MT)              |
| ------------------- | ---------------------- | ---------------------- |
| callback-1.vipps.no | callback-dr-1.vipps.no | callback-mt-1.vipps.no |
| callback-2.vipps.no | callback-dr-2.vipps.no | callback-mt-2.vipps.no |
| callback-3.vipps.no | callback-dr-3.vipps.no | callback-mt-3.vipps.no |
| callback-4.vipps.no | callback-dr-4.vipps.no | callback-mt-4.vipps.no |

The disaster recovery environment is as important as the production environment.

**Please note:** Vipps may change the IP addresses for the request servers. To ensure
that you are whitelisting the correct IP addresses please use these hostnames
and DNS, and automatically update your firewall rules if there are DNS changes.

For API products where Vipps makes requests to your servers, please make sure
that these request servers are allowed through firewalls, etc.

## Additional developer resources

* Developer overview: https://vipps.no/developer
* Products, personal: http://vipps.no/privat
* Products, business: http://vipps.no/bedrift

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
