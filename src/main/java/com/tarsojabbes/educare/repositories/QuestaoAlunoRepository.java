package com.tarsojabbes.educare.repositories;

import com.tarsojabbes.educare.domains.QuestaoAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuestaoAlunoRepository extends JpaRepository<QuestaoAluno, Integer> {

    @Transactional(readOnly = true)
    List<QuestaoAluno> findAllByAlunoId(Integer alunoId);

    @Transactional(readOnly = true)
    List<QuestaoAluno> findAllByQuestaoId(Integer questaId);
}
