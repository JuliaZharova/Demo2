package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckHelpCenterPage {

    @Test(groups = "regression")
    public void checkQuestionMarkButtonOpensHelpCenter() {
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver()).openBooking()
                .checkQuestionMarkButtonIsEnabled()
                .clickOnQuestionMarkButton()
                .checkHelpCenterIsDisplayed()
                .checkTitleTextHelpCenterPage();
    }

    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}