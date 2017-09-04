package com.dilook.training.selenium;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.dilook.training.selenium.WebDriverTestUtils.selectWebDriver;

/**
 * Created by Di on 29.08.2017.
 */
public class BaseTest {

    static WebDriver webDriver;
    static WebDriverWait webDriverWait;

    @BeforeClass
    public static void start() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    @AfterClass
    public static void stop() {
        webDriver.quit();
        webDriver = null;
    }

    static void navigateTo(String page) {
        webDriver.navigate().to(page);
    }

    static Boolean areElementsPresent(By locator) {
        return webDriver.findElements(locator).size() > 0;
    }

    static Boolean areElementsPresent(WebElement webElement, By locator) {
        return webElement.findElements(locator).size() > 0;
    }

    static String generator(Integer length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String digits = "0123456789";
        String alphanum = upper + lower + digits;

        return RandomStringUtils.random(length, alphanum.toCharArray());

    }

}
