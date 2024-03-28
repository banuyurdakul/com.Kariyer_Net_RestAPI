package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class Endpoint {

    public static RequestSpecification spec;

    @BeforeClass
    public void setUP() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();
        spec.pathParams("pp1","search");
    }
}
