package listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static PageObject.BasePage.getDriver;

public class ClassForListener implements ITestListener {

    @Attachment
    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot scr = ((TakesScreenshot) getDriver());
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
