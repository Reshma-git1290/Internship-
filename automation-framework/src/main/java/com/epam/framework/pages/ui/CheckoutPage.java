package com.epam.framework.pages.ui;

import com.epam.framework.base.BasePage;
import com.epam.framework.pages.ui.model.CustomerInformation;
import org.openqa.selenium.By;

import static com.epam.framework.utils.WaitUtils.*;

public class CheckoutPage extends BasePage {

    private final By checkoutTitle = By.xpath("//span[text()='Your Cart']");
    private final By checkoutButton = By.id("checkout");
    private final By checkoutPage = By.xpath("//span[text()=\"Checkout: Your Information\"]");
    private final By firstName=By.id("first-name");
    private final By lastName=By.id("last-name");
    private final By postalCode=By.id("postal-code");

    private final By continueButton=By.id("continue");
    private final By checkoutOverview=By.xpath("//span[text()=\"Checkout: Overview\"]");

    private final By finishButton=By.id("finish");
    private final By successMessage=By.xpath("//h2[text()=\"Thank you for your order!\"]");


    public boolean isCheckoutPageDisplayed() {
        return getVisibleElement(driver, checkoutTitle, 10).isDisplayed();
    }

    public void proceedToCheckout() {
        clickWhenReady(driver, checkoutButton, 10);
    }

    public void enterAddressAndContinueToCheckout(CustomerInformation customerInformation){
        getVisibleElement(driver,firstName,10).sendKeys(customerInformation.getFirstName());
        getVisibleElement(driver,lastName,10).sendKeys(customerInformation.getLastName());
        getVisibleElement(driver,postalCode,10).sendKeys(customerInformation.getPostalCode());

        getVisibleElement(driver,continueButton,10).click();

    }
    public boolean isCheckoutOverviewDisplayed(){
        return getVisibleElement(driver,checkoutOverview,10).isDisplayed();

    }

    public void finishCheckout(){
        getVisibleElement(driver,finishButton,10).click();

    }
    public boolean isUserOnCheckoutPage() {
        return getVisibleElement(driver, checkoutPage, 10).isDisplayed();
    }
    public boolean isCheckoutSuccess(){
        return getVisibleElement(driver,successMessage,10).isDisplayed();
    }
}
