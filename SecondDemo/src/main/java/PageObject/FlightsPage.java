package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage extends BasePage {

    public FlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".Text-module__root--variant-headline_1___2W9ql")
    private WebElement titleCompareAndBookFlightsWithEase;

    @Step("Check that title 'Compare and book flights with ease' in English")
    public FlightsPage checkTitleCompareAndBookFlightsWithEaseInEng() {
        System.out.println(titleCompareAndBookFlightsWithEase.getText());
        softAssert.assertEquals(titleCompareAndBookFlightsWithEase.getText(), "Compare and book flights with ease",
                "The wrong language is displayed on the page Flights");
        softAssert.assertAll();
        return this;
    }

}
