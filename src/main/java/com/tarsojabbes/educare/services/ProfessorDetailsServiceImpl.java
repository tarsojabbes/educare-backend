package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.Professor;
import com.tarsojabbes.educare.repositories.ProfessorRepository;
import com.tarsojabbes.educare.security.ProfessorSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ProfessorDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Professor professor = professorRepository.findByEmail(email);

        if (professor == null){
            throw new UsernameNotFoundException(email);
        }

        return new ProfessorSS(professor.getId(), professor.getNome(), professor.getSenha());


    }
}
