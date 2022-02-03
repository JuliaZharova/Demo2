package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckCurrencyChangeAttractionPage {

    @Test(groups = "smoke",
            description = "Check that the currency on the Attraction page has changed")
    public void CheckCurrencyChangeAttractionPage() {
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver())
                .openBooking()
                .checkAttractionsPageButtonIsDisplayed()
                .clickOnAttractionsButton()
                .checkAttractionsPageIsDisplayed()
                .enterAttractionSearch()
                .clickOnCheckPriceButton()
                .checkSearchAttractionsPage()
                .checkCurrencyIconDisplayed()
                .clickOnCurrencyIcon()
                .checkCurrencyIconPopUpDisplayed()
                .chooseCurrency()
                .checkCurrencyChanges();
    }
    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}