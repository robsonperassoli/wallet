package com.robsonp.wallet.service.movimentacao;

import com.robsonp.wallet.domain.Movimentacao;
import com.robsonp.wallet.util.Data;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class MovimentacaoDTO {

    private String id;
    private String descricao;
    private String data;
    private Double valor;
    private String tipo;

    public MovimentacaoDTO() {
    }
    
    public MovimentacaoDTO(Movimentacao movimentacao) {
        this.id = movimentacao.getId();
        this.descricao = movimentacao.getDescricao();
        this.data = Data.toString(movimentacao.getData());
        this.valor = movimentacao.getValor();
        this.tipo = movimentacao.getTipo().getAbraviacao();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public static List<MovimentacaoDTO> convert(List<Movimentacao> movimentacoes) {
        List<MovimentacaoDTO> dtos = new ArrayList<MovimentacaoDTO>();
        for (Movimentacao movimentacao : movimentacoes) {
            dtos.add(new MovimentacaoDTO(movimentacao));
        }
        return dtos;
    }
}
