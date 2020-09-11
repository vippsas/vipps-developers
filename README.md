# Vipps Developers

Document version: 2.1.3.

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
    - [Craft Commerce](#craft-commerce)
    - [Drupal](#drupal)
    - [Episerver](#episerver)
    - [Magento 2](#magento-2)
    - [Magento 1](#magento-1)
    - [Shopify](#shopify)
    - [WooCommerce](#woocommerce)
    - [WordPress](#wordpress)
    - [BigCommerce](#bigcommerce)
    - [Wix](#wix)
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

Vipps provides several open source plugins for various web solutions.
This table below gives an overview, and the sections below have more details.
We update this table as soon as statuses or plans change.

Platform/solution | eCommerce | Recurring  | Login | Support
----------------- | --------- | ---------- | ----- | -------
Vipps product info | [Vipps på nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/) | [Faste betalinger](https://vipps.no/produkter-og-tjenester/bedrift/faste-betalinger/faste-betalinger/) | [Vipps Logg Inn](https://www.vipps.no/produkter-og-tjenester/bedrift/logg-inn-med-vipps/logg-inn-med-vipps/) | - |
WooCommerce | [vipps-woocommerce](https://github.com/vippsas/vipps-woocommerce) | [vipps-recurring-woocommerce](https://github.com/vippsas/vipps-recurring-woocommerce) | - | [Details](#woocommerce)
WordPress | - | - | [vipps-login-wordpress](https://github.com/vippsas/vipps-login-wordpress) | [Details](#wordpress) |
Magento 2 | [vipps-magento](https://github.com/vippsas/vipps-magento) | - | [vipps-login-magento](https://github.com/vippsas/vipps-login-magento) | [Details](#magento-2)
Magento 1 | [vipps-magento-v1](https://github.com/vippsas/vipps-magento-v1) | - | -| [Details](#magento-1)
Episerver | [vipps-episerver](https://github.com/vippsas/vipps-episerver) | - | [vipps-login-dotnet](https://github.com/vippsas/vipps-login-dotnet) |-
Drupal | [vipps-drupal](https://github.com/vippsas/vipps-drupal) | [vipps-recurring-drupal](https://github.com/vippsas/vipps-recurring-drupal) | [vipps-login-drupal](https://github.com/vippsas/vipps-login-drupal) |[Details](#drupal)
Shopify | [vipps-shopify](https://github.com/vippsas/vipps-shopify) | - | - | [Details](#shopify)
Craft Commerce | To be decided. | - | [vipps-craft-login](https://github.com/vippsas/vipps-craft-login)|-
Wix | Coming soon, possibly November. | - | -|-
BigCommerce | To be decided. | - | -|-

### Craft Commerce

![alt text][craft-cms-logo]  
**eCommerce**: To be decided.  
**Recurring**: N/A  
**Login**: [vipps-craft-login](https://github.com/vippsas/vipps-craft-login)  

### Drupal  

![Drupal logo][drupal-logo]  
**eCommerce**: [vipps-drupal](https://github.com/vippsas/vipps-drupal)  
**Recurring**: [vipps-recurring-drupal](https://github.com/vippsas/vipps-recurring-drupal)  
**Login**: [vipps-login-drupal](https://github.com/vippsas/vipps-login-drupal)  

### Episerver  

![Episerver logo][episerver-logo]  
**eCommerce**: [vipps-episerver](https://github.com/vippsas/vipps-episerver)  
**Recurring**: N/A  
**Login**: [vipps-login-dotnet](https://github.com/vippsas/vipps-login-dotnet)  

![Magento logo][magento-logo]  

### Magento 2

**eCommerce**: [vipps-magento](https://github.com/vippsas/vipps-magento) **Support:** vipps@vaimo.no or [submit an issue on GitHub](https://github.com/vippsas/vipps-magento)  
**Recurring**: N/A  
**Login**: [vipps-login-magento](https://github.com/vippsas/vipps-login-magento) **Support:** vipps@vaimo.no or [submit an issue on GitHub](https://github.com/vippsas/vipps-login-magento)

### Magento 1

**eCommerce**: [vipps-magento-v1](https://github.com/vippsas/vipps-magento-v1) **Support:** vipps@vaimo.no or [submit an issue on GitHub](https://github.com/vippsas/vipps-magento-v1)  
**Recurring**: N/A  
**Login**: N/A  

### Shopify  

![Shopify logo][shopify-logo]  
**eCommerce**: [vipps-shopify](https://github.com/vippsas/vipps-shopify) **Support:** [submit an issue on GitHub](https://github.com/vippsas/vipps-shopify)  
**Recurring**:  N/A  
**Login**:  N/A

### WooCommerce

![WooCommerce logo][woocommerce-logo]  
**eCommerce**: [vipps-woocommerce](https://github.com/vippsas/vipps-woocommerce) **Support:** [wordpress.org](https://wordpress.org/support/plugin/woo-vipps/)  
**Recurring**: [vipps-recurring-woocommerce](https://github.com/vippsas/vipps-recurring-woocommerce) **Support:** [wordpress.org](https://wordpress.org/support/plugin/vipps-recurring-payments-gateway-for-woocommerce/)  
**Login**: [See WordPress.](#wordpress)  

### WordPress

![Wordpress logo][wordpress-logo]  
**eCommerce**: [See WooCommerce.](#woocommerce)  
**Recurring**: [See WooCommerce.](#woocommerce)  
**Login**: [vipps-login-wordpress](https://github.com/vippsas/vipps-login-wordpress) **Support:** [wordpress.org](https://wordpress.org/support/plugin/login-with-vipps/)  

### BigCommerce  
![BigCommerce logo][bigcommerce-logo]  
**eCommerce**: To be decided.  
**Recurring**: N/A  
**Login**: N/A  

### Wix  

![Wix logo][wix-logo]  
**eCommerce**: Coming soon.  
**Recurring**: N/A  
**Login**: N/A  

[bigcommerce-logo]: images/logos/bigcommerce.png "BigCommerce logo"
[craft-cms-logo]: images/logos/logo-craft-cms.svg "craft cms logo"
[drupal-logo]: images/logos/drupal.png "craft cms logo"
[episerver-logo]: images/logos/episerver.png "EpiServer logo"
[magento-logo]: images/logos/magento.png "Magento logo"
[shopify-logo]: images/logos/shopify.png "Shopify logo"
[wix-logo]: images/logos/wix.png "Wix logo"
[wordpress-logo]: images/logos/wordpress.png "Wordpress logo"
[woocommerce-logo]: images/logos/woocommerce.png "WooCommerce logo"

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
