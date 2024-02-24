package pages;

//import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
//import io.qameta.allure.Step;

//import java.util.List;

public class InventoryPage extends BasePage {

    //ELEMENTS

    //page title
    @FindBy(xpath = "//span[@class='title']")
    private WebElement inventoryTitle;

    //the Add to cart button
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']")
    private WebElement removeButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartButton;

    // Constructor
    public InventoryPage(WebDriver driver) {

        super(driver); // Call the constructor of the BasePage class

        //Initialization of PageFactory: In the constructor, you should initialize the elements using PageFactory.initElements().
        //Make sure you pass the correct class (this), not InventoryPage.class.
        PageFactory.initElements(driver, this);
    }


    //ACTIONS

    // Open the inventory page
    // Log in to https://hq.qashier.com/#signin
    public InventoryPage openPage() {
        //implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(inventoryTitle)); // Wait for inventoryTitle to be visible (explicit wait)
        return this;


    }

    // Verify page title is displayed
    public InventoryPage verifyPageTitle() {
        Assert.assertTrue(inventoryTitle.isDisplayed(), "Inventory page title is not displayed");
        Assert.assertEquals(inventoryTitle.getText(), "Products", "Inventory title text is incorrect");
        return this;
    }

    // Verify add to cart button is displayed
    public InventoryPage verifyAddToCartButton() {
        Assert.assertTrue(addToCartButton.isDisplayed(), "Add to cart button is not displayed");
        return this;
    }

    // Click add to cart button
    public InventoryPage clickAddToCartButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).pause(1000).click().perform();

        return this;
    }

    public InventoryPage clickShoppingCartButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartButton).pause(1000).click().perform();

        return this;
    }

    // Verify remove button is displayed
    public InventoryPage verifyRemoveButton() {
        Assert.assertTrue(removeButton.isDisplayed(), "Remove button is not displayed");
        return this;
    }



   /* public InventoryPage isOnInventoryPage() {

        // Check if inventory title is displayed
        //WebElement titleElement = driver.findElement(inventoryTitle);
        //assertTrue(titleElement.isDisplayed());
        //assertEquals(titleElement.getText(), "Products");

        Assert.assertTrue(inventoryTitle.isDisplayed(), "Inventory title is not displayed");


        // Check if inventory items are displayed
        //List<WebElement> items = driver.findElements(inventoryItems);
        //for (WebElement item : items) {
        //    assertTrue(item.isDisplayed());
        //}

        return this;
    }*/


}