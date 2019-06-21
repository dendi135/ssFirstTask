package com.softserve.firsttask.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.softserve.firsttask.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public abstract class TestRunner {

    protected WebDriver driver;

    private final String SERVER_URL = "https://www.latlong.net/";
    private final String DOCKER_URL = "http://host.docker.internal:4444/wd/hub";

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setupTest(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        driver = new RemoteWebDriver(new URL(DOCKER_URL), capabilities);
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
