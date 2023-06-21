---
title: Errors
pagination_next: null
pagination_prev: null
---

# Errors

The standard response body format for our errors in our APIs follows
[RFC 7807](https://tools.ietf.org/html/rfc7807).

Here is an example of an error sent together with a
`HTTP 400 Bad Request`:

```http
HTTP/1.1 400 Bad Request
Content-Type: application/problem+json
Content-Language: en
{
   "type":"https://developer.vippsmobilepay.com/api-name/v1/validation-error",
   "title":"Your request parameters didn't validate.",
   "detail":"The request body contains one or more validation errors.",
   "instance":"urn:uuid:123e4567-e89b-12d3-a456-426655440000",
   "status":"400",
   "extraDetails":[
      {
         "name":"amount",
         "reason":"Must be a positive integer larger than 100"
      },
      {
         "name":"URL",
         "reason":"Must use HTTPS and validate according to the API specification"
      }
   ]
}
```

**Important:** The `extraDetails` in the example above *may* be different for
some errors - for instance `invalidParams` - for some APIs, but new APIs
will use `extraDetails`.

**Please note:**

* Most of the APIs use this error format, but legacy APIs may not.
  For details: See each
  [API](https://developer.vippsmobilepay.com/docs/APIs)'s
  specification.
* Some errors are sent from Microsoft Azure, and not the Vipps APIs.
  These include `401`, `403`, `422` and `429`.
  These errors may have a different format, as they are not configurable.
* It is the integrator's responsibility to monitor and handle all errors.  

See also:
[HTTP response codes](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/http-response-codes/).
