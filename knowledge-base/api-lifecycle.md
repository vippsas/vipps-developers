---
title: API Lifecycle
description: Vipps MobilePay API versioning strategy.
pagination_next: null
pagination_prev: null
---

# API Lifecycle

<!-- START_COMMENT -->
ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://developer.vippsmobilepay.com/docs/).
<!-- END_COMMENT -->

## Versioning

Our APIs use [Semantic Versioning](https://semver.org), which states:

> Given a version number MAJOR.MINOR.PATCH, increment the:
>
> * MAJOR version when you make incompatible API changes
> * MINOR version when you add functionality in a backwards compatible manner
> * PATCH version when you make backwards compatible bug fixes

### Version number in the endpoint URIs

We version API endpoints in the URIs:
`GET:/someapi/v1/some/more/path` and `GET:/someapi/v2/some/more/path`.

There are other ways to manage versions, and many (strong) opinions about them,
and we have chosen the above.

## Lifecycle

The API can change over time. Please keep your applications updated with the latest versions for the optimal behavior.

### Major version

A major version is officially supported until the date when is becomes deprecated.
See [Notice of deprecation](#notice-of-deprecation) for more information about the
deprecation process.

### Minor version

A minor version is automatically superseded by a newer minor version.
If a customer uses version `2.1.0`, that version is automatically
superseded when version `2.2.0` is available.
There will be no bug fixes or other improvements to a minor version that
has been superseded.

We expect you to update to the latest minor version within 30 days.

### Patch version

A patch version fixes one or more small problems, such as correcting a
small bug, so the API works as intended and documented in the first place.

We expect you to update to the latest patch within 30 days.

## Notice of deprecation

Vipps MobilePay will inform of deprecation with a minimum of four (4) months.

### How we will inform

#### Mailing list

We will send information in the
[technical newsletter](https://developer.vippsmobilepay.com/docs/newsletters)
as soon as there is a decision to deprecate an API.
We strongly recommend subscribing to the newsletter.

#### Partners and key accounts

Partners and customers with a Key Account Manager (KAM) will, in addition to the above,
be contacted personally by the partner manager or KAM.

#### Email

We will *attempt* to send email to the technical contact registered for each customer.
If the customer doesn't have a registered technical contact, we'll inform the main contact.

#### Make sure we have the correct contact information

It's your responsibility to make sure we have the correct
contact information. See the
[contact](https://developer.vippsmobilepay.com/docs/contact/) page
for details about how to contact us.

### APIs

The API version is included in the path: `v1`, `v2`, etc.
Only the major version is specified.

### API documentation

The API documentation is updated frequently, and we only version it according to
the mentioned [versioning standards](#versioning).

## Backwards compatibility

We strive to improve existing APIs while also maintaining backwards compatibility.

We consider the following changes to be backwards compatible:

* [Adding an optional field to a request](#adding-an-optional-field-to-a-request)
* [Adding an optional field to a response](#adding-an-optional-field-to-a-response)
* [Adding a new enum value](#adding-a-new-enum-value)
* [Relaxing some constraints on an existing request parameter](#relaxing-some-constraints-on-an-existing-request-parameter)
* [Adding a new response parameter to the API response](#adding-a-new-response-parameter-to-the-api-response)
* [Changing the order in which parameters are returned in existing API responses](#changing-the-order-in-which-parameters-are-returned-in-existing-api-responses)
* [Correcting faulty functionality in edge cases](#correcting-faulty-functionality-in-edge-cases)

### Adding an optional field to a request

An optional parameter for a request is considered a backwards compatible change.
The caller may choose to send the new, optional parameter, but there is no
obligation to do so. There is no change in the API's functionality if the
new, optional parameter is omitted.

The parameter can be added as part of the request body, as a URL parameter, or
an HTTP header field.

Some optional parameters may offer additional or improved functionality, but
the API will never offer less than before the optional parameter was added.

#### Example

We may add a `msisdn` field to support international phone numbers,
in addition to Norwegian-only phone numbers:

Version 2.0.0:

```json
  "customerInfo": {
    "mobileNumber": 91234567
  }
```

Version 2.1.0:

```json
  "customerInfo": {
    "mobileNumber": 91234567,
    "msisdn": 4791234567
  }
```

### Adding an optional field to a response

An optional parameter for a response is considered a backwards compatible change.

The parameter can be added as part of the response body or an HTTP header field.

It is the caller's responsibility to manage the response in a way that
correctly handles new, optional parameters. This is normally done automatically,
but we want to explicitly mention this.

#### Example of option field

We may add a `type` field to the `address` object:

Version 2.0.0:

```json
"address": {
  "addressLine1": "Robert Levins gate 5",
  "city": "Oslo",
  "postCode": "0154",
  "country": "Norway"
  }
```  

Version 2.1.0:

```json
"address": {
  "addressLine1": "Robert Levins gate 5",
  "city": "Oslo",
  "postCode": "0154",
  "country": "Norway",
  "type": "business"
  }
```  

### Adding a new enum value

The value may be added either in the request or in the response.

Response parsing must be robust: Ignore any unknown fields or enum values
received as part of API responses.

### Relaxing some constraints on an existing request parameter

For example, making it optional.

### Adding a new response parameter to the API response

Response parsing must be robust, and able to handle new parameters.

The parameter can be added as part of the request body, as a URL parameter, or
an HTTP header field.

### Changing the order in which parameters are returned in existing API responses

Response parsing must be robust.

### Correcting faulty functionality in edge cases

If the API has offered unintended, undocumented functionality, we consider it a
backwards compatible change to correct it.

## Breaking changes

Changes that are incompatible with previous versions of an API requires
a new major version. This means a bump from `2.3.4` to `3.0.0`.

The API endpoints will also get a new version parameter in the path, for example:
from `v2` to `v3`.

Breaking changes include:

* [Changing the properties of an object](#changing-the-properties-of-an-object)
* [Adding a new required parameter](#adding-a-new-required-parameter)
* [Changing an endpoints URL](#changing-an-endpoints-url)

### Changing the properties of an object

A change in the format for `country` from the full name of the country
(`Norway`) to ISO 3166 (`NO`) is considered a breaking change, as
it requires a change in code that uses the API.

Version 2.0.0:

```json
"address": {
  "addressLine1": "Robert Levins gate 5",
  "city": "Oslo",
  "postCode": "0154",
  "country": "Norway"
  }
```  

Version 3.0.0:

```json
"address": {
  "addressLine1": "Robert Levins gate 5",
  "city": "Oslo",
  "postCode": "0154",
  "country": "NO",
  }
```  

If the ISO 3166 country code was *added* as `countryCode` in addition to the existing `country`,
it would be a non-breaking change, and only a minor version:

Version 2.1.0:

```json
"address": {
  "addressLine1": "Robert Levins gate 5",
  "city": "Oslo",
  "postCode": "0154",
  "country": "Norway"
  "countryCode": "NO",
  }
```  

### Adding a new required parameter

A new required parameter that results in previously valid requests no longer
being valid, is considered a breaking change.

### Changing an endpoints URL

It is considered a breaking change to change from `POST:/accesstoken/get` to
`POST:/accesstokens`.
