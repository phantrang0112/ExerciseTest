package com.cmdglobal.lesson8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceDemoTest  extends  BaseTest{
    @Test
    public void testLoginAndAddToCart() throws InterruptedException {
        // Login step
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(3000);
        // Add backpack to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        Thread.sleep(3000);
        inventoryPage.addBackpackToCart();
        Thread.sleep(3000);
        inventoryPage.goToCart();
        Thread.sleep(3000);
        // Verify item in cart
        CartPage cartPage = new CartPage(driver);
        Thread.sleep(3000);
        String itemName = cartPage.getFirstItemName();
        Thread.sleep(3000);
        // Assertion: Item in cart should be the backpack
        assertEquals("Sauce Labs Backpack", itemName);
    }
}
