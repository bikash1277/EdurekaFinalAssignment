
package com.edureka.testCases;

import org.testng.annotations.Test;

public class RoundTrip extends CommonRunner {
	public RoundTrip() throws Exception {
	super();
	}
	@Test(enabled = true)
	public void roundTrip() throws Exception {
		login.validateLoginPage("SIGN-ON");
		login.logInMethod();
		flight.selectFlightDetails();
		flight.selectPrefernces();
		flight.clickContinue();
		Thread.sleep(5000);
		reserve.clickContinue();
		Thread.sleep(5000);
		summary.fillPassengerDetails();
		summary.clickPurchase();
		confirmation.getPrice();
		
	}
}