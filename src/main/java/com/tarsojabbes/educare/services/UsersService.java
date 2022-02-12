package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.domains.User;
import com.tarsojabbes.educare.repositories.UserRepository;
import com.tarsojabbes.educare.security.AlunoSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll(){
        List<User> users =  userRepository.findAll();
        return users;
    }

    public Optional<User> findById(Integer id){
        AlunoSS aluno = UserService.authenticated();

        if (aluno == null || !id.equals(aluno.getId())) {
            return null;
        }
        Optional<User> obj = userRepository.findById(id);
        return obj;
    }

    public User insert(User user){
        User doesUserAlreadyExists = userRepository.findByEmail(user.getEmail());
        if (doesUserAlreadyExists != null) {
            return null;
        }
        User createdUser = new User(null, user.getNome(), user.getEmail(), bCryptPasswordEncoder.encode(user.getSenha()), user.getTipo());
        return userRepository.save(createdUser);
    }

    public Optional<User> delete(Integer id){
        Optional<User> doesAlunoAlreadyExists = findById(id);

        if (doesAlunoAlreadyExists == null) {
            return null;
        }

        userRepository.deleteById(id);
        return doesAlunoAlreadyExists;

    }

    public Optional<User> update(User user, Integer id) {
        Optional<User> doesAlunoAlreadyExists = findById(user.getId());
        if (doesAlunoAlreadyExists == null) {
            return null;
        }

        User toBeUpdatedUser = new User(user.getId(), user.getNome(), user.getEmail(), bCryptPasswordEncoder.encode(user.getSenha()), user.getTipo());
        userRepository.save(toBeUpdatedUser);

        return Optional.of(toBeUpdatedUser);
    }

}
