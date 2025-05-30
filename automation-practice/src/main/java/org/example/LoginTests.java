package org.example;

import com.epam.framework.base.BaseTest;
import com.epam.framework.pages.ui.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @DataProvider(name = "userData")
    public Object[][] users() {
        return new Object[][] {
                {"standard_user", true},
                {"locked_out_user", false},
                {"problem_user", true},
                {"performance_glitch_user", true},
                {"error_user", true},
                {"visual_user", true}
        };
    }

    @Test(dataProvider = "userData")
    public void testLoginWithDifferentUsers(String username, boolean isLoginExpected) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, "secret_sauce");

        boolean loginSuccess = driver.findElements(By.xpath("//span[text()='Products']")).size() > 0;
        Assert.assertEquals(loginSuccess, isLoginExpected, "Login validation failed for: " + username);
    }

    @Test
    public void testStandardUserLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed(),
                "Standard user should be able to log in.");
    }
}
