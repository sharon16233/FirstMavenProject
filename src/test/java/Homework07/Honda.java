package Homework07;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Honda extends Utils {

    /*Base Url*/
    public static final String baseUrl = "https://courses.letskodeit.com/practice";

    /*Page elements*/
    public static WebElement hondaRadioButton;
    public static WebElement benzRadioButton;

    public static void findElements() {
        hondaRadioButton = driver.findElement(By.id("hondaradio"));
        benzRadioButton = driver.findElement(By.id("benzradio"));
    }

    @Test
    public void hondaRadioButtonIsSelectedTest() {
        driver.get(baseUrl);
        findElements();
        clickOnElement(hondaRadioButton);
        Assert.assertTrue(hondaRadioButton.isSelected());

        clickOnElement(benzRadioButton);
        Assert.assertTrue(!hondaRadioButton.isSelected());
    }
}
