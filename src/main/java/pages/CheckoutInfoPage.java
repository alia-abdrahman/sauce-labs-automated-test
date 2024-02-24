package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage extends BasePage {

    // ELEMENTS

    // First name field
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    // Last name field
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    // Postal code field
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;


    public CheckoutInfoPage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class

        PageFactory.initElements(driver, this);
    }

    // ACTIONS

    String firstname = "any first name";
    String lastname = "any last name";
    String postalcode = "12345";


    public CheckoutInfoPage enterFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public CheckoutInfoPage enterLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public CheckoutInfoPage enterPostalCode(String postalCode) {
        this.postalCode.sendKeys(postalCode);
        return this;
    }

    public CheckoutInfoPage clickContinueButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(continueButton).pause(1000).click().perform(); // Add a pause of 1000 milliseconds (1 second)

        return this;
    }

}
