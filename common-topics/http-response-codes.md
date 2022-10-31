<!-- START_METADATA
---
title: HTTP response codes
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# HTTP response codes

The Vipps APIs return the following HTTP statuses in the responses:

| HTTP status        | Description                                            |
| ------------------ | ------------------------------------------------------ |
| `200 OK`           | Request successful (see [200 OK](https://www.webfx.com/web-development/glossary/http-status-codes/what-is-a-200-status-code/))                                    |
| `400 Bad Request`  | Invalid request, see the error in the response body for details. (see [400 Bad Request](https://www.webfx.com/web-development/glossary/http-status-codes/what-is-a-400-status-code/))             |
| `401 Unauthorized` | Invalid API credentials (see [401 Unauthorized](https://www.webfx.com/web-development/glossary/http-status-codes/what-is-a-401-status-code/))                                   |
| `403 Forbidden`    | Authentication OK, but the API keys do not provide the required authorization (see [403 Forbidden](https://www.webfx.com/web-development/glossary/http-status-codes/what-is-a-403-status-code/)) |
| `404 Not Found`    | The resource was not found (see [404 Not Found](https://www.webfx.com/web-development/glossary/http-status-codes/what-is-a-404-status-code/))                            |
| `429 Too Many Requests`    | You have reached the rate limit for this API (see [429 Too Many Requests](https://www.webfx.com/web-development/glossary/http-status-codes/what-is-a-429-status-code/))                           |
| `500 Server Error` | An internal Vipps problem (see [500 Server Error](https://www.webfx.com/web-development/glossary/http-status-codes/what-is-a-500-status-code/))                             |

There may also be responses with other HTTP statuses.
See the API specification for each API for details _especially the FAQ_.

In general:
* 2XX responses: Everything is OK.
* 4XX responses: Client error. You have a problem, and you must correct it.
* 5XX responses: Server error. We have a problem, and we must correct it.

The overview here is quite good:
[HTTP Status Codes Glossary](https://www.webfx.com/web-development/glossary/http-status-codes/).

The authoritative reference is:
[RFC 9110: HTTP Semantics](https://www.rfc-editor.org/rfc/rfc9110.html#name-status-codes).
