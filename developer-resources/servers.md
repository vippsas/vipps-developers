<!-- START_METADATA
---
title: Vipps servers
sidebar_position: 60
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Vipps servers

Vipps has different servers for making API calls to Vipps, and for Vipps
to make API calls to merchants (like callbacks).

<!-- START_TOC -->

## Table of contents

- [Vipps API servers](#vipps-api-servers)
- [Vipps request servers](#vipps-request-servers)

<!-- END_TOC -->

**Please note:** Vipps may change the IP addresses for the request servers. To ensure
that you are whitelisting the correct IP addresses please use these hostnames
and DNS, and automatically update your firewall rules if there are DNS changes.
We cannot provide the IP addresses in any other way than DNS.

The servers are the same for all APIs.

The Vipps servers all use UTC time.

## Vipps API servers

The test and production environments are separate and require different API credentials:

| Production (Prod) | Test (MT)        |
|-------------------|------------------|
| api.vipps.no      | apitest.vipps.no |

The servers are world accessible. Vipps only relies on the API keys, and
no requests to our servers are blocked on our side by IP addresses or similar.

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

For API products where Vipps makes requests to your servers, please make sure
that these request servers are allowed through firewalls, etc.
