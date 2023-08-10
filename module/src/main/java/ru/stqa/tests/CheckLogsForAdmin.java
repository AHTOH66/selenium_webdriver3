package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.admin_pages.AdminTests;

public class CheckLogsForAdmin extends AdminTests {

    @Before
    public void before() {
        start();
        login();
    }

    @Test
    public void checkLogsForAdmin() {
        getLeftRailMenu()
                .clickCatalogPage();
        getCatalogPage()
                .checkLogsOfProductPages();
    }

    @After
    public void after() {
        cleanUpBrowser();
    }
}
