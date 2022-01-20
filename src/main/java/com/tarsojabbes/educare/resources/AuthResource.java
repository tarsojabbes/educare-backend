package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.security.AlunoSS;
import com.tarsojabbes.educare.security.JWTUtil;
import com.tarsojabbes.educare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(method = RequestMethod.POST, value = "/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        AlunoSS aluno = UserService.authenticated();
        String token = jwtUtil.generateToken(aluno.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        // Configuração de CORS p/ expor header Authorization
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }
}
