package ui.controller;

import io.restassured.http.ContentType;
import ui.congif.AuthServicePath;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class AuthServiceController {

    public static String auth(String uuid) {
        return given()
                .auth()
                .none()
                .header("Content-Type",  ContentType.JSON)
            .when()
                .post(format(AuthServicePath.AUTH_SIGNIN, uuid))
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
            .extract()
                .path("token");
    }
}
