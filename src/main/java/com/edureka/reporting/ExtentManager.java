package com.edureka.reporting;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public ExtentManager() {
		
	}
	// builds a new report using the html template
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;

	// helps to generate the logs in test report.
	ExtentTest test;
	
	// Current Date & Time
	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	// Report folder
	public final static String REPORT_PATH = System.getProperty("user.dir")
			+"/Reports/"+timeStamp+"/"+timeStamp+"_"+"ExtentReport.html";
	
	
	public static ExtentReports getInstance() {
        if (extent == null)
        	startReport();
        return extent;
    }

	/*
	 * Extent Report Implementation
	 */

	public static ExtentReports startReport() {
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(REPORT_PATH);

		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// configuration items to change the look and feel
		// add content, manage tests etc
//		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Test-Automaton-Report.html");
		htmlReporter.config().setReportName("Test-Automaton-Report.html");
		htmlReporter.config().setEncoding("utf-8");
//		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Set environment details
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("AUT", "QA");
 
        return extent;
	}
//	@AfterMethod
//	public void getResult(ITestResult result) {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
//			test.fail(result.getThrowable());
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
//		} else {
//			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
//			test.skip(result.getThrowable());
//		}
//	}
//
//	@AfterTest
//	public void tearDown() {
//		extent.flush();
//	}
}
