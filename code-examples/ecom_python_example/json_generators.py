import datetime
import random
import string

from config import config


def get_base_ecom_headers(access_token):
    """
    Generates a basic ecom request headers.

    :param access_token: Access Token for authorizing requests made to Vipps ecom.
    :return: Return the base headers for a Vipps ecom request.
    """
    headers = config['ecom'].copy()
    headers['authorization'] = "Bearer {}".format(access_token)
    return headers


def generate_random_order_id():
    """
    Generates a random order id.

    :return: A random 6 character string that can be used as order
    """
    return ''.join(random.choices(string.ascii_lowercase + string.digits, k=12))


def get_initiate_payment_http_body(order_id, transaction_amount, transaction_text, customer_number, express_checkout,
                                   is_app):
    """
    Creates a initiate payment HTTP body.

    :param express_checkout: Enables express checkout.
    :param order_id: ID for the transaction.
    :param transaction_amount: The amount to reserve for the transaction.
    :param transaction_text: The text attached to the transaction.
    :param customer_number: The number for the Vipps account that will pay for the transaction.
    :return: Returns a HTTP body for making a initiate payment request to Vipps.
    """
    ecom_initiate_payment_body = config['ecom_initiate_payment_body'].copy()
    host = config["host_server"]
    ecom_initiate_payment_body["merchantInfo"]["shippingDetailsPrefix"] = "{}/vipps".format(host)
    ecom_initiate_payment_body["merchantInfo"]["consentRemovalPrefix"] = "{}/vipps".format(host)
    ecom_initiate_payment_body["merchantInfo"]["callbackPrefix"] = "{}/vipps".format(host)
    ecom_initiate_payment_body["merchantInfo"]["fallBack"] = '{}/order/{}'.format(host, order_id)
    if is_app:
        ecom_initiate_payment_body["merchantInfo"]["isApp"] = True
    else:
        ecom_initiate_payment_body["merchantInfo"]["isApp"] = False
    ecom_initiate_payment_body["transaction"] = {}
    ecom_initiate_payment_body["customerInfo"] = {}
    ecom_initiate_payment_body["customerInfo"]["mobileNumber"] = customer_number
    ecom_initiate_payment_body["transaction"]["orderId"] = order_id
    ecom_initiate_payment_body["transaction"]["timeStamp"] = datetime.datetime.now().isoformat()
    ecom_initiate_payment_body["transaction"]["amount"] = transaction_amount
    ecom_initiate_payment_body["transaction"]["transactionText"] = transaction_text
    if express_checkout:
        ecom_initiate_payment_body["merchantInfo"]["paymentType"] = "eComm Express Payment"
    else:
        ecom_initiate_payment_body["merchantInfo"]["paymentType"] = "eComm Regular Payment"
    return ecom_initiate_payment_body


def get_capture_payment_http_body(transaction_amount, transaction_text):
    """
    Creates a capture payment HTTP request body.

    :param transaction_amount: The amount of the payment to capture, 0 for capturing all.
    :param transaction_text: The associated text for the capture.
    :return: A HTTP request body for payment capture.
    """
    ecom_capture_payment_body = config['ecom_initiate_payment_body'].copy()
    ecom_capture_payment_body["transaction"] = {}
    ecom_capture_payment_body["transaction"]["amount"] = transaction_amount
    ecom_capture_payment_body["transaction"]["transactionText"] = transaction_text
    return ecom_capture_payment_body


def get_order_ecom_headers(order_id, access_token):
    """
    Creates HTTP request headers for managing a order.

    :param order_id: ID for the transaction.
    :param access_token: A token for authorizing the request to Vipps.
    :return: HTTP request headers for managing a order.
    """
    headers = get_base_ecom_headers(access_token)
    headers["orderId"] = order_id
    return headers


def get_order_ecom_cancel_body(transaction_text):
    """
    Creates a HTTP body for a cancel order request.

    :param transaction_text: Text describing the cancel request.
    :return: A HTTP request body for cancel order.
    """
    ecom_cancel_body = {"merchantInfo": {
        "merchantSerialNumber": config['ecom_initiate_payment_body']['merchantInfo']['merchantSerialNumber']},
        "transaction": {"transactionText": transaction_text}}
    return ecom_cancel_body


def get_shipping_details_response(order_id, address_id):
    """
    Creates a json response for a shipping details request.

    :param order_id: ID for the transaction.
    :param address_id: Address ID received from Vipps.
    :return: A json response for a shipping details request.
    """
    shipping_details = {
        "addressId": address_id,
        "orderId": order_id,
        "shippingDetails": [
            {
                "isDefault": "N",
                "priority": 1,
                "shippingCost": 30.0,
                "shippingMethod": "postNord",
                "shippingMethodId": "".join(random.choices(string.ascii_lowercase + string.digits, k=6))
            },

            {
                "isDefault": "Y",
                "priority": 2,
                "shippingCost": 30.0,
                "shippingMethod": "Posten",
                "shippingMethodId": "".join(random.choices(string.ascii_lowercase + string.digits, k=6))
            }
        ]
    }
    return shipping_details
