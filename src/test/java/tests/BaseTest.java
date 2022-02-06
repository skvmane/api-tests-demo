package tests;

import config.ConfigManager;
import config.Configuration;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static Configuration configuration;

    @BeforeMethod
    public void setupTests() {
        configuration = ConfigManager.getConfiguration();
        RestAssured.baseURI = configuration.baseURI();
        RestAssured.basePath = configuration.basePath();
        setLogLevel();
    }

    @AfterMethod
    public void resetSpecs() {
        RestAssured.reset();
    }

    private static void setLogLevel() {
        if (configuration.logAll()) {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
        } else {
            RestAssured.filters(new AllureRestAssured());
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }
    }
}
