package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class BasicPage {

    public BasicPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
