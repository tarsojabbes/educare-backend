package com.tarsojabbes.educare.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aluno implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo nome é de preenchimento obrigatório")
    @Length(min = 3, max = 255, message = "O tamanho deve ser entre 3 e 255 caracteres")
    private String nome;

    @NotEmpty(message = "Campo email é de preenchimento obrigatório")
    @Email(message = "Email informado é inválido")
    private String email;

    @NotEmpty(message = "Campo senha é de preenchimento obrigatório")
    @Length(min=8, message = "O tamanho deve ser de, no mínimo, 8 caracteres")
    private String senha;

    @NotEmpty(message = "Campo curso é de preenchimento obrigatório")
    @Length(min=5, max = 255, message = "O tamanho deve ser entre 5 e 255 caracteres")
    private String curso;


    public Aluno(){}

    public Aluno(Integer id, String nome, String email, String senha, String curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
