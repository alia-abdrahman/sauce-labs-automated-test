import org.testng.annotations.Test;
import pages.*;

public class SauceLabsAppTest extends BaseTest {
    private InventoryPage inventoryPage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckoutInfoPage checkoutInfoPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;


    // Test case for Sauce Labs Onesie purchase
    @Test
    public void TC01_purchase_onesie(){

        // Initialize InventoryPage
        inventoryPage = new InventoryPage(driver);

        // Initialize LoginPage
        loginPage = new LoginPage(driver);

        // Initialize CartPage
        cartPage = new CartPage(driver);

        checkoutInfoPage = new CheckoutInfoPage(driver);

        checkoutOverviewPage = new CheckoutOverviewPage(driver);

        checkoutCompletePage = new CheckoutCompletePage(driver);

        loginPage
                .openPage()
                .login("standard_user", "secret_sauce");

        inventoryPage
                .clickFilterToSortByAlphabeticalAscOrder()
                .verifyProductIsSortedByAlphabeticalAscOrder()
                .clickFilterToSortByAlphabeticalDescOrder()
                .verifyProductIsSortedByAlphabeticalDescOrder()
                .clickFilterToSortByPriceAscOrder()
                .verifyProductIsSortedByPriceAscOrder()
                .clickFilterToSortByPriceDescOrder()
                .verifyProductIsSortedByPriceDescOrder()
                .verifyOnesieProductisDisplayed()
                .clickAddToCartButton()
                .verifyShoppingCartBadgeisDisplayed()
                .clickShoppingCartButton();

        cartPage
                .verifyItemsAddedToCart()
                .clickCheckoutButton();

        checkoutInfoPage
                .enterFirstName("John")
                .enterLastName("Doe")
                .enterPostalCode("12345")
                .clickContinueButton();

        checkoutOverviewPage
                .verifyPaymentOverviewisDisplayed()
                .clickFinishButton();

        checkoutCompletePage
                .verifyCheckoutCompleteMessageisDisplayed()
                .clickBackToProductsButton();

    }


}



