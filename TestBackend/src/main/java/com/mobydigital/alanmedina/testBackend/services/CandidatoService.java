package com.mobydigital.alanmedina.testBackend.services;

import com.mobydigital.alanmedina.testBackend.models.entities.Candidato;
import com.mobydigital.alanmedina.testBackend.models.entities.Tecnologia;
import com.mobydigital.alanmedina.testBackend.repository.CandidatoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService implements ICandidatoService{

    @Autowired
    private CandidatoDAO candidatoDAO;

    @Override
    public List<Candidato> findAll() {

        List<Candidato> listaCandidatos = candidatoDAO.findAll();
        return listaCandidatos;
    }

    @Override
    public Candidato findById(int id) {
        Candidato candidato = candidatoDAO.findById(id);
        if(candidato == null){
            throw new RuntimeException("No se encuentra enl candidato id - " + id);
        }
        return candidato;
    }

    @Override
    public void save(Candidato candidato) {
        candidatoDAO.save(candidato);
    }

    @Override
    public void deleteById(int id) {
        candidatoDAO.deleteById(id);
    }

    @Override
    public void agregarCandidatos(Candidato candidato, List<Tecnologia> tecnologias, int anosExperiencia) {
        candidatoDAO.agregarCandidatos(candidato, tecnologias, anosExperiencia);
    }

//    @Override
//    public void candidatosXtecnologiaList(String tecnologiaAbuscar) {
//        candidatoDAO.candidatosXtecnologiaList(tecnologiaAbuscar);
//    }
}
