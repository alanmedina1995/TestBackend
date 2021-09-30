package com.mobydigital.alanmedina.testBackend.models.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidatosCtecnologias")


public class CandidatoXTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "idCandidato", referencedColumnName = "id")
    @ManyToOne
    private Candidato candidato;

    @JoinColumn(name = "idTecnologia", referencedColumnName = "id")
    @ManyToOne
    private Tecnologia tecnologia;

    @Column(name = "anosExperiencia")
    private int anosExperiencia;

}
