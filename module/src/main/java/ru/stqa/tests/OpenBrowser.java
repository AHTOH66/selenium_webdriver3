package ru.stqa.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.enums.Links;

public class OpenBrowser {
    public WebDriver driver;
    public String link = Links.GOOGLE.getLink();

    @Test
    public void start() {
        driver = new ChromeDriver();
        driver.get(link);
        driver.quit();
        driver = null;
    }
}
