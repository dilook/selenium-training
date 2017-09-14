package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.Platform;
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
    public static final String USERNAME = "dilook1";
    public static final String AUTOMATE_KEY = "yzA9BLrPzDDzLGWnHVt7";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void testGrid() throws MalformedURLException {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities("firefox", "55", Platform.WIN8);

        WebDriver webDriver = new RemoteWebDriver(new URL(URL), desiredCapabilities);
        webDriver.get("http://google.com");
        webDriver.quit();

    }

}
