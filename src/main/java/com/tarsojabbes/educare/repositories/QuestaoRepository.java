package com.tarsojabbes.educare.repositories;

import com.tarsojabbes.educare.domains.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {
}
