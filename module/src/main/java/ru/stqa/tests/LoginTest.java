package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.stqa.enums.Links;
import ru.stqa.pages.AdminLoginPage;
import ru.stqa.pages.LeftRailMenu;
import ru.stqa.tests.support.SelectDriver;

import static ru.stqa.enums.Browsers.NIGHTLY;

public class LoginTest {

    public WebDriver driver;
    public AdminLoginPage loginPage = new AdminLoginPage();
    public String link = Links.LITECART_ADMIN.getLink();

    @Before
    public void before() {
        driver = new SelectDriver().selectDriver(driver, NIGHTLY);
        driver.get(link);
    }

    @Test
    public void start() {
        loginPage.login(driver);
    }

    @After
    public void after() {
        LeftRailMenu leftRail = new LeftRailMenu();
        leftRail.logout(driver);
        driver.quit();
        driver = null;
    }
}
