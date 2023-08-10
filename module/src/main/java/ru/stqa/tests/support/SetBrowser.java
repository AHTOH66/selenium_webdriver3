package ru.stqa.tests.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.stqa.enums.Browsers;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SetBrowser {

    public static ThreadLocal<EventFiringWebDriver> tlDriver = new ThreadLocal<>();
    public EventFiringWebDriver driver;

    public WebDriver setBrowser(Browsers browser) {
        cleanUpBrowser();
        switch (browser) {
            case CHROME -> driver = new EventFiringWebDriver(new ChromeDriver());
            case FIREFOX -> driver = new EventFiringWebDriver(setBinary("Mozilla Firefox"));
            case NIGHTLY -> driver = new EventFiringWebDriver(setBinary("Firefox Nightly"));
            case EDGE -> driver = new EventFiringWebDriver(new InternetExplorerDriver());
        }
        setUp();
        return driver;
    }

    public WebDriver setBrowser() {
        cleanUpBrowser();
        driver = new EventFiringWebDriver(new ChromeDriver());
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
        driver.register(new MyListener());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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

    public void checkExternalLinks(WebElement element) {
        String mainWindow = tlDriver.get().getWindowHandle();
        if (!(tlDriver.get().getWindowHandles().size() == 1)) {
            ArrayList<String> allWindows = new ArrayList<>(tlDriver.get().getWindowHandles());
            allWindows.remove(mainWindow);
            for (String allWindow : allWindows) {
                tlDriver.get().switchTo().window(allWindow);
                tlDriver.get().close();
            }
            tlDriver.get().switchTo().window(mainWindow);
        }
        element.click();
        ArrayList<String> allWindows = new ArrayList<>(tlDriver.get().getWindowHandles());
        assert allWindows.size() > 1;
        allWindows.remove(mainWindow);
        tlDriver.get().switchTo().window(allWindows.get(0));
        tlDriver.get().close();
        tlDriver.get().switchTo().window(mainWindow);
        assert tlDriver.get().getWindowHandles().size() == 1;
    }
}
