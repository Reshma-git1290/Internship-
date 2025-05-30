//package com.epam.framework.stepdefs.ui;
//
//import com.epam.framework.pages.ui.HomePage;
//import com.epam.framework.pages.ui.CheckoutPage;
//import io.cucumber.java.en.*;
//
//import static org.testng.Assert.*;
//
//public class CartSteps {
//    HomePage homePage = new HomePage();
//    CheckoutPage checkoutPage = new CheckoutPage();
//
//    @When("I add all products to the cart")
//    public void i_add_all_products_to_the_cart() {
//        homePage.addAllProductsToCart();
//    }
//
//    @And("I go to the cart page")
//    public void i_go_to_the_cart_page() {
//        homePage.goToCart();
//    }
//
//    @Then("I should see the checkout page")
//    public void i_should_see_the_checkout_page() {
//        assertTrue(checkoutPage.isCheckoutPageDisplayed(), "Checkout page is not displayed");
//    }
//
//    @Given("I have added all products to the cart")
//    public void i_have_added_all_products_to_the_cart() {
//        homePage.addAllProductsToCart();
//    }
//
//    @Given("I am on the cart page")
//    public void i_am_on_the_cart_page() {
//        homePage.goToCart();
//        assertTrue(checkoutPage.isCheckoutPageDisplayed());
//    }
//}
