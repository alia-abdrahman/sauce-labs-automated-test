package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage {


    // ELEMENTS
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class

        PageFactory.initElements(driver, this);
    }

    // ACTIONS
    public CheckoutOverviewPage clickFinishButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(finishButton).pause(1000).click().perform(); // Add a pause of 1000 milliseconds (1 second)

        return this;

    }
}
