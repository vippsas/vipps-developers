---
title: MobilePay migration guides
sidebar_label: Introduction
sidebar_position: 35
description: Looking for a hassle-free way to migrate to Vipps MobilePay? Our comprehensive migration guide has got you covered. With easy-to-follow instructions and dedicated support, migrating should be hassle-free. Embrace the future of payments with Vipps MobilePay.
pagination_next: null
pagination_prev: null
---

# MobilePay migration guides

On November 1st 2022, MobilePay and Norwegian Vipps became one company, *Vipps MobilePay*.

We are working at full speed to transition towards one joint Vipps MobilePay platform.
Our ambition is to become the best and most-used payment wallet in the Nordics for you, our customers, our partners, and our users!

In early 2024, we will provide a joint platform with more than 11 million users and more than 400,000 merchants across the Nordics.
We will provide one app, branded locally as *MobilePay* in Denmark and Finland, and as *Vipps* in Norway.

Are you currently using the MobilePay APIs for your payment integration needs?

In that case, we’re excited to introduce you to the [Vipps MobilePay API platform](https://developer.vippsmobilepay.com/docs/APIs/),
a reliable and versatile payment solution that can make the migration hassle-free and even dazzle you with its ease of use and features.
To ensure a smooth transition, we recommend using our migration guides, which will provide step-by-step instructions and best practices for integrating with the Vipps MobilePay APIs.

## MobilePay Invoice

We must replace the current MobilePay Point of Sale API with new ePayment API on the joint platform by early 2024. This will *require a new integration*. Use the [Invoice to ePayment migration guide](invoice.md) to ease the transition.

## MobilePay Point of Sale

We must replace the current MobilePay Point of Sale API with new ePayment API on the joint platform by early 2024. This will *require a new integration*. Use the [Point of Sale to ePayment migration guide](pos.md) to ease the transition.

## MobilePay Subscriptions

There is *no need to reintegrate* into the new solution. Your existing *Subscriptions Payments* integration will continue to work, but some functionality will be changing or closed starting from the moment we launch the joint platform.
Please visit the [MobilePay developer documentation](https://developer.mobilepay.dk/docs/subscriptions/transition-to-one-platform) for details.
After we have switched to joint platform, you can transition to Vipps MobilePay Recurring API using the
[Subscriptions to Recurring migration guide](subscriptions.md).

## MobilePay App Payments

There is *no need to reintegrate* into the new solution. Your existing *App Payments* integration will continue to work, but some functionality will be changing or closed starting from the moment we transition to the joint platform.
Please visit the [MobilePay developer documentation](https://developer.mobilepay.dk/docs/app-payments/transition-to-one-platform) for details.


## MobilePay Reporting 
You need to integrate to Vipps MobilePay Report API as the The Reporting API will be unavailable after we move to facades. Your existing Reporting API integration will stop working.  Use the [Reporting API to Report API migration guide](reporting.md).

## MobilePay Online

There is *no need to reintegrate* into the new solution. Your existing *Online* integration will continue to work, but some functionality will be changing or closed starting from the moment we transition to the joint platform.
Please visit the [MobilePay developer documentation](https://developer.mobilepay.dk/docs/online/transition-to-one-platform) for details.
