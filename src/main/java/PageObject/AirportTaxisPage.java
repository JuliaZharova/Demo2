package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AirportTaxisPage extends BasePage{

    public AirportTaxisPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-decider-header='rideways']")
    private WebElement airportTaxisButton ;

    @FindBy(css = ".sb-searchbox__title")
    private WebElement airportTaxisTittle ;

    @FindBy(id = "returnJourneyNegative")
    private WebElement oneWayTaxiButton ;

    @FindBy(xpath = "")
    private WebElement PickupLocationInputField;

    @FindBy(xpath = "")
    private WebElement destinationInputField;


    public AirportTaxisPage clickOnAirportTaxisButton(){
        airportTaxisButton.click();
        return this;
    }

    public AirportTaxisPage checkAirportTaxisPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(airportTaxisTittle));
        System.out.println(driver.getCurrentUrl());
        System.out.println(airportTaxisTittle.getText());
        Assert.assertEquals(airportTaxisTittle.getText(),"Забронируйте такси от/до аэропорта",
                "The wrong title is displayed on the Airport taxis page!");
        return this;
    }
    public AirportTaxisPage checkOneWayTaxiButtonIsChosen(){
        softAssert.assertEquals(oneWayTaxiButton.getCssValue("background-color"), "#07c");
        return this;
    }

    public AirportTaxisPage inputPickupLocation(){
        System.out.println("Input field 'Destination' is enabled: " + PickupLocationInputField.isEnabled());
        softAssert.assertTrue(PickupLocationInputField.isEnabled(), "Input field 'Pick-up Location' isn't enabled!");
        PickupLocationInputField.sendKeys("улица Валентиновская");
        return this;
    }

    public AirportTaxisPage checkPickupLocationInput(){
        System.out.println(PickupLocationInputField.getText());
        return this;
    }

    public AirportTaxisPage inputDestination(){
        System.out.println("Input field 'Destination' is enabled: " + destinationInputField.isEnabled());
        softAssert.assertTrue(destinationInputField.isEnabled(), "Input field 'Destination' isn't enabled!");
        destinationInputField.sendKeys("");
        return this;
    }

    public AirportTaxisPage checkDestinationInput(){
        System.out.println(destinationInputField.getText());
        return this;
    }



}