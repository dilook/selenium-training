package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by Di on 04.09.2017.
 */
public class LitecartAddProductTest extends AdminLoginTest {
    static String BIG_TEXT = "It's really BIG text about everything things what happens in our great wonderful world!!!!";

    @Test
    public void newProduct() throws URISyntaxException {
        navigateTo("https://litecart.000webhostapp.com/admin/?app=catalog&doc=catalog");

        webDriver.findElement(By.xpath("//*[contains(text(), 'Add New Product')]")).click();

        checked(By.cssSelector("[name='status'][value='1']"));
        webDriver.findElement(By.name("name[en]")).sendKeys("Ugly Duck");
        webDriver.findElement(By.name("code")).sendKeys("ud_01");
        checked(By.cssSelector("[name='categories[]'][value='1']"));
        Select category = new Select(webDriver.findElement(By.name("default_category_id")));
        category.selectByVisibleText("Rubber Ducks");
        checked(By.cssSelector("[name='product_groups[]'][value='1-3']"));
        webDriver.findElement(By.name("quantity")).sendKeys("15");

        String path = new File("resources/uglu_duck.png").getAbsolutePath();
        webDriver.findElement(By.cssSelector("[type=file]")).sendKeys(path);

        By tabLocator = By.xpath("//*[contains(text(), 'Information')]");
        webDriver.findElement(By.className("tabs")).findElement(tabLocator).click();

        Select manufacturer = new Select(webDriver.findElement(By.name("manufacturer_id")));
        manufacturer.selectByVisibleText("ACME Corp.");
        webDriver.findElement(By.name("keywords")).sendKeys("ugly");
        webDriver.findElement(By.name("short_description[en]")).sendKeys("Simple duck");

        StringSelection selection = new StringSelection(BIG_TEXT);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        webDriver.findElement(By.name("description[en]")).sendKeys(Keys.chord(Keys.CONTROL, "V"));

        webDriver.findElement(By.name("head_title[en]")).sendKeys("Ugly Duck");
        webDriver.findElement(By.name("meta_description[en]")).sendKeys("meta_info");

        tabLocator = By.xpath("//*[contains(text(), 'Prices')]");
        webDriver.findElement(By.className("tabs")).findElement(tabLocator).click();
        webDriver.findElement(By.name("purchase_price")).sendKeys("5.50");
        Select price = new Select(webDriver.findElement(By.name("purchase_price_currency_code")));
        price.selectByVisibleText("Euros");
        webDriver.findElement(By.name("prices[USD]")).sendKeys("7.00");
        webDriver.findElement(By.name("prices[EUR]")).sendKeys("6.15");

        webDriver.findElement(By.name("save")).click();







    }
}
