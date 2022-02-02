package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StaysPage extends BasePage {

    public StaysPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"bui-tab__link bui-tab__link--selected\"]")
    private WebElement staysButtonSelected;

    @FindBy(id = "ss")
    private WebElement inputFieldDestination;

    @FindBy(xpath = "//div[@class=\"xp__dates-inner xp__dates__checkin\"]")
    private WebElement datesCheckinButton;

    @FindBy(xpath = "//div[@class=\"xp__dates-inner xp__dates__checkout\"]")
    private WebElement datesCheckoutButton;

    @FindBy(css = ".bui-calendar")
    private WebElement calendar;

    @FindBy(css = "[data-date=\"2022-02-14\"]")
    private WebElement dateForCheckin;

    @FindBy(css = "[data-date=\"2022-02-15\"]")
    private WebElement dateForCheckout;

    @FindBy(css = "[data-placeholder=\"Заезд\" ]")
    private WebElement chosenDateCheckIn;

    @FindBy(css = "[data-placeholder=\"Отъезд\"]")
    private WebElement chosenDateCheckOut;

    @FindBy(css = "[data-adults-count]")
    private WebElement adultsCount;

    @FindBy(css = "[data-children-count]")
    private WebElement childrenCount;

    @FindBy(css = "[data-room-count]")
    private WebElement roomCount;

    @FindBy(css = "#xp__guests__toggle")
    private WebElement guestsToggle;

    @FindBy(css = "#xp__guests__inputs-container")
    private WebElement guestsInputsContainer;

    @FindBy(xpath = "//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"]")
    private List<WebElement> addButton;

    @FindBy(xpath = "//button[@data-sb-id=\"main\"]")
    private WebElement checkPricesButton;

    @FindBy(xpath = "//h1[@class=\"_30227359d _0db903e42\"]")
    private WebElement searchResult;

    @FindBy(css = ".sb-searchbox__title-text")
    private WebElement titleFindYourNextStay;

    @Step("Check that stays button is selected")
    public StaysPage checkStaysButtonIsSelected() {
        System.out.println("Stays button is selected: " + staysButtonSelected.isDisplayed());
        softAssert.assertTrue(staysButtonSelected.isDisplayed(), "Stays button isn't selected!");
        return this;
    }

    @Step("Check that input field 'Destination' is enabled")
    public StaysPage checkInputFieldDestinationIsEnabled() {
        System.out.println("Input field 'Destination' is enabled: " + inputFieldDestination.isEnabled());
        softAssert.assertTrue(inputFieldDestination.isEnabled(), "Input field 'Destination' isn't enabled!");
        return this;
    }

    @Step("Enter destination")
    public StaysPage enterDestination() {
        inputFieldDestination.sendKeys("Буковель");
        return this;
    }

    @Step("Check entered destination")
    public StaysResultsPage checkEnteredDestination() {
        System.out.println(inputFieldDestination.getText());
        return new StaysResultsPage(driver);
    }

    @Step("Check that dates check-in button is enabled")
    public StaysPage checkDatesCheckInButtonIsEnabled() {
        System.out.println("Dates check-in button is enabled: " + datesCheckinButton.isEnabled());
        softAssert.assertTrue(datesCheckinButton.isEnabled(), "Dates check-in button isn't enabled!");
        return this;
    }

    @Step("Click on dates check-in button")
    public StaysPage clickOnDatesCheckinButton() {
        datesCheckinButton.click();
        return this;
    }

    @Step("Check that calendar is displayed")
    public StaysPage checkCalendarIsDisplayed() {
        System.out.println("Calendar is displayed: " + calendar.isDisplayed());
        softAssert.assertTrue(calendar.isDisplayed(), "Calendar isn't displayed!");
        return this;
    }

    @Step("Choose date check-in")
    public StaysPage chooseDateCheckIn() {
        dateForCheckin.click();
        return this;
    }

    @Step("Check that date check-in is chosen")
    public StaysPage checkDateCheckInIsChosen() {
        System.out.println(dateForCheckin.getCssValue("background"));
        softAssert.assertEquals(dateForCheckin.getCssValue("background"),
                "rgb(0, 113, 194) none repeat scroll 0% 0% / auto padding-box border-box",
                "The date check-in has not been chosen!");
        return this;
    }

    @Step("Check that dates checkout button is enabled")
    public StaysPage checkDatesCheckOutButtonIsEnabled() {
        System.out.println("Dates checkout button is enabled: " + datesCheckoutButton.isEnabled());
        softAssert.assertTrue(datesCheckoutButton.isEnabled(), "Dates checkout button isn't enabled!");
        return this;
    }

    @Step("Choose date checkout")
    public StaysPage chooseDateCheckOut() {
        dateForCheckout.click();
        return this;
    }

    @Step("Check that date checkout is chosen")
    public StaysPage checkDateCheckOutIsChosen() {
        System.out.println(dateForCheckout.getCssValue("background"));
        softAssert.assertEquals(dateForCheckout.getCssValue("background"),
                "rgb(0, 113, 194) none repeat scroll 0% 0% / auto padding-box border-box",
                "The date checkout has not been chosen!");
        return this;
    }

    @Step("Check that calendar isn't displayed")
    public StaysPage checkCalendarIsNotDisplayed() {
        System.out.println("Calendar is displayed: " + calendar.isDisplayed());
        softAssert.assertFalse(calendar.isDisplayed(), "Calendar is displayed!");
        return this;
    }

    @Step("Check chosen check-in date")
    public StaysPage checkChosenCheckInDate() {
        System.out.println(chosenDateCheckIn.getText());
        softAssert.assertEquals(chosenDateCheckIn.getText(), "пн, 14 февр.",
                "Wrong check-in date!");
        return this;
    }

    @Step("Check chosen checkout date")
    public StaysPage checkChosenCheckOutDate() {
        System.out.println(chosenDateCheckOut.getText());
        softAssert.assertEquals(chosenDateCheckOut.getText(), "вт, 15 февр.",
                "Wrong checkout date!");
        return this;
    }

    @Step("Check adults count before changes")
    public StaysPage checkAdultsCountBeforeChanges() {
        System.out.println("Adults count before changes: " + adultsCount.getText());
        softAssert.assertEquals(adultsCount.getText(), "2 взрослых",
                "Wrong adults count before changes!");
        return this;
    }

    @Step("Check children count before changes")
    public StaysPage checkChildrenCountBeforeChanges() {
        System.out.println("Children count before changes: " + childrenCount.getText());
        softAssert.assertEquals(childrenCount.getText(), "без детей",
                "Wrong children count before changes!");
        return this;
    }

    @Step("Check room count before changes")
    public StaysPage checkRoomCountBeforeChanges() {
        System.out.println("Room count before changes: " + roomCount.getText());
        softAssert.assertEquals(roomCount.getText(), "1 номер",
                "Wrong room count before changes!");
        return this;
    }

    @Step("Click on guests toggle")
    public StaysPage clickOnGuestsToggle() {
        guestsToggle.click();
        return this;
    }

    @Step("Check that guests inputs container is displayed")
    public StaysPage checkGuestsInputsContainerIsDisplayed() {
        System.out.println("Guests inputs container is displayed: " + guestsInputsContainer.isDisplayed());
        softAssert.assertTrue(guestsInputsContainer.isDisplayed(), "Guests inputs container isn't displayed!");
        return this;
    }

    @Step("Add one adult")
    public StaysPage addOneAdult() {
        addButton.get(0).click();
        return this;
    }

    @Step("Add one room")
    public StaysPage addOneRoom() {
        addButton.get(2).click();
        return this;
    }

    @Step("Check adults count after changes")
    public StaysPage checkAdultsCountAfterChanges() {
        System.out.println("Adults count after changes: " + adultsCount.getText());
        softAssert.assertEquals(adultsCount.getText(), "3 взрослых",
                "Wrong adults count after changes!");
        return this;
    }

    @Step("Check children count after changes")
    public StaysPage checkChildrenCountAfterChanges() {
        System.out.println("Children count after changes: " + childrenCount.getText());
        softAssert.assertEquals(childrenCount.getText(), "без детей",
                "Wrong children count after changes!");
        return this;
    }

    @Step("Check room count after changes")
    public StaysPage checkRoomCountAfterChanges() {
        System.out.println("Room count after changes: " + roomCount.getText());
        softAssert.assertEquals(roomCount.getText(), "2 номера",
                "Wrong room count after changes!");
        return this;
    }

    @Step("Check that prices button is enabled")
    public StaysPage checkPricesButtonIsEnabled() {
        System.out.println("Prices button is enabled: " + checkPricesButton.isEnabled());
        softAssert.assertTrue(checkPricesButton.isEnabled(), "Prices button isn't enabled!");
        return this;
    }

    @Step("Click on prices button")
    public StaysPage clickOnPricesButton() {
        checkPricesButton.click();
        System.out.println(driver.getCurrentUrl());
        return this;
    }

    @Step("Check that the name of the destination item is what is entered")
    public StaysResultsPage checkSearchResult() {
        String result = searchResult.getText();
        String destinationName = result.substring(0, 8);
        System.out.println(destinationName);
        softAssert.assertEquals(destinationName, "Буковель", "The name of the destination item is not what is entered!");
        softAssert.assertAll();
        return new StaysResultsPage(driver);
    }

    @Step("Check title 'Find your next stay' is in English")
    public StaysPage checkTitleFindYourNextStayInEng() {
        System.out.println(titleFindYourNextStay.getText());
        softAssert.assertEquals(titleFindYourNextStay.getText(), "Find your next stay", "Title 'Find your next stay' is not in English!");
        return this;
    }

    @Step("Open Care Rental page")
    public CarRentalsPage openCareRentalPage() {
        menuTabs.get(2).click();
        return new CarRentalsPage(driver);
    }
}
