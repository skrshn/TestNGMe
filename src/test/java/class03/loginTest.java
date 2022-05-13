package class03;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class loginTest {

    @BeforeMethod(alwaysRun = true)
    public void OpenBrowser() {
        //singleton concept
        MultipleBrowsers.getInstance().setDriver("chrome");
        MultipleBrowsers.getDriver().get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        MultipleBrowsers.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(groups = "regression")
    public void VerifyCredentials() {
        // MultipleBrowsers.getDriver() = MultipleBrowsers.getDriver();
        SoftAssert soft = new SoftAssert();
        String expectedText = "Invalid credentials";
        MultipleBrowsers.getDriver().findElement(By.id("txtUsername")).sendKeys("Admin");
        MultipleBrowsers.getDriver().findElement(By.id("txtPassword")).sendKeys("1Hum@nhrm123");
        MultipleBrowsers.getDriver().findElement(By.id("btnLogin")).click();
        String actualText = MultipleBrowsers.getDriver().findElement(By.id("spanMessage")).getText();
        soft.assertEquals(actualText, expectedText);
        soft.assertAll();
        System.out.println("VerifyCredentials1");
    }

    @Test(groups = "regression")
    public void VerifyCredentials2() {
        //MultipleBrowsers.getDriver() = MultipleBrowsers.getDriver();
        SoftAssert soft = new SoftAssert();
        String expectedText = "Invalid credentials";
        MultipleBrowsers.getDriver().findElement(By.id("txtUsername")).sendKeys("Admin");
        MultipleBrowsers.getDriver().findElement(By.id("txtPassword")).sendKeys("1Hum@nhrm123");
        MultipleBrowsers.getDriver().findElement(By.id("btnLogin")).click();
        String actualText = MultipleBrowsers.getDriver().findElement(By.id("spanMessage")).getText();
        soft.assertEquals(actualText, expectedText);
        soft.assertAll();
        System.out.println("VerifyCredentials2");
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