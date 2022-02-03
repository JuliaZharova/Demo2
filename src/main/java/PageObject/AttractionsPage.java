package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class AttractionsPage extends BasePage{

    public AttractionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-decider-header='attractions']")
    private WebElement attractButton;

    @FindBy(css = ".css-19idom")
    private WebElement attractTitle;

    @FindBy(xpath = "//input[@type=\"search\"]")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement checkPriceButton;

    @FindBy(css =  ".css-1rrebqu")
    private WebElement titleSearchResult;

    @FindBy(xpath = "//div[@class='Group-module__item___3zsS9']")
    private WebElement currencyIcon;

    @FindBy(xpath = "//div[@class='SheetContainer-module__inner___3oo3Y']")
    private WebElement currencyIconPopUp;

    @FindBy(xpath = "//div[@class='Group-module__item___3zsS9']")
    private List<WebElement> iconCurrency;

    @FindBy(xpath = "//div[@class='Stack-module__item--grow___1oiGm']")
    private List<WebElement>  currency;

    @FindBy(partialLinkText = "US$44,98")
    private WebElement  priceText;


    @Step("Click on the Attractions Button on Home Page")
    public AttractionsPage clickOnAttractionsButton(){
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
    public AttractionsPage clickOnCheckPriceButton(){
        checkPriceButton.click();
        return this;
    }

    @Step("Check search results on Attractions Page")
    public AttractionsPage checkSearchAttractionsPage() {
        System.out.println(driver.getCurrentUrl());
        System.out.println(titleSearchResult.getText());
        Assert.assertEquals(titleSearchResult.getText(), "Нант","Wrong search results!");
        return this;
    }

    @Step("Check that CurrencyIcon is displayed")
    public AttractionsPage checkCurrencyIconDisplayed(){
        System.out.println("Currency Icon is enabled: " + currencyIcon.isDisplayed());
        softAssert.assertTrue(currencyIcon.isEnabled(),"Currency Icon isn't enabled!");
        return this;
    }

    @Step("Click on the CurrencyIcon on Attractions Page")
    public AttractionsPage clickOnCurrencyIcon(){
        iconCurrency.get(0).click();
        return this;
    }

    @Step("Check that CurrencyIcon Pop-Up is displayed on Attractions Page")
    public AttractionsPage checkCurrencyIconPopUpDisplayed(){
        System.out.println("Currency Icon Pop-up is displayed: " + currencyIconPopUp.isEnabled());
        softAssert.assertTrue(currencyIconPopUp.isEnabled(),"Currency Icon Pop-up isn't enabled!");
        return this;
    }

    @Step("Choose the Currency in the CurrencyIcon Pop-Up")
    public AttractionsPage chooseCurrency(){
        for(WebElement c : currency){
            System.out.println("Currency : " + c.getText());
            if(c.getText().equals("Доллар США\n" + "USD")){
                c.click();
                break;
            }
        }
        return this;
    }

    @Step("Check that the Currency is Changed")
    public AttractionsPage checkCurrencyChanges(){
        softAssert.assertTrue(currencyIcon.isEnabled(),"Currency Icon isn't enabled!");
        Assert.assertEquals(currencyIcon.getText(), "USD", "Wrong title of the currency icon");
        String actualPriceText = priceText.getText();
        Assert.assertTrue(actualPriceText.contains("US$"));
        return this;
    }
}