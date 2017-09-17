package com.dilook.training.selenium;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Di on 04.09.2017.
 */
public class LitecartAddProductTest extends AdminLoginTest {
    private static String BIG_TEXT = "It's really BIG text about everything stuff what happens in our great wonderful world!!!!";

    @Test
    public void addProduct() {
        navigateTo("/admin/?app=catalog&doc=catalog");

        webDriver.findElement(By.xpath("//*[contains(text(), 'Add New Product')]")).click();

        checked(By.cssSelector("[name='status'][value='1']"));
        setElementValue(By.name("name[en]"), "Ugly Duck");
        setElementValue(By.name("code"), "ud_01");
        unchecked(By.cssSelector("[name='categories[]'][value='0']"));
        checked(By.cssSelector("[name='categories[]'][value='1']"));
        setElementValue(By.name("default_category_id"), "Rubber Ducks");
        checked(By.cssSelector("[name='product_groups[]'][value='1-3']"));
        setElementValue(By.name("quantity"), Keys.chord(Keys.CONTROL, "a"));
        setElementValue(By.name("quantity"), "15");

        attachFile(By.name("new_images[]"), "ugly_duck.png");

        By tabLocator = By.xpath("//*[contains(text(), 'Information')]");
        webDriver.findElement(By.className("tabs")).findElement(tabLocator).click();

        selectElementValue(By.name("manufacturer_id"), "ACME Corp.");
        setElementValue(By.name("keywords"), "ugly");
        setElementValue(By.name("short_description[en]"), "Simple duck");
        setElementBigValue(By.className("trumbowyg-editor"), BIG_TEXT);
        setElementValue(By.name("head_title[en]"), "Ugly Duck");
        setElementValue(By.name("meta_description[en]"), "meta_info");

        tabLocator = By.xpath("//*[contains(text(), 'Prices')]");
        webDriver.findElement(By.className("tabs")).findElement(tabLocator).click();

        setElementValue(By.name("purchase_price"), Keys.chord(Keys.CONTROL, "a"));
        setElementValue(By.name("purchase_price"), "5.50");
        selectElementValue(By.name("purchase_price_currency_code"), "Euros");
        setElementValue(By.name("prices[USD]"), "7.00");
        setElementValue(By.name("prices[EUR]"), "6.15");

        webDriver.findElement(By.name("save")).click();

        webDriverWait.until(visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Ugly Duck')]")));
    }

    @After
    public void deleteProduct() {
        checked(getCheckbox());
        webDriver.findElement(By.name("delete")).click();
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

        webDriverWait.until(invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Ugly Duck')]")));
    }

    private WebElement getCheckbox() {
        List<WebElement> rows = webDriver.findElements(By.className("row"));
        WebElement result = null;

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (areElementsPresent(cells.get(2), By.linkText("Ugly Duck"))) {
                result = cells.get(0);
            }
        }

        return result.findElement(By.tagName("input"));
    }

}