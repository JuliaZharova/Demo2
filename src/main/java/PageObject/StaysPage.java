package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(css = "[data-date=\"2022-02-20\"]")
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

    public StaysPage checkStaysButtonIsSelected() {
        System.out.println("Stays button is selected: " + staysButtonSelected.isDisplayed());
        softAssert.assertTrue(staysButtonSelected.isDisplayed());
        return this;
    }

    public StaysPage checkInputFieldDestinationIsEnabled(){
        System.out.println("Input field 'Destination' is enabled: " + inputFieldDestination.isEnabled());
        softAssert.assertTrue(inputFieldDestination.isEnabled());
        return this;
    }

    public StaysPage enterDestination() {
        inputFieldDestination.sendKeys("Буковель");
        return this;
    }

    public StaysPage checkDatesCheckInButtonIsEnabled(){
        System.out.println("Dates checkin button is enabled: " + datesCheckinButton.isEnabled());
        softAssert.assertTrue(datesCheckinButton.isEnabled());
        return this;
    }

    public StaysPage clickOnDatesCheckinButton(){
        datesCheckinButton.click();
        return this;
    }

    public StaysPage checkCalendarIsDisplayed(){
        System.out.println("Calendar is displayed: " + calendar.isDisplayed());
        softAssert.assertTrue(calendar.isDisplayed());
        return this;
    }

    public StaysPage chooseDateCheckIn(){
        dateForCheckin.click();
        return this;
    }

    public StaysPage checkDateCheckInIsChosen(){
        System.out.println(dateForCheckin.getCssValue("background"));
        softAssert.assertEquals(dateForCheckin.getCssValue("background"), "rgb(0, 113, 194) none repeat scroll 0% 0% / auto padding-box border-box");
        return this;
    }

    public StaysPage checkDatesCheckOutButtonIsEnabled(){
        System.out.println("Dates checkout button is enabled: " + datesCheckoutButton.isEnabled());
        softAssert.assertTrue(datesCheckoutButton.isEnabled());
        return this;
    }

    public StaysPage chooseDateCheckOut(){
        dateForCheckout.click();
        return this;
    }

    public StaysPage checkDateCheckOutIsChosen(){
        System.out.println(dateForCheckout.getCssValue("background"));
        softAssert.assertEquals(dateForCheckout.getCssValue("background"), "rgb(0, 113, 194) none repeat scroll 0% 0% / auto padding-box border-box");
        return this;
    }

    public StaysPage checkCalendarIsNotDisplayed(){
        System.out.println("Calendar is displayed: " + calendar.isDisplayed());
        softAssert.assertFalse(calendar.isDisplayed());
        return this;
    }

    public StaysPage checkChosenCheckInDate(){
        System.out.println(chosenDateCheckIn.getText());
        softAssert.assertEquals(chosenDateCheckIn.getText(), "пн, 14 февр.");
        return this;
    }

    public StaysPage checkChosenCheckOutDate(){
        System.out.println(chosenDateCheckOut.getText());
        softAssert.assertEquals(chosenDateCheckOut.getText(), "вс, 20 февр.");
        return this;
    }

    public StaysPage checkAdultsCountBeforeChanges(){
        System.out.println("Adults count before changes: " + adultsCount.getText());
        softAssert.assertEquals(adultsCount.getText(), "2 взрослых");
        return this;
    }

    public StaysPage checkChildrenCountBeforeChanges(){
        System.out.println("Children count before changes: " + childrenCount.getText());
        softAssert.assertEquals(childrenCount.getText(), "без детей");
        return this;
    }

    public StaysPage checkRoomCountBeforeChanges(){
        System.out.println("Room count before changes: " + roomCount.getText());
        softAssert.assertEquals(roomCount.getText(), "1 номер");
        return this;
    }


}
