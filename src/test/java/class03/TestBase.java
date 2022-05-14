package class03;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    @BeforeMethod(alwaysRun = true)
    public void OpenBrowser() {
        //singleton concept
        MultipleBrowsers.getInstance().setDriver("chrome");
        MultipleBrowsers.getDriver().get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        MultipleBrowsers.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        //to format the date according to our choice we want to implement in this function
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void takeScreenShot(String fileName) {
        File sourceFile = ((TakesScreenshot) MultipleBrowsers.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName
                    + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void highlightErrorMessage(String color) {
        JavascriptExecutor js = (JavascriptExecutor) MultipleBrowsers.getDriver();
        WebElement errorMessage = MultipleBrowsers.getDriver().findElement(By.id("spanMessage"));
        js.executeScript("arguments[0].style.backgroundColor='" + color + "'", errorMessage);
    }

    @AfterMethod(alwaysRun = true)
    public void CloseBrowser() {
        MultipleBrowsers.closeBrowser();
    }

}
