package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"
})
public interface Configuration extends Config {

    @DefaultValue("https://gorest.co.in")
    String baseURI();

    @DefaultValue("/public/v1")
    String basePath();

    @DefaultValue("258830d250ad6113393f56171c6eda027f687dda4abc213c0b51625634ba86db")
    String primaryToken();

    @DefaultValue("en")
    String fakerLocale();

    @DefaultValue("true")
    Boolean logAll();

    @DefaultValue("3")
    int maxRetryAttempts();
}