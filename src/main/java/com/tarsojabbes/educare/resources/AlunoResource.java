package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.domains.Aluno;
import com.tarsojabbes.educare.domains.CustomError;
import com.tarsojabbes.educare.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
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
    public ResponseEntity<?> insert(@RequestBody Aluno alunoObj){
        Aluno aluno = alunoService.insert(alunoObj);
        if (aluno == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Aluno com email " + alunoObj.getEmail() + " já existe"));
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Optional<Aluno> aluno = alunoService.delete(id);
        if (aluno == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Aluno de id " + id + " inexistente"));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/{id}")
    public ResponseEntity<?> update(@RequestBody Aluno aluno, @PathVariable Integer id){
        Optional<Aluno> updatedAluno = alunoService.update(aluno, id);

        if (updatedAluno == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Aluno de id " + id + " inexistente"));
        }

        return ResponseEntity.noContent().build();
    }
}
