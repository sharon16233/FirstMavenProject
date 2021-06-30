package Homework07;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoQA extends Utils {

    /*Base Url*/
    public static final String baseUrl = "https://demoqa.com/text-box";

    /*Page elements*/
    public static WebElement fullNameField;
    public static WebElement emailField;
    public static WebElement currentAddressField;
    public static WebElement permanentAddressField;
    public static WebElement submitButton;

    /*Input*/
    public static final String fullName = "Sharon Groisman";
    public static final String email = "sharon@test.com";
    public static final String currentAddress = "address test";
    public static final String permanentAddress = "permanent address test";



    public static void findElements() {
        fullNameField = driver.findElement(By.id("userName"));
        emailField = driver.findElement(By.id("userEmail"));
        currentAddressField = driver.findElement(By.id("currentAddress"));
        permanentAddressField = driver.findElement(By.id("permanentAddress"));
        submitButton = driver.findElement(By.id("submit"));
    }

    @Test
    public void checkTextAfterSubmit() {
        driver.get(baseUrl);
        findElements();
        sendText(fullNameField, fullName);
        sendText(emailField, email);
        sendText(currentAddressField, currentAddress);
        sendText(permanentAddressField, permanentAddress);
        scrollToElement(submitButton);
        clickOnElement(submitButton);

        WebElement outputText = driver.findElement(By.cssSelector("[class='border col-md-12 col-sm-12']"));

        String expectedText = "Name:" + fullName + "\n" +
                              "Email:" + email + "\n" +
                              "Current Address :" + currentAddress + "\n" +
                              "Permananet Address :" + permanentAddress;


        Assert.assertEquals(expectedText, outputText.getText());
    }


}
