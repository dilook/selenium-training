package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

import static com.dilook.training.selenium.WebDriverTestUtils.selectWebDriver;

/**
 * Created by Di on 16.08.2017.
 */
public class LitecartLoginTest {

    private WebDriver webDriver;

    @Before
    public void start() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
    }

    @Test
    public void login() {
        webDriver.navigate().to("http://localhost/litecart/admin/login.php");
        webDriver.findElement(By.name("username")).sendKeys("admin");
        webDriver.findElement(By.name("password")).sendKeys("admin");
        webDriver.findElement(By.name("login")).click();

        System.out.println(((HasCapabilities) webDriver).getCapabilities());
    }

    @After
    public void stop() {
        webDriver.quit();
        webDriver = null;
    }
}
