package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Di on 16.08.2017.
 */
public class LitecartLoginTest {

    private WebDriver webDriver;

    @Before
    public void start() {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
    }

    private WebDriver selectWebDriver(DesiredCapabilities caps) {
        String browser = System.getProperty("browser", "CR");
        System.out.println(browser);

        switch (browser) {
            case "FF":
                return caps == null ? new FirefoxDriver() : new FirefoxDriver(caps);

            case "IE":
                return caps == null ? new InternetExplorerDriver() : new InternetExplorerDriver(caps);

            case "CR":
                return caps == null ? new ChromeDriver() : new ChromeDriver(caps);

            default:
                return caps == null ? new ChromeDriver() : new ChromeDriver(caps);
        }
    }

    @Test
    public void login() {
        webDriver.navigate().to("http://localhost/litecart/admin/login.php");
        webDriver.findElement(By.name("username")).sendKeys("admin");
        webDriver.findElement(By.name("password")).sendKeys("admin");
        webDriver.findElement(By.name("login")).click();
    }

    @After
    public void stop() {
        webDriver.quit();
        webDriver = null;
    }
}
