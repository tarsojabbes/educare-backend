package com.tarsojabbes.educare.repositories;

import com.tarsojabbes.educare.domains.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRespository extends JpaRepository<Aluno, Integer> {
}
