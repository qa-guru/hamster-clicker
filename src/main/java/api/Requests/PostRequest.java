package api.Requests;

import api.specs.RequestSpecs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
    private final String token;

    public PostRequest(String token) {
        this.token = token;
    }

    public Response makePostRequest(String endpoint, String body, boolean enableLogging) {
        RequestSpecification requestSpec = RestAssured.given(RequestSpecs.requestSpecs).header("Authorization", "Bearer " + token)
                .body(body);

        if (enableLogging) {
            return requestSpec.post(endpoint).then().log().status().log().body().extract().response();
        } else {
            return requestSpec.post(endpoint).then().extract().response();
        }
    }
}
