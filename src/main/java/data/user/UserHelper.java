package data.user;

import model.user.User;
import specs.InitialStateSpec;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.when;

public class UserHelper {
    private UserHelper() {
    }

    public static List<User> getExistingUsers() {
        InitialStateSpec.set();
        List<User> users = when()
                .get("/users")
                .then()
                .extract()
                .body().jsonPath().getList("data", User.class);
        return users;
    }

    public static User getOneExistingUser() {
        List<User> users = getExistingUsers();
        return users.get(new Random().nextInt(users.size()));
    }

    public static Integer getRandomUserId() {
        return getOneExistingUser().getId();
    }
}
