package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

/**
 * Created by Di on 17.09.2017.
 */
public class LitecartLogsTest extends AdminLoginTest {

    @Test
    public void assertLogs() {
        navigateTo("/admin/?app=catalog&doc=catalog&category_id=1");

        String xpath = "(//tr[@class = 'row']/td[3][not(i)])";
        int productNumbers = webDriver.findElements(By.xpath(xpath)).size();

        for (int i = 1; i < productNumbers + 1; i++) {
            clickByElement(By.xpath(xpath + "[" + i + "]/a"));
            assertTrue(webDriver.manage().logs().get("browser").getAll().isEmpty());
            webDriver.navigate().back();
        }
    }
}
