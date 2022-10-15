package com.edureka.testCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.edureka.pages.FlightConfirmation;
import com.edureka.pages.FlightFinder;
import com.edureka.pages.FlightLogOut;
import com.edureka.pages.FlightLogin;
import com.edureka.pages.FlightResevation;
import com.edureka.pages.FlightSummary;
import com.edureka.seleniumHelper.BaseClass;
import com.edureka.utility.ExcelUtils;
import com.edureka.utility.PropertyFileReader;

public class CommonRunner extends BaseClass {
	FlightLogin login;
	FlightFinder flight;
	FlightResevation reserve;
	FlightSummary summary;
	FlightConfirmation confirmation;
	FlightLogOut logout;
	ExcelUtils _dataRepo = new ExcelUtils();

	public CommonRunner() throws Exception {
		
	}

	@BeforeSuite
	public void beforeSuiteMethod() throws Exception {
		initReportDir();
		getBrowser("Chrome");
		login = PageFactory.initElements(driver, FlightLogin.class);
		flight=PageFactory.initElements(driver, FlightFinder.class);
		reserve=PageFactory.initElements(driver, FlightResevation.class);
		summary=PageFactory.initElements(driver, FlightSummary.class);
		confirmation=PageFactory.initElements(driver, FlightConfirmation.class);
		logout = PageFactory.initElements(driver, FlightLogOut.class);
		PropertyFileReader.setProperty("TestcaseName", "Login to Demo");
	}

	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("Using Before Class");
	}
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("Using Before test");
	}

	@AfterClass
	public void afterClassMethod() {
		System.out.println("Using After Class");
	}

	@AfterTest
	public void afterTestMethod() {
		closeAllDriver();
		logStepInfo("Closing Application!!!!");
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
	}
	@AfterSuite 
	public void afterSuiteMethod() throws Exception {
//	mailing();
	}
	
}