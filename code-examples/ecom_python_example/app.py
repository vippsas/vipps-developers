from flask import Flask, request, render_template, redirect, url_for, session, jsonify

from rest_requests import token_request, create_payment, order_status, cancel_order, order_details, refund_payment, \
    capture_payment
from json_generators import generate_random_order_id, get_shipping_details_response
from wtfforms import Transaction, OrderPage

app = Flask(__name__)
app.config.from_pyfile('flask_config.py')


@app.route('/')
def index():
    """
    The landing page of the site

    :return: Returns a rendering of the landing page.
    """
    form = Transaction(request.form)
    return render_template("transaction.html", form=form)


@app.route('/initiate', methods=['POST'])
def initiate_payment():
    """
    Page for initiating payment. Validates that all fields are filled, before making a create_payment call.

    :return: A redirect to the Vipps confirm payment page.
    """
    form = Transaction(request.form)
    if form.validate():
        customer_number = int(form.customer_number.data)
        transaction_amount = form.transaction_amount.data
        transaction_text = form.transaction_text.data
        access_token = token_request()["access_token"]
        order_id = generate_random_order_id()
        payment = create_payment(order_id, access_token, transaction_amount, transaction_text, customer_number,
                                 express_checkout=form.express_checkout.data)
        if "url" in payment:
            payment_url = payment["url"]
        else:
            return payment
        session['payment_url'] = payment_url
        session['order_id'] = order_id
        return redirect(url_for('order_page', order_id=order_id))
    else:
        return redirect(url_for('index'))


@app.route('/order/<order_id>', methods=['POST', 'GET'])
def order_page(order_id):
    """
    Page for managing a initiated order. No authentication performed. This page shows a mix of what should be
    accessible to the merchant and costumer.

    :param order_id: The ID for the order that are to be managed.
    :return: A render of the manage order page.
    """
    form = OrderPage(request.form)
    access_token = token_request()["access_token"]
    if request.method == 'POST':
        if form.cancel_order.data:
            cancel_order(order_id, access_token, "User canceled order")
        elif form.capture_order.data:
            capture_payment(order_id, access_token)
        elif form.refund_order.data:
            refund_payment(order_id, access_token)
    if session.get("order_id") == order_id:
        payment_url = session["payment_url"]
    else:
        payment_url = ""
    order_status_string = str(order_status(order_id, access_token))
    history = order_details(order_id, access_token)["transactionLogHistory"]
    return render_template("order_page.html", form=form, payment_url=payment_url, order_status=order_status_string,
                           order_id=order_id, order_history=history)


@app.route('/vipps/v2/payments/<order_id>', methods=['POST'])
def callback_route(order_id):
    """
    Endpoint for Vipps to provide transaction updates.

    :param order_id: The ID for the order there is updated information about.
    :return: Vipps requires no return for callback.
    """
    response = request.get_json()
    if response["transactionInfo"]["status"] == "RESERVE":
        access_token = token_request()["access_token"]
        capture_payment(order_id, access_token)
    return ""


@app.route('/vipps/v2/payments/<order_id>/shippingDetails', methods=['POST'])
def provide_shipping_details(order_id):
    """
    Provides the shipping details for the specified order.

    This will return dummy data, as the application does not care for shipping information.

    :param order_id: ID for the order.
    :return: The required shipping details. Does not return this in example.
    """
    vipps_request = request.get_json()
    shipping_details_response = get_shipping_details_response(order_id, int(vipps_request["addressId"]))
    return jsonify(shipping_details_response)


@app.route('/vipps/v2/consents/<userId>', methods=['DELETE'])
def remove_consent(user_id):
    """
    This function does nothing, as this examples stores no permanent user information. A cookie delete could be done.
    For a complete implementation, this function needs to remove user details, as per the GDPR guidelines.

    :param user_id: ID for a Vipps user.
    :return: Nothing
    """
    return


#app.run(host='0.0.0.0', port=80)
app.run()
