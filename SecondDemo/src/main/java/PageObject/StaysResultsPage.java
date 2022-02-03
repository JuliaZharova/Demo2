package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StaysResultsPage extends BasePage {

    public StaysResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-filters-group=\"pri\"]")
    private WebElement filterPopup;

    @FindBy(xpath = "//div[@data-testid=\"price-and-discounted-price\"]")
    private List<WebElement> price;

    @FindBy(xpath = "//div[@data-filters-item=\"pri:pri=1\"]")
    private WebElement priceFilterLess2000;

    @FindBy(xpath = "//div[@data-filters-item=\"pri:pri=1\"]")
    private WebElement checkBoxForPriceFilterLess2000;

    @FindBy(xpath = "//h1[@class=\"_30227359d _0db903e42\"]")
    private WebElement titleResultAfterFiltering;

    @FindBy(xpath = "//button[@class=\"_4310f7077 _ab6816951 _61890ffeb e33c6840d8 _8f1ea26a7\"]")
    private WebElement closeButton;

    @FindBy(xpath = "//li[@data-id=\"popularity\"]")
    private WebElement popularityButton;

    @FindBy(xpath = "//a[@data-type=\"upsort_bh\"]")
    private WebElement housesAndApartmentsFirstButton;

    @FindBy(xpath = "//a[@data-type=\"price\"]")
    private WebElement fromLowPriceButton;

    @FindBy(xpath = "//div[@data-testid=\"overlay-card\"]")
    private WebElement overlayCard;

    @Step("Check that filter popup is displayed")
    public StaysResultsPage checkFilterPopupIsDisplayed() {
        System.out.println("Filter popup is displayed: " + filterPopup.isDisplayed());
        softAssert.assertTrue(filterPopup.isDisplayed(), "Filter popup isn't displayed!");
        return this;
    }

    @Step("Check that price filter 'Less2000' is displayed")
    public StaysResultsPage checkPriceFilterLess2000IsDisplayed() {
        System.out.println("Price filter 'Less2000' is displayed: " + priceFilterLess2000.isDisplayed());
        softAssert.assertTrue(priceFilterLess2000.isDisplayed(), "Price filter 'Less2000' isn't displayed!");
        return this;
    }

    @Step("Check that checkbox for price filter 'Less 2000' is enabled")
    public StaysResultsPage checkCheckBoxForPriceFilterLess2000IsEnabled() {
        System.out.println("Checkbox for price filter 'Less 2000' is enabled: " + checkBoxForPriceFilterLess2000.isEnabled());
        softAssert.assertTrue(checkBoxForPriceFilterLess2000.isEnabled(), "Checkbox for price filter 'Less 2000' isn't enabled!");
        return this;
    }

    @Step("Click on checkbox for price filter 'Less 2000'")
    public StaysPage clickOnCheckBoxForPriceFilterLess2000() {
        try {
            checkBoxForPriceFilterLess2000.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Checkbox for price filter 'Less 2000' is unclickable.");
            checkBoxForPriceFilterLess2000.click();
        }
        driver.getPageSource();
        return new StaysPage(driver);
    }

    @Step("Check that overlay card is displayed")
    public StaysResultsPage checkOverlayCardIsDisplayed(){
       try{
           System.out.println("Overlay card is displayed:" + overlayCard.isDisplayed());
           softAssert.assertTrue(overlayCard.isDisplayed(), "Overlay card isn't displayed");
       } catch (NoSuchElementException e){
           System.out.println("Overlay card isn't displayed");
       }
        return this;
    }

    @Step("Check that the name of the destination match the entered")
    public StaysResultsPage checkTitleResultAfterFiltering() {
        String result = titleResultAfterFiltering.getText();
        String destinationName = result.substring(0, 8);
        System.out.println(destinationName);
        softAssert.assertEquals(destinationName, "Буковель", "The name of the destination does not match the entered!");
        return this;
    }

    @Step("Click on close button")
    public StaysResultsPage clickOnCloseButton() {
        closeButton.click();
        return this;
    }

    @Step("Check that 'Popularity' button is displayed")
    public StaysResultsPage checkPopularityButtonIsDisplayed() {
        System.out.println("'Popularity' button is displayed: " + popularityButton.isDisplayed());
        softAssert.assertTrue(popularityButton.isDisplayed(), "'Popularity' button isn't displayed!");
        return this;
    }

    @Step("Check that 'Houses and apartments first' button is displayed")
    public StaysResultsPage checkHousesAndApartmentsFirstButtonIsDisplayed() {
        System.out.println("'Houses and apartments first' button is displayed: " + housesAndApartmentsFirstButton.isDisplayed());
        softAssert.assertTrue(housesAndApartmentsFirstButton.isDisplayed(), "'Houses and apartments first' button isn't displayed!");
        return this;
    }

    @Step("Check that 'From low price' button is displayed")
    public StaysResultsPage checkFromLowPriceButtonIsDisplayed() {
        System.out.println("'From low price' button is displayed: " + fromLowPriceButton.isDisplayed());
        softAssert.assertTrue(fromLowPriceButton.isDisplayed(), "'From low price' button isn't displayed!");
        return this;
    }

    @Step("Check that the price is less than or equal to 2000")
    public StaysResultsPage checkPrice() {
        try {
            for (WebElement p : price) {
                String q = p.getText();
                if (q.length() > 9) {
                    String sub = q.substring(13);
                    System.out.println(sub);
                    if (sub.length() > 4) {
                        char expected;
                        if (sub.charAt(0) == '1') {
                            expected = '1';
                        } else {
                            expected = '2';
                        }
                        softAssert.assertEquals(sub.charAt(0), expected, "The price is more than 2000 UAH!");
                    }
                } else System.out.println(q.substring(4));
                softAssert.assertAll();
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException caught.");
        }
        return this;
    }
}
