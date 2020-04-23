# Vipps eCom python example

A simple example implementation for the eCom API.

API documentation: https://github.com/vippsas/vipps-ecom-api

## Disclaimer:

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

## Running the example:
1. `pip install -r requirements.txt`
3. Edit config.py
2. `python app.py`

### Running express checkout:
- For express payment the API require an externally accessible host address. To enable flask to be externally accessible, change app.run() to app.run(host='0.0.0.0').
- Express checkout and merchant end point functionality is untested and not currently working.

### Basic manage order page:
![](images/manage_order.png)

# Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/vipps-ecom-api/issues),
a [pull request](https://github.com/vippsas/vipps-ecom-api/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).

Sign up for our [Technical newsletter for developers](https://github.com/vippsas/vipps-developers/tree/master/newsletters).
