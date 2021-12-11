# How to contact Vipps Integration

Hello! We can help!

- [We help with technical issues](#we-help-with-technical-issues)
- [What to include in the email](#what-to-include-in-the-email)
- [Can I call you?](#can-i-call-you)
- [Can we have a meeting?](#can-we-have-a-meeting)
- [Keep your colleagues up to date](#keep-your-colleagues-up-to-date)
- [Automatic reply](#automatic-reply)
- [Adding additional information](#adding-additional-information)
- [Response time](#response-time)
- [Escalation](#escalation)
- [More than one problem, or a new one?](#more-than-one-problem-or-a-new-one)
- [Newsletter](#newsletter)

Document version: 2.4.7.

## We help with technical issues

Vipps Integration helps with _**technical**_ questions from developers, such as questions about using our APIs.
If you do not have a technical issue, the fastest way to get help is to start in the right place:

| Topic                                      | How to get help                             |
| ------------------------------------------ | ------------------------------------------- |
| General questions, including the (new) customer relationship,
creating sale units, change of admins, etc   | [Contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/) |
| Applications for Vipps products | [Contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/) |
| Using Vipps through a partner (for merchants) | [Contact your partner directly](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-3) |
| Vipps through a PSP (Payment Service Provider) | Please contact your PSP. |
| Partner assistance (for partners) | See [Vipps partner](https://github.com/vippsas/vipps-partner).  |
| Vipps plugins (WooCommerce, WordPress, Wix,
  Shopify, Magento, EPiServer, etc)| [Plugin overview](https://github.com/vippsas/vipps-plugins) |
| Vipps through a POS (Point of Sale) vendor | Please contact your vendor. |
| Settlements, invoices or similar | [Settlements](https://github.com/vippsas/vipps-developers/tree/master/settlements) |
| Suggestions for improvements to [Vipps products](https://www.vipps.no/produkter-og-tjenester/bedrift/) | [Use this form](https://www.vipps.no/kontakt-oss/bedrift/) |
| BankID | [BankID service portal](https://servicedesk.bankidnorge.no/jira/servicedesk/customer/user/login?destination=portals) |

For _**technical**_ issues related to Vipps and development of services using our APIs: Please see below.

We also have a technical newsletter for developers:
[Sign up and access the archives here](https://github.com/vippsas/vipps-developers/tree/master/newsletters) (low volume, no marketing).

## What to include in the email

First of all: It's nice if you can check the FAQs and search to check if your problem is a common one:
* [eCom API FAQ](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md)
* [Recurring API FAQ](https://github.com/vippsas/vipps-recurring-api/blob/master/vipps-recurring-api-faq.md)
* [Login API FAQ](https://github.com/vippsas/vipps-login-api/blob/master/vipps-login-api-faq.md)

If it's not: Please send an email with all relevant information to the address below:

* **Please: Always include a _detailed_ description of the problem**
* A concise, self-explanatory `Subject` line, such as "`POST:/something` gives `HTTP 400` response".
* Company details
  - Organization number (find yours at [Brønnøysundregistrene](https://brreg.no))
  - Merchant Serial Number (MSN, see [Getting started](vipps-developer-portal-getting-started.md))
* Is it a problem in the Test (MT) or the Production environment?
* On which date did the problem occur?
* Include `orderId`, and preferably also `transactionId` and `contextId`, to make it possible to search in logs.
* If you are a new Vipps customer, please include details about when and how you ordered Vipps.
* Which [Vipps product](https://www.vipps.no/produkter-og-tjenester/bedrift/) or [Vipps API](https://github.com/vippsas) this is about.
* For API issues: Complete `request` and `response` details (plain HTTP from Postman, or [curl](https://curl.haxx.se) ensures the quickest response).
* Please provide screenshots, if possible.
* For app issues: Specify iOS or Android, and the app version - and have a look at the
  [standard reply for app problems](https://github.com/vippsas/vipps-developers/blob/master/housekeeping/response-app-error-en.txt).
* Please provide your contact information (if not in your email signature):
  - Name
  - Phone number
* Please include any other information that may be relevant or possibly helpful.

The Integration email address is: integration@vipps.no

## Can I call you?

Nope. We do not have a phone number for Integration, and we do not have the capacity to
help 1:1 on phone, sorry. Most cases involve information that needs to be in written form,
such as ids, API requests/responses, etc. We do sometimes set up Slack channels for
customers, so you can request that if you expect to be contacting us a lot.

## Can we have a meeting?

Nope. See: [Can I call you?](#can-i-call-you)

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
of requests and the varying complexity of resolving them, we can not guarantee response times.

## Escalation

If you have a KAM (Key Account Manager), please contact her/him.
If you do not, please reply to the issue, and add any relevant information.
Please note that we understand that your problem is important to you, but that Vipps must sometimes prioritize differently.

## More than one problem, or a new one?

Please send separate emails for each problem. If you send an email about a
new problem by replying to an old issue, it may delay our response.

## Newsletter

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
