package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import payloads.SearchPojo;
import utils.ConfigReader;
import utils.Endpoint;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC01 extends Endpoint {
    SearchPojo reqbody = new SearchPojo(10,1,"ios developer",true);
    Response response;

    @Test
    public void  tc01(){

        Endpoint.spec.pathParam("pp1", ConfigReader.getProperty("param1"));
        response = given().spec(spec).contentType(ContentType.JSON).when().body(reqbody).post("{pp1}");
        // response.prettyPrint();

        response.then().assertThat().
                statusCode(200).
                contentType("application/json")
                .body("statusCode", equalTo("Success"),
                        "status", equalTo("Success"));


    }





}
