package com.robsonp.wallet.service.usuario;

import com.robsonp.wallet.domain.Usuario;
import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class UsuarioDTO {
    private String email;
    private String senha;

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
