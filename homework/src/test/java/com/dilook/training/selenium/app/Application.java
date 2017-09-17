package com.dilook.training.selenium.app;

import com.dilook.training.selenium.pages.CartPage;
import com.dilook.training.selenium.pages.ProductPage;
import com.dilook.training.selenium.pages.TitlePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.dilook.training.selenium.WebDriverTestUtils.selectWebDriver;

/**
 * Created by Di on 17.09.2017.
 */
public class Application {

    private WebDriver webDriver;

    private TitlePage titlePage;
    private ProductPage productPage;
    private CartPage cartPage;

    public Application() {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
        titlePage = new TitlePage(webDriver);
        productPage = new ProductPage(webDriver);
        cartPage = new CartPage(webDriver);
    }

    public void quit() {
        webDriver.quit();
    }

    public void addProductToCart(int count) {
        titlePage.open();
        for (int i = 1; i < count + 1; i++) {
            titlePage.mostPopProduct.click();
            productPage.selectSizeIfExist("Small");
            productPage.addProduct(i);
            productPage.back();
        }
        titlePage.cart.click();
    }

    public void removeProductFromCart() {
        int cartItems = cartPage.getCartSize();

        for (int i = 1; i < cartItems; i++) {
            cartPage.getFirstItemOfCart().click();
            cartPage.removeItemOfCart(i);
        }
        cartPage.removeLastItemOfCart(cartItems);
    }

}
