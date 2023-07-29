package ru.stqa.user_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.tests.support.SetBrowser;

import java.util.ArrayList;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class CartPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement detailBoxBlock = driver.findElement(By.id("box-checkout-cart"));
    private final WebElement orderTableBlock = driver.findElement(By.id("order_confirmation-wrapper"));

    public void clickRemoveButtonForAll() {
        ArrayList<WebElement> productItems = new ArrayList<>(detailBoxBlock.findElements(By.className("item")));
        int numberOfFinalProduct = productItems.size();
        for (int i = 1; i <= numberOfFinalProduct; i++) {
            if (!(numberOfFinalProduct == i)) {
                driver.findElements(By.className("shortcut")).get(0).click();
            }
            WebElement itemInTable = driver.findElement(By.id("order_confirmation-wrapper"))
                    .findElements(By.className("item")).get(1);
            driver.findElement(By.id("box-checkout-cart")).findElements(By.className("item")).get(0)
                    .findElement(By.name("remove_cart_item")).click();
            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
            wait.until(stalenessOf(itemInTable));
        }
    }
}
