package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Di on 03.09.2017.
 */
public class LitecartNewUserTest extends OpenClientPageTest {
    
    @Test
    public void registerUser() {
        navigateTo("https://litecart.000webhostapp.com/en/create_account");

        webDriver.findElement(By.name("firstname")).sendKeys("Gordon");
        webDriver.findElement(By.name("lastname")).sendKeys("Freeman");
        webDriver.findElement(By.name("address1")).sendKeys("Nova Prospekt Str. 25");
        webDriver.findElement(By.name("address2")).sendKeys("Mohave, Value 8");
        webDriver.findElement(By.name("postcode")).sendKeys("15623");
        webDriver.findElement(By.name("city")).sendKeys("City 17");
        Select country = new Select(webDriver.findElement(By.name("country_code")));
        country.selectByVisibleText("United States");
        //webDriverWait.until(visibilityOf(webDriver.findElement(By.cssSelector("select[name = 'zone_code']"))));
        Select zone = new Select(webDriver.findElement(By.cssSelector("select[name = 'zone_code']")));
        zone.selectByVisibleText("Guam");
        String rand = generator(3);
        webDriver.findElement(By.name("email")).sendKeys("ex" + rand + "@test.com");
        webDriver.findElement(By.name("phone")).sendKeys("12345678");
        webDriver.findElement(By.name("password")).sendKeys("passwd");
        webDriver.findElement(By.name("confirmed_password")).sendKeys("passwd");
        webDriver.findElement(By.name("create_account")).click();

        webDriverWait.until(titleIs("Online Store | My Store"));

        webDriver.findElement(By.id("box-account")).findElement(By.linkText("Logout")).click();

    }
}
