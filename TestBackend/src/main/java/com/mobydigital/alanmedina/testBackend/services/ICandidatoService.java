package com.mobydigital.alanmedina.testBackend.services;

import com.mobydigital.alanmedina.testBackend.models.entities.Candidato;

import java.util.List;

public interface ICandidatoService {

    public List<Candidato> findAll();

    public Candidato findById(int id);

    public void save(Candidato candidato);

    public void deleteById(int id);


}
