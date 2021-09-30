package com.mobydigital.alanmedina.testBackend.models.entities;

import lombok.*;

import java.util.Date;
import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidatoExtend extends Candidato{


    private List<Tecnologia> tecnologias;
    @Getter
    @Setter
    private int anosExperiencia;


    @Builder
    public CandidatoExtend(int id, String nombre, String apellido, String tipoDocumento, int numeroDocumento, Date fechaNacimiento , List<Tecnologia>tecnologias, int anosExperiencia){
        super(id,nombre,apellido,tipoDocumento,numeroDocumento,fechaNacimiento);
        this.tecnologias = tecnologias;
        this.anosExperiencia = anosExperiencia;
    }


    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void addTecnologias(Tecnologia tecnologia) {
        tecnologias.add(tecnologia);
    }
}
