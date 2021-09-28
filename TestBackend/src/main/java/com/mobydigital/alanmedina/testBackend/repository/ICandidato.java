package com.mobydigital.alanmedina.testBackend.repository;

import com.mobydigital.alanmedina.testBackend.models.entities.Candidato;
import com.mobydigital.alanmedina.testBackend.models.entities.Tecnologia;

import java.util.List;

public interface ICandidato {
    //COPIAR LO MISMO EN SERVICE

    public List<Candidato> findAll();

    public Candidato findById(int id);

    public void save(Candidato candidato);

    public void deleteById(int id);

    public void agregarCandidatos(Candidato candidato, List<Tecnologia>tecnologias, int anosExperiencia);

    //public void candidatosXtecnologiaList (String tecnologiaAbuscar);b

}
