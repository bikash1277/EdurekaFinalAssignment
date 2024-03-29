package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    protected static WebDriver driver = null;
    static ExcelUtils dataRepo = new ExcelUtils();
    private static Map<String, WebDriver> drivers = new HashMap<>();
    private static String driverPath;

    /*
     * Factory method for getting browsers
     */
    public BrowserFactory() {
        driverPath = System.getProperty("user.dir") + "\\resources\\";
    }

    public static WebDriver getBrowser(String browserName) throws IOException {

        switch (browserName) {
            case "Firefox":
                driver = drivers.get("Firefox");
                if (driver == null) {
                    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
//				driver = new FirefoxDriver();
                    drivers.put("Firefox", driver);
                }
                break;
            case "IE":
                driver = drivers.get("IE");
                if (driver == null) {
                    System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    drivers.put("IE", driver);
                }
                break;
            case "Chrome":
                driver = drivers.get("Chrome");
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromeDriver.exe");
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
                }
                break;
            default:
                System.out.println("Incorrect browser Name!!!!");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(PropertyFileReader.getProperty("URL"));
        return driver;
    }

    public static void closeAllDriver() {
        for (String key : drivers.keySet()) {
            drivers.get(key).close();
            drivers.get(key).quit();
        }
    }
}