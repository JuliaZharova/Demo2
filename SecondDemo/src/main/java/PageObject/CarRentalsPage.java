package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarRentalsPage extends BasePage {

    public CarRentalsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".sb-searchbox__title-text")
    private WebElement titleCarRentalsForAnyKindOfTrip;

    @FindBy(xpath = "//*[@id=\"bodyconstraint-inner\"]/div[3]/div/div[2]/div/h1/span")
    private WebElement carRentalsTitle;

    @FindBy(className = "bui-alert__title")
    private WebElement cleanCarsInfoBlockTitle;

    @FindBy(xpath = "//*[@id=\"bodyconstraint-inner\"]/div[3]/div/div[1]/div/div[2]/div/a")
    private WebElement findOutHowLink;

    @Step("Check that title 'Car rentals for any kind of trip' in English")
    public CarRentalsPage checkTitleCarRentalsForAnyKindOfTripInEng() {
        System.out.println(titleCarRentalsForAnyKindOfTrip.getText());
        softAssert.assertEquals(titleCarRentalsForAnyKindOfTrip.getText(), "Car rentals for any kind of trip",
                "The wrong language is displayed on the Car rental page");
        return this;
    }

    @Step("Open Attractions page")
    public AttractionsPage openAttractionsPage() {
        menuTabs.get(3).click();
        return new AttractionsPage(driver);
    }

    @Step("Check that the Car rentals page is displayed")
    public CarRentalsPage checkCarRentalsPageIsDisplayed() {
        System.out.println("Car rentals page is displayed:" + carRentalsTitle.isDisplayed());
        softAssert.assertTrue(carRentalsTitle.isDisplayed());
        return this;
    }

    @Step("Check that the Clean car's information block is displayed")
    public CarRentalsPage checkCleanCarsInfoBlockIsDisplayed() {
        System.out.println("Clean cars info block is displayed: " + cleanCarsInfoBlockTitle.isDisplayed());
        softAssert.assertTrue(cleanCarsInfoBlockTitle.isDisplayed());
        return this;
    }

    @Step("Check the Clean cars block title")
    public CarRentalsPage checkTitleCleanCarsInfoBlock() {
        System.out.println("Title of Clean cars info block: " + cleanCarsInfoBlockTitle.getText());
        softAssert.assertEquals(cleanCarsInfoBlockTitle.getText(), "Чистые автомобили. Гибкие условия бронирования. Соблюдение дистанции в пунктах проката.");
        return this;
    }

    @Step("Check that the 'Find out how' link is enabled")
    public CarRentalsPage checkFindOutHowLinkIsEnabled() {
        System.out.println("Find out how link is enabled: " + findOutHowLink.isEnabled());
        return this;
    }

    @Step("Check the 'Find out how' link title")
    public CarRentalsPage checkFindOutHowLinkTitle() {
        System.out.println("Title of Find out how link: " + findOutHowLink.getText());
        softAssert.assertEquals(findOutHowLink.getText(), "Как мы это делаем");
        return this;
    }

    @Step("Click on the 'Find out how' link")
    public CarRentalCoronavirusPage clickOnFindOutHowLink() {
        findOutHowLink.click();
        return new CarRentalCoronavirusPage(driver);
    }
}
