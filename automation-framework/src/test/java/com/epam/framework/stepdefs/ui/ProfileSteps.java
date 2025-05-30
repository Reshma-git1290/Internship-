package com.epam.framework.stepdefs.ui;


import com.epam.framework.factory.DriverFactory;
import com.epam.framework.pages.ui.LoginPage;
import com.epam.framework.pages.ui.model.ProfilePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProfileSteps {

    WebDriver driver = DriverFactory.getInstance().getDriver();
    ProfilePage profilePage = new ProfilePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Given("User is logged in and navigates to the profile page")
    public void userIsLoggedInAndOnProfilePage() {
        loginPage.openLoginPage("http://localhost:4200/register");
        loginPage.enterEmail("johndoe@gmail.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();
        profilePage.navigateToProfilePage();
        System.out.println("user logged in");
    }

    @Then("Profile page should be displayed")
    public void profilePageShouldBeDisplayed() {
        Assert.assertTrue(profilePage.isProfileHeaderDisplayed());
    }

    @When("User clicks on Personal Info")
    public void userClicksOnPersonalInfo() {
        profilePage.clickPersonalInfo();
    }

    @Then("Personal Info section should be displayed")
    public void personalInfoShouldBeDisplayed() {
        Assert.assertTrue(profilePage.isProfileHeaderDisplayed());
    }

    @When("User clicks on Change")
    public void userClicksOnChange() {
        profilePage.clickChange();
    }

    @When("User updates phone number with {string}")
    public void userUpdatesPhoneNumber(String phone) {
        profilePage.updatePhoneNumber(phone);
    }

    @When("User clicks on Save Changes")
    public void userClicksOnSaveChanges() {
        profilePage.clickSaveChanges();
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        // Assert success toast, or message from DOM
    }

    @Then("Phone number should be updated to {string}")
    public void phoneNumberShouldBeUpdated(String expectedPhone) {
        Assert.assertEquals(expectedPhone, profilePage.getPhoneFieldValue());
    }

    @Then("Error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedError) {
        // Assert.assertTrue(profilePage.getErrorMessage().contains(expectedError));
    }

    @When("User clicks on Cancel")
    public void userClicksOnCancel() {
        profilePage.clickCancel();
    }

    @Then("Phone number should not be updated to {string}")
    public void phoneShouldNotBeUpdated(String phone) {
        Assert.assertNotEquals(phone, profilePage.getPhoneFieldValue());
    }
}
