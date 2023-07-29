package ru.stqa.user_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.SetBrowser;

public class ProductPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement element = driver.findElement(By.id("box-product"));

    public void addProductToCart() {
        HeaderBlock headerBlock = new HeaderBlock();
        int items = Integer.parseInt(headerBlock.getNumberOfItemsInCart());
        By locator = By.name("options[Size]");
        if (isElementPresent(locator)) {
            element.findElement(locator).click();
            element.findElement(By.xpath("//option[contains(., 'Small')]")).click();
        }
        element.findElement(By.name("add_cart_product")).click();
        headerBlock.checkAddedProductInCartIcon(Integer.toString(items + 1));
    }
}
