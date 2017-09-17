package com.dilook.training.selenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.openqa.selenium.Proxy.ProxyType.AUTODETECT;

/**
 * Created by Di on 24.08.2017.
 */
class WebDriverTestUtils {

    static WebDriver selectWebDriver(DesiredCapabilities caps) {
        String browser = System.getProperty("browser", "CR");
        System.out.println(browser);

        switch (browser) {
            case "FF":
                FirefoxOptions fo = new FirefoxOptions()
                        .setLegacy(false)
                        .setBinary(extractPath("src/test/resources/caps.properties", "ff.path"));
                caps.setCapability(CapabilityType.PROXY, setProxy());
                caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, fo);
                return new FirefoxDriver(caps);

            case "IE":
                WebDriver ieDriver = caps == null ? new InternetExplorerDriver() : new InternetExplorerDriver(caps);
                ieDriver.manage().window().maximize();
                ieDriver.manage().deleteAllCookies();
                return ieDriver;

            case "CR":
                return caps == null ? new ChromeDriver() : new ChromeDriver(caps);

            case "FFESR":
                fo = new FirefoxOptions()
                        .setLegacy(true)
                        .setBinary(extractPath("src/test/resources/caps.properties", "esr.path"));
                return new FirefoxDriver(fo);

            case "FFNIGHT":
                fo = new FirefoxOptions()
                        .setBinary(extractPath("src/test/resources/caps.properties", "nightly.path"))
                        .setProfile(new FirefoxProfile());

                return new FirefoxDriver(fo);

            default:
                return caps == null ? new ChromeDriver() : new ChromeDriver(caps);
        }

    }

    public static String extractPath(String propFilePath, String propName) {
        Properties properties = new Properties();

        try {
            FileReader fr = new FileReader(new File(propFilePath));
            try {
                properties.load(fr);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return properties.getProperty(propName);
    }

    private static Proxy setProxy() {
        Proxy proxy = new Proxy();
        proxy.setProxyType(AUTODETECT);

        return proxy;
    }


}
