package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.EstatisticaQuestao;
import com.tarsojabbes.educare.domains.Questao;
import com.tarsojabbes.educare.domains.QuestaoAluno;
import com.tarsojabbes.educare.repositories.QuestaoAlunoRepository;
import com.tarsojabbes.educare.repositories.QuestaoRepository;
import com.tarsojabbes.educare.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public Integer check(Integer questaoId, String alternativa, Integer alunoId) {

        Questao questao = questaoRepository.findAllById(questaoId);
        String alternativa_correta = questao.getAlternativa_correta();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = format.format(new Date());

        if (alternativa_correta.equalsIgnoreCase(alternativa)) {

            QuestaoAluno questaoAluno = new QuestaoAluno(null, questaoId, alunoId, 1, date);
            insert(questaoAluno);
            return 1;
        }
        QuestaoAluno questaoAluno = new QuestaoAluno(null, questaoId, alunoId, 0, date);
        insert(questaoAluno);
        return 0;
    }

    public EstatisticaQuestao estatisticas(Integer id){
        List<QuestaoAluno> questoesObj = questaoAlunoRepository.findAllByQuestaoId(id);

        int submissoes = questoesObj.toArray().length;

        if (submissoes == 0){
            return new EstatisticaQuestao(id, 0, 0, 0, 0.0);
        }

        int acertos = 0;
        int erros = 0;

        for (QuestaoAluno questaoAluno : questoesObj){
            if (questaoAluno.getAcerto() == 1){
                acertos++;
            } else if (questaoAluno.getAcerto() == 0){
                erros++;
            }
        }

        Double taxaAcerto = (double) ((acertos / submissoes)*100);

        return new EstatisticaQuestao(id, submissoes, acertos, erros, taxaAcerto);

    }

}
