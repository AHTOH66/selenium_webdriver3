package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.tests.support.SetBrowser;

import static ru.stqa.enums.Links.LITECART_ADMIN;

public class AdminTests extends SetBrowser {

    public WebDriver driver;

    public void start() {
        driver = setBrowser();
        driver.get(LITECART_ADMIN.getLink());

    }

    public void login() {
        String admin = "admin";
        driver.findElement(By.name("username")).sendKeys(admin);
        driver.findElement(By.name("password")).sendKeys(admin);
        driver.findElement(By.name("login")).click();
    }

    public LeftRailMenu getLeftRailMenu() {
        return new LeftRailMenu();
    }

    public GeoZonesPage getGeoZonesPage() {
        return new GeoZonesPage();
    }

    public CountryPage getCountryPage() {
        return new CountryPage();
    }

    public void adminLogout() {
        new LeftRailMenu().logout();
    }
}
