---
title: Polling guidelines
hide_table_of_contents: true
pagination_next: null
pagination_prev: null
---


# Polling guidelines

Our general guidelines for polling are:

1. Start after 5 seconds
2. Check every 2 seconds

**Please note:** These are reasonable values, but different merchants have
different use cases, and values should be adapted to the specific case.

Some APIs, like the
[eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api#rate-limiting)
and
[Recurring API](https://developer.vippsmobilepay.com/docs/APIs/recurring-api/vipps-recurring-api#rate-limiting),
have rate-limiting to prevent obviously incorrect use.
If you get a `HTTP 429 Too Many Requests` error you are most likely using the API
incorrectly.

See [Timeouts](./timeouts.md) for details about timeouts.
