package applicationApi;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Playlist;

import java.util.HashMap;

import static constants.Route.API_TOKEN;
import static helper.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    @Step
    public static Response post(String path , String token, Object playlist){

        return given().
                spec(requestSpec()).
                body(playlist).
                //header("Authorization","Bearer "+token).
                auth().oauth2(token).
                when().
                post(path).
                then().
                spec(responseSpec()).extract().response();
    }

    @Step
    public static Response get(String path , String token){

        return given().
                spec(requestSpec()).
                //header("Authorization","Bearer "+token).
                auth().oauth2(token).
                when().
                get(path).
                then().
                spec(responseSpec()).extract().response();
    }

    @Step
    public static Response update(String path ,String token, Object playlist){

        return given().
                spec(requestSpec()).
                //header("Authorization","Bearer "+token).
                auth().oauth2(token).
                body(playlist).
                when().
                put(path).
                then().
                spec(responseSpec()).extract().response();
    }

    @Step
    public static Response postAccount(HashMap<String,String> form_params){
        return given(getAccountRequestSpec()).
                formParams(form_params).
                when().
                post(API_TOKEN).
                then().
                spec(responseSpec()).
                extract().response();
    }

}
