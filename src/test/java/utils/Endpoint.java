package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;


public class Endpoint {

    public static RequestSpecification spec;

    @BeforeSuite
    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();
        spec.pathParams("pp1",ConfigReader.getProperty("param1"));

    }


}
