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
        Aluno doesAlunoAlreadyExists = alunoRepository.findByEmail(aluno.getEmail());
        if (doesAlunoAlreadyExists != null) {
            return null;
        }
        Aluno createdAluno = new Aluno(null, aluno.getNome(), aluno.getEmail(), bCryptPasswordEncoder.encode(aluno.getSenha()), aluno.getCurso());
        return alunoRepository.save(createdAluno);
    }

    public Optional<Aluno> delete(Integer id){
        Optional<Aluno> doesAlunoAlreadyExists = findById(id);

        if (doesAlunoAlreadyExists == null) {
            return null;
        }

        alunoRepository.deleteById(id);
        return doesAlunoAlreadyExists;

    }

    public Optional<Aluno> update(Aluno aluno, Integer id) {
        Optional<Aluno> doesAlunoAlreadyExists = findById(aluno.getId());
        if (doesAlunoAlreadyExists == null) {
            return null;
        }

        Aluno toBeUpdatedAluno = new Aluno(aluno.getId(), aluno.getNome(), aluno.getEmail(), bCryptPasswordEncoder.encode(aluno.getSenha()), aluno.getCurso());
        alunoRepository.save(toBeUpdatedAluno);

        return Optional.of(toBeUpdatedAluno);
    }

}
