package com.edureka.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import com.edureka.seleniumHelper.BaseClass;


public class FlightLogOut extends BaseClass{
	public FlightLogOut() {
		
	}
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
	@CacheLookup
	public WebElement logOffBtn;

	public void logOff() {
		logOffBtn.click();
	}

}
