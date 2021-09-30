package com.mobydigital.alanmedina.testBackend.repository;

import com.mobydigital.alanmedina.testBackend.models.entities.Candidato;
import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoExtend;
import com.mobydigital.alanmedina.testBackend.models.entities.CandidatoXTecnologia;
import com.mobydigital.alanmedina.testBackend.models.entities.Tecnologia;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CandidatoExtendDAO implements ICandidatoExtend {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CandidatoExtend> candidatosXtecnologiaList (String tecnologiaAbuscar){
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
        CandidatoXTecnologiaDAO candidatoXTecnologiaDAO = new CandidatoXTecnologiaDAO();

        List<CandidatoExtend> candidatosList = new ArrayList<CandidatoExtend>();

        List<Tecnologia> tecnologias = (List<Tecnologia>) tecnologiaDAO.findByNombre(tecnologiaAbuscar);
       try {
           if (tecnologias != null) {
               for (Tecnologia tecnologia : tecnologias) {
                   CandidatoExtend candidatoExtend = new CandidatoExtend();

                   CandidatoXTecnologia candidatoXTecnologia = new CandidatoXTecnologia();
                   Candidato candidato = new Candidato();
                   candidatoXTecnologia = candidatoXTecnologiaDAO.findByIdTecnologia(tecnologia.getId());
                   candidato = candidatoDAO.findById(candidatoXTecnologia.getCandidato().getId());

                   candidatoExtend.setId(candidato.getId());
                   candidatoExtend.setNombre(candidato.getNombre());
                   candidatoExtend.setApellido(candidato.getApellido());
                   candidatoExtend.setTipoDocumento(candidato.getTipoDocumento());
                   candidatoExtend.setNumeroDocumento(candidato.getNumeroDocumento());
                   candidatoExtend.setFechaNacimiento(candidato.getFechaNacimiento());
                   candidatoExtend.addTecnologias(tecnologia);
                   candidatoExtend.setAnosExperiencia(candidatoXTecnologia.getAnosExperiencia());

                   candidatosList.add(candidatoExtend);

               }
           }
       }catch(Exception ex){
               ex.printStackTrace();
           }

        return candidatosList;
    }
}
