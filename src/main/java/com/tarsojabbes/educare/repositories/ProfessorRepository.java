package com.tarsojabbes.educare.repositories;

import com.tarsojabbes.educare.domains.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Transactional(readOnly = true)
    Professor findByEmail(String email);
}
