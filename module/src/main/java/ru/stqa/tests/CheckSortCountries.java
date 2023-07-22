package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.admin_pages.AdminTests;

public class CheckSortCountries extends AdminTests {

    @Before
    public void before() {
        start();
        login();
    }

    @Test
    public void checkAlphabeticalSort() {
        getLeftRailMenu()
                .clickCountriesPage();
        getCountryPage()
                .checkListOfCountries()
                .checkListOfZones();
        adminLogout();
    }

    @After
    public void after() {
        cleanUpBrowser();
    }
}
