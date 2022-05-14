package codilityLoginExample.utils;

import codilityLoginExample.pages.PageLocators;
import codilityLoginExample.testBase.codilityLoginTestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonMethods extends codilityLoginTestBase {
    public static void takeScreenshot(String fileName) {
        File sourceFile = ((TakesScreenshot) codilityBrowserFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName
                    + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static void highlightField(String color) {
        PageLocators pageLocators = new PageLocators();
        JavascriptExecutor js = (JavascriptExecutor) codilityBrowserFactory.getDriver();
        try {
            js.executeScript("arguments[0].style.backgroundColor='" + color + "'", pageLocators.getMessageField());
        } catch (Exception e) {
        }
    }
}
