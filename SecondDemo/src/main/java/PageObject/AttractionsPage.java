package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AttractionsPage extends BasePage {

    public AttractionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"Text-module__root--variant-headline_1___29-Qz css-19idom\"]")
    private WebElement titleFindAndBookAGreatExperience;

    @FindBy(css = ".Tab-module__item___2B7Xl")
    private List<WebElement> tabAirportTaxis;

    public AttractionsPage checkTitleFindAndBookAGreatExperience() {
        System.out.println(titleFindAndBookAGreatExperience.getText());
        softAssert.assertEquals(titleFindAndBookAGreatExperience.getText(), "Find and book a great experience",
                "The wrong language is displayed on the Attractions page!");
        return this;
    }

    public AirportTaxisPage openAirportTaxisPage(){
        tabAirportTaxis.get(4).click();
        return new AirportTaxisPage(driver);
    }

}
