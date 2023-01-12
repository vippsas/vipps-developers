<!-- START_METADATA
---
title: Vipps portal
sidebar_position: 40
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# The Vipps portal

<!-- START_COMMENT -->

ℹ️ Please use the new documentation:
[Vipps Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

## Table of contents

* [How to find the API keys](#how-to-find-the-api-keys)
* [How to regenerate API keys](#how-to-regenerate-api-keys)
* [How to create a test sales unit](#how-to-create-a-test-sales-unit)
* [How to create additional users on portal.vipps.no](#how-to-create-additional-users-on-portalvippsno)
* [Permissions and users](#permissions-and-users)
* [Questions](#questions)

<!-- END_COMMENT -->

This page will guide you through the steps to finding API keys and creating test sales units
on the [Vipps portal (portal.vipps.no)](https://portal.vipps.no).

For more information about the portal, see the
[help pages on vipps.no (in Norwegian)](https://vipps.no/hjelp/vipps/kundeforholdet-mitt/hva-får-jeg-tilgang-til-når-jeg-logger-meg-inn-på-vippsportalen/).

## How to find the API keys

1. Log in to [portal.vipps.no](https://portal.vipps.no) using BankID.
    * If you have problems, see [Permissions and users](#permissions-and-users).
1. Select _Vipps På Nett_ > _Utvikler_.
   In the page that opens, you will see a table with many sales units listed.
   ![portal.vipps.no: The API products for a sales unit](../images/portalvippsno-salesunit-products.png)
   Hover over the `i` in the column heading for additional information.
1. Select either _production keys_ and/or _test keys_, depending on the type of keys you need.
1. Find your desired sales unit.
   * If you need to create your own test sales unit, click _Add test sales unit_ and fill out the form.
     See [create a new test sales unit](#how-to-create-a-test-sales-unit) for more details.
1. Click the _Show keys_ button corresponding to your sales desired unit.
   The API keys will be displayed.
   **Please note:** You can only see API keys that you have access to. All others will be hidden.
   ![portal.vipps.no: The API keys for a sales unit](../images/portalvippsno-salesunit-keys.png)

💥 **Use caution with storing and transferring API keys** 💥

* Do _not_ send API keys unencrypted by email.
* If you accidentally share your API keys, you must [generate new ones](#how-to-regenerate-api-keys).

See [API keys](../common-topics/api-keys.md) for more details.

## How to regenerate API keys

Follow the steps from [Finding the API keys](#how-to-find-the-api-keys).
In the window where your keys are shown, click the _regenerate_ button for each key that you need to regenerate.
Update your integrations so they will not stop working.

## How to create a test sales unit

1. Log in to [portal.vipps.no](https://portal.vipps.no) using BankID.
   * If you have problems, see [Permissions and users](#permissions-and-users).
1. Select _Vipps På Nett_ > _Utvikler_.
1. Select to show _test keys_.
1. Click _Add test sales unit_.
1. Enter the requested properties and click _Create_.
   * Name - Enter the name of your test sales unit.
   * Partner - Enter optional partner data (not usually needed).
   * Select optional properties:
     * [Skip Landing Page](../faqs/vipps-landing-page-faq.md#is-it-possible-to-skip-the-landing-page)
     * [Recurring API](https://vippsas.github.io/vipps-developer-docs/docs/APIs/recurring-api/)
     * [Direct Capture](../common-topics/reserve-and-capture.md#direct-capture)

After a couple of minutes, your new test sales unit will appear in the bottom of the list (possibly after some browser refreshes).
Then, you can [get the API keys](#how-to-find-the-api-keys) and begin testing.

**Please note:** It is not possible to _change_ an existing sale unit in the test environment,
but you can create as many as you need.

## How to create additional users on portal.vipps.no

Merchants may create additional users, both for their own colleagues,
accountants, etc - and also for their partner's employees.
Or anyone else they want to give access to their sale units.

See:
[How to add a user on portal.vipps.no](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/add-portal-user).

## Permissions and users

If you don't have BankID, or you have BankID but not access to the correct merchant,
you will need the merchant's administrator to log in on
[portal.vipps.no](https://portal.vipps.no)
and provide the API keys to you in a secure way.

The merchant's administrator can also create additional users on
[portal.vipps.no](https://portal.vipps.no).
If you don't know who the administrator is, you can check
[Brønnøysundregistrene](https://www.brreg.no)
and see who has the right to sign for the company.

If you can log in to [portal.vipps.no](https://portal.vipps.no), but cannot see
the _Utvikler_ (developer) selection in the menu, you need to have the
merchant's administrator grant you developer access for the sales unit you
need access to.

For
[integration partners](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/):
You will need the merchant's administrator to either:

* Log in to
    [portal.vipps.no](https://portal.vipps.no)
    and grant you developer access for the necessary sales unit, or
* Provide the API keys to you in a secure way

For more information, see:

* [Developer Information: Vipps Partners](https://vippsas.github.io/vipps-developer-docs/docs/vipps-partner/)
* [User permissions on vipps.no (in Norwegian)](https://vipps.no/hjelp/vipps/kundeforholdet-mitt/hvilke-tilganger-kan-vi-opprette-i-vippsportalen/).

## Questions

For more information about the Vipps Portal, see the
[help pages on vipps.no (in Norwegian)](https://vipps.no/hjelp/vipps/kundeforholdet-mitt/hva-får-jeg-tilgang-til-når-jeg-logger-meg-inn-på-vippsportalen/)
or [contact us](https://vipps.no/kontakt-oss/).
