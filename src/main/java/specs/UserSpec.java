package specs;

import config.ConfigManager;
import config.Configuration;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import static org.hamcrest.Matchers.*;


public class UserSpec {
    public static Configuration configuration = ConfigManager.getConfiguration();

    private UserSpec() {
    }

    //Response specifications
    public static ResponseSpecification created() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .expectHeader("Location", startsWith(configuration.baseURI() + configuration.basePath()))
                .build();
    }

    public static ResponseSpecification requestedOrUpdated() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification deleted() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NO_CONTENT)
                .build();
    }

}
