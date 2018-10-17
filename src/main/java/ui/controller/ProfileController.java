package ui.controller;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.awaitility.Awaitility;
import ui.congif.ProfileServicePath;
import ui.request.SignUpRequest;

import java.util.concurrent.TimeUnit;

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

    @Step("Validate calling retrieveProfiles ProfileService: /profile/profiles/{0} with token: {1} return status code 200")
    public static void validateRetrieveProfiles(String userUUID, String token) {
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> retrieveProfilesStatusCode(userUUID, token) == 200);
    }

    @Step("Calling retrieveProfiles ProfileService: /profile/profiles/{0} with token: {1}")
    public static int retrieveProfilesStatusCode(String userUUID, String token) {
        log.info(String.format("Calling retrieveProfiles with uuid: %s, token: %s", userUUID, token));
        Header jwtTokenHeader = new Header("Authorization", "Bearer " + token);

        return given()
                .header(jwtTokenHeader)
                .when()
                .get(format(ProfileServicePath.PROFILES_GET, userUUID))
                .then()
                .extract()
                .statusCode();
    }
}
