package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import payloads.SearchPojo;
import utils.PostReqResponse;

import static org.hamcrest.Matchers.equalTo;

public class TC01 extends PostReqResponse {
    SearchPojo reqbody = new SearchPojo(10,1,"ios developer",true);

    @Description("Basic http response")
    @Test
    public void  test01(){

        generateResponse(reqbody).then().assertThat().
                statusCode(200).
                contentType("application/json")
                .body("statusCode", equalTo("Success"),
                        "status", equalTo("Success"));

    }





}
