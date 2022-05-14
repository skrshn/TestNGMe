package codilityLoginExample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLocators extends codilityLoginTestBase {
    @FindBy(id = "email-input")
    private WebElement emailField;

    @FindBy(id = "password-input")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(@class,'message') or contains(@class,'error')]")
    private WebElement messageField;

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getMessageField() {return messageField;}

    public PageLocators() {
        PageFactory.initElements(codilityBrowserFactory.getDriver(), this);
    }
}