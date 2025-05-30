package org.example;

import com.epam.framework.api.client.UserClient;
import com.epam.framework.api.models.User;
import com.epam.framework.api.base.BaseApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserApiTests extends BaseApi {

    UserClient userClient = new UserClient();

    @Test
    public void createUser() {
        // Build the user payload using the Builder pattern with fluent interface
        User user = User.builder()
                .id(101)  // Optional: can skip if auto-generated
                .firstName("Reshma")
                .lastName("Begum")
                .email("reshma.begum@epam.com")
                .avatar("https://reqres.in/img/faces/1-image.jpg")
                .build();

        Response response = userClient.createUser(user);
        assertEquals(response.getStatusCode(), 201); // Created
        System.out.println("Response: " + response.prettyPrint());
    }

    @Test
    public void testGetUserById() {
        Response response = userClient.getUserById("1");
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testPutUser() {
        User user = User.builder()
                .id(4)  // ID should match userId in URL
                .firstName("Reshma")
                .build();

        Response response = userClient.updateUser("1", user);

        // Log for debugging
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());

        assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void testDeleteUser() {
        Response response = userClient.deleteUser("1");
        assertEquals(response.getStatusCode(), 204);
    }
}