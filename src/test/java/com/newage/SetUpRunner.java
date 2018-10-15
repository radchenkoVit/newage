package com.newage;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static ui.utils.RunReader.getBaseUri;

public class SetUpRunner {

    @BeforeSuite
    public void beforeAll() {
        RestAssured.baseURI = getBaseUri();
    }


    @AfterSuite
    public void afterAll() {
    }



}
