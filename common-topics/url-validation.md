---
title: URL Validation
pagination_next: null
pagination_prev: null
---


# URL Validation

This is applicable to:

* [eCom API](https://developer.vippsmobilepay.com/docs/APIs/ecom-api)
* [PSP API](https://developer.vippsmobilepay.com/docs/APIs/psp-api)

All URLs in the Vipps eCommerce API are validated with the
[Apache Commons URL Validator](https://commons.apache.org/proper/commons-validator/apidocs/org/apache/commons/validator/routines/UrlValidator.html).

**Please note:**

* The `callbackPrefix` URL *must* use HTTPS.
* The `fallBack` URL must use either HTTPS or a custom URL scheme (`myapp://`).
* The endpoints required by Vipps must be publicly available.
* The hostnames must resolve with DNS.

URLs that start with `http://localhost` will be rejected. If you want to use
localhost as fallback, please use `http://127.0.0.1`.
It is, naturally, not possible to use `http://localhost` or
`http://127.0.0.1` for the callback, as the Vipps backend would then call itself.
[Ngrok](https://ngrok.com) may also be an option.

If `isApp` is true, the `fallBack` URL is not validated with Apache Commons URL Validator,
as the app-switch URL may be something like `vipps://`, which is not a valid URL.

Here is a simple Java class suitable for testing URLs,
using the dummy URL `https://example.com/vipps/fallback-result-page-for-both-success-and-failure/acme-shop-123-order123abc`:

```java
import org.apache.commons.validator.routines.UrlValidator;

public class UrlValidate {
 public static void main(String[] args) {
  UrlValidator urlValidator = new UrlValidator();

  if (urlValidator.isValid("https://example.com/vipps/fallback-result-page-for-both-success-and-failure/acme-shop-123-order123abc")) {
   System.out.println("URL is valid");
  } else {
   System.out.println("URL is invalid");
  }
 }
}
```
