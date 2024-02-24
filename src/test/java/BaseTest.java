import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

        protected WebDriver driver;

        @BeforeMethod
        public void setUp() {
            // Initialize WebDriver

        driver = new ChromeDriver();
        }

        @AfterMethod
        public void tearDown() {

            // Add a delay before closing the WebDriver instance
            try {
                TimeUnit.SECONDS.sleep(5); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Close the WebDriver instance
            if (driver != null) {
                driver.quit();
            }
        }
    }