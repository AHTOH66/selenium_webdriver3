package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.stqa.enums.Links;
import ru.stqa.tests.support.SetBrowser;

import static ru.stqa.enums.Browsers.NIGHTLY;

public class OpenBrowser extends SetBrowser {
    public WebDriver driver;
    public String link = Links.GOOGLE.getLink();

    @Before
    public void setUp() {
        driver = setBrowser(NIGHTLY);
    }

    @Test
    public void openBrowser() {
        driver.get(link);
    }

    @After
    public void cleanUp() {
        driver.quit();
        driver = null;
    }
}
