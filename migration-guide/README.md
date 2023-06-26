---
title: MobilePay migration guide
sidebar_label: Migration guide
sidebar_position: 100
description: Looking for a hassle-free way to migrate to Vipps MobilePay? Our comprehensive migration guide has got you covered. With easy-to-follow instructions and dedicated support, migrating should be hassle-free. Embrace the future of payments with Vipps MobilePay.
pagination_next: null
pagination_prev: null
---

# Migration guides

On November 1st 2022 the merger between MobilePay and Norwegian Vipps was approved. We have now set full speed on the transition towards having one joint platform to become the best and most used payment wallet in the Nordics for you, both as our ccustomers, partners, and users. Early 2024, the ambition is to have one app, branded locally as MobilePay in Denmark and Finland and Vipps in Norway, and one platform with more than 11 million users and more than 400.000 merchants across the Nordics.

Are you currently using MobilePay APIs for your payment integration needs?

In that case, we’re excited to introduce you to Vipps MobilePay APIs. A reliable and versatile payment solution that can make the migration hassle-free, and even dazzle you with its ease of use and features.
To ensure a smooth transition, we recommend using our migration guide, which will provide step-by-step instructions and best practices for integrating with Vipps MobilePay APIs.

## MobilePay Invoice 
We will have to replace the current MobilePay Point of Sale API with new ePayments API on the joint platform by early 2024. This will *require a new integration*. Use this [migration guide](/docs/vipps-developers/migration-guide/invoice) to ease the transition. 


## MobilePay Point of Sale
We will have to replace the current MobilePay Point of Sale API with new ePayments API on the joint platform by early 2024. This will *require a new integration*. Use this [migration guide](/docs/vipps-developers/migration-guide/pos) to ease the transition. 

## MobilePay Subscriptions 
There is *no need to reintegrate* into the new solution. Your existing Subscriptions Payments integration will continue to work but some functionality will be changing or closed starting from the moment we transition to One Platform. Please visit the [developer documentation](https://developer.mobilepay.dk/docs/subscriptions/transition-to-one-platform) for details. After we have switched to One platform you can transition to Vipps MobilePay Recurring API using this [migration guide](/docs/vipps-developers/migration-guide/subscriptions). 

## MobilePay App Payments
There is *no need to reintegrate* into the new solution. Your existing App Payments integration will continue to work but some functionality will be changing or closed starting from the moment we transition to One Platform. Please visit the [developer documentation](https://developer.mobilepay.dk/docs/app-payments/transition-to-one-platform) for details.

## MobilePay Online
There is *no need to reintegrate* into the new solution. Your existing Online integration will continue to work but some functionality will be changing or closed starting from the moment we transition to One Platform. Please visit the [developer documentation](https://developer.mobilepay.dk/docs/online/transition-to-one-platform) for details.
