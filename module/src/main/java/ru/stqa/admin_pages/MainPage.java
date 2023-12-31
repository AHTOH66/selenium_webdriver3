package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.SetBrowser;

public class MainPage extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement element = driver.findElement(By.id("content"));

    public void checkHeaderText() {
        String text = element.findElement(By.tagName("h1")).getText();
        System.out.println(text);
        if ("".equals(text)) {
            throw new NullPointerException("Header has no any text");
        }
    }
}
