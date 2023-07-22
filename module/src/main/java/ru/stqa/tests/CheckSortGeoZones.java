package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.admin_pages.AdminTests;

public class CheckSortGeoZones extends AdminTests {

    @Before
    public void before() {
        start();
        login();
    }

    @Test
    public void checkAlphabeticalSortGeoZones() {
        getLeftRailMenu()
                .clickGeoZonesPage();
        getGeoZonesPage()
                .checkAlphabeticalGeoZones();
        adminLogout();
    }

    @After
    public void after() {
        cleanUpBrowser();
    }
}
