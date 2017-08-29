package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Di on 25.08.2017.
 */
public class LitecartCheckStickersTest extends OpenClientPageTest {

    @Test
    public void clickMenu() {
        List<WebElement> products = webDriver.findElements(By.cssSelector(".product"));

        assertFalse(products.isEmpty());

        for (WebElement element : products) {
            int countStickers = element.findElements(By.cssSelector(".sticker")).size();

            assertEquals(1, countStickers);
        }
    }
}
