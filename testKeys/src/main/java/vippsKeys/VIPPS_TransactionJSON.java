package vippsKeys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VIPPS_TransactionJSON {

@SerializedName("orderId")
@Expose
private String orderId;
@SerializedName("amount")
@Expose
private String amount;
@SerializedName("transactionText")
@Expose
private String transactionText;

public String getOrderId() {
return orderId;
}

public void setOrderId(String orderId) {
this.orderId = orderId;
}

public String getAmount() {
return amount;
}

public void setAmount(String amount) {
this.amount = amount;
}

public String getTransactionText() {
return transactionText;
}

public void setTransactionText(String transactionText) {
this.transactionText = transactionText;
}

}