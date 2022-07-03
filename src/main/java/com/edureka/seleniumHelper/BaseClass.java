package com.edureka.seleniumHelper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.edureka.utility.BrowserFactory;
import com.edureka.utility.DateTime;
import com.edureka.utility.PropertyFileReader;

public class BaseClass extends BrowserFactory {
	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("currenttime", dateFormat.format(new Date()));
		System.setProperty("logLocation", System.getProperty("user.dir") + "\\ApplicationLog");}
//	public static Logger logger = Logger.getLogger(BaseClass.class.getName());
//	MailerClass mail;
	DateTime dt=new DateTime();
	public static int counter;
	protected static String reportPath = null;
	public String screenshotPath;
	public static int screenshotCounter;
	public BaseClass() {}
	public void initReportDir() {
		try {
			String reportDir = System.getProperty("user.dir") + "\\Reports";
			String reportDateDir = reportDir + "\\" + dt.getDate();
			reportPath = reportDateDir + "\\SCR_" + dt.getTime();
			createFolder(reportPath);
		} catch (Exception e) {
			logStepInfo("Failed - Error in function initReportDir(): " + e.getMessage());
			scenarioFailed();}}
	public void createFolder(String path) {
		File file = new File(path);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Folder is created!");
			}		} else {
			System.out.println("Failed to create folder!");}}
	public void logStepInfo(String message) {
//		counter++;
//		logger.info("Step " + counter + ")" + message);
		}
	public void scenarioFailed() {
		closeAllDriver();
		Assert.fail();}
	public void loadUrl(String url) {
		driver.get(url);
		logStepInfo("Navigated to url - " + url);}
	public void waitTillElementIsVisible(By element, long timeoutSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.getMessage();}}
	public String takeScreenshot() {
		try {
			screenshotCounter++;
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			screenshotPath = reportPath + "//screenshot_" + screenshotCounter + ".png";
			File DestFile = new File(screenshotPath);
//			FileUtils.copyFile(SrcFile, DestFile);
			return screenshotPath;
		} catch (Exception e) {
			logStepInfo("Failed - Error in function takeScreenshot(): " + e.getMessage());
			return null;}}
	public void implicitlyWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);}
	public void selectFromDropDownByVisibleText(By element, String sItemVisibleText) {
		try {
			Select dropdown;
			dropdown = new Select(driver.findElement(element));
			dropdown.selectByVisibleText(sItemVisibleText);
			logStepInfo("Value is selected from the Drop Down:::" + sItemVisibleText);
		} catch (Exception e) {
			logStepInfo("Failed - Select The Element from Drop Down ::" + sItemVisibleText + ":::" + e.getMessage());
			scenarioFailed();}}
	public void verifyElementText(By element, String text) {
		String actualText = "";
		try {
			actualText = driver.findElement(element).getText();
			System.out.println("text is present in UI-" + actualText);
			Assert.assertTrue(actualText.contains(text), "Text is Present");
			logStepInfo("Expected text is verified" + text);
			takeScreenshot();
		} catch (Exception e) {
			logStepInfo("Failed - Error in function verifyElementText(): " + e.getMessage());
			scenarioFailed();} }
	public void verifyElement(By element) {
		try {
			Assert.assertTrue(driver.findElement(element).isDisplayed(), "Text is Present");
			System.out.println("Text is present in UI....");
			logStepInfo("Text is present in UI....");
			takeScreenshot();
		} catch (Exception e) {
			logStepInfo("Failed - Error in function verifyElement(): " + e.getMessage());
			scenarioFailed();}	}
	public void mailing() throws Exception {
		System.out.println("Common Action Mail method !!!");
//		mail = new MailerClass();
//		mail.mailReports();
	}
}