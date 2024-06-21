package api.tests;

import api.Requests.PostRequest;
import api.utils.ConfigLoader;
import api.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class MakeTap {
    Utils utils = new Utils();
    ConfigLoader configLoader = new ConfigLoader();

    @Test
    public void makeTap() {
        RestAssured.baseURI = "https://api.hamsterkombat.io";
        String body = "{\"count\":20,\"availableTaps\":6000,\"timestamp\":" + utils.generateTimestamp() + "}";

        PostRequest postRequest = new PostRequest(configLoader.getToken());
        Response response = postRequest.makePostRequest("tap", body).then().extract().response();
        System.out.println("Response body: " + response.prettyPrint());
    }
}
