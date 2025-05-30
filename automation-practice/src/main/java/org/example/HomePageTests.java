package org.example;

import com.epam.framework.base.BaseTestWithLogin;
import com.epam.framework.pages.ui.CheckoutPage;
import com.epam.framework.pages.ui.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests extends BaseTestWithLogin {

    @Test
    public void checkFunctionality() {
        HomePage homePage = new HomePage();
        homePage.addAllProductsToCart();
        homePage.goToCart();

        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed(), "User is not on Checkout Page");
    }

    public static class DriverManager {
        private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

        public static void setDriver(String edgeDriverPath) {
            if (driverThread.get() == null) {
                System.setProperty("webdriver.edge.driver", edgeDriverPath);
                WebDriver driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                driverThread.set(driver);
            }
        }

        public static WebDriver getDriver() {
            return driverThread.get();
        }

        public static void quitDriver() {
            if (driverThread.get() != null) {
                driverThread.get().quit();
                driverThread.remove();
            }
        }
    }
}
