package com.newage;

import org.testng.annotations.Test;
import ui.controller.AuthServiceController;
import ui.controller.ProfileController;
import ui.request.SignInRequest;
import ui.request.SignUpRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ui.utils.StringGenerator.generateEmail;
import static ui.utils.StringGenerator.generateOnlyString;

public class RetrievePlayerProfileTest extends SetUpRunner {

    private SignUpRequest signUpRequest = SignUpRequest.builder()
            .email(generateEmail())
            .login(generateOnlyString(5))
            .build();

    private SignInRequest signInRequest = SignInRequest.of(signUpRequest);

    @Test
    public void validatePlayerProfileRetrieve() {
        String uuid = ProfileController.singUp(signUpRequest, login, password);
        String token = AuthServiceController.auth(signInRequest);

        String expectedJsonObject  = ProfileController.retrieveProfiles(uuid, token);

        assertThat(expectedJsonObject, not(null));
    }
}
