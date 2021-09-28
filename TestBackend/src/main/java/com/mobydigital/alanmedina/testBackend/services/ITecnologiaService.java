package com.mobydigital.alanmedina.testBackend.services;

import com.mobydigital.alanmedina.testBackend.models.entities.Candidato;
import com.mobydigital.alanmedina.testBackend.models.entities.Tecnologia;

import java.util.List;

public interface ITecnologiaService {

    public List<Tecnologia> findAll();

    public Tecnologia findById(int id);

    public void save(Tecnologia tecnologia);

    public void deleteById(int id);
}
