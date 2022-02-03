package tests;

import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckAttractionsPageSearch {

    @Test(groups = "regression",
            description = "Check the search results on the Attraction page")
    public void CheckAttractionsPageSearch(){
        WebDriverManager.chromedriver().setup();
        new BasePage(new ChromeDriver())
                .openBooking()
                .checkAttractionsPageButtonIsDisplayed()
                .clickOnAttractionsButton()
                .checkAttractionsPageIsDisplayed()
                .enterAttractionSearch()
                .clickOnCheckPriceButton()
                .checkSearchAttractionsPage();
    }
    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}
