package com.dilook.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Di on 25.08.2017.
 */
public class UITestUtils {

    protected static void login(WebDriver webDriver) {
        webDriver.navigate().to("http://localhost/litecart/admin/login.php");
        webDriver.findElement(By.name("username")).sendKeys("admin");
        webDriver.findElement(By.name("password")).sendKeys("admin");
        webDriver.findElement(By.name("login")).click();
    }

    protected static Boolean areElementsPresent(WebDriver webDriver, By locator) {
        return webDriver.findElements(locator).size() > 0;
    }

    protected static Boolean areElementsPresent(WebElement webElement, By locator) {
        return webElement.findElements(locator).size() > 0;
    }
}
