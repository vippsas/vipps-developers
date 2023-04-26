---
title: HTTP response codes
pagination_next: null
pagination_prev: null
---


# HTTP response codes

The Vipps APIs return the following HTTP statuses in the responses:

| HTTP status             | Description                                            |
|:------------------------|:-------------------------------------------------------|
| `200 OK`                | Request successful                                     |
| `201 Created`           | Request successful, resource created                   |
| `204 No Content`        | Request successful, but empty result                   |
| `400 Bad Request`       | Invalid request, see the error for details             |
| `401 Unauthorized`      | Invalid credentials                                    |
| `403 Forbidden`         | Authentication ok, but credentials lacks authorization |
| `404 Not Found`         | The resource was not found                             |
| `409 Conflict`          | Unsuccessful due to conflicting resource               |
| `429 Too Many Requests` | Look at table below to view current rate limits        |
| `500 Server Error`      | An internal Vipps problem.                             |

In general:

* 2XX responses: Everything is OK.
* 4XX responses: Client error. You have a problem, and you must correct it.
* 5XX responses: Server error. We have a problem, and we must correct it.

See the API specification for each API for details _especially the FAQ_.

See:
[Error](https://developer.vippsmobilepay.com/docs/vipps-developers/common-topics/errors/).

The HTTP status overview here is quite good:
[HTTP Status Codes Glossary](https://www.webfx.com/web-development/glossary/http-status-codes/).

The authoritative reference is:
[RFC 9110: HTTP Semantics](https://www.rfc-editor.org/rfc/rfc9110.html#name-status-codes).
