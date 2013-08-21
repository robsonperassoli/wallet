package com.robsonp.wallet.infra;

import com.robsonp.wallet.domain.Usuario;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ApiData {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
