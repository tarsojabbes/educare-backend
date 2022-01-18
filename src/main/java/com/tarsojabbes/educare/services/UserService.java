package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.security.AlunoSS;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    public static AlunoSS authenticated() {
        try {
            return (AlunoSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}
