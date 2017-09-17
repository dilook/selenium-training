package com.dilook.training.selenium;

import org.junit.BeforeClass;

/**
 * Created by Di on 29.08.2017.
 */
public class OpenClientPageTest extends BaseTest {

    @BeforeClass
    public static void openClientSideTest() {
        webDriver.get("http://" + url + "/en/");
    }
}
