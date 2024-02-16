package com.example;

import com.example.foo.Foo;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class FooResourceTest {

    @Test
    void testApi() {
        Foo foo = new Foo();
        foo.id = 1L;
        foo.name = "Foo";

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(foo)
                .when()
                .post("foo")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}