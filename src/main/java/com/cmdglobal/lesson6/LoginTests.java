package com.cmdglobal.lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
public class LoginTests {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // Test Case 1: Valid login
    @Test
    public void testValidLogin() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
        // Assert that the user is redirected to the inventory page
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    // Test Case 2: Invalid login
    @Test
    public void testInvalidLogin() {
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        // Assert that error message is displayed
        WebElement error = driver.findElement(By.cssSelector(".error-message-container"));
        assertTrue(error.isDisplayed());
    }
}
