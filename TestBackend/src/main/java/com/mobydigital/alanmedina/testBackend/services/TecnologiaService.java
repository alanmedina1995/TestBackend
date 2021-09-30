package com.mobydigital.alanmedina.testBackend.services;

import com.mobydigital.alanmedina.testBackend.models.entities.Tecnologia;
import com.mobydigital.alanmedina.testBackend.repository.TecnologiaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologiaService implements ITecnologiaService{

    @Autowired
    private TecnologiaDAO tecnologiaDAO;

    @Override
    public List<Tecnologia> findAll() {
        List<Tecnologia> listaTecnologias = tecnologiaDAO.findAll();
        return listaTecnologias;
    }

    @Override
    public Tecnologia findById(int id) {
        Tecnologia tecnologia = tecnologiaDAO.findById(id);
        if(tecnologia == null){
            throw new RuntimeException("No se encuentra la tecnologia id - " + id);
        }
        return tecnologia;
    }

    @Override
    public void save(Tecnologia tecnologia) {
        tecnologiaDAO.save(tecnologia);
    }

    @Override
    public void deleteById(int id) {
        tecnologiaDAO.deleteById(id);
    }
}
