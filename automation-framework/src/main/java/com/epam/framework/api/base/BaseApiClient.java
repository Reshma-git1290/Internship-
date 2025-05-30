package com.epam.framework.api.base;

import com.epam.framework.api.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseApiClient {

    protected Response get(String endpoint) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint);
    }

    protected Response post(String endpoint, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint);
    }

    protected Response put(String endpoint, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(endpoint);
    }

    protected Response delete(String endpoint) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .delete(endpoint);
    }
    public Response patch(User user) {
        return given()
                .contentType(ContentType.JSON)
                .pathParam("id", user.getId()) // ✅ only id in path
                .body(user)                    // ✅ full object in body
                .patch("/users/{id}");        // ✅ patch expects {id}
    }

}
