package api.tests;

import api.Requests.PostRequest;
import api.utils.ConfigLoader;
import api.utils.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class MakeTap {
    Utils utils = new Utils();
    ConfigLoader configLoader = new ConfigLoader();
    Integer earnPerTap = 11;
    PostRequest postRequest = new PostRequest(configLoader.getToken());


    @Test
    public void makeTap() {
        String body = "{\"count\": " + earnPerTap + ",\"availableTaps\":6000,\"timestamp\":" + utils.generateTimestamp() + "}";
        Response response = postRequest.makePostRequest("tap", body).then().extract().response();
    }

    @Test
    public void makeMoney() throws InterruptedException {
        int availableTaps = 6000;
        double balanceCoins = 0;

        String body = "{\"count\": " + earnPerTap + ", \"availableTaps\": " + availableTaps + ", \"timestamp\": " + utils.generateTimestamp() + "}";
        Response response = postRequest.makePostRequest("tap", body).then().extract().response();
        JsonPath jsonPath = response.jsonPath();

        availableTaps = jsonPath.getInt("clickerUser.availableTaps");
        balanceCoins = jsonPath.getDouble("clickerUser.balanceCoins");

        System.out.println("Available Taps: " + availableTaps);
        System.out.println("Balance Coins: " + balanceCoins);

        while (availableTaps > 0) {
            body = "{\"count\": " + earnPerTap + ", \"availableTaps\": " + availableTaps + ", \"timestamp\": " + utils.generateTimestamp() + "}";
            response = postRequest.makePostRequest("tap", body);
            jsonPath = response.jsonPath();

            availableTaps = jsonPath.getInt("clickerUser.availableTaps");
            balanceCoins = jsonPath.getDouble("clickerUser.balanceCoins");

            System.out.println("Available Taps: " + availableTaps);
            System.out.println("Balance Coins: " + balanceCoins);

            Thread.sleep(550);
        }
    }
}
