package com.tarsojabbes.educare.repositories;

import com.tarsojabbes.educare.domains.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
