
package com.edureka.testCases;

import org.testng.annotations.Test;

public class LoginCheck extends CommonRunner {

	public LoginCheck() throws Exception {
		super();

	}

	@Test
	public void loginCheck() throws Exception {
		login.validateLoginPage("SIGN-ON");
		login.logInMethod();
		logout.logOff();
		login.validateRegistrationLink();
	}
}