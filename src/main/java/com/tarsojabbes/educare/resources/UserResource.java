package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.domains.User;
import com.tarsojabbes.educare.domains.CustomError;
import com.tarsojabbes.educare.services.UsersService;
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
public class UserResource {

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        List<User> users = usersService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Integer id){
        Optional<User> aluno = usersService.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody User userObj){
        User user = usersService.insert(userObj);
        if (user == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Aluno com email " + userObj.getEmail() + " já existe"));
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Optional<User> aluno = usersService.delete(id);
        if (aluno == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Aluno de id " + id + " inexistente"));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id){
        Optional<User> updatedAluno = usersService.update(user, id);

        if (updatedAluno == null) {
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),"Aluno de id " + id + " inexistente"));
        }

        return ResponseEntity.noContent().build();
    }
}
