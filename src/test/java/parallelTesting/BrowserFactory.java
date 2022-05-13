package parallelTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    //singleton concept, only one instance allowed. whatever objects created from the class BrowserFactory, it'll use same instance.
    //constructor is private, to get instance you have to use getInstance() method
    //we can create objects of BrowserFactory class by using getInstance()
    //Lazy Initializing

    //diff between normal class and singleton class
    //for normal class we use constructor whereas for singleton class we use getInstance() method for instantiation
    private BrowserFactory() {
    }

    private static BrowserFactory instance = new BrowserFactory();

    public static BrowserFactory getInstance() {
        return instance;
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static void setDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeBrowser() {
        getDriver().close();
        driver.remove();
    }
}
