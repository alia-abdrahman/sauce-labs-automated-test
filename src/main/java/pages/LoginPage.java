package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {


    // ELEMENTS

    // Login header
    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement loginHeader;

    // Username field
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    // Password field
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    // Login button
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {

        super(driver); // Call the constructor of the BasePage class

        PageFactory.initElements(driver, this);
    }


    // ACTIONS

    // Verify login header is displayed
    public LoginPage verifyLoginHeader() {
        Assert.assertTrue(loginHeader.isDisplayed(), "Login header is not displayed");
        return this;
    }

    // Verify username field is displayed
    public LoginPage verifyUsernameField() {
        Assert.assertTrue(username.isDisplayed(), "Username field is not displayed");
        return this;
    }
    // Verify password field is displayed
    public LoginPage verifyPasswordField() {
        Assert.assertTrue(password.isDisplayed(), "Password field is not displayed");
        return this;
    }
    // Verify login button is displayed
    public LoginPage verifyLoginButton() {
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        return this;
    }

    public LoginPage enterUsername(String username) {
        //username.clear();
        this.username.clear();
        //username.sendKeys("standard_user");
        this.username.sendKeys("standard_user");
        return this;
    }

    public LoginPage enterPassword(String password) {
        //password.clear();
        this.password.clear();
        //password.sendKeys("secret_sauce");
        this.password.sendKeys("secret_sauce");
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }


    // Open the inventory page
    public LoginPage openPage() {

        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(loginHeader)); // Wait for inventoryTitle to be visible (explicit wait)
        return this;
    }

    // Login
    public LoginPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return this;
    }





}
