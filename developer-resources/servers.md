---
title: Vipps MobilePay servers
sidebar_position: 140
pagination_next: null
pagination_prev: null
---

# Servers

Vipps MobilePay has different servers for making API calls, and for us
to make API calls to merchants (like callbacks).

**Please note:** We may change the IP addresses for the request servers. To ensure
that you are whitelisting the correct IP addresses please use these hostnames
and DNS, and automatically update your firewall rules if there are DNS changes.
We cannot provide the IP addresses in any other way than DNS.

The servers are the same for all APIs.

The Vipps MobilePay servers all use UTC time.

## API servers

The test and production environments are separate and require different API credentials:

| Production (Prod) | Test (MT)        |
|-------------------|------------------|
| api.vipps.no      | apitest.vipps.no |

The servers are world accessible. Vipps MobilePay only relies on the API keys, and
no requests to our servers are blocked on our side by IP addresses or similar.

## Request servers

Requests made by us are made from the servers specified below.
We normally only uses one server at a time, and change servers approximately
every three months.

| Production (Prod)   | Disaster recovery (DR) | Test (MT)              |
|---------------------|------------------------|------------------------|
| callback-1.vipps.no | callback-dr-1.vipps.no | callback-mt-1.vipps.no |
| callback-2.vipps.no | callback-dr-2.vipps.no | callback-mt-2.vipps.no |
| callback-3.vipps.no | callback-dr-3.vipps.no |                        |
| callback-4.vipps.no | callback-dr-4.vipps.no |                        |

The disaster recovery environment is as important as the production environment.

For API products where we makes requests to your servers, please make sure
that these request servers are allowed through firewalls, etc.

## DNS lookup commands

Here are some quick commands to look up the IP addresses of all servers,
including example output at the time of writing:

Production
```
$ for i in {1..4}; do dig +short callback-$i.vipps.no; done | sort -u
104.45.17.199
104.45.28.230
[...]
```

Disaster recovery:
```
$ for i in {1..4}; do dig +short callback-dr-$i.vipps.no; done | sort -u
13.79.229.87
13.79.231.118
[...]
```

Test:
```
$ for i in {1..2}; do dig +short callback-mt-$i.vipps.no; done | sort -u
104.40.249.200
104.40.250.173
[...]
```