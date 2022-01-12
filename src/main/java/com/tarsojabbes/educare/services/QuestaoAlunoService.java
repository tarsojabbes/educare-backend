package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.QuestaoAluno;
import com.tarsojabbes.educare.repositories.QuestaoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuestaoAlunoService {

    @Autowired
    private QuestaoAlunoRepository questaoAlunoRepository;

    public List<QuestaoAluno> findAllByAlunoId(Integer alunoId) {
        List<QuestaoAluno> questaoAlunos = questaoAlunoRepository.findAllByAlunoId(alunoId);
        return questaoAlunos;
    }

    public QuestaoAluno insert(QuestaoAluno questaoAluno) {
        questaoAluno.setId(null);
        return questaoAlunoRepository.save(questaoAluno);
    }

    public void delete(Integer id) {
        findAllByAlunoId(id);
        try {
            questaoAlunoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Nao foi possivel excluir");
        }
    }
}
