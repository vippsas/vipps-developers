package vippsKeys;

import java.io.IOException;

public class getAccessTokenAndInitiatePayment {

	
	public static void main(String [] args) throws IOException, Exception {

		
		
	    	VIPPS_APIKeys.incrementOrderId();
	    	VIPPS_APIKeys.readKeys();
	    	VIPPS_getAccessToken gat = new VIPPS_getAccessToken();
	    	gat.fetchAccessToken();
	    	VIPPS_InitiatePaymentRequest ipr = new VIPPS_InitiatePaymentRequest();
	    	
	    	if(ipr.initiatePayment(gat.fetchAccessToken())) {
	    	if(VIPPS_WebPageButtonClicker.main(ipr.getDeeplinkUrl())) System.out.println("Success!!");
	    	}
	    	else { System.out.println("Stopped because no URL");

	}
}
}
