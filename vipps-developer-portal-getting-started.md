# Vipps Developer Portal: Getting Started

These are the steps after you have received in the onboarding email from Vipps. You should have received proper credentials with username on email and password on the admin-phonenumber. Use those credentials to log into Vipps Developer Portal in either test or production.

For in-depth information about the Vipps Developer Portal, see the PDF manual: https://github.com/vippsas/vipps-developers

# Step 0

Make sure you have an active subscription to the relevant Vipps product(s): https://www.vipps.no/bedrift

We have sign-up pages for those who know what they want (https://vippsbedrift.no/signup/)
and also a "Find your Vipps" product selector: https://www.vipps.no/bedrift/vippshjelper.

For general questions about products, please use the contact form: https://www.vipps.no/bedrift/kontakt-oss

# Step 1

We start with the typical Sign-in screen:

![Sign-in screen](images/Vipps_sign_in.PNG?raw=true "Title")

You type in your username and password here. Please note that there's a difference between the test and production environments when it comes to Vipps Developer Portal:

## Test environment

* Vipps Developer Portal URL: https://apitest-portal.vipps.no/
* A username that looks like this: username@**testapivipps**.no
* A default password.

## Production environment

* Vipps Developer Portal URL: https://api-portal.vipps.no/
* A username that looks like this: username@**apivipps**.no`
* A default password.

For password changes in either test or production, please [contact us](contact.md).

## Remember to log out of other Microsoft accounts

![Error screen](images/Error-Screen.PNG?raw=true "Title")

If you see an error page similar to the one above:

1. Make sure that you are logged out of any Microsoft accounts, such as Office 365 accounts, _**or**_ make sure you are in "incognito mode" or "private window" in your browser.
2. Make sure you are using the correct URL for Vipps Developer Portal.

# Step 2

After an successful log in you will see the account name up in the right corner of the screen ("TOM KVAM" in this example). On the left you have several tabs.
The **"MANAGE USERS"** tab allows you to add users:

![Add users](images/add_user_vipps_developer_portal.PNG?raw=true "Title")

# Step 3

The next tab **"PRODUCTS"** shows you the APIs you currently have. As you see from the picture below you can have multiple products:

![Products](images/products_vipps_dev.PNG?raw=true "Title")

Click on the **"TEST THE API(S)"** button:
![Test the API(s)](images/Test_the_api.PNG?raw=true "Title")

Click on the **"Try it"** button:
![Try it](images/Try_it_out.PNG?raw=true "Title")

Add the the proper keys to initiate your request (see the next steps):
![Request payment](images/Request_payment.PNG?raw=true "Title")

# Step 4

To get your API keys, open the **"APPLICATIONS"** tab (in a new browser tab) and click on the unit with the number-identificator that fits your Salesunit. You will find both `client_id` and `client_secret`.

![keys applications](images/keys_application.PNG?raw=true "Title")

Under the tab **"REGISTER APPLICATION"** it should say, marked in red:

'All existing products have been subscribed'

Under the profile tab (the account name at the top right, "TOM KVAM" in this example) you will find your two last keys.

![Keys profile](images/keys_profile.PNG?raw=true "Title")

You have the `Access Token` key on the top. You have to click "Show" on the right side to make the keys appear. And as marked in yellow, it's the `Primary key` you are after. If the key for some reason does not work, then you can hit "Regenerate", right next to "Show".

The `Ocp-Apim-Subscription-Key` is right below the `Access Token` key. You have to click "Show" on the right side to make the keys appear. And as marked in yellow, it's the `Primary key` you are after. If the key for some reason does not work, then you can hit "Regenerate", right next to "show".

The `MerchantSerialNumber` (MSN) is the number right next to the name of your Salesunit, `100848` in this example.

Now you should have `Client_id`, `Client_secret`, `Access_token`, `Ocp-Apim-Subscription-Key` and `merchantSerialNumber`, and you can proceed with the payment flow.
