package com.newage;

import io.restassured.RestAssured;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui.utils.PropertyReader;

import static ui.utils.RunReader.getBaseUri;

@Slf4j
public class SetUpRunner {

    protected String login;
    protected String password;

    @BeforeSuite
    public void beforeAll() {
        RestAssured.baseURI = getBaseUri();
        login = PropertyReader.getProperty("login");
        password = PropertyReader.getProperty("password");
        log.info(String.format("Set up Base Env Uri: %s, login: %s, password: %s", getBaseUri(), login, password));
    }


    @AfterSuite
    public void afterAll() {
    }



}
