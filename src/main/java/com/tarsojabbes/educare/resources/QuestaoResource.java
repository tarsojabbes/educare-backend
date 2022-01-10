package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/questoes")
public class QuestaoResource {

    @Autowired
    private QuestaoService questaoService;
}
