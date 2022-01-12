package com.tarsojabbes.educare.resources;

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
@RequestMapping(value = "/resolvidas")
public class QuestaoAlunoResource {

    @Autowired
    private QuestaoAlunoService questaoAlunoService;

    @RequestMapping(method = RequestMethod.GET, value = "/{alunoId}")
    private ResponseEntity<List<QuestaoAluno>> findAllByAlunoId(@PathVariable Integer alunoId) {
        List<QuestaoAluno> questaoAlunos = questaoAlunoService.findAllByAlunoId(alunoId);
        return ResponseEntity.ok().body(questaoAlunos);
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity<Void> insert(@RequestBody QuestaoAluno questaoAluno) {
        QuestaoAluno questaoAlunoCreated = questaoAlunoService.insert(questaoAluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(questaoAlunoCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    private ResponseEntity<Void> delete(@PathVariable Integer id) {
        questaoAlunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
