package tests;

import PageObject.BasePage;
import PageObject.FlightsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckFlightsPage {

    @Test(groups = "smoke",
            description = "Check flight ticket from Kharkiv to Barcelona")
    public void checkFlightTicket() {
        WebDriverManager.chromedriver().setup();
        new FlightsPage(new ChromeDriver()).openBooking()
                .checkFlightsButtonIsDisplayed()
                .clickOnFlights()
                .checkFlightsButtonIsEnabled()
                .checkOneWayButtonIsDisplayed()
                .chooseOnOneWay()
                .chooseAirportFrom()
                .checkPopUpAirportFromIsEnabled()
                .deleteKyiv()
                .checkEmptySearchBoxFromIsEnabled()
                .enterAirportFrom()
                .checkKharkivAirportIsEnabled()
                .chooseKharkivAirport()
                .checkEmptySearchBoxToIsEnabled()
                .enterAirportTo()
                .checkBarcelonaAirportIsDisplayed()
                .chooseBarcelonaAirport()
                .chooseCalendar()
                .checkCalendarIsDisplayed()
                .chooseDate()
                .clickSearch()
                .checkTicketIsDisplayed()
                .clickOnTicket()
                .getTitle();
    }

   @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}