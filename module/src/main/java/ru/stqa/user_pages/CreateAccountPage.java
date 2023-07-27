package ru.stqa.user_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.tests.support.RandomGeneration;
import ru.stqa.tests.support.SetBrowser;

public class CreateAccountPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private WebElement element = driver.findElement(By.id("create-account"));
    private final StringBuilder email = new StringBuilder(new RandomGeneration().randomAlphabeticalString());

    public String registrationNewUser() {
        element.findElement(By.name("firstname")).sendKeys("firstName");
        element.findElement(By.name("lastname")).sendKeys("lastName");
        element.findElement(By.name("address1")).sendKeys("address");
        element.findElement(By.name("postcode")).sendKeys("12345");
        element.findElement(By.name("city")).sendKeys("city");
        element.findElement(By.className("select2-selection__arrow")).click();
        element.findElement(By.xpath("//li[contains(., 'United States')]")).click();
        element.findElement(By.name("phone")).sendKeys("12345");
        sendEmailAndPassword();
        clickCreateAccountButton();

        //if this email exists, add new letter
        while (driver.getCurrentUrl().equals("http://localhost/litecart/en/create_account")) {
            email.append(new RandomGeneration().randomAlphabeticalChar());
            element = driver.findElement(By.id("create-account"));
            sendEmailAndPassword();
            clickCreateAccountButton();
        }
        driver.findElement(By.className("success")).isDisplayed();
        return email + "@gmail.com";
    }

    private void sendEmailAndPassword() {
        element.findElement(By.name("email")).clear();
        element.findElement(By.name("email")).sendKeys(email + "@gmail.com");
        element.findElement(By.name("password")).sendKeys("password");
        element.findElement(By.name("confirmed_password")).sendKeys("password");
    }

    public void clickCreateAccountButton() {
        element.findElement(By.name("create_account")).click();
    }
}
