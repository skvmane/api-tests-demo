package tests.user;

import data.user.UserHelper;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class UserContractTests extends UserBaseTest {

    @Test(testName = "Validation of user schema for GET method(single user)")
    public void getUser() {
        Integer userId = UserHelper.getRandomUserId();

        given()
                .pathParam("id", userId)
                .when()
                .get("/users/{id}")
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/usersGeneralResponseSchema.json"));
    }

    @Test(testName = "Validation of user schema for GET method(users list)")
    public void getUsers() {

        given()
                .when()
                .get("/users")
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/usersGetUsersListResponseSchema.json"));
    }

}
