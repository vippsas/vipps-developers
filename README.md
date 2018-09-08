# Vipps Developers

This repository contains various resources for Vipps developers, including:

* [Getting started](vipps-developer-portal-getting-started.md) with the Vipps Developer Portal
* [How to contribute](contribute.md) to Vipps projects on GitHub
* [How to contact us](contact.md) in the Vipps Integration team

# Vipps repositories on GitHub

To clone all the Vipps repos, this works for macOS:

1. Install [Homebrew](https://brew.sh), the missing package manager for macOS  
        ```Shell
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
        ```
2. Install [jq](https://stedolan.github.io/jq/), a lightweight and flexible command-line JSON processor  
        ```Shell
brew install jq
       ```
3. Run this command  
        ```Shell
curl -s https://api.github.com/orgs/vippsas/repos | jq .[].git_url | xargs -n 1 git clone
        ```

## Pull all GitHub repos in the current directory

Creating an alias like `gitall` for this command may be useful:

```
find . -type d -depth 1 -exec git --git-dir={}/.git --work-tree=$PWD/{} pull origin master \;'
```

# Additional developer resources

* Developer overview: https://vipps.no/developer
* High-level overview of the APIs: http://vippsas.github.io
* Products, personal: http://vipps.no/privat
* Products, business: http://vipps.no/bedrift

The Vipps Integration team  

Get in touch: [How to contact us](contact.md)
