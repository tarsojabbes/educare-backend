package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.domains.Aluno;
import com.tarsojabbes.educare.domains.ModeloChecagemQuestao;
import com.tarsojabbes.educare.domains.Questao;
import com.tarsojabbes.educare.domains.QuestaoAluno;
import com.tarsojabbes.educare.services.QuestaoAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestaoAlunoResource {

    @Autowired
    private QuestaoAlunoService questaoAlunoService;

    @RequestMapping(method = RequestMethod.GET, value = "/resolvidas/{alunoId}")
    private ResponseEntity<List<QuestaoAluno>> findAllByAlunoId(@PathVariable Integer alunoId) {
        List<QuestaoAluno> questaoAlunos = questaoAlunoService.findAllByAlunoId(alunoId);
        return ResponseEntity.ok().body(questaoAlunos);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/resolvidas/{alunoId}")
    private ResponseEntity<Void> insert(@RequestBody QuestaoAluno questaoAluno) {
        QuestaoAluno questaoAlunoCreated = questaoAlunoService.insert(questaoAluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(questaoAlunoCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/resolvidas/{id}")
    private ResponseEntity<Void> delete(@PathVariable Integer id) {
        questaoAlunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/checa-questao")
    private ResponseEntity<Integer> check(@RequestBody ModeloChecagemQuestao modelo){
        Integer value = questaoAlunoService.check(modelo.getQuestao().getId(), modelo.getQuestao().getAlternativa_correta(), modelo.getAlternativa(), modelo.getAlunoId());
        return ResponseEntity.ok().body(value);
    }

}