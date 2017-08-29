package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Di on 24.08.2017.
 */
public class LitecartMenuClickTest extends AdminLoginTest {

    @Test
    public void clickMenu() {

        int menuSize = webDriver.findElements(By.id("app-")).size();
        assertNotEquals(menuSize, 0);
        int subMenuSize;
        String text;

        for (int item = 1; item <= menuSize; item++) {
            webDriver.findElement(By.cssSelector("[id = app-]:nth-child(" + item + ")")).click();

            assertTrue(areElementsPresent(By.tagName("h1")));

            text = webDriver.findElement(By.tagName("h1")).getText();
            assertNotEquals(text, "");

            System.out.println("#" + item + ": " + text);
            subMenuSize = webDriver.findElements(By.cssSelector("[id ^= doc-]")).size();

            if (subMenuSize > 0) {
                for (int subItem = 1; subItem <= subMenuSize; subItem++) {
                    webDriver.findElement(By.cssSelector("[id ^= doc-]:nth-child(" + subItem + ")")).click();
                    assertTrue(areElementsPresent(By.tagName("h1")));

                    text = webDriver.findElement(By.tagName("h1")).getText();
                    assertNotEquals(text, "");

                    System.out.println("\t" + item + "." + subItem + ": " + text);
                }
            }

        }
    }
}
