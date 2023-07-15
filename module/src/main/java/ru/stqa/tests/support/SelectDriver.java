package ru.stqa.tests.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.stqa.enums.Browsers;

import java.io.File;

public class SelectDriver {

    public WebDriver selectDriver(WebDriver driver, Browsers browser) {
        switch (browser) {
            case CHROME -> driver = new ChromeDriver();
            case FIREFOX -> driver = setBinary("Mozilla Firefox");
            case NIGHTLY -> driver = setBinary("Firefox Nightly");
            case EDGE -> driver = new InternetExplorerDriver();
        }
        return driver;
    }

    private WebDriver setBinary(String versionFF) {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\" + versionFF + "\\firefox.exe")));
        return new FirefoxDriver(options);
    }
}
