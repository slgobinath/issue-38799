package com.example.foo;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@ResourceProperties(path = "/foo")
public interface FooResource extends PanacheEntityResource<Foo, Long> {
}
