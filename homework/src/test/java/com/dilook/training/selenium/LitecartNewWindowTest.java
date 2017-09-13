package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Set;

/**
 * Created by Di on 13.09.2017.
 */
public class LitecartNewWindowTest extends AdminLoginTest {

    @Test
    public void openNewWindow() {
        navigateTo("http://localhost/litecart/admin/?app=countries&doc=countries");

        clickByElement(By.cssSelector("a.button"));
        int countOfLinks = webDriver.findElements(By.className("fa-external-link")).size();

        String originalWindow = webDriver.getWindowHandle();
        for (int i = 1; i < countOfLinks + 1; i++) {
            clickByElement(By.xpath("(//*[contains(@class, 'fa-external-link')])[" + i + "]"));

            String newWindow = webDriverWait.until(thereIsWindowOtherThan(originalWindow));
            webDriver.switchTo().window(newWindow);

            System.out.println(webDriver.getTitle());

            webDriver.close();
            webDriver.switchTo().window(originalWindow);
        }

    }

    private ExpectedCondition<String> thereIsWindowOtherThan(String oldWindow) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver driver) {
                Set<String> handles = webDriver.getWindowHandles();
                handles.remove(oldWindow);

                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }
}
