package com.cmdglobal.lesson7;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
public class lesson7 {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void testRemoveCheckbox() {
        WebElement removeButton = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
        removeButton.click();
        WebElement message = Utils.waitForElementVisible(driver, By.id("message"), 10);
        assertTrue(message.getText().contains("It's gone!"));
    }

    @Test
    public void testEnableTextField() {
        WebElement enableButton = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        enableButton.click();
        WebElement inputField = Utils.waitForElementEnabled(driver, By.xpath("//form[@id='input-example']/input"), 10);
        assertTrue(inputField.isEnabled());
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
