package ru.stqa.user_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.SetBrowser;

import java.util.ArrayList;

public class BlocksOnMainUserPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement mostPopularBlock = driver.findElement(By.id("box-most-popular"));
    private final WebElement campaigns = driver.findElement(By.id("box-campaigns"));
    private final WebElement latestProducts = driver.findElement(By.id("box-latest-products"));

    public BlocksOnMainUserPage checkMostPopularStickers() {
        ArrayList<WebElement> ducks = new ArrayList<>(getAllDucks(mostPopularBlock));
        checkOnlyOneSticker(ducks);
        return this;
    }

    public BlocksOnMainUserPage checkCampaignsStickers() {
        ArrayList<WebElement> ducks = new ArrayList<>(getAllDucks(campaigns));
        checkOnlyOneSticker(ducks);
        return this;
    }

    public BlocksOnMainUserPage checkLatestProductsStickers() {
        ArrayList<WebElement> ducks = new ArrayList<>(getAllDucks(latestProducts));
        checkOnlyOneSticker(ducks);
        return this;
    }

    private ArrayList<WebElement> getAllDucks(WebElement element) {
        ArrayList<WebElement> ducks = new ArrayList<>(element.findElements(By.className("product")));
        return ducks;
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
}
