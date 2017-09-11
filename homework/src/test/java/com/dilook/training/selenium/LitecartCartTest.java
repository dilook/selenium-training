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
        if (cartSize == 0) {
            System.out.println("Count of position: 1");
        } else {
            System.out.println("Count of position: " + cartSize);
        }
        WebElement item;
        String textOfItem;
        for (int i = 1; i < cartSize; i++) {
            clickByElement(By.cssSelector("li.shortcut"));
            item = webDriver.findElement(By.cssSelector(".dataTable td.item"));
            textOfItem = item.getText();

            clickByElement(By.name("remove_cart_item"));

            System.out.println("\nItem " + i + ": " + textOfItem + ", was removed");

            webDriverWait.until(stalenessOf(item));
        }

        WebElement table = webDriver.findElement(By.id("box-checkout-summary"));
        textOfItem = webDriver.findElement(By.cssSelector(".dataTable td.item")).getText();
        clickByElement(By.name("remove_cart_item"));
        System.out.println("\nItem " + cartSize + ": " + textOfItem + " was removed");

        webDriverWait.until(stalenessOf(table));
    }
}
