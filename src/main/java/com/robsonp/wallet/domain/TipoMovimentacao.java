package com.robsonp.wallet.domain;

public enum TipoMovimentacao {
    Receita("R"), Despesa("D");

    private final String abreviacao;

    private TipoMovimentacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }
    
    public String getAbraviacao() {
        return this.abreviacao;
    }
    
    public static TipoMovimentacao getFromAbraviacao(String abreviacao) {
        for (TipoMovimentacao tipo : TipoMovimentacao.values()) {
            if(tipo.getAbraviacao().equals(abreviacao))
                return tipo;
        }
        throw new RuntimeException("A abreviação informada não existe");
    }
}
