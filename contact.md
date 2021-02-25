# How to contact Vipps Integration

Hello! 👋 We love email!

- [We help with technical issues](#we-help-with-technical-issues)
- [What to include in the email](#what-to-include-in-the-email)
- [Can I call you?](#can-i-call-you)
- [Keep your colleagues up to date](#keep-your-colleagues-up-to-date)
- [Automatic reply](#automatic-reply)
- [Adding additional information](#adding-additional-information)
- [Response time](#response-time)
- [Escalation](#escalation)
- [More than one problem, or a new one?](#more-than-one-problem-or-a-new-one)
- [Newsletter](#newsletter)

Document version: 2.3.3.

## We help with technical issues

We help with _**technical**_ issues from developers, such as questions about using our APIs.
If you do not have a technical issue, the fastest way to get help is to start in the right place:

| Topic               | How to get help |
| ------------------- | --------------- |
| General questions, including the (new) customer relationship, creating sale units, change of admins, etc   | Please see the [contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/) |
| Applications for Vipps products | Please see the [contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/) |
| Using Vipps through a partner (for merchants) | Please [contact your partner directly](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-3) |
| Partner assistance (for partners) | Please contact partnerbestilling@vipps.no  |
| Vipps plugins (WooCommerce, WordPress, Magento, Drupal, Shopify, etc)| Please see the [plugin overview](https://github.com/vippsas/vipps-plugins) |
| Settlements, invoices or similar | Please see [Settlements](https://github.com/vippsas/vipps-developers/tree/master/settlements) |
| Suggestions for improvements to [Vipps products](https://www.vipps.no/produkter-og-tjenester/bedrift/) | Please use [this form](https://www.vipps.no/kontakt-oss/bedrift/) |
| BankID | Use the [BankID service portal](https://servicedesk.bankidnorge.no/jira/servicedesk/customer/user/login?destination=portals) |

For _**technical**_ issues: Please see below.

We also have a technical newsletter for developers:
[Sign up here](https://github.com/vippsas/vipps-developers/tree/master/newsletters) (low volume, no marketing).

## What to include in the email

Please send an email with all relevant information to the address below:

* It's nice if you can check the
  [eCom API FAQ](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md)
  and search to check if your problem is a common one.
* **Please: Always include a _detailed_ description of the problem**
* A concise, self-explanatory `Subject` line, such as "`POST:/something` gives `HTTP 400` response".
* Company details
  - Organization number (find your at https://brreg.no)
  - Merchant Serial Number (MSN, see [Getting started](vipps-developer-portal-getting-started.md))
* Is it a problem in the Test (MT) or the Production environment?
* On which date did the problem occur?
* Include `orderId`, and preferrably also `transactionId` and `contextId`, to make it possible to search in logs.
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

(You can also [use the web interface](https://vippsas.atlassian.net/servicedesk/customer/portal/2))

## Can I call you?

No, we do not have a phone number for Integration, and we do not have the capacity to
help 1:1 on phone, sorry. Most cases involve information that needs to be in written form,
such as ids, API requests/responses, etc. We do sometimes set up Slack channels for
customers, so you can request that if you expect to be contacting us a lot.

## Keep your colleagues up to date

If you want colleagues to be included in all communication regarding this issue,
add them in the `To:` or `CC:` field of the email. Any updates to the issue will be
sent to all email addresses in the original email.

## Automatic reply

You will get an auto-reply from us with an issue number like `VSD-12345` in the `Subject` line.
This is the unique number for this specific issue, and is used to connect all communication
about this issue in our systems.

The auto-reply is sent from a real e-mail address, which you can reply to ✌️

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
If you do not, plese reply to the issue, and add any relevant information.
Please note that everyone thinks that their problem is the most important to solve,
but that Vipps must sometimes prioritize differently.

## More than one problem, or a new one?

Please send separate emails for each problem. If you send an email about a
new problem by replying to an old issue, it may delay our response.

## Newsletter

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
