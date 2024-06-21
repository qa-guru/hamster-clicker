package api.specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RequesSpecs {
    private static final String BASE_URI = "https://api.hamsterkombat.io";
    private static final String BASE_PATH = "/clicker/";

    public static RequestSpecification requestSpecs = with()
            .log().uri()
            .log().method()
            .contentType(JSON)
            .header("Connection", "keep-alive")
            .header("sec-ch-ua", "\"Chromium\";v=\"122\", \"Not(A:Brand\";v=\"24\", \"Android WebView\";v=\"122\"")
            .header("sec-ch-ua-mobile", "?1")
            .header("User-Agent", "Mozilla/5.0 (Linux; Android 11; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/122.0.6261.64 Mobile Safari/537.36")
            .header("sec-ch-ua-platform", "\"Android\"")
            .header("Accept", "*/*")
            .header("Origin", "https://hamsterkombat.io")
            .header("X-Requested-With", "org.telegram.messenger")
            .header("Sec-Fetch-Site", "same-site")
            .header("Sec-Fetch-Mode", "cors")
            .header("Sec-Fetch-Dest", "empty")
            .header("Referer", "https://hamsterkombat.io/")
            .baseUri(BASE_URI)
            .basePath(BASE_PATH);
}
