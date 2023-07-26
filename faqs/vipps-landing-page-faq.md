---
title: "FAQ: landing page"
sidebar_label: Landing page
sidebar_position: 190
pagination_next: null
pagination_prev: null
---

# FAQ: Landing page

## Is it possible to skip the landing page?

Only in special cases, where displaying it is not possible.

This feature has to be specially enabled by Vipps for eligible sales units:
The sales units must be whitelisted by Vipps.
Skipping the landing page is typically used at physical points of sale
where there is no display available.

The landing page is more than just a web page, it is an entire
application, and it plays an important role in the Vipps payment process.
See
[landing page](../common-topics/landing-page.md)
for more information

If you need to skip the landing page in a Point of Sale (POS) solution, see:
[What is the process to go live in production?](pos-integrations-faq.md#what-is-the-process-to-go-live-in-production).

If you need to skip the landing page for a different reason:
Contact your Key Account Manager. If you do not have a KAM:
Please log in on
[portal.vipps.no](https://portal.vipps.no),
open the "Utvikler" (Developer) tab,
find the right sales unit and
click the email link under the "i" information bubble.
Include a detailed description of why it is not possible to display the landing page.

See:
[Skip landing page](../common-topics/landing-page.md#skip-landing-page).

## How can I check if I have skipLandingPage activated?

Vipps can no longer manually check this for merchant or partners.

All merchants can log in on
[portal.vipps.no](https://portal.vipps.no)
and check if a sales unit has `skipLandingPage` enabled
for all their sales units under the "Utvikler" menu item.

You can also find information on how to activate `skipLandingPage` there.

If you are a partner and want to check a merchant, see the
[Partner API](https://developer.vippsmobilepay.com/docs/APIs/partner-api).

If you are a partner and do not yet use the Partner API, you can ask the
merchant to create a user for you on
[portal.vipps.no](https://portal.vipps.no), so you can check on behalf of the merchant as
[described in detail with screenshots](https://developer.vippsmobilepay.com/docs/vipps-partner/add-portal-user).

If you are not able to log in on
[portal.vipps.no](https://portal.vipps.no)
you can make a small payment (2 NOK)
with `skipLandingPage`.
If you do not get an error, it's active.
If you get an error, it's not active.

See:
[Skip landing page](../common-topics/landing-page.md#skip-landing-page).

## Can I show the landing page in an iframe?

No. Never show the Vipps landing page inside an iframe.

Displaying the landing page inside an iframe makes it impossible for the
user to reliably be redirected back to the merchant's website, and result in a
lower success rate.

When the phone's operating system is instructed to open the `fallBack` URL (the
result page for the payment) and the Vipps app is installed, the
`https://vipps.no?token... [truncated]` URL is recognized
by the phone's operating system as "owned" by Vipps. Then, instead of opening a browser,
the Vipps app is automatically opened. This is called an *app-switch*.

However, if the landing page is displayed inside an iframe, the logic above does
not work. This results in the user gets a bad user experience, and the success rate for
completing the payment drops.

Also: The `fallBack` URL is opened in the default browser, since it's opened
by the phone's operating system. It cannot be opened inside an embedded
browser, or in an iframe. Any session cookies or similar will be gone, so it
is crucial that the `fallBack` URL is able to correctly show the correct state
for the payment.

## Is it possible to prevent the user from editing the phone number?

In special cases, it may be a requirement to always specify the user's
phone number and to make the phone number impossible to edit on the landing page.

This will of course make it impossible for a user to start the payment process,
but have another user (a parent, for instance) complete the payment.

If you need to make the user's phone number impossible to edit on the landing page:
Contact your Key Account Manager. If you do not have a KAM:
[contact us](../contact.md)
and include a detailed description of why this is needed.

**Important:**

* Vipps users should never see the Vipps landing page on a device where Vipps
  is installed.
* Any *optimization* of the normal payment flow may break the Vipps payment
  flow - if not today, then later.
* The default behavior and our recommendations
  are based on years of experience and data, and we continuously monitor and improve it.

See:
[Skip landing page](../common-topics/landing-page.md#skip-landing-page).
