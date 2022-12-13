<!-- START_METADATA
---
title: Contact us
sidebar_position: 100
---
END_METADATA -->

# How to contact Vipps Integration

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

<!-- START_TOC -->

* [We help with technical issues](#we-help-with-technical-issues)
* [What to include in the email](#what-to-include-in-the-email)
* [Keep your colleagues up to date](#keep-your-colleagues-up-to-date)
* [Automatic reply](#automatic-reply)
* [Adding additional information](#adding-additional-information)
* [Response time](#response-time)
* [Escalation](#escalation)
* [More than one problem, or a new one?](#more-than-one-problem-or-a-new-one)
* [Can I call you?](#can-i-call-you)
* [Can we have a meeting?](#can-we-have-a-meeting)
* [Newsletter](#newsletter)

<!-- END_TOC -->

## We help with technical issues

There are a lot of self-service solutions on
[portal.vipps.no](https://portal.vipps.no),
please check there first.

Vipps Integration helps with _**technical**_ questions from developers, such as questions about using our APIs.
If you do not have a technical issue, the fastest way to get help is to start in the right place:

| Topic | How to get help |
|--------|----------------|
| General questions (including the customer relationship, creating sale units, change of admins, etc) | See: [Contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/). |
| "Are there any problems?"  | See: [Status pages](./developer-resources/status-pages). |
| Applications for Vipps products (status, follow-ups, etc) | Check the status on [portal.vipps.no](https://portal.vipps.no). |
| Vipps plugins (WooCommerce, Shopify, Wix, WordPress, Wix, Shopify, Magento, EPiServer, etc)         | See the support info for your plugin: [Plugin overview](https://vippsas.github.io/vipps-developer-docs/docs/vipps-plugins/). |
| Vipps through a partner (for merchants) | Please contact your partner. |
| Vipps through a POS (Point of Sale) vendor | Please contact your POS vendor. |
| Vipps through a PSP (Payment Service Provider) | Please contact your PSP. |
| Partner assistance (for partners) | See: [Vipps Partners](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/) and the [Partner API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/partner-api). |
| Settlements, invoices or similar | See: [Settlements](./settlements/README.md). |
| Suggestions for improvements to [Vipps products](https://www.vipps.no/produkter-og-tjenester/bedrift/)  | Please use [this form](https://www.vipps.no/kontakt-oss/bedrift/). |

For _**technical**_ issues related to Vipps and development of services using our APIs: Please see below.

## What to include in the email

**Important:** Almost all requests we get are already covered in the technical documentation.
Please check the FAQs (Frequently Asked Questions) for the
[Vipps API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/)
you are using, and use the
[search functionality for the technical documentation](https://vippsas.github.io/vipps-developer-docs/search).

If you cannot find the answer: Please send an email with all relevant information to the address below:

1. **Please: Always include a _detailed_ description of the problem with a step-by-step description of what you do and what happens.**
2. A concise, self-explanatory `Subject` line, such as "`POST:/something` gives `HTTP 400` response".
3. Company details: Organization number (find yours at [Brønnøysundregistrene](https://brreg.no))
4. Merchant Serial Number (MSN, see [Getting started](vipps-getting-started.md))
5. Which [Vipps product](https://www.vipps.no/produkter-og-tjenester/bedrift/) or [Vipps API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/) this is about.
6. Environment: Is it a problem in the Test (MT) or the Production environment?
7. Include `orderId`, and preferably also `transactionId` and `contextId`, to make it possible to search in logs.
8. Date: On which date did the problem occur?
9. For API issues: We need a complete `request` and `response`.
   Plain HTTP from Postman ensures the quickest response.
   No source code, please.
   **Important:** Remove everything except the last four characters from
   `client_secret`and `Ocp-Apim-Subscription-Key`.
10. Please provide screenshots, if possible.
11. Please provide your contact information (if not in your email signature): Name and phone number
12. Please include any other information that may be relevant or possibly helpful.

The Integration email address is: integration@vipps.no

We also have a technical newsletter for developers:
[Sign up and access the archives here](./newsletters/README.md)
(low volume, no marketing).

## Keep your colleagues up to date

If you want colleagues to be included in all communication regarding this issue,
add them in the `To:` or `CC:` field of the email. Any updates to the issue will be
sent to all email addresses in the original email.

## Automatic reply

You will get an auto-reply from us with an issue number like `VSD-12345` in the `Subject` line.
This is the unique number for this specific issue, and is used to connect all communication
about this issue in our systems.

The auto-reply is sent from a real e-mail address, which you can reply to.

## Adding additional information

If you want to send additional information about the same issue,
please reply to the email, without changing the `Subject` line.

Please remove previous communication when replying to an email, do _not_ quote
all the previous messages - we already have them.

## Response time

We will help as quickly as possible, but due to large variations in the number
of requests and the varying complexity of resolving them, we cannot guarantee response times.

## Escalation

If you have a KAM (Key Account Manager), please contact her/him.
If you do not, please reply to the issue, and add any relevant information.
Please note that we understand that your problem is important to you,
but that Vipps must sometimes prioritize differently.

## More than one problem, or a new one?

Please send separate emails for each problem. If you send an email about a
new problem by replying to an old issue, it may delay our response.

## Can I call you?

Nope. We do not have a phone number for Integration, and we do not have the capacity to
help 1:1 on phone. Most cases involve information that needs to be in written form,
such as ids, API requests/responses, etc. We do sometimes set up Slack channels for
customers, so you can request that if you expect to be contacting us a lot.

## Can we have a meeting?

Nope. See: [Can I call you?](#can-i-call-you)

## Newsletter

Sign up for our [Technical newsletter for developers](./newsletters/README.md).
