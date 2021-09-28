package com.mobydigital.alanmedina.testBackend.services;

import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoExtend;
import com.mobydigital.alanmedina.testBackend.models.exceptions.EmptyListException;
import com.mobydigital.alanmedina.testBackend.repository.CandidatoExtendDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CandidatoExtendsService implements ICandidatoExtendsService{
    @Autowired
    private CandidatoExtendDAO candidatoExtendDAO;

    @Override
    public List<CandidatoExtend> candidatosXtecnologiaList(String tecnologiaAbuscar) {
        List<CandidatoExtend> candidatoExtendList = candidatoExtendDAO.candidatosXtecnologiaList(tecnologiaAbuscar);
        if(candidatoExtendList == null || candidatoExtendList.isEmpty()){
            log.error("La lista es nula.");
            throw new EmptyListException("La lista candidatos por tecnologia se encuentra vacia");
        }
        return candidatoExtendList;
    }
}
