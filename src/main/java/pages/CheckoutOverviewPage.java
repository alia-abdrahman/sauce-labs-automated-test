package pages;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutOverviewPage extends BasePage {


    // ELEMENTS
    @FindBy(xpath = "//div[@class='summary_info_label'][contains(.,'Payment Information')]")
    private WebElement paymentInformationLabel;

    @FindBy(xpath = "//div[@class='summary_info_label'][contains(.,'Shipping Information')]")
    private WebElement shippingInformationLabel;

    @FindBy(xpath = "//div[@class='summary_info_label'][contains(.,'Price Total')]")
    private WebElement shippingPriceInfoLabel;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement totalLabel;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver); // Call the constructor of the BasePage class

        PageFactory.initElements(driver, this);
    }

    // ACTIONS
    public CheckoutOverviewPage verifyPaymentOverviewisDisplayed() {
        Assert.assertTrue(paymentInformationLabel.isDisplayed());
        Assert.assertTrue(shippingInformationLabel.isDisplayed());
        Assert.assertTrue(shippingPriceInfoLabel.isDisplayed());
        Assert.assertTrue(totalLabel.isDisplayed());
        return this;
    }



    public CheckoutOverviewPage clickFinishButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(finishButton).pause(1000).click().perform(); // Add a pause of 1000 milliseconds (1 second)

        return this;

    }

}
