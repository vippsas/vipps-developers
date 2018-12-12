import requests

from config import config
from json_generators import get_base_ecom_headers, get_initiate_payment_http_body, get_capture_payment_http_body, \
    get_order_ecom_headers, get_order_ecom_cancel_body

base_url = 'https://apitest.vipps.no'
order_id = ''


def token_request():
    """
    Request a Access Token from Vipps.

    :return: A Access Token
    """
    headers = config['token_request']
    url = base_url + '/accesstoken/get'
    response = requests.post(url, headers=headers)
    return response.json()


def create_payment(order_id, access_token, transaction_amount, transaction_text, customer_number,
                   express_checkout=False):
    """
    Creates a initiate payment request to Vipps.

    :param express_checkout: Boolean for enabling express checkout.
    :param order_id: ID for the transaction.
    :param access_token: A token for authorizing the request to Vipps.
    :param transaction_amount: The amount to reserve for the transaction.
    :param transaction_text: The text attached to the transaction.
    :param customer_number:  The number for the Vipps account that will pay for the transaction.
    :return: The response for the initiate payment request, as JSON.
    """
    url = base_url + '/ecomm/v2/payments'
    headers = get_base_ecom_headers(access_token)
    body = get_initiate_payment_http_body(order_id, transaction_amount, transaction_text, customer_number,
                                          express_checkout=express_checkout)
    response = requests.post(url=url, headers=headers, json=body)
    return response.json()


def capture_payment(order_id, access_token, transaction_amount=0, transaction_text="Capture"):
    """
    Captures the reserved payment for the provided order id.

    :param order_id: ID for the transaction.
    :param access_token: A token for authorizing the request to Vipps.
    :param transaction_amount: The amount of the payment to capture, 0 for capturing all.
    :param transaction_text: The associated text for the capture.
    :return: Response for the capture request, as JSON.
    """
    url = base_url + '/ecomm/v2/payments/{order_id}/capture'.format(order_id=order_id)
    headers = get_order_ecom_headers(order_id, access_token)
    body = get_capture_payment_http_body(transaction_amount, transaction_text)
    response = requests.post(url=url, headers=headers, json=body)
    return response.json()


def order_status(order_id, access_token):
    """
    Requests the status of a transaction.

    :param order_id: ID for the transaction.
    :param access_token: A token for authorizing the request to Vipps.
    :return: Response for the status request, as JSON.
    """
    url = base_url + '/ecomm/v2/payments/{order_id}/status'.format(order_id=order_id)
    headers = get_order_ecom_headers(order_id, access_token)
    response = requests.get(url=url, headers=headers)
    return response.json()


def cancel_order(order_id, access_token, transaction_text):
    """
    Sends a cancel order request for the provided order id.

    :param order_id: ID for the transaction
    :param access_token: A token for authorizing the request to Vipps.
    :param transaction_text: Text describing the cancel request.
    :return: Response for the cancel order request, as JSON.
    """
    url = base_url + '/ecomm/v2/payments/{order_id}/cancel'.format(order_id=order_id)
    headers = get_order_ecom_headers(order_id, access_token)
    body = get_order_ecom_cancel_body(transaction_text)
    response = requests.put(url, headers=headers, json=body)
    return response.json()


def order_details(order_id, access_token):
    """
    Requests the order details of a transaction.

    :param order_id: ID for the transaction.
    :param access_token: A token for authorizing the request to Vipps.
    :return: Response for the status request, as JSON.
    """
    url = base_url + '/ecomm/v2/payments/{order_id}/details'.format(order_id=order_id)
    headers = get_order_ecom_headers(order_id, access_token)
    response = requests.get(url=url, headers=headers)
    return response.json()


def refund_payment(order_id, access_token, transaction_amount=0, transaction_text="Refund"):
    """
    Refunds a already captured payment.

    :param order_id: ID for the transaction.
    :param access_token: A token for authorizing the request to Vipps.
    :param transaction_amount: The amount of the payment to capture, 0 for capturing all.
    :param transaction_text: The associated text for the capture.
    :return: Response for the refund request, as JSON.
    """
    url = base_url + '/ecomm/v2/payments/{order_id}/refund'.format(order_id=order_id)
    headers = get_order_ecom_headers(order_id, access_token)
    body = get_capture_payment_http_body(transaction_amount, transaction_text)
    response = requests.post(url=url, headers=headers, json=body)
    return response.json()
