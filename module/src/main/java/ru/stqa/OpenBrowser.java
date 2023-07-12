package ru.stqa;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public WebDriver driver;

    @Test
    public void start() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.quit();
        driver = null;
    }
}
