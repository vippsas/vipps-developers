---
title: API dashboard
sidebar_position: 110
pagination_next: null
pagination_prev: null
---

# API dashboard

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/).
<!-- END_COMMENT -->

All merchants have access to an API dashboard on
[portal.vipps.no](https://portal.vipps.no) in the *Utvikler* section.

The API dashboard shows information about your API usage, an overview of errors, etc.
Think of the API dashboard as a "health check" that you can use to see if there
are any problems you need to investigate.

Here's an example for one endpoint, showing that 2.95 % of the API requests
for
[`POST:/ecomm/v2/payments/{orderId}/refund`](https://developer.vippsmobilepay.com/api/ecom#tag/Vipps-eCom-API/operation/refundPaymentUsingPOST)
fail:

![API dashboard](../images/api-dashboard-example.png)

The API dashboard is available for both the production and
[test environment](https://developer.vippsmobilepay.com/docs/test-environment),
and is an easy way to see if you are using the APIs correctly.
It only gives a high-level overview, so you must check the actual API
responses for more details about the errors.

**Important:** For every API request that has failed, and for every error shown on the API dashboard,
you have already received a detailed error message, as described on
[Errors](https://developer.vippsmobilepay.com/docs/common-topics/errors).
We do not have the capacity to manually check our logs and re-send the same error details.

From the
[eCom API checklist](https://developer.vippsmobilepay.com/docs/APIs/ecom-api/vipps-ecom-api-checklist):

> Make sure to log and handle all errors. All integrations should to display
> errors in a way that the user can see and understand them.

It is your responsibility to check that you are using the APIs correctly.

**Please note:**

* The API dashboard is not real-time, and events might take up to 10 minutes before they appear.
* Partners can ask their merchants to provide access to the
  sales unit(s) for whom they are making payments; therefore, the partner can use the
  API dashboard. There is a guide here:
  [How to add a user on the portal](https://developer.vippsmobilepay.com/docs/partner/add-portal-user)  
* Keep in mind that the *Utvikler* section is only available to users with *admin* or *developer* roles.
