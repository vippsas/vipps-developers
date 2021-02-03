# Vipps Partners

💥 Work in progress! 💥

Vipps partners can represent multiple Vipps merchants, and can make transactions
on behalf of the merchants.

Document version: 0.10.0.

## Partner keys

**Note: This is new functionality currently being implemented.**

A partner has API keys that also work for all the partner's merchants.
This means that the partner does noe have to manage the API keys for
every merchant: It is sufficient to use the partner's own API keys.

The partner's API keys only work for merchants that are registered
in Vipps as customers of that partner.

## Onboarding

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

## Integration checklist

Partners should use the standard
[eCom API checklist](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-checklist.md).

In addition:
- [ ] As a partner you accept the [Partner terms and conditions](https://github.com/vippsas/vipps-developers/blob/master/partners/partnerterms.md)

## Flow to go live for direct integrations for partners

1. The partner becomes a partner by
   [applying here](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-i-butikk/vipps-i-kassa/#kom-i-gang-med-vipps-i-kassa-category-3).
2. The partner completes the integration, with the API test keys.
3. The partner
   [contacts Vipps](https://github.com/vippsas/vipps-developers/blob/master/contact.md)
   with test IDs (`orderId`) in the
   [Vipps test environment](https://github.com/vippsas/vipps-developers#the-vipps-test-environment-mt),
   showing that all checklist items have been completed:
    - A complete order ending in `REFUND`
      ([`/refund`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/refundPaymentUsingPOST)
      request).
    - For *reserve capture* (not "direct capture"): A complete order ending in `VOID`
      ([`/cancel`](https://vippsas.github.io/vipps-ecom-api/#/Vipps%20eCom%20API/cancelPaymentRequestUsingPUT)
      request after reserve).
    - We recommend checking this using both the API itself and the API Dashboard available under "Utvikler" on
      [portal.vipps.no](https://portal.vipps.no).
4. The partner receives an email from Vipps saying that the implementation is OK.
5. Vipps adds the partner to vipps.no, including the signup forms for merchants.
6. The partner add its merchant to their solution, usually by configuring the POS with the merchant's API keys.
7. The Merchant goes live 🎉

**Please note:** For POS integrations that can not display the Vipps
landing page, it is important that all sale units are configured with
`skipLandingPage`. See the
[Frequently Asked Questions for POS integrations](https://github.com/vippsas/vipps-ecom-api/blob/master/vipps-ecom-api-faq.md#frequently-asked-questions-for-pos-integrations).

## Flow to go live for new merchants

1. The merchant signs up for
   [Vipps på Nett](https://www.vipps.no/produkter-og-tjenester/bedrift/ta-betalt-paa-nett/ta-betalt-paa-nett/)
   and selects the partner in the form.
2. Vipps completes customer control (KYC, PEP, AML, etc).
3. Merchant keys are available for the merchant on
   [portal.vipps.no](https://portal.vipps.no),
   or sent directly to partner if the
   [Signup API](https://github.com/vippsas/vipps-signup-api)
   is implemented.
   Using the Signup API speeds up customer control and API key distribution.

## Partner terms and conditions

As a partner you accept the
[Partner terms and conditions](https://github.com/vippsas/vipps-developers/blob/master/partners/partner-terms.md).

## Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-developers/issues),
a [pull request](https://github.com/vippsas/vipps-developers/pulls),
or contact us by email: partnerbestilling@vipps.no.

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
