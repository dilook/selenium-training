package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Di on 29.08.2017.
 */
public class LitecartProductPageTest extends OpenClientPageTest {

    @Test
    public void test() {
        WebElement product = webDriver.findElement(By.cssSelector("#box-campaigns li.product"));
        String nameFromMain = product.findElement(By.cssSelector("div.name")).getText();

        WebElement regpriceFromMain = product.findElement(By.cssSelector(".regular-price"));
        WebElement camppriceFromMain = product.findElement(By.cssSelector(".campaign-price"));
        assertTrue("", regpriceFromMain.getCssValue("color").contains("119, 119, 199"));
        assertEquals(regpriceFromMain.getTagName(), "s");
        assertTrue(camppriceFromMain.getCssValue("color").contains("204, 0, 0"));
        assertEquals(regpriceFromMain.getTagName(), "strong");
        System.out.println(camppriceFromMain.getSize());

        product.click();

        String nameFromCategory = webDriver.findElement(By.cssSelector("[itemprop = name]")).getText();

        assertEquals("", nameFromMain, nameFromCategory);
        assertEquals("", regpriceFromMain.getText(), "");
        assertEquals("", camppriceFromMain.getText(), "");
    }

}
