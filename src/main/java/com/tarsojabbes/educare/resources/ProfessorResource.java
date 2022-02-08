package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {

    @Autowired
    private ProfessorService professorService;
}
