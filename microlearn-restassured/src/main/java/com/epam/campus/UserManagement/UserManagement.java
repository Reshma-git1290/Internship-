
package com.epam.campus.UserManagement;

import com.epam.campus.RequestConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserManagement {
    private RequestConfig requestConfig;
    private User user;
    private String authToken;

    public Response createUser() {

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken)
                .body(user)
                .when()
                .post("/admin/users")
                .then()
                .extract().response();

//        System.out.println("Response Body: " + response.getBody().asString());  // DEBUGGING
        return response;
    }

    public Response updateUser() {

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken)
                .body(user)
                .when()
                .put("/admin/users/" + user.getLogin())
                .then()
                .extract().response();

//        System.out.println("Response Body: " + response.getBody().asString());
        return response;
    }
}
