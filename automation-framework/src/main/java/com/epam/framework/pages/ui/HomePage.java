package com.epam.framework.pages.ui;

import com.epam.framework.base.BasePage;
import org.openqa.selenium.By;

import static com.epam.framework.utils.WaitUtils.*;

public class HomePage extends BasePage {

    private final By cart = By.cssSelector(".shopping_cart_link");

    private final By[] productButtons = {
            By.id("add-to-cart-sauce-labs-bike-light"),
            By.id("add-to-cart-sauce-labs-onesie"),
            By.id("add-to-cart-sauce-labs-fleece-jacket"),
            By.id("add-to-cart-test.allthethings()-t-shirt-(red)"),
            By.id("add-to-cart-sauce-labs-bolt-t-shirt"),
            By.id("add-to-cart-sauce-labs-backpack")
    };

    public boolean isHomePageDisplayed() {
        return driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed();
    }

    public void addAllProductsToCart() {
        for (By button : productButtons) {
            clickWhenReady(driver, button, 10);
        }
    }

    public void goToCart() {
        clickWhenReady(driver, cart, 10);
    }
}
