package ui.controller;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import ui.congif.AuthServicePath;
import ui.request.SignInRequest;

import static io.restassured.RestAssured.given;

public class AuthServiceController {

    @Step("Calling AuthService: /auth/signin with body: {0}")
    public static String auth(SignInRequest signIn) {
        return given()
                .log().all()
                .header("Content-Type",  "application/json;charset=UTF-8")
            .when()
                .body(signIn)
                .post(AuthServicePath.AUTH_SIGNIN)
            .then()
                .log().ifError()
                .statusCode(200)
                .contentType(ContentType.JSON)
            .extract()
                .path("token");
    }
}
