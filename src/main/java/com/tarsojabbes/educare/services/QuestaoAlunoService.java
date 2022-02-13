package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.QuestaoAluno;
import com.tarsojabbes.educare.repositories.QuestaoAlunoRepository;
import com.tarsojabbes.educare.repositories.QuestaoRepository;
import com.tarsojabbes.educare.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoAlunoService {

    @Autowired
    private QuestaoAlunoRepository questaoAlunoRepository;

    @Autowired
    private QuestaoRepository questaoRepository;

    public List<QuestaoAluno> findAllByAlunoId(Integer alunoId) {
        UserSS aluno = UserService.authenticated();

        if (aluno == null || !alunoId.equals(aluno.getId())) {
            return null;
        }

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

    public Integer check(Integer questaoId, String alternativa_correta, String alternativa, Integer alunoId) {
        if (alternativa_correta.equalsIgnoreCase(alternativa)) {
            QuestaoAluno questaoAluno = new QuestaoAluno(null, questaoId, alunoId, 1);
            insert(questaoAluno);
            return 1;
        }
        QuestaoAluno questaoAluno = new QuestaoAluno(null, questaoId, alunoId, 0);
        insert(questaoAluno);
        return 0;
    }
}
