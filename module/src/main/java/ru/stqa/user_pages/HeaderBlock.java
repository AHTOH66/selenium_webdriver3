package ru.stqa.user_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.tests.support.SetBrowser;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HeaderBlock extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement header = driver.findElement(By.id("header"));
    private final WebElement cart = header.findElement(By.className("quantity"));

    public String getNumberOfItemsInCart() {
        return cart.getText();
    }

    public void checkAddedProductInCartIcon(String items) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(textToBePresentInElement(cart, items));
    }

    public void clickLitecardHomePage() {
        header.findElement(By.id("logotype-wrapper")).click();
    }

    public void clickCartLink() {
        cart.click();
    }
}
