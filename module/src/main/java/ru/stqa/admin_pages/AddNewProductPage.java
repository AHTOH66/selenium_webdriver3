package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.SetBrowser;

public class AddNewProductPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement element = driver.findElement(By.className("tabs"));

    public AddNewProductGeneralTab clickGeneralTab() {
        clickTab("General");
        return new AddNewProductGeneralTab();
    }

    public AddNewProductInformationTab clickInformationTab() {
        clickTab("Information");
        return new AddNewProductInformationTab();
    }

    public AddNewProductPricesTab clickPricesTab() {
        clickTab("Prices");
        return new AddNewProductPricesTab();
    }

    private void clickTab(String nameOfTab) {
        WebElement tabs = element.findElement(By.className("index"));
        tabs.findElement(By.linkText(nameOfTab)).click();
    }

    public void clickSaveButton() {
        driver.findElement(By.name("save")).click();
    }
}
