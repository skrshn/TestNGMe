package codilityLoginExample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class codilityLoginTestBase {
    @BeforeMethod
    public void openBrowser() {
        codilityBrowserFactory.setDriver("chrome");
        codilityBrowserFactory.getDriver().get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static" +
                "/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        codilityBrowserFactory.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() {
        codilityBrowserFactory.closeBrowser();
    }
}
