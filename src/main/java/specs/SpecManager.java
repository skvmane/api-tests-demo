package specs;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecManager {

    private SpecManager() {
    }

    public static void setRequestSpec(RequestSpecification request) {
        RestAssured.requestSpecification = request;
    }

    public static void setResponseSpec(ResponseSpecification response) {
        RestAssured.responseSpecification = response;
    }

    public static void clearSpecs() {
        RestAssured.requestSpecification = null;
        RestAssured.responseSpecification = null;
    }


}
