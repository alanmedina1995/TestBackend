package com.mobydigital.alanmedina.testBackend.repository;

import com.mobydigital.alanmedina.testBackend.models.entities.Candidato;
import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoXTecnologia;
import com.mobydigital.alanmedina.testBackend.models.entities.Tecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
@Transactional
public class CandidatoDAO implements ICandidato{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Candidato> findAll() {
        String query = "FROM Candidato";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Candidato findById(int id) {
        String query = "FROM Candidato c WHERE c.id = id";
        return (Candidato) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void save(Candidato candidato) {
        entityManager.merge(candidato);
    }

    @Override
    public void deleteById(int id) {
        Candidato candidato = entityManager.find(Candidato.class, id);
        entityManager.remove(candidato);
    }
    @Override
    public void agregarCandidatos(Candidato candidato, List<Tecnologia>tecnologias, int anosExperiencia){
        TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
        CandidatoXTecnologia candidatoXTecnologia = new CandidatoXTecnologia();
        CandidatoXTecnologiaDAO candidatoXTecnologiaDAO = new CandidatoXTecnologiaDAO();
        this.save(candidato);
        List<Tecnologia>tecnologiasCandidato = tecnologias;
        if(tecnologiasCandidato != null){
            for(Tecnologia tecnologia: tecnologiasCandidato){
                tecnologiaDAO.save(tecnologia);
                candidatoXTecnologia.setCandidato(candidato);
                candidatoXTecnologia.setTecnologia(tecnologia);
                candidatoXTecnologia.setAnosExperiencia(anosExperiencia);
                candidatoXTecnologiaDAO.save(candidatoXTecnologia);
            }
        }

    }
    @Override
    public void candidatosXtecnologiaList (String tecnologiaAbuscar){
        TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
        CandidatoXTecnologiaDAO candidatoXTecnologiaDAO = new CandidatoXTecnologiaDAO();

        List<Tecnologia>tecnologias = (List<Tecnologia>) tecnologiaDAO.findByNombre(tecnologiaAbuscar);
        if(tecnologias != null){
            for(Tecnologia tecnologia: tecnologias){
                CandidatoXTecnologia candidatoXTecnologia = new CandidatoXTecnologia();
                Candidato candidato = new Candidato();
                candidatoXTecnologia = candidatoXTecnologiaDAO.findByIdTecnologia(tecnologia.getId());
                candidato = this.findById(candidatoXTecnologia.getCandidato().getId());
                System.out.println(tecnologia.toString() + candidatoXTecnologia.toString() + candidato.toString());
            }
        }else{
            System.out.println("No se ha encontrado la tecnologia deseada");
        }

    }

}
