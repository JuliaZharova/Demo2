package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckForLanguageChange{

    @Test(groups = "regression",
    description = "Check that all pages are in the same language")
    public void checksForLanguageChanges() {
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver()).openBooking()
                .checkLanguageSelectionButtonIsEnabled()
                .clickOnLanguageSelectionButton()
                .checkLanguagePopUpIsDisplayed()
                .checkEnglishLanguageButtonIsEnabled()
                .clickOnEnglishLanguageButton()
                .checkLanguagePopUpIsNotDisplayed()
                .checkTitleFindYourNextStayInEng()
                .openCareRentalPage()
                .checkTitleCarRentalsForAnyKindOfTripInEng()
                .openAttractionsPage()
                .checkTitleFindAndBookAGreatExperience()
                .openAirportTaxisPage()
                .checkTitleBookYourAirportTaxi()
                .openFlightsPage()
                .checkTitleCompareAndBookFlightsWithEaseInEng();
    }

    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}
