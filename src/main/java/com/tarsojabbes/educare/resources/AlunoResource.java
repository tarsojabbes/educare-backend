package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.domains.Aluno;
import com.tarsojabbes.educare.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> alunos = alunoService.findAll();
        return ResponseEntity.ok().body(alunos);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Optional<Aluno>> findById(@PathVariable Integer id){
        Optional<Aluno> aluno = alunoService.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Aluno alunoObj){
        Aluno aluno = alunoService.insert(alunoObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/{id}")
    public ResponseEntity<Void> update(@RequestBody Aluno aluno, @PathVariable Integer id){
        alunoService.update(aluno, id);
        return ResponseEntity.noContent().build();
    }
}
