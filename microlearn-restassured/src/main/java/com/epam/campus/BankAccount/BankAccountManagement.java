package com.epam.campus.BankAccount;

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
public class BankAccountManagement {
    private String apiToken;
    private RequestConfig requestConfig;
    private CustomerCredentials customerCredentials;

    public Response createBankAccount(){

            return given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + apiToken)
                    .body(customerCredentials)
                    .when()
                    .post("/bank-accounts")
                    .then()
                    .extract().response();
        }

    public Response viewBankAccount(String customerId){
        Response response=given().
                contentType(ContentType.JSON).
                header("Authorization","Bearer "+apiToken).
                when().
                get("/bank-accounts/"+customerId).
                then().
                extract().response();

        return response;
    }


    public Response updateBankAccount(String customerId){
        Response response=given()
                .contentType(ContentType.JSON).
                header("Authorization","Bearer "+apiToken).
                body(customerCredentials).
                when()
                .put("/bank-accounts/"+customerId).
                then()
                .extract().response();

        return response;
    }


    public Response partialUpdateAccount(String customerId){

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + apiToken)
                        .body(customerCredentials)
                        .when()
                        .patch("/bank-accounts/"+customerId)
                        .then()
                        .extract()
                        .response();

        // Print response for debugging
     return response;

    }

public Response deleteBankAccount(String customerId) {

    Response response =
            given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + apiToken)
                    .body(customerCredentials)
                    .when()
                    .delete("/bank-accounts/"+customerId)
                    .then()
                    .extract()
                    .response();
    return response;

    }

}
