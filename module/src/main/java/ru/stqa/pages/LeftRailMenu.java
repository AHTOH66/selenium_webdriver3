package ru.stqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftRailMenu {

    public void logout(WebDriver driver) {
        driver.findElement(By.className("fa-sign-out")).click();
    }
}
