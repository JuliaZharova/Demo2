package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarRentalCoronavirusPage extends CarRentalsPage{

    public CarRentalCoronavirusPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement carRentalCoronavirusTitle;

    public CarRentalCoronavirusPage checkCarRentalCoronavirusPageIsDisplayed() {
        System.out.println("Help Center page is displayed:" + carRentalCoronavirusTitle.isDisplayed());
        softAssert.assertTrue(carRentalCoronavirusTitle.isDisplayed());
        return this;
    }

    public CarRentalCoronavirusPage checkTitleCarRentalCoronavirusPage() {
        System.out.println("Title of Car rental coronavirus page: " + carRentalCoronavirusTitle.getText());
        softAssert.assertEquals("Информация от Booking.com об аренде автомобилей во время вспышки коронавируса (COVID-19)", carRentalCoronavirusTitle.getText());
        return this;
    }
}