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

TODO
