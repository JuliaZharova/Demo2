package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AttractionsPage extends BasePage {

    public AttractionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"Text-module__root--variant-headline_1___29-Qz css-19idom\"]")
    private WebElement titleFindAndBookAGreatExperience;

    @FindBy(xpath = "//div[@class=\"css-1t3v2n3\"]")
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

    @FindBy(css = ".Tab-module__item___2B7Xl")
    private List<WebElement> tabAirportTaxis;

    public AttractionsPage checkTitleFindAndBookAGreatExperience() {
        System.out.println(titleFindAndBookAGreatExperience.getText());
        softAssert.assertEquals(titleFindAndBookAGreatExperience.getText(), "Find and book a great experience");
        return this;
    }

    public AirportTaxisPage openAirportTaxisPage(){
        tabAirportTaxis.get(4).click();
        return new AirportTaxisPage(driver);
    }
    //@Step("Check top destination is displayed")
    public AttractionsPage checkTopDestinationIsDisplayed() {
        System.out.println("Top destination is displayed: " + topDestination.isDisplayed());
        softAssert.assertTrue(topDestination.isDisplayed());
        return new AttractionsPage(driver);
    }
    //@Step("Click on top destination")
    public AttractionsPage clickOnTopDestination() {
        topDestination.click();
        return this;
    }
    //@Step("Check category tours is displayed")
    public AttractionsPage checkCategoryToursIsDisplayed() {
        System.out.println("Category Tours is displayed: " + categoryTours.isDisplayed());
        softAssert.assertTrue(categoryTours.isDisplayed());
        return new AttractionsPage(driver);
    }
    //@Step("Click on category tours")
    public AttractionsPage clickOnCategoryTours() {
        categoryTours.click();
        return this;
    }
    //@Step("Check category tours is enabled")
    public AttractionsPage checkCategoryToursIsEnabled() {
        System.out.println("Category Tours is enabled: " + categoryTours.isEnabled());
        softAssert.assertTrue(categoryTours.isEnabled());
        return new AttractionsPage(driver);
    }
    //@Step("Click on categories")
    public AttractionsPage clickOnCategories() {
        categories.get(0).click();
        return this;
    }
    //@Step("Choose popular on this week")
    public AttractionsPage choosePopularThisWeek() {
        categoriesMenu.get(0).click();
        return this;
    }
    //@Step("Check popular on this week is enabled")
    public AttractionsPage checkPopularThisWeekIsEnabled() {
        System.out.println("Category Popular This Week is enabled: " + categoriesMenu.get(0).isEnabled());
        softAssert.assertTrue(categoriesMenu.get(0).isEnabled());
        return new AttractionsPage(driver);
    }
    //@Step("Choose dubai cruise")
    public AttractionsPage chooseDubaiCruise() {
        dubaiCruise.get(0).click();
        return this;
    }
    //@Step("Get dubai cruise title")
    public AttractionsPage getCruiseTitle() {
        System.out.println("The title is: " + cruiseTitle.getText());
        softAssert.assertTrue(cruiseTitle.isDisplayed());
        return new AttractionsPage(driver);
    }

}
