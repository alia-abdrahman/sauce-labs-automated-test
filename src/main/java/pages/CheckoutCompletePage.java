package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage {

    @FindBy(xpath = "//img[@alt='Pony Express']")
    private WebElement checkoutSuccessIcon;

    @FindBy(xpath = "//h2[contains(.,'Thank you for your order!')]")
    private WebElement checkoutCompleteMessage;

    @FindBy(xpath = "//div[@class='complete-text']")
    private WebElement checkoutCompleteMessageDesc;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backToProductsButton;


    public CheckoutCompletePage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class

        PageFactory.initElements(driver, this);
    }

    public CheckoutCompletePage verifyCheckoutCompleteMessageisDisplayed() {
        Assert.assertTrue(checkoutSuccessIcon.isDisplayed());
        Assert.assertTrue(checkoutCompleteMessage.isDisplayed());
        Assert.assertTrue(checkoutCompleteMessageDesc.isDisplayed());
        return this;
    }

    public CheckoutCompletePage clickBackToProductsButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(backToProductsButton).pause(1000).click().perform(); // Add a pause of 1000 milliseconds (1 second)

        return this;
    }
}
