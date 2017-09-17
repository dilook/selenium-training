package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Di on 27.08.2017.
 */
public class LitecartCountrGeoTest extends AdminLoginTest {

    @Test
    public void assertCountries() {
        navigateTo("/admin/?app=countries&doc=countries");

        List<WebElement> countriesElement = webDriver.findElements(By.xpath("//*[contains(@class, 'row')]/td[5]"));
        int result;
        for (int i = 0; i < countriesElement.size() - 1; i++) {
            result = countriesElement.get(i).getText().compareTo(countriesElement.get(i + 1).getText());
            assertTrue("Сортировка стран не в алфавитном порядке", result < 0);
        }
    }

    @Test
    public void assertZonesFromCountries() {
        navigateTo("/admin/?app=countries&doc=countries");

        int countriesSize = webDriver.findElements(By.className("row")).size();
        WebElement row;

        for (int i = 1; i < countriesSize + 1; i++) {
            row = webDriver.findElement(By.xpath("//*[contains(@class, 'row')][" + i + "]"));
            if (!row.findElement(By.xpath("./td[6]")).getText().equals("0")) {
                row.findElement(By.tagName("a")).click();
                checkZones(webDriver, "");
                webDriver.navigate().back();
            }
        }
    }

    @Test
    public void assertsZonesFromGeoZones() {
        navigateTo("/admin/?app=geo_zones&doc=geo_zones");

        int geoZonesSize = webDriver.findElements(By.cssSelector(".row")).size();
        WebElement row;

        for (int i = 1; i < geoZonesSize + 1; i++) {
            row = webDriver.findElement(By.xpath("//*[contains(@class, 'row')][" + i + "]"));
            row.findElement(By.xpath("./td[3]/a")).click();

            checkZones(webDriver, "select");
            webDriver.navigate().back();
        }
    }

    private void checkZones(WebDriver webDriver, String type) {
        WebElement table = webDriver.findElement(By.id("table-zones"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        int result;
        WebElement curElement, nextElement;
        for (int i = 1; i < rows.size() - 2; i++) {
            curElement = rows.get(i).findElement(By.xpath("./td[3]"));
            nextElement = rows.get(i + 1).findElement(By.xpath("./td[3]"));

            if (type.equals("select")) {
                nextElement = nextElement.findElement(By.cssSelector("[selected = selected"));
                curElement = curElement.findElement(By.cssSelector("[selected = selected"));
            }

            result = curElement.getText().compareTo(nextElement.getText());

            assertTrue("Сортировка зон не в алфавитном порядке", result < 0);
        }

    }

}
