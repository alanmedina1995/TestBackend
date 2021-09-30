package com.mobydigital.alanmedina.testBackend.repository;

import com.mobydigital.alanmedina.testBackend.models.entities.Candidato;
import com.mobydigital.alanmedina.testBackend.models.entities.Tecnologia;
import com.mobydigital.alanmedina.testBackend.models.enums.ETecnologia;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;



@Repository
@Transactional

public class TecnologiaDAO implements ITecnologia {

    @PersistenceContext
    private EntityManager entityManager;

    public TecnologiaDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        entityManager = emf.createEntityManager();
    }


    @Override
    public List<Tecnologia> findAll() {
        String query = " FROM Tecnologia "; //ACA EL "FROM NO ME LO RECONOCE"
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public Tecnologia findById(int id) {
        String query = " FROM Tecnologia t where t.id = id ";
        return (Tecnologia) entityManager.createQuery(query).getSingleResult();

    }

    @Override
    public void save(Tecnologia tecnologia) {
        entityManager.merge(tecnologia);
    }

    @Override
    public void deleteById(int id) {
        Tecnologia tecnologia = entityManager.find(Tecnologia.class, id);
        entityManager.remove(tecnologia);
    }

    public Tecnologia findByNombre(String nombre){
        String aBuscar = nombre.toLowerCase();
        String query = "FROM Tecnologia t WHERE t.nombre LIKE aBuscar ";
        return (Tecnologia) entityManager.createQuery(query).getResultList();
    }

}
