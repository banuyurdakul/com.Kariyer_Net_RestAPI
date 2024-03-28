package tests;


import org.testng.annotations.Test;
import payloads.SearchPojo;
import utils.PostReqResponse;

import static org.hamcrest.Matchers.equalTo;

public class TC03 extends PostReqResponse {
    SearchPojo reqBody = new SearchPojo(-1,1,"qa engineer",true);

    @Test
    public void test01(){

       generateResponse(reqBody).prettyPrint();
       generateResponse(reqBody).then().assertThat().
                statusCode(400).
                contentType("application/json")
                .body("status", equalTo("Error"),
                        "message", equalTo("Size parametresi 0 ile 10000 arasında olmalıdır!"));

    }



}
