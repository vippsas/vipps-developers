from wtforms import Form, StringField, SubmitField, BooleanField
from wtforms.validators import DataRequired


class Transaction(Form):
    customer_number = StringField(validators=[DataRequired()])
    transaction_amount = StringField(validators=[DataRequired()])
    transaction_text = StringField(validators=[DataRequired()])
    express_checkout = BooleanField()


class OrderPage(Form):
    cancel_order = SubmitField(label='Cancel Order')
    capture_order = SubmitField(label='Capture Payment')
    refund_order = SubmitField(label='Refund Payment')
