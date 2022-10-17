config = {
    "host_server": "<host_address>",
    'token_request':{
        'client_id': '<client_id>',
        'client_secret': '<client_secret>', # Do not put your secret directly in the source code, consider retrieving it from a secure store
        'Ocp-Apim-Subscription-Key': '<Ocp-Apim-Subscription-Key> For Access Token', # Do not put your secret key directly in the source code, consider retrieving it from a secure store
    },
    'ecom':{
        'Content-Type': 'application/json',
        'Ocp-Apim-Subscription-Key': '<Ocp-Apim-Subscription-Key> For the eCommerce product', # Do not put your secret key directly in the source code, consider retrieving it from a secure store
    'ecom_initiate_payment_body':{
        "merchantInfo": {
            "merchantSerialNumber": "<merchantSerialNumber>",
        },
    }
}
