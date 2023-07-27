package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.SetBrowser;

public class AddNewProductInformationTab extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement information = driver.findElement(By.id("tab-information"));

    public AddNewProductInformationTab selectManufacturer() {
        information.findElement(By.name("manufacturer_id")).click();
        information.findElement(By.xpath("//option[contains(., 'ACME Corp.')]")).click();
        return this;
    }

    public AddNewProductInformationTab inputKeywordsAndDescriptions() {
        information.findElement(By.name("keywords")).sendKeys("Keyword");
        information.findElement(By.name("short_description[en]")).sendKeys("Short description");
        information.findElement(By.className("trumbowyg-editor")).sendKeys("The best product");
        information.findElement(By.name("head_title[en]")).sendKeys("Head title");
        information.findElement(By.name("meta_description[en]")).sendKeys("Meta description");
        return this;
    }
}
