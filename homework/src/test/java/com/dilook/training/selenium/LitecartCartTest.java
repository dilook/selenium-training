package com.dilook.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

/**
 * Created by Di on 07.09.2017.
 */
public class LitecartCartTest extends OpenClientPageTest {

    @Test
    public void cartTest() {
        By sizeLocator;
        for (int i = 1; i < 4; i++) {
            clickByElement(By.cssSelector("#box-most-popular li.product"));

            sizeLocator = By.name("options[Size]");
            if (areElementsPresent(sizeLocator)) {
                setElementValue(sizeLocator, "Small");
            }
            clickByElement(By.name("add_cart_product"));

            webDriverWait.until(textToBe(By.cssSelector("span.quantity"), String.valueOf(i)));
            webDriver.navigate().back();
        }

        clickByElement(By.id("cart"));

        int cartSize = webDriver.findElements(By.cssSelector("li.shortcut")).size();
        System.out.println("Count of position are: " + cartSize);
        WebElement item;
        for (int i = 1; i < cartSize + 1; i++) {
            clickByElement(By.xpath("//li[contains(@class, 'shortcut')][1]"));
            item = webDriver.findElement(By.xpath("(//*[contains(@class, 'dataTable')]//td[contains(@class, 'item')])[1]"));

            clickByElement(By.name("remove_cart_item"));

            System.out.println("Item " + i+ ": " + item.getText() + " was removed");

            webDriverWait.until(stalenessOf(item));
        }

    }
}
