package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.Professor;
import com.tarsojabbes.educare.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Professor> findAll(){
        List<Professor> professorList = professorRepository.findAll();
        return professorList;
    }

    public Optional<Professor> findById(Integer id){
        Optional<Professor> professor = professorRepository.findById(id);

        if (professor == null) {
            return null;
        }
        return professor;
    }

    public Professor insert(Professor professor){
        Professor doesProfessorAlreadyExists = professorRepository.findByEmail(professor.getEmail());
        if (doesProfessorAlreadyExists != null){
            return null;
        }
        Professor createdProfessor = new Professor(null, professor.getNome(), professor.getEmail(), bCryptPasswordEncoder.encode(professor.getSenha()));
        return professorRepository.save(createdProfessor);
    }

    public Optional<Professor> delete(Integer id){
        Optional<Professor> doesProfessorExists = findById(id);

        if (doesProfessorExists == null) {
            return null;
        }

        professorRepository.deleteById(id);
        return doesProfessorExists;
    }

    public Optional<Professor> update(Professor professor, Integer id){
        Optional<Professor> doesProfessorExists = findById(id);

        if (doesProfessorExists == null) {
            return null;
        }

        Professor professorToBeUpdated = new Professor(professor.getId(), professor.getNome(), professor.getEmail(), bCryptPasswordEncoder.encode(professor.getSenha()));
        professorRepository.save(professorToBeUpdated);

        return Optional.of(professorToBeUpdated);
    }
}
