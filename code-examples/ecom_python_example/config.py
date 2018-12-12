config = {
    "host_server": "<host_address>",
    'token_request':{
        'client_id': '<client_id>',
        'client_secret': '<client_secret>',
        'Ocp-Apim-Subscription-Key': '<Ocp-Apim-Subscription-Key> For Access Token',
    },
    'ecom':{
        'Content-Type': 'application/json',
        'Ocp-Apim-Subscription-Key': '<Ocp-Apim-Subscription-Key> For the eCommerce product',
    },
    'ecom_initiate_payment_body':{
        "merchantInfo": {
            "merchantSerialNumber": "<merchantSerialNumber>",
        },
    }
}