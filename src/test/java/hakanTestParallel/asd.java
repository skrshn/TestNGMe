package hakanTestParallel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class asd {
    WebDriver driver;
    @Test
    void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement logo=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(3000);


    }
    @Test
    void test2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        String title=driver.getTitle();
        Assert.assertEquals(title,"SYNTAXHRM");
        Thread.sleep(3000);


    }
    @AfterTest
    void teardown(){
        driver.quit();


    }
}