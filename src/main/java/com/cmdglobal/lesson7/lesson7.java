package com.cmdglobal.lesson7;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class lesson7 {
    WebDriver driver;
    WebDriverWait  wait;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void testRemoveCheckbox() {
        WebElement removeButton = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
        removeButton.click();
        WebElement message = Utils.waitForElementVisible(driver, By.id("message"), 10);
        assertTrue(message.getText().contains("It's gone!"));
    }

    @Test
    @Order(2)
    public void testEnableTextField() {
        WebElement enableButton = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        enableButton.click();
        WebElement inputField = Utils.waitForElementEnabled(driver, By.xpath("//form[@id='input-example']/input"), 10);
        assertTrue(inputField.isEnabled());
    }

    @Test
    @Order(3)
    public void testDynamicLoadingExample1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        Thread.sleep(3000);

        WebElement finish = driver.findElement(By.id("finish"));
        Assertions.assertEquals("Hello World!", finish.getText());
    }

    @Test
    @Order(4)
    public void testDynamicLoadingExample2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.cssSelector("#start button")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        WebElement finish = driver.findElement(By.id("finish"));
        Assertions.assertTrue(finish.isDisplayed());
    }

    @Test
    @Order(5)
    public void testSelectDropdownOption1() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");

        Assertions.assertEquals("Option 1", dropdown.getFirstSelectedOption().getText());
    }

    @Test
    @Order(6)
    public void testSelectDropdownOption2() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByValue("2");

        Assertions.assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
    }

    @Test
    @Order(7)
    public void testAllLinksVisible() {
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");
        List<WebElement> links = driver.findElements(By.cssSelector("ul li"));

        // Expect at least 4 links visible
        Assertions.assertTrue(links.size() >= 4);
    }

    @Test
    @Order(8)
    public void testRefreshMayChangeElements() {
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");
        List<WebElement> firstVisit = driver.findElements(By.cssSelector("ul li"));

        driver.navigate().refresh();
        List<WebElement> secondVisit = driver.findElements(By.cssSelector("ul li"));

        // The number of elements may vary (this tests dynamic behavior)
        Assertions.assertNotEquals(firstVisit.size(), secondVisit.size(), "Element count may vary on refresh");
    }

    @Test
    @Order(9)
    public void testSimpleAlertAccept() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        Assertions.assertEquals("You successfully clicked an alert", result.getText());
    }

    @Test
    @Order(10)
    public void testConfirmAlertDismiss() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        Assertions.assertEquals("You clicked: Cancel", result.getText());
    }

    @Test
    @Order(11)
    public void testAddElement() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector(".added-manually"));

        Assertions.assertFalse(deleteButtons.isEmpty(), "Delete button should appear");
    }

    @Test
    @Order(12)
    public void testRemoveElement() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        WebElement deleteButton = driver.findElement(By.cssSelector(".added-manually"));
        deleteButton.click();
        Assertions.assertTrue(driver.findElements(By.cssSelector(".added-manually")).isEmpty(), "Delete button should be removed");
    }
}


