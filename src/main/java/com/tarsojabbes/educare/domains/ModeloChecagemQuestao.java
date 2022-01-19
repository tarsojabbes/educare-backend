package com.tarsojabbes.educare.domains;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ModeloChecagemQuestao implements Serializable {
    private static final long serialVersionUUID = 1L;

    @NotEmpty(message = "Campo questão é de preenchimento obrigatório")
    private Questao questao;
    @NotEmpty(message = "Campo alternativa é de preenchimento obrigatório")
    private String alternativa;
    @NotEmpty(message = "Campo alunoId é de preenchimento obrigatório")
    private Integer alunoId;

    public ModeloChecagemQuestao() {
    }

    public ModeloChecagemQuestao(Questao questao, String alternativa, Integer alunoId) {
        this.questao = questao;
        this.alternativa = alternativa;
        this.alunoId = alunoId;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }
}
