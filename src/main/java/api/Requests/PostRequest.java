package api.Requests;

import api.specs.RequesSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequest {
    private final String token;

    public PostRequest(String token) {
        this.token = token;
    }

    public Response makePostRequest(String endpoint, String body) {
        return RestAssured.given(RequesSpecs.requestSpecs).header("Authorization", "Bearer " + token)
                .body(body).post(endpoint).then().log().status().log().body().extract().response();

    }
}
