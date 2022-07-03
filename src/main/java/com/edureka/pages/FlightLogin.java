package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.edureka.seleniumHelper.BaseClass;
import com.edureka.utility.ExcelUtils;

public class FlightLogin extends BaseClass{
	public FlightLogin() {
		
	}
	ExcelUtils _dataRepo=new ExcelUtils();

	@FindBy(xpath="//*[@name=\"userName\"]")
	@CacheLookup
	public WebElement userNameTxt;

	@FindBy(xpath="//*[@name=\"password\"]")
	@CacheLookup
	public WebElement passwordTxt;
	
	@FindBy(xpath="//*[@value=\"Login\"]")
	@CacheLookup
	public WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
	@CacheLookup
	public WebElement SignOnLink;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/a")
	@CacheLookup
	public WebElement RegLink;
	
	
	public void logInMethod() throws Exception {
		userNameTxt.sendKeys(_dataRepo.getData("Username"));
		implicitlyWait(2);
		passwordTxt.sendKeys(_dataRepo.getData("Password"));
		
		loginBtn.click();
		
		takeScreenshot();
	}
	public void validateLoginPage(String ExpectedText)throws Exception {
		Assert.assertEquals(SignOnLink.getText(), ExpectedText);
		takeScreenshot();
	}
	public void validateRegistrationLink() {
		Assert.assertTrue(RegLink.isDisplayed(), "Text is Present");
	}
}
