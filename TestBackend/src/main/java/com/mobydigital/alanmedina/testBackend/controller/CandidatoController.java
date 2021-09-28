package com.mobydigital.alanmedina.testBackend.controller;


import com.mobydigital.alanmedina.testBackend.models.entities.Candidato;
import com.mobydigital.alanmedina.testBackend.models.exceptions.EmptyListException;
import com.mobydigital.alanmedina.testBackend.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping("api/candidatos")
    public List<Candidato> findAll(){
        return candidatoService.findAll();
    }

    @GetMapping("api/candidato/{candidatoId}")
    public Candidato findById(@PathVariable int candidatoId){
        Candidato candidato = candidatoService.findById(candidatoId);
        return candidato;
    }

    @PostMapping("api/candidatos")
    public Candidato addCandidato(@RequestBody Candidato candidato){
        candidatoService.save(candidato);
        return candidato;
    }

    @DeleteMapping("api/candidatos/{candidatoId}")
    public String deleteCandidato(@PathVariable int candidatoId){
        Candidato candidato = candidatoService.findById(candidatoId);
        candidatoService.deleteById(candidatoId);
        return "Fue eliminado el candidato id - " + candidatoId;
    }



}
