package com.trendyol.util;

import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ControlPage {

    private static final Logger logger = Logger.getLogger(ControlPage.class);
    private static long responseTimeout = 7000L;
    private String apiURL = "apiURLTest";

    public void apiStart(){
        System.out.println("apiURL:" + apiURL);
        logger.info("Servis Çalıştırılıyor");
        ValidatableResponse then = given()
                .log()
                .all()
                .and()
                .when()
                .get(apiURL).then();

        then
                .statusCode(200)
                .and()
                .time(lessThan(responseTimeout))
                .extract()
                .response()
                .prettyPrint();
    }

    public String authorTitleRequiredFields(String author, String title){
        ValidatableResponse then = given()
                .formParam("author", author)
                .formParam("title", title)
                .log()
                .all()
                .and()
                .when()
                .put(apiURL + "/api/books/").then();

        return
                then
                .statusCode(200)
                .and()
                .time(lessThan(responseTimeout))
                .extract()
                .response()
                .prettyPrint();
    }

    public void createId(String id){
        ValidatableResponse then = given()
                .formParam("id", id)
                .log()
                .all()
                .and()
                .when()
                .put(apiURL + "/api/books/").then();

        then
                .statusCode(200)
                .and()
                .time(lessThan(responseTimeout))
                .extract()
                .response()
                .prettyPrint();
    }

    public void getBook(String id){
        ValidatableResponse then = given().formParam("id", id)
                .log()
                .all()
                .and()
                .when()
                .get(apiURL + "/api/books/" + id + "/").then();

        then
                .statusCode(200)
                .and()
                .time(lessThan(responseTimeout))
                .extract()
                .response()
                .prettyPrint();
    }

    public String createDuplicateBook(String book){
        ValidatableResponse then = given()
                .formParam("book", book)
                .log()
                .all()
                .and()
                .when()
                .put(apiURL + "/api/books/").then();

        return
                then
                .statusCode(200)
                .and()
                .time(lessThan(responseTimeout))
                .extract()
                .response()
                .prettyPrint();
    }
}