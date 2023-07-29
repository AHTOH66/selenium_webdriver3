package ru.stqa.tests.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.stqa.enums.Browsers;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SetBrowser {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;

    public WebDriver setBrowser(Browsers browser) {
        cleanUpBrowser();
        switch (browser) {
            case CHROME -> driver = new ChromeDriver();
            case FIREFOX -> driver = setBinary("Mozilla Firefox");
            case NIGHTLY -> driver = setBinary("Firefox Nightly");
            case EDGE -> driver = new InternetExplorerDriver();
        }
        setUp();
        return driver;
    }

    public WebDriver setBrowser() {
        cleanUpBrowser();
        driver = new ChromeDriver();
        setUp();
        return driver;
    }

    private WebDriver setBinary(String versionFF) {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\" + versionFF + "\\firefox.exe")));
        return new FirefoxDriver(options);
    }

    private void setUp() {
        tlDriver.set(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void cleanUpBrowser() {
        if (tlDriver.get() != null) {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
            tlDriver.set(null);
        }
    }

    public boolean isElementPresent(By locator) {
        return !tlDriver.get().findElements(locator).isEmpty();
    }
}
