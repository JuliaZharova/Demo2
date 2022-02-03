package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckStaysResultPage{

    @Test(groups = "regression",
    description = "Check the filter 'Price is less than or equal to 2000'")
    public void checkFilterPriceLess2000() {
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver()).openBooking()
                .checkStaysButtonIsDisplayed()
                .enterDestination()
                .clickOnDatesCheckinButton()
                .chooseDateCheckIn()
                .chooseDateCheckOut()
                .clickOnGuestsToggle()
                .checkPricesButtonIsEnabled()
                .clickOnPricesButton()
                .checkSearchResult()
                .checkFilterPopupIsDisplayed()
                .checkPriceFilterLess2000IsDisplayed()
                .checkCheckBoxForPriceFilterLess2000IsEnabled()
                .clickOnCheckBoxForPriceFilterLess2000()
                .checkEnteredDestination()
                .checkOverlayCardIsDisplayed()
                .checkPopularityButtonIsDisplayed()
                .checkHousesAndApartmentsFirstButtonIsDisplayed()
                .checkFromLowPriceButtonIsDisplayed()
                .checkTitleResultAfterFiltering()
                .clickOnCloseButton()
                .checkPrice();
    }

    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}

