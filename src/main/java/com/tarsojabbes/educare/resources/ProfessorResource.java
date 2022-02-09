package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.domains.CustomError;
import com.tarsojabbes.educare.domains.Professor;
import com.tarsojabbes.educare.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {

    @Autowired
    private ProfessorService professorService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Professor>> findAll(){
        List<Professor> professorList = professorService.findAll();
        return ResponseEntity.ok().body(professorList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Optional<Professor>> findById(@PathVariable Integer id){
        Optional<Professor> professor = professorService.findById(id);
        return ResponseEntity.ok().body(professor);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody Professor professorObj){
        Professor professor = professorService.insert(professorObj);
        if (professor == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Professor com email " + professorObj.getEmail() + " já existe"));
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professorObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Optional<Professor> professor = professorService.delete(id);

        if (professor == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Professor de id " + id + " inexistente"));
        }

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Professor professorObj, @PathVariable Integer id){
        Optional<Professor> professor = professorService.update(professorObj, id);

        if (professor == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Professor de id " + id + " inexistente"));
        }

        return ResponseEntity.noContent().build();
    }
}
