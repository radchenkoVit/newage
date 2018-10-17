package ui.controller;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import ui.congif.AuthServicePath;
import ui.request.SignInRequest;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

@Slf4j
public class AuthServiceController {

    @Step("Calling AuthService: /auth/signin with body: {0}")
    public static String auth(SignInRequest signIn) {
        log.info(format("Call to AuthService/sighin, body: %s", signIn));
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
