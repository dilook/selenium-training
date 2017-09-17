package com.dilook.training.selenium.test;

import org.junit.Test;

/**
 * Created by Di on 17.09.2017.
 */
public class AddRemoveCartTest extends TestBase {


    @Test
    public void addAndRemoveProduct() {
        app.addProductToCart(3);
        app.removeProductFromCart();
    }
}
