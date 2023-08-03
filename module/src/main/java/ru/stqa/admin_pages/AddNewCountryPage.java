package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.SetBrowser;

import java.util.ArrayList;

public class AddNewCountryPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement element = driver.findElement(By.id("content"));

    public void checkExternalLinksForEditCountry() {
        ArrayList<WebElement> links = new ArrayList<>(element.findElements(By.className("fa-external-link")));
        for (WebElement link : links) {
            checkExternalLinks(link);
        }
    }
}
