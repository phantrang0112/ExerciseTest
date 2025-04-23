package com.cmdglobal.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver driver;

    // Locators
    private By backpackAddToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Add item to cart
    public void addBackpackToCart() {
        driver.findElement(backpackAddToCartBtn).click();
    }

    // Navigate to cart
    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
