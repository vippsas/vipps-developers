# Vipps Developers

This repository contains various resources for Vipps developers, including:

* [Getting started](vipps-getting-started.md) with Vipps development
* [How to contribute](contribute.md) to Vipps projects on GitHub
* [How to contact us](contact.md) in the Vipps Integration team
* [Requirements](requirements.md) for foreign companies in order to use Vipps
* [Settlements](https://github.com/vippsas/vipps-developers/tree/master/settlements) for information about settlements


## Status page

### Status page for the test environment

https://vipps-test.statuspage.io

### Status page for the production environment

https://vipps.statuspage.io

## The Vipps test environment (MT)

https://github.com/vippsas/vipps-developers/blob/master/vipps-test-environment.md

## Postman

See our [Postman guide](https://github.com/vippsas/vipps-developers/blob/master/postman-guide.md) or the
 [Postman documentation](https://www.getpostman.com/docs/) for more information about using Postman.

## Example code

We have made some example code available, in hope that it may be useful:
https://github.com/vippsas/vipps-developers/tree/master/code-examples

## Vipps design guidelines

Guidelines, logos, buttons, etc: https://github.com/vippsas/vipps-design-guidelines

## Vipps request servers

Requests made by Vipps are made from the servers specified below.
Vipps normally only uses one server at a time, and change servers approximately every three months.

## Production environment
```
callback-1.vipps.no
callback-2.vipps.no
callback-3.vipps.no
callback-4.vipps.no
```


## Disaster recovery (DR) environment

```
callback-dr-1.vipps.no
callback-dr-2.vipps.no
callback-dr-3.vipps.no
callback-dr-4.vipps.no
```

The disaster recovery environment is as important as the production environment.

## Test environment

```
callback-mt-1.vipps.no
callback-mt-2.vipps.no
callback-mt-3.vipps.no
callback-mt-4.vipps.no
```

For API products where Vipps makes requests to your servers, please make sure that these request servers are allowed through firewalls, etc.

**Note:** Vipps may change the IP addresses for the request servers. To ensure that you are whitelisting the correct IP addresses please use these hostnames and DNS, and automatically update your firewall rules if there are DNS changes.

## Additional developer resources

* Developer overview: https://vipps.no/developer
* High-level overview of the API documentation: https://vipps.no/developer/documentation/
* Products, personal: http://vipps.no/privat
* Products, business: http://vipps.no/bedrift

**The Vipps Integration team**
[Get in touch here](contact.md)
