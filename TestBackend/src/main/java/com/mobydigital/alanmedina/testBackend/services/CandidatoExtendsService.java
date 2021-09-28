package com.mobydigital.alanmedina.testBackend.services;

import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoExtend;
import com.mobydigital.alanmedina.testBackend.models.exceptions.EmptyListException;
import com.mobydigital.alanmedina.testBackend.repository.CandidatoExtendDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoExtendsService implements ICandidatoExtendsService{
    @Autowired
    private CandidatoExtendDAO candidatoExtendDAO;

    @Override
    public List<CandidatoExtend> candidatosXtecnologiaList(String tecnologiaAbuscar) {
        List<CandidatoExtend> candidatoExtendList = candidatoExtendDAO.candidatosXtecnologiaList(tecnologiaAbuscar);
        if(candidatoExtendList == null || candidatoExtendList.isEmpty()){
            throw new EmptyListException("La lista candidatos por tecnologia se encuentra vacia");
        }
        return candidatoExtendList;
    }
}
