package com.edureka.pages;

import com.edureka.seleniumHelper.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class FlightConfirmation extends BaseClass {
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")
    @CacheLookup
    public WebElement confirmMsgLbl;
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/b/font/font/b/font[1]")
    @CacheLookup
    public WebElement ticktNumberTxt;
    @FindBy(xpath = "//*[contains(text(),'Price')]/following::td[1]")
    @CacheLookup
    public WebElement TotalPriceTxt;
    @FindBy(xpath = "//*[contains(text(),'Taxes')]/following::td[1]")
    @CacheLookup
    public WebElement TotalTaxTxt;
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/body/tr[7]/td/table/tbody/tr/td[3]/a/img")
    @CacheLookup
    public WebElement logOffBtn;
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[1]/a/img")
    @CacheLookup
    public WebElement backToFlightsBtn;
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[2]/a/img")
    @CacheLookup
    public WebElement backToHomeBtn;
    public FlightConfirmation() {

    }

    public void getPrice() {
        System.out.println("Your itinerary Number is ::" + ticktNumberTxt.getText());
        System.out.println("Total Tax paid By you is ::" + TotalTaxTxt.getText());
        System.out.println("Total paid By you is ::" + TotalPriceTxt.getText());
    }

    public void verifyElement() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(confirmMsgLbl.getText(), "Your itinerary has been booked!");
        Assert.assertTrue(logOffBtn.isDisplayed(), "Log Off is Present!!!");
        Assert.assertEquals(backToFlightsBtn.isDisplayed(), "Back to Flight Button is Present!");
        Assert.assertEquals(backToHomeBtn.isDisplayed(), "Back to Home button is Present!");
        Assert.assertEquals(confirmMsgLbl.getText(), "Confirm Message is present!");
    }

    public void logOff() {
        logOffBtn.click();
    }
}
