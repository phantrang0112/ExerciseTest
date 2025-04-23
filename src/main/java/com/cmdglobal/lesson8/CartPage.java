package com.cmdglobal.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;
    private final By cartItemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstItemName() {
        return driver.findElement(cartItemName).getText();
    }
}
