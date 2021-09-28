package com.mobydigital.alanmedina.testBackend.models.entities;

import lombok.*;

import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidatoExtend extends Candidato{


    private List<Tecnologia> tecnologias;
    @Getter
    @Setter
    private int anosExperiencia;

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void addTecnologias(Tecnologia tecnologia) {
        tecnologias.add(tecnologia);
    }
}
