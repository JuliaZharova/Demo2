package PageObject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StaysResultsPage extends BasePage{

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

    @FindBy(xpath = "//input[@name=\"pri=1\"]")
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

    public StaysResultsPage checkFilterPopupIsDisplayed(){
        System.out.println("Filter popup is displayed: " + filterPopup.isDisplayed());
        softAssert.assertTrue(filterPopup.isDisplayed());
        return this;
    }

    public StaysResultsPage checkPriceFilterLess2000IsDisplayed(){
        System.out.println("Price filter 'Less2000' is displayed: " + priceFilterLess2000.isDisplayed());
        softAssert.assertTrue(priceFilterLess2000.isDisplayed());
        return this;
    }

public StaysResultsPage checkCheckBoxForPriceFilterLess2000IsEnabled(){
        System.out.println("Checkbox for price filter 'Less 2000' is enabled: " + checkBoxForPriceFilterLess2000.isEnabled());
        softAssert.assertTrue(checkBoxForPriceFilterLess2000.isEnabled());
        return this;
}

    public StaysPage clickOnCheckBoxForPriceFilterLess2000(){
       checkBoxForPriceFilterLess2000.click();
       return new StaysPage(driver);
    }

    public StaysResultsPage checkTitleResultAfterFiltering(){
        String result = titleResultAfterFiltering.getText();
        String destinationName = result.substring(0,8);
        System.out.println(destinationName);
        softAssert.assertEquals(destinationName, "Буковель");
        return this;
    }

    public StaysResultsPage clickOnCloseButton(){
        closeButton.click();
        return this;
    }

    public StaysResultsPage checkPopularityButtonIsDisplayed(){
        System.out.println("'Popularity' button is displayed: " + popularityButton.isDisplayed());
        return this;
    }

    public StaysResultsPage checkHousesAndApartmentsFirstButtonIsDisplayed(){
        System.out.println("'Houses and apartments first' button is displayed: " + housesAndApartmentsFirstButton.isDisplayed());
        return this;
    }

    public StaysResultsPage checkFromLowPriceButtonIsDisplayed(){
        System.out.println("'From low price' button is displayed: " + fromLowPriceButton.isDisplayed());
        return this;
    }

    public StaysResultsPage checkPrice(){
        try {
          for (WebElement p : price) {
              String q = p.getText();
              if(q.length()>9){
                  String sub = q.substring(13);
                  System.out.println(sub);
                  if (sub.length()>4) {
                      char expected;
                      if (sub.charAt(0)=='1') {
                          expected = '1';
                      } else {
                          expected = '2';
                      }
                      softAssert.assertEquals(sub.charAt(0), expected);
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
