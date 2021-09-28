package com.mobydigital.alanmedina.testBackend.repository;

import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoXTecnologia;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CandidatoXTecnologiaDAO implements ICandidatoXTecnologia{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CandidatoXTecnologia> findAll() {
        String query = "FROM CandidatoXTecnologia";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public CandidatoXTecnologia findById(int id) {
        String query = "FROM CandidatoXTecnologia c WHERE c.id = id";
        return (CandidatoXTecnologia) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void save(CandidatoXTecnologia candidatoXTecnologia) {
        entityManager.merge(candidatoXTecnologia);
    }

    @Override
    public void deleteById(int id) {
        CandidatoXTecnologia candidatoXTecnologia = entityManager.find(CandidatoXTecnologia.class, id);
        entityManager.remove(candidatoXTecnologia);
    }

    public CandidatoXTecnologia findByIdTecnologia(int id){
        String query = "From CandidatoXTecnologia C WHERE C.tecnologia = id";
        return (CandidatoXTecnologia) entityManager.createQuery(query).getSingleResult();
    }
}
