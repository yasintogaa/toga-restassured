package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;


public abstract class BaseTest {

    private final RequestSpecification rs = new RequestSpecBuilder()
            .setBaseUri("petstore.swagger.io/v2")
            .setContentType(ContentType.JSON)
            .build();


    public Response getRequest(String id) {
        return given(rs)
                .when()
                .get(id);
    }

    public Response postRequest(Object model) {
        return given(rs)
                .when()
                .body(model)
                .post();
    }

    public Response putRequest(Object model) {
        return given(rs)
                .when()
                .body(model)
                .put();
    }

    public Response deleteRequest(String id) {
        return given(rs)
                .when()
                .delete(id);
    }
}
