package com.epam.framework.api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static com.epam.framework.config.ConfigurationReader.getProperty;

public class BaseApi {
    @BeforeClass
    public void setupApi() {
        RestAssured.baseURI = getProperty("api.base.url");
    }

}
