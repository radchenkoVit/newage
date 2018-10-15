package ui.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import ui.congif.ProfileServicePath;
import ui.response.ProfileServicesResponse;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class ProfileController {

    public static String singUp() {
        return RestAssured.given()
                .auth()
                .none()
            .when()
                .post(ProfileServicePath.SIGN_UP_POST)
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
            .extract()
                .path("playerUUID");
    }

    public static ProfileServicesResponse retrieveProfiles(String userUUID, String token) {
        Header jwtTokenHeader = new Header("Authorization", "Bearer " + token);

        return given()
                .header(jwtTokenHeader)
            .when()
                .get(format(ProfileServicePath.PROFILES_GET, userUUID))
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
            .extract()
                .body().as(ProfileServicesResponse.class);
    }
}
