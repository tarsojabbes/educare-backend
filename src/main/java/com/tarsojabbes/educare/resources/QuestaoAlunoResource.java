package com.tarsojabbes.educare.resources;

import com.tarsojabbes.educare.domains.*;
import com.tarsojabbes.educare.services.QuestaoAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
public class QuestaoAlunoResource {

    @Autowired
    private QuestaoAlunoService questaoAlunoService;

    @RequestMapping(method = RequestMethod.GET, value = "/resolvidas/{alunoId}")
    private ResponseEntity<List<QuestaoAluno>> findAllByAlunoId(@PathVariable Integer alunoId) {
        List<QuestaoAluno> questaoAlunos = questaoAlunoService.findAllByAlunoId(alunoId);
        return ResponseEntity.ok().body(questaoAlunos);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/resolvidas/{alunoId}")
    private ResponseEntity<Void> insert(@RequestBody QuestaoAluno questaoAluno) {
        QuestaoAluno questaoAlunoCreated = questaoAlunoService.insert(questaoAluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(questaoAlunoCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/resolvidas/{id}")
    private ResponseEntity<Void> delete(@PathVariable Integer id) {
        questaoAlunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checa-questao")
    private ResponseEntity<Integer> check(@RequestBody ModeloChecagemQuestao modelo){
        Integer value = questaoAlunoService.check(modelo.getQuestaoId(), modelo.getAlternativa(), modelo.getAlunoId());
        return ResponseEntity.ok().body(value);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/estatistica-questao/{id}")
    private ResponseEntity<EstatisticaQuestao> estatisticaByQuestaoId(@PathVariable Integer id){
        EstatisticaQuestao estatisticaQuestao = questaoAlunoService.estatisticaQuestao(id);
        return ResponseEntity.ok().body(estatisticaQuestao);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/estatistica-aluno/{id}")
    private ResponseEntity<?> estatisticaByAlunoId(@PathVariable Integer id){
        EstatisticaAluno estatisticaAluno = questaoAlunoService.estatisticaAluno(id);
        if (estatisticaAluno == null){
            return ResponseEntity.badRequest().body(new CustomError(new Date(System.currentTimeMillis()),
                    "Erro de autenticação ou usuário não encontrado"));
        }

        return ResponseEntity.ok().body(estatisticaAluno);
    }

}
