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


public class TC04 extends PostReqResponse {
    SearchPojo reqBody = new SearchPojo(5, 1, "qa engineer", true);

    @Description("Apllied Jobs Should Not Be Listed")
    @Test
    public void test01() {
        generateResponse(reqBody).then().assertThat().
                statusCode(200).
                contentType("application/json")
                .body("statusCode", equalTo("Success"),
                        "status", equalTo("Success"));

        JsonPath responseJP = generateResponse(reqBody).jsonPath();
        List<LinkedHashMap> itemsList = responseJP.get("data.jobs.items");

        for (int i = 0; i < itemsList.size(); i++) {
            Assert.assertEquals(itemsList.get(i).get("appliedDetail"), "true", "Application Detail Error");
        }

    }
}
