package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.Aluno;
import com.tarsojabbes.educare.repositories.AlunoRepository;
import com.tarsojabbes.educare.security.AlunoSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Aluno> findAll(){
        List<Aluno> alunos =  alunoRepository.findAll();
        return alunos;
    }

    public Optional<Aluno> findById(Integer id){
        AlunoSS aluno = UserService.authenticated();

        if (aluno == null || !id.equals(aluno.getId())) {
            return null;
        }
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj;
    }

    public Aluno insert(Aluno aluno){
        Aluno createdAluno = new Aluno(null, aluno.getNome(), aluno.getEmail(), bCryptPasswordEncoder.encode(aluno.getSenha()), aluno.getCurso());
        return alunoRepository.save(createdAluno);
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
        Aluno toBeUpdatedAluno = new Aluno(aluno.getId(), aluno.getNome(), aluno.getEmail(), bCryptPasswordEncoder.encode(aluno.getSenha()), aluno.getCurso());
        alunoRepository.save(toBeUpdatedAluno);
    }

}
