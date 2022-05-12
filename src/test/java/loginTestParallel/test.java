package loginTestParallel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class test {
    static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeMethod(alwaysRun = true)
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        driver.get().get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test(groups = "regression")
    public void VerifyCredentials() {
        SoftAssert soft = new SoftAssert();
        String expectedText = "Invalid credentials";
        driver.get().findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.get().findElement(By.id("txtPassword")).sendKeys("1Hum@nhrm123");
        driver.get().findElement(By.id("btnLogin")).click();
        String text = driver.get().findElement(By.id("spanMessage")).getText();
        soft.assertEquals(text, expectedText);

        System.out.println("VerifyCredentials1");

        soft.assertAll();
    }

    @Test(groups = "regression")
    public void VerifyCredentials2() {
        SoftAssert soft = new SoftAssert();
        String expectedText = "Password cannot be empty";
        driver.get().findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.get().findElement(By.id("txtPassword")).sendKeys("");
        driver.get().findElement(By.id("btnLogin")).click();
        String text = driver.get().findElement(By.id("spanMessage")).getText();
        soft.assertEquals(text, expectedText);

        System.out.println("VerifyCredentials2");

        soft.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void CloseBrowser() {
        driver.get().close();
    }
}
