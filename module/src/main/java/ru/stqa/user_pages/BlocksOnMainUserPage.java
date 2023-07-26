package ru.stqa.user_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.CompareMethod;
import ru.stqa.tests.support.GetCssStyles;
import ru.stqa.tests.support.SetBrowser;

import java.util.ArrayList;

public class BlocksOnMainUserPage extends SetBrowser {

    public WebDriver driver = tlDriver.get();
    public WebElement mostPopularBlock = driver.findElement(By.id("box-most-popular"));
    public WebElement campaigns = driver.findElement(By.id("box-campaigns"));
    public WebElement latestProducts = driver.findElement(By.id("box-latest-products"));

    private String price;

    public BlocksOnMainUserPage checkMostPopularStickers() {
        checkOnlyOneSticker(getAllDucks(mostPopularBlock));
        return this;
    }

    public BlocksOnMainUserPage checkCampaignsStickers() {
        checkOnlyOneSticker(getAllDucks(campaigns));
        return this;
    }

    public BlocksOnMainUserPage checkLatestProductsStickers() {
        checkOnlyOneSticker(getAllDucks(latestProducts));
        return this;
    }

    private ArrayList<WebElement> getAllDucks(WebElement element) {
        return new ArrayList<>(element.findElements(By.className("product")));
    }

    private void checkOnlyOneSticker(ArrayList<WebElement> ducks) {
        Integer onlyOneSticker = 1;
        for (int i = 0; i < ducks.size(); i++) {
            ArrayList<WebElement> stickers = new ArrayList<>(ducks.get(i).findElements(By.className("sticker")));
            if (onlyOneSticker.equals(stickers.size())) {
                System.out.println("Sticker is " + stickers.get(0).getText());
            } else {
                throw new NullPointerException("Duck number " + i + " has several stickers");
            }
        }
    }

    public void updateElementsOfBlocks() {
        campaigns = driver.findElement(By.id("box-campaigns"));
        mostPopularBlock = driver.findElement(By.id("box-most-popular"));
        latestProducts = driver.findElement(By.id("box-latest-products"));
    }

    public BlocksOnMainUserPage checkTitle(WebElement element) {
        WebElement duck = getFirstDuck(element);
        String title = duck.findElement(By.className("name")).getText();
        duck.click();
        new CompareMethod().checkProductTitle(title);
        backToMainPage();
        return this;
    }

    public BlocksOnMainUserPage checkFullPrice(WebElement element) {
        WebElement duck = getFirstDuck(element);
        checkFullPriceElements(duck);
        String priceOnMainPage = price;
        duck.click();
        checkFullPriceElements(driver.findElement(By.id("box-product")));
        String priceOnProductPage = price;
        new CompareMethod().textCompare(priceOnMainPage, priceOnProductPage);
        backToMainPage();
        return this;
    }

    //for Campaigns Block only
    public BlocksOnMainUserPage checkDiscountPrice(WebElement element) {
        WebElement duck = getFirstDuck(element);
        checkDiscountPriceElements(duck);
        String discountOnMainPage = price;
        duck.click();
        checkDiscountPriceElements(driver.findElement(By.id("box-product")));
        String discountOnProductPage = price;
        new CompareMethod().textCompare(discountOnMainPage, discountOnProductPage);
        backToMainPage();
        return this;
    }

    private void backToMainPage() {
        driver.navigate().back();
        updateElementsOfBlocks();
    }

    private WebElement getFirstDuck(WebElement element) {
        return getAllDucks(element).get(0);
    }

    private void checkFullPriceElements(WebElement duck) {
        WebElement fullPrice;

        //if there is a discount, check that the fullPrice is crossed out
        if (duck.findElements(By.className("regular-price")).size() != 0) {
            fullPrice = duck.findElement(By.className("regular-price"));
            assert fullPrice.getTagName().equals("s");
        } else {
            fullPrice = duck.findElement(By.className("price"));
        }

        //check that the color for red is the same as for green and blue
        String[] color = new GetCssStyles().getColors(fullPrice);
        assert color[0].equals(color[1]) && color[0].equals(color[2]);
        price = fullPrice.getText();
    }

    private void checkDiscountPriceElements(WebElement duck) {
        WebElement discountPrice = duck.findElement(By.className("campaign-price"));

        //check that text for the discount is strong
        assert discountPrice.getTagName().equals("strong");

        //check that the color is red
        String[] color = new GetCssStyles().getColors(discountPrice);
        assert color[1].equals(color[2]);

        //check that font for the discount price element is bigger
        Double fullPriceSize = new GetCssStyles().getFontSize(
                driver.findElement(By.className("regular-price")));
        Double discountPriceSize = new GetCssStyles().getFontSize(discountPrice);
        assert fullPriceSize < discountPriceSize;
        price = discountPrice.getText();
    }
}
