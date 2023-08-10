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

    public void checkLogsOfProductPages() {
        ArrayList<WebElement> elementsList = new ArrayList<>(driver.findElements(By.className("row")));
        for (int e = 1; e < elementsList.size(); e++) {
            elementsList.get(e).findElements(By.xpath(".//a")).get(0).click();
            if (!driver.findElement(By.tagName("h1")).getText().equals("Catalog")) {
                assert driver.manage().logs().get("browser").getAll().isEmpty();
                driver.navigate().back();
            }
            elementsList = new ArrayList<>(driver.findElements(By.className("row")));
        }
    }
}
