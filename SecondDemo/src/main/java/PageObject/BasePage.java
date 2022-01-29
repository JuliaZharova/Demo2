package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"bui-header__main\"]")
    private WebElement bookingComLogo;

    @FindBy(id = "language-selection")
    private WebElement languageSelection;

    @FindBy(xpath = "//a[@class=\"bui-button bui-button--light bui-button--large\"]")
    private WebElement questionMarkButton;

    @FindBy(partialLinkText = "Войти в аккаунт")
    private WebElement loginButton;

    @FindBy(partialLinkText = "Зарегистрироваться")
    private WebElement registerButton;

    @FindBy(partialLinkText = "Жилье")
    private WebElement staysButton;


    SoftAssert softAssert = new SoftAssert();
   public BasePage openBooking(){
       driver.get("https://www.booking.com/");
       System.out.println(driver.getCurrentUrl());
       return this;
   }

    public BasePage checkBookingComLogoIsDisplayed() {
        System.out.println("Booking.com button is enabled: " + bookingComLogo.isEnabled());
        return this;
    }

    public BasePage checkLanguageSelectionButtonIsDisplayed() {
        System.out.println("Language button is enabled: " + languageSelection.isEnabled());
        return this;
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

    public StaysPage checkStaysButtonIsDisplayed() {
        System.out.println("Stays button is enabled: " + staysButton.isEnabled());
        softAssert.assertTrue(staysButton.isEnabled());
        return new StaysPage(driver);
    }
}
