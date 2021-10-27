package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isSignOutTabPresent()) {
            click(By.xpath("//a[contains(.,'LOGIN')]"));
            type(By.cssSelector("[placeholder='Email']"), "kronos@gm.com");
            type(By.cssSelector("[placeholder='Password']"), "Kronos12345~");
            click(By.xpath("//button[contains(.,'Login')]"));
        }

        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        //click on tab Add
        click(By.cssSelector("a:nth-child(5)"));
        pause(1000);
        //fill all fields
        type(By.cssSelector("[placeholder='Name']"), "Karl");
        type(By.cssSelector("input:nth-child(2)"), "Adamski");
        type(By.cssSelector("input:nth-child(3)"), "873454467" + i);
        type(By.cssSelector("input:nth-child(4)"), "adams" + i + "@gmd.com");
        type(By.cssSelector("input:nth-child(5)"), "Berlin");
        type(By.cssSelector("input:nth-child(6)"), "teamplayer");
        //click on the Save button
        clickWithActions(By.cssSelector(".add_form__2rsm2 button"));
        //   click(By.cssSelector(".add_form__2rsm2 button"));
        //Assert contact created
    }


    @Test

    public void deleteContactTest() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        pause(2000);
        click(By.xpath("//button[contains(., 'Remove')]"));
        Assert.assertTrue(thereAreNoMoreContacts());
    }
}

