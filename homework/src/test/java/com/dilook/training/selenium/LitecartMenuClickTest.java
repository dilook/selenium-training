package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

import static com.dilook.training.selenium.UITestUtils.areElementsPresent;
import static com.dilook.training.selenium.UITestUtils.login;
import static com.dilook.training.selenium.WebDriverTestUtils.selectWebDriver;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Di on 24.08.2017.
 */
public class LitecartMenuClickTest {

    private WebDriver webDriver;

    @Before
    public void start() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
    }

    @Test
    public void clickMenu() {

        login(webDriver);

        int menuSize = webDriver.findElements(By.id("app-")).size();
        assertNotEquals(menuSize, 0);
        int subMenuSize = 0;
        String text = "";

        for (int item = 1; item <= menuSize; item++) {
            webDriver.findElement(By.cssSelector("[id = app-]:nth-child(" + item + ")")).click();

            assertTrue(areElementsPresent(webDriver, By.tagName("h1")));

            text = webDriver.findElement(By.tagName("h1")).getText();
            assertNotEquals(text, "");

            System.out.println("#" + item + ": " + text);
            subMenuSize = webDriver.findElements(By.cssSelector("[id ^= doc-]")).size();

            if (subMenuSize > 0) {
                for (int subItem = 1; subItem <= subMenuSize; subItem++) {
                    webDriver.findElement(By.cssSelector("[id ^= doc-]:nth-child(" + subItem + ")")).click();
                    assertTrue(areElementsPresent(webDriver, By.tagName("h1")));

                    text = webDriver.findElement(By.tagName("h1")).getText();
                    assertNotEquals(text, "");

                    System.out.println("\t" + item + "." + subItem + ": " + text);
                }
            }

        }
    }

    @After
    public void stop() {
        webDriver.quit();
        webDriver = null;
    }
}
