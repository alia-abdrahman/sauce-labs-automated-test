package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backToProductsButton;


    public CheckoutCompletePage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class

        PageFactory.initElements(driver, this);
    }

    public CheckoutCompletePage clickBackToProductsButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(backToProductsButton).pause(1000).click().perform(); // Add a pause of 1000 milliseconds (1 second)

        return this;
    }
}
