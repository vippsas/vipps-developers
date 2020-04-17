# How to contact Vipps Integration

Hello! 👋 We love email!

## Table of contents

- [How to contact Vipps Integration](#how-to-contact-vipps-integration)
  - [Table of contents](#table-of-contents)
  - [We help with technical issues](#we-help-with-technical-issues)
  - [What to include in the email](#what-to-include-in-the-email)
    - [Keep your colleagues up to date](#keep-your-colleagues-up-to-date)
  - [Automatic reply](#automatic-reply)
    - [Adding additional information](#adding-additional-information)
  - [Response time](#response-time)
  - [More than one problem, or a new one?](#more-than-one-problem-or-a-new-one)

## We help with technical issues

We help with _**technical**_ issues from developers, such as questions about using our APIs. 
If you do not have a technical issue, the fastest way to get help is to use the right method:

* General questions: See the [contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/)
* Questions about applications for Vipps products: See the [contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/)
* Suggestions for improvements to Vipps products: Use [this form](https://www.vipps.no/kontakt-oss/bedrift/).
* Vipps through a partner: Please [contact your partner directly](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/#kom-i-gang-med-vipps-pa-nett-category-3). 
* Questions about _ordering_ Vipps through a partner (also for partners): partnerbestilling@vipps.no
* If you have questions about the plugins, the best way to get help is from the plugin developers directly:
  - WooCommerce: Please use [the support forum on wordpress.org](https://wordpress.org/support/plugin/woo-vipps/).
  - Magento: Please [submit an issue on GitHub](https://github.com/vippsas/vipps-magento).
  - Drupal: Please see [the plugin on drupal.org](https://www.drupal.org/project/commerce_vipps).
  - Episerver: TBD (not yet officially released).
  - Shopify: TBD (not yet officially released).
* Questions about settlements, invoices or similar: operations@vipps.no

We also have a technical newsletter for developers:
[Sign up here](https://cloud.hei.vipps.no/utv) (low volume, no marketing).

## What to include in the email

So, for _*technical questions*_: Send an email with all relevant information to the address below:

* A concise, self-explanatory `Subject` line, such as "`POST:/something` gives `HTTP 400` response".
* Your contact information (if not in your email signature):
  - Name
  - Phone number
* Company details
  - Organization number (check https://brreg.no)
  - Merchant Serial Number (MSN, see [Getting started](vipps-developer-portal-getting-started.md))
* Which [Vipps product](https://www.vipps.no/bedrift) this is about
* If you are a new Vipps customer, please include detailas about when and how you ordered Vipps. For status on the order, please see the [contact info for companies on vipps.no](https://www.vipps.no/kontakt-oss/bedrift/)
* For eCommerce issues: Which eCommerce solution you are using, and which version
  - For WooCommerce: See the [support forum](https://wordpress.org/support/plugin/woo-vipps) and https://github.com/vippsas/vipps-woocommerce
  - For Magento: See https://github.com/vippsas/vipps-magento
* **Always include a detailed description of the problem**
* For API issues: Complete `request` and `response` details (plain HTTP from Postman, or [curl](https://curl.haxx.se) ensures the quickest response)
* Include `orderID`, `transactionId`and `contextId` to make it posible to search in logs.
* For app issues: Specify iOS or Android, and the app version
* Screenshots, if applicable
* Any other information that may be relevant

The Integration email address is: integration@vipps.no 

(You can also [try the web interface](https://vippsas.atlassian.net/servicedesk/customer/portal/2))

### Keep your colleagues up to date

If you want colleagues to be included in all communication regarding this issue,
add them in the `To:` or `CC:` field of the email. Any updates to the issue will be
sent to all email addresses in the original email.

## Automatic reply

You will get an auto-reply from us with an issue number like `VSD-12345` in the `Subject` line.
This is the unique number for this specific issue, and is used to connect all communication
about this issue in our systems.

The auto-reply is sent from a real e-mail address, which you can reply to ✌️

### Adding additional information

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
