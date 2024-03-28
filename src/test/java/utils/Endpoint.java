package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;


public class Endpoint {

    public static RequestSpecification spec;


    @Before
    public void setUp() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();

    }


}
