package com.tarsojabbes.educare.domains;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Credenciais implements Serializable {
    private static final long serialVersionUUID = 1L;

    @NotEmpty(message = "Campo email é de preenchimento obrigatório")
    @Email(message = "Email informado é inválido")
    private String email;

    @NotEmpty(message = "Campo senha é de preenchimento obrigatório")
    @Length(min=8, message = "O tamanho deve ser de, no mínimo, 8 caracteres")
    private String senha;

    public Credenciais() {
    }

    public Credenciais(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
