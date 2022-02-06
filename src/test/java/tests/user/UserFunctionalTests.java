package tests.user;

import data.user.UserHelper;
import model.user.User;
import org.testng.annotations.Test;
import specs.SpecManager;
import specs.UserSpec;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;

public class UserFunctionalTests extends UserBaseTest {

    @Test(testName = "Successfully create user using valid data")
    public void createUserSuccessfully() {
        User data = userDataFactory.createValidUser();
        SpecManager.setResponseSpec(UserSpec.created());

        User response = given()
                .body(data)
                .when()
                .post("/users")
                .then()
                .extract()
                .body().jsonPath().getObject("data", User.class);
        assertThat(response).isEqualTo(data);
    }

    @Test(testName = "Successfully get single user by valid id")
    public void getUserSuccessfully() {
        Integer userId = UserHelper.getRandomUserId();
        SpecManager.setResponseSpec(UserSpec.requestedOrUpdated());

        given()
                .pathParam("id", userId)
                .when()
                .get("d/users/{id}")
                .then()
                .rootPath("data")
                .body(
                        "id", is(userId),
                        ".name", notNullValue(),
                        "email", notNullValue(),
                        "gender", notNullValue(),
                        "status", notNullValue()
                );
    }

    @Test(testName = "Successfully update user with valid data")
    public void updateUserSuccessfully() {
        User dataToUpdate = UserHelper.getOneExistingUser();
        User updatedData = userDataFactory.createValidUser();
        SpecManager.setResponseSpec(UserSpec.requestedOrUpdated());

        User response = given()
                .pathParam("id", dataToUpdate.getId())
                .body(updatedData)
                .when()
                .put("/users/{id}")
                .then()
                .extract()
                .body().jsonPath().getObject("data", User.class);
        assertThat(response).isNotEqualTo(dataToUpdate)
                            .isEqualTo(updatedData);
    }

    @Test(testName = "Successfully delete user")
    public void deleteUserSuccessfully() {
        Integer userId = UserHelper.getRandomUserId();
        SpecManager.setResponseSpec(UserSpec.deleted());

        given()
                .pathParam("id", userId)
                .when()
                .delete("/users/{id}")
                .then();
    }

}
