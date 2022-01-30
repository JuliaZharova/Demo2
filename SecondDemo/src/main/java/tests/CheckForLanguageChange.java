package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static PageObject.BasePage.driver;

public class CheckForLanguageChange {


    @Test
    public void checksChoosingStaysOnStaysPage() {
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver()).openBooking()
                .checkLanguageSelectionButtonIsEnabled()
                .clickOnLanguageSelectionButton()
                .checkLanguagePopUpIsDisplayed()
                .checkEnglishLanguageButtonIsEnabled()
                .clickOnEnglishLanguageButton()
                .checkLanguagePopUpIsNotDisplayed()
                .checkTitleFindYourNextStayInEng();

    }

    //    @AfterMethod
    public void setDown() {
        driver.quit();
    }
}
