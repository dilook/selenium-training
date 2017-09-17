package com.dilook.training.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.dilook.training.selenium.WebDriverTestUtils.url;

/**
 * Created by Di on 17.09.2017.
 */
public class TitlePage extends Page {

    public TitlePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public TitlePage open() {
        webDriver.get("http://" + url + "/en/");
        return this;
    }

    @FindBy(css = "#box-most-popular li.product")
    public WebElement mostPopProduct;

    @FindBy(id = "cart")
    public WebElement cart;
}
