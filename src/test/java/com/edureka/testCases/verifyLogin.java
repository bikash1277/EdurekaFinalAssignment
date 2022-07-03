
package com.edureka.testCases;

import org.testng.annotations.Test;

public class verifyLogin extends CommonRunner {

	public verifyLogin() throws Exception {
		super();
	}

	@Test(priority = 1)
	public void loginCheck() throws Exception {
		login.validateLoginPage("SIGN-ON");
		login.logInMethod();
	}
}
