package com.epam.framework.pages.ui;

import com.epam.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
//
//    private final By usernameField = By.id("user-name");
//    private final By passwordField = By.id("password");
//    private final By loginButton = By.id("login-button");
//    private final By productsTitle = By.xpath("//span[text()='Products']");
//
//    public void login(String username, String password) {
//        driver.findElement(usernameField).sendKeys(username);
//        driver.findElement(passwordField).sendKeys(password);
//        driver.findElement(loginButton).click();
//    }
//
//    public boolean isLoginSuccessful() {
//        return !driver.findElements(productsTitle).isEmpty();
//    }
//
//    public void navigateToLogin() {
//        driver.get("https://www.saucedemo.com/");
//    }
//}
        private WebDriver driver;

        @FindBy(id="email")
        private WebElement emailField;

        @FindBy(id = "password")
        private WebElement passwordField;

        @FindBy(xpath = "//button[@type='submit' and contains(text(),'Login')] ")
        private WebElement loginButton;

        @FindBy(xpath= "//div[contains(@class, 'text-red-500')]")
        private WebElement errMsg;

        @FindBy(xpath="//div[@class='user-dropdown']//span[@class='user-name' and contains(text(), 'Hello')]")
        private WebElement userDropDown;

        @FindBy(xpath="//li[text()='Logout']")
        private WebElement logoutbtn;

        public LoginPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

        public void openLoginPage(String url) {
            driver.get(url);
        }

        public void enterEmail(String email){
            emailField.sendKeys(email);
        }

        public void enterPassword(String password){
            passwordField.sendKeys(password);
        }

        public void clickLogin(){
            loginButton.click();
        }

        public String getErrorMessage(){
            return errMsg.getText();
        }

        public void clickLogout(){
            userDropDown.click();
            logoutbtn.click();
        }

        public boolean isLogoutButtonDisplayed(){
            return logoutbtn.isDisplayed();
        }

        public boolean isLoginButtonDisplayed(){
            return loginButton.isDisplayed();
        }

    }

