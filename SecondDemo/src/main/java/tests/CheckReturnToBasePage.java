package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckReturnToBasePage {

    @Test(groups = "regression",
            description = "Check return to base page from car rentals and attractions page")
    public void checkReturnToBasePage() {
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver()).openBooking()
                .checkStaysButtonIsEnabled()
                .getStaysTitle()
                .checkCarRentalsButtonIsDisplayed()
                .clickOnCarRentals()
                .checkCarRentalsButtonIsEnabled()
                .getCarRentalsTitle()
                .clickOnBookingComFromCars()
                .checkStaysButtonIsEnabled()
                .checkAttractionsButtonIsDisplayed()
                .clickOnAttractions()
                .getAttractionsTitle()
                .clickOnBookingComFromAttractions()
                .checkStaysButtonIsEnabled();
    }

    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}