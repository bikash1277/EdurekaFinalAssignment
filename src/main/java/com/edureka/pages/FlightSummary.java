package com.edureka.pages;

import com.edureka.seleniumHelper.BaseClass;
import com.edureka.utility.ExcelUtils;
import com.edureka.utility.RandomGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightSummary extends BaseClass {
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font")
    @CacheLookup
    public WebElement SummaryLbl;
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td/font/font/b/font/font")
    @CacheLookup
    public WebElement PassengersLbl;
    @FindBy(xpath = "//*[text()='Passengers:']/following::td[1]")
    @CacheLookup
    public WebElement PassengersText;
    @FindBy(name = "passFirst0")
    @CacheLookup
    public WebElement FirstNameText;
    @FindBy(name = "passLast0")
    @CacheLookup
    public WebElement LastNameText;
    @FindBy(name = "pass.0.meal")
    @CacheLookup
    public WebElement MealPreferenceDropDown;
    @FindBy(name = "creditCard")
    @CacheLookup
    public WebElement CardTypeDropDown;
    @FindBy(name = "creditnumber")
    @CacheLookup
    public WebElement CarNumberTxt;
    @FindBy(name = "cc_exp_dt_mn")
    @CacheLookup
    public WebElement ExipryMonthDropDown;
    @FindBy(name = "cc_exp_dt_yr")
    @CacheLookup
    public WebElement ExipryYearDropDown;
    @FindBy(name = "cc_frst_name")
    @CacheLookup
    public WebElement CardFirstNameTxt;
    @FindBy(name = "cc_mid_name")
    @CacheLookup
    public WebElement CardMiddleNameTxt;
    @FindBy(name = "cc_last_name")
    @CacheLookup
    public WebElement CardLastNameTxt;
    @FindBy(name = "billAddress1")
    @CacheLookup
    public WebElement billingAddressTxt;
    @FindBy(name = "billCity")
    @CacheLookup
    public WebElement billingCityTxt;
    @FindBy(name = "billState")
    @CacheLookup
    public WebElement billingStateTxt;
    @FindBy(name = "billZip")
    @CacheLookup
    public WebElement billingZipTxt;
    @FindBy(xpath = "(//*[@name='ticketLess'])[2]")
    @CacheLookup
    public WebElement SameAsBillingCheckbox;
    @FindBy(name = "buyFlights")
    @CacheLookup
    public WebElement SecurePurchaseBtn;
    ExcelUtils _dataRepo = new ExcelUtils();
    RandomGenerator _random = new RandomGenerator();
    public FlightSummary() {
    }

    public void validatePassenger() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(PassengersText.getText(), _dataRepo.getData("Passenger"));
    }

    public void fillPassengerDetails() {
        Select dropdown;
        FirstNameText.sendKeys(_random.randomStringGenerator(5));
        LastNameText.sendKeys(_random.randomStringGenerator(5));
        dropdown = new Select(MealPreferenceDropDown);
        dropdown.selectByVisibleText(_dataRepo.getData("Meal"));
        dropdown = new Select(CardTypeDropDown);
        dropdown.selectByVisibleText(_dataRepo.getData("CardType"));
        CarNumberTxt.sendKeys(_random.randomNumberGenerator(16));
        dropdown = new Select(ExipryMonthDropDown);
        dropdown.selectByVisibleText(_dataRepo.getData("Month"));
        dropdown = new Select(ExipryYearDropDown);
        dropdown.selectByVisibleText(_dataRepo.getData("Year"));
        CardFirstNameTxt.sendKeys(_random.randomStringGenerator(5));
        CardMiddleNameTxt.sendKeys(_random.randomStringGenerator(5));
        CardLastNameTxt.sendKeys(_random.randomStringGenerator(5));
        billingAddressTxt.sendKeys(_random.randomStringGenerator(15));
        billingCityTxt.sendKeys(_dataRepo.getData("City"));
        billingStateTxt.sendKeys(_dataRepo.getData("State"));
        billingZipTxt.sendKeys(_random.randomNumberGenerator(5));
        SameAsBillingCheckbox.click();
    }

    public void clickPurchase() {
        SecurePurchaseBtn.click();
    }
}
