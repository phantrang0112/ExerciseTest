package com.cmdglobal.lesson6;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTests {
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

    // Test Case 1: Complete checkout process
    @Test
    public void testCheckoutSuccess() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Trang");
        driver.findElement(By.id("last-name")).sendKeys("Phan");
        driver.findElement(By.id("postal-code")).sendKeys("70000");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        WebElement successMessage = driver.findElement(By.className("complete-header"));
        assertEquals("Thank you for your order!", successMessage.getText());
    }

    // Test Case 2: Missing checkout info
    @Test
    public void testCheckoutMissingInfo() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        // Leave fields empty
        driver.findElement(By.id("continue")).click();

        WebElement error = driver.findElement(By.cssSelector(".error-message-container"));
        assertTrue(error.isDisplayed());
    }
}
