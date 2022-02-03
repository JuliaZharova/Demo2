package tests;

import PageObject.AttractionsPage;
import PageObject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckPopularTour {

    @Test(groups = "smoke",
            description = "Check popular tour")
    public void checkPopularTour() {
        WebDriverManager.chromedriver().setup();
        new AttractionsPage(new ChromeDriver()).openBooking()
                .checkAttractionsButtonIsDisplayed()
                .clickOnAttractions()
                .checkAttractionsButtonIsEnabled()
                .getAttractionsTitle()
                .checkTopDestinationIsDisplayed()
                .clickOnTopDestination()
                .checkCategoryToursIsDisplayed()
                .clickOnCategoryTours()
                .checkCategoryToursIsEnabled()
                .clickOnCategories()
                .choosePopularThisWeek()
                .checkPopularThisWeekIsEnabled()
                .chooseDubaiCruise()
                .getCruiseTitle();
    }

    @AfterMethod(description = "Quit driver")
    public void closeBrowser() {
        BasePage.setDown();
    }
}