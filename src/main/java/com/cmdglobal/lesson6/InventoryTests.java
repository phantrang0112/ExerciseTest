package com.cmdglobal.lesson6;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTests {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // Test Case 1: Check total number of products
    @Test
    public void testProductCount() {
        int expectedProductCount = 6;
        int actualCount = driver.findElements(By.className("inventory_item")).size();
        assertEquals(expectedProductCount, actualCount);
    }

    // Test Case 2: Check product names are displayed
    @Test
    public void testProductNamesDisplayed() {
        for (WebElement item : driver.findElements(By.className("inventory_item_name"))) {
            assertFalse(item.getText().isEmpty());
        }
    }
}
