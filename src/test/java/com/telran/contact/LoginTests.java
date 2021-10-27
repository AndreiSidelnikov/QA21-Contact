package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //login not present
        if (!isLoginTabPresent()) {
            //click on logout button
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //click on Login tab
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());
        //fill Login form
        type(By.cssSelector("[placeholder='Email']"), "kroos@gm.com");
        type(By.cssSelector("[placeholder='Password']"), "Kroos12345~");

        //submit Login
        click(By.xpath("//button[contains(.,'Login')]"));
        //Assert user loggedIn
        Assert.assertTrue(isSignOutTabPresent());
    }

    @Test
    public void loginRegisteredUserNegativeWithWrongPasswordTest() {
        //click on Login tab
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());
        //fill Login form
        type(By.cssSelector("[placeholder='Email']"), "kroos@gm.com");
        type(By.cssSelector("[placeholder='Password']"), "Kroos12345");

        //submit Login
        click(By.xpath("//button[contains(.,'Login')]"));
        //Assert user loggedIn
        Assert.assertTrue(isAlertPresent());
    }

}