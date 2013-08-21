package com.robsonp.wallet.service.usuario;

import com.robsonp.wallet.domain.Usuario;
import com.robsonp.wallet.infra.Public;
import com.robsonp.wallet.repository.UsuarioRepository;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuario")
public class UsuarioResource {
    
    @Inject
    private UsuarioRepository repository;
    
    @GET
    @Public
    @Path("/api-key")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String loadApiKey(UsuarioDTO dto){
        try {
            String apiKey = repository.getApiKey(dto.getEmail(), dto.getSenha());
            if(apiKey == null || apiKey.isEmpty())
                throw new RuntimeException("Não foi possível encontrar a api key. Dados incorretos.");
           
            return apiKey;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível encontrar a api key. Dados incorretos.", e);
        }
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void salvar(UsuarioDTO dto){
        Usuario novoUsuario = new Usuario(dto.getEmail(), dto.getSenha());
        repository.save(novoUsuario);
    }
        
    @GET
    @Path("/criar-padrao")
    public void criarUsuarioPadrao(){
        Usuario novoUsuario = new Usuario("admin@admin", "admin");
        repository.save(novoUsuario);
    }
        
}
