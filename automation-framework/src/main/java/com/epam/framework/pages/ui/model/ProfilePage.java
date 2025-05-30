package com.epam.framework.pages.ui.model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ProfilePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[text()=\" Hello, john (Client) \"]")
    private WebElement userDropdown;

    @FindBy(xpath = "//ul[@class=\"dropdown-menu ng-star-inserted\"]/li[text()=\"Profile\"]")
    private WebElement profileMenuOption;

    @FindBy(xpath = "//div[@class=\"section-header\"]/h2[text()=\"Personal info\"]")
    private WebElement personalInfoHeader;

    @FindBy(xpath = "//button[@class=\"change-button\"]")
    private WebElement changeButton;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//div[@class=\"modal-container\"]//button[text()=\"Save changes\"]")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//button[text()=\"Cancel\"]")
    private WebElement cancelButton;

//        @FindBy(xpath = "//div[contains(@class, 'text-red-500')]")
//        private WebElement errorMessage;

//        @FindBy(xpath = "//div[contains(@class, 'text-green-500')]")
//        private WebElement successMessage;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToProfilePage() {
        userDropdown.click();
        profileMenuOption.click();
        System.out.println("profile page");
    }

    public boolean isProfileHeaderDisplayed() {
        return personalInfoHeader.isDisplayed();
    }

    public void clickPersonalInfo() {
        personalInfoHeader.click();
    }

    public void clickChange() {
        changeButton.click();
    }

    public void updatePhoneNumber(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickSaveChanges() {
        saveChangesButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public String getPhoneFieldValue() {
        return phoneInput.getAttribute("value");
    }

//        public String getErrorMessage() {
//            return errorMessage.getText();
//        }
//
//        public String getSuccessMessage() {
//            return successMessage.getText();
//        }
}
