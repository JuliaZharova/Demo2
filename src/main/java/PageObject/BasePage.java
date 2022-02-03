package PageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public static void setDown(){
        driver.quit();
    }

    @FindBy(xpath = "//div[@class=\"bui-header__logo\"]")
    private WebElement bookingComLogo;

    @FindBy(xpath = "//button[@data-modal-id=\"language-selection\"]")
    private WebElement languageSelection;

    @FindBy(xpath = "//a[@class=\"bui-button bui-button--light bui-button--large\"]")
    private WebElement questionMarkButton;

    @FindBy(partialLinkText = "Войти в аккаунт")
    private WebElement loginButton;

    @FindBy(partialLinkText = "Зарегистрироваться")
    private WebElement registerButton;

    @FindBy(partialLinkText = "Жилье")
    private WebElement staysButton;

    @FindBy(partialLinkText = "Авиабилеты")
    private WebElement flightsButton;

    @FindBy(partialLinkText = "Аренда машин")
    private WebElement carRentals;

    @FindBy(partialLinkText = "Варианты досуга")
    private WebElement attractions;

    @FindBy(css = ".bui-modal__header")
    private WebElement languagePopUp;

    @FindBy(xpath = "//div[@lang=\"en-us\"]")
    private WebElement englishLanguageButton;

    @FindBy(css = ".bui-tab__link")
    List<WebElement> menuTabs;

    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//span[@class=\"sb-searchbox__title-text\"]")
    private WebElement staysTitle;

    @FindBy(xpath = "//div[@class=\"Text-module__root--variant-headline_1___2W9ql\"]")
    private WebElement flightsTitle;

    @FindBy(xpath = "//div[@class=\"Header-module__main___2ZC25\"]")
    private WebElement bookingCom;

    @FindBy(xpath = "//span[@class=\"sb-searchbox__title-text\"]")
    private WebElement carRentalsTitle;

    @FindBy(xpath = "//div[@class=\"Text-module__root--variant-headline_1___29-Qz css-19idom\"]")
    private WebElement attractionsTitle;

    @FindBy(xpath = "//div[@class=\"Header-module__main___K_XWi\"]")
    private WebElement bookingComOnAttractions;

    public BasePage openBooking() {
        driver.get("https://www.booking.com/");
        System.out.println(driver.getCurrentUrl());
        return this;
    }

    public BasePage checkBookingComLogoIsDisplayed() {
        System.out.println("Booking.com button is enabled: " + bookingComLogo.isEnabled());
        return this;
    }

    public BasePage checkLanguageSelectionButtonIsEnabled() {
        System.out.println("Language button is enabled: " + languageSelection.isEnabled());
        softAssert.assertTrue(languageSelection.isEnabled());
        return this;
    }

    public BasePage clickOnLanguageSelectionButton() {
        languageSelection.click();
        return this;
    }

    public BasePage checkLanguagePopUpIsDisplayed() {
        System.out.println("Language popup is displayed: " + languagePopUp.isDisplayed());
        softAssert.assertTrue(languagePopUp.isDisplayed());
        return this;
    }

    public BasePage checkEnglishLanguageButtonIsEnabled() {
        System.out.println("English language button is enabled: " + englishLanguageButton.isEnabled());
        softAssert.assertTrue(englishLanguageButton.isEnabled());
        return this;
    }

    public BasePage clickOnEnglishLanguageButton() {
        englishLanguageButton.click();
        return this;
    }

    public StaysPage checkLanguagePopUpIsNotDisplayed() {
        try {
            softAssert.assertFalse(languagePopUp.isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("Everything is fine. Language popup isn't displayed.");
        }
        softAssert.assertAll();
        return new StaysPage(driver);
    }

    public BasePage checkQuestionMarkButtonIsEnabled() {
        System.out.println("Question mark button is enabled: " + questionMarkButton.isEnabled());
        return this;
    }

    public BasePage checkLoginButtonIsDisplayed() {
        System.out.println("Login button is enabled: " + loginButton.isEnabled());
        return this;
    }

    public BasePage checkRegisterButtonIsDisplayed() {
        System.out.println("Register button is enabled: " + registerButton.isEnabled());
        return this;
    }
    public BasePage checkStaysButtonIsDisplayed() {
        System.out.println("Stays button is displayed: " + staysButton.isDisplayed());
        softAssert.assertTrue(staysButton.isDisplayed());
        return new StaysPage(driver);
    }

    //@Step("Check that flights button is displayed")
    public FlightsPage checkFlightsButtonIsDisplayed() {
        System.out.println("Flights button is displayed: " + flightsButton.isDisplayed());
        softAssert.assertTrue(flightsButton.isDisplayed());
        return new FlightsPage(driver);
    }
    //@Step("Check that stays button is enabled")
    public BasePage checkStaysButtonIsEnabled() {
        System.out.println("Stays button is enabled: " + staysButton.isEnabled());
        softAssert.assertTrue(staysButton.isEnabled());
        return new StaysPage(driver);
    }
    //@Step("Check stays title")
    public BasePage getStaysTitle() {
        System.out.println("Current title is: " + staysTitle.getText());
        softAssert.assertTrue(staysTitle.isDisplayed());
        return new FlightsPage(driver);
    }

    public BasePage getFlightsTitle() {
        System.out.println("Current title is: " + flightsTitle.getText());
        softAssert.assertTrue(flightsTitle.isDisplayed());
        return new FlightsPage(driver);
    }

    public BasePage checkBookingComIsDisplayed() {
        System.out.println("Booking.com is displayed " + bookingCom.isDisplayed());
        softAssert.assertTrue(bookingCom.isDisplayed());
        return new StaysPage(driver);
    }

    public BasePage clickOnBookingCom() {
        bookingCom.click();
        return this;
    }
    //@Step("Check that car rentals button is displayed")
    public BasePage checkCarRentalsButtonIsDisplayed() {
        System.out.println("Car Rentals button is displayed: " + carRentals.isDisplayed());
        softAssert.assertTrue(carRentals.isDisplayed());
        return new FlightsPage(driver);
    }
    //@Step("Click on car rentals")
    public BasePage clickOnCarRentals() {
        carRentals.click();
        return this;
    }
    //@Step("Check car rentals button is enabled")
    public BasePage checkCarRentalsButtonIsEnabled() {
        System.out.println("Car Rentals button is enabled: " + carRentals.isEnabled());
        softAssert.assertTrue(carRentals.isEnabled());
        return new StaysPage(driver);
    }
    //@Step("Check car rentals title")
    public BasePage getCarRentalsTitle() {
        System.out.println("Current title is: " + carRentalsTitle.getText());
        softAssert.assertTrue(carRentalsTitle.isDisplayed());
        return new FlightsPage(driver);
    }
    //@Step("Click on booking.com from cars page")
    public BasePage clickOnBookingComFromCars() {
        bookingComLogo.click();
        return this;
    }
    //@Step("Check that attractions button is displayed")
    public AttractionsPage checkAttractionsButtonIsDisplayed() {
        System.out.println("Attractions button is displayed: " + attractions.isDisplayed());
        softAssert.assertTrue(attractions.isDisplayed());
        return new AttractionsPage(driver);
    }
    //@Step("Check that attractions button is enabled")
    public AttractionsPage checkAttractionsButtonIsEnabled() {
        System.out.println("Attractions button is enabled: " + attractions.isEnabled());
        softAssert.assertTrue(attractions.isEnabled());
        return new AttractionsPage(driver);
    }
    //@Step("Click on attractions")
    public BasePage clickOnAttractions() {
        attractions.click();
        return this;
    }
    //@Step("Get attracrions title")
    public AttractionsPage getAttractionsTitle() {
        System.out.println("Current title is: " + attractionsTitle.getText());
        softAssert.assertTrue(attractionsTitle.isDisplayed());
        return new AttractionsPage(driver);
    }
    //@Step("Click on booking.com from attractions page")
    public BasePage clickOnBookingComFromAttractions() {
        bookingComOnAttractions.click();
        return this;
    }
}
