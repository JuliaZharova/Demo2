package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static PageObject.BasePage.driver;

public class CheckStaysPage {

    @Test
    public void checksChoosingStaysOnStaysPage() {
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver()).openBooking()
                .checkStaysButtonIsDisplayed()
                .checkStaysButtonIsSelected()
                .checkInputFieldDestinationIsEnabled()
                .enterDestination()
                .checkDatesCheckInButtonIsEnabled()
                .clickOnDatesCheckinButton()
                .checkCalendarIsDisplayed()
                .chooseDateCheckIn()
                .checkDateCheckInIsChosen()
                .checkDatesCheckOutButtonIsEnabled()
                .chooseDateCheckOut()
                .checkDateCheckOutIsChosen()
                .checkCalendarIsNotDisplayed()
                .checkChosenCheckInDate()
                .checkChosenCheckOutDate()
                .checkAdultsCountBeforeChanges()
                .checkChildrenCountBeforeChanges()
                .checkRoomCountBeforeChanges()
                .clickOnGuestsToggle()
                .checkGuestsInputsContainerIsDisplayed()
                .addOneAdult()
                .addOneRoom()
                .checkAdultsCountAfterChanges()
                .checkChildrenCountAfterChanges()
                .checkRoomCountAfterChanges()
                .checkPricesButtonIsEnabled()
                .clickOnPricesButton()
                .checkSearchResult();

    }

//    @AfterMethod
    public void setDown() {
        driver.quit();
    }
}