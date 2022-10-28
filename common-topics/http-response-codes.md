<!-- START_METADATA
---
title: HTTP response codes
pagination_next: null
pagination_prev: null
---
END_METADATA -->

# HTTP response codes

This API returns the following HTTP statuses in the responses:

| HTTP status        | Description                                            |
| ------------------ | ------------------------------------------------------ |
| `200 OK`           | Request successful                                     |
| `400 Bad Request`  | Invalid request, see the error for details             |
| `401 Unauthorized` | Invalid credentials                                    |
| `403 Forbidden`    | Authentication ok, but credentials lacks authorization |
| `404 Not Found`    | The resource was not found                             |
| `500 Server Error` | An internal Vipps problem                              |
