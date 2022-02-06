package data.user;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import model.user.User;

import java.util.Locale;

import static config.ConfigManager.getConfiguration;

@Log4j2
public class UserDataFactory {

    private final Faker faker;

    public UserDataFactory() {
        faker = new Faker(new Locale(getConfiguration().fakerLocale()));
    }

    public User createValidUser() {
        return newUser();
    }

    public User newUser() {
        User user = User.builder()
                .name(faker.name().firstName())
                .email(faker.internet().emailAddress())
                .gender(faker.demographic().sex().toLowerCase())
                .status(newStatus())
                .build();
        log.info(String.format("Created userdata: %n%s%n", user));
        return user;
    }

    private String newStatus() {
        int number = faker.number().numberBetween(0, 1);
        if (number == 0)
            return "inactive";
        else
            return "active";
    }


}
