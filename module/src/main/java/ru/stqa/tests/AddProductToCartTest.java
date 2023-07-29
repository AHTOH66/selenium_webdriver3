package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.user_pages.UserTests;

public class AddProductToCartTest extends UserTests {

    @Before
    public void before() {
        start();
    }

    @Test
    public void addProductToCartTest() {
        //add 3 random products
        for (int i = 0; i < 3; i++) {
            getBlocksOnMainPage()
                    .clickOnProductMostPopularBlock();
            getProductPage()
                    .addProductToCart();
            //after 1 & 2 times go back to Main page
            if (i < 2) {
                getHeaderBlock()
                        .clickLitecardHomePage();
            }
        }
        getHeaderBlock()
                .clickCartLink();
        getCartPage()
                .clickRemoveButtonForAll();
    }

    @After
    public void after() {
        cleanUpBrowser();
    }
}
