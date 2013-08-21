package com.robsonp.wallet.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movimentacao {
    
    @Id
    private String id;
    
    private String descricao;
    private Date data;
    private Double valor;
    private TipoMovimentacao tipo;
    
    @DBRef
    private Usuario usuario;

    public Movimentacao() {
    }

    public Movimentacao(String id, String descricao, Date data, Double valor, TipoMovimentacao tipo, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.usuario = usuario;
    }
    
    public Movimentacao(String descricao, Date data, Double valor, TipoMovimentacao tipo, Usuario usuario) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

}
