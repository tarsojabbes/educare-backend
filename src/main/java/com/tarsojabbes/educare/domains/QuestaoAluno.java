package com.tarsojabbes.educare.domains;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
public class QuestaoAluno implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo questaoId é de preenchimento obrigatório")
    private Integer questaoId;
    @NotEmpty(message = "Campo alunoId é de preenchimento obrigatório")
    private Integer alunoId;
    private Integer acerto;

    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private String createdAt;


    public QuestaoAluno(){

    }

    public QuestaoAluno(Integer id, Integer questaoId, Integer alunoId, Integer acerto, String createdAt) {
        this.id = id;
        this.questaoId = questaoId;
        this.alunoId = alunoId;
        this.acerto = acerto;
        this.createdAt = createdAt;
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

    public Integer getAcerto() {
        return acerto;
    }

    public void setAcerto(Integer acerto) {
        this.acerto = acerto;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
