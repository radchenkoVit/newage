package ui.controller;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import ui.congif.ProfileServicePath;
import ui.request.SignUpRequest;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

@Slf4j
public class ProfileController {

    @Step("Calling singUp ProfileService: /profile/public/signup with body: {0}, login: {1}, pass: {2}")
    public static String singUp(SignUpRequest signBody, String login, String password) {
        log.info(String.format("SignUp with body: %s, login: %s, pass: %s", signBody, login, password));
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

    @Step("Calling retrieveProfiles ProfileService: /profiles/{0} with token: {1}")
    public static String retrieveProfiles(String userUUID, String token) {
        log.info(String.format("Calling retrieveProfiles with uuid: %s, token: %s", userUUID, token));
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
