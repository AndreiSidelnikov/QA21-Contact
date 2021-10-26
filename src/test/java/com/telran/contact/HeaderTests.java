package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        //login not present
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            //click on logout button
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
    }

    @Test
    public void headerTabAboutTest() {
        driver.findElement(By.xpath("//a[contains(.,'ABOUT')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".about_main__2Uv5W")));

    }

    @Test
    public void headerTabContactsTest() {
        userMustBeRegistered();
        driver.findElement(By.xpath("//a[contains(.,'CONTACTS')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".contact-page_message__2qafk")));

    }

    @Test
    public void headerTabAddTest() {
        userMustBeRegistered();
        driver.findElement(By.xpath("//a[contains(.,'ADD')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".add_main__1tbl_")));

    }

}
