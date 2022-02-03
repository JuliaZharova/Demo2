package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckLoginPage {

    @DataProvider(name = "validDataForLogIn")
    public Object[][] validDataForLogIn() {
        return new Object[][]{
                {"anneta792@gmail.com", "Kozyreva89"},
        };
    }
    @Test (groups = "smoke",
            description = "Check that user can log in with valid data",
            dataProvider = "validDataForLogIn")
    public void checkValidDataLogIn(String email, String password) {
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver())
                .openBooking()
                .checkLoginButtonIsDisplayed()
                .clickOnLoginButton()
                .checkLogInPageIsDisplayed()
                .InputValidMail(email)
                .clickOnSubmitEmailButton()
                .checkPasswordPageIsDisplayed()
                .InputValidPassword(password)
                .clickOnSubmitPasswordButton()
                .checkSuccessMessage();
    }
   @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}