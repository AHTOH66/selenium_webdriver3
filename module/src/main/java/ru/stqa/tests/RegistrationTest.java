package ru.stqa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.user_pages.UserTests;

public class RegistrationTest extends UserTests {

    public String email;

    @Before
    public void before() {
        start();
    }

    @Test
    public void registrationTest() {
        email = getLeftRailBlock()
                .clickNewCustomerLink()
                .registrationNewUser();
        getLeftRailBlock()
                .userLogout();
        getLeftRailBlock()
                .login(email, "password");
        getLeftRailBlock()
                .userLogout();
    }

    @After
    public void after() {
        cleanUpBrowser();
    }
}
