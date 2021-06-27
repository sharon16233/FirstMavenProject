package Pages;

import org.openqa.selenium.WebDriver;

public class AllPages {

    public static MainPage mainPage;

    public AllPages(WebDriver driver) {
        mainPage = new MainPage(driver);
    }
}
