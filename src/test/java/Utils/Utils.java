package Utils;

import Pages.AllPages;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utils {

    public static AllPages allPages;

    @BeforeAll
    public static void initiateDriver() {
        Browser.initDriver();
        allPages = new AllPages(Browser.getDriver());
        Browser.getDriver().get(Constants.URL);
    }

    @AfterAll
    public static void quitDriver() {
        Browser.getDriver().quit();
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void waitForElement(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Browser.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
