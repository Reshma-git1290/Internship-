package com.epam.campus.Authentication;

import com.epam.campus.RequestConfig;
import lombok.AllArgsConstructor;
import lombok.Data;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.NoArgsConstructor;

import static io.restassured.RestAssured.given;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Authenticate {


    private RequestConfig requestConfig;
    private LoginCredentials loginCredentials;


    public Response validAuthenticate(){
        RestAssured.baseURI= requestConfig.getBaseURL();
        RestAssured.basePath= requestConfig.getBasePath();

        return given()
                .contentType(requestConfig.getContentType())
                .body(loginCredentials)
                .when()
                .post("/authenticate")
                .then()
                .extract()
                .response();


    }


    public Response InvalidAuthentication(){
        RestAssured.baseURI= requestConfig.getBaseURL();
        RestAssured.basePath= requestConfig.getBasePath();


        return given()
                .contentType(requestConfig.getContentType())
                .body(loginCredentials)
                .when()
                .post("/authenticate")
                .then()
                .extract()
                .response();

    }

}