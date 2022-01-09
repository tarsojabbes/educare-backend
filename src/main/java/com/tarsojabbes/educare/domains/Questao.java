package com.tarsojabbes.educare.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Questao implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String banca;
    private String enunciado;
    private String alternativa_a;
    private String alternativa_b;
    private String alternativa_c;
    private String alternativa_d;
    private String alternativa_e;

    public Questao() {
    }

    public Questao(Integer id, String banca, String enunciado, String alternativa_a, String alternativa_b, String alternativa_c, String alternativa_d, String alternativa_e) {
        this.id = id;
        this.banca = banca;
        this.enunciado = enunciado;
        this.alternativa_a = alternativa_a;
        this.alternativa_b = alternativa_b;
        this.alternativa_c = alternativa_c;
        this.alternativa_d = alternativa_d;
        this.alternativa_e = alternativa_e;
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
}
