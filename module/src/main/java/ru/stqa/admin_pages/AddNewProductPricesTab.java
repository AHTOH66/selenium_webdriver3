package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.enums.Currency;
import ru.stqa.tests.support.SetBrowser;

public class AddNewProductPricesTab extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement prices = driver.findElement(By.id("tab-prices"));

    public AddNewProductPricesTab inputPurchasePrice(String price) {
        WebElement purchasePrise = prices.findElement(By.name("purchase_price"));
        purchasePrise.clear();
        purchasePrise.sendKeys(price);
        return this;
    }

    public AddNewProductPricesTab selectCurrency(Currency currency) {
        prices.findElement(By.name("purchase_price_currency_code")).click();
        prices.findElement(By.xpath("//option[contains(., '" + currency.getCurrency() + "')]")).click();
        return this;
    }

    public AddNewProductPricesTab inputUsdAndEurPrice(String price) {
        prices.findElement(By.name("prices[USD]")).sendKeys(price);
        prices.findElement(By.name("prices[EUR]")).sendKeys(price);
        return this;
    }
}
