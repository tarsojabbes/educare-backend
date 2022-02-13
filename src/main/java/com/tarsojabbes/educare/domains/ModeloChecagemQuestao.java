package com.tarsojabbes.educare.domains;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ModeloChecagemQuestao implements Serializable {
    private static final long serialVersionUUID = 1L;

    @NotEmpty(message = "Campo questãoId é de preenchimento obrigatório")
    private Integer questaoId;
    @NotEmpty(message = "Campo alternativa é de preenchimento obrigatório")
    private String alternativa;
    @NotEmpty(message = "Campo alunoId é de preenchimento obrigatório")
    private Integer alunoId;

    public ModeloChecagemQuestao() {
    }

    public ModeloChecagemQuestao(Integer questaoId, String alternativa, Integer alunoId) {
        this.questaoId = questaoId;
        this.alternativa = alternativa;
        this.alunoId = alunoId;
    }

    public Integer getQuestaoId() {
        return questaoId;
    }

    public void setQuestao(Integer questaoId) {
        this.questaoId = questaoId;
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
