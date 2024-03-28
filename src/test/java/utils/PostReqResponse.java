package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.SearchPojo;

import static io.restassured.RestAssured.given;

public class PostReqResponse extends Endpoint {

    public static Response generateResponse(SearchPojo requestedBody) {
        return given().spec(spec).contentType(ContentType.JSON).when().body(requestedBody).post("{pp1}");
    }
}
