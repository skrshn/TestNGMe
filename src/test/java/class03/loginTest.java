package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class loginTest {
    static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test(groups = "regression")
    public void VerifyCredentials() {
        SoftAssert soft = new SoftAssert();

        String expectedText = "Invalid credentials";
        WebElement Username = driver.findElement(By.id("txtUsername"));
        boolean displayed = Username.isDisplayed();
        Username.sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("1Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        soft.assertEquals(text, expectedText);

        System.out.println("hello world1");
        soft.assertTrue(displayed);
        soft.assertAll();

    }

    @Test(groups = "regression")
    public void VerifyCredentials2() {
        SoftAssert soft = new SoftAssert();

        String expectedText = "Password cannot be empty";
        WebElement Username = driver.findElement(By.id("txtUsername"));
        boolean displayed = Username.isDisplayed();
        Username.sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        soft.assertEquals(text, expectedText);

        System.out.println("hello world2");
        soft.assertTrue(displayed);
        soft.assertAll();

    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        //to format the date according to our choice we want to implement in this function
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void takeScreenShot(String path) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(path + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void highlightErrorMessage(String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement errorMessage = driver.findElement(By.id("spanMessage"));
        js.executeScript("arguments[0].style.backgroundColor='" + color + "'", errorMessage);
    }

    @AfterMethod(alwaysRun = true)
    public void CloseBrowser() {
        driver.quit();
    }

}