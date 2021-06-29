package Tests;


import Utils.Browser;
import Utils.Utils;
import Utils.Constants;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Lesson07 {

    public static WebDriver driver;
    public static final String baseUrl = "https://demoqa.com/text-box";
    JavascriptExecutor js = (JavascriptExecutor) driver;

    private WebElement fullNameField = driver.findElement(By.id("userName"));
    private WebElement emailField = driver.findElement(By.id("userEmail"));
    private WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
    private WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
    private WebElement submitButton = driver.findElement(By.id("submit"));

    @Test
    public void test_01() throws InterruptedException {

        Utils.sendText(fullNameField, "test");
        Utils.sendText(emailField, "test@test.com");
        Utils.sendText(currentAddressField, "test address");
        Utils.sendText(permanentAddressField, "permanent address test");
        Utils.scrollToElement(submitButton);
        Utils.clickOnElement(submitButton);

        WebElement massage = driver.findElement(By.id("output"));
        Assert.assertTrue(massage.isDisplayed());
    }


    @BeforeAll
    public static void before() {
        Browser.initDriver();
        driver = Browser.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterAll
    public static void after() {
        driver.quit();
    }



}
