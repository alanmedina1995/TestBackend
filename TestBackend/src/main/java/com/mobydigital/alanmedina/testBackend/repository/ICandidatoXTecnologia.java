package com.mobydigital.alanmedina.testBackend.repository;

import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoXTecnologia;

import java.util.List;

public interface ICandidatoXTecnologia {

    public List<CandidatoXTecnologia> findAll();

    public CandidatoXTecnologia findById(int id);

    public void save(CandidatoXTecnologia candidatoXTecnologia);

    public void deleteById(int id);


}
