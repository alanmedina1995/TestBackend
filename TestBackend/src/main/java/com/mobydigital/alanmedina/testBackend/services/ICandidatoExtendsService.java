package com.mobydigital.alanmedina.testBackend.services;

import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoExtend;

import java.util.List;

public interface ICandidatoExtendsService {
    public List<CandidatoExtend> candidatosXtecnologiaList (String tecnologiaAbuscar);
}
