package vippsKeys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VIPPS_InitiatePaymentJSON {

@SerializedName("merchantInfo")
@Expose
private VIPPS_MerchantInfoJSON merchantInfo;
@SerializedName("customerInfo")
@Expose
private VIPPS_CustomerInfoJSON customerInfo;
@SerializedName("transaction")
@Expose
private VIPPS_TransactionJSON transaction;

public VIPPS_MerchantInfoJSON getMerchantInfo() {
return merchantInfo;
}

public void setMerchantInfo(VIPPS_MerchantInfoJSON merchantInfo) {
this.merchantInfo = merchantInfo;
}

public VIPPS_CustomerInfoJSON getCustomerInfo() {
return customerInfo;
}

public void setCustomerInfo(VIPPS_CustomerInfoJSON customerInfo) {
this.customerInfo = customerInfo;
}

public VIPPS_TransactionJSON getTransaction() {
return transaction;
}

public void setTransaction(VIPPS_TransactionJSON transaction) {
this.transaction = transaction;
}

}