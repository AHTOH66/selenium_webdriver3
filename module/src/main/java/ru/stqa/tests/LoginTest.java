package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.admin_pages.AdminTests;

public class LoginTest extends AdminTests {

    @Before
    public void before() {
        start();
    }

    @Test
    public void loginTest() {
        login();
        adminLogout();
    }

    @After
    public void after() {
        cleanUpBrowser();
    }
}
