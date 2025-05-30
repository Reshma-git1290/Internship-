package com.epam.campus;

import com.epam.campus.AccountsManagement.*;
import com.epam.campus.Authentication.*;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class AccountsManagementTests {

    private RequestConfig requestConfig;
    private Accounts accounts;
    private Authenticate authenticate;
    private String authToken; // Store authentication token

    @BeforeTest
    public void authenticateBeforeTest() {
        // Initialize required objects
        requestConfig = new RequestConfig();
        authenticate = new Authenticate(requestConfig, new LoginCredentials("admin", "admin", false));

        // Perform authentication and store the token
        Response authResponse = authenticate.validAuthenticate();
        assertEquals(authResponse.statusCode(), 200, "Authentication failed");

        // Extract the token from response
        authToken = authResponse.jsonPath().getString("id_token");

        // Initialize Accounts with resource
        accounts = new Accounts();
        accounts.setRequestConfig(requestConfig);
    }

    @Test
    public void registerValidUserTest() {
        accounts.setUserCredentials(new UserCredentials("resh", "resh@email.com", "resh12", "en"));
        assertEquals(accounts.registerValidUser().statusCode(),201);
    }

    @Test
    public void registerInValidUserTest() {
        accounts.setUserCredentials(new UserCredentials("resh", "reshmail.com", "resh12", "en"));
        assertEquals(accounts.registerValidUser().statusCode(),400);
    }

    @Test
    public void changePasswordTest() {
        assertEquals(accounts.changePassword(authToken).statusCode(),200);
    }
}