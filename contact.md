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

### Non-technical questions

We offer a wide range of self-service solutions on our portal at [portal.vipps.no](https://portal.vipps.no). We encourage you to check there first to see if your question or issue has already been addressed.

For technical questions and inquiries related to API usage, our *Integration Services* team is available to assist. Please note that most information can be found in our searchable [technical documentation](https://developer.vippsmobilepay.com/search).

For non-technical question, the fastest way to get help is to start in one of the places listed below:

| Questions relating to: | How to get help: |
|--------|----------------|
| General questions (e.g., customer relationship, creating sales units, change of admins) | See [Contact info on vipps.no](https://www.vipps.no/kontakt-oss/). |
| Problems with Vipps services  | Check the status on the [Status pages](./developer-resources/status-pages.md). |
| Applications for Vipps products (status, follow-ups, etc.) | Check the status on [portal.vipps.no](https://portal.vipps.no). |
| Vipps plugins (e.g., WooCommerce, Shopify, Wix, etc.) | Check the support info for your plugin in the [Plugin](https://developer.vippsmobilepay.com/docs/plugins) documentation. |
| Vipps through a partner (for merchants) | Contact your partner. |
| Vipps through a POS (Point of Sale) vendor | Contact your POS vendor. |
| Vipps through a PSP (Payment Service Provider) | Contact your PSP. |
| Partner assistance (for partners) | Check the [Partner](https://developer.vippsmobilepay.com/docs/partner) and [Management API](https://developer.vippsmobilepay.com/docs/APIs/management-api/) documentation. |
| Settlements, invoices or similar | Check the [Settlements](./settlements/README.md) documentation. |
| Suggestions for improvements to [Vipps products](https://www.vipps.no/produkter-og-tjenester/bedrift/)  | Please use [this form](https://www.vipps.no/kontakt-oss/). |

For *technical* issues related to using our APIs, please see the sections below.

## Technical questions

Most information can be found in our searchable [technical documentation](https://developer.vippsmobilepay.com/search).

You can also check the
[Frequently Asked Questions (FAQ)](https://developer.vippsmobilepay.com/docs/faqs).

If you cannot find the answer, please send an email as described below.

### What to include in the email

Please email us at [developer@vippsmobilepay.com](mailto:developer@vippsmobilepay.com)
and include all the following information:

1. **A *detailed* description of the problem with a step-by-step description of what you do and what happens.**
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

**Important:** To ensure a faster response, be sure to provide all the above information.

### Keep your colleagues up to date

To include your colleagues in all the communication for this issue,
add them in the `To:` or `CC:` field of the email.

You can add more recipients to an existing issue by adding them as recipients
to the email, you are sending.

All updates to the issue will be sent to every recipient of the previous email.

### Case number

When you email us, we will create a case and assign a case number. For instance `Case 123456` in
the `Subject` line. This is the unique number for the specific case and is
used to connect all communication about this issue in our systems.

### Adding additional information

If you want to send additional information about the same issue,
please reply to the email, without changing the `Subject` line.

Please remove previous communication when replying to an email, do *not* quote
all the previous messages - we already have them.

### Response time

We will help as quickly as possible, usually in a few hours during normal
working hours.

But, due to large variations in the number of requests and the
varying complexity of resolving them, we cannot guarantee response times.

### Escalation

If you have a Key Account Manager (KAM), please contact them.
If you do not, please reply to the issue and add all relevant information.

### More than one problem, or a new one?

For the fastest response, please send separate emails for each problem.

Including details about new problems into old cases may result in delays.
If you reply to an old issue that has been closed, we will not see the message.

## Can I call you?

We do not have the capacity to help individually by phone.
We require that all the above information is provided in written form.

For partners at [Partner Plus](https://developer.vippsmobilepay.com/docs/partner/partner-level-up/)
level or above,
we may set up a Slack channel to assist with communication.

## Newsletter

Sign up for our [Technical newsletter for developers](./newsletters/README.md) for occasional updates relating to the API platform
or other technical tools.
