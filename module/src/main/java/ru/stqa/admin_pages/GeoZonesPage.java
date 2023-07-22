package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.AlphabeticalCheck;
import ru.stqa.tests.support.SetBrowser;

import java.util.ArrayList;

public class GeoZonesPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();

    public void checkAlphabeticalGeoZones() {
        ArrayList<WebElement> row = new ArrayList<>(getListOfCountry());
        for (int i = 0; i < row.size(); i++) {
            row.get(i).findElement(By.xpath(".//a")).click();
            new AlphabeticalCheck().checkByAlphabetical(getListOfGeoZones());
            driver.navigate().back();
            row = getListOfCountry();
        }
    }

    private ArrayList<WebElement> getListOfCountry() {
        return new ArrayList<>(driver.findElements(By.className("row")));
    }

    private ArrayList<String> getListOfGeoZones() {
        WebElement table = driver.findElement(By.id("table-zones"));
        ArrayList<WebElement> row = new ArrayList<>(table.findElements(
                By.xpath("//td[3]/select/option[contains(@selected, 'selected')]")));
        ArrayList<String> listOfZones = new ArrayList<>();
        for (WebElement element : row) {
            listOfZones.add(element.getAttribute("textContent"));
        }
        return listOfZones;
    }
}
