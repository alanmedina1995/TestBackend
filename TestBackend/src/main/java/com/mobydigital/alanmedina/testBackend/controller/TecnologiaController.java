package com.mobydigital.alanmedina.testBackend.controller;


import com.mobydigital.alanmedina.testBackend.models.entities.Tecnologia;
import com.mobydigital.alanmedina.testBackend.services.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TecnologiaController {

    @Autowired
    private TecnologiaService tecnologiaService;

    @GetMapping("api/tecnologias")
    public List<Tecnologia> findAll(){
        return tecnologiaService.findAll();
    }

    @GetMapping("api/tecnologias/{tecnologiaId}")
    public Tecnologia findById(@PathVariable int tecnologiaId){
        Tecnologia tecnologia = tecnologiaService.findById(tecnologiaId);
        return tecnologia;

    }

    @PostMapping("api/tecnologias")
    public Tecnologia addTecnologia(@RequestBody Tecnologia tecnologia){
        tecnologiaService.save(tecnologia);
        return tecnologia;
    }

    @DeleteMapping("api/tecnologias/{tecnologiaId}")
    public String deleteTecnologia(@PathVariable int tecnologiaId){
        Tecnologia tecnologia = tecnologiaService.findById(tecnologiaId);
        tecnologiaService.deleteById(tecnologiaId);
        return "Fue eliminada la tecnologia id - " + tecnologiaId;
    }
}
