package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.admin_pages.AdminTests;
import ru.stqa.tests.support.RandomGeneration;

import static ru.stqa.enums.Currency.USD;

public class AddNewProductTest extends AdminTests {

    private final String name = new RandomGeneration().randomAlphabeticalString();

    @Before
    public void before() {
        start();
        login();
    }

    @Test
    public void addNewProductPage() {
        getLeftRailMenu()
                .clickCatalogPage();
        getCatalogPage()
                .clickAddNewProductButton();
        getAddNewProductPage()
                .clickGeneralTab()
                .clickEnabled()
                .inputName(name)
                .inputCode("code")
                .selectProductGroupUnisexCheckbox()
                .inputQuantity("300")
                .uploadImageOfProduct()
                .inputValidDate();
        getAddNewProductPage()
                .clickInformationTab()
                .selectManufacturer()
                .inputKeywordsAndDescriptions();
        getAddNewProductPage()
                .clickPricesTab()
                .inputPurchasePrice("1000")
                .selectCurrency(USD)
                .inputUsdAndEurPrice("500");
        getAddNewProductPage()
                .clickSaveButton();
        getCatalogPage()
                .checkAddedNewProduct(name);
        adminLogout();
    }

    @After
    public void after() {
        cleanUpBrowser();
    }
}
