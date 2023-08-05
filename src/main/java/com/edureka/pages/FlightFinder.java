package com.edureka.pages;

import com.edureka.seleniumHelper.BaseClass;
import com.edureka.utility.ExcelUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightFinder extends BaseClass {
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font")
    @CacheLookup
    public WebElement FilghtDetailsLbl;
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td/font/font/b/font/font")
    @CacheLookup
    public WebElement PreferencesLbl;
    @FindBy(xpath = "//*[@value='roundtrip']")
    @CacheLookup
    public WebElement roundTripRadio;
    @FindBy(xpath = "//*[@value='oneway']")
    @CacheLookup
    public WebElement oneWayTripRadio;
    @FindBy(xpath = "//*[@name='passCount']")
    @CacheLookup
    public WebElement passengerDropDown;
    @FindBy(xpath = "//*[@name='fromPort']")
    @CacheLookup
    public WebElement DepartFromDropDown;
    @FindBy(xpath = "//*[@name='toPort']")
    @CacheLookup
    public WebElement DepartToDropDown;
    @FindBy(xpath = "//*[@name='fromDay']")
    @CacheLookup
    public WebElement OnDayFromDropDown;
    @FindBy(xpath = "//*[@name='fromMonth']")
    @CacheLookup
    public WebElement OnMonthFromDropDown;
    @FindBy(xpath = "//*[@name='toDay']")
    @CacheLookup
    public WebElement OnDayToDropDown;
    @FindBy(xpath = "//*[@name='toMonth']")
    @CacheLookup
    public WebElement OnMonthToDropDown;
    @FindBy(xpath = "//*[@value='Coach']")
    @CacheLookup
    public WebElement EconomyClassRadio;
    @FindBy(xpath = "//*[@value='Business']")
    @CacheLookup
    public WebElement BusinessClassRadio;
    @FindBy(xpath = "//*[@value='First']")
    @CacheLookup
    public WebElement FirstClassRadio;
    @FindBy(xpath = "//*[@name='airline']")
    @CacheLookup
    public WebElement airlineDropDown;
    @FindBy(xpath = "//*[@name='findFlights']")
    @CacheLookup
    public WebElement COntinueBtn;
    ExcelUtils _dataRepo = new ExcelUtils();
    public FlightFinder() {

    }

    public void validateFields() {
        String ExpectedValue = "Flight \r\n" + "              Details ";
        Assert.assertEquals(FilghtDetailsLbl.getText(), ExpectedValue);
        Assert.assertEquals(PreferencesLbl.getText(), "Preferences");
    }

    public void selectFlightDetails() {

        Select dropdown1 = new Select(passengerDropDown);
        dropdown1.selectByVisibleText(_dataRepo.getData("Passenger"));
        Select dropdown2 = new Select(DepartFromDropDown);
        dropdown2.selectByVisibleText(_dataRepo.getData("FromPort"));
        Select dropdown3 = new Select(OnDayFromDropDown);
        dropdown3.selectByVisibleText(_dataRepo.getData("FromDate"));
        Select dropdown4 = new Select(OnMonthFromDropDown);
        dropdown4.selectByVisibleText(_dataRepo.getData("FromMonth"));
        Select dropdown5 = new Select(DepartToDropDown);
        dropdown5.selectByVisibleText(_dataRepo.getData("ToPort"));
        Select dropdown6 = new Select(OnDayToDropDown);
        dropdown6.selectByVisibleText(_dataRepo.getData("ToDate"));
        Select dropdown7 = new Select(OnMonthToDropDown);
        dropdown7.selectByVisibleText(_dataRepo.getData("ToMonth"));
        Select dropdown8 = new Select(airlineDropDown);
        dropdown8.selectByVisibleText(_dataRepo.getData("Airline"));
        System.out.println("Values are selected from Drop Downs !!!!");
        takeScreenshot();
    }

    public void selectPrefernces() {
        if (_dataRepo.getData("Preferences").equalsIgnoreCase("Economy class")) {
            EconomyClassRadio.click();
        } else if (_dataRepo.getData("Preferences").equalsIgnoreCase("Business class")) {
            BusinessClassRadio.click();
        } else if (_dataRepo.getData("Preferences").equalsIgnoreCase("First class")) {
            FirstClassRadio.click();
        } else {
            System.out.println("Preference is out of list!!!!!");
        }
        takeScreenshot();
    }

    public void clickContinue() {
        COntinueBtn.click();
        System.out.println("Navigate to next page!!!");
    }

}
