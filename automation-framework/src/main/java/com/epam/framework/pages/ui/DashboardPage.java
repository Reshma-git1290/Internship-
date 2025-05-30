package com.epam.framework.pages.ui;
import com.epam.framework.base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

        private By logoutButton = By.id("logout");

        public DashboardPage() {
            super();
        }

        public boolean isUserLoggedIn() {
            return driver.findElement(logoutButton).isDisplayed();
        }
    }