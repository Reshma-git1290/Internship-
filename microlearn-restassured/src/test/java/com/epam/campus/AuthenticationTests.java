package com.epam.campus;

import com.epam.campus.Authentication.Authenticate;
import com.epam.campus.Authentication.LoginCredentials;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthenticationTests {
    RequestConfig requestConfig;
    Authenticate authenticate;

    @BeforeTest
    public void setAuthenticate(){
        requestConfig =new RequestConfig();
        authenticate=new Authenticate();
        authenticate.setRequestConfig(requestConfig);


    }
    @Test
    public void validAuthenticate(){


        authenticate.setLoginCredentials(new LoginCredentials("admin","admin",false));
        assertEquals(200,authenticate.validAuthenticate().statusCode());

    }


    @Test
    public void InvalidAuthentication(){
        authenticate.setLoginCredentials(new LoginCredentials("admin","Admin",false));
        assertEquals(401,authenticate.InvalidAuthentication().statusCode());

    }

}
