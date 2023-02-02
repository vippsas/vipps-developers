<!-- START_METADATA
---
sidebar_position: 66
title: 2022-12
pagination_next: null
pagination_prev: null
draft: true
---
END_METADATA -->

# Technical newsletter for developers 2023-01

💥 DRAFT! 💥

This newsletter was sent in January 2023.

<!-- START_COMMENT -->

## Table of Contents

* [Reminders](#reminders)
  * [Please check your API calls for errors](#please-check-your-api-calls-for-errors)
* [Questions or comments?](#questions-or-comments)

<!-- END_COMMENT -->

## Report API

The Vipps Report API is now available. It is a REST API providing data about
payments in JSON format. See the
[API documentation](https://vippsas.github.io/vipps-developer-docs/docs/APIs/report-api).

## Changes to the access token endpoint

Due to
[changes to the Microsoft Azure platform](https://learn.microsoft.com/en-us/answers/questions/768833/when-is-adal-and-azure-ad-graph-reaching-end-of-li.html)
that Vipps depends on, we have to make some minor changes to the
[`POST:/accesstoken/get`](https://vippsas.github.io/vipps-developer-docs/api/access-token#tag/Authorization-Service/operation/fetchAuthorizationTokenUsingPost)
endpoint.

We will not longer return the following fields in the response:
```
"ext_expires_in": "0",
"expires_on": "1495271273",
"not_before": "1495184574",
```

See the API specification (link above) for details.

## Reminders

### Please check your API calls for errors

We are working on eliminating incorrect API use. Please:

* Monitor the responses you get when making API calls
* Log all errors
* Fix errors as quickly as possible
* Use the
  [API Dashboard](../developer-resources/api-dashboard.md)
  to find problems with your integration.

![API Dashboard example](images/2021-02-api-dashboard-example.png)

## Questions or comments?

We're always happy to help with code or other questions you might have!
Please create [GitHub issues or pull requests](https://github.com/vippsas)
for the relevant API,
or [contact us](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/contact).
