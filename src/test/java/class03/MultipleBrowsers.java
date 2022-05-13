package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowsers {
    private MultipleBrowsers() {
    }

    private static MultipleBrowsers instance = new MultipleBrowsers();

    public static MultipleBrowsers getInstance() {
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
        }
    }

    public static void closeBrowser() {
        getDriver().quit();
        driver.remove();
    }
}
