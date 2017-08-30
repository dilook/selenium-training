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
        String regPrice = regpriceFromMain.getText();
        WebElement camppriceFromMain = product.findElement(By.cssSelector(".campaign-price"));
        String campPrice = camppriceFromMain.getText();

        assertPriceStyle(regpriceFromMain, "reg");
        assertPriceStyle(camppriceFromMain, "camp");
        assertPriceSize(camppriceFromMain, regpriceFromMain);

        product.click();

        String nameFromCategory = webDriver.findElement(By.cssSelector("h1.title")).getText();
        WebElement regpriceFromView = webDriver.findElement(By.cssSelector(".regular-price"));
        WebElement camppriceFromView = webDriver.findElement(By.cssSelector(".campaign-price"));


        assertEquals(nameFromMain, nameFromCategory);
        assertEquals(regPrice, regpriceFromView.getText());
        assertEquals(campPrice, camppriceFromView.getText());

        assertPriceStyle(regpriceFromView, "reg");
        assertPriceStyle(camppriceFromView, "camp");
        assertPriceSize(camppriceFromView, regpriceFromView);
    }


    public void assertPriceSize(WebElement campaignPrice, WebElement regularPrice) {
        Dimension dim = campaignPrice.getSize();
        int camppriceSize = dim.height * dim.width;

        dim = regularPrice.getSize();
        int regpriceSize = dim.height * dim.width;

        assertTrue(regpriceSize < camppriceSize);
    }

    private void assertPriceStyle(WebElement price, String type) {
        String color = price.getCssValue("color");
        if (type.equals("reg")) {
            assertTrue(color.contains("119, 119, 119") | color.contains("102, 102, 102"));
            assertEquals("s", price.getTagName());

        } else if (type.equals("camp")) {
            assertTrue(color.contains("204, 0, 0"));
            assertEquals("strong", price.getTagName());

        }

    }

}
