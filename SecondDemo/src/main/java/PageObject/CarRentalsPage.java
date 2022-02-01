package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarRentalsPage extends BasePage{

    public CarRentalsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".sb-searchbox__title-text")
    private WebElement titleCarRentalsForAnyKindOfTrip;

    public CarRentalsPage checkTitleCarRentalsForAnyKindOfTripInEng(){
        System.out.println(titleCarRentalsForAnyKindOfTrip.getText());
        softAssert.assertEquals(titleCarRentalsForAnyKindOfTrip.getText(), "Car rentals for any kind of trip");
        return this;
    }

    public AttractionsPage openAttractionsPage(){
        menuTabs.get(3).click();
        return new AttractionsPage(driver);
    }
}
