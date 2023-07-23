package ru.stqa.tests.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompareMethod extends SetBrowser {

    private final WebDriver driver = tlDriver.get();

    public final WebElement product = driver.findElement(By.id("box-product"));

    public void checkProductTitle(String title) {
        assert title.equals(product.findElement(By.className("title")).getText());
    }

    public void textCompare(String firstText, String secondText) {
        assert firstText.equals(secondText);
    }
}
