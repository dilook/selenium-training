package com.dilook.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/**
 * Created by Di on 17.09.2017.
 */
public class CartPage extends Page {

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "li.shortcut")
    public List<WebElement> cartSize;

    @FindBy(name = "remove_cart_item")
    public WebElement removeCartItemButton;

    public int getCartSize() {
        return this.cartSize.size();
    }

    public WebElement getFirstItemOfCart() {
        printPosition();
        return this.cartSize.get(0);
    }

    public void removeItemOfCart(int i) {
        WebElement item = webDriver.findElement(By.cssSelector(".dataTable td.item"));
        this.removeCartItemButton.click();

        System.out.println("Item " + i + ": " + item.getText() + ", was removed");

        webDriverWait.until(stalenessOf(item));
    }

    public void removeLastItemOfCart(int i) {
        WebElement table = webDriver.findElement(By.id("box-checkout-summary"));

        String textOfItem = webDriver.findElement(By.cssSelector(".dataTable td.item")).getText();
        this.removeCartItemButton.click();

        System.out.println("Item " + i + ": " + textOfItem + " was removed");

        webDriverWait.until(stalenessOf(table));
    }

    private void printPosition() {
        if (this.getCartSize() == 0) {
            System.out.println("Count of position: 1");
        } else {
            System.out.println("Count of position: " + this.getCartSize());
        }
    }
}
