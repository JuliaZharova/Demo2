package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckRegistrationViaEmail {

    @Test(groups = "regression", description = "Check that User can do registration via Email")
    public void checkRegistrationViaEmail() {
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver()).openBooking()
                .checkRegisterButtonIsDisplayed()
                .checkRegistrationButtonTitle()
                .clickOnRegistrationButton()
                .checkRegisterPageIsDisplayed()
                .checkRegisterPageTitle()
                .checkInputFieldIsEnable()
                .checkInputFieldLabel()
                .checkInputFieldIsEmpty()
                .checkRegisterButtonIsEnable()
                .checkRegisterButtonTitle()
                .inputEmail("tanya.finogentova@gmail.com")
                .clickOnRegisterButton()
                .checkPageTitleAfterClickRegisterButton()
                .checkRegisterButtonIsEnable()
                .checkRegisterButtonTitle();
    }

    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}