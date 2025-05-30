package com.epam.framework.api.client;

import com.epam.framework.api.base.BaseApiClient;
import io.restassured.response.Response;


public class UserClient extends BaseApiClient {

    public Response getUserById(String userId) {
        return get("api/users/" + userId);
    }

    public Response createUser(Object userPayload) {
        return post("api/users", userPayload);
    }


    public Response updateUser(String userId, Object updatedPayload) {
        return put("api/users/" + userId, updatedPayload);
    }

    public Response deleteUser(String userId) {
        return delete("api/users/" + userId);
    }
}
