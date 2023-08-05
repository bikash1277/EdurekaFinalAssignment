package com.edureka.pages;


import com.edureka.seleniumHelper.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class FlightLogOut extends BaseClass {
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
    @CacheLookup
    public WebElement logOffBtn;

    public FlightLogOut() {

    }

    public void logOff() {
        logOffBtn.click();
    }

}
