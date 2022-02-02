package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AirportTaxisPage extends BasePage {

    public AirportTaxisPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".sb-searchbox__title-text")
    private WebElement titleBookYourAirportTaxi;

    @Step("Check title 'Book your airport taxi'")
    public AirportTaxisPage checkTitleBookYourAirportTaxi() {
        System.out.println(titleBookYourAirportTaxi.getText());
        softAssert.assertEquals(titleBookYourAirportTaxi.getText(), "Book your airport taxi",
                "The wrong language is displayed on the Airport taxis page!");
        return this;
    }

    @Step("Open Flights page")
    public FlightsPage openFlightsPage() {
        menuTabs.get(1).click();
        return new FlightsPage(driver);
    }
}
