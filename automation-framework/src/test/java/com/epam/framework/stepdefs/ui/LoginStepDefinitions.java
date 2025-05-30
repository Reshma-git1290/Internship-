//package com.epam.framework.stepdefs.ui;
//
//import com.epam.framework.pages.ui.LoginPage;
//import io.cucumber.java.en.*;
//
//import org.testng.Assert;
//
//public class LoginStepDefinitions{
//    LoginPage loginPage = new LoginPage();
//
//    @Given("the user is on the login page")
//    public void the_user_is_on_the_login_page() {
//        loginPage.navigateToLogin();  // Make sure this method is defined in LoginPage
//    }
//
//    @When("the user logs in with username {string} and password {string}")
//    public void the_user_logs_in_with_username_and_password(String username, String password) {
//        loginPage.login(username, password);
//    }
//
//    @Then("the login should be {string}")
//    public void the_login_should_be(String status) {
//        boolean isLoginSuccessful = loginPage.isLoginSuccessful(); // This should return true/false
//        if(status.equalsIgnoreCase("fail")){
//            Assert.assertFalse(isLoginSuccessful);
//        }
//        else {
//            Assert.assertTrue(isLoginSuccessful);
//        }
//
//    }
//}
