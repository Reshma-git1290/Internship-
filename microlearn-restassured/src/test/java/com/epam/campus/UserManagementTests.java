

package com.epam.campus;

import com.epam.campus.UserManagement.User;
import com.epam.campus.Authentication.Authenticate;
import com.epam.campus.Authentication.LoginCredentials;
import com.epam.campus.UserManagement.UserManagement;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class UserManagementTests {
    private RequestConfig requestConfig;
    private User user;
    UserManagement userManagement;

    @BeforeTest
    public void authenticateBeforeTest() {
        requestConfig = new RequestConfig();
        Authenticate authenticate = new Authenticate(requestConfig, new LoginCredentials("admin", "admin", false));

        Response authResponse = authenticate.validAuthenticate();
        assertEquals(authResponse.statusCode(), 200, "Authentication failed");



        user = new User();
        userManagement = new UserManagement();
        userManagement.setUser(user);
        userManagement.setRequestConfig(requestConfig);
        userManagement.setAuthToken(authResponse.jsonPath().getString("id_token"));
    }

    @Test
    public void createUser() {
        user.setLogin("reshma2345");
        user.setFirstName("Reshma");
        user.setLastName("Begum");
        user.setEmail("reshma2345@mail.com");
        user.setActivated(true);
        user.setLangKey("en");
        user.setAuthorities(Arrays.asList("ROLE_USER"));  // FIXED

        Response response = userManagement.createUser();

//        System.out.println("Create User Response: " + response.getBody().asString()); // DEBUGGING

        Assert.assertEquals(response.statusCode(), 201, "Expected status code 201 for user creation");
    }

    @Test
    public void updateUser() {
        user.setId("1015");
        user.setLogin("reshma2345");
        user.setFirstName("Resh");
        user.setLastName("Begum");
        user.setEmail("reshma2345@mail.com");
        user.setActivated(true);
        user.setLangKey("en");
        user.setAuthorities(Arrays.asList("ROLE_USER"));  // FIXED

        Response response = userManagement.updateUser();

//        System.out.println("Update User Response: " + response.getBody().asString()); // DEBUGGING

        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200 for updating user");
    }
}
