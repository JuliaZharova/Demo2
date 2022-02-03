package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpCenterPage extends BasePage{
    public HelpCenterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div")
    private WebElement helpCenterTitle;

    @Step("Check that the Help center page is displayed")
    public HelpCenterPage checkHelpCenterIsDisplayed() {
        System.out.println("Help Center page is displayed:" + helpCenterTitle.isDisplayed());
        softAssert.assertTrue(helpCenterTitle.isDisplayed());
        return this;
    }

    @Step("Check the Help center page title")
    public HelpCenterPage checkTitleTextHelpCenterPage() {
        System.out.println("Title of Help Center page: " + helpCenterTitle.getText());
        softAssert.assertEquals("Центр поддержки", helpCenterTitle.getText());
        return this;
    }
}