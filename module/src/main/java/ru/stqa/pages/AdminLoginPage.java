package ru.stqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {

    public void login(WebDriver driver) {
        String admin = "admin";
        driver.findElement(By.name("username")).sendKeys(admin);
        driver.findElement(By.name("password")).sendKeys(admin);
        driver.findElement(By.name("login")).click();
    }
}
