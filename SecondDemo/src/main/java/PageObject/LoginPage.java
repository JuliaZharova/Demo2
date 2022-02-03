package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(partialLinkText = "Войти в аккаунт")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@class='bui-button bui-button--secondary js-header-login-link']")
    private List<WebElement> logButton;

    @FindBy(xpath = "//div[@class='page-header']")
    private WebElement loginTittle;

    @FindBy(id="username")
    private WebElement emailInput;

    @FindBy(xpath = "//button [@type='submit']")
    private WebElement submitEmailButton;

    @FindBy(xpath = "//h1 [@class='bui_font_display_two bui_font_heading--bold bui-spacer--medium nw-step-header']")
    private WebElement passwordTittle;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button [@type='submit']")
    private WebElement submitPasswordButton;

    @FindBy(xpath = "//div[@class='bui-spacer--large bui-u-margin-top--24']//h3")
    private WebElement successMessage;


    @DataProvider(name = "validDataForLogIn")

    public Object[][] validDataForLogIn() {
        return new Object[][]{
                {"anneta792@gmail.com", "Kozyreva89"},
        };
    }
    @Step("Click on LogIn button")
    public LoginPage clickOnLoginButton() {
        logButton.get(1).click();
        return this;
    }

    @Step("Check that the LogIn Page is displayed")
    public LoginPage checkLogInPageIsDisplayed() {
        System.out.println(driver.getCurrentUrl());
        System.out.println(loginTittle.getText());
        Assert.assertEquals(loginTittle.getText(), "Войдите или создайте аккаунт", "The wrong title is displayed on the Login Page!");
        return this;
    }

    @Step("Input valid data in mail form")
    public LoginPage InputValidMail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Click on the submitButton in mail form")
    public LoginPage clickOnSubmitEmailButton(){
        submitEmailButton.click();
        return this;
    }

    @Step("Check that the Password Page is displayed")
    public LoginPage checkPasswordPageIsDisplayed() {
        System.out.println(driver.getCurrentUrl());
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(passwordTittle));
        System.out.println(passwordTittle.getText());
        Assert.assertEquals(passwordTittle.getText(), "Введите пароль","The wrong title is displayed on the Password Page!");
        return this;
    }

    @Step("Input valid data in password form")
    public LoginPage InputValidPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click on the submitButton in password form")
    public LoginPage clickOnSubmitPasswordButton(){
        submitPasswordButton.click();
        return this;
    }

    @Step("Check that success message is displayed ")
    public LoginPage checkSuccessMessage() {

        System.out.println("Success Message is displayed: " + successMessage.isDisplayed());
        softAssert.assertTrue(successMessage.isDisplayed(),"Success Message isn't displayed!");
        return this;
    }
}
