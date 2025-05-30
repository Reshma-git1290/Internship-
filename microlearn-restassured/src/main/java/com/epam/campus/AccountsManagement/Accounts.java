package com.epam.campus.AccountsManagement;

import com.epam.campus.RequestConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
    private RequestConfig requestConfig;
    private UserCredentials userCredentials;

    public Response registerValidUser(){
        Response response=given()
                .contentType(ContentType.JSON)
                .body(userCredentials).
                when()
                .post("/register").
                then()
                .extract().response();
        return response;

    }
    public Response changePassword(String apiToken){
        String userPayload= """
                    {
                        "currentPassword": "admin",
                        "newPassword": "admin"
                    }
                    """;

        Response response=given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+apiToken)
                .body(userPayload).
                when()
                .post("account/change-password").
                then()
                .extract().response();
        return response;


    }



}


