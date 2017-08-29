package com.dilook.training.selenium;

import org.junit.BeforeClass;
import org.openqa.selenium.By;

/**
 * Created by Di on 29.08.2017.
 */
public class AdminLoginTest extends BaseTest {

    @BeforeClass
    public static void openAdminSideTest() {
        webDriver.navigate().to("http://localhost/litecart/admin/login.php");
        webDriver.findElement(By.name("username")).sendKeys("admin");
        webDriver.findElement(By.name("password")).sendKeys("admin");
        webDriver.findElement(By.name("login")).click();

        //System.out.println(((HasCapabilities) webDriver).getCapabilities());
    }
}
