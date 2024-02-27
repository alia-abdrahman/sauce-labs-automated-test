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

    @FindBy(xpath = "//img[@alt='Sauce Labs Onesie']")
    private WebElement onesieProductImg;

    @FindBy(xpath = "//div[@class='inventory_item_name '][contains(.,'Sauce Labs Onesie')]")
    private WebElement onesieProductName;

    @FindBy(xpath = "//div[contains(text(),'Rib snap infant onesie for the junior automation e')]")
    private WebElement onesieProductDesc;

    @FindBy(xpath = "//div[@class='inventory_item_price'][contains(.,'$7.99')]")
    private WebElement onesieProductPrice;

    @FindBy (xpath = "//span[@class='shopping_cart_badge']")
    private WebElement shoppingCartBadge;

    @FindBy (xpath = "//select[@class='product_sort_container']")
    private WebElement FilterToSort;

    @FindBy (xpath = "//option[@value='az']")
    private WebElement FilterToSortByAlphabeticalAscOrder;

    @FindBy (xpath = "//option[@value='za']")
    private WebElement FilterToSortByAlphabeticalDescOrder;

    @FindBy (xpath = "//option[@value='lohi']")
    private WebElement FilterToSortByPriceAscOrder;

    @FindBy (xpath = "//option[@value='hilo']")
    private WebElement FilterToSortByPriceDescOrder;

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

    public InventoryPage verifyOnesieProductisDisplayed() {
        Assert.assertTrue(onesieProductImg.isDisplayed(), "Onesie product image is not displayed");
        Assert.assertTrue(onesieProductName.isDisplayed(), "Onesie product name is not displayed");
        Assert.assertTrue(onesieProductDesc.isDisplayed(), "Onesie product description is not displayed");
        Assert.assertTrue(onesieProductPrice.isDisplayed(), "Onesie product price is not displayed");
        return this;

    }

    public InventoryPage verifyShoppingCartBadgeisDisplayed() {
        Assert.assertTrue(shoppingCartBadge.isDisplayed(), "Shopping cart badge is not displayed");
        return this;
    }

    public InventoryPage clickFilterToSortByAlphabeticalAscOrder() {

        // First, ensure the dropdown is visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(FilterToSort));

        // Click on the dropdown to expand it
        FilterToSort.click();

        // Wait for the option to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(FilterToSortByAlphabeticalAscOrder));

        // Click on the desired option
        FilterToSortByAlphabeticalAscOrder.click();

        return this;
    }

    public InventoryPage verifyProductIsSortedByAlphabeticalAscOrder() {
        Assert.assertTrue(FilterToSortByAlphabeticalAscOrder.isDisplayed(), "Product is not sorted by alphabetical ascending order");
        return this;
    }

    public InventoryPage clickFilterToSortByAlphabeticalDescOrder() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(FilterToSort));


        FilterToSort.click();


        wait.until(ExpectedConditions.elementToBeClickable(FilterToSortByAlphabeticalDescOrder));


        FilterToSortByAlphabeticalDescOrder.click();

        return this;
    }

    public InventoryPage verifyProductIsSortedByAlphabeticalDescOrder() {
        Assert.assertTrue(FilterToSortByAlphabeticalDescOrder.isDisplayed(), "Product is not sorted by alphabetical descending order");
        return this;
    }

    public InventoryPage clickFilterToSortByPriceAscOrder() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(FilterToSort));


        FilterToSort.click();


        wait.until(ExpectedConditions.elementToBeClickable(FilterToSortByPriceAscOrder));


        FilterToSortByPriceAscOrder.click();

        return this;
    }

    public InventoryPage verifyProductIsSortedByPriceAscOrder() {
        Assert.assertTrue(FilterToSortByPriceAscOrder.isDisplayed(), "Product is not sorted by price ascending order");
        return this;
    }

    public InventoryPage clickFilterToSortByPriceDescOrder() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(FilterToSort));


        FilterToSort.click();


        wait.until(ExpectedConditions.elementToBeClickable(FilterToSortByPriceDescOrder));


        FilterToSortByPriceDescOrder.click();

        return this;
    }

    public InventoryPage verifyProductIsSortedByPriceDescOrder() {
        Assert.assertTrue(FilterToSortByPriceDescOrder.isDisplayed(), "Product is not sorted by price descending order");
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