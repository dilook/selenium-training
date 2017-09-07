package com.dilook.training.selenium;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;

import static com.dilook.training.selenium.WebDriverTestUtils.selectWebDriver;

/**
 * Created by Di on 29.08.2017.
 */
public class BaseTest {

    static WebDriver webDriver;
    static WebDriverWait webDriverWait;

    @BeforeClass
    public static void start() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    @AfterClass
    public static void stop() {
        webDriver.quit();
        webDriver = null;
    }

    static void navigateTo(String page) {
        webDriver.navigate().to(page);
    }

    static Boolean areElementsPresent(By locator) {
        return webDriver.findElements(locator).size() > 0;
    }

    static Boolean areElementsPresent(WebElement webElement, By locator) {
        return webElement.findElements(locator).size() > 0;
    }

    static void checked(By locator) {
        WebElement checkbox = webDriver.findElement(locator);
        checked(checkbox);
    }

    static void checked(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    static void unchecked(By locator) {
        WebElement checkbox = webDriver.findElement(locator);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    static WebElement setElementValue(By locator, String value) {
        WebElement webElement = webDriver.findElement(locator);
        webElement.sendKeys(value);

        return webElement;
    }

    static void clickByElement(By locator) {
        webDriver.findElement(locator).click();
    }

    static void clickByElement(WebElement webElement, By locator) {
        webElement.findElement(locator).click();
    }

    static void setElementBigValue(By locator, String bigValue) {
        StringSelection selection = new StringSelection(bigValue);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        setElementValue(locator, Keys.chord(Keys.CONTROL, "v"));
    }

    static void selectElementValue(By locator, String value) {
        Select price = new Select(webDriver.findElement(locator));
        price.selectByVisibleText(value);
    }

    static String generator(Integer length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String digits = "0123456789";
        String alphanum = upper + lower + digits;

        return RandomStringUtils.random(length, alphanum.toCharArray());
    }

    private void unhide(WebDriver driver, WebElement element) {
        String script = "arguments[0].style.opacity=1;"
                + "arguments[0].style['transform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['MozTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['WebkitTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['msTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['OTransform']='translate(0px, 0px) scale(1)';"
                + "return true;";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public void attachFile(By locator, String file) {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = new File(classLoader.getResource(file).getFile()).getAbsolutePath();
        WebElement input = webDriver.findElement(locator);

        unhide(webDriver, input);
        input.sendKeys(path);
    }

}
