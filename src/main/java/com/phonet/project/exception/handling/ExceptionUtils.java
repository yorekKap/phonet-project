package com.phonet.project.exception.handling;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by yuri on 06.09.17.
 */
public class ExceptionUtils {

    public static int getStatus(Throwable throwable){
        if(throwable instanceof WebApplicationException) {
            return ((WebApplicationException)throwable).getResponse().getStatus();
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        }
    }
}
