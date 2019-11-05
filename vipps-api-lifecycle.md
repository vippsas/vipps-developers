# Vipps API Lifecycle

Document version: 0.1.0.

# Table of Contents

- [Versioning](#versioning)
- [Lifecycle](#lifecycle)
  * [Major version](#major-version)
  * [Minor version](#minor-version)
  * [Patch version](#patch-version)
- [Notice of deprecation](#notice-of-deprecation)
  * [Who Vipps will inform](#who-vipps-will-inform)
  * [Vipps APIs](#vipps-apis)
  * [Vipps API documentation](#vipps-api-documentation)
- [Backwards compatibility](#backwards-compatibility)
  * [Adding an optional field to a request](#adding-an-optional-field-to-a-request)
    + [Example](#example)
  * [Adding an optional field to a response](#adding-an-optional-field-to-a-response)
    + [Example](#example-1)
- [Breaking changes](#breaking-changes)
  * [Adding a new required parameter](#adding-a-new-required-parameter)
- [Questions?](#questions-)

# Versioning

Vipps APIs uses [Semantic Versioning](https://semver.org), which states:

> Given a version number MAJOR.MINOR.PATCH, increment the:
>
> MAJOR version when you make incompatible API changes,
> MINOR version when you add functionality in a backwards compatible manner, and
> PATCH version when you make backwards compatible bug fixes.

# Lifecycle

## Major version

A major version is officially supported until the date where it is deprecated.
See "Notice of deprecation".

## Minor version

A minor version is automatically superseded by a newer minor version.
If a customer uses version `2.1.0`, that version is automatically
superseeded when version `2.2.0` is available.

There will be no bugfixes or other improvements to a minor version that
has been superseeded.

## Patch version

# Notice of deprecation

Vipps will inform about upcoming deprecation of an API as early as possible.
The minimum time from Vipps informs about an API's deprecation until the actual
deprecation is specified in the contract. This is usually three months.

## Who Vipps will inform

Will will email the technical contact registered for each customer.
If the customer does not have a registered technical contact,
Vipps will inform the main contact.

It is the customer's responsibility to make sure Vipps has the correct
contact information. See the
[Vipps contact information](https://www.vipps.no/kontakt-oss/bedrift/).

## Vipps APIs

The Vipps API version is included in the path: `v1`, `v2`, etc.
Only the major version is specified.

## Vipps API documentation

The Vipps API documentation is updated frequently, and we use the versioning
like this:

* Major version: A major change to the documentation, such as adding "recurring" functionality to the Vipps eCom API.
* Minor version: A new section, new flowcharts, or another significant change.
* Patch version: Text changes, typos, small fixes.

# Backwards compatibility

Vipps strives to improves existing APIs while also maintaining backwards compatibility.

Vipps considers the following changes to be backwards compatible:

## Adding an optional field to a request

An optional parameter for a request is considered a backwards compatible change.
The caller may choose to send the new, optional parameter, but there is no
obligation to do so.

Some optional parameters may offer additional or improved functionality, but
the API will never offer less than before the optional parameter was added.

### Example

Vipps may add a `msisdn` field to suopport international phone numbers, in addition to
Norwegian phone numbers:

Version 2.0.0:

```
  "customerInfo": {
    "mobileNumber": 91234567
  }
```

Version 2.1.0:
```
  "customerInfo": {
    "mobileNumber": 91234567
    "msisdn": 4791234567
  }
```

## Adding an optional field to a response

An optional parameter for a response is considered a backwards compatible change.

It is the caller's responsibility to manage the response in a way that
correctly handles new, optional parameters. This is normally done automatically,
but we want to explicitly mention this.

### Example

Vipps may add an `addressType` field to the `address` object:

Version 2.0.0:

```
"address": {
  "addressLine1": "Robert Levins gate 5",
  "city": "Oslo",
  "country": "Norway",
  "postCode": "0154"
  }
```  

Version 2.1.0:

```
"address": {
  "addressLine1": "Robert Levins gate 5",
  "city": "Oslo",
  "country": "Norway",
  "postCode": "0154",
  "addressType": "business"
  }
```  

# Breaking changes

Changes that are incompatible with previous versions of an API requires
a new major version. This means a bump from `2.3.4` from `3.0.0`.

The API endpoints will also get a new version parameter in the path:
from `v2` to `v3`.

## Adding a new required parameter





# Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-ecom-api/issues),
a [pull request](https://github.com/vippsas/vipps-ecom-api/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
