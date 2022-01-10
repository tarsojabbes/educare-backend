package com.tarsojabbes.educare.repositories;

import com.tarsojabbes.educare.domains.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaRepository extends JpaRepository<Questao, Integer> {
}
