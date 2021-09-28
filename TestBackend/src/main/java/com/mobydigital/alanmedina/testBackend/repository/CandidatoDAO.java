package com.mobydigital.alanmedina.testBackend.repository;

import com.mobydigital.alanmedina.testBackend.models.entities.Candidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
}
