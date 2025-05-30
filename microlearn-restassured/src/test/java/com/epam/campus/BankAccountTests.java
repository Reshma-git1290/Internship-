package com.epam.campus;

import com.epam.campus.Authentication.Authenticate;
import com.epam.campus.Authentication.LoginCredentials;
import com.epam.campus.BankAccount.BankAccountManagement;
import com.epam.campus.BankAccount.CustomerCredentials;
import com.epam.campus.BankAccount.User;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BankAccountTests {

    private RequestConfig requestConfig;
    private BankAccountManagement bankAccountManagement;
    private CustomerCredentials customerCredentials;
     // Store dynamic customer ID

    @BeforeTest
    public void authenticateBeforeTest() {
        // Initialize objects
        requestConfig = new RequestConfig();
        Authenticate authenticate = new Authenticate(requestConfig, new LoginCredentials("admin", "admin", false));

        // Perform authentication
        Response authResponse = authenticate.validAuthenticate();
        assertEquals(authResponse.statusCode(), 200, "Authentication failed");


        customerCredentials = new CustomerCredentials();

        // Store API token for tests
        bankAccountManagement = new BankAccountManagement();
        bankAccountManagement.setApiToken(authResponse.jsonPath().getString("id_token"));
        //customer credentials setup
        bankAccountManagement.setCustomerCredentials(customerCredentials);
        bankAccountManagement.setRequestConfig(requestConfig);


    }

    @Test
    public void testCreateValidAccount() {
        customerCredentials.setName("resh");
        customerCredentials.setBalance(6356);
        customerCredentials.setUser(new User("1","user"));
        bankAccountManagement.setCustomerCredentials(customerCredentials);

        Response response = bankAccountManagement.createBankAccount();
        assertEquals(response.statusCode(), 201);

    }

    @Test
    public void testCreateInValidAccount() {
        customerCredentials.setId("1020");
        customerCredentials.setName("resh");
        customerCredentials.setBalance(6356);
        customerCredentials.setUser(new User("1","user"));
        bankAccountManagement.setCustomerCredentials(customerCredentials);

        Response response = bankAccountManagement.createBankAccount();
        assertEquals(response.statusCode(), 400);

    }

    @Test
    public void testViewValidAccount() {
        assertEquals(bankAccountManagement.viewBankAccount("2").statusCode(), 200);
    }

    @Test
    public void testViewInvalidAccount() {
        assertEquals(bankAccountManagement.viewBankAccount("99999").statusCode(), 404);
    }

    @Test
    public void testUpdateAccount() {
        bankAccountManagement.setCustomerCredentials(new CustomerCredentials("2", "reshma", 54345, new User("1","admin")));
        assertEquals(bankAccountManagement.updateBankAccount("2").statusCode(), 200);
    }

    @Test
    public void testPartialUpdateAccount() {
        CustomerCredentials partialUpdate = new CustomerCredentials();
        partialUpdate.setId("2");
        partialUpdate.setBalance(89789);
        bankAccountManagement.setCustomerCredentials(partialUpdate);
        assertEquals(bankAccountManagement.partialUpdateAccount("2").statusCode(), 200);
    }

    @Test
    public void deleteValidAccount() {
        assertEquals(bankAccountManagement.deleteBankAccount("2").statusCode(), 204);
    }

    @Test
    public void deleteInvalidAccount() {
        assertEquals(bankAccountManagement.deleteBankAccount("99999").statusCode(), 204);
    }
}
