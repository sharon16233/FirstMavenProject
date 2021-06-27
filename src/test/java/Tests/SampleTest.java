package Tests;

import Pages.AllPages;
import Pages.MainPage;
import Utils.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class SampleTest extends Utils {

    @Test
    public void test01() throws InterruptedException {
        clickOnElement(AllPages.mainPage.elementsButton);
        waitForElement(Constants.THREE_SECONDS);
    }

}
