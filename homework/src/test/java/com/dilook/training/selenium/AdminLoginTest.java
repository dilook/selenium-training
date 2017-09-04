package com.dilook.training.selenium;

import org.junit.BeforeClass;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Di on 29.08.2017.
 */
public class AdminLoginTest extends BaseTest {

    @BeforeClass
    public static void openAdminSideTest() {
        webDriver.navigate().to("https://litecart.000webhostapp.com/admin/login.php");
        webDriverWait.until(titleIs("My Store"));
        webDriver.findElement(By.name("username")).sendKeys("admin");
        webDriver.findElement(By.name("password")).sendKeys("admin");
        webDriver.findElement(By.name("login")).click();

        //System.out.println(((HasCapabilities) webDriver).getCapabilities());
    }
}
