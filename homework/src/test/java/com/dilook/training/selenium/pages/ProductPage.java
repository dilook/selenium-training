package com.dilook.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;

/**
 * Created by Di on 17.09.2017.
 */
public class ProductPage extends Page {

    public void back() {
        webDriver.navigate().back();
    }

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(name = "options[Size]")
    private WebElement sizeOfProduct;

    @FindBy(name = "add_cart_product")
    private WebElement addToCartButton;

    @FindBy(css = "span.quantity")
    private WebElement quantityProduct;

    public void selectSizeIfExist(String value) {
        if (isElementPresent(By.name("options[Size]"))) {
            new Select(this.sizeOfProduct).selectByVisibleText(value);
        }
    }

    public void addProduct(int i) {
        this.addToCartButton.click();
        webDriverWait.until(attributeToBe(this.quantityProduct, "innerText", String.valueOf(i)));
    }

}
