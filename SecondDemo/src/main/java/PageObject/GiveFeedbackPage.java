package PageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class GiveFeedbackPage extends BasePage{

    public GiveFeedbackPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
