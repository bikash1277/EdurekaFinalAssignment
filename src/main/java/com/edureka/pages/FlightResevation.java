package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.edureka.seleniumHelper.BaseClass;
import com.edureka.utility.ExcelUtils;

public class FlightResevation extends BaseClass {
	public FlightResevation() {
		
	}
	ExcelUtils _dataRepo = new ExcelUtils();

	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/font/b/font")
	@CacheLookup
	public WebElement departLbl;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/font/b/font")
	@CacheLookup
	public WebElement returnLbl;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font")
	@CacheLookup
	public WebElement locationTolocationLbl;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font")
	@CacheLookup
	public WebElement locationFromlocationLbl;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[1]/input")
	@CacheLookup
	public WebElement airlinesFromPrice;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[3]/td[1]/input")
	@CacheLookup
	public WebElement airlinesFromRadio;
	
	@FindBy(xpath="(/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[4]/td/font/font/b")
	@CacheLookup
	public WebElement airlineToPrice;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[4]/td/font/font/b")
	@CacheLookup
	public WebElement airlinesToRadio;

	@FindBy(xpath="//*[@name='reserveFlights']")
	@CacheLookup
	public WebElement ContineBtn;	
	
	public void validateElement() throws Exception {
		Thread.sleep(5000);
		Assert.assertEquals(departLbl.getText(),"DEPART");
		Assert.assertEquals(locationTolocationLbl.getText(), ""+_dataRepo.getData("FromPort")+" to "+_dataRepo.getData("ToPort")+"");
		System.out.println("Element is present !!!!");
		Assert.assertEquals(returnLbl.getText(),"RETURN");
		Assert.assertEquals(locationFromlocationLbl.getText(), ""+_dataRepo.getData("ToPort")+" to "+_dataRepo.getData("FromPort")+"");
		System.out.println("Element is present !!!!");
	}
	public void getFlightsPrice() {
		System.out.println("The from price is "+airlinesFromPrice.getText());
		System.out.println("The from price is "+airlineToPrice.getText());
	}
	public void selectValueRadio() throws InterruptedException {
		airlinesFromRadio.click();
		airlinesToRadio.click();
	}
	public void clickContinue() {
	ContineBtn.click();
		System.out.println("Navigate to Next Page!!!");
	}
}
