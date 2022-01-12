package com.tarsojabbes.educare.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class QuestaoAluno implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer questaoId;
    private Integer alunoId;

    public QuestaoAluno(){

    }

    public QuestaoAluno(Integer id, Integer questaoId, Integer alunoId) {
        this.id = id;
        this.questaoId = questaoId;
        this.alunoId = alunoId;
    }

    public Integer getquestaoId() {
        return questaoId;
    }

    public void setquestaoId(Integer questaoId) {
        this.questaoId = questaoId;
    }

    public Integer getalunoId() {
        return alunoId;
    }

    public void setalunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
