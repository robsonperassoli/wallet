package com.robsonp.wallet.domain;

import com.robsonp.wallet.util.UniqueSha256Hash;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {
    
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String email;
    private String senha;
    
    private String apiKey;

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
        
        if(email == null || email.isEmpty())
            throw new IllegalArgumentException("Para criar um usuário o e-mail não pode estar em branco");
        
        if(senha == null || senha.isEmpty())
            throw new IllegalArgumentException("Para criar um usuário a senha não pode estar em branco");
        
        gerarApiKey();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void gerarApiKey(){
        apiKey = new UniqueSha256Hash().toString();
    }
    
}
