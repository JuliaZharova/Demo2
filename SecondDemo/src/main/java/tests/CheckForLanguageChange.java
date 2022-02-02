package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static PageObject.BasePage.driver;

public class CheckForLanguageChange{

    @Test(groups = "regression")
    public void checksChoosingStaysOnStaysPage() {
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

    @AfterMethod
    public void setDown() {
        driver.quit();
    }
}
