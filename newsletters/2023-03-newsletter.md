<!-- START_METADATA
---
sidebar_position: 66
title: 2023-02
pagination_next: null
pagination_prev: null
draft: true
---
END_METADATA -->

# Technical newsletter for developers 2023-03

💥 DRAFT! 💥

This newsletter was sent in March 2023.

<!-- START_COMMENT -->

## Table of Contents

* [Is this is the first time you receive this newsletter?](#is-this-is-the-first-time-you-receive-this-newsletter)
* [ePayment API](#epayment-api)
* [More Solutions](#more-solutions)
* [Report API](#report-api)
* [Reminders](#reminders)
  * [Please check your API calls for errors](#please-check-your-api-calls-for-errors)
* [Questions or comments?](#questions-or-comments)

<!-- END_COMMENT -->

## Is this is the first time you receive this newsletter?

Hello! All Vipps customers that have API access now receive this technical
newsletter.

The newsletter is sent 5-10 times a year and contains important updates and
information about our APIs: https://vippsas.github.io/vipps-developer-docs/docs/APIs

Newsletter archive: https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters

(You can unsubscribe if you want - see the link at the bottom)

## ePayment API

We recommend that all new integrations uise the ePayment API, not the eCom API.

The
[ePayment API specification](https://vippsas.github.io/vipps-developer-docs/api/epayment)
has been ready for some time, and now
we have also updated the API guide, FAQ, etc.

See: [ePayment API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/epayment-api).

## More Solutions

You can now see hoiw Vipps APIs can be used and combined to give the best
user experience for vending machinbes, taxis, QR codes, and more.

See: [Solutions](https://vippsas.github.io/vipps-developer-docs/docs/vipps-solutions).

## Report API

The Vipps Report API is now available. It is a REST API providing data about
payments in JSON format. See the
[API documentation](https://vippsas.github.io/vipps-developer-docs/docs/APIs/report-api).

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
