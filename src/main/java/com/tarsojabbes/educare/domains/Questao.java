package com.tarsojabbes.educare.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity(name = "questoes")
public class Questao implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Campo banca é de preenchimento obrigatório")
    private String banca;
    @NotEmpty(message = "Campo conteúdo é de preenchimento obrigatório")
    private String conteudo;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Campo enunciado é de preenchimento obrigatório")
    private String enunciado;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Campo Alternativa A é de preenchimento obrigatório")
    private String alternativa_a;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Campo Alternativa B é de preenchimento obrigatório")
    private String alternativa_b;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Campo Alternativa C é de preenchimento obrigatório")
    private String alternativa_c;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Campo Alternativa D é de preenchimento obrigatório")
    private String alternativa_d;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Campo Alternativa E é de preenchimento obrigatório")
    private String alternativa_e;

    @NotEmpty(message = "Campo Alternativa Correta é de preenchimento obrigatório")
    private String alternativa_correta;

    private Integer idCriador;


    public Questao() {
    }

    public Questao(Integer id, String banca, String conteudo, String enunciado, String alternativa_a, String alternativa_b, String alternativa_c, String alternativa_d, String alternativa_e, String alternativa_correta, Integer idCriador) {
        this.id = id;
        this.banca = banca;
        this.conteudo = conteudo;
        this.enunciado = enunciado;
        this.alternativa_a = alternativa_a;
        this.alternativa_b = alternativa_b;
        this.alternativa_c = alternativa_c;
        this.alternativa_d = alternativa_d;
        this.alternativa_e = alternativa_e;
        this.alternativa_correta = alternativa_correta;
        this.idCriador = idCriador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBanca() {
        return banca;
    }

    public void setBanca(String banca) {
        this.banca = banca;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getAlternativa_a() {
        return alternativa_a;
    }

    public void setAlternativa_a(String alternativa_a) {
        this.alternativa_a = alternativa_a;
    }

    public String getAlternativa_b() {
        return alternativa_b;
    }

    public void setAlternativa_b(String alternativa_b) {
        this.alternativa_b = alternativa_b;
    }

    public String getAlternativa_c() {
        return alternativa_c;
    }

    public void setAlternativa_c(String alternativa_c) {
        this.alternativa_c = alternativa_c;
    }

    public String getAlternativa_d() {
        return alternativa_d;
    }

    public void setAlternativa_d(String alternativa_d) {
        this.alternativa_d = alternativa_d;
    }

    public String getAlternativa_e() {
        return alternativa_e;
    }

    public void setAlternativa_e(String alternativa_e) {
        this.alternativa_e = alternativa_e;
    }

    public String getAlternativa_correta(){return alternativa_correta;}

    public void setAlternativa_correta(String alternativa_correta){this.alternativa_correta = alternativa_correta;}

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Integer getIdCriador() {
        return idCriador;
    }

    public void setIdCriador(Integer idCriador) {
        this.idCriador = idCriador;
    }
}
