package codilityLoginExample.test;

import codilityLoginExample.utils.codilityListener;
import codilityLoginExample.testBase.codilityLoginTestBase;
import codilityLoginExample.pages.PageLocators;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(codilityListener.class)
public class codilityLoginTest extends codilityLoginTestBase {

    @DataProvider(name = "wrongLoginInformation")
    public static Object[][] wrongLoginInformation() {
        Object[][] wrongLoginInformation = {{"unknown@codility.com", "password", "You shall not pass! Arr!1"},
                {"logincodility.com", "password", "Enter a valid email1"},
                {"", "password", "Email is required1"}};
        return wrongLoginInformation;
    }

    @DataProvider(name = "validLoginInformation")
    public static Object[][] validLoginInformation() {
        Object[][] validLoginInformation = {{"login@codility.com", "password", "Welcome to Codility1"}};
        return validLoginInformation;
    }

    @Test
    void fieldVerification() {
        PageLocators pageLocators = new PageLocators();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pageLocators.getEmailField().isDisplayed());
        softAssert.assertTrue(pageLocators.getPasswordField().isDisplayed());
        softAssert.assertTrue(pageLocators.getLoginButton().isDisplayed());
        softAssert.assertAll();
    }

    @Test(dataProvider = "validLoginInformation")
    void validCredentials(String username, String password, String expectedMessage) {
        PageLocators pageLocators = new PageLocators();
        SoftAssert softAssert = new SoftAssert();
        pageLocators.getEmailField().sendKeys(username);
        pageLocators.getPasswordField().sendKeys(password);
        pageLocators.getLoginButton().click();
        String actualMessage = pageLocators.getMessageField().getText();

        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }

    @Test(dataProvider = "wrongLoginInformation")
    void wrongCredentials(String username, String password, String expectedMessage) {
        PageLocators pageLocators = new PageLocators();
        SoftAssert softAssert = new SoftAssert();
        pageLocators.getEmailField().sendKeys(username);
        pageLocators.getPasswordField().sendKeys(password);
        pageLocators.getLoginButton().click();
        String actualMessage = pageLocators.getMessageField().getText();

        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }
}
