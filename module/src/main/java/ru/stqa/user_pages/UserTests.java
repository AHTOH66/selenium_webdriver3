package ru.stqa.user_pages;

import org.openqa.selenium.WebDriver;
import ru.stqa.enums.Browsers;
import ru.stqa.tests.support.SetBrowser;

import static ru.stqa.enums.Links.LITECART;

public class UserTests extends SetBrowser {

    public WebDriver driver;

    public void start() {
        driver = setBrowser();
        driver.get(LITECART.getLink());
    }

    public void start(Browsers browser) {
        driver = setBrowser(browser);
        driver.get(LITECART.getLink());
    }

    public BlocksOnMainUserPage getBlocksOnMainPage() {
        return new BlocksOnMainUserPage();
    }
}
