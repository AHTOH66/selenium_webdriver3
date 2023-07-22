package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.AlphabeticalCheck;
import ru.stqa.tests.support.SetBrowser;

import java.util.ArrayList;

public class ZonesPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement element = driver.findElement(By.id("content"));

    public void checkAlphabeticalListOfZones() {
        ArrayList<WebElement> allRow = new ArrayList<>(new CountryPage().getAllRowCountries());
        for (int i = 0; i < allRow.size(); i++) {
            if (!allRow.get(i).findElement(By.xpath(".//td[6]")).getText().equals("0")) {
                allRow.get(i).findElement(By.xpath(".//a")).click();
                new AlphabeticalCheck().checkByAlphabetical(getListOfZOnes());
                driver.navigate().back();
                allRow = new CountryPage().getAllRowCountries();
            }
        }
    }

    private ArrayList<String> getListOfZOnes() {
        WebElement table = driver.findElement(By.id("table-zones"));
        ArrayList<WebElement> row = new ArrayList<>(table.findElements(By.xpath("//tr/td[3]")));
        ArrayList<String> listOfZones = new ArrayList<>();
        for (int i = 1; i < row.size() - 1; i++) {
            listOfZones.add(row.get(i).getText());
        }
        return listOfZones;
    }
}
