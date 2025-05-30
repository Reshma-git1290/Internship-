package com.epam.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private By signInButton=By.xpath("//a[@id=\"login\"]/span");
    private By accountButton=By.xpath("//a[@id=\"account-menu\"]/span/span");

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void goToLoginPage(){
        driver.findElement(accountButton).click();
        driver.findElement(signInButton).click();
    }
}