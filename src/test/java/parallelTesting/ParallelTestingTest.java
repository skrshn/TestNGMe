package parallelTesting;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;


public class ParallelTestingTest {

    @BeforeMethod(alwaysRun = true)
    public void OpenBrowser() {
        //singleton concept
        BrowserFactory.getInstance().setDriver("chrome");
        BrowserFactory.getDriver().manage().window().maximize();
        BrowserFactory.getDriver().get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        BrowserFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(groups = "regression")
    public void VerifyCredentials() {
        SoftAssert softAssert = new SoftAssert();
        String expectedText = "Invalid credentials";
        BrowserFactory.getDriver().findElement(By.id("txtUsername")).sendKeys("Admin");
        BrowserFactory.getDriver().findElement(By.id("txtPassword")).sendKeys("1Hum@nhrm123");
        BrowserFactory.getDriver().findElement(By.id("btnLogin")).click();
        String actualText = BrowserFactory.getDriver().findElement(By.id("spanMessage")).getText();
        softAssert.assertEquals(actualText, expectedText);
        softAssert.assertAll();
        System.out.println("VerifyCredentials1");
    }

    @Test(groups = "regression")
    public void VerifyCredentials2() {
        SoftAssert soft = new SoftAssert();
        String expectedText = "Password cannot be empty";
        BrowserFactory.getDriver().findElement(By.id("txtUsername")).sendKeys("Admin");
        BrowserFactory.getDriver().findElement(By.id("txtPassword")).sendKeys("");
        BrowserFactory.getDriver().findElement(By.id("btnLogin")).click();
        String actualText = BrowserFactory.getDriver().findElement(By.id("spanMessage")).getText();
        soft.assertEquals(actualText, expectedText);
        soft.assertAll();
        System.out.println("VerifyCredentials2");
    }

    @AfterMethod(alwaysRun = true)
    public void CloseBrowser() {
        BrowserFactory.closeBrowser();
    }
}
