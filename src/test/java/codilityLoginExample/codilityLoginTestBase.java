package codilityLoginExample;

import org.testng.annotations.BeforeMethod;

public class codilityLoginTestBase {
    @BeforeMethod
    public static void openBrowser() {
        codilityBrowserFactory.setDriver("chrome");
        codilityBrowserFactory.getDriver().get("");
    }
}
