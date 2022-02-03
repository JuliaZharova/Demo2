package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    private WebElement registerPageTitle;

    @FindBy(id = "username")
    private WebElement inputField;

    @FindBy(tagName = "label")
    private WebElement inputFieldLabel;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/form/div[3]/button")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/div/a/button")
    private WebElement enterButton;

    @FindBy(className = "_1jp30RWusTBQoML9GSCZ_C")
    private WebElement registerButtonTitle;

    @Step("Check that the Registration page is displayed")
    public RegisterPage checkRegisterPageIsDisplayed() {
        System.out.println("Register page is displayed: " + registerPageTitle.isDisplayed());
        return this;
    }

    @Step("Check that the Registration page has title 'Войдите или создайте аккаунт'")
    public RegisterPage checkRegisterPageTitle() {
        System.out.println("Register page title: " + registerPageTitle.getText());
        softAssert.assertEquals(registerPageTitle.getText(), "Войдите или создайте аккаунт");
        return this;
    }

    @Step("Check that the Input field is enable on the Registration page")
    public RegisterPage checkInputFieldIsEnable() {
        System.out.println("Input field is enable: " + inputField.isEnabled());
        return this;
    }

    @Step("Check that the Input field has a label with text 'Адрес электронной почты'")
    public RegisterPage checkInputFieldLabel() {
        System.out.println("Label text of input field: " + inputFieldLabel.getText());
        softAssert.assertEquals(inputFieldLabel.getText(), "Адрес электронной почты");
        return this;
    }

    @Step("Check that the Input field is enable on the Registration page")
    public RegisterPage checkInputFieldIsEmpty() {
        System.out.println("Input field contains: " + inputField.getText());
        softAssert.assertEquals(inputField.getText(), "");
        inputField.clear();
        return this;
    }

    @Step("Check that the register button is enable on the Registration page")
    public RegisterPage checkRegisterButtonIsEnable() {
        System.out.println("Register button is enable: " + registerButton.isEnabled());
        return this;
    }

    @Step("Check that the register button has title 'Продолжить через электронную почту'")
    public RegisterPage checkRegisterButtonTitle() {
        System.out.println("Register button title: " + registerButtonTitle.getText());
        softAssert.assertEquals(registerButtonTitle.getText(), "Продолжить через электронную почту");
        return this;
    }

    @Step("Check that the User can input the Email")
    public RegisterPage inputEmail(String email) {
        System.out.println("Email for the test: " + email);
        inputField.sendKeys(email);
        return this;
    }

    @Step("Click on the register button")
    public RegisterPage clickOnRegisterButton() {
        registerButton.click();
        return this;
    }

    @Step("Check that the Registration page has title 'Проверьте папку 'Входящие'' after click on the register button")
    public RegisterPage checkPageTitleAfterClickRegisterButton() {
        System.out.println("Title after click on Register button: " + registerPageTitle.getText());
        softAssert.assertEquals(registerPageTitle.getText(), "Проверьте папку «Входящие»");
        return this;
    }
}