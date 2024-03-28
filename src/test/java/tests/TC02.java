package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import payloads.SearchPojo;
import utils.ConfigReader;
import utils.Endpoint;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC02 extends Endpoint {
    int size = 5;
    SearchPojo reqbody = new SearchPojo(size, 1, "ios developer", true);
    Response response;


    @Test
    public void tc01() {

        Endpoint.spec.pathParam("pp1", ConfigReader.getProperty("param1"));
        response = given().spec(spec).contentType(ContentType.JSON).when().body(reqbody).post("{pp1}");
        //response.prettyPrint();

        JsonPath responseJP = response.jsonPath();

        List<String> arrL = new ArrayList<>();

         arrL =  responseJP.get("data.jobs.items");
        // System.out.println(arrL);

        response.then().assertThat().
                statusCode(200).
                contentType("application/json")
                .body("statusCode", equalTo("Success"),
                        "status", equalTo("Success"));

        Assert.assertEquals(arrL.size(),size,"Number of Job Posts Do Not Match");


    }
}
