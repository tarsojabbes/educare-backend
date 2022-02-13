package com.tarsojabbes.educare.repositories;

import com.tarsojabbes.educare.domains.Questao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

    @Transactional(readOnly = true)
    Page<Questao> findByConteudo(String conteudo, Pageable pageable);

    @Transactional(readOnly = true)
    List<Questao> findByIdCriador(Integer id);

    @Transactional(readOnly = true)
    Questao findAllById(Integer id);
}
