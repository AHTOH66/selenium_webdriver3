package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.user_pages.UserTests;

public class CheckStickers extends UserTests {

    @Before
    public void before() {
        start();
    }

    @Test
    public void checkStickers() {
        getBlocksOnMainPage()
                .checkMostPopularStickers()
                .checkCampaignsStickers()
                .checkLatestProductsStickers();
    }

    @After
    public void after() {
        cleanUpBrowser();
    }
}
