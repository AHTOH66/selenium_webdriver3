package ru.stqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.SetBrowser;

import java.util.ArrayList;

public class LeftRailMenu extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement element = driver.findElement(By.id("sidebar"));

    public void logout() {
        element.findElement(By.className("fa-sign-out")).click();
    }

    public void checkAllLinksOfLeftRail() {
        ArrayList<WebElement> elementsList = new ArrayList<>(element.findElements(By.id("app-")));
        for (int e = 0; e < elementsList.size(); e++) {
            elementsList.get(e).click();
            elementsList = new ArrayList<>(driver.findElements(By.id("app-")));
            ArrayList<WebElement> subList = new ArrayList<>(elementsList.get(e).findElements(By.className("name")));
            if (subList.size() > 1) {
                for (int i = 1; i < subList.size(); i++) {
                    WebElement line = subList.get(i);
                    String header = line.getText();
                    line.click();
                    getMainPage().checkHeaderText(header);
                    elementsList = new ArrayList<>(driver.findElements(By.id("app-")));
                    subList = new ArrayList<>(elementsList.get(e).findElements(By.className("name")));
                }
            } else {
                String header = elementsList.get(e).getText();
                new MainPage().checkHeaderText(header);
            }
        }
    }

    public MainPage getMainPage() {
        return new MainPage();
    }
}
