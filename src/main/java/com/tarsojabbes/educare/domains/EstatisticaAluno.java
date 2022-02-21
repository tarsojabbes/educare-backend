package com.tarsojabbes.educare.domains;

import java.io.Serializable;

public class EstatisticaAluno implements Serializable {
    private static final long serialVersionUUID = 1L;

    private Integer idAluno;
    private Integer questoesResolvidas;
    private Integer acertos;
    private Double taxaAcerto;

    public EstatisticaAluno(){

    }

    public EstatisticaAluno(Integer idAluno, Integer questoesResolvidas, Integer acertos, Double taxaAcerto) {
        this.idAluno = idAluno;
        this.questoesResolvidas = questoesResolvidas;
        this.acertos = acertos;
        this.taxaAcerto = taxaAcerto;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getQuestoesResolvidas() {
        return questoesResolvidas;
    }

    public void setQuestoesResolvidas(Integer questoesResolvidas) {
        this.questoesResolvidas = questoesResolvidas;
    }

    public Integer getAcertos() {
        return acertos;
    }

    public void setAcertos(Integer acertos) {
        this.acertos = acertos;
    }

    public Double getTaxaAcerto() {
        return taxaAcerto;
    }

    public void setTaxaAcerto(Double taxaAcerto) {
        this.taxaAcerto = taxaAcerto;
    }
}
