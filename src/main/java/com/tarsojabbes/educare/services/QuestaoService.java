package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.Questao;
import com.tarsojabbes.educare.repositories.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    public List<Questao> findAll(){
        List<Questao> questoes = questaoRepository.findAll();
        return questoes;
    }

    public Optional<Questao> findById(Integer id){
        Optional<Questao> questao = questaoRepository.findById(id);
        return questao;
    }

    public void insert(Questao questao) {
        questao.setId(null);
        questaoRepository.save(questao);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            questaoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não foi possível excluir essa questão");
        }
    }

    public void update(Questao questao, Integer id) {
        findById(id);
        questaoRepository.save(questao);
    }

    public Page<Questao> findByConteudo(String conteudo, Integer page, Integer linesPerPage){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        return questaoRepository.findByConteudo(conteudo, pageRequest);
    }

}
