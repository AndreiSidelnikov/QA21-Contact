
package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenHomePageTests extends TestBase {

    @Test
    public void homePageTest() {
        System.out.println("site opened");
        System.out.println("HomeComponent:" + isElementPresent2(By.cssSelector("div:nth-child(2) > div > div")));
    }

}