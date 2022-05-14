package codilityLoginExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class codilityBrowserFactory {
    private codilityBrowserFactory() {
    }

    private static codilityBrowserFactory instance = new codilityBrowserFactory();

    public static codilityBrowserFactory getInstance() {
        return instance;
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            //driver.get().manage().window().maximize();
        }
    }

    public static void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }
}

