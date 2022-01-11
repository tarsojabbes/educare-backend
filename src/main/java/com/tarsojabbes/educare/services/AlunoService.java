package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.Aluno;
import com.tarsojabbes.educare.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll(){
        List<Aluno> alunos =  alunoRepository.findAll();
        return alunos;
    }

    public Optional<Aluno> findById(Integer id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno;
    }

    public Aluno insert(Aluno aluno){
        aluno.setId(null);
        return alunoRepository.save(aluno);
    }

    public void delete(Integer id){
        findById(id);
        try {
            alunoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro ao excluir aluno");
        }
    }

    public void update(Aluno aluno, Integer id) {
        findById(aluno.getId());
        alunoRepository.save(aluno);
    }

}
