---
title: Vipps servers
sidebar_position: 160
pagination_next: null
pagination_prev: null
---

# Vipps servers

Vipps has different servers for making API calls to Vipps, and for Vipps
to make API calls to merchants (like callbacks).

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

## DNS lookup commands

Here are some quick commands to look up the IP addresses of all servers,
including example output at the time of writing:

Production
```
$ for i in {1..4}; do dig +short callback-$i.vipps.no; done | sort -u
104.45.17.199
104.45.28.230
104.45.8.62
13.69.68.12
168.63.12.69
40.114.249.97
40.91.218.4
40.91.218.91
40.91.220.139
51.105.122.49
51.105.122.53
51.105.122.60
51.105.122.61
51.144.117.82
52.232.113.216
```

Disater recovery:
```
$ for i in {1..4}; do dig +short callback-dr-$i.vipps.no; done | sort -u
13.79.229.87
13.79.231.118
13.79.231.176
```

Test:
```
$ for i in {1..2}; do dig +short callback-mt-$i.vipps.no; done | sort -u
104.40.249.200
104.40.250.173
104.40.251.114
104.40.253.225
104.40.255.223
13.69.68.37
40.113.120.168
40.114.197.70
40.114.204.190
40.91.205.141
51.105.193.243
51.105.193.245
```