# Vipps Developers

This repository contains various resources for Vipps developers, including:

* [Getting started](vipps-developer-portal-getting-started.md) with the Vipps Developer Portal
* [How to contribute](contribute.md) to Vipps projects on GitHub
* [How to contact us](contact.md) in the Vipps Integration team

# Vipps repositories on GitHub

To clone all the Vipps repos, this works for macOS:

1. Install [Homebrew](https://brew.sh), the missing package manager for macOS  
        ```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
        ```
2. Install [jq](https://stedolan.github.io/jq/), a lightweight and flexible command-line JSON processor  
        ```
brew install jq
       ```
3. Run this command  
        ```
curl -s https://api.github.com/orgs/vippsas/repos | jq .[].clone_url | xargs -n 1 git clone
        ```

## Pull all GitHub repos in the current directory

Creating an alias like `gitall` for this command may be useful:

```
find . -type d -depth 1 -exec git --git-dir={}/.git --work-tree=$PWD/{} pull origin master \;
```

# API Documentation

The main source for the API documentation is the Swagger files.
We offer both YAML and JSON versions.

HTML documentation is generated using:

| Generator                                          | Example                  |
| -------------------------------------------------- | ------------------------ |
| [Swagger] UI(https://swagger.io/tools/swagger-ui/) | [Vipps Invoice ISP](https://vippsas.github.io/vipps-invoice-api/isp.html) |
| [Redoc](https://github.com/Rebilly/ReDoc)          | [Vipps Invoice ISP](https://vippsas.github.io/vipps-invoice-api/redoc-isp.html) |
| [Spectacle](https://sourcey.com/spectacle/)        |  |

To convert to other formats, [api-spec-converter](https://github.com/LucyBot-Inc/api-spec-converter/) may be useful.

# Postman

[Postman](https://www.getpostman.com/) is a common tool for working with REST APIs.
We offer [Postman Collections](https://www.getpostman.com/collection)
for some APIs, and aim to offer this for all public APIs.

Postman supports importing Swagger files directly, so a collection is not required.

See the [Postman documentation](https://www.getpostman.com/docs/) for more information about using Postman.

# Additional developer resources

* Developer overview: https://vipps.no/developer
* High-level overview of the APIs: http://vippsas.github.io
* Products, personal: http://vipps.no/privat
* Products, business: http://vipps.no/bedrift



**The Vipps Integration team**
[Get in touch](contact.md)
