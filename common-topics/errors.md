<!-- START_METADATA
---
title: Errors
pagination_next: null
pagination_prev: null
---
END_METADATA -->

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
   "type":"https://example.com/validation-error",
   "title":"Your request parameters didn't validate.",
   "detail":"The request body contains one or more errors",
   "instance":"123e4567-e89b-12d3-a456-426655440000",
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

**Important:** The `extraDetails` in the example above _may_ be different for
some errors - for instance `invalidParams` - for some APIs, but new APIs
will use `extraDetails`.

**Please note:**

* Most of the APIs use this error format, but legacy APIs may not.
  For details: See each
  [API](https://vippsas.github.io/vipps-developer-docs/docs/APIs)'s
  specification.
* Some errors are sent from Microsoft Azure, and not the Vipps APIs.
  These errors may have a different format, as they are not configurable.
  This includes authentication errors.
