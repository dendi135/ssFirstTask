package com.softserve.firsttask.tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.softserve.firsttask.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class TestRunner {

    protected WebDriver driver;

    private final String SERVER_URL = "https://www.latlong.net/";

    @BeforeClass
    public void beforeClass() {
        URL url = this.getClass().getResource("/chromedriver-osx-32bit");
        System.setProperty("webdriver.chrome.driver", url.getPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(SERVER_URL);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            driver.get(SERVER_URL);
        }
    }

    public HomePage loadApplication() {
        return new HomePage(driver);
    }

}
