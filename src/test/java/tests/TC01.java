package tests;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;
import utils.TestPojo;

public class TC01 {

    @Test
    public void test01(){

       TestPojo reqBody = new TestPojo(0,10,1,"ios developer", true);

        RestAssured.given().body(reqBody);


        String statusCode = "Success";
        String status = "Success";
        int code = 200;


    }

}
