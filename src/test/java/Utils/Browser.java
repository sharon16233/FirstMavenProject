package Utils;

import Pages.AllPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    public static WebDriver driver;

    public static void initDriver() {
        System.setProperty(Constants.WEB_DRIVER, Constants.CHROME_DRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
