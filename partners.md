# Vipps Partners

Document version: 0.0.1.

Vipps partners can represent multiple Vipps merchants, and can make transactions
on behalf of the merchants.

## Partner keys

**Note: This is new functionality currently being rolled out.**

A partner has API keys that also work for all the partner's merchants.
This means that the partner does noe have to manage the API keys for
every merchant: It is sufficient to use the partner's own API keys.
The partner's API keys only work for merchants that are registered
in Vipps as customers of that partner.

# Partner onboarding

A new Vipps partner typically goes through the following steps:

1. The partner finds information on vipps.no, or in a meeting with the Vipps
   partner team.
2. The partner signs up to be Vipps partner, and siges the application
   with BankID. The sign-up is the same as for a regular eCom merchant.
3. In less than 24 hours the partner receives information about how to
   retrieve API keys for the Vipps _test_ environment.
   The development and integration with Vipps can now start.
4. Vipps completes the "Know Your Customer" (KYC) process and other checks
   required by the financial authorities. This can take  a few days, and the
   partner may be contacted for additional information.
5. The partner receives information about how to retrieve API keys for the
   Vipps _production_ environment.

# Integration checklist

TODO: Tidy up!

- [ ] Integrate _all_ the [API endpoints](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#api-endpoints):
    - [ ] Initiate [`POST:/ecomm/v2/payments`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/initiatePaymentV3UsingPOST)
    - [ ] Capture [`POST:/ecomm/v2/payments/{orderId}/capture`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/capturePaymentUsingPOST)
    - [ ] Cancel [`PUT:/ecomm/v2/payments/{orderId}/cancel`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/cancelPaymentRequestUsingPUT)
    - [ ] Refund [`POST:/ecomm/v2/payments/{orderId}/refund`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/refundPaymentUsingPOST)
    - [ ] Details [`GET:/ecomm/v2/payments/{orderId}/details`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/getPaymentDetailsUsingGET)
- [ ] The merchant correctly handles callbacks, both for successful and unsuccessful payments
    - [ ] Callback [`POST:[callbackPrefix]/v2/payments/{orderId}`](https://vippsas.github.io/vipps-ecom-api/#/Endpoints_required_by_Vipps_from_the_merchant/transactionUpdateCallbackForRegularPaymentUsingPOST)
    - [ ] For express checkout only: Shipping details [`POST:[shippingDetailsPrefix]/v2/payments/{orderId}/shippingDetails`](https://vippsas.github.io/vipps-ecom-api/#/Endpoints_required_by_Vipps_from_the_merchant/fetchShippingCostUsingPOST)
    - [ ] For express checkout only: Remove consent [`DELETE:[consetRemovalPrefix]/v2/consents/{userId}`](https://vippsas.github.io/vipps-ecom-api/#/Endpoints_required_by_Vipps_from_the_merchant/removeUserConsentUsingDELETE)
- [ ] Avoid Integration pitfalls
    - [ ] The Partner _must not_ rely on `fallback` or `callback` alone
    - [ ] The Vipps branding must be according to the [Vipps design guidelines](https://github.com/vippsas/vipps-design-guidelines)
- [ ] Integrate [HTTP headers](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api.md#optional-vipps-http-headers) for better tracking (Mandatory for partners and plattforms)
    - [ ] Vipps-System-Name
    - [ ] Vipps-System-Version
    - [ ] Vipps-System-Plugin-Name
    - [ ] Vipps-System-Plugin-Version    

## Flow to go live for direct integrations

1. The partner orders [Vipps på Nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/).
2. Vipps completes customer control (KYC, PEP, AML, etc).
3. The merchant receives an email from Vipps saying that they can log in with bankID on [portal.vipps.no](https://portal.vipps.no) and retrieve API keys.
4. The partner completes all checklist items.
5. The partner [contacts Vipps](https://github.com/vippsas/vipps-developers/blob/master/contact.md) with test IDs (`orderId`) in the [Vipps test environment](https://github.com/vippsas/vipps-developers#the-vipps-test-environment-mt), showing that all checklist items have been fulfilled.
    - A complete order ending in `REFUND` ([`/refund`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/refundPaymentUsingPOST) request).
    - A complete order ending in `VOID` ([`/cancel`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/cancelPaymentRequestUsingPUT) request).
6. The partner receives an email from Vipps saying that the orders are OK.
7. The partner [contacts Vipps](https://github.com/vippsas/vipps-developers/blob/master/contact.md) to verify the integration in the production environment:
    - A complete order ending in `REFUND` ([`/refund`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/refundPaymentUsingPOST) request).
    - For *reserve capture*: A complete order ending in `VOID` ([`/cancel`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/cancelPaymentRequestUsingPUT) request after reserve).
8. The partner goes live 🎉

## Flow to go live for direct integrations for partners

1. The partner becomes a partner by [applying here](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
2. The partner completes the integration, with the API test keys
3. The partner [contacts Vipps](https://github.com/vippsas/vipps-developers/blob/master/contact.md) with test IDs (`orderId`) in the [Vipps test environment](https://github.com/vippsas/vipps-developers#the-vipps-test-environment-mt), showing that all checklist items have been fulfilled.
    - A complete order ending in `REFUND` ([`/refund`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/refundPaymentUsingPOST) request).
    - For *reserve capture*: A complete order ending in `VOID` ([`/cancel`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/cancelPaymentRequestUsingPUT) request after reserve).
4. The partner receives an email from Vipps saying that the implementation is OK.
5. Vipps adds the partner to vipps.no, including the signup forms for merchants.
6. The partner add its merchant to their solution.
7. The Merchant goes live 🎉
