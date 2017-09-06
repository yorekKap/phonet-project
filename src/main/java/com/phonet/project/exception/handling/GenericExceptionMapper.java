package com.phonet.project.exception.handling;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by yuri on 06.09.17.
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        int status = ExceptionUtils.getStatus(throwable);

        return Response.status(status)
                .entity(new ErrorMessage(status, throwable.getMessage()))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();

    }
}
