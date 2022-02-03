package tests;

import PageObject.BasePage;
import PageObject.CarRentalCoronavirusPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckCarRentalCoronavirusPage {

    @Test(groups = "regression")
    public void checkCarRentalCoronavirusPage() {
        WebDriverManager.chromedriver().setup();
        new CarRentalCoronavirusPage(new ChromeDriver()).openBooking()
                .checkMenuItemsTitlesQuantity()
                .clickOnCarRentalsItem()
                .checkCarRentalsPageIsDisplayed()
                .checkCleanCarsInfoBlockIsDisplayed()
                .checkTitleCleanCarsInfoBlock()
                .checkFindOutHowLinkIsEnabled()
                .checkFindOutHowLinkTitle()
                .clickOnFindOutHowLink()
                .checkCarRentalCoronavirusPageIsDisplayed()
                .checkTitleCarRentalCoronavirusPage();
    }

    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}