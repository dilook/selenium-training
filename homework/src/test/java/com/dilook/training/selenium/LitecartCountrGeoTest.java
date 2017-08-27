package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.dilook.training.selenium.UITestUtils.login;
import static com.dilook.training.selenium.WebDriverTestUtils.selectWebDriver;

/**
 * Created by Di on 27.08.2017.
 */
public class LitecartCountrGeoTest {
    private WebDriver webDriver;

    @Before
    public void start() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
    }

    @Test
    public void assertCountry() {
        login(webDriver, "http://localhost/litecart/admin/?app=countries&doc=countries");

        List<WebElement> countriesElement = webDriver.findElements(By.xpath("//*[contains(@class, 'row')]/td[5]"));
        ArrayList<String> textCountries = new ArrayList<>();
        for (WebElement country : countriesElement) {
            textCountries.add(country.getText());
        }

        ArrayList<String> sortCountries = new ArrayList<>();
        Collections.sort(textCountries);

        //Arrays.equals(textCountries, sortCountries);

    }

    @After
    public void stop() {
        webDriver.quit();
        webDriver = null;
    }

}
