package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
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

    @FindBy(xpath = "//a[@data-decider-header='attractions']")
    private WebElement attractButton;

    @FindBy(css = ".css-19idom")
    private WebElement attractTitle;

    @FindBy(xpath = "//input[@type=\"search\"]")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement checkPriceButton;

    @FindBy(css = ".css-1rrebqu")
    private WebElement titleSearchResult;

    @FindBy(xpath = "//div[@class='Group-module__item___3zsS9']")
    private WebElement currencyIcon;

    @FindBy(xpath = "//div[@class='SheetContainer-module__inner___3oo3Y']")
    private WebElement currencyIconPopUp;

    @FindBy(xpath = "//div[@class='Group-module__item___3zsS9']")
    private List<WebElement> iconCurrency;

    @FindBy(xpath = "//div[@class='Stack-module__item--grow___1oiGm']")
    private List<WebElement> currency;

    @FindBy(xpath = "//div[@class=\"Text-module__root--variant-strong_1___2aniL\"]")
    private WebElement priceText;

    @FindBy(xpath = "//a[@title=\"Дубай\"]")
    private WebElement topDestination;

    @FindBy(xpath = "//div[@class=\"css-18yal0d\"]")
    private WebElement categoryTours;

    @FindBy(xpath = "//button[@class=\"Actionable-module__root___3GRl0 Button-module__root___1g71n Button-module__root--variant-secondary___3bOKl Button-module__root--size-medium___2hcsc Button-module__root--variant-secondary-action___35o54\"]")
    private List<WebElement> categories;

    @FindBy(xpath = "//button[@class=\"Actionable-module__root___3GRl0 ListItem-module__root___3J0lf ListItem-module__root--spacing-medium___2hv0Z ListItem-module__root--interactive___3xZTV\"]")
    private List<WebElement> categoriesMenu;

    @FindBy(xpath = "//div[@class=\"Grid-module__column___2DBft Grid-module__column--size-12___2Eiac\"]")
    private List<WebElement> dubaiCruise;

    @FindBy(xpath = "//h2[@class=\"Text-module__root--variant-headline_2___8MqQR css-1uk1gs8\"]")
    private WebElement cruiseTitle;

    @FindBy(xpath = "//a[@data-testid=\"search-bar-result\"]")
    private WebElement nant;

    @Step("Check title 'Find and book a great experience'")
    public AttractionsPage checkTitleFindAndBookAGreatExperience() {
        System.out.println(titleFindAndBookAGreatExperience.getText());
        softAssert.assertEquals(titleFindAndBookAGreatExperience.getText(), "Find and book a great experience",
                "The wrong language is displayed on the Attractions page!");
        return this;
    }

    @Step("Open Airport taxis page")
    public AirportTaxisPage openAirportTaxisPage() {
        tabAirportTaxis.get(4).click();
        return new AirportTaxisPage(driver);
    }

    @Step("Click on the Attractions Button on Home Page")
    public AttractionsPage clickOnAttractionsButton() {
        attractButton.click();
        return this;
    }

    @Step("Check that Attractions Page is displayed")
    public AttractionsPage checkAttractionsPageIsDisplayed() {
        System.out.println(driver.getCurrentUrl());
        System.out.println(attractTitle.getText());
        Assert.assertEquals(attractTitle.getText(), "Находите и бронируйте отличные варианты досуга", "The wrong title is displayed on the Attraction Page!");
        return this;
    }

    @Step("Input data in Search on Attractions Page")
    public AttractionsPage enterAttractionSearch() {
        inputSearch.sendKeys("Нант");
        return this;
    }

    @Step("Click on the CheckPrice Button on Attractions Page")
    public AttractionsPage clickOnCheckPriceButton() {
      try {
          System.out.println("Nant is displayed: " + nant.isDisplayed());
          nant.click();
      } catch (StaleElementReferenceException e){
          System.out.println("StaleElementReferenceException (Click on the CheckPrice Button on Attractions Page)");
          nant.click();
      }
        return this;
    }

    @Step("Check search results on Attractions Page")
    public AttractionsPage checkSearchAttractionsPage() {
        System.out.println(driver.getCurrentUrl());
        System.out.println(titleSearchResult.getText());
        Assert.assertEquals(titleSearchResult.getText(), "Нант", "Wrong search results!");
        return this;
    }

    @Step("Check that CurrencyIcon is displayed")
    public AttractionsPage checkCurrencyIconDisplayed() {
        System.out.println("Currency Icon is enabled: " + currencyIcon.isDisplayed());
        softAssert.assertTrue(currencyIcon.isEnabled(), "Currency Icon isn't enabled!");
        return this;
    }

    @Step("Click on the CurrencyIcon on Attractions Page")
    public AttractionsPage clickOnCurrencyIcon() {
        iconCurrency.get(0).click();
        return this;
    }

    @Step("Check that CurrencyIcon Pop-Up is displayed on Attractions Page")
    public AttractionsPage checkCurrencyIconPopUpDisplayed() {
        System.out.println("Currency Icon Pop-up is displayed: " + currencyIconPopUp.isEnabled());
        softAssert.assertTrue(currencyIconPopUp.isEnabled(), "Currency Icon Pop-up isn't enabled!");
        return this;
    }

    @Step("Choose the Currency in the CurrencyIcon Pop-Up")
    public AttractionsPage chooseCurrency() {
        for (WebElement c : currency) {
            System.out.println("Currency : " + c.getText());
            if (c.getText().equals("Доллар США\n" + "USD")) {
                c.click();
                break;
            }
        }
        return this;
    }

    @Step("Check that the Currency is Changed")
    public AttractionsPage checkCurrencyChanges() {
        softAssert.assertTrue(currencyIcon.isEnabled(), "Currency Icon isn't enabled!");
        Assert.assertEquals(currencyIcon.getText(), "USD", "Wrong title of the currency icon");
        String actualPriceText = priceText.getText();
        Assert.assertTrue(actualPriceText.contains("US$"));
        return this;
    }

    @Step("Check top destination is displayed")
    public AttractionsPage checkTopDestinationIsDisplayed() {
        System.out.println("Top destination is displayed: " + topDestination.isDisplayed());
        softAssert.assertTrue(topDestination.isDisplayed());
        return this;
    }

    @Step("Click on top destination")
    public AttractionsPage clickOnTopDestination(){
        try {
            WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(topDestination));
            topDestination.click();
        } catch (ClassCastException e) {
            System.out.println("ClassCastException");
        }
        topDestination.isDisplayed();
        topDestination.click();
        return this;
    }

    @Step("Check category tours is displayed")
    public AttractionsPage checkCategoryToursIsDisplayed() {
        System.out.println("Category Tours is displayed: " + categoryTours.isDisplayed());
        softAssert.assertTrue(categoryTours.isDisplayed());
        return this;
    }

    @Step("Click on category tours")
    public AttractionsPage clickOnCategoryTours() {
        categoryTours.click();
        return this;
    }

    @Step("Check category tours is enabled")
    public AttractionsPage checkCategoryToursIsEnabled() {
        System.out.println("Category Tours is enabled: " + categoryTours.isEnabled());
        softAssert.assertTrue(categoryTours.isEnabled());
        return this;
    }

    @Step("Click on categories")
    public AttractionsPage clickOnCategories() {
        categories.get(0).click();
        return this;
    }

    @Step("Choose popular on this week")
    public AttractionsPage choosePopularThisWeek() {
        categoriesMenu.get(0).click();
        return this;
    }

    @Step("Check popular on this week is enabled")
    public AttractionsPage checkPopularThisWeekIsEnabled() {
        System.out.println("Category Popular This Week is enabled: " + categoriesMenu.get(0).isEnabled());
        softAssert.assertTrue(categoriesMenu.get(0).isEnabled());
        return new AttractionsPage(driver);
    }

    @Step("Choose dubai cruise")
    public AttractionsPage chooseDubaiCruise() {
      try {
          dubaiCruise.get(0).click();
      } catch (StaleElementReferenceException e){
         System.out.println("StaleElementReferenceException (Choose dubai cruise)");
          dubaiCruise.get(0).click();
      }
        return this;
    }

    @Step("Get dubai cruise title")
    public AttractionsPage getCruiseTitle() {
        System.out.println("The title is: " + cruiseTitle.getText());
        softAssert.assertTrue(cruiseTitle.isDisplayed());
        return this;
    }
}
