package com.trendyol.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    protected static final Logger log = Logger.getLogger(BaseTest.class);
    static String environment = System.getProperty("ENV", "src/test/properties");

    @Before
    public void before() {
        RestAssured.baseURI = ReadProperties.baseUrl();
        RestAssured.basePath = "/";
        RestAssured.requestSpecification = new RequestSpecBuilder().build().accept(ContentType.JSON).contentType(ContentType.JSON);

        PropertyConfigurator.configure("properties/log4j.properties");
    }

    @After
    public void setupAfterTest() {
        RestAssured.reset();
    }
}