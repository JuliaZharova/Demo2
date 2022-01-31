package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static PageObject.BasePage.driver;

public class CheckStaysResultPage {

    @Test(groups = "regression")
    public void checkFilterPriceLess2000() throws InterruptedException {
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
                .checkPopularityButtonIsDisplayed()
                .checkTitleResultAfterFiltering()
                .clickOnCloseButton()
                .checkPrice();
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }
}

