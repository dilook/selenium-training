package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Di on 15.08.2017.
 */
public class MyFirstTest {

    private WebDriver webDriver;

    @Before
    public void start() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-fullscreen");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        caps.setCapability(ChromeOptions.CAPABILITY, opt);
        webDriver = new ChromeDriver(caps);
        HasCapabilities capabilities = (HasCapabilities) webDriver;
        System.out.println(capabilities.getCapabilities());
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
