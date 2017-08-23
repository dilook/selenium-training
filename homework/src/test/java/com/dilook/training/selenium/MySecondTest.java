package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Created by Di on 23.08.2017.
 */
public class MySecondTest {

    private WebDriver webDriver;

    @Before
    public void start(){
        FirefoxOptions firefoxOptions = new FirefoxOptions().setLegacy(false);
        webDriver = new FirefoxDriver(firefoxOptions);
    }

    @Test
    public void mySecondTest() {
        webDriver.get("https://www.google.com");
    }

    @After
    public void quit() {
        webDriver.quit();
        webDriver = null;
    }

}
