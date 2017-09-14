package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by: usodv
 * Date      : 15.09.2017
 */
public class GridTest {
    @Test
    public void testGrid() throws MalformedURLException{

        WebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.internetExplorer());
        webDriver.get("http://google.com");
        webDriver.quit();

    }

}
