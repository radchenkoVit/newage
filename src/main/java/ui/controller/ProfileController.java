package ui.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import ui.congif.ProfileServicePath;
import ui.request.SignUpRequest;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class ProfileController {

    public static String singUp(SignUpRequest signBody, String login, String password) {
        RequestSpecification requestSpecification = RestAssured.given()
                .log().all()
                .auth()
                .preemptive()
                .basic(login, password)
            .when()
                .header("Content-Type", "application/json")
                .queryParam("brandId", "redbox")
                .queryParam("send-mail", "false")
                .body(signBody);

    return requestSpecification.post(ProfileServicePath.SIGN_UP_POST)
            .then()
                .log().ifError().statusCode(200)
                .contentType(ContentType.JSON)
            .extract()
                .path("playerUUID");
    }

    public static String retrieveProfiles(String userUUID, String token) {
        Header jwtTokenHeader = new Header("Authorization", "Bearer " + token);

        return given()
                .header(jwtTokenHeader)
            .when()
                .get(format(ProfileServicePath.PROFILES_GET, userUUID))
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
            .extract()
                .body().as(String.class);
    }
}
