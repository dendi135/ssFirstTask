package com.softserve.firsttask.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.softserve.firsttask.pages.HomePage;
import com.softserve.firsttask.tools.IniReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public abstract class TestRunner {

    protected WebDriver driver;
    IniReader iniReader = new IniReader("/Users/mburk/GitRepos/ssFirstTask/Task/src/test/resources/data.ini");

    private final String SERVER_URL = iniReader.getValueAsString("links", "server_url");
    private final String DOCKER_URL = iniReader.getValueAsString("links", "docker_url");;

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
