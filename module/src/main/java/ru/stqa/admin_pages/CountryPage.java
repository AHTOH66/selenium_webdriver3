package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.AlphabeticalCheck;
import ru.stqa.tests.support.SetBrowser;

import java.util.ArrayList;

public class CountryPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement element = driver.findElement(By.id("content"));

    public CountryPage checkListOfCountries() {
        ArrayList<String> countriesOnPage = new ArrayList<>();
        ArrayList<WebElement> allRow = new ArrayList<>(getAllRowCountries());
        for (WebElement row : allRow) {
            countriesOnPage.add(row.findElement(By.xpath(".//td[5]")).getText());
        }
        new AlphabeticalCheck().checkByAlphabetical(countriesOnPage);
        return this;
    }

    public void checkListOfZones() {
        new ZonesPage().checkAlphabeticalListOfZones();
    }

    public ArrayList<WebElement> getAllRowCountries() {
        return new ArrayList<>(element.findElements(By.className("row")));
    }

    public void clickAddNewCountryButton() {
        element.findElement(By.linkText("Add New Country")).click();
    }
}
