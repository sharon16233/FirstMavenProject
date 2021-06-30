package Homework07;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ZipCode extends Utils {

    /*Base Url*/
    public static final String baseUrl = "https://israelpost.co.il/%D7%A9%D7%99%D7%A8%D7%95%D7%AA%D7%99%D7%9D/%D7%90%D7%99%D7%AA%D7%95%D7%A8-%D7%9E%D7%99%D7%A7%D7%95%D7%93/";

    /*Page elements*/
    public static WebElement cityField;
    public static WebElement streetField;
    public static WebElement houseNumberField;
    public static WebElement searchButton;


    public static void findElements() {
        cityField = driver.findElement(By.id("City"));
        streetField = driver.findElement(By.id("Street"));
        houseNumberField = driver.findElement(By.id("House"));
        searchButton = driver.findElement(By.id("SearchZipSearch"));
    }

    @Test
    public void confirmZipCode() {
        driver.get(baseUrl);
        findElements();
        sendText(cityField, "באר יעקב");
        sendText(streetField, "ישפה");
        sendText(houseNumberField, "4");
        clickOnElement(searchButton);

        String expectedZipCode = "המיקוד לכתובת הינו: 7032040";

        WebElement zipCodeOutput = driver.findElement(By.id("searchresult"));
        waitForElement(zipCodeOutput);

        Assert.assertEquals(expectedZipCode, zipCodeOutput.getText());
    }
}
