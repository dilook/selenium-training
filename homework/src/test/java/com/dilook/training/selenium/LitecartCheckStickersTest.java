package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.List;

import static com.dilook.training.selenium.WebDriverTestUtils.selectWebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Di on 25.08.2017.
 */
public class LitecartCheckStickersTest {

    private WebDriver webDriver;

    @Before
    public void start() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
    }

    @Test
    public void clickMenu() {

        webDriver.get("http://localhost/litecart/en/");

        List<WebElement> products = webDriver.findElements(By.cssSelector(".product"));

        assertFalse(products.isEmpty());

        for (WebElement element : products) {
            int countStickers = element.findElements(By.cssSelector(".sticker")).size();

            assertEquals(countStickers, 1);
        }
    }

    @After
    public void stop() {
        webDriver.quit();
        webDriver = null;
    }
}
