<!-- START_METADATA
---
title: API Dashboard
sidebar_position: 10
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# API Dashboard

All merchants have access to an API Dashboard on
[portal.vipps.no](https://portal.vipps.no) under the "Utvikler" tab.

The API Dashboard shows information about your API usage, an overview of errors, etc.
Think of the API Dashboard as a "health check" that you can use to see if there
are any problems you need to investigate.

Here's an example for one endpoint, showing that 2.95 % of the API requests
for
[`POST:/ecomm/v2/payments/{orderId}/refund`](https://vippsas.github.io/vipps-developer-docs/api/ecom#tag/Vipps-eCom-API/operation/refundPaymentUsingPOST)
fail:

![API Dashboard](../images/api-dashboard-example.png)

The API Dashboard is available for both the production and
[test environment](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/test-environment),
and is an easy way to see if you are using the Vipps APIs correctly.
It only gives a high-level overview, so you must check the actual API
responses for more details about the errors.

For every error shown on the API Dashboard you have already received a
detailed error message, as described on
[Errors](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/common-topics/errors).

From the
[eCom API checklist](https://vippsas.github.io/vipps-developer-docs/docs/APIs/ecom-api/vipps-ecom-api-checklist):

> Make sure to log and handle all errors. All integrations should to display
> errors in a way that the user can see and understand them.

It is your responsibility to check that you are using the Vipps APIs correctly,
and we do not have the capacity to manually check our logs for errors on your behalf.

**Please note:**
* The API dashboard is not real-time, and events might take up to
  10 minutes before they appear.
* Partners can ask their merchants to give them access to the
  sale unit(s) the partner is making payments for, so the partner can use the
  API Dashboard. There is a guide here:
  [How to add a user on portal.vipps.no](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/add-portal-user)  
* Keep in mind that the "Utvikler" tab is only available to users with admin or
  developer roles.
