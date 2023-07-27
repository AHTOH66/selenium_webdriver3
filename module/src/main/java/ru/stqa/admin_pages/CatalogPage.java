package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.SetBrowser;

import java.util.ArrayList;

public class CatalogPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement element = driver.findElement(By.id("content"));

    public void clickAddNewProductButton() {
        element.findElement(By.linkText("Add New Product")).click();
    }

    public void checkAddedNewProduct(String name) {
        WebElement dataTable = element.findElement(By.className("dataTable"));
        dataTable.findElement(By.xpath(".//a[contains(., '" + name + "')]")).isDisplayed();
    }
}
