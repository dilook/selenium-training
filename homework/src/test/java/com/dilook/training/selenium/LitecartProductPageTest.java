package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

        assertTrue(regpriceFromMain.getCssValue("color").contains("119, 119, 119"));
        assertEquals("s", regpriceFromMain.getTagName());
        assertTrue(camppriceFromMain.getCssValue("color").contains("204, 0, 0"));
        assertEquals("strong", camppriceFromMain.getTagName());

        Dimension dim = camppriceFromMain.getSize();
        int camppriceSize = dim.height * dim.width;

        dim = regpriceFromMain.getSize();
        int regpriceSize = dim.height * dim.width;

        assertTrue(regpriceSize < camppriceSize);

        product.click();

        String nameFromCategory = webDriver.findElement(By.cssSelector("[itemprop = name]")).getText();

        assertEquals(nameFromMain, nameFromCategory);/*
        assertEquals(regpriceFromMain.getText(), "");
        assertEquals(camppriceFromMain.getText(), "");*/
    }

}
