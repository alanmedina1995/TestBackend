package com.mobydigital.alanmedina.testBackend.repository;

import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoExtend;

import java.util.List;

public interface ICandidatoExtend {

    public List<CandidatoExtend> candidatosXtecnologiaList (String tecnologiaAbuscar);
}
