<!-- START_METADATA
---
title: API Lifecycle
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# Vipps API Lifecycle

<!-- START_COMMENT -->

ℹ️ Please use the website:
[Vipps MobilePay Technical Documentation](https://vippsas.github.io/vipps-developer-docs/).

<!-- END_COMMENT -->

## Versioning

Vipps APIs uses [Semantic Versioning](https://semver.org), which states:

> Given a version number MAJOR.MINOR.PATCH, increment the:
>
> - MAJOR version when you make incompatible API changes
> - MINOR version when you add functionality in a backwards compatible manner
> - PATCH version when you make backwards compatible bug fixes

### Version number in the endpoint URIs

Vipps versions API endpoints in the URIs:
`GET:/someapi/v1/some/more/path` and `GET:/someapi/v2/some/more/path`.

There are other ways to manage versions, and many (strong) opinions about them,
and Vipps has chosen the above.

## Lifecycle

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

### Patch version

A patch version fixes one or more small problems, such as correcting a
small bug so the API works as intended and documented in the first place.

## Notice of deprecation

Vipps will inform about upcoming deprecation of an API as early as possible.

The minimum time from Vipps informs about an API's deprecation until the actual
deprecation is specified in the contract. This is usually four (4) months, and
we will soon change this to six (6) months as standard, in new contracts.

### How Vipps will inform

#### Email

Vipps will email the technical contact registered for each customer.
If the customer does not have a registered technical contact,
Vipps will inform the main contact.

#### Mailing list

Vipps will send information to
[the technical newsletter for developers](https://vippsas.github.io/vipps-developer-docs/docs/vipps-developers/newsletters)
as soon as there is a decision to deprecate an API.

#### Key accounts

Customers with a key account manager (KAM) will, in addition to the above,
be contacted personally by the KAM.

#### Make sure Vipps has the correct contact information

It is the customer's responsibility to make sure Vipps has the correct
contact information. See the
[Vipps contact information](https://www.vipps.no/kontakt-oss/bedrift/).

### Vipps APIs

The Vipps API version is included in the path: `v1`, `v2`, etc.
Only the major version is specified.

### Vipps API documentation

The Vipps API documentation is updated frequently, and we use the versioning
like this:

- Major version: A major change to the documentation, such as adding "recurring"
  functionality to the Vipps eCom API.
- Minor version: A new section, new flowcharts, or another significant change.
- Patch version: Text changes, typos, small fixes.

See
[Versioning](#versioning)
for more details.

### Legacy API products

If you are still using a legacy API, you should upgrade as soon as possible.
The best way to keep up to date of changes is to
[star the API repository on GitHub](https://docs.github.com/en/get-started/exploring-projects-on-github/saving-repositories-with-stars).

## Backwards compatibility

Vipps strives to improve existing APIs while also maintaining backwards compatibility.

Vipps considers the following changes to be backwards compatible:

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

Vipps may add a `msisdn` field to support international phone numbers,
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
    "mobileNumber": 91234567
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

Vipps may add an `type` field to the `address` object:

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

### Relaxing some of the constraints on an existing request parameter

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

The API endpoints will also get a new version parameter in the path:
from `v2` to `v3`.

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

If the ISO 3166 country code was _added_ as `countryCode`, it would be a
non-breaking change, and only a minor version:

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
