package com.mobydigital.alanmedina.testBackend.repository;

import com.mobydigital.alanmedina.testBackend.models.entities.Tecnologia;

import java.util.List;

public interface ITecnologia {

    public List<Tecnologia> findAll();

    public Tecnologia findById(int id);

    public void save(Tecnologia tecnologia);

    public void deleteById(int id);

//    public void agregarTecnologia();


}
