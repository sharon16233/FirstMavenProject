package Homework07;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class Walla extends Utils {

    /*Base Url*/
    public static final String baseUrl = "https://friends.walla.co.il/login";

    /*Page elements*/
    public static WebElement usernameField;
    public static WebElement nextButton;

    public static void findElements() {
        usernameField = driver.findElement(By.cssSelector("[formcontrolname='username']"));
        nextButton = driver.findElement(By.cssSelector("[class='common-button-1 full-line']"));
    }

    @Test
    public void badLoginTest() {
        driver.get(baseUrl);
        findElements();
        sendText(usernameField, "aaaaaa");
        clickOnElement(nextButton);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement passwordField = driver.findElement(By.cssSelector("[placeholder='סיסמה']"));
        waitForElement(passwordField);
        sendText(passwordField, "aaa");

        // Find the nextButton element again to avoid stale error.
        nextButton = driver.findElement(By.cssSelector("[class='common-button-1 full-line']"));
        clickOnElement(nextButton);


        WebElement errorMessage = driver.findElement(By.id("invalid-data-error"));
        waitForElement(errorMessage);

        String expectedErrorMessage = "פרטי ההתחברות שגויים";

        Assert.assertEquals(expectedErrorMessage, errorMessage.getText());

    }

}
