package listener;

import PageObject.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClassForListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot scr = ((TakesScreenshot) BasePage.driver);
        byte[] screenshot = scr.getScreenshotAs(OutputType.BYTES);

        String fileName = "screenshot.png";
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
           fileOutputStream.write(screenshot);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
