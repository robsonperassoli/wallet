package com.robsonp.wallet.repository;

import com.robsonp.wallet.domain.Movimentacao;
import com.robsonp.wallet.domain.TipoMovimentacao;
import com.robsonp.wallet.domain.Usuario;
import java.util.List;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MovimentacaoRepository extends GenericRepository<Movimentacao, String> {

    public List<Movimentacao> findByUsuario(Usuario usuario) {
        Query query = new Query(Criteria.where("usuario").is(usuario));
        return getMongoOperations().find(query, Movimentacao.class);
    }

    public List<Movimentacao> findByUsuario(Usuario usuario, TipoMovimentacao tipo) {
        Query query = new Query(Criteria.where("usuario").is(usuario))
                .addCriteria(Criteria.where("tipo").is(tipo));
        return getMongoOperations().find(query, Movimentacao.class);
    }
    
}
