package class03;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase{



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
}