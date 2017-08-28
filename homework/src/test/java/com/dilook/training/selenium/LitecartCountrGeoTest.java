package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.List;

import static com.dilook.training.selenium.UITestUtils.login;
import static com.dilook.training.selenium.WebDriverTestUtils.selectWebDriver;
import static org.junit.Assert.assertTrue;

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
        int result;
        for (int i = 0; i < countriesElement.size() - 1; i++) {
            result = countriesElement.get(i).getText().compareTo(countriesElement.get(i + 1).getText());
            assertTrue("Сортировка стран не в алфавитном порядке", result < 0);
        }

        WebElement text;

        for (int i = 0; i < countriesElement.size(); i++) {
            text = webDriver.findElement(By.xpath("//*[contains(@class, 'row')][" + i + "]/td[6]"));
            if (text.getText() != "0") {
                text.click();
                checkZones(webDriver);
            }
        }


    }

    @After
    public void stop() {
        webDriver.quit();
        webDriver = null;
    }

    private void checkZones(WebDriver webDriver) {
        WebElement table = webDriver.findElement(By.id("table-zones"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));


        int result;
        for (int i = 0; i < rows.size() - 1; i++) {
            result = row.get(i).getText().compareTo(countriesElement.get(i + 1).getText());
            assertTrue("Сортировка стран не в алфавитном порядке", result < 0);
        }

    }

}
