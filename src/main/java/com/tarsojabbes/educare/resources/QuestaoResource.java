package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.domains.CustomError;
import com.tarsojabbes.educare.domains.Questao;
import com.tarsojabbes.educare.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
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

    @RequestMapping(method = RequestMethod.GET, value = "/lista")
    public ResponseEntity<Page<Questao>> findPageByConteudo(
            @RequestParam(value = "conteudo", defaultValue = "") String conteudo,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "questoesPerPage", defaultValue = "1") Integer questoesPerPage
    ){
        Page<Questao> questoes = questaoService.findByConteudo(conteudo, page, questoesPerPage);
        return ResponseEntity.ok().body(questoes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/professor/{id}")
    public ResponseEntity<?> findByIdProfessor(@PathVariable Integer id){
        List<Questao> questoes = questaoService.findByIdCriador(id);

        if (questoes == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Vocẽ não pode acessar os dados do usuário de id "+id));
        }

        return ResponseEntity.ok().body(questoes);

    }


}
