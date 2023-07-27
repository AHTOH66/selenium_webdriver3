package ru.stqa.admin_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.tests.support.SetBrowser;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddNewProductGeneralTab extends SetBrowser {

    private final WebDriver driver = tlDriver.get();
    private final WebElement general = driver.findElement(By.id("tab-general"));

    public AddNewProductGeneralTab clickEnabled() {
        general.findElement(By.xpath("//label[contains(., 'Enabled')]")).click();
        return this;
    }
    public AddNewProductGeneralTab inputName(String name) {
        general.findElement(By.name("name[en]")).sendKeys(name);
        return this;
    }

    public AddNewProductGeneralTab inputCode(String code) {
        general.findElement(By.name("code")).sendKeys(code);
        return this;
    }

    public AddNewProductGeneralTab selectProductGroupUnisexCheckbox() {
        getAllProductCheckboxes().get(2).click();
        return this;
    }

    private ArrayList<WebElement> getAllProductCheckboxes() {
        return new ArrayList<>(general.findElements(By.name("product_groups[]")));
    }

    public AddNewProductGeneralTab inputQuantity(String pcs) {
        WebElement quantity = general.findElement(By.name("quantity"));
        quantity.clear();
        quantity.sendKeys(pcs);
        return this;
    }

    public AddNewProductGeneralTab uploadImageOfProduct() {
        File image = new File("src/main/java/ru/stqa/product.jpg");
        general.findElement(By.name("new_images[]")).sendKeys(image.getAbsolutePath());
        return this;
    }

    public AddNewProductGeneralTab inputValidDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        general.findElement(By.name("date_valid_from")).sendKeys(currentDate.format(formatter));
        general.findElement(By.name("date_valid_to")).sendKeys(currentDate.plusYears(10).format(formatter));
        return this;
    }
}
