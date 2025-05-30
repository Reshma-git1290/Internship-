package com.epam.campus.Operations;

import com.epam.campus.BankAccount.CustomerCredentials;
import com.epam.campus.RequestConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationsManagement {

        private RequestConfig requestConfig;

        private String id;
        private String date;
        private String description;
        private int amount;
        private String operations;
        private CustomerCredentials bankAccount;
        private String authToken;
        private List<String> labels = new ArrayList<>(); // Add labels



    public Response viewOperation(){

        Response response=given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+authToken).
                when()
                .get("/operations/1").
                then()
                .extract().response();
        return response;


    }

    public Response createOperation(){

        Response response=given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+authToken)
                .body(this).
                when()
                .post("/operations").
                then()
                .extract().response();


        return response;

    }

}
