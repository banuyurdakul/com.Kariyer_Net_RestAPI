package tests;

import io.restassured.path.json.JsonPath;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.SearchPojo;
import utils.PostReqResponse;
import java.util.LinkedHashMap;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class TC02 extends PostReqResponse {
    int size = 5;
    SearchPojo reqbody = new SearchPojo(size, 1, "ios developer", true);


    @Description("Size parameter test with items returned")
    @Test
    public void tc01() {
         generateResponse(reqbody).then().assertThat().
                 statusCode(200).
                 contentType("application/json")
                 .body("statusCode", equalTo("Success"),
                         "status", equalTo("Success"));


        JsonPath responseJP = generateResponse(reqbody).jsonPath();
        List<LinkedHashMap> itemsList = responseJP.get("data.jobs.items");

        Assert.assertEquals(itemsList.size(),size,"Number of Job Posts Do Not Match");


    }
}
