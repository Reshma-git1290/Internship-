//package com.epam.framework.stepdefs.ui;
//
//import com.epam.framework.pages.ui.*;
//import com.epam.framework.pages.ui.model.CustomerInformation;
//import io.cucumber.java.en.*;
//import org.testng.Assert;
//
//public class CheckoutStepDefinitions {
//
//    LoginPage loginPage = new LoginPage();
//    HomePage homePage = new HomePage();
//    CheckoutPage checkoutPage = new CheckoutPage();
//
//    @Given("the user is logged in as {string}")
//    public void loginUser(String username) {
//        loginPage.navigateToLogin();
//        loginPage.login(username, "secret_sauce");
//        Assert.assertTrue(homePage.isHomePageDisplayed(), "Login failed for user: " + username);
//    }
//
//    @When("the user adds a product to the cart and proceeds to checkout")
//    public void checkoutSteps() {
//        homePage.addAllProductsToCart();
//        homePage.goToCart();
//        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed(), "Cart page not displayed.");
//        checkoutPage.proceedToCheckout();
//    }
//
//    @Then("the checkout page should be displayed")
//    public void verifyUserOnCheckoutPage() {
//        Assert.assertTrue(checkoutPage.isUserOnCheckoutPage(), "User is not on checkout page.");
//    }
//
//    @When("the user enters user information and clicks continue")
//    public void enterCustomerDetails() {
//        CustomerInformation info = new CustomerInformation("John", "Doe", "12345");
//        checkoutPage.enterAddressAndContinueToCheckout(info);
//    }
//
//    @Then("the checkout overview page should be displayed")
//    public void verifyUserOnCheckoutOverviewPage() {
//        Assert.assertTrue(checkoutPage.isCheckoutOverviewDisplayed(), "Checkout overview page not displayed.");
//    }
//
//    @When("the user clicks the finish button")
//    public void clickFinishButton() {
//        checkoutPage.finishCheckout();
//    }
//
//    @Then("the checkout success message should be displayed")
//    public void verifySuccessMessage() {
//        Assert.assertTrue(checkoutPage.isCheckoutSuccess(), "Success message not displayed.");
//    }
//
//    @Then("the checkout information page should be displayed")
//    public void verifyCheckoutInfoPage() {
//        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed(), "Checkout info page is not displayed.");
//    }
//}
