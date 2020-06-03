# How to contact Vipps Integration

Hello! 👋 We love email!

- [We help with technical issues](#we-help-with-technical-issues)
- [What to include in the email](#what-to-include-in-the-email)
- [Keep your colleagues up to date](#keep-your-colleagues-up-to-date)
- [Automatic reply](#automatic-reply)
- [Adding additional information](#adding-additional-information)
- [Response time](#response-time)
- [More than one problem, or a new one?](#more-than-one-problem-or-a-new-one)
- [Newsletter](#newsletter)

Document version: 2.2.0.

## We help with technical issues

We help with _**technical**_ issues from developers, such as questions about using our APIs.
If you do not have a technical issue, the fastest way to get help is to use the right method:

| Topic               | How to get help |
| ------------------- | --------------- |
| General questions, including changes to the customer relationship, creating eCom sale units, change of admins, etc   | Please see the [contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/) |
| Applications for Vipps products | Please see the [contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/) |
| VippsGO | Please see the self-service portal:  https://vippsadmin.snappo.com/. For questions about POS (Point Of Sale) integrations: Please contact your POS vendor. For other issues, please see the [contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/)  |
| Suggestions for improvements to [Vipps products](https://www.vipps.no/produkter-og-tjenester/bedrift/) | Please use [this form](https://www.vipps.no/kontakt-oss/bedrift/) |
| Using Vipps through a partner | Please [contact your partner directly](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-3) |
| Ordering Vipps through a partner | Please contact partnerbestilling@vipps.no |
| If you are a partner and need help | Please contact partnerbestilling@vipps.no  |
| Vipps for [WooCommerce](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/woocommerce/) | Please use [the support forum on wordpress.org](https://wordpress.org/support/plugin/woo-vipps/) |
| Vipps Payment modules for [Magento](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/magento/) | Please contact vipps@vaimo.no or submit an issue on GitHub [for Magento 2](https://github.com/vippsas/vipps-magento) or for [for Magento 1](https://github.com/vippsas/vipps-magento-v1)|
| Vipps Login for [Magento 2](https://marketplace.magento.com/vipps-module-login.html) | Please contact vipps@vaimo.no or [submit an issue on GitHub](https://github.com/vippsas/vipps-login-magento) |
| Vipps for [Drupal](https://www.drupal.org/project/commerce_vipps) | Please see [the plugin on drupal.org](https://www.drupal.org/project/commerce_vipps) |
| Vipps for [Episerver](https://github.com/vippsas/vipps-episerver) | Please [submit an issue on GitHub](https://github.com/vippsas/vipps-episerver) |
| Vipps for [Shopify](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/shopify/) | For the plugin, not Shopify itself: Please [submit an issue on GitHub](https://github.com/vippsas/vipps-shopify) |
| [Settlements](https://github.com/vippsas/vipps-developers/tree/master/settlements), invoices or similar | Please see [Settlements](https://github.com/vippsas/vipps-developers/tree/master/settlements) |

For _**technical**_ issues: Please see below.

We also have a technical newsletter for developers:
[Sign up here](https://cloud.hei.vipps.no/utv) (low volume, no marketing).

## What to include in the email

Please send an email with all relevant information to the address below:

* **Please: Always include a _detailed_ description of the problem**
* A concise, self-explanatory `Subject` line, such as "`POST:/something` gives `HTTP 400` response".
* Company details
  - Organization number (find your at https://brreg.no)
  - Merchant Serial Number (MSN, see [Getting started](vipps-developer-portal-getting-started.md))
* Is it a problem in the Test (MT) or the Production environment?
* Include `orderId`, `transactionId` and `contextId` to make it possible to search in logs.
* If you are a new Vipps customer, please include details about when and how you ordered Vipps.
* Which [Vipps product](https://www.vipps.no/produkter-og-tjenester/bedrift/) or [Vipps API](https://github.com/vippsas) this is about.
* For API issues: Complete `request` and `response` details (plain HTTP from Postman, or [curl](https://curl.haxx.se) ensures the quickest response)
* For app issues: Specify iOS or Android, and the app version
* Please provide screenshots, if applicable
* Please provide your contact information (if not in your email signature):
  - Name
  - Phone number
* Please include any other information that may be relevant or possibly helpful.

The Integration email address is: integration@vipps.no

(You can also [use the web interface](https://vippsas.atlassian.net/servicedesk/customer/portal/2))

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

## More than one problem, or a new one?

Please send separate emails for each problem. If you send an email about a
new problem by replying to an old issue, it may delay our response.

## Newsletter

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
