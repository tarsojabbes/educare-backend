package com.tarsojabbes.educare.domains;

import java.io.Serializable;

public class EstatisticaQuestao implements Serializable {
    private static final long serialVersionUUID = 1L;

    private Integer idQuestao;
    private Integer submissoes;
    private Integer acertos;
    private Integer erros;
    private Double taxaAcerto;

    public EstatisticaQuestao(){

    }

    public EstatisticaQuestao(Integer idQuestao, Integer submissoes, Integer acertos, Integer erros, Double taxaAcerto) {
        this.idQuestao = idQuestao;
        this.submissoes = submissoes;
        this.acertos = acertos;
        this.erros = erros;
        this.taxaAcerto = taxaAcerto;
    }


    public Integer getSubmissoes() {
        return submissoes;
    }

    public void setSubmissoes(Integer submissoes) {
        this.submissoes = submissoes;
    }

    public Integer getAcertos() {
        return acertos;
    }

    public void setAcertos(Integer acertos) {
        this.acertos = acertos;
    }

    public Integer getErros() {
        return erros;
    }

    public void setErros(Integer erros) {
        this.erros = erros;
    }

    public Double getTaxaAcerto() {
        return taxaAcerto;
    }

    public void setTaxaAcerto(Double taxaAcerto) {
        this.taxaAcerto = taxaAcerto;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }
}
