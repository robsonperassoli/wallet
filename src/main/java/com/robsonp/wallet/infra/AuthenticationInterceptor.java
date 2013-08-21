package com.robsonp.wallet.infra;

import com.robsonp.wallet.domain.Usuario;
import com.robsonp.wallet.repository.UsuarioRepository;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

@Provider
@ServerInterceptor
public class AuthenticationInterceptor implements PreProcessInterceptor {

    @Inject
    private UsuarioRepository repository;
    
    @Inject
    private ApiData apiData;

    @Override
    public ServerResponse preProcess(HttpRequest request, ResourceMethod method) throws Failure, WebApplicationException {
        boolean isPublic = method.getMethod().isAnnotationPresent(Public.class);
        if (!isPublic) {
            return authenticate(request);
        } else {
            return null;
        }
    }
    
    private ServerResponse authenticate(HttpRequest request) {
        try {
            String apiKey = request.getHttpHeaders().getRequestHeader("apiKey").get(0);
            Usuario usuario = repository.findByApiKey(apiKey);
            apiData.setUsuario(usuario);
            
            return null;
        } catch (Exception e) {
            StringBuilder response = new StringBuilder("{");
            response.append("\"message\":\"" + "API KEY incorreta ou não informada." + "\"");
            response.append("}");

            return new ServerResponse(response.toString(),
                    Response.Status.UNAUTHORIZED.getStatusCode(), new Headers<Object>());
        }
    }

}
