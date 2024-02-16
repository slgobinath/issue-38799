package com.example.foo;

import io.quarkus.rest.data.panache.RestDataPanacheException;
import jakarta.annotation.Priority;
import jakarta.persistence.EntityExistsException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
// Enabling @Priority(1) works; Moving this class to com.example.config works
//@Priority(1)
public class RestDataPanacheExceptionMapper implements ExceptionMapper<RestDataPanacheException> {

    @Override
    public Response toResponse(RestDataPanacheException e) {
        if (e.getCause() instanceof EntityExistsException ex) {
            if (ex.getMessage() != null && ex.getMessage().contains("detached entity passed to persist")) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()).build();
    }

}
