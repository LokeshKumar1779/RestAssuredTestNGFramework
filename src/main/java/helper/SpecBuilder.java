package helper;

import config.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static constants.Route.*;

public class SpecBuilder extends Config {


    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(System.getProperty("BASE_URI")).
                setBasePath(BASE_PATH).
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).build();
    }

    public static ResponseSpecification responseSpec(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }

    public static RequestSpecification invalidTokenRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(System.getProperty("BASE_URI")).
                setBasePath(BASE_PATH).
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).build();
    }


    public static RequestSpecification getAccountRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(System.getProperty("BASE_URI_ACCOUNT")).
                setContentType(ContentType.URLENC).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).build();
    }
}
