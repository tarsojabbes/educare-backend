package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.Aluno;
import com.tarsojabbes.educare.repositories.AlunoRepository;
import com.tarsojabbes.educare.security.AlunoSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AlunoDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Aluno aluno = alunoRepository.findByEmail(email);
        if (aluno == null) {
            throw new UsernameNotFoundException(email);
        }
        return new AlunoSS(aluno.getId(), aluno.getEmail(), aluno.getSenha());
    }
}
