package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightsPage extends BasePage {

    public FlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".Text-module__root--variant-headline_1___2W9ql")
    private WebElement titleCompareAndBookFlightsWithEase;

    @FindBy(xpath = "//a[@data-decider-header=\"flights\"]")
    private WebElement flightsButton;

    @FindBy(xpath = "//a[@class=\"Actionable-module__root___1Be0F Tab-module__link___3Etkm Tab-module__link--selected___bTkCG Actionable-module__focus-inset___3TZbM\"]")
    private WebElement flightsButtonSelected;

    @FindBy(xpath = "//div[@class=\"css-1dgzenf-radio-input\"]")
    private WebElement oneWayButton;

    @FindBy(xpath = "//div[@aria-label=\"Звідки?\"]")
    private WebElement searchBoxFrom;

    @FindBy(xpath = "//div[@class=\"css-1dzh146-autoCompleteSheet\"]")
    private WebElement popUpAirportFrom;

    @FindBy(xpath = "//div[@class=\"css-1eii3rq\"]")
    private WebElement deleteKyiv;

    @FindBy(xpath = "//input[@class=\"css-1tl2oa1\"]")
    private WebElement emptySearchBoxFrom;

    @FindBy(xpath = "//ul[@class=\"css-1t69qnr\"]")
    private WebElement airportHRK;

    @FindBy(xpath = "//input[@data-testid=\"searchbox_destination_input\"]")
    private WebElement emptySearchBoxTo;

    @FindBy(xpath = "//ul[@class=\"css-1t69qnr\"]")
    private WebElement airportBCN;

    @FindBy(xpath = "//div[@data-testid=\"searchbox_calendar\"]")
    private WebElement calendar;

    @FindBy(xpath = "//div[@class=\"css-zhpg6q\"]")
    private WebElement bigCalendar;

    @FindBy(xpath = "//span[@data-date-cell=\"2022-02-12\"]")
    private WebElement date;

    @FindBy(xpath = "//button[@class=\"css-ya5gr9 wide\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@class=\"Actionable-module__root___1Be0F Button-module__root___rHKuR Button-module__root--variant-secondary___4ZbrG Button-module__root--size-medium___2sdY2 Button-module__root--variant-secondary-action___1VWu5 css-ox3zc8\"]")
    private WebElement ticket;

    @FindBy(xpath = "//header[@class=\"Title-module__root___2N-7w Title-module__root--variant-headline_3___25kKN\"]")
    private WebElement title;

    @Step("Check that title 'Compare and book flights with ease' in English")
    public FlightsPage checkTitleCompareAndBookFlightsWithEaseInEng() {
        System.out.println(titleCompareAndBookFlightsWithEase.getText());
        softAssert.assertEquals(titleCompareAndBookFlightsWithEase.getText(), "Compare and book flights with ease",
                "The wrong language is displayed on the page Flights");
        softAssert.assertAll();
        return this;
    }

    @Step("Check click on flights button")
    public FlightsPage clickOnFlights() {
        flightsButton.click();
        return this;
    }

    @Step("Check that flights button is enabled")
    public FlightsPage checkFlightsButtonIsEnabled() {
        System.out.println("Flights button is enabled: " + flightsButtonSelected.isEnabled());
        softAssert.assertTrue(flightsButtonSelected.isEnabled());
        return this;
    }

    @Step("Check that one way button is displayed")
    public FlightsPage checkOneWayButtonIsDisplayed() {
        System.out.println("One way button is displayed: " + oneWayButton.isDisplayed());
        softAssert.assertTrue(oneWayButton.isDisplayed());
        return new FlightsPage(driver);
    }

    @Step("Check choosing one way button")
    public FlightsPage chooseOnOneWay() {
        oneWayButton.click();
        return this;
    }

    @Step("Check choosing airport from")
    public FlightsPage chooseAirportFrom() {
        searchBoxFrom.click();
        return this;
    }

    @Step("Check popUp airport from is enabled")
    public FlightsPage checkPopUpAirportFromIsEnabled() {
        System.out.println("popUp Airport is enabled: " + popUpAirportFrom.isEnabled());
        softAssert.assertTrue(popUpAirportFrom.isEnabled());
        return new FlightsPage(driver);
    }

    @Step("Delete Kyiv airport")
    public FlightsPage deleteKyiv() {
        deleteKyiv.click();
        System.out.println("Kyiv airport was deleted");
        return this;
    }

    @Step("Check Search Box From is enabled")
    public FlightsPage checkEmptySearchBoxFromIsEnabled() {
        System.out.println("Empty Search Box From is enabled: " + emptySearchBoxFrom.isEnabled());
        softAssert.assertTrue(emptySearchBoxFrom.isEnabled());
        return new FlightsPage(driver);
    }

    @Step("Enter airport from")
    public FlightsPage enterAirportFrom() {
        emptySearchBoxFrom.sendKeys("Харків");
        return this;
    }

    @Step("Check Kharkiv airport is enabled")
    public FlightsPage checkKharkivAirportIsEnabled() {
        try{
            System.out.println("Kharkiv Airport is enabled: " + airportHRK.isEnabled());
            softAssert.assertTrue(airportHRK.isEnabled());
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException (Check Kharkiv airport is enabled)");
        }
        return new FlightsPage(driver);
    }

    @Step("Choose Kharkiv airport")
    public FlightsPage chooseKharkivAirport() {
       try {
           airportHRK.click();
       } catch (StaleElementReferenceException e) {
           System.out.println("StaleElementReferenceException (Choose Kharkiv airport)");
           airportHRK.click();
       }
        return this;
    }

    @Step("Check empty searchbox is enabled")
    public FlightsPage checkEmptySearchBoxToIsEnabled() {
        System.out.println("Empty Search Box To is enabled: " + emptySearchBoxTo.isEnabled());
        softAssert.assertTrue(emptySearchBoxTo.isEnabled());
        return new FlightsPage(driver);
    }

    @Step("Enter airport to")
    public FlightsPage enterAirportTo() {
        emptySearchBoxTo.click();
        emptySearchBoxTo.sendKeys("Барселона");
        return this;
    }

    @Step("Check Barcelona airport is displayed")
    public FlightsPage checkBarcelonaAirportIsDisplayed() {
        System.out.println("Barcelona Airport is displayed: " + airportBCN.isDisplayed());
        softAssert.assertTrue(airportBCN.isDisplayed());
        return new FlightsPage(driver);
    }

    @Step("Choose Barcelona airport")
    public FlightsPage chooseBarcelonaAirport() {
        try {
            WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.elementToBeClickable(airportBCN));
            airportBCN.click();
        } catch (ClassCastException e) {
            System.out.println("ClassCastException");
            airportBCN.click();
      } catch (StaleElementReferenceException e){
          System.out.println("StaleElementReferenceException in method 'chooseBarcelonaAirport'");
          airportBCN.click();
      }
        return this;
    }

    @Step("Choose calendar")
    public FlightsPage chooseCalendar() {
        calendar.click();
        return this;
    }

    @Step("Check calendar is displayed")
    public FlightsPage checkCalendarIsDisplayed() {
        System.out.println("Calendar is displayed: " + bigCalendar.isDisplayed());
        softAssert.assertTrue(bigCalendar.isDisplayed());
        return new FlightsPage(driver);
    }

    @Step("Choose date")
    public FlightsPage chooseDate() {
        date.click();
        return this;
    }

    @Step("Click search")
    public FlightsPage clickSearch() {
        searchButton.click();
        return this;
    }

    @Step("Check ticket is displayed")
    public FlightsPage checkTicketIsDisplayed() {
        System.out.println("Ticket is displayed: " + ticket.isDisplayed());
        softAssert.assertTrue(ticket.isDisplayed());
        return new FlightsPage(driver);
    }

    @Step("Click on ticket")
    public FlightsPage clickOnTicket() {
        ticket.click();
        return this;
    }

    @Step("Check title")
    public FlightsPage getTitle() {
        System.out.println("The title is: " + title.getText());
        softAssert.assertTrue(title.isDisplayed());
        return new FlightsPage(driver);
    }
}
