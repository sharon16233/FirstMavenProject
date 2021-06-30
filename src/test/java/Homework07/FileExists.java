package Homework07;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileExists extends Utils {

    /*Base Url*/
    public static final String baseUrl = "http://thedemosite.co.uk/";


    public static final String path = "C:\\Users\\Sharon\\Downloads\\demo-code.zip";

    /*Page elements*/
    public static WebElement downloadLink;


    public static void findElements() {
        downloadLink = driver.findElement(By.linkText("download the free zip here"));
    }

    @Test
    public void downloadFile() throws InterruptedException {
        driver.get(baseUrl);
        scrollDown();
        findElements();
        waitForElement(downloadLink);
        clickOnElement(downloadLink);
        Thread.sleep(5000);
    }

    @Test
    public void fileExistsTest() {
        Assert.assertTrue(checkIfFileExists(path));
    }

    public static boolean checkIfFileExists(String path) {
        File tmpdir = new File(path);
        return tmpdir.exists();
    }

}
