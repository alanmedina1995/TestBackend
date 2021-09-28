package com.mobydigital.alanmedina.testBackend.controller;

import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoExtend;
import com.mobydigital.alanmedina.testBackend.services.CandidatoExtendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandidatoExtendController {

    @Autowired
    private CandidatoExtendsService candidatoExtendsService;

    @GetMapping("api/candidatos/listarTecnologia/{tecnologiaNombre}")
    public List<CandidatoExtend> candidatosXtecnologiasList(@PathVariable String tecnologiaNombre){
        return candidatoExtendsService.candidatosXtecnologiaList(tecnologiaNombre);
    }
}
