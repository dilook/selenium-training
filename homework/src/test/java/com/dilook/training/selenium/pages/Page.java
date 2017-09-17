package com.dilook.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Di on 17.09.2017.
 */
public class Page {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public Boolean isElementPresent(By locator){
        return webDriver.findElements(locator).size() > 0;

    }
/*
    public Page back(Page page) {
        webDriver.navigate().back();
        return page;
    }*/
}
