package com.tarsojabbes.educare.services;

import com.tarsojabbes.educare.repositories.AlunoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRespository alunoRespository;

}
