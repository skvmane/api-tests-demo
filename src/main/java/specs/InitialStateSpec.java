package specs;

import config.ConfigManager;
import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class InitialStateSpec {

    private InitialStateSpec() {
    }

    public static RequestSpecification set() {
        Configuration configuration = ConfigManager.getConfiguration();

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + configuration.primaryToken())
                .build();
    }



}
