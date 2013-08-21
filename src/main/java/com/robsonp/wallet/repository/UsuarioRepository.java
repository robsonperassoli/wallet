package com.robsonp.wallet.repository;

import com.robsonp.wallet.domain.Usuario;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class UsuarioRepository extends GenericRepository<Usuario, String>{

    public Usuario findByApiKey(String apiKey) {
        Query query = new Query(Criteria.where("apiKey").is(apiKey));
        return getMongoOperations().findOne(query, Usuario.class);
    }

    public String getApiKey(String email, String senha) {
        Query query = new Query(Criteria.where("email").is(email))
                .addCriteria(Criteria.where("senha").is(senha));
        Usuario usuario = getMongoOperations().findOne(query, Usuario.class);
        return usuario.getApiKey();
    }
    
}
