package com.newage;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui.utils.PropertyReader;

import static ui.utils.RunReader.getBaseUri;

public class SetUpRunner {

    protected String login;
    protected String password;

    @BeforeSuite
    public void beforeAll() {
        RestAssured.baseURI = getBaseUri();
        login = PropertyReader.getProperty("login");
        password = PropertyReader.getProperty("password");
    }


    @AfterSuite
    public void afterAll() {
    }



}
