package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.user_pages.UserTests;

import static ru.stqa.enums.Browsers.CHROME;
import static ru.stqa.enums.Browsers.FIREFOX;

public class CheckProductDetails extends UserTests {

    @Before
    public void before() {
        start(CHROME);
    }

    @Test
    public void checkProductDetails() {
        getBlocksOnMainPage()
                .checkTitle(getBlocksOnMainPage().campaigns)
                .checkFullPrice(getBlocksOnMainPage().campaigns)
                .checkDiscountPrice(getBlocksOnMainPage().campaigns);
    }

    @After
    public void after() {
        cleanUpBrowser();
    }
}
