package ru.stqa.user_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeftRailBlockForUser extends UserTests {

    private final WebDriver driver = tlDriver.get();
    private final WebElement element = driver.findElement(By.id("navigation"));

    private WebElement getLoginForm() {
        return element.findElement(By.id("box-account-login"));
    }

    public CreateAccountPage clickNewCustomerLink() {
        getLoginForm().findElement(By.linkText("New customers click here")).click();
        return new CreateAccountPage();
    }

    public void logout() {
        WebElement boxAccount = element.findElement(By.id("box-account"));
        boxAccount.findElement(By.linkText("Logout")).click();
        driver.findElement(By.className("success")).isDisplayed();
    }

    public void login(String email, String password) {
        WebElement loginForm = getLoginForm();
        loginForm.findElement(By.name("email")).sendKeys(email);
        loginForm.findElement(By.name("password")).sendKeys(password);
        loginForm.findElement(By.name("login")).click();
        driver.findElement(By.className("success")).isDisplayed();
    }
}
