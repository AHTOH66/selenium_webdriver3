package ru.stqa.user_pages;

import org.openqa.selenium.WebDriver;
import ru.stqa.tests.support.SetBrowser;

import static ru.stqa.enums.Links.LITECART;

public class UserTests extends SetBrowser {

    public WebDriver driver;

    public void start() {
        driver = setBrowser();
        driver.get(LITECART.getLink());
    }

    public BlocksOnMainUserPage getMostPopularBlock() {
        return new BlocksOnMainUserPage();
    }
}
