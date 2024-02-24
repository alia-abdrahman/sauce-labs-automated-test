package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {


    // ELEMENTS

    // Checkout button
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;


    public CartPage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class

        PageFactory.initElements(driver, this);
    }

    // ACTIONS

    // Click checkout button
    public CartPage clickCheckoutButton() {

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        //wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(checkoutButton).pause(1000).click().perform(); // Add a pause of 1000 milliseconds (1 second)

        return this;
    }



}
