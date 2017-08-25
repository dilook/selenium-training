package com.dilook.training.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Di on 24.08.2017.
 */
public class WebDriverTestUtils {

    protected static WebDriver selectWebDriver(DesiredCapabilities caps) throws IOException {
        String browser = System.getProperty("browser", "CR");
        System.out.println(browser);

        switch (browser) {
            case "FF":
                return caps == null ? new FirefoxDriver() : new FirefoxDriver(caps);

            case "IE":
                return caps == null ? new InternetExplorerDriver() : new InternetExplorerDriver(caps);

            case "CR":
                return caps == null ? new ChromeDriver() : new ChromeDriver(caps);

            case "FFESR":
                FirefoxOptions fo = new FirefoxOptions()
                        .setLegacy(true)
                        .setBinary(extractESRPath("src/test/resources/caps.properties", "esr.path"));
                return new FirefoxDriver(fo);

            case "FFNIGHT":
                fo = new FirefoxOptions()
                        .setBinary(extractESRPath("src/test/resources/caps.properties", "nightly.path"))
                        .setProfile(new FirefoxProfile());

                return new FirefoxDriver(fo);

            default:
                return caps == null ? new ChromeDriver() : new ChromeDriver(caps);
        }
    }

    private static String extractESRPath(String propFilePath, String propName) throws IOException {
        Properties properties = new Properties();

        try (FileReader fr = new FileReader(new File(propFilePath))) {
            properties.load(fr);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        return properties.getProperty(propName);
    }


}
