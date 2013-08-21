package com.robsonp.wallet.service.movimentacao;

import com.robsonp.wallet.domain.Movimentacao;
import com.robsonp.wallet.domain.TipoMovimentacao;
import com.robsonp.wallet.infra.ApiData;
import com.robsonp.wallet.repository.MovimentacaoRepository;
import com.robsonp.wallet.util.Data;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/movimentacao")
public class MovimentacaoResource {
    
    @Inject
    private MovimentacaoRepository repository;
    
    @Inject
    private ApiData apiData;
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void salvar(MovimentacaoDTO dto){
        Movimentacao movimentacao = new Movimentacao(
                dto.getId(), 
                dto.getDescricao(), 
                Data.fromString(dto.getData()), 
                dto.getValor(), 
                TipoMovimentacao.getFromAbraviacao(dto.getTipo()), 
                apiData.getUsuario());
        repository.save(movimentacao);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MovimentacaoDTO carregar(String id){
        return new MovimentacaoDTO(repository.findById(id));
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MovimentacaoDTO> listar(){
        List<Movimentacao> movimentacoes = repository.findByUsuario(apiData.getUsuario());
        return MovimentacaoDTO.convert(movimentacoes);
    }
    
    @GET
    @Path("/receitas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MovimentacaoDTO> listarReceitas(){
        List<Movimentacao> movimentacoes = repository.findByUsuario(apiData.getUsuario(), TipoMovimentacao.Receita);
        return MovimentacaoDTO.convert(movimentacoes);
    }
    
    @GET
    @Path("/despesas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MovimentacaoDTO> listarDespesas(){
        List<Movimentacao> movimentacoes = repository.findByUsuario(apiData.getUsuario(), TipoMovimentacao.Despesa);
        return MovimentacaoDTO.convert(movimentacoes);
    }
}
