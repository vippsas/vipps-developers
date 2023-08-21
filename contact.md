---
sidebar_position: 210
pagination_next: null
pagination_prev: null
---

# Contact us

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/contact/).
<!-- END_COMMENT -->

## MobilePay support

While we work to bring together the best features of both Vipps and MobilePay platforms, some information is still under development and will be updated soon.

For those in need of assistance with MobilePay, we recommend checking out the [MobilePay Developer Support page](https://developer.mobilepay.dk/docs/support). Here, users can find a wealth of information and resources to help navigate the platform and troubleshoot any issues that may arise.

## Vipps support

### We help developers with technical issues

We offer a wide range of self-service solutions on our portal at [portal.vipps.no](https://portal.vipps.no). We encourage you to check there first to see if your question or issue has already been addressed.

For technical questions and inquiries related to API usage, our Integration Services team is available to assist. Please note that almost all requests we receive are already covered in our searchable technical documentation, which can be found at [searchable technical documentation](https://developer.vippsmobilepay.com/search).

To avoid any delays in receiving support, we recommend that users with non-technical questions or inquiries start in the appropriate place:

| Topic | How to get help |
|--------|----------------|
| General questions (including the customer relationship, creating sales units, change of admins, etc.) | See: [Contact info on vipps.no](https://www.vipps.no/kontakt-oss/). |
| Problems with Vipps services  | See: [Status pages](./developer-resources/status-pages.md). |
| Applications for Vipps products (status, follow-ups, etc.) | Check the status on [portal.vipps.no](https://portal.vipps.no). |
| Vipps plugins (WooCommerce, Shopify, Wix, WordPress, Wix, Shopify, Magento, EPiServer, etc.)         | See the support info for your plugin: [Plugin overview](https://developer.vippsmobilepay.com/docs/plugins). |
| Vipps through a partner (for merchants) | Please contact your partner. |
| Vipps through a POS (Point of Sale) vendor | Please contact your POS vendor. |
| Vipps through a PSP (Payment Service Provider) | Please contact your PSP. |
| Partner assistance (for partners) | See: [Partners](https://developer.vippsmobilepay.com/docs/partner) and the [Management API](https://developer.vippsmobilepay.com/docs/APIs/management-api/). |
| Settlements, invoices or similar | See: [Settlements](./settlements/README.md). |
| Suggestions for improvements to [Vipps products](https://www.vipps.no/produkter-og-tjenester/bedrift/)  | Please use [this form](https://www.vipps.no/kontakt-oss/). |

For *technical* issues related to Vipps and the development of services using our APIs, please see the sections below.

### Almost all questions are answered in the documentation

Please check the
[Frequently Asked Questions (FAQ)](https://developer.vippsmobilepay.com/docs/faqs).

Please use the
[search functionality for the technical documentation](https://developer.vippsmobilepay.com/search).

### What to include in the email

If you cannot find the answer: Please send an email with all relevant
information to the address below:

1. **Please: Always include a *detailed* description of the problem with a step-by-step description of what you do and what happens.**
2. A concise, self-explanatory `Subject` line, such as "`POST:/something` gives `HTTP 400` response".
3. Company details: Organization number (find yours at [Brønnøysundregistrene](https://brreg.no))
4. Merchant Serial Number (MSN), found on [portal.vipps.no](https://portal.vipps.no).
   See the
   [Vipps portal](https://developer.vippsmobilepay.com/docs/developer-resources/portal).
5. Which
   [Vipps product](https://www.vipps.no/produkter-og-tjenester/bedrift/)
   or
   [Vipps API](https://developer.vippsmobilepay.com/docs/APIs)
   is this about?
6. Environment: Is it a problem in the Test (MT) or the Production environment?
7. Include `orderId`, and preferably also `transactionId` and `contextId`, to make it possible to search in logs.
8. Date: On which date(s) did the problem occur?
9. For API issues: We need a complete `request` and `response`.
   Plain HTTP from Postman ensures the quickest response.
   No source code, please.
   **Important:** Remove everything except the last four characters from
   `client_secret` and `Ocp-Apim-Subscription-Key`.
10. Please provide screenshots, if possible.
11. Please provide your contact information (if not in your email signature): Name and phone number
12. Please include any other information that may be relevant or possibly helpful.

**Important:** If you do not provide enough information, our first reply will
be a request for more details, which will of course cause delays.

The Integration Services email address is [developer@vippsmobilepay.com](mailto:developer@vippsmobilepay.com).
If you add your colleagues on CC they will get all updates too.

### Keep your colleagues up to date

If you want colleagues to be included in all communication regarding this issue,
add them in the `To:` or `CC:` field of the email.

You can add more recipients to an existing issue by adding them as recipients
to the email, you are sending.

All updates to the issue will be sent to every recipient of the previous email.

### Automatic reply

You will get an auto-reply from us with an issue number like `VSD-123456` in
the `Subject` line. This is the unique number for this specific issue and is
used to connect all communication about this issue in our systems.

The auto-reply is sent from a real e-mail address, which you can reply to.

### Adding additional information

If you want to send additional information about the same issue,
please reply to the email, without changing the `Subject` line.

Please remove previous communication when replying to an email, do *not* quote
all the previous messages - we already have them.

### Response time

We will help as quickly as possible, usually in a few hours during normal
working hours.

But: Due to large variations in the number of requests and the
varying complexity of resolving them, we cannot guarantee response times.

### Escalation

If you have a KAM (Key Account Manager), please contact her/him.
If you do not, please reply to the issue, and add any relevant information.
Please note that we understand that your problem is important to you,
but that we must sometimes prioritize differently.

## More than one problem, or a new one?

Please send separate emails for each problem. If you send an email about a
new problem by replying to an old issue, it may delay our response.
If you reply to an old issue that has been closed, we will not see the reply.

### Can I call you?

We do not have a phone number, and we do not have the capacity to
help 1:1 on the phone. Most cases involve information that needs to be in written form,
such as IDs, API requests/responses, etc.

We do sometimes set up Slack channels for customers, depending on the [Partner level](https://developer.vippsmobilepay.com/docs/partner/partner-level-up/).

### Newsletter

Sign up for our [Technical newsletter for developers](./newsletters/README.md).
