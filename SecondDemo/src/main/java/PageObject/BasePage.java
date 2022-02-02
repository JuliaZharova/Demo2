package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
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

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    @FindBy(xpath = "//div[@class=\"bui-header__main\"]")
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

    @FindBy(css = ".bui-modal__header")
    private WebElement languagePopUp;

    @FindBy(xpath = "//div[@lang=\"en-us\"]")
    private WebElement englishLanguageButton;

    @FindBy(css = ".bui-tab__link")
    List<WebElement> menuTabs;

    SoftAssert softAssert = new SoftAssert();

    @Step("Open booking.com")
    public BasePage openBooking() {
        driver.get("https://www.booking.com/");
        System.out.println(driver.getCurrentUrl());
        return this;
    }

    public BasePage checkBookingComLogoIsDisplayed() {
        System.out.println("Booking.com button is enabled: " + bookingComLogo.isEnabled());
        softAssert.assertTrue(bookingComLogo.isEnabled(), "Booking.com button isn't enabled!");
        return this;
    }

    @Step("Check language selection button is enabled")
    public BasePage checkLanguageSelectionButtonIsEnabled() {
        System.out.println("Language button is enabled: " + languageSelection.isEnabled());
        softAssert.assertTrue(languageSelection.isEnabled(), "Language button isn't enabled!");
        return this;
    }

    @Step("Click on language selection button")
    public BasePage clickOnLanguageSelectionButton() {
        languageSelection.click();
        return this;
    }

    @Step("Check language popup is displayed")
    public BasePage checkLanguagePopUpIsDisplayed() {
        System.out.println("Language popup is displayed: " + languagePopUp.isDisplayed());
        softAssert.assertTrue(languagePopUp.isDisplayed(), "Language popup isn't displayed!");
        return this;
    }

    @Step("Check English language button is enabled")
    public BasePage checkEnglishLanguageButtonIsEnabled() {
        System.out.println("English language button is enabled: " + englishLanguageButton.isEnabled());
        softAssert.assertTrue(englishLanguageButton.isEnabled(), "English language button isn't enabled!");
        return this;
    }

    @Step("Click on English language button")
    public BasePage clickOnEnglishLanguageButton() {
        englishLanguageButton.click();
        return this;
    }

    @Step("Check language popup isn't displayed")
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
        softAssert.assertTrue(questionMarkButton.isEnabled(), "Question mark button isn't enabled!");
        return this;
    }

    public BasePage checkLoginButtonIsDisplayed() {
        System.out.println("Login button is enabled: " + loginButton.isEnabled());
        softAssert.assertTrue(loginButton.isEnabled(), "Login button isn't enabled!");
        return this;
    }

    public BasePage checkRegisterButtonIsDisplayed() {
        System.out.println("Register button is enabled: " + registerButton.isEnabled());
        softAssert.assertTrue(registerButton.isEnabled(), "Register button isn't enabled!");
        return this;
    }

    @Step("Check stays button is enabled")
    public StaysPage checkStaysButtonIsDisplayed() {
        System.out.println("Stays button is enabled: " + staysButton.isEnabled());
        softAssert.assertTrue(staysButton.isEnabled(), "Stays button isn't enabled!");
        return new StaysPage(driver);
    }
}
