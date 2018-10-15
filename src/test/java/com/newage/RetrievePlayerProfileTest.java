package com.newage;

import org.testng.annotations.Test;
import ui.controller.AuthServiceController;
import ui.controller.ProfileController;
import ui.response.ProfileServicesResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class RetrievePlayerProfileTest extends SetUpRunner {

    @Test
    public void test() {
        String uuid = ProfileController.singUp();
        String token = AuthServiceController.auth(uuid);
        ProfileServicesResponse expectedJsonObject  = ProfileController.retrieveProfiles(uuid, token);

        assertThat(expectedJsonObject, not(null));
    }
}
