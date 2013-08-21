package com.robsonp.wallet.infra;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefautExceptionHandler implements ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception exception) {
        exception.printStackTrace();

        String message = getStackedMessage(exception);
        StringBuilder response = new StringBuilder();
        response.append("{\"message\":\"" + message + "\"}");

        return Response.serverError().entity(response.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    
    private String getStackedMessage(Exception exception) {
        String stackedMessage = "";
        Throwable throwable = exception;
        int count = 1;
        do {
            stackedMessage += count + " - " + throwable.getMessage() + "\n";
            throwable = throwable.getCause();
            count++;
        } while (throwable != null);
        return stackedMessage;
    }
    
}
