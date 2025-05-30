package com.epam.campus;

import com.epam.campus.Authentication.*;
import com.epam.campus.BankAccount.CustomerCredentials;
import com.epam.campus.Operations.OperationsManagement;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OperationsManagementTests {


    private RequestConfig requestConfig;
    private OperationsManagement operationsManagement;
    private String apiToken; // Store authentication token


    @BeforeTest
    public void authenticateBeforeTest() {
        // Initialize required objects
        requestConfig = new RequestConfig();
        Authenticate authenticate = new Authenticate(requestConfig, new LoginCredentials("admin", "admin", false));

        // Perform authentication and store the token
        Response authResponse = authenticate.validAuthenticate();
        assertEquals(authResponse.statusCode(), 200, "Authentication failed");

        // Extract the token from response
        apiToken = authResponse.jsonPath().getString("id_token");

        // Initialize Accounts with resource
        operationsManagement = new OperationsManagement();
        operationsManagement.setRequestConfig(requestConfig);
        operationsManagement.setAuthToken(apiToken);
    }


    @Test
    public void testViewOperation(){

        Assert.assertEquals(operationsManagement.viewOperation().statusCode(),200);
    }

    @Test
    public void createOperation(){
        CustomerCredentials customerCredentials=new CustomerCredentials();
        customerCredentials.setId("10");
        customerCredentials.setName("sudden pillow");
        customerCredentials.setBalance((int) 8280.18);

        operationsManagement.setDate("2025-02-25T11:46:00.000Z");
        operationsManagement.setDescription("hello");
        operationsManagement.setAmount(63754);
//        operationsManagement.setId("1");



//        System.out.println("Request Payload: " + new Gson().toJson(operationsManagement));

        Assert.assertEquals(operationsManagement.createOperation().statusCode(),201,"Status code is 400(Bad request)");
    }

}
