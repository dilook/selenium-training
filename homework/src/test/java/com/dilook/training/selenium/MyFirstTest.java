package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Di on 15.08.2017.
 */
public class MyFirstTest {

    private WebDriver webDriver;

    @Before
    public void start() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        webDriver.get("http://izh-it.ru");
    }

    @After
    public void stop() {
        webDriver.quit();
        webDriver = null;
    }

}
