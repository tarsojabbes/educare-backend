package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.domains.Questao;
import com.tarsojabbes.educare.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/questoes")
public class QuestaoResource {

    @Autowired
    private QuestaoService questaoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Questao>> findAll(){
        List<Questao> questoes = questaoService.findAll();
        return ResponseEntity.ok().body(questoes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Optional<Questao>> findById(@PathVariable Integer id){
        Optional<Questao> questao = questaoService.findById(id);
        return ResponseEntity.ok().body(questao);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Questao questao){
        questaoService.insert(questao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(questao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        questaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Questao questao, @PathVariable Integer id) {
        questaoService.update(questao, id);
        return ResponseEntity.noContent().build();
    }
}
